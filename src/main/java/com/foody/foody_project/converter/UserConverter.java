package com.foody.foody_project.converter;

import com.foody.foody_project.dto.response.UserResponseDto;
import com.foody.foody_project.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserResponseDto toUserResponseDtoFromEntity(User entity)  {
        return new UserResponseDto(
                entity.getFullName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getPhoto()
        );
    }
}
