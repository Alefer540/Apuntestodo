package com.primerproyecto;
import java.util.Random;
import java.util.Calendar;

public class hilos2 extends Thread{
    public int id=0;
    public hilos2(int id){
        this.id=id;
    }
    public int resul=0;
    @Override
    public void run (){

        int numeroAleatorio = 1;
        int cont=1;

        while (numeroAleatorio==1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            numeroAleatorio = (int) (Math.random()*2+1);
            cont++;
        }


        System.out.println("Soy el hilo "+id+" y me he dormido "+cont+" veces");
        resul=cont;
    }



}
