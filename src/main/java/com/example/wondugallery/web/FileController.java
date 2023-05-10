package com.example.wondugallery.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public class FileController {

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("test",null);
    }
}
