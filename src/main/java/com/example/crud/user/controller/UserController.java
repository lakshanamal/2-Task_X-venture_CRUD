package com.example.crud.user.controller;

import com.example.crud.user.model.User;
import com.example.crud.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;
    Logger log= LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        log.info("Get request received for get all users");
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        log.info("Get request received for get user, user_id="+id);
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/users")
    public ResponseEntity<Map<String,String>> saveUser(@RequestBody User user){
        log.info("Post request received , user_id="+user.getId());
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Map<String,String>> updateUserPut(@RequestBody User user, @PathVariable String id){
        log.info("Put request received , user_id="+user.getId());
        return ResponseEntity.ok(userService.updateUser(user,id));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String,String>> deleteUser(@PathVariable String id){
        log.info("Delete request received , user_id="+id);
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
