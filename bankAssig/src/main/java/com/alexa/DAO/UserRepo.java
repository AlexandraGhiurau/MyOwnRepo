package com.alexa.DAO;


import com.alexa.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {

    List<User> findByName(String name);

}
