package com.example.Inherit.PersonAddress.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perform")
public class ApiController {

    // GET mapping
    @GetMapping("/resourc")
    public String getResource() {
        return "This is a GET request";
    }

    // POST mapping
    @PostMapping("/resource")
    public String createResource(@RequestBody String data) {
        return "Received POST request with data: " + data;
    }

    // PUT mapping
    @PutMapping("/resourc/{id}")
    public String updateResource(@PathVariable Long id, @RequestBody String data) {
        return "Received PUT request for resource with id " + id + " and data: " + data;
    }

    // PATCH mapping
    @PatchMapping("/resource/{id}")
    public String partialUpdateResource(@PathVariable Long id, @RequestBody String data) {
        return "Received PATCH request for resource with id " + id + " and data: " + data;
    }
}

