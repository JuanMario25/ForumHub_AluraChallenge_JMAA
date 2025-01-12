package com.jmario.alurachallege.forumhub.domain.users.controller;

import com.jmario.alurachallege.forumhub.domain.users.models.User;
import com.jmario.alurachallege.forumhub.domain.users.models.UserAuthenticationDTO;
import com.jmario.alurachallege.forumhub.infra.security.TokenService;
import com.jmario.alurachallege.forumhub.infra.security.jwtTokenDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @GetMapping

    public ResponseEntity test(){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<jwtTokenDTO> authenticateUser(@RequestBody @Valid UserAuthenticationDTO authenticationDTO){
            Authentication authToken = new UsernamePasswordAuthenticationToken(authenticationDTO.email(),authenticationDTO.password());
            var authenticatedUser = authenticationManager.authenticate(authToken);
            String jwtToken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
            return  ResponseEntity.ok( new jwtTokenDTO(jwtToken));
    }
}
