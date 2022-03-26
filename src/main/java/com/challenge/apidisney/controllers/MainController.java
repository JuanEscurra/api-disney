package com.challenge.apidisney.controllers;

import com.challenge.apidisney.domain.dao.UserRepository;
import com.challenge.apidisney.domain.entity.User;
import com.challenge.apidisney.dto.UserDTO;
import com.challenge.apidisney.services.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MainController {

    private final EmailService emailService;
    private final UserRepository repository;
    private final ObjectMapper objectMapper;

    @Autowired
    public MainController(UserRepository repository, EmailService emailService, ObjectMapper mapper ) {
        this.repository = repository;
        this.emailService = emailService;
        this.objectMapper = mapper;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDTO user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        User newUser = repository.save(objectMapper.convertValue(user, User.class));

        if(newUser != null) {
            emailService.sendEmail(user.getEmail());
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}