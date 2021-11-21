package EjHilos3;

import java.util.Random;

public class Item {

    public String nombre;
    public int precio;

    Item(){
        Random r = new Random();
        nombre = "Item"+r.nextInt();
        precio = r.nextInt(100) + 1;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}