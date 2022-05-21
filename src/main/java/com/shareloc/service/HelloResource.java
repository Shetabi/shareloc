package com.shareloc.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloResource {

    @GetMapping("/hello")
    public String hello() {
        return "Hello I'm here!";
    }

}
