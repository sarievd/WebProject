package com.dnr.apiservice.service;

import com.dnr.apiservice.dto.PersonDTO;
import com.dnr.apiservice.model.Person;
import com.dnr.apiservice.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private  PersonRepository personRepository;
    @Autowired
    private PersonPhotoStorageService personPhotoStorageService;

    public Optional<Person> getPerson(Long id){
        return personRepository.findById(id);
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public void addPerson(MultipartFile photo, String userData){
        PersonDTO personDTO = new PersonDTO();
        Person person = new Person();
        ObjectMapper userObj = new ObjectMapper();
        try {
            personDTO = userObj.readValue(userData, PersonDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        person.setPhotoPath(personPhotoStorageService.photoUpload(photo));//returns the path of the file;
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setBirthDate(personDTO.getBirthDate());
        person.setDriverLicense(personDTO.getDriverLicense());
        person.setDriverLicenseExpiringDate(personDTO.getDriverLicenseExpiringDate());
        System.out.println(personDTO.toString());
        System.out.println(person.toString());
        personRepository.save(person);
    }

    public void addPersonWithCar(Person person){
        personRepository.save(person);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }


}
