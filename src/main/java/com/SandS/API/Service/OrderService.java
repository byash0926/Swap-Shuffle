package com.SandS.API.Service;

import com.SandS.API.Model.ss_orders;
import com.SandS.API.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<ss_orders> purchasedProduct(int u_id) {
        return orderRepo.findByUser(u_id);
    }
}
