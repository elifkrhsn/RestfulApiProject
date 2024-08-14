package com.example.demo.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = UniqueEmployeeValidator.class)
@Target({ TYPE })
@Retention(RUNTIME)
public @interface UniqueEmployeeDetails {
    String message() default "Duplicate values found.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
