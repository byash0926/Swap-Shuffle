package com.SandS.API.Controller;

import com.SandS.API.Model.ss_users;
import com.SandS.API.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserCont {

    @Autowired
    private UserService userService;

    @PostMapping(path="/add", consumes = "application/json")
    public ss_users addNewUser(@RequestBody ss_users user){
        return userService.addUser(user);
    }

//    @GetMapping(path="/")
//    public ss_users addNewUsr(){
//        userService.addUser(new ss_users("Harsh", 987654321, "harsh@gmail.com", "1234", null, null));
//        userService.addUser(new ss_users("vardhan", 987654321, "ojha@gmail.com", "1234", null, null));
//        return userService.addUser(new ss_users("Harshvardhan", 987654321, "ojhaharsh7@gmail.com", "1234", null, null));
//    }

    @GetMapping(path="/find/{email}")
    public ss_users findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @PostMapping(path = "/delete/{id}", consumes = "application/json")
    public void deleteUser(@RequestBody int id){
        userService.deleteUser(id);
    }
}
