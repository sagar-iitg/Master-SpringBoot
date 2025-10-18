package com.sk.validations;

import com.sk.core.Request;
import com.sk.core.ValidationException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(2)
public class IValidation2 implements IValidation {
    @Override
    public void validate(Request request) {
        if (request.amount() <= 0) {
            throw new ValidationException("Amount must be positive");
        }
    }
}
