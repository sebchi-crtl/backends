package com.mesh.backend.controller;

import com.mesh.backend.entity.User;
import com.mesh.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> GetUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User GetUser(@PathVariable Integer id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public User AddUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/")
    public User UpdateUser(@RequestBody User user){
        User oldUser = userRepository.findById(user.getId()).orElse(null);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        return userRepository.save(oldUser);
    }

    @DeleteMapping("/")
    public Integer DeleteUser(@PathVariable Integer id){
        userRepository.deleteById(id);
        return id;
    }
}
