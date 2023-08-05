package com.example.spring1.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student {
    @GetMapping("student")
    public String getAllStudents(){
        return "Get All Student Data : ";
    }

    @GetMapping("student/{id}*")
    public String getAllStudentsWithGivenId(@PathVariable String id){
        return "Get All Student Data with id : "+id;
    }

    @GetMapping("student/{id:S\\d{3}}")
    public String getStudentDetails(@PathVariable String id){
        return "Student Data : "+id;
    }

}
