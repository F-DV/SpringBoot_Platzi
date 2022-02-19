package com.fundamentosPlatzi.springboot.fundamentos.configurations;

import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosPlatzi.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentosPlatzi.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @EnableConfigurationProperties(UserPojo.class) : Esta annotacion me indica que la clase UserPojo es la que va a representar como
 * propiedades en nuestra aplicacion
 * @PropertiesSource("claspath:connection.properties") : Para utilizar nuestras propiedades, que definimos previeamente en connection utilizandoi
 * la annotacion @Value
 */
@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {

    @Value("${value.name}")                             //llamamos variable que creamos en applications.properties
    private String name;                                //almacenamos el valor que llamamos anteriormente

    @Value("${value.apellido}")                             //llamamos variable que creamos en applications.properties
    private String apellido;                                //almacenamos el valor que llamamos anteriormente

    @Value("${value.random}")                             //llamamos variable que creamos en applications.properties
    private String random;                                //almacenamos el valor que llamamos anteriormente

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name, apellido);
    }

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

}
