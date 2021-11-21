package Atomicos;

public class Persona {

    String nombre;
    String apellido;

    Persona(String nombre, String apellido) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

}
