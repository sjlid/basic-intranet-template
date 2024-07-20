package com.example.intranet.dtos;

import com.example.intranet.models.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Schema(description = "Sign up request")
@Data
public class SignUpRequestDto {

    @Schema(description = "It's a login")
    @NotBlank(message = "Login must be filled")
    @Size(min = 2, max = 30, message = "Login should be between 2 and 30 characters")
    private String login;

    @Schema(description = "User's password")
    @NotBlank(message = "Password must be filled")
    @Size(min = 7, max = 15, message = "Password should be between 7 and 15 characters")
    private String password;

    @Schema(description = "User's email")
    @NotBlank(message = "Email must be filled")
    @Email(message = "Email should be user@example.com alike")
    private String email;

    @Schema(description = "User's name")
    @NotBlank(message = "User's name must be filled")
    private String userName;

    @Schema(description = "User's surname")
    @NotBlank(message = "User's surname must be filled")
    private String userSurname;

    @Schema(description = "User's phone number")
    @NotBlank(message = "Phone number must be filled")
    private String phone;

    @Schema(description = "User's job title")
    @NotBlank(message = "Job title must be filled")
    private String jobTitle;

    @Schema(description = "Department's name, where user is working")
    @NotBlank(message = "Department's name must be filled")
    private String department;

    @Schema(description = "User's role")
    private Role role;
}
