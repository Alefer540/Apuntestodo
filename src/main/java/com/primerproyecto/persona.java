package com.primerproyecto;

public class persona {
    String nombre="";
    String apellido1="";
    String apellido2="";
    int edad=0;
    boolean com=false;

    public persona(String nombre,String apellido1,String apellido2, int edad){
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.edad=edad;
        com=false;
    }

    public persona(String nombre,String apellido1, int edad){
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.edad=edad;
        com=true;
    }



    public boolean getcom(){
        return com;
    }

}
