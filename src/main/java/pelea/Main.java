package pelea;
import java.util.Random;
import java.util.concurrent.Semaphore;
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            Luchador t = new Luchador();
            t.setName(i);
            t.start();
        }
    }
}
class Luchador extends Thread {
    int id=0;
    public void setName(int id){
        this.id = id;
    }

    @Override
    public void run() {
        Cuadrilatero.addParticipante(this);
    }
}
class Cuadrilatero {
    static  Luchador vencedor = new Luchador();
    private static final int NUM_ACCESO_SIMULTANEOS = 1;
    static Semaphore semaphore = new Semaphore(NUM_ACCESO_SIMULTANEOS,true);
    static  int flag=0;
    public static  void addParticipante(Luchador Luchador){
        if (flag==0){
            vencedor=Luchador;
            flag=1;
        }
        System.out.println("Esperando luchador "+Luchador.id);
        try {
            semaphore.acquire();
            if (Luchador != vencedor){
                pelea(vencedor,Luchador);
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized static  void pelea(Luchador Luchador1,Luchador Luchador2){
        Random r2 = new Random();
        boolean rr2 = r2.nextBoolean();

        System.out.println("Pelea entre luchador "+Luchador1.id+" y luchador "+Luchador2.id);
        if (rr2){
            System.out.println("Ha ganado el luchador "+Luchador1.id);
        }else{
            System.out.println("Ha ganado el luchador "+Luchador2.id);
            vencedor=Luchador2;
        }
        try {
            Thread.sleep(((new Random().nextInt(4) ) + 2) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
