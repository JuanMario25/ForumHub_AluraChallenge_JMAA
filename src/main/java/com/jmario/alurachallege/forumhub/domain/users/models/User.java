package com.jmario.alurachallege.forumhub.domain.users.models;

import com.jmario.alurachallege.forumhub.domain.answers.models.Answer;
import com.jmario.alurachallege.forumhub.domain.profiles.enums.RolePermissions;
import com.jmario.alurachallege.forumhub.domain.profiles.models.Profile;
import com.jmario.alurachallege.forumhub.domain.topics.models.Topic;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "user_table")
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "profile_id") // foreign key column
    private Profile profile;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topic> topics; // Topics created by the user

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> Answers; // Answers given by the user


    public User(UserSingUpDTO singUpData){
        this.name = singUpData.name();
        this.email = singUpData.email();
        this.password = singUpData.password();
        this.profile = new Profile(RolePermissions.USER);
    }
    // example how set author in Topic and Answer
//    public void setEpisodes(List<Episode> episodes) {
//        episodes.forEach(e->e.setSeries(this));
//        this.episodes = episodes;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
