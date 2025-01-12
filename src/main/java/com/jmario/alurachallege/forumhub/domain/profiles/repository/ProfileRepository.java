package com.jmario.alurachallege.forumhub.domain.profiles.repository;

import com.jmario.alurachallege.forumhub.domain.profiles.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long>{
}
