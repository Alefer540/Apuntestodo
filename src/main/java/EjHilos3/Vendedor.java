package EjHilos3;

public class Vendedor {

    private static int recadacionTotal = 0;

    public synchronized static void cobrar(Cliente cliente) {
        System.out.println("El cajero está atendiendo al cliente " + cliente.numeroDeHilo);
        int precioTotalItems = 0;
        for (Item item : cliente.listaItem) {
            precioTotalItems += item.precio;
        }
        System.out.println("Voy a cobrarle al cliente " + cliente.numeroDeHilo + " " + precioTotalItems + "€.");
        recadacionTotal+= precioTotalItems;
    }

    public static void decirRecaudacionTotal() {
        System.out.println("La recaudación total ha sido de " + recadacionTotal);
    }
}