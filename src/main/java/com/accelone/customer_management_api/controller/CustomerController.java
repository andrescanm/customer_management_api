package com.accelone.customer_management_api.controller;

import com.accelone.customer_management_api.service.CustomerService;
import com.accelone.customer_management_api.model.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer Management API", description = "API for managing customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    @Operation(summary = "Get all customers", description = "Retrieve a list of all customers")
    public List<Customer> findAll() {
        return service.findAll();
    }

    @GetMapping("/{name}")
    @Operation(summary = "Get a customer by name", description = "Retrieve a customer by their name")
    public Optional<Customer> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @PostMapping
    @Operation(summary = "Add a new customer", description = "Create a new customer")
    public Customer save(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @PutMapping
    @Operation(summary = "Update an existing customer", description = "Update the details of an existing customer")
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }
}
