import java.util.ArrayList;


public class Main {

    public static ArrayList<Hilo> listaHilosOrdenada = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<Hilo> listaHilos = new ArrayList<>();
        int contador=0;

        Cajero cajero1=new Cajero();


        for (int i = 0; i <= 3; i++) {
            Hilo h = new Hilo(i);
            h.start();
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            contador+=cajero1.vendedor(h);


        }

        System.out.println("El total recaudado es: "+contador);





    }

    public static class Cajero{
        Cajero(){}
        public  synchronized int vendedor(Hilo hil) {
            int contador=0;
            contador+=hil.veces;

            return contador;
        }
    }




}