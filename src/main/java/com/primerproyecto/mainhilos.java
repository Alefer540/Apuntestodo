package com.primerproyecto;
import java.util.Calendar;

public class mainhilos {
    public static void main(String[] args) {

        System.out.println("hola");


        hilo h1 = new hilo("uno");
        hilo h2 = new hilo("dos");

        h1.start();
        h2.start();
        try{
            h1.join();
            h2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Calendar tiempo = Calendar.getInstance();
        System.out.println("Terminamos a las"+tiempo.getTimeInMillis());

        System.out.println("adioz");
    }


}
