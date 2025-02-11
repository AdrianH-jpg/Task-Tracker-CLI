package cli;

import java.util.Scanner;

public class TaskCLI {
    private final TaskManager taskManager;
    private final Scanner scanner;

    public TaskCLI() {
        //Inicializa nuestro gestor de tareas y nuestro scanner
        this.taskManager = new TaskManager();
        this.scanner = new Scanner(System.in);
    }

    // Metodo que inicia el CLI y gestiona la interaccion con el usuario
    public void start(){

        while (true){
            System.out.print("task-cli ");
            String command = scanner.nextLine().trim();
            String[] commandArgs = command.split(" ", 2); // separa el comando y el argumento
            String action = commandArgs[0].toLowerCase();

            switch (action){
                case "add":
                    handleAddTask(commandArgs);
                    break;
                case "list":
                    handleListTasks(commandArgs);
                    break;
                case "update":
                    handleUpdateTask(commandArgs);
                    break;
                case "delete":
                    handleDeleteTask(commandArgs);
                    break;
                case "mark-done":
                    handleMarkTask(commandArgs, true);
                    break;
                case "mark-in-progress":
                    handleMarkTask(commandArgs, false);
                    break;
                case "help":
                    handleHelp();
                    break;
                case "exit":
                    taskManager.saveTaskToFile();
                    System.out.println("task-cli exited");
                    return;
                default:
                    System.out.println("Unknown command: " + command);
            }
        }

    }

    private void handleHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("  add <description>          - Add a new task");
        System.out.println("  list [status]              - List tasks (optional: todo, in-progress, done)");
        System.out.println("  update <id> <description>  - Update the description of a task");
        System.out.println("  delete <id>                - Delete a task by ID");
        System.out.println("  mark-done <id>             - Mark the task as Done by the ID");
        System.out.println("  mark-in-progress <id>      - Mark the task as In Progress by ID");
        System.out.println("  exit                       - Save tasks and exit the program");
        System.out.println("  help                       - Show this help message");
    }


    private void handleAddTask(String[] commandArgs){
        if(commandArgs.length > 1){
            taskManager.addTask(commandArgs[1]);
        }else {
            System.out.println("Please enter a task description");
        }
    }

    private void handleListTasks(String[] commandArgs){
        if(commandArgs.length > 1){
            taskManager.listTask(commandArgs[1]);
        }else {
            taskManager.listTask(null);
        }
    }

    private void handleUpdateTask(String[] commandArgs){
        if(commandArgs.length > 1){
            String[] updateArgs = commandArgs[1].split(" ", 2);
            if(updateArgs.length > 1){
                try {
                    int id = Integer.parseInt(updateArgs[0]);
                    taskManager.updateTask(id, updateArgs[1]);
                }catch (NumberFormatException e){
                    System.out.println("Please enter a valid task id");
                }
            }else{
                System.out.println("Please enter a task description");
            }
        }else {
            System.out.println("Please enter a task id and description");
        }
    }

    private void handleDeleteTask(String[] commandArgs){
        if(commandArgs.length > 1){
            try {
                int id = Integer.parseInt(commandArgs[1]);
                taskManager.deleteTask(id);
            }catch (NumberFormatException e){
                System.out.println("Please enter a valid task id");
            }
        }else{
            System.out.println("Please enter a task id");
        }
    }

    private void handleMarkTask(String[] commandArgs, boolean mark){
        if(commandArgs.length > 1){
            try {
                int id = Integer.parseInt(commandArgs[1]);
                if(mark){
                    taskManager.markTaskAsDone(id);
                }else{
                    taskManager.markTaskAsInProgress(id);
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter a valid task id");
            }
        }else{
            System.out.println("Please enter a task id");
        }
    }

}
