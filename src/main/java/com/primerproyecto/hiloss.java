package com.primerproyecto;
import java.util.Random;
import java.util.Calendar;

public class hiloss extends Thread{
    public int id=0;
    public hiloss(int id){
        this.id=id;
    }
    public long resul=0;
    int numeroAleatorio = (int) (Math.random()*3000+0);
    @Override
    public void run (){
        Calendar cal = Calendar.getInstance();
        try {
            Thread.sleep(numeroAleatorio);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Calendar cal2 = Calendar.getInstance();
        long resultado =0;
        resultado=cal2.getTimeInMillis()-cal.getTimeInMillis();
        System.out.println("Soy el hilo "+id+" y he tardado "+resultado);
        resul=resultado;
    }


}
