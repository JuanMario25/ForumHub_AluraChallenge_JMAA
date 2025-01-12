package com.jmario.alurachallege.forumhub.domain.users.controller;


import com.jmario.alurachallege.forumhub.domain.users.models.UserSingUpDTO;
import com.jmario.alurachallege.forumhub.domain.users.service.SingUpService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/singup")
public class SingUpController {

    @Autowired
    SingUpService RegisterNewUser;

    @PostMapping
    @Transactional
    public ResponseEntity authenticateUser(@RequestBody @Valid UserSingUpDTO userSingUpDTO){
            RegisterNewUser.userSingUpService(userSingUpDTO);
            return ResponseEntity.ok().build();
    }
}
