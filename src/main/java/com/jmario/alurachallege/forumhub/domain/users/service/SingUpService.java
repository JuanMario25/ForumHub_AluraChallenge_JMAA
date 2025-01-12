package com.jmario.alurachallege.forumhub.domain.users.service;

import com.jmario.alurachallege.forumhub.domain.profiles.repository.ProfileRepository;
import com.jmario.alurachallege.forumhub.domain.users.models.User;
import com.jmario.alurachallege.forumhub.domain.users.models.UserSingUpDTO;
import com.jmario.alurachallege.forumhub.domain.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SingUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfileRepository profileRepository;

    public void userSingUpService(UserSingUpDTO userSingUpDTO){
        User newUser = new User(userSingUpDTO);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        profileRepository.save(newUser.getProfile());
        userRepository.save(newUser);
    }
}
