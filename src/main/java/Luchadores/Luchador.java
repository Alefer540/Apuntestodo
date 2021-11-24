package Luchadores;
public class Luchador extends Thread {


    @Override
    public void run() {
        Cuadrilatero.AddParticipante(this);
    }
}