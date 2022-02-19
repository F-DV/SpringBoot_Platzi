package com.fundamentosPlatzi.springboot.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping                     //Acepta todas las solicitudes a nivel http
    @ResponseBody                       //Responde a un cuerpo a nivel servicio
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("Hello from controller un cambio" , HttpStatus.OK);       //Imprimimos en pantalla con el servidor embebido tomcat
    }
}
