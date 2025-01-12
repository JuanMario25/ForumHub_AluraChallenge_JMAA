package com.jmario.alurachallege.forumhub.domain.users.repository;


import com.jmario.alurachallege.forumhub.domain.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByEmail(String username);
}
