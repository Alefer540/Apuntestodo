package semaforos2;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i <15; i++) {
            Hilo l = new Hilo();
            l.start();
        }
    }

    public static void atenderAlHilo(Hilo hilo){
        try {
            System.out.println("He llegado!! " + hilo.id);

            lock.lock();
            if (lock.tryLock()){
                //Si puede pasar pasa y si no pasa NO se queda esperando y NO pasa
            }

            System.out.println("Estoy tratando al hilo " + hilo.id);
            Thread.sleep(1000);
            System.out.println("He termiando de tratar al hilo " + hilo.id);

            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
