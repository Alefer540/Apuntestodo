package Luchadores;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cuadrilatero {
    private static final int NUM_ACCESO_SIMULTANEOS = 2;
    static Semaphore semaphore = new Semaphore(NUM_ACCESO_SIMULTANEOS,true);
    private static Luchador luch1 =null;
    private static Luchador luch2 =null;
    public static void AddParticipante(Luchador luchador){

        try {
            semaphore.acquire();
            if(luch1==null){
                luch1=luchador;
            } else{
                luch2=luchador;
            }
            if(luch1 != null && luch2 != null)
                Luchar(luch1,luch2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    private static void Luchar(Luchador luchador1,Luchador luchador2){
        System.out.println("Comienza la batalla entre:  " +luchador1.getName()+ " y " +luchador2.getName()) ;
        try {
            Thread.sleep( 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random r=new Random();

        if(r.nextBoolean()){
            luch1=null;
            System.out.println("El "+luchador1.getName()+" ha perdido");
        }else {
            luch2 = null;
            System.out.println("El " + luchador2.getName() + " ha perdido");
        }

        semaphore.release();
    }

}
