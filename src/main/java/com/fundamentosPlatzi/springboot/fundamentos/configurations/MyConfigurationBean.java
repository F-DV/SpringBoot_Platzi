package com.fundamentosPlatzi.springboot.fundamentos.configurations;

import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBeanTwoImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration                              //spring determina que es una clase para configuraciones adicionales para los beans
public class MyConfigurationBean {

    @Bean                                   //configuramos nuestro bean
    public MyBean beanOperation(){
        return new MyBeanTwoImplement();       //Nombre de la clase que se va a utilizar
    }

}
