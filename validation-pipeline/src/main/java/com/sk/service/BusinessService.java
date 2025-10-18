package com.sk.service;


import com.sk.core.Request;
import com.sk.core.ValidationAggregator;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    private final ValidationAggregator validationAggregator;

    public BusinessService(ValidationAggregator validationAggregator) {
        this.validationAggregator = validationAggregator;
    }

    public String executeBusinessLogic(Request request) {
        // 1) run sequential validations (synchronous)
        validationAggregator.validateAll(request);

        // 2) proceed only if all validations pass
        // ... your business logic here ...
        return "Processed for userId=" + request.userId()
                + ", amount=" + request.amount()
                + ", country=" + request.country();
    }
}
