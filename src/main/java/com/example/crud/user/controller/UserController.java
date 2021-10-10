package com.example.crud.user.controller;

import com.example.crud.user.dto.UserDTO;
import com.example.crud.user.model.User;
import com.example.crud.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/users")
    public ResponseEntity<Map<String,String>> saveUser(@RequestBody User User){
        return ResponseEntity.ok(userService.saveUser(User));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Map<String,String>> updateUserPut(@RequestBody User user, @PathVariable String id){
        return ResponseEntity.ok(userService.updateUser(user,id));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String,String>> deleteUser(@PathVariable String id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
