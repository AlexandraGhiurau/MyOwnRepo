package com.alexa.Service;

import com.alexa.Entity.Account;
import com.alexa.Entity.Client;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();
    public void saveAccount(Account acc);
    public Account findOne(int id);
    public void delete(int id);

}
