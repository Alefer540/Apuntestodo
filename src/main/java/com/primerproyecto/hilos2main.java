package com.primerproyecto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.HashMap;



public class hilos2main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> mapa1 = new HashMap<Integer, Integer>();
        for (int i = 0; i <= 10; i++) {
            hilos2 h = new hilos2(i);
            h.start();
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mapa1.put(h.id, h.resul);
        }
        System.out.println(mapa1);

        for (Object j : mapa1.keySet()) {

            if ((int) mapa1.get(j) == finalista(mapa1)) {
                System.out.println("Hilo finalista : " + j + " que se ha repetido: " + mapa1.get(j) + " veces");
            }

        }
        System.out.println(finalista(mapa1)+" "+subcampeon(mapa1));

        for (Object k : mapa1.keySet()) {

            if ((int) mapa1.get(k) == subcampeon(mapa1)) {
                System.out.println("Hilo subcampeón : " + k + " que se ha repetido: " + mapa1.get(k) + " veces");
            }

        }


    }

    public static int finalista(HashMap hm) {
        int conter = 0;

        for (Object j : hm.keySet()) {

            if ((int) hm.get(j) >= conter) {
                conter = (int) hm.get(j);
            }

        }
        return conter;

    }

    public static int subcampeon(HashMap hm) {

        int resultadox=0;
        int copia=finalista(hm)-1;

        for (int i=0;i<= finalista(hm)-1;i++){
            for (Object j : hm.keySet()) {
                if ((int)hm.get(j) < finalista(hm) && resultadox<(int)hm.get(j)) {
                    resultadox=(int)hm.get(j);
                }
            }

            copia=copia-1;

        }
        return resultadox;
    }
}
