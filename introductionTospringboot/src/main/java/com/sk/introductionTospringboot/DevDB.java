package com.sk.introductionTospringboot;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



public class DevDB implements DB{
    @Override
    public String getData() {
        return "dev DB";
    }
}
