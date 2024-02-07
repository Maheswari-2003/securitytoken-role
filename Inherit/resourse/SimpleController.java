package com.example.Inherit.resourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resources")
public class SimpleController {

    @Autowired
    private ResourceService resourceService;

    // GET mapping
    @GetMapping("/{id}")
    public Resource getResource(@PathVariable Long id) {
        return resourceService.getResourceById(id).orElse(null);
    }

    // GET all resources
    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    // POST mapping
    @PostMapping
    public Resource createResource(@RequestBody Resource resource) {
        return resourceService.createResource(resource);
    }

    // PUT mapping
    @PutMapping("/{id}")
    public Resource updateResource(@PathVariable Long id, @RequestBody Resource updatedResource) {
        return resourceService.updateResource(id, updatedResource).orElse(null);
    }

    // DELETE mapping
    @DeleteMapping("/{id}")
    public String deleteResource(@PathVariable Long id) {
        if (resourceService.deleteResource(id)) {
            return "Resource deleted successfully";
        } else {
            return "Resource not found with ID: " + id;
        }
    }
}
