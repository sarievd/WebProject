package com.dnr.apiservice.service;

import com.dnr.apiservice.model.Person;
import com.dnr.apiservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private  PersonRepository personRepository;

    public Optional<Person> getPerson(Long id){
        return personRepository.findById(id);
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public void addPerson(Person person){
        personRepository.save(person);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
