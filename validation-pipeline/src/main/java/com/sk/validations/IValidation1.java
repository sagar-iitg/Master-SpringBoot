package com.sk.validations;


import com.sk.core.Request;
import com.sk.core.ValidationException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class IValidation1 implements IValidation {
    @Override
    public void validate(Request request) {
        if (request.userId() == null || request.userId().isBlank()) {
            throw new ValidationException("User ID is missing");
        }
    }
}
