package com.SandS.API.Repository;

import com.SandS.API.Model.ss_users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<ss_users,Integer> {
}
