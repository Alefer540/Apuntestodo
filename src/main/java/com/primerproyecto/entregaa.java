package com.primerproyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entregaa {
    public static void main(String[] args) {
        System.out.println(getIp4());
        System.out.println(getSubred());
        System.out.println(getPuertaEnlace());
        System.out.println(hacerPing("www.zalando.es"));

    }

    public static String getIp4 (){
        Boolean flag=false;
        String respuesta="";



        if (flag=true){

            try {


                ProcessBuilder builder2= new ProcessBuilder(
                        "cmd.exe", "/c", "cd \"C:\\\" && ipconfig " );


                builder2.redirectErrorStream(true);
                Process p = builder2.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = r.readLine()) != null ) {
                    if(line.contains("v4")) {
                        respuesta=line;

                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        return  respuesta;
    }
    public static String getSubred (){
        Boolean flag=false;
        String respuesta="";

        if (flag=true){

            try {


                ProcessBuilder builder2= new ProcessBuilder(
                        "cmd.exe", "/c", "cd \"C:\\\" && ipconfig " );


                builder2.redirectErrorStream(true);
                Process p = builder2.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = r.readLine()) != null ) {
                    if(line.contains("subred")) {
                        respuesta=line;

                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        return  respuesta;
    }

    public static String getPuertaEnlace (){
        Boolean flag=false;
        String respuesta="";

        boolean encontrado=false;


        if (flag=true){

            try {


                ProcessBuilder builder2= new ProcessBuilder(
                        "cmd.exe", "/c", "cd \"C:\\\" && ipconfig " );


                builder2.redirectErrorStream(true);
                Process p = builder2.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = r.readLine()) != null && encontrado==false) {
                    if(line.contains("enlace")) {
                        respuesta=line;
                        encontrado = true;
                        encontrado=true;
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        return  respuesta;
    }
    public static String hacerPing (String ip){
        Boolean flag=false;
        String respuesta="";



        if (flag=true){

            try {


                ProcessBuilder builder2= new ProcessBuilder(
                        "cmd.exe", "/c", "cd \"C:\\\" && ping "+ip);


                builder2.redirectErrorStream(true);
                Process p = builder2.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = r.readLine()) != null) {
                    if (line.contains("Haciendo") || line.contains("desde"))
                        respuesta+="\n"+line;


                }

            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        return  respuesta;
    }

}
