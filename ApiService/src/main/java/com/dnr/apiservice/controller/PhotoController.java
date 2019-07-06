package com.dnr.apiservice.controller;

import com.dnr.apiservice.service.PersonPhotoStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/photoUpload")
public class PhotoController {
    @Autowired
    private PersonPhotoStorageService personPhotoStorageService;

    @PostMapping("/")
    public String photoUpload(@RequestParam("file")MultipartFile file) throws IOException {

        return personPhotoStorageService.photoUpload(file);
    }
}
