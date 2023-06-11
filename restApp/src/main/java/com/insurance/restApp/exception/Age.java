package com.insurance.restApp.exception;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
@Documented
public @interface Age {
    String message() default "Customer's age is invalid, Current age : {currentAge}" +
            "; Age must be between({minAge}) and ({maxAge})";

    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};

    int min();
    int max();
}
