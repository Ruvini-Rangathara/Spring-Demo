package com.example.spring1.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("order")
public class Order {

    //if have any json value, trigger this -> {"name" : "Ruvini"}
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveOrderJson(){
        return "save Order Json";
    }

    //if have any XML value, trigger this ->
    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public String saveOrderXML(){
        System.out.println("xml");
        return "save Order XML";
    }
}
