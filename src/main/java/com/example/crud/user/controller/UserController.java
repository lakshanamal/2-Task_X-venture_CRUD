package com.example.crud.user.controller;

import com.example.crud.user.dto.UserDTO;
import com.example.crud.user.model.User;
import com.example.crud.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> userList=userService.getUsers();
        if(userList.isEmpty()){
            throw new ArithmeticException("user not found");
        }
            return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<String> getUser(@PathVariable String id){
        return ResponseEntity.ok(userService.getUser());
    }

    @PostMapping("/users")
    public ResponseEntity<String> saveUser(@RequestBody User User){

            userService.saveUser(User);
        return ResponseEntity.ok("User added to system");
    }

    @PutMapping("/users")
    public ResponseEntity<String> updateUser(@PathVariable String id){
        return ResponseEntity.ok(userService.updateUser());
    }

    @DeleteMapping("/users")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        return ResponseEntity.ok(userService.deleteUser());
    }
}
