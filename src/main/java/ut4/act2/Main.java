package ut4.act2;

public class Main {
    public static void main(String[] args) {
        // Variable para almacenar temperatura recibida de la API
        double temperatura;

        // Creamos un objeto de tipo API
        API api = new API();

        // Primero ejecutamos el GET a la API
        api.ejecutarGet();

        // Luego ejecutamos un POST a otra API
        api.ejecutarPost();
    }
}