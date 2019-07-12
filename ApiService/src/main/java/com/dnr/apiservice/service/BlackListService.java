package com.dnr.apiservice.service;

import com.dnr.apiservice.model.PersonBlackList;
import com.dnr.apiservice.repository.BlackListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlackListService {
    @Autowired
    private BlackListRepository blackListRepository;

    public Optional<PersonBlackList> getPersonFromBlackList(Long id){
        return blackListRepository.findById(id);
    }

    public List<PersonBlackList> getAllPersonsFromBlackList(){
        return blackListRepository.findAll();
    }

    public void addPersonToBlackList(PersonBlackList personBlackList){
        blackListRepository.save(personBlackList);
    }

    public void deletePersonFromBlackList(Long id){
        blackListRepository.deleteById(id);
    }
}
