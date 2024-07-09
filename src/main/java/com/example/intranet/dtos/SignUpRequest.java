package com.example.intranet.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Schema(description = "Sign Up request")
@Data
public class SignUpRequest {

    @Schema(description = "User's name")
    @NotEmpty(message = "Login must be filled")
    @Size(min = 2, max = 30, message = "Username should be between 2 and 30 characters")
    private String username;

    @Schema(description = "User's password")
    @NotEmpty(message = "Password must be filled")
    @Size(min = 7, max = 15, message = "Password should be between 7 and 15 characters")
    private String password;

    @Schema(description = "User's email")
    @NotEmpty(message = "Email must be filled")
    @Email(message = "Email should be user@example.com alike")
    private String email;
}
