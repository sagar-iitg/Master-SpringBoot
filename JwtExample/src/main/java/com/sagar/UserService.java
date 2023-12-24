package com.sagar;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store=new ArrayList<>();

     public UserService(){
         store.add(new User(UUID.randomUUID().toString(),"sagar","sagar@gmail.com"));
         store.add(new User(UUID.randomUUID().toString(),"mohit","mohit@gmail.com"));
         store.add(new User(UUID.randomUUID().toString(),"ankit","ankit@gmail.com"));
         store.add(new User(UUID.randomUUID().toString(),"pankaj","pankaj@gmail.com"));

     }

     public  List<User> getUsers(){
         return this.store;
     }
}
