package CarreraRelevos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

//Vamos a simular una carrera de relevos en las olimpiadas.
//36 corredores representando a los 9 países que compiten en la
//olimpiada. Cada hilo deber ser identificado con el nombre del país y
//un número que le diferencie de sus compañeros.
//Empieza a correr un corredor por país. Simulamos la carrera con
//sleep de entre 1 y 5 segundos. Cuando ha pasado ese tiempo, el
//corredor encuentra un obstáculo. La probabilidad de que el corredor
//supere el obstáculo es 90%.
//• Si el corredor supera el obstáculo, da paso al siguiente
//corredor de su grupo, el cual repite el mismo proceso hasta que
//todos los corredores de su país terminen.
//• Gana el país cuyos participantes terminan primero.
//• Si el corredor no supera el obstáculo, la ambulancia debe
//entrar en acción (otro hilo).
//• La ambulancia solo puede atender a un hilo a la vez, si la
//ambulancia estuviera ocupada, ese país no continúa en la
//carrera.
//• La ambulancia tarda 5 segundos en curar al corredor herido.
//Cuando el corredor esté curado, notifica al siguiente corredor
//que prosiga la carrera. Si es el último corredor de su país,
//termina su carrera, pudiendo quedar campeón

public class Main {
    static AtomicInteger eInteger = new AtomicInteger(0);
    static AtomicInteger iInteger = new AtomicInteger(0);
    static AtomicInteger fInteger = new AtomicInteger(0);
    static AtomicBoolean ambulancia = new AtomicBoolean(true);
    public static void main(String[] args) {
        Semaphore sespana = new Semaphore(1,true);
        Semaphore sitalia = new Semaphore(1,true);
        Semaphore sfrancia = new Semaphore(1,true);

        ArrayList<Corredor> preparados = new ArrayList<Corredor>();
        preparados.add(new Corredor("espana "+(int)(Math.random()*100+1),sespana));
        preparados.add(new Corredor("espana "+(int)(Math.random()*100+1),sespana));
        preparados.add(new Corredor("espana "+(int)(Math.random()*100+1),sespana));
        preparados.add(new Corredor("espana "+(int)(Math.random()*100+1),sespana));
        preparados.add(new Corredor("italia "+(int)(Math.random()*100+1),sitalia));
        preparados.add(new Corredor("italia "+(int)(Math.random()*100+1),sitalia));
        preparados.add(new Corredor("italia "+(int)(Math.random()*100+1),sitalia));
        preparados.add(new Corredor("italia "+(int)(Math.random()*100+1),sitalia));
        preparados.add(new Corredor("francia "+(int)(Math.random()*100+1),sfrancia));
        preparados.add(new Corredor("francia "+(int)(Math.random()*100+1),sfrancia));
        preparados.add(new Corredor("francia "+(int)(Math.random()*100+1),sfrancia));
        preparados.add(new Corredor("francia "+(int)(Math.random()*100+1),sfrancia));



        for (int i=0;i<preparados.size();i++){
            preparados.get(i).start();
        }


    }

}
class Corredor extends Thread {

    String nombre=" ";
    Semaphore s;


    Corredor(String nombre,Semaphore s){
        this.nombre=nombre;
        this.s=s;
    }

    @Override
    public void run() {

        try {
            int numeroAleatoriox = (int) (Math.random()*10 + 1);
            s.acquire(1);
            System.out.println("Comienza la carrera "+this.nombre);
            Thread.sleep(((new Random().nextInt(5) ) + 1) * 1000);
            if (numeroAleatoriox==1 || numeroAleatoriox==2 || numeroAleatoriox==3 || numeroAleatoriox==4 || numeroAleatoriox==5){
                System.out.println("Se ha caido "+this.nombre+" y va a intentar entrar en la ambulancia");
                if (Main.ambulancia.get()){
                    Main.ambulancia.set(false);
                    System.out.println(this.nombre+" esta en la ambulancia");
                    Thread.sleep(5000);
                    System.out.println(this.nombre+" sale de la ambulancia");
                    Main.ambulancia.set(true);
                }else{
                    System.out.println("Esta llena la ambulancia y "+this.nombre+" pierde con su equipo");
                    s.acquire(4);
                }
            }
            System.out.println("Acaba la carrera "+this.nombre);

            s.release(1);

            if (this.nombre.contains("espana")){
                Main.eInteger=new AtomicInteger(Main.eInteger.get()+1);
            }else if (this.nombre.contains("francia")){
                Main.fInteger=new AtomicInteger(Main.fInteger.get()+1);
            }else if (this.nombre.contains("italia")){
                Main.iInteger=new AtomicInteger(Main.iInteger.get()+1);
            }

            if (Main.eInteger.get()==4){
                System.out.println("Ha ganado españa !");
                System.exit(0);
            } else if (Main.fInteger.get()==4){
                System.out.println("Ha ganado francia !");
                System.exit(0);
            }else if (Main.iInteger.get()==4){
                System.out.println("Ha ganado italia !");
                System.exit(0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
