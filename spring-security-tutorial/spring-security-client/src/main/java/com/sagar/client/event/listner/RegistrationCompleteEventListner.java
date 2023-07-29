package com.sagar.client.event.listner;

import com.sagar.client.entity.User;
import com.sagar.client.event.RegistrationCompleteEvent;
import com.sagar.client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListner implements ApplicationListener<RegistrationCompleteEvent> {


    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

        //Create the verification token for the user
        User user=event.getUser();
        String token= UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);

        //send mail to user

        String url=event.getApplicationUrl()+ "/verifyRegistration?token="+token ;

        //
        log.info("Click the link to verify your account: {}",url);



    }
}
