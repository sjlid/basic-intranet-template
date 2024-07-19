package com.example.intranet.security;

import com.example.intranet.dtos.JwtAuthenticationResponseDto;
import com.example.intranet.dtos.SignInRequestDto;
import com.example.intranet.dtos.SignUpRequestDto;
import com.example.intranet.models.Role;
import com.example.intranet.models.User;
import com.example.intranet.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResponseDto signUp(SignUpRequestDto request) {
        var user = User.builder()
                .login(request.getLogin())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .userName(request.getUserName())
                .userSurname(request.getUserSurname())
                .phone(request.getPhone())
                .jobTitle(request.getJobTitle())
                .department(request.getDepartment())
                .role(Role.USER)
                .build();

        userService.saveUser(user);
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponseDto(jwt);
    }

    public JwtAuthenticationResponseDto signIn(SignInRequestDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getLogin(),
                request.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getLogin());

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponseDto(jwt);
    }
}