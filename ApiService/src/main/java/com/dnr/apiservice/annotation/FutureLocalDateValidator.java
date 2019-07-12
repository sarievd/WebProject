package com.dnr.apiservice.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class FutureLocalDateValidator implements ConstraintValidator<FutureLocalDateConstraint, LocalDate> {
    @Override
    public void initialize(FutureLocalDateConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return localDate.isAfter(LocalDate.now());
    }
}
