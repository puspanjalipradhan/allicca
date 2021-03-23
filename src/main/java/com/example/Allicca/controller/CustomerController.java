package com.example.Allicca.controller;

import com.example.Allicca.model.Cache;
import com.example.Allicca.model.CacheImpl;
import com.example.Allicca.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CustomerController {

    @Autowired
    Cache cache;

    @PostMapping(path = "/customer", produces = "application/json")
    public ResponseEntity customerDetail(@RequestBody Customer customer) {

        cache.setCustomer(customer);

        return new ResponseEntity(customer, HttpStatus.CREATED);
    }

    @GetMapping(path = "/customer/{id}")
    public ResponseEntity fetchCustomer(@PathVariable Long id) {

        String errorMessage = "Customer data Not found";
        if (cache.containsCustomer(id)) {
            return new ResponseEntity(cache.getCustomer(id), HttpStatus.OK);
        }
        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }


    @Bean
    public Cache getCache() {
        return new CacheImpl();
    }
}
