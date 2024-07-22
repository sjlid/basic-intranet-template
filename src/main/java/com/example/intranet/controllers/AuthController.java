package com.example.intranet.controllers;

import com.example.intranet.dtos.JwtAuthenticationResponseDto;
import com.example.intranet.dtos.SignInRequestDto;
import com.example.intranet.dtos.SignUpRequestDto;
import com.example.intranet.security.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Add a new employee to the intranet. Access only for authorized users with ADMIN role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User has created"),
            @ApiResponse(responseCode = "400", description = "Not all the necessary fields are filled"),
            @ApiResponse(responseCode = "500", description = "Not all the necessary fields are present in DTO or has correct values")
    })
    @PostMapping("/sign-up")
    public JwtAuthenticationResponseDto signUp(
            @Parameter(description = "Create a new user in the intranet", required = true)
            @RequestBody @Valid SignUpRequestDto request) {
        return authenticationService.signUp(request);
    }

    @Operation(summary = "Login for user", description = "Here you can logging in as a user",
            tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User is logged in"),
            @ApiResponse(responseCode = "400", description = "Not all the necessary fields are filled"),
            @ApiResponse(responseCode = "500", description = "Not all the necessary fields are present in DTO or has correct values")
    })
    @PostMapping("/sign-in")
    public JwtAuthenticationResponseDto signIn(
            @Parameter(description = "Login as actual employee wit login-password", required = true)
            @RequestBody @Valid SignInRequestDto request) {
        return authenticationService.signIn(request);
    }
}
