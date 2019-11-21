package com.SandS.API.Controller;

import com.SandS.API.Model.forget_password;
import com.SandS.API.Model.ss_users;
import com.SandS.API.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

//    @GetMapping("/sendmail/{email}")
//    public void sendmailTest(@PathVariable String email) {
//        userService.sendMail(email);
//    }

    @GetMapping("/confirmation/{token}")
    public ss_users ConfirmAccount(@PathVariable String token) {
        return userService.findByTokenID(token);
    }

    @PostMapping(path = "/login/", consumes = "application/json")
    public ResponseEntity LogInUser(@RequestBody ss_users User){
        try {
            //System.out.println(User);
            ss_users user = userService.findByEmailPass(User.getEmail(), User.getPassword());
            if(user == null) {
                return ResponseEntity.ok("Bad Credential");
            }
            return ResponseEntity.ok(user);
        }
        catch (Exception ex) {
            return ResponseEntity.ok("Bad Credential");
        }
//        if(user == null) {
//            System.out.println("Invalid");
//            return (ResponseEntity) ResponseEntity.badRequest();
//        }
    }

    @GetMapping(path="/find/{email}")
    public ss_users findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @PostMapping(path = "/delete/{id}", consumes = "application/json")
    public void deleteUser(@RequestBody int id){
        userService.deleteUser(id);
    }

    @GetMapping(path = "forgotpassword/{email}")
    public ResponseEntity forgotPassword(@PathVariable String email){
        ss_users user = findByEmail(email);
        if(user != null){
            user.setTokenID(UUID.randomUUID().toString());
            String Subject = "Reset the Password";
            String Message = "To reset your password click on the link given below.";
            String link = "http://localhost:8080/user/forgotpassword/"+user.getTokenID();
            userService.sendMail(user,Message,Subject);
        }

        return ResponseEntity.ok("CHECK YOUR MAIL TO CONFIRM PASSWORD");
    }

    @PostMapping(path = "forgotpassword/token/{tokenId}")
    public ResponseEntity forgotPasswordPost(@PathVariable String tokenId, @RequestBody forget_password password){
        ss_users user = userService.findByTokenID(tokenId);
        if(user == null){
            return ResponseEntity.ok("No User Found with this email");
        }
        if(password.getPassword().equals(password.getC_password())) {
            user.setPassword(password.getPassword());
            userService.addUser(user);
            return ResponseEntity.ok("Successfully changed your Password");
        }
        return ResponseEntity.ok("Password doesn't match");
    }
}
