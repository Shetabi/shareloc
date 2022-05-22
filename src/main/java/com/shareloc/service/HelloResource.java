package com.shareloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class HelloResource {

    private final HelloRepository repository;

    @GetMapping("/{id}")
    public String hello(@PathVariable("id") Integer id) {
        return repository.findById(id).get().getMessage();
    }

    @GetMapping("/hello/{id}")
    public String helloCreate(@PathVariable("id") Integer id) {
        HelloEntity helloEntity = new HelloEntity();

        helloEntity.setId(id);
        helloEntity.setMessage("Hello number " + id);

        HelloEntity save = repository.save(helloEntity);

        return String.format("Hello with Id %d created", save.getId());
    }

}
