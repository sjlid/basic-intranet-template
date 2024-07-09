package com.example.intranet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
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
    @Column(name = "username", unique = true)
    private String username;

    @NotEmpty(message = "Password must be filled")
    @Column(name = "password")
    private String password;

    @NotEmpty(message = "Employee name must be filled")
    @Column(name = "employee_name")
    private String employeeName;

    @NotEmpty(message = "Employee name must be filled")
    @Column(name = "employee_surname")
    private String employeeSurname;

    @NotEmpty(message = "Phone number must be filled")
    @Column(name = "phone", unique = true)
    private String phone;

    @NotEmpty(message = "Email must be filled")
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Department name must be filled")
    @Column(name = "department")
    private String departmentName;

    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "Employee name must be filled")
    @Column(name = "role")
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRoleName()));
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
