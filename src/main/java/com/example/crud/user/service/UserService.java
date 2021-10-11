package com.example.crud.user.service;

import com.example.crud.user.exception.UserAlreadyInException;
import com.example.crud.user.exception.UserNotFoundException;
import com.example.crud.user.model.User;
import com.example.crud.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;
    Logger log= LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getUsers(){
        log.info("Get request completed");
        return userRepository.findAll();
    }

    public User getUser(String id) {
        if(userRepository.findById(id).isEmpty()){
            log.error("User not found, user_id="+id);
            throw new UserNotFoundException("User not found, user_id="+id);
        }
        log.info("Get request completed");
            return userRepository.findById(id).get();
    }

    public Map<String,String> saveUser(User user) {
       if(userRepository.findById(user.getId()).isPresent()){
           log.error("User already in system, user_id="+user.getId());
           throw new UserAlreadyInException("User already in system, user_id="+user.getId());
       }
        userRepository.save(user);
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg","New user added, user_id="+user.getId());
        log.info("Post request completed");
        return  map;
    }

    public Map<String,String> updateUser(User user,String id) {
        if(userRepository.findById(id).isEmpty()){
            log.error("User not exits in the database");
            throw new UserNotFoundException("User not exists in the database");
        }

        userRepository.save(user);
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg","Update user successful, user_id="+id);
        log.info("Put request completed");
        return map;
    }

    public Map<String, String>  deleteUser(String id) {
        if(userRepository.findById(id).isEmpty()){
            log.error("User not exits in the database");
            throw new UserNotFoundException("User not exists in the database");
        }
        userRepository.deleteById(id);
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg","User delete successful, user_id="+id);
        log.info("Delete request completed");
        return map;
    }

}
