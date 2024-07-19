package com.example.intranet.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "User's phone DTO")
@Getter
@Setter
public class UserPhoneDto {

    @Schema(description = "User's phone number")
    @NotBlank(message = "Phone number must be filled")
    private String phone;
}
