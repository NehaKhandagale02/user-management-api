package com.example.usermanagement.controller;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

@Autowired
    private UserService userService;

@PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
    User savedUser = userService.saveUser(user);
    System.out.println("user saved Successfully");
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
}

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUserList() {
        List<User> allUserList = userService.getAllUserList();
        return new ResponseEntity<>(allUserList, HttpStatus.FOUND);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") int id) {
        String msg = userService.deleteUserById(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

}
