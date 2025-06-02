package com.foody.foody_project.converter;

import com.foody.foody_project.dto.request.CreateUserRequestDto;
import com.foody.foody_project.dto.response.UserResponseDto;
import com.foody.foody_project.model.User;
import com.foody.foody_project.service.RoleService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserConverter(@Lazy RoleService roleService, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto toUserResponseDtoFromEntity(User entity)  {
        return new UserResponseDto(
                entity.getFullName(),
                entity.getUsername(),
                entity.getPhone(),
                entity.getPhoto()
        );
    }

    public User toEntityFromCreateUserRequestDto(CreateUserRequestDto requestDto) {
        User entity = new User();
        entity.setFullName(requestDto.getFullName());
        entity.setEmail(requestDto.getEmail());
        entity.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        entity.setPhone("Please enter your phone number");
        entity.setPhoto("");
        entity.setEnabled(true);
        entity.setAccountNonExpired(true);
        entity.setAccountNonLocked(true);
        entity.setCredentialsNonExpired(true);
        entity.setAuthority(roleService.getRole(requestDto.getRoleId()));

        return entity;
    }
}
