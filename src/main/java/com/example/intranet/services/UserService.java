package com.example.intranet.services;

import com.example.intranet.models.User;
import com.example.intranet.repositories.UserRepository;
import com.example.intranet.utils.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findUserById(long id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElseThrow(UserNotFoundException::new);
    }

    @Transactional
    public void create(User user) {
        if (userRepository.existsByLogin(user.getUsername())) {
            throw new RuntimeException("User with the same username is already exists");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User with the same email is already exists");
        }
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        return userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    @Transactional
    public void changeName(long id, String employeeName) {
        User updatedUser = findUserById(id);
        updatedUser.setUserName(employeeName);
        userRepository.save(updatedUser);
    }

    @Transactional
    public void changeSurname(long id, String employeeSurname) {
        User updatedUser = findUserById(id);
        updatedUser.setUserSurname(employeeSurname);
        userRepository.save(updatedUser);
    }
}
