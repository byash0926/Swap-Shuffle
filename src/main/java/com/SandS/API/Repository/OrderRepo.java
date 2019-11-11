package com.SandS.API.Repository;

import com.SandS.API.Model.ss_orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<ss_orders,Integer> {
}
