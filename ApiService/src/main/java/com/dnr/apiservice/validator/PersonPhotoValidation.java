package com.dnr.apiservice.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PersonPhotoValidator.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonPhotoValidation {

    String message() default "Image's extensions should be .png or .jpeg, image size should be bigger than 2MB, check out image resolution";
    Class<? >[] groups()  default {};
    Class<? extends Payload> [] payload() default {};
}
