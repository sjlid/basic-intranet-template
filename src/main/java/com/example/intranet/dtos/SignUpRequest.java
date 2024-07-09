package com.example.intranet.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema(description = "Sign Up request")
@Data
public class SignUpRequest {

    private String username;
    private String password;
    private String email;
}
