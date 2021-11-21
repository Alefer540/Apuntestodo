package EjHilos1;

import java.util.ArrayList;

public class Main {
    //Parte 1:
    //
    //Crea un ejercicio en el que se crean 100 hilos. Cada hilo dormirá por un tiempo aleatorio de entre 0 y 3000 milisegundos (long).
    //
    //Cada hilo deberá escribir por pantalla "Soy el hilo nº X y he dormido por Y milisegundos" Siendo Y la diferencia entre el momento en el que empieza a ejecutarse y el momento en el que acaba de ejecutarse.
    //
    //Parte 2:
    //
    //Busca la manera de crear una función que escriba un listado de los hilos ordenados por orden de finalización. Ejemplo:
    //
    //"El hilo X ha finalizado en el milisegundo 26514500"
    //
    //"El hilo Y ha tardado en el milisegundo 26514550"
    //
    //"El hilo Z ha tardado en el milisegundo 26514590"
    //
    //etc.


    static ArrayList<Hilo> listaHilosOrdenada = new ArrayList<>();


    public static void main(String[] args) {

        ArrayList<Hilo> listaHilos = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            Hilo h = new Hilo(i);
            h.start();
            listaHilos.add(h);
        }

        for (Hilo h : listaHilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mostraListado();
    }

    private static void mostraListado() {
        for (Hilo hilo : listaHilosOrdenada){
            System.out.println("El hilo " + hilo.numero + " ha finalizado en el milisegundo " + hilo.tiempoFinalizacion);
        }
    }

}