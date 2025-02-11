# Task Tracker CLI

Task Tracker es un proyecto diseñado para rastrear y gestionar tus tareas a través de una interfaz de línea de comandos (CLI).

## Descripción

Este proyecto te permite construir una CLI simple para gestionar tus tareas diarias. Puedes agregar, actualizar, eliminar y cambiar el estado de tus tareas. También puedes listar tareas según su estado. Este proyecto es ideal para practicar habilidades de programación, manipulación de archivos y gestión de entradas de usuario.

## Requisitos

- La aplicación debe ejecutarse desde la línea de comandos.
- Debe aceptar acciones e inputs del usuario como argumentos.
- Almacenar las tareas en un archivo JSON.

### Funcionalidades del Usuario

- **Agregar una tarea:** `task-cli add "Descripción de la tarea"`
- **Actualizar una tarea:** `task-cli update <id> "Nueva descripción"`
- **Eliminar una tarea:** `task-cli delete <id>`
- **Marcar tarea como "en progreso":** `task-cli mark-in-progress <id>`
- **Marcar tarea como "completada":** `task-cli mark-done <id>`
- **Listar todas las tareas:** `task-cli list`
- **Listar tareas por estado:**
    - Completadas: `task-cli list done`
    - Pendientes: `task-cli list todo`
    - En progreso: `task-cli list in-progress`

## Restricciones

- Puedes usar cualquier lenguaje de programación.
- Usa argumentos posicionales para las entradas del usuario en la línea de comandos.
- Almacena las tareas en un archivo JSON en el directorio actual.
- El archivo JSON debe crearse automáticamente si no existe.
- Utiliza solo módulos nativos del lenguaje para manipular el archivo JSON.
- No uses librerías o frameworks externos.
- Maneja errores y casos extremos adecuadamente.

## Estructura de una Tarea

Cada tarea debe incluir:

- **id**: Identificador único.
- **description**: Descripción de la tarea.
- **status**: Estado de la tarea (todo, in-progress, done).
- **createdAt**: Fecha y hora de creación.
- **updatedAt**: Última fecha y hora de actualización.

## Primeros Pasos

### Configuración del Entorno de Desarrollo

1. **Elige tu lenguaje:** Selecciona un lenguaje con el que te sientas cómodo.
2. **Instala un editor de código:** VSCode, PyCharm, etc.

### Inicialización del Proyecto

1. **Crea un nuevo directorio:** `mkdir TaskTrackerCLI`
2. **Inicializa Git:** `git init`

### Implementación de Funcionalidades

- Comienza con la estructura básica del CLI.
- Implementa funcionalidades de forma incremental:
    - Agregar tareas
    - Listar tareas
    - Actualizar y cambiar estado de tareas

### Pruebas y Depuración

- Prueba cada funcionalidad individualmente.
- Verifica la integridad del archivo JSON.
- Depura cualquier problema encontrado.

### Finalización

- Asegúrate de que todas las funcionalidades estén implementadas y probadas.
- Limpia el código y añade comentarios explicativos.
- Completa este README para que otros usuarios puedan entender y usar tu CLI.

## Uso

Para usar Task Tracker, ejecuta los comandos desde tu terminal en el directorio del proyecto.

---

