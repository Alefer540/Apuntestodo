package mercado;


import java.util.ArrayList;


public class Main {

    static ArrayList<Hilo> listaHilosOrdenada = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<Hilo> listaHilos = new ArrayList<>();
        int contador=0;

        Cajero cajero1=new Cajero();

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



        System.out.println(cajero1.vendedor(listaHilos));



    }

    public static class Cajero{


        public  synchronized String vendedor(ArrayList<Hilo> a) {
            int contador=0;
            for (Hilo j : a) {
                contador+=j.veces;
            }
            return "El total recaudado es: "+ contador;
        }

    }




}

class Hilo extends Thread {


    public final int numero;

    public int veces;


    public Hilo(int numero){
        this.numero = numero;
    }

    @Override
    public void run() {
        boolean alerta=false;
        int items=0;
        int aumento=0;
        while (!alerta){
            item obj = new item ("item"+(Math.random()*10000+1));
            veces+=obj.precio();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int numeroAleatoriox = (int) (Math.random()*10 + 1);
            if (numeroAleatoriox<=aumento){
                alerta=true;
            }
            aumento++;
            items++;
        }
        Main.listaHilosOrdenada.add(this);

        System.out.println("Soy el comprador " + numero + " y me he gastado " + veces+ " euros y he cogido estos items "+items);

    }


}
//la captura donde aparece el truco de esperar
class item{
    public item(String nombre){
        this.nombre=nombre;
    }
    String nombre ="item"+(Math.random()*10000000+1);
    public  int precio(){
        return (int)(Math.random()*100 + 1);
    }
}
