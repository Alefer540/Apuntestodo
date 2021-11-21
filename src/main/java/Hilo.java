import java.util.Random;

public class Hilo extends Thread {


    public final int numero;

    public int veces;


    public Hilo(int numero){
        this.numero = numero;
    }

    @Override
    public void run() {
        boolean alerta=false;
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
            if (numeroAleatoriox<aumento){
                alerta=true;
            }
            aumento++;
        }
        System.out.println("Soy el comprador " + numero + " y me he gastado " + veces+ " euros ");

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
