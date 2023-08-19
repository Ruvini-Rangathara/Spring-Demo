package com.example.spring1.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("api/v1/teacher")
public class Teacher {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleMultiPart(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String city,
            @RequestParam("profile") MultipartFile profileFile
    ) throws IOException {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("City: " + city);

        byte[] profileBytes = profileFile.getBytes();
        String profileStr = Base64.getEncoder().encodeToString(profileBytes);
        System.out.println("Profile: " + profileStr);

        return "Post";
    }

//    http://localhost:8080/testSpring/api/v1/teacher
//    body -> form-data

//    profile -> input type - file
}
