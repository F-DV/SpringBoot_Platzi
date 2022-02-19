package com.fundamentosPlatzi.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {

        int num = 3;
        System.out.println(myOperation.sum(num));               ///imprimimos la suma del numero utilizando la interface de Myoperation
        System.out.println("Hola yo tengo la dependencia");
    }
}
