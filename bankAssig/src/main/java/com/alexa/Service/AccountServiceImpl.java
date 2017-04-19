package com.alexa.Service;

import com.alexa.DAO.AccountRepo;
import com.alexa.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }

    @Override
    public void saveAccount(Account acc) {
        if(acc.getAccountId()<0){
            throw new RuntimeException("No negative ids allowed");
        }
        accountRepo.save(acc);
    }

    @Override
    public Account findOne(int id) {
        return accountRepo.findOne(id);
    }

    @Override
    public void delete(int id) {
        accountRepo.delete(id);
    }
}
