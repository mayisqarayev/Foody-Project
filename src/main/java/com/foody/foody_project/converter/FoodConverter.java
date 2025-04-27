package com.foody.foody_project.converter;

import com.foody.foody_project.dto.response.FoodResponseDto;
import com.foody.foody_project.model.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodConverter {

    public FoodResponseDto toFoodResponseDtoFromEntity(Food entity) {
        return new FoodResponseDto(
                entity.getFoodName(),
                entity.getFoodPrice(),
                entity.getFoodDescription(),
                entity.getFoodRating()
        );
    }
}
