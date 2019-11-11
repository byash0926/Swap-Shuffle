package com.SandS.API.Repository;

import com.SandS.API.Model.ss_product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ss_product,Integer> {
}
