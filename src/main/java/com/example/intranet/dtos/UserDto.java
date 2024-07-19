package com.example.intranet.dtos;

import com.example.intranet.models.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "User's DTO")
@Getter
@Setter
public class UserDto {

    @Schema(description = "User's login")
    @NotBlank(message = "Login must be filled")
    private String login;

    @Schema(description = "User's password")
    @NotBlank(message = "Password must be filled")
    private String password;

    @Schema(description = "User's name")
    @NotBlank(message = "User's name must be filled")
    private String userName;

    @Schema(description = "User's surname")
    @NotBlank(message = "User's surname must be filled")
    private String userSurname;

    @Schema(description = "User's phone number")
    @NotBlank(message = "Phone number must be filled")
    private String phone;

    @Schema(description = "User's email")
    @NotBlank(message = "Email must be filled")
    private String email;

    @Schema(description = "User's job title")
    @NotBlank(message = "Job title must be filled")
    private String jobTitle;

    @Schema(description = "Department's name, where user is working")
    @NotBlank(message = "Department's name must be filled")
    private String department;

    @Schema(description = "URL for user's image")
    private String imageUrl;

    @Schema(description = "User's role")
    private Role role;
}
