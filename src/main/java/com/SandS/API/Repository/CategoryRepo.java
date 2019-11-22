package com.SandS.API.Repository;

import com.SandS.API.Model.ss_category;
import com.SandS.API.Model.ss_product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<ss_category,Integer> {
    ss_category findByName(String c_name);
}
