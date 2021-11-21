package com.primerproyecto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.HashMap;



public class ejhilos1 {
    public static void main(String[] args) {
        HashMap <Integer, Long> mapa1 = new HashMap<Integer, Long>();

        for (int i=0;i<=5;i++){
          hiloss h = new hiloss(i);
          h.start();
          try{
              h.join();
          }catch(InterruptedException e){
              e.printStackTrace();
          }
         mapa1.put(h.id,h.resul);
      }
        System.out.println(mapa1);
        mapa1.forEach((k,v)->System.out.println(k+"="+v));
        List<Entry<Integer, Long>> listap = new ArrayList<>(mapa1.entrySet());
        listap.sort(Entry.comparingByValue());
        listap.forEach(System.out::println);
        System.out.println(listap);


    }

}
