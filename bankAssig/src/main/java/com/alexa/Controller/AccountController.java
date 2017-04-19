package com.alexa.Controller;

import com.alexa.Entity.Account;
import com.alexa.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Account> getAllAccounts(){
        //this will get the collection from the hashmap and give it to me
        return accService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable("id") int id){
        return this.accService.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable("id") int id){
        accService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAccount(@RequestBody Account acc){
        accService.saveAccount(acc);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Account acc){
        accService.saveAccount(acc);
    }
}
