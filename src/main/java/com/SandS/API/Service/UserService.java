package com.SandS.API.Service;

import com.SandS.API.Model.ss_users;
import com.SandS.API.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JavaMailSender mailSender;

    public ss_users addUser(ss_users user){
        user.setTokenID(UUID.randomUUID().toString());
        String Subject = "Complete Your Registration";
        String Message = "To complete your registration click on the link given below.";
        String link = "http://localhost:8080/user/confirmation/"+user.getTokenID();
        sendMail(user, Message+link, Subject);
        return userRepo.save(user);
    }

    public ss_users updateUser(ss_users user){
        return userRepo.save(user);
    }

    public void deleteUser(int id){
        userRepo.deleteById(id);
    }

    public Optional<ss_users> getById(int id){
        return userRepo.findById(id);
    }

    public List<ss_users> getAll(){
        return userRepo.findAll();
    }

    public ss_users findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public ss_users findByEmailPass(String email,String password){
        ss_users user = findByEmail(email);
       // System.out.println(user);
        if(user.getU_status() == true)
            return userRepo.findByEmailAndPassword(email,password);
        else
            return null;
    }

    public boolean sendMail(ss_users user, String message, String subject) {
        try {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(user.getEmail());
            email.setSubject(subject);
            email.setText(message);
            mailSender.send(email);
            return true;
        }catch(MailException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ss_users findByTokenID(String tokenId){
        ss_users user = userRepo.findByTokenID(tokenId);
        System.out.println(user);
        if(user != null){
            user.setU_status(true);
        }
        userRepo.save(user);
        return user;
    }
}
