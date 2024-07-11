package com.example.intranet.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "User's department DTO")
@Getter
@Setter
public class UserDepartmentDto {

    @Schema(description = "User's department")
    @NotEmpty(message = "Department must be filled")
    private String department;
}
