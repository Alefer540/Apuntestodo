package semaforo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Piscina {

    private static final int NUM_ACCESO_SIMULTANEOS = 4;
    static Semaphore semaphore = new Semaphore(NUM_ACCESO_SIMULTANEOS,true);

    static void solicitadAcceso(Banista banista){
        System.out.println("El " + banista.nombre + "quiere entrar");
        try {
            semaphore.acquire(2);
            banarse(banista);
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void banarse(Banista banista){
        System.out.println("Comienza el baño el banista " + banista.nombre);
        try {
            Thread.sleep(((new Random().nextInt(4) ) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        banista.sucio = false;
        System.out.println("Finaliza el baño el banista " + banista.nombre);

    }
}
