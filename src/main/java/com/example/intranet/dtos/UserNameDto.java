package com.example.intranet.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "User's name DTO")
@Getter
@Setter
public class UserNameDto {

    @Schema(description = "User's name")
    @NotEmpty(message = "User's name must be filled")
    private String userName;
}
