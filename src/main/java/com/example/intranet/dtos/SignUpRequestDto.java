package com.example.intranet.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Schema(description = "Sign up request")
@Data
public class SignUpRequestDto {

    @Schema(description = "It's a login")
    @NotEmpty(message = "Login must be filled")
    @Size(min = 2, max = 30, message = "Login should be between 2 and 30 characters")
    private String login;

    @Schema(description = "User's password")
    @NotEmpty(message = "Password must be filled")
    @Size(min = 7, max = 15, message = "Password should be between 7 and 15 characters")
    private String password;

    @Schema(description = "User's email")
    @NotEmpty(message = "Email must be filled")
    @Email(message = "Email should be user@example.com alike")
    private String email;
}
