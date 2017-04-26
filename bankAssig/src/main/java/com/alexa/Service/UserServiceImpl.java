package com.alexa.Service;

import com.alexa.DAO.UserRepo;
import com.alexa.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void saveUser(User user) {

        /*user.setPassword(user.getPassword());
        user.setRole(user.getRole());*/
        userRepo.save(user);
    }

    @Override
    public User findOne(int id) {
        return userRepo.findOne(id);
    }

    @Override
    public void delete(int id) {
        userRepo.delete(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public List<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }


}
