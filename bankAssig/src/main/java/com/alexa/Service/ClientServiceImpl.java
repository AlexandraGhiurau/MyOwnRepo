package com.alexa.Service;

import com.alexa.DAO.ClientRepo;
import com.alexa.Entity.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements  ClientService{

    @Autowired
    private ClientRepo clientRepo;


    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    /* 1 */
   /* @Override*/
    public List<Client> findByName(String name) {
        return clientRepo.findByName(name);
    }

    /* 2 */
    /*@Override*/
    public List<Client> findByPersonalNumCode(long personalNumCode) {
        return clientRepo.findByPersonalNumCode(personalNumCode);
    }

    /* 3 */
    /*@Override*/
    public List<Client> findByCardNo(String cardNo) {
        return clientRepo.findByCardNo(cardNo);
    }

    @Override
    public Client findOne(int id) {
        return clientRepo.findOne(id);
    }

    @Override
    public void saveClient(Client client) {
        clientRepo.save(client);
    }

    @Override
    public void delete(int id) {
         clientRepo.delete(id);
    }
}
