# Parcial 2 Daniel Sousa

## Descripción del Proyecto
Este proyecto es una aplicación Android desarrollada utilizando Kotlin y Java. Incluye funcionalidades para la gestión de eventos y la visualización de detalles de farmacias. El proyecto utiliza Firebase para el almacenamiento y recuperación de datos.

## Tabla de Contenidos
1. [Configuración e Instalación](#configuración-e-instalación)
2. [Características](#características)
3. [Registro de Desarrollo](#registro-de-desarrollo)
4. [Problemas Conocidos](#problemas-conocidos)
5. [Mejoras Futuras](#mejoras-futuras)

## Configuración e Instalación
1. Clona el repositorio:
    ```sh
    git clone https://github.com/tu-repo/proyecto.git
    ```
2. Abre el proyecto en Android Studio.
3. Sincroniza el proyecto con los archivos de Gradle.
4. Configura Firebase:
    - Añade tu archivo `google-services.json` al directorio `app`.
    - Asegúrate de que Firebase Realtime Database esté configurado.

## Características
- **Gestión de Eventos**: Añadir, listar y ver detalles de eventos.
- **Detalles de Farmacias**: Mostrar información de farmacias desde un archivo JSON.
- **Soporte de Idiomas**: Cambiar entre inglés y español.

## Registro de Desarrollo

### Paso 1: Inicialización del Proyecto
- Configuración de la estructura del proyecto en Android Studio.
- Configuración de Firebase para el proyecto.

### Paso 2: Gestión de Eventos
- Creación de `AddEventActivity` para añadir nuevos eventos.
- Implementación de `MainActivityejdos` para listar eventos.
- Actualización de `activity_add_event.xml` para los campos de entrada de eventos.

### Paso 3: Integración con Firebase
- Implementación de `getEventsFromFirebase` para recuperar eventos desde Firebase.
- Asegurarse de que los eventos se listan correctamente en `MainActivityejdos`.

### Paso 4: Detalles de Farmacias
- Creación de `MainActivityejtres` para leer detalles de farmacias desde un archivo JSON.
- Implementación de `DetailActivity` para mostrar información detallada de las farmacias.

### Paso 5: Mejoras en la Interfaz de Usuario
- Actualización de los diseños para una mejor experiencia de usuario.
- Añadido funcionalidad de cambio de idioma en `MainActivityejdos`.

## Problemas Conocidos
- Error de tipo de ID de evento resuelto asegurando que la clase `Event` acepte `String?` para `id`.
- Asegurarse de que todos los campos sean no nulos en la clase `Event` para evitar errores en tiempo de ejecución.

## Mejoras Futuras
- Implementar autenticación de usuarios para la gestión de eventos.
- Añadir integración con mapas para mostrar ubicaciones de eventos y farmacias.
- Mejorar el manejo de errores y los mecanismos de retroalimentación al usuario.
