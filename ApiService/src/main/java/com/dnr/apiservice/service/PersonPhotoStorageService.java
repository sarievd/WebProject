package com.dnr.apiservice.service;

import com.dnr.apiservice.exception.ImageResolutionException;
import com.dnr.apiservice.exception.ImageSizeException;
import com.dnr.apiservice.exception.NoPhotoException;
import com.dnr.apiservice.exception.WrongFileExtension;
import com.dnr.apiservice.property.FileStorageProperties;
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

        public String photoUpload(MultipartFile photo) {
            checkingPhoto(photo);
            byte[] bytes = new byte[0];
            try {
                bytes = photo.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Path path = Paths.get(fileStorageProperties.getUploadDir() + photo.getOriginalFilename());
            try {
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "photo saved!";
        }

    private void checkingPhoto(MultipartFile photo){
        if(photo.isEmpty())
            throw new NoPhotoException("File is empty");
        if(!photo.getOriginalFilename().matches("[-_a-z0-9]+.(jpeg|png)$"))
            throw new WrongFileExtension("Image is not valid for .jpeg and .png extensions!");
        if (photo.getSize() > 1048576)
            throw new ImageSizeException("The image's size is bigger than 1 MB");
        BufferedImage img = null;
        try {
            img = ImageIO.read(convert(photo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width          = img.getWidth();
        int height         = img.getHeight();
        if (width > 354 && height > 472)
            throw new ImageResolutionException("The image's resolution should be in 354x472PX");
    }

    private static File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
