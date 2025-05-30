package com.sagar.client.service;


import com.sagar.client.entity.PasswordResetToken;
import com.sagar.client.entity.User;
import com.sagar.client.entity.VerificationToken;
import com.sagar.client.model.UserModel;
import com.sagar.client.repository.PasswordResetTokenRepository;
import com.sagar.client.repository.UserRepository;
import com.sagar.client.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public User registerUser(UserModel userModel) {
        User u=new User();
        u.setEmail(userModel.getEmail());
        u.setFirstName(userModel.getFirstName());
        u.setLastName(userModel.getLastName());
        u.setRole("USER");
        u.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(u);
        return u;

    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken=new VerificationToken(user,token);
        verificationTokenRepository.save(verificationToken);




    }

    @Override
    public String validateVerificationToken(String token) {

        VerificationToken verificationToken=verificationTokenRepository.findByToken(token);
        if(verificationToken==null)
        {
            return "invalid token";
        }

        User user=verificationToken.getUser();
        Calendar cal=Calendar.getInstance();
        if((verificationToken.getExpirationTime().getTime()-cal.getTime().getTime()<=0)){
                verificationTokenRepository.delete(verificationToken);
                return "expired";
        }
        user.setEnabled(true);
        userRepository.save(user);
        return "valid";

    }

    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {

        VerificationToken verificationToken=verificationTokenRepository.findByToken(oldToken);
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenRepository.save(verificationToken);
        return verificationToken;

    }

    @Override
    public User findUserByEmail(String email) {

        return userRepository.findByEmail(email);

    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {

        PasswordResetToken passwordResetToken=new PasswordResetToken(user,token);
        passwordResetTokenRepository.save(passwordResetToken);



    }

    @Override
    public String validatePasswordResetToken(String token) {


        PasswordResetToken passwordResetToken=passwordResetTokenRepository.findByToken(token);

        if(passwordResetToken==null)
        {
            return "invalid token";
        }

        User user=passwordResetToken.getUser();
        Calendar cal=Calendar.getInstance();
        if((passwordResetToken.getExpirationTime().getTime()-cal.getTime().getTime()<=0)){
            passwordResetTokenRepository.delete(passwordResetToken);
            return "expired";
        }

        return "valid";

    }

    @Override
    public Optional<User> getUserByPasswordResetToken(String token) {

        return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getUser());

    }

    @Override
    public void changePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);


    }

    @Override
    public boolean checkIfValidOldPassword(User user, String oldPassword) {

        return passwordEncoder.matches(oldPassword,user.getPassword());

    }


}
