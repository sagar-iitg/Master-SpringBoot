package com.sk.introductionTospringboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class ProdDB implements DB{

    @Override
    public String getData() {
        return "prod DB";
    }
}
