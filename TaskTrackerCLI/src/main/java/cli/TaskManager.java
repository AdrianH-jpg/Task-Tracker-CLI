package cli;

import model.Task;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks = new ArrayList<Task>();
    private static final String FILE_NAME = "tasks.json";

    public TaskManager() {
        loadTaskFromFile();
    }


    // Metodo para agregar nuevas tareas
    public void addTask( String description) {
        int newId = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getIdTask() + 1;
        Task newTask = new Task(newId, description);
        tasks.add(newTask);
        saveTaskToFile();
        System.out.println("Task added successfully (ID: " + newTask.getIdTask() + ")");
    }

    public void saveTaskToFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            writer.write("[");
            for(int i=0; i < tasks.size(); i++){
                Task task = tasks.get(i);
                writer.write(String.format(
                        "{\"idTask\":%d,\"description\":\"%s\",\"status\":\"%s\",\"createAt\":\"%s\",\"updateAt\":\"%s\"}",
                        task.getIdTask(), task.getDescription(), task.getStatus(),task.getCreateAt(), task.getUpdateAt()

                ));
                if(i <tasks.size()-1){
                    writer.write(",");
                }
            }
            writer.write("]");
        }
        catch(IOException e){
            System.out.println("Error saving tasks to file, " + e.getMessage());
        }
    }

    public void loadTaskFromFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String json = reader.lines().collect(Collectors.joining());
            if(!json.isEmpty() && !json.equals("[]")){
                json = json.substring(1,json.length()-1); // Quitar los corchetes
                String[] taskArray = json.split("},\\{"); // Separar nuestros objetos en el JSON
                for(String task : taskArray){
                    task = task.replace("{","").replace("}","");
                    String[] taskSplit = task.split(",");
                    Map<String,String> taskMap = new HashMap<>();
                    for (String taskSplits : taskSplit) {
                        int firstColonIndex = taskSplits.indexOf(":"); // Solo divide en el primer ':'
                        if(firstColonIndex != -1) {
                            String key = taskSplits.substring(0,firstColonIndex).replace("\"","").trim();
                            String value = taskSplits.substring(firstColonIndex+1).replace("\"","").trim();
                            taskMap.put(key,value);
                        }
                    }

                    Task objTask  = new Task(
                            Integer.parseInt(taskMap.get("idTask")),
                            taskMap.get("description")
                    );
                    objTask.setStatus(taskMap.get("status"));
                    objTask.setCreateAt(LocalDateTime.parse(taskMap.get("createAt")));
                    objTask.setUpdateAt(LocalDateTime.parse(taskMap.get("updateAt")));
                    tasks.add(objTask);

                }
            }

        }catch (IOException e){
            System.out.println("Error loading tasks from file, " + e.getMessage());
        }

    }

    // Metodo para listar las tareas guardadas
    public void listTask(String statusFilter){
        if(tasks.isEmpty()){
            System.out.println("No tasks found");
            return;
        }

        List<Task> filteredTasks = tasks;

        if(statusFilter != null && !statusFilter.isEmpty()){
            filteredTasks = tasks.stream().filter(task -> task.getStatus().equals(statusFilter)).collect(Collectors.toList());
        }

        if(filteredTasks.isEmpty()){
            System.out.println("No tasks found " + statusFilter );
        }else {
            filteredTasks.forEach(System.out::println);
        }

    }

    // Metodo para actualizar tareas
    public void updateTask(int id, String description) {
        if(tasks.isEmpty()){
            System.out.println("No tasks for update");
        }else {
            for(Task task : tasks){
                if(task.getIdTask() == id){
                    task.setDescription(description);
                    System.out.println("Task updated successfully with ID: " + task.getIdTask());
                    break;
                }
            }
        }
    }

    // Metodo para eliminar tareas
    public void deleteTask(int id) {
        if(tasks.isEmpty()){
            System.out.println("No tasks for delete");
        }else {
            // Iterator crea un objeto iterator que recorre la lista task y su Metodo hasNext valida si hay un siguiente articulo en la lista
            Iterator<Task> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                // iterator.next obtiene el siguiente valor en la lista de tareas y lo guarda en la variable task
                Task task = iterator.next();
                if (task.getIdTask() == id) {
                    iterator.remove();
                    System.out.println("Task deleted successfully");
                    break;
                }
            }
        }
    }

    public void markTaskAsDone(int id){
        if(tasks.isEmpty()){
            System.out.println("No tasks found");
        }else{
            for(Task task : tasks){
                if(task.getIdTask() == id){
                    task.setStatus("done");
                    System.out.println("Task marked successfully as done");
                    break;
                }
            }
        }
    }

    public void markTaskAsInProgress(int id){
        if(tasks.isEmpty()){
            System.out.println("No tasks found");
        }else{
            for(Task task : tasks){
                if(task.getIdTask() == id){
                    task.setStatus("in-progress");
                    System.out.println("Task marked successfully as in-progress");
                    break;
                }
            }
        }
    }

}
