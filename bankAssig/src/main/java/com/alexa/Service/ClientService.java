package com.alexa.Service;

import com.alexa.Entity.Client;

import java.util.List;

public interface ClientService {

    public List<Client> findAll();
    public void saveClient(Client client);
    public Client findOne(int id);
    public void delete(int id);
    public List<Client> findByName(String name);
    public List<Client> findByPersonalNumCode(long personalNumCode);
    public List<Client> findByCardNo(String cardNo);

}
