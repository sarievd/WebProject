package com.dnr.apiservice.controller;

import com.dnr.apiservice.model.Person;
import com.dnr.apiservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Optional<Person> getPerson(@PathVariable("id") Long id){
        return personService.getPerson(id);
    }

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return personService.getAllPersons();
    }

    @PostMapping("/")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id){
        personService.deletePerson(id);
    }
}
