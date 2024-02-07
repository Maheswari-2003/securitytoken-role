package com.example.Inherit.resourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Optional<Resource> getResourceById(Long id) {
        return resourceRepository.findById(id);
    }

    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public Optional<Resource> updateResource(Long id, Resource updatedResource) {
        Optional<Resource> existingResource = resourceRepository.findById(id);

        if (existingResource.isPresent()) {
            Resource resource = existingResource.get();
            resource.setData(updatedResource.getData());
            return Optional.of(resourceRepository.save(resource));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteResource(Long id) {
        if (resourceRepository.existsById(id)) {
            resourceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
