package com.dnr.apiservice.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FutureLocalDateValidator.class)
public @interface FutureLocalDateConstraint {
//    String message() default "{javax.validation.constraints.FutureLocalDateConstraint.message}";
    String message() default "Future bla bla";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
