package com.sagar.springbootdemo.error;


import com.sagar.springbootdemo.model.Employee;
import com.sagar.springbootdemo.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


            @ExceptionHandler(EmployeeNotFoundException.class)
            @ResponseBody
            @ResponseStatus(HttpStatus.NOT_FOUND)
            public ErrorMessage employeeNotFoundHandler(EmployeeNotFoundException e){

                    ErrorMessage msg=new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
                    return msg;

            }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage genericExceptionHandler(Exception e){

        ErrorMessage msg=new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        return msg;

    }






}
