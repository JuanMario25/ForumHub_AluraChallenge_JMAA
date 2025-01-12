package com.jmario.alurachallege.forumhub.domain.profiles.models;

import com.jmario.alurachallege.forumhub.domain.profiles.enums.RolePermissions;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "profile_table")
@Entity(name = "Profile")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RolePermissions role_permissions;

    public Profile(RolePermissions role){
        this.role_permissions = role;
    }
}
