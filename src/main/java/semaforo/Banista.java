package semaforo;

public class Banista extends Thread {

    boolean sucio = true;
    String nombre;
    public Banista(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run() {
        Piscina.solicitadAcceso(this);
        System.out.println("El "+ nombre + "ya se ha bañado ");
    }
}