package com.fundamentosPlatzi.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties{

    private String nombre;                                                          //variables
    private String apellido;

    public MyBeanWithPropertiesImplement(String nombre, String apellido) {          //constructor
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre + "-" + apellido;
    }
}
