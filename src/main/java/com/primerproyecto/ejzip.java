package com.primerproyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejzip {
    public static void main(String[] args) {
        comprimir();
        descomprimir();
    }

    public static void comprimir() {

        try {


            ProcessBuilder builder2 = new ProcessBuilder(
                    "C:\\Program Files\\7-Zip\\7z.exe", "a", "C:\\Users\\AlumnoM\\Desktop\\todo.7z", "C:\\Users\\AlumnoM\\Desktop\\COMPRIM");


            builder2.redirectErrorStream(true);
            Process p = builder2.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {
                System.out.println(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void descomprimir() {

        try {


            ProcessBuilder builder2 = new ProcessBuilder(
                    "C:\\Program Files\\7-Zip\\7z.exe", "e", "C:\\Users\\AlumnoM\\Desktop\\todo.7z", "-oC:\\Users\\AlumnoM\\Desktop\\DESCOMPRIM");


            builder2.redirectErrorStream(true);
            Process p = builder2.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {
                System.out.println(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}




