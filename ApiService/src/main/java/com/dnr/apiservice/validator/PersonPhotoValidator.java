package com.dnr.apiservice.validator;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PersonPhotoValidator implements ConstraintValidator<PersonPhotoValidation, MultipartFile> {
    @Override
    public void initialize(PersonPhotoValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(MultipartFile photo, ConstraintValidatorContext constraintValidatorContext) {
        BufferedImage img = null;
        try {
            img = ImageIO.read((File) photo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width          = img.getWidth();
        int height         = img.getHeight();

        return photo.getName().matches("([^\\s]+(\\.(?i)(jpeg|png))$)") &&
                (photo.getSize() < 10) && (width < 250 && height < 100);
    }
}
