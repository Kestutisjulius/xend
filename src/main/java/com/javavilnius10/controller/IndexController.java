package com.javavilnius10.controller;

import com.javavilnius10.model.Authority;
import com.javavilnius10.model.User;
import com.javavilnius10.reposirory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class IndexController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping()
    public String index() {return "For only Authenticated USERS";}

    @GetMapping("admin")
    public String adminPage() {return "I am ADMIN";}


    @PostMapping("login")
    public User login(@RequestBody User user) {
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        Authority authority = new Authority();
        if (user.isAdmin()) {
            authority.setAuthority("ADMIN");
        } else {
            authority.setAuthority("USER");
        }
        authority.setUser(user);
        user.setAuthority(authority);
        return userRepository.save(user);
    }

    @GetMapping("details")
    public String showDetails (Principal principal) {
        String userName = principal.getName();
        User currentUser = userRepository.getUserByName(userName);
        return currentUser.getCompanyName() + ", " + currentUser.getEmail() + ", " + currentUser.getUsername();
    }
}
