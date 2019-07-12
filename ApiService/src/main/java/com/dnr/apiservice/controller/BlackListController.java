package com.dnr.apiservice.controller;

import com.dnr.apiservice.model.PersonBlackList;
import com.dnr.apiservice.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blackList")
public class BlackListController {
    @Autowired
    private BlackListService blackListService;

    @GetMapping("/{id}")
    public Optional<PersonBlackList> getPersonFromBlackList(@PathVariable("id") Long id){
        return blackListService.getPersonFromBlackList(id);
    }

    @GetMapping("/all")
    public List<PersonBlackList> getAllPersonsFromBlackList(){
        return blackListService.getAllPersonsFromBlackList();
    }

    @PostMapping("/add")
    public void addPersonToBlackList(@RequestBody PersonBlackList personBlackList){
        blackListService.addPersonToBlackList(personBlackList);
    }

    @DeleteMapping("/{id}")
    public void deletePersonFromBlackList(@PathVariable("id") Long id){
        blackListService.deletePersonFromBlackList(id);
    }
}
