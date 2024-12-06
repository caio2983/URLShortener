package com.example.urlshortener.controllers;


import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class URLShortenerController {

    @GetMapping("/hello")
    public ResponseEntity sayHello() {
        return ResponseEntity.ok("hello world");
    }
}
