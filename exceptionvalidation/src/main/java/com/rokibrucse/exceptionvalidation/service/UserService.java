package com.rokibrucse.exceptionvalidation.service;

import com.rokibrucse.exceptionvalidation.model.User;
import com.rokibrucse.exceptionvalidation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> userList() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(long id){
        return userRepository.findById(id).get();
    }

    public void deleteUserById(long id){
        userRepository.deleteById(id);
    }

    public User updateUserById(long id,User user){
        User user1 = userRepository.findById(id).get();
        user1.setName(user.getName()!=null?user.getName():user1.getName());
        user1.setEmail(user.getEmail()!=null?user.getEmail():user1.getEmail());
        user1.setPassword(user.getPassword()!=null?user.getPassword():user1.getPassword());
        return userRepository.save(user1);
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}
