package com.alexa.DAO;

import com.alexa.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Integer> {

    //update si delete

}
