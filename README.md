# Programación en Java: Cliente HTTP y Consumo de APIs Externas

Este proyecto ha sido desarrollado como parte de la **Actividad 2** de la Unidad de Trabajo 4 (UT4): "Generación de servicios en red".

El programa implementa un **cliente HTTP** que realiza peticiones a APIs para obtener (`GET`) y enviar (`POST`) información en tiempo real de forma estructurada.

## Características Principales

* **Uso de las librerías `java.net.http`**: Implementación de las clases `HttpClient`, `HttpRequest` y `HttpResponse` para poder realizar las peticiones HTTP.
* **Consumo de APIs**: Conexión con el servicio **Open-Meteo** para obtener datos meteorológicos en tiempo real de Barcelona mediante el método `GET`.
* **Interacción con API REST**: Simulación de envío de información estructurada (`JSON`) usando el método `POST` hacia la API de **JSONPlaceholder**, usando la información que hemos recibido en el método `GET`.
* **Uso de JSON**: Manejo de este formato para estructurar datos, de forma que usamos protocolos actuales e universales.
* **Análisis de resultado**: El programa muestra de forma detallada un informe completo de la respuesta obtenido por parte del servidor, que incluye códigos de estado (200, 201, 404, etc.), encabezados (*headers*) y la información recibida por parte de la API.

## Funcionamiento

El programa sigue el siguiente flujo de trabajo:

1. **Petición `GET`**: El cliente HTTP solicita a la API de Open-Meteo la temperatura para la ciudad de Barcelona.
2. **Procesamiento**: El servidor responde y el programa extrae la información recibida en formato JSON.
3. **Petición `POST`**: Se realiza una solicitud sobre la API de **JSONPlaceholder** enviando la información en formato JSON en el cuerpo del mensaje.
4. **Verificación**: El servidor procesa el envío y nos devuelve un código e informaciónm, confirmando que los datos han sido recibidos y el recurso ha sido "creado" de forma ficticia.

## Instrucciones de Uso

Para ejecutar este programa, se puede usar el fichero `.jar` o compilar el *código fuente* que se pueden descargar desde las [releases](https://git.paualdea.com/paualdea/Java-API-HTTP/-/releases) del proyecto.

---
Este proyecto sirve como evidencia del aprendizaje sobre el desarrollo de aplicaciones distribuidas, el funcionamiento de los protocolos de la capa de aplicación y el consumo de servicios web para la asignatura de **Programación de Servicios y Procesos**.