package com.jpaturial.jpaturorial.controller;

import com.jpaturial.jpaturorial.Entities.User;
import com.jpaturial.jpaturorial.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api", produces="application/json")
public class Controller {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public  ResponseEntity<List<User>> getAlluser(@RequestParam(required = false) String slackUsername) {


        try {
            List<User> user = new ArrayList<User>();

            if (slackUsername == null)
                userRepository.findAll().forEach(user::add);
            else
                userRepository.findBySlackUsername(slackUsername).forEach(user::add);

            if (user.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
       // return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<User>  saveUser(@RequestBody User user) {
//        user.setAge(25);
//        user.setBackend(true);
//        user.setSlackUsername("stevenmboko");
//        user.setBio("Hi there , I'm Steven Maina. FullStack I’m currently working on my skills i backed using spring boot java");
        try {
            User _user = userRepository
                    .save(new User(user.getSlackUsername(),user.isBackend(),user.getBio(), user.getAge()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return userRepository.save(user);
    }
    @GetMapping("/hello")
    public String HelloWorld() {
        return "hello word";
    }
}

