package com.foody.foody_project.service

import com.foody.foody_project.converter.AddressConverter
import com.foody.foody_project.dto.request.AddAddressRequestDto
import com.foody.foody_project.dto.request.UpdateAddressRequestDto
import com.foody.foody_project.dto.response.AddressResponseDto
import com.foody.foody_project.exception.InvalidArgumentException
import com.foody.foody_project.repository.AddressRepository
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class AddressService(
    private val repository: AddressRepository,
    private val converter: AddressConverter
) {

    fun getAddressesByUserId(userId: String?): List<AddressResponseDto> {
        userId ?: throw InvalidArgumentException("UserId is null")
        val addresses = repository.findAll()
        return addresses.stream()
            .filter{ it.fkUserId == userId }
            .map { converter.toAddressResponseDtoFromEntity(it) }
            .toList()
    }

    fun addAddress(requestDto: AddAddressRequestDto?) {
        requestDto ?: throw InvalidArgumentException("Request is null")
        repository.save(converter.toEntityFromAddAddressRequestDto(requestDto))
    }

    fun updateAddress(requestDto: UpdateAddressRequestDto?) {
        requestDto ?: throw InvalidArgumentException("Request is null")
        repository.updateAddress(
            requestDto.addressName,
            requestDto.cityName,
            requestDto.addressName,
            requestDto.streetName,
            requestDto.id
        )
    }

    fun deleteAddress(id: String?) {
        id ?: throw InvalidArgumentException("Id is null")
        repository.deleteAddressById(id)
    }
}