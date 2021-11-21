package EjHilos3;

import java.util.ArrayList;

public class Main {
    //Vamos a simular hacer la compra en un supermercado.
    //
    //El vendedor estará representado por una clase cajero con una función estática  "cobrar(Cliente cliente)". Un cajero solo puede cobrar a un Cliente a la vez. Por tanto, habrá un Cajero y 100 clientes.
    //
    //Los items tendrán nombres aleatorios ejemplo: "Item928645" y tendrán un precio aleatorio de entre 1 y 100€.
    //
    //Los clientes será hilos.  Vamos a simular que los clientes tardan 1 segundo en coger cada item que quiere comprar. El primer item tiene un 100% de posibilidades de ser cogido. Una vez que ha cogido el primer item, la probabilidad de coger otro objeto se reduce en 0,1 y así sucesivamente. En caso de no coger objeto significa que se va. Por tanto tendrá que ir al cajero para pagar.
    //
    //El vendedor SOLO PUEDE ATENDER A UN CLIENTE A LA VEZ, por lo que si está cobrando a alguien, al resto les tocará esperar.
    //
    //El programa termina cuando TODOS los cliente se han ido del supermecado.
    //
    //Justo antes de terminar, el vendedor debe decir cuando dinero ha recaudado.
    //
    //La entrega se realiza en un solo fichero .java con todas las clases correspondientes.
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Cliente c = new Cliente(i);
            listaClientes.add(c);
            c.start();
        }

        for (Cliente c : listaClientes){
            c.join();
        }

        Vendedor.decirRecaudacionTotal();

    }

}