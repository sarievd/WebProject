package com.dnr.apiservice.controller;

import com.dnr.apiservice.service.PersonPhotoStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PhotoController {
    @Autowired
    private PersonPhotoStorageService personPhotoStorageService;

    @PostMapping("/upload")
    public String photoUpload(@RequestParam("file")MultipartFile file) throws IOException {

        return personPhotoStorageService.photoUpload(file);
    }
}
