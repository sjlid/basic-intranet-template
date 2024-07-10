package com.example.intranet.dtos;

import com.example.intranet.models.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "User's DTO")
@Getter
@Setter
public class UserDto {

    @Schema(description = "User's login")
    @NotEmpty(message = "Login must be filled")
    private String login;

    @Schema(description = "User's password")
    @NotEmpty(message = "Password must be filled")
    private String password;

    @Schema(description = "User's name")
    @NotEmpty(message = "User's name must be filled")
    private String userName;

    @Schema(description = "User's surname")
    @NotEmpty(message = "User's surname must be filled")
    private String userSurname;

    @Schema(description = "User's phone number")
    @NotEmpty(message = "Phone number must be filled")
    private String phone;

    @Schema(description = "User's email")
    @NotEmpty(message = "Email must be filled")
    private String email;

    @Schema(description = "User's job title")
    @NotEmpty(message = "Job title must be filled")
    private String jobTitle;

    @Schema(description = "Department's name, where user is working")
    @NotEmpty(message = "Department's name must be filled")
    private String departmentName;

    @Schema(description = "URL for user's image")
    @NotEmpty(message = "User should have image's url")
    private String imageUrl;

    @Schema(description = "User's role")
    @NotEmpty(message = "User's role must be filled")
    private Role role;
}
