package com.SandS.API.Controller;

import com.SandS.API.Model.ss_orders;
import com.SandS.API.Model.ss_users;
import com.SandS.API.Service.OrderService;
import com.SandS.API.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderCont {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping(path="/purchasedProduct/{email}")
    public List<ss_orders> addCategory(@PathVariable String email){
        ss_users user=userService.findByEmail(email);
        return orderService.purchasedProduct(user.getU_id());
    }
}
