package BattleRoyale;



import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

//El semaforo.tryAcquire() te cuenta como un acquire normal por lo cual hay que jugar con las variablea atomicas





//Vamos a simular un torneo de Battle Royale, estilo Warzone.
//En resumen, entran 10 jugadores (hilos) de los que solo puede
//quedar uno.
//Sin embargo, inicialmente, se crean 15 jugadores (hilos) de los
//cuales solo los 10 primeros más rápidos entran a la batalla de
//inmediato. Los demás tendrán que esperar a que haya hueco.
//Nada más entrar cada hilo duerme por entre 1 y 5 segundos.
//El primero hilo que acabe consiguen un bonus.
//Los 5 últimos mueren, dando paso a los hilos que estaban esperando.
//Cuando todos los hilos hayan acabado, cada uno de los hilos saca un
//número aleatorio que será la puntuación y se lo entrega a alguna
//clase que se encargue de calcular al ganador.
//La puntuación que hubieran sacado los hilos que tenían bonus vale
//doble. Gana el hilo que más puntos haya conseguido.

public class Main {
    static AtomicBoolean bonus = new AtomicBoolean(false);
    static AtomicBoolean pase = new AtomicBoolean(false);
    static AtomicInteger cantidad = new AtomicInteger(0);
    static ArrayList<Jugador> preparados = new ArrayList<Jugador>();
    public static void main(String[] args) {
        Semaphore carga = new Semaphore(10,true);
        Semaphore s2 = new Semaphore(5,true);

        for (int i=1;i<=15;i++){
            Jugador j = new Jugador(i,carga,s2);
            preparados.add(j);
        }
        for (int i=0;i<=14;i++){
            preparados.get(i).start();
        }

    }
}




class Jugador extends Thread {

   int id;
   boolean bonus=false;
   Semaphore s;
   Semaphore j;
   int puntuacion = new Random().nextInt(100);
   boolean pase=false;




    Jugador(int id, Semaphore s, Semaphore j){
        this.id=id;
        this.s=s;
        this.j=j;
    }

    @Override
    public void run() {
        System.out.println(this.id+" esta intentando entrar a la partida");
        try {
            s.acquire();
            pase=Main.pase.get();
            System.out.println(this.id+" ha entrado en la partida");
            Thread.sleep(((new Random().nextInt(5) ) + 1) * 1000);
            if (pase==false) {
                j.acquire();
                if (!Main.bonus.get()) {
                    Main.bonus.set(true);
                    bonus = true;
                    System.out.println(this.id + " consigue el bonus");
                }
            }
            System.out.println(this.id+" entra en fase 2");
            Main.cantidad.set(Main.cantidad.get()+1);
            if (Main.cantidad.get()==5){
                s.release(5);
                Main.pase.set(true);
            }
            if (bonus){
                puntuacion=puntuacion*2;
            }
            System.out.println(this.id + " tiene estos puntos "+this.puntuacion);
            Ganador.vencedor(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Ganador{
    static int puntos=0;
    static int cont=0;
    public synchronized static void vencedor(Jugador jugador){
        if(puntos<=jugador.puntuacion){
            puntos=jugador.puntuacion;
        }
        cont++;
        if (cont==10){
            for (int i=0;i<=14;i++){
                if (Main.preparados.get(i).puntuacion==puntos){
                    System.out.println("El que mas puntos tiene es el jugador "+Main.preparados.get(i).id);
                    System.exit(0);
                }
            }

        }
    }
}

