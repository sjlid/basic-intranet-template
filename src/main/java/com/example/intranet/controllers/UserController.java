package com.example.intranet.controllers;

import com.example.intranet.dtos.UserNameDto;
import com.example.intranet.dtos.UserSurnameDto;
import com.example.intranet.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "Access only for authorized users")
    @GetMapping("/employees")
    public String getAllEmployees() {
        return "Hello, world!";
    }


    @Operation(summary = "Add a new employee to the intranet. Access only for authorized users with ADMIN role")
    @PostMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public String createEmployee() {
        return "Hello, admin!";
    }

    @Operation(summary = "Change employee's name. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/name")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> changeName(@PathVariable long id,
                                                 @RequestBody @Valid UserNameDto userNameDto
    ) {
        userService.changeName(id, userNameDto.getUserName());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Change employee's surname. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/surname")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> changeSurname(@PathVariable long id,
                                                    @RequestBody @Valid UserSurnameDto userSurnameDto
    ) {
        userService.changeName(id, userSurnameDto.getUserSurname());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Change employee's phone number. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/phone")
    @PreAuthorize("hasRole('ADMIN')")
    public String changePhoneNumber() {
        return "Hello, admin!";
    }

    @Operation(summary = "Change employee's email. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/email")
    @PreAuthorize("hasRole('ADMIN')")
    public String changeEmail() {
        return "Hello, admin!";
    }

    @Operation(summary = "Change employee's department. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/department")
    @PreAuthorize("hasRole('ADMIN')")
    public String changeDepartment() {
        return "Hello, admin!";
    }

    @Operation(summary = "Change employee's job title. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/job_title")
    @PreAuthorize("hasRole('ADMIN')")
    public String changeJobTitle() {
        return "Hello, admin!";
    }


    @Operation(summary = "Remove an employee from the intranet. Access only for authorized users with ADMIN role")
    @DeleteMapping("/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String removeEmployee() {
        return "Hello, admin!";
    }
}
