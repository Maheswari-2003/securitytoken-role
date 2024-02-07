package com.example.Inherit.PersonAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/persons")
    public ResponseEntity<String> createPerson(@RequestBody PersonRequest request) {
        personService.savePerson(request);
        return ResponseEntity.ok("Person added successfully");
    }
    @GetMapping("/get")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }


    @GetMapping("/fetch")
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam String city) {
        List<Person> persons = personService.getPersonsByCity(city);
        return ResponseEntity.ok(persons);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Person>> getPersonsByNamePattern(@RequestParam String namePattern) {
        List<Person> persons = personService.findPersonsByNamePattern(namePattern);
        return ResponseEntity.ok(persons);
    }

}
