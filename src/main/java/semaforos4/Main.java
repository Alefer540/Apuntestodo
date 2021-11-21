package semaforos4;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {

    static final int NUMERO_JUGADORES = 5;
    static Integer jugadoresEnCola = 0;

    public static void main(String[] args) {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        Semaphore s = new Semaphore(0);
        Integer jugadoresEnCola = 0;

        for (int i = 0; i < 5; i++){
            listaJugadores.add(new Jugador("nombre = " + i + " ", s, jugadoresEnCola));
        }
        for (int i = 0; i < listaJugadores.size(); i++){
            listaJugadores.get(i).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



class Jugador extends Thread {

    private String nombre;
    private Semaphore s;
    private Integer jugadoresEnCola;

    Jugador(String nombre, Semaphore s, Integer jugadoresEnCola) {
        this.nombre = nombre;
        this.s = s;
        this.jugadoresEnCola = jugadoresEnCola;
    }


    @Override
    public void run() {
        System.out.println("El jugador " + nombre + "está en cola para empezar");
        Main.jugadoresEnCola++;
        try {
            if (Main.jugadoresEnCola == Main.NUMERO_JUGADORES)
                s.release(Main.NUMERO_JUGADORES);
            s.acquire();
            System.out.println("El jugador " + nombre + "ha entrado en la partida");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}