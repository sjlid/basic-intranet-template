package com.example.intranet.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "User's surname DTO")
@Getter
@Setter
public class UserSurnameDto {

    @Schema(description = "User's surname")
    @NotEmpty(message = "User's surname must be filled")
    private String userSurname;
}
