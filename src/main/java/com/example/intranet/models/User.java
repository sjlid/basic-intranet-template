package com.example.intranet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Login must be filled")
    @Column(name = "login", unique = true)
    private String login;

    @NotEmpty(message = "Password must be filled")
    @Column(name = "password")
    private String password;

    @NotEmpty(message = "User's name must be filled")
    @Column(name = "user_name")
    private String userName;

    @NotEmpty(message = "User's surname must be filled")
    @Column(name = "user_surname")
    private String userSurname;

    @NotEmpty(message = "Phone number must be filled")
    @Column(name = "phone", unique = true)
    private String phone;

    @NotEmpty(message = "Email must be filled")
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Job's title must be filled")
    @Column(name = "job_title")
    private String jobTitle;

    @NotEmpty(message = "Department must be filled")
    @Column(name = "department")
    private String department;

    @NotEmpty(message = "User should have image's url")
    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "User's role must be filled")
    @Column(name = "role")
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return login;
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
