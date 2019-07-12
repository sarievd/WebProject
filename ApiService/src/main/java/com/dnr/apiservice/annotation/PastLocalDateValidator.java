package com.dnr.apiservice.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class PastLocalDateValidator implements ConstraintValidator<PastLocalDateConstraint, LocalDate> {
    @Override
    public void initialize(PastLocalDateConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return localDate.isBefore(LocalDate.now());
    }
}
