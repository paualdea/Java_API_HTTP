package ut4.act2;

// IMPORTS
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class API {
    // Tiempo espera en ms
    private final int TIEMPO_ESPERA = 3500;

    // Direcciones URL para el GET y el POST
    private final String GET_URL = "https://api.open-meteo.com/v1/forecast?latitude=41.38879&longitude=2.15899&current=temperature_2m,wind_speed_10m";
    private final String POST_URL = "https://jsonplaceholder.typicode.com/posts";

    // Creamos un cliente HTTP para hacer las solicitudes
    private HttpClient cliente;

    /**
     * Constructor de la clase API.
     * Inicializa el cliente HTTP al crear un objeto de esta clase.
     */
    public API () {
        // Inicializamos el cliente HTTP que usaremos para interactuar con las APIs
        cliente = HttpClient.newHttpClient();
    }

    /**
     * Función para ejecutar el GET sobre la API de OpenMeteo.
     */
    public void ejecutarGet() {
        // Usamos una estructura try-catch para controlar errores
        try {
            System.out.println("\t\t\n.:PETICIÓN GET A Open-Meteo:.");

            // Realizamos la petición HTTP con un objeto HttpRequest
            HttpRequest peticion = HttpRequest.newBuilder().uri(URI.create(GET_URL)).GET().build();
            // Almacenamos la respuesta de la peticion que mandamos usando el cliente HTTP
            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

            // Una vez ejecutada la petición, enviamos la respuesta a la función mostrarResultado()
            mostrarResultado(respuesta);
        } catch (Exception e) {
            System.err.println("Error - " + e.getMessage());
        }
    }

    /**
     * Función para ejecutar el POST sobre la API de JSONPlaceHolder
     */
    public void ejecutarPost() {
        // Implementamos estructura try-catch para controlar errores de la petición o conexión
        try {
            System.out.println("\t\t\n.:PETICIÓN POST A JSONPlaceHolder:.");

            // Estructuramos los datos que vamos a mandar al POST en formato JSON
            String infoJson = "{\"ciudad\": \"Barcelona\", \"unidad\": \"Celsius\", \"info\": \"Prueba Actividad 2\"}";

            // Realizamos la petición HTTP con un objeto HttpRequest, adjuntando la información que queremos enviar
            HttpRequest peticion = HttpRequest.newBuilder().uri(URI.create(POST_URL)).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(infoJson)).build();
            // Almacenamos la respuesta de la petición para poder mostrarla por pantalla
            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

            // Una vez ejecutada la petición, enviamos la respuesta a la función mostrarResultado()
            mostrarResultado(respuesta);
        } catch (Exception e) {
            System.err.println("Error - " + e.getMessage());
        }


    }

    /**
     * Función que imprime los resultados de las peticiones por pantalla.

     * @param respuesta
     * Recibe cómo parámetro un HttpResponse cómo respuesta de la petición HTTP a la API.
     */
    private void mostrarResultado(HttpResponse<String> respuesta) {
        // Imprimimos el código de estado de la respuesta
        System.out.println("\tCÓDIGO DE ESTADO: " + respuesta.statusCode());

        // Imprimimos las cabeceras. Por cada clave-valor lo imprimimos por pantalla
        System.out.println("\t\n.:HEADERS:.");
        respuesta.headers().map().forEach((clave, contenido) -> System.out.println("  " + clave + ": " + contenido));

        // Imprimimos el contenido JSON que recibimos de la API
        System.out.println("\t\n.:CONTENIDO::");
        System.out.println(respuesta.body());
        System.out.println();

        // Añadimos un tiempo de espera para poder ver el resultado bien
        espera(0);
    }

    /**
     * Esta función ejecuta un bloque de código que para la ejecución de espera TIEMPO_ESPERA segundos
     */
    public void espera(int tiempo) {
        if (tiempo > 0) {
            try {
                Thread.sleep(tiempo);

            } catch (InterruptedException e) {
                System.err.println("No se ha podido hacer la pausa de " + tiempo);
            }
        } else {
            try {
                Thread.sleep(TIEMPO_ESPERA);

            } catch (InterruptedException e) {
                System.err.println("No se ha podido hacer la pausa de " + TIEMPO_ESPERA);
            }
        }
    }
}