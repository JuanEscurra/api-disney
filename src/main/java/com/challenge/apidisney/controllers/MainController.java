package com.challenge.apidisney.controllers;

import com.challenge.apidisney.domain.dao.UserRepository;
import com.challenge.apidisney.domain.entity.User;
import com.challenge.apidisney.services.EmailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Conjunto de operaciones generales para los usuarios", tags = "Generales")
public class MainController {

    private EmailService emailService;

    private final UserRepository repository;

    @Autowired
    public MainController(UserRepository repository, EmailService emailService ) {
        this.repository = repository;
        this.emailService = emailService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User newUser = repository.save(user);

        if(newUser != null) {
            emailService.sendEmail(user.getEmail());
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}