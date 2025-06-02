package com.foody.foody_project.controller;

import com.foody.foody_project.dto.request.CreateUserRequestDto;
import com.foody.foody_project.dto.request.UpdateUserPhoneRequestDto;
import com.foody.foody_project.dto.request.UpdateUserRequestDto;
import com.foody.foody_project.dto.response.UserResponseDto;
import com.foody.foody_project.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public void createUser(@RequestBody CreateUserRequestDto requestDto) {
        service.createProfile(requestDto);
    }

    @PutMapping("/update/profile")
    public void updateProfile(@RequestBody UpdateUserRequestDto requestDto) {
        service.updateProfile(requestDto);
    }

    @PatchMapping("/update/phone")
    public void updateProfilePhone(@RequestBody UpdateUserPhoneRequestDto requestDto) {
        service.updateProfilePhone(requestDto);
    }

    @GetMapping("/profile/{id}")
    public UserResponseDto getProfile(@PathVariable String id) {
        return service.getProfile(id);
    }
}
