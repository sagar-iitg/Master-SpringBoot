package com.sagar.springbootdemo.error;

public class EmployeeNotFoundException extends  RuntimeException{



    public EmployeeNotFoundException(String msg){
        super(msg);


    }



}
