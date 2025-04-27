package com.foody.foody_project.service

import com.foody.foody_project.converter.UserConverter
import com.foody.foody_project.dto.request.UpdateUserPhoneRequestDto
import com.foody.foody_project.dto.request.UpdateUserRequestDto
import com.foody.foody_project.dto.response.ForReviewUserResponseDto
import com.foody.foody_project.dto.response.UserResponseDto
import com.foody.foody_project.exception.InvalidArgumentException
import com.foody.foody_project.exception.UserNotFoundException
import com.foody.foody_project.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository,
    private val converter: UserConverter
) {
    fun getProfile(id: String?): UserResponseDto {
        id ?: throw InvalidArgumentException("Id is null")
        return converter.toUserResponseDtoFromEntity(
            repository.findById(id).orElseThrow { UserNotFoundException("User not found") }
        )
    }

    fun updateProfile(requestDto: UpdateUserRequestDto?) {
        requestDto ?: throw InvalidArgumentException("Request is null")
        repository.updateProfile(
            requestDto.fullName,
            requestDto.email,
            requestDto.photo,
            requestDto.phone,
            requestDto.id
        )
    }

    fun updateProfilePhone(requestDto: UpdateUserPhoneRequestDto?) {
        val user = requestDto?.id?.let {
            repository.findById(it).orElseThrow { UserNotFoundException("User not found") }
        } ?: throw InvalidArgumentException("Request is null")
        user.phone = requestDto.phone
        repository.save(user)
    }

    fun getUsernameAndPhotoById(id: String?): ForReviewUserResponseDto {
        val user = repository.findById(id).get()
        return ForReviewUserResponseDto(
            user.fullName,
            user.photo
        )
    }
}