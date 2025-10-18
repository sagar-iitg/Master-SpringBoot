package com.sk.validations;


import com.sk.core.Request;
import com.sk.core.ValidationException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class IValidation3 implements IValidation {
    @Override
    public void validate(Request request) {
        if (!"IN".equalsIgnoreCase(request.country())) {
            throw new ValidationException("Only country IN is allowed");
        }
    }
}
