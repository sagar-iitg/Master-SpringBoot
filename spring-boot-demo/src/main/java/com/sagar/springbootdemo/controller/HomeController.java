package com.sagar.springbootdemo.controller;


import com.sagar.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//return data in response body
//not configuring any views


// @RestController  -> @Controller+@ResponseBody
@RestController
public class HomeController {




    // end point
    @RequestMapping("/")
    public String home(){

        return "Hello world";

    }

    //send object the back
   // @RequestMapping(value="/user",method = RequestMethod.GET)--
    @GetMapping("/user")
    public User user(){
        User u=new User();
        u.setId("1");
        u.setEmailId("heelo@gmail.com");
        u.setName("sk");
        return u;


    }


    @GetMapping("/{id}")
    public String pathVariable(@PathVariable String id){


        return "The path variable is "+id;

    }


    @GetMapping("/requestParam")
    public String requestParams(@RequestParam String name,
                                @RequestParam(name="email",required = false,defaultValue = "hello@gmail.com") String emailId){
        return "Your name is "+ name+   "   email is:   "+emailId;


    }




}
