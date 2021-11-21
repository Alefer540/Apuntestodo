package com.primerproyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dir {

    public static void main(String[] args) {




        System.out.println(proce());






    }

    public static String proce (){
        Boolean flag=false;
        String respuesta="";
        String respuesta2="";


        if (flag=true){

            try {


                ProcessBuilder builder2 = new ProcessBuilder(
                        "cmd.exe", "/c", "cd \"C:\\\" && dir");
                ProcessBuilder builder3= new ProcessBuilder(
                        "cmd.exe", "/c", "cd \"C:\\\" && dir ");


                builder2.redirectErrorStream(true);
                Process p = builder2.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = r.readLine()) != null ) {
                    if (line.contains("<DIR>")) {
                        respuesta=line.substring(36);
                        builder3= new ProcessBuilder(
                                "cmd.exe", "/c", "cd \"C:\\\" && dir \"" +respuesta+"\"");
                        Process p1 = builder3.start();
                        BufferedReader d = new BufferedReader(new InputStreamReader(p1.getInputStream()));
                        String line2="";
                        while ((line2 = d.readLine()) != null ) {
                            respuesta2+="\n"+line2;

                        }


                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }



        }

        return  respuesta2;
    }
}

