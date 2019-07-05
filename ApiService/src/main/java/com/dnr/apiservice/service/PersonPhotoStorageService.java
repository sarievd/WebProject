package com.dnr.apiservice.service;

import com.dnr.apiservice.property.FileStorageProperties;
import com.dnr.apiservice.validator.PersonPhotoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PersonPhotoStorageService {

    @Autowired
    private FileStorageProperties fileStorageProperties;



        public String photoUpload(MultipartFile photo) throws IOException {
            if(photo.isEmpty())
                return "no photo!";
            if(!photo.getOriginalFilename().matches("[-_a-z0-9]+.(jpeg|png)$"))
                return "doesnt match extension";
            if (photo.getSize() > 1048576)
                return "too big";
            BufferedImage img = null;
            try {
                img = ImageIO.read(convert(photo));
            } catch (IOException e) {
                e.printStackTrace();
            }
            int width          = img.getWidth();
            int height         = img.getHeight();
            if (width < 354 && height < 472)
                return "try to use another resolution of the photo!";
            byte[] bytes = photo.getBytes();
            Path path = Paths.get(fileStorageProperties.getUploadDir() + photo.getOriginalFilename());
            Files.write(path, bytes);
            return "photo saved!";
        }

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


}
