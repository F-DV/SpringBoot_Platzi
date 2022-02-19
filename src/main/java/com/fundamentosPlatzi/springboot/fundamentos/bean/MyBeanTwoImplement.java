package com.fundamentosPlatzi.springboot.fundamentos.bean;

public class MyBeanTwoImplement implements MyBean{         //Implmentamos de la interface Bean

    @Override
    public void print() {                               //implementamos metodo y damos funcionalidad

        System.out.println("Hola desde mi implementacion propia del Bean 2");
    }
}
