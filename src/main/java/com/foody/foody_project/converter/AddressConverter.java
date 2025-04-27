package com.foody.foody_project.converter;

import com.foody.foody_project.dto.request.AddAddressRequestDto;
import com.foody.foody_project.dto.response.AddressResponseDto;
import com.foody.foody_project.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public AddressResponseDto toAddressResponseDtoFromEntity(Address entity) {
        return new AddressResponseDto(
                entity.getAddressName(),
                entity.getStreetName(),
                entity.getCityName(),
                entity.getStateName()
        );
    }

    public Address toEntityFromAddAddressRequestDto(AddAddressRequestDto requestDto) {
        Address entity = new Address();
        entity.setAddressName(requestDto.getAddressName());
        entity.setStreetName(requestDto.getStreetName());
        entity.setCityName(requestDto.getCityName());
        entity.setAddressStatus(true);
        entity.setStateName(requestDto.getStateName());
        entity.setFkUserId(requestDto.getUserId());

        return entity;
    }
}
