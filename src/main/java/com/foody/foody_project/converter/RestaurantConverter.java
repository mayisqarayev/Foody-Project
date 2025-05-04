package com.foody.foody_project.converter;

import com.foody.foody_project.dto.response.RestaurantResponseDto;
import com.foody.foody_project.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantConverter {

    public RestaurantResponseDto toRestaurantResponseDtoFromEntity(Restaurant entity) {
        return new RestaurantResponseDto(
                entity.getRestaurantName(),
                entity.getPhoto(),
                entity.getRestaurantRating()
        );
    }
}
