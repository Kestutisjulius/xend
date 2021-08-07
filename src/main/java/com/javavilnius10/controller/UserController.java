package com.javavilnius10.controller;

import com.javavilnius10.exception.UserNotFoundException;
import com.javavilnius10.model.User;
import com.javavilnius10.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/user")
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws UserNotFoundException {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }
    @PostMapping()
    public ResponseEntity<Void> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<Void> updateUser (@RequestBody User user){
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
