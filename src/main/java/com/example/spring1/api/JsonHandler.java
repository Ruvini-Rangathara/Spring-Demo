package com.example.spring1.api;

import com.example.spring1.dto.JsonData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jsonHandler")
public class JsonHandler {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonData> getJsonData(){
        System.out.println("Json Handler");
        return new ResponseEntity<>(new JsonData("J001", "Ruvini","Panadura"), HttpStatus.CREATED);
    }
}

