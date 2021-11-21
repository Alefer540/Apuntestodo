package hilitos;


import java.util.ArrayList;

import java.util.ArrayList;

public class Main {

    static ArrayList<Hilo> listaHilosOrdenada = new ArrayList<>();
    static int conter = 0;

    public static void main(String[] args) {

        ArrayList<Hilo> listaHilos = new ArrayList<>();

        for (int i = 0; i <= 100; i++){
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

        System.out.println(escribirFinalistas());
        System.out.println(escribirSubCampeones());

    }

    public static String escribirFinalistas(){

        for (Hilo j : listaHilosOrdenada) {

            if (j.veces >= conter) {
                conter = j.veces;
            }

        }
        String respuesta="Hilos finalistas:\n";
        for (Hilo j : listaHilosOrdenada) {

            if (j.veces == conter) {
                respuesta += "El hilo " + j.numero + " se ha ejecutado " + j.veces + " veces\n";
            }

        }
        return respuesta;

    }
    public static String escribirSubCampeones(){
        int resultadox=0;
        int copia=conter-1;

        for (int i=0;i<= conter-1;i++){
            for (Hilo j : listaHilosOrdenada) {
                if (j.veces < conter && resultadox<j.veces) {
                    resultadox=j.veces;
                }
            }

            copia=copia-1;

        }
        String respuesta="Hilos subcampeones:\n";
        for (Hilo k : listaHilosOrdenada) {

            if (k.veces == resultadox) {
                respuesta +="El hilo " + k.numero + " se ha ejecutado " + k.veces + " veces\n";
            }

        }
        return respuesta;
    }

}