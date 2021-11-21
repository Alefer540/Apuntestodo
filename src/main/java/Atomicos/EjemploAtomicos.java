package Atomicos;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class EjemploAtomicos {

    AtomicBoolean aBoolean = new AtomicBoolean(true);
    AtomicInteger aInteger = new AtomicInteger(1);
    AtomicLong aLong = new AtomicLong(1);
    AtomicReference<String> bString = new AtomicReference<>("Hola");
    AtomicReference<Persona> bPersona = new AtomicReference<>(new Persona("A", "B"));

    boolean nBoolean = true;
    int nInt = 1;
    long nLong = 1;
    String nString = "Hola";
    Persona nPersona = new Persona("A", "B");


    EjemploAtomicos(){
        probarBoolean();
        probarInt();
        probarLong();
        probarString();
        probarPersona();
    }

    private void probarBoolean() {
        // Mal
        if (nBoolean) {
            nBoolean = false;
        }
        // Bien
        aBoolean.compareAndExchange(true, false);
        System.out.println(aBoolean.get());
    }

    private void probarInt() {
        // Mal
        if (nInt == 1) {
            nInt = 6;
        }
        // Bien
        aInteger.compareAndExchange(1, 6);
        System.out.println(aInteger.get());
    }

    private void probarLong() {
        // Mal
        if (nLong == 1) {
            nLong = 9;
        }
        // Bien
        aLong.compareAndExchange(1, 9);
        System.out.println(aLong.get());
    }

    private void probarString() {
        // Mal
        if (nString.contentEquals("Hola")) {
            nString = "Adios";
        }
        // Bien
        bString.compareAndExchange("Hola", "Adios");
        System.out.println(bString.get());
    }

    private void probarPersona() {
        // Mal
        if (nPersona.nombre.contentEquals("A") && nPersona.apellido.contentEquals("B")) {
            nPersona = new Persona("C", "D");
        }
        // Bien
        bPersona.compareAndExchange(new Persona("A","B"), new Persona("C","D"));
        System.out.println(bPersona.get());

    }
}