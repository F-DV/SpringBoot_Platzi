package com.fundamentosPlatzi.springboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOGGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {

        LOGGGER.info("hemos ingresado al metodo printWithDependenci");
        int num = 3;
        LOGGGER.debug("El numero enviado como parametro a la dependencia es =" + num);
        System.out.println(myOperation.sum(num));               ///imprimimos la suma del numero utilizando la interface de Myoperation
        System.out.println("Hola yo tengo la dependencia");
    }
}
