package hilitos;


public class Hilo extends Thread {


    public final int numero;

    public int veces;


    public Hilo(int numero){
        this.numero = numero;
    }

    @Override
    public void run() {
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

        veces=cont;
        Main.listaHilosOrdenada.add(this);
        System.out.println("Soy el hilo nº " + numero + " y he dormido " + cont + " veces");
    }


}