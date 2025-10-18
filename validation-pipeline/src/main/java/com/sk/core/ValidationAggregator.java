package com.sk.core;

import com.sk.validations.IValidation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidationAggregator {

    private final List<IValidation> IValidations; // auto-injected, auto-ordered

    public ValidationAggregator(List<IValidation> IValidations) {
        this.IValidations = IValidations;
    }

    public void validateAll(Request request) {
        for (IValidation v : IValidations) {
            v.validate(request); // throws ValidationException -> stops sequence
        }
    }
}
