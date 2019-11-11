package com.SandS.API.Repository;

import com.SandS.API.Model.ss_category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<ss_category,Integer> {
}
