package com.primerproyecto;

public class hilo extends Thread{
    public String nombre="";
    public hilo(String nombre){
        this.nombre=nombre;
    }
    @Override
    public void run (){
        System.out.println("Soy el hilo"+nombre);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nombre+" se ha despertado");
    }

}
