package com.example.crud.user.service;

import com.example.crud.user.exception.UserAlreadyInException;
import com.example.crud.user.model.User;
import com.example.crud.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public String getUser() {
        return "one";
    }

    public void saveUser(User user) {
       if(userRepository.findById(user.getId()).isPresent()){
           throw new UserAlreadyInException("User already in system user_id="+user.getId());
       }
        userRepository.save(user);
    }

    public String updateUser() {
        return "update";
    }

    public String deleteUser() {
        return "delete";
    }
}
