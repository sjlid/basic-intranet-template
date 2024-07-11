package com.example.intranet.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "User's job title DTO")
@Getter
@Setter
public class UserJobTitleDto {

    @Schema(description = "User's job title")
    @NotEmpty(message = "Job title must be filled")
    private String jobTitle;
}
