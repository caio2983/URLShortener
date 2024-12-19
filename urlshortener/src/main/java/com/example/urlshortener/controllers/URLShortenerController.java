package com.example.urlshortener.controllers;


import com.example.urlshortener.domain.url.CreateUrl;
import com.example.urlshortener.domain.url.Url;
import com.example.urlshortener.domain.url.UrlRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class URLShortenerController {

    @Autowired
    private UrlRepository repository;

    @GetMapping("/get")
    public ResponseEntity getAllUrls() {

        var allUrls = repository.findAll();
        return ResponseEntity.ok(allUrls);
    }

    @PostMapping("/create")
    public ResponseEntity createUrl(@RequestBody @Valid CreateUrl data) {
        Url newUrl = new Url(data);
        repository.save(newUrl);

        return ResponseEntity.ok().build();


    }


 

}
