package com.fundamentosPlatzi.springboot.fundamentos.configurations;

import com.fundamentosPlatzi.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration                              //spring determina que es una clase para configuraciones adicionales para los beans
public class MyConfigurationBean {

    @Bean                                   //configuramos nuestro bean
    public MyBean beanOperation(){
        return new MyBeanTwoImplement();                                                        //Nombre de la clase que se va a utilizar
    }

    @Bean                                                                                       //configuramos nuestro bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();                                                      //Nombre de la clase que se va a utilizar
    }

    @Bean                                                                                       //configuramos nuestro bean
    public MyBeanWithDependency beanOperationImplementwithDependency(MyOperation myOperation){

        return new MyBeanWithDependencyImplement(myOperation);                                  //Nombre de la clase que se va a utilizar
    }

}
