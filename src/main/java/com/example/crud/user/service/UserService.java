package com.example.crud.user.service;

import com.example.crud.user.exception.UserAlreadyInException;
import com.example.crud.user.exception.UserNotFoundException;
import com.example.crud.user.model.User;
import com.example.crud.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getUsers() throws RuntimeException {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        if(userRepository.findById(id).isEmpty()){
            throw new UserNotFoundException("User not found, user_id="+id);
        }
            return userRepository.findById(id).get();
    }

    public Map<String,String> saveUser(User user) {
       if(userRepository.findById(user.getId()).isPresent()){
           throw new UserAlreadyInException("User already in system, user_id="+user.getId());
       }
        userRepository.save(user);
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg","New user added, user_id="+user.getId());
        return  map;
    }

    public Map<String,String> updateUser(User user,String id) {
        if(userRepository.findById(id).isEmpty()){
            throw new UserNotFoundException("User not exits in the database");
        }
        userRepository.save(user);
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg","Update user successful, user_id="+id);
        return map;
    }

    public Map<String, String>  deleteUser(String id) {
        if(userRepository.findById(id).isEmpty()){
            throw new UserNotFoundException("User not exits in the database");
        }
        userRepository.deleteById(id);
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg","User delete successful, user_id="+id);
        return map;
    }

}
