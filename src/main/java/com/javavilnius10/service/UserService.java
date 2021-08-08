package com.javavilnius10.service;

import com.javavilnius10.exception.UserNotFoundException;
import com.javavilnius10.model.Invoice;
import com.javavilnius10.model.User;
import com.javavilnius10.reposirory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with: " + id + " id was not found!"));
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }

    public User findUserByName(String name) { return userRepository.getUserByName(name);
    }

}
