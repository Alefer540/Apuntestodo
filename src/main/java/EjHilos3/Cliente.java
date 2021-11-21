package EjHilos3;

import java.util.ArrayList;
import java.util.Random;

public class Cliente extends Thread {

    ArrayList<Item> listaItem = new ArrayList<>();

    int numeroDeHilo;

    public Cliente(int numeroDeHilo){
        this.numeroDeHilo = numeroDeHilo;
    }

    @Override
    public void run() {
        int pExito = 9;
        int deboSeguir;
        do {
            comprarItem();
            pExito--;
            deboSeguir = new Random().nextInt(10);
            //System.out.println("pExito = " + pExito + " deboSeguir = "+ deboSeguir);
        } while (deboSeguir <= pExito);
        Vendedor.cobrar(this);
        //System.out.println(getListaCompraEnString());
    }

    private void comprarItem(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        listaItem.add(new Item());
    }

    private String getListaCompraEnString(){
        String s = "He comprado ";
        for (Item item : listaItem) {
            s += item.toString();
        }
        return s;
    }
}