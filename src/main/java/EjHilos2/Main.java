package EjHilos2;

import java.util.ArrayList;

import java.util.ArrayList;

public class Main {
    //Parte 1:
    //
    //Crea un ejercicio en el que se crean 100 hilos. Cada hilo dormirá por un 1 segundo. Después, aleatoriamente (50%), o terminará o volverá a dormir por otro segundo. Si duerme, se repetirá el proceso de jugar aleatoriamente. Si se vuelve a dormir, termina. Este proceso se repite indefinidamente.
    //
    //Cada hilo deberá escribir por pantalla "Soy el hilo nº X y he dormido Y veces" Siendo Y el número de veces que ha dormido.
    //
    //Parte 2:
    //
    //Busca la manera de crear dos funciones. La primera que escriba el listado de los hilos finalistas (los que más veces han dormido) y otra de los hilos subcampeones (los que han dormido una vez menos que los campeones).
    //
    //Ejemplo de output:
    //
    //public static String escribirFinalistas()
    //
    //"Hilos finalistas:
    //
    //El hilo X se ha ejecutado 5 veces
    //
    //El hilo Y se ha ejecutado 5 veces
    //
    //El hilo Z se ha ejecutado 5 veces"
    //
    //public static String escribirSubCampeones()
    //
    //"Hilos subcampeones:
    //
    //El hilo X se ha ejecutado 5 veces
    //
    //El hilo Y se ha ejecutado 5 veces
    //
    //El hilo Z se ha ejecutado 5 veces"


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