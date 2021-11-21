package Locks;

import java.util.Random;

public class Hilo extends Thread {

    Random r = new Random();
    int id = r.nextInt();

    @Override
    public void run() {
        Main.atenderAlHilo(this);
    }
}