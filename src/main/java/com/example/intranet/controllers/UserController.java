package com.example.intranet.controllers;

import com.example.intranet.dtos.*;
import com.example.intranet.models.User;
import com.example.intranet.services.UserImageService;
import com.example.intranet.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserImageService userImageService;

    @Operation(summary = "Get a list of all the users. Access only for authorized users")
    @GetMapping("/employees")
    public Stream<UserDto> getAllEmployees() {
        return userService.getAllUsers()
                .stream()
                .map(this::convertToUserDto);
    }

    @Operation(summary = "Change employee's name. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/name")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> changeName(@PathVariable("id") long id,
                                                 @RequestBody @Valid UserNameDto userNameDto
    ) {
        userService.changeName(id, userNameDto.getUserName());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Change employee's surname. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/surname")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> changeSurname(@PathVariable("id") long id,
                                                    @RequestBody @Valid UserSurnameDto userSurnameDto
    ) {
        userService.changeSurname(id, userSurnameDto.getUserSurname());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Change employee's phone number. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/phone")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> changePhone(@PathVariable("id") long id,
                                                  @RequestBody @Valid UserPhoneDto userPhoneDto
    ) {
        userService.changePhone(id, userPhoneDto.getPhone());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Change employee's email. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/email")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> changeEmail(@PathVariable("id") long id,
                                                  @RequestBody @Valid UserEmailDto userEmailDto
    ) {
        userService.changeEmail(id, userEmailDto.getEmail());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Change employee's department. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/department")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> changeDepartment(@PathVariable("id") long id,
                                                       @RequestBody @Valid UserDepartmentDto userDepartmentDto
    ) {
        userService.changeDepartment(id, userDepartmentDto.getDepartment());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Change employee's job title. Access only for authorized users with ADMIN role")
    @PutMapping("/employees/{id}/job_title")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> changeJobTitle(@PathVariable("id") long id,
                                                     @RequestBody @Valid UserJobTitleDto userJobTitleDto
    ) {
        userService.changeJobTitle(id, userJobTitleDto.getJobTitle());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Remove an employee from the intranet. Access only for authorized users with ADMIN role")
    @DeleteMapping("/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> removeEmployee(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Add a user's picture. Access only for authorized users with ADMIN role")
    @PostMapping("/employees/{id}/userpic")
    public ResponseEntity<String> uploadUserPic(@PathVariable("id") long id,
                                                @RequestParam("file") MultipartFile file) {
        try {
            User user = userService.findUserById(id);
            String filename = userImageService.saveUserImage(file);
            user.setImageName(filename);
            userService.saveUser(user);
            return ResponseEntity.ok("Avatar uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload avatar");
        }
    }

    @GetMapping("/employees/{id}/avatar")
    public ResponseEntity<byte[]> getUserImage(@PathVariable("id") long id) {
        try {
            User user = userService.findUserById(id);
            byte[] avatar = userImageService.getUserImage(user.getImageName());
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "image/jpeg");
            return new ResponseEntity<>(avatar, headers, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/get-admin")
    @Operation(summary = "Получить роль ADMIN (для демонстрации)")
    public void getAdmin() {
        userService.getAdmin();
    }

    private UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUsername());
        userDto.setUserSurname(user.getUserSurname());
        userDto.setPhone(user.getPhone());
        userDto.setEmail(user.getEmail());
        userDto.setJobTitle(user.getJobTitle());
        userDto.setDepartment(user.getDepartment());
        userDto.setImageUrl(user.getImageName());
        return userDto;
    }
}
