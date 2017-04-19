package com.alexa.Service;


import com.alexa.Entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public void saveUser(User user);
    public User findOne(int id);
    public void delete(int id);
    public List<User> findByName(String name);
}
