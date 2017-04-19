package com.alexa.DAO;

import com.alexa.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepo extends JpaRepository <Client,Integer>{

    List<Client> findByName(String name);
    List<Client> findByPersonalNumCode(long personalNumCode);
    List<Client> findByCardNo(String cardNo);
}
