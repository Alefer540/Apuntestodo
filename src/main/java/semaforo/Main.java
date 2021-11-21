package semaforo;

public class Main {

    // Imagina que tenemos una piscina con 4 personas de aforo.
    // Nuestros bañistas son hilos
    // Un bañista se queda un rato en la piscina (Tiempo aleatorio)
    // Cuando uno se va, entra otro


    public static void main(String[] args) {
        for (int i = 0; i<10; i++){
            Banista b = new Banista(String.valueOf(i));
            b.start();
        }
    }
}