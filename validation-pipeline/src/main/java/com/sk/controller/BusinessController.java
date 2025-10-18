package com.sk.controller;


import com.sk.core.Request;
import com.sk.service.BusinessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BusinessController {

    private final BusinessService service;

    public BusinessController(BusinessService service) {
        this.service = service;
    }

    @PostMapping("/process")
    public ResponseEntity<String> process(@RequestBody Request request) {
        String result = service.executeBusinessLogic(request);
        return ResponseEntity.ok(result);
    }
}
