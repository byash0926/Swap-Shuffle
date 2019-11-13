package com.SandS.API.Service;

import com.SandS.API.Model.ss_users;
import com.SandS.API.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public ss_users addUser(ss_users user){
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
}
