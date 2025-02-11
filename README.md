# Task Tracker CLI

# Task Tracker CLI  

Task Tracker CLI es una aplicación de línea de comandos para gestionar tareas. Permite agregar, listar, actualizar y eliminar tareas, además de cambiar su estado.  

## 🚀 Cómo ejecutar el proyecto  

1. Clona el repositorio:  
   ```sh
   git clone https://github.com/AdrianH-jpg/Task-Tracker-CLI.git
   cd task-tracker-cli

2. Compila el proyecto:
    ```sh
    javac -d out src/main/java/cli/*.java src/main/java/model/*.java src/main/java/Main.java
    
3. Ejecuta la aplicación:
     ```sh
    java -cp out Main

📌 Comandos disponibles
add <descripcion> → Agregar una tarea
list [status] → Listar tareas (todo, in-progress, done)
update <id> <nueva descripcion> → Actualizar tarea
delete <id> → Eliminar tarea
mark-done <id> → Marcar como completada
mark-in-progress <id> → Marcar como en progreso
help → Ver la ayuda
exit → Guardar y salir

