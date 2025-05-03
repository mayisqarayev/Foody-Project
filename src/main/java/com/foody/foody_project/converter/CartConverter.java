package com.foody.foody_project.converter;

import com.foody.foody_project.dto.response.CartItemResponseDto;
import com.foody.foody_project.model.CartItem;
import com.foody.foody_project.service.FoodService;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    private final FoodService foodService;

    public CartConverter(FoodService foodService) {
        this.foodService = foodService;
    }

    public CartItemResponseDto toCartItemResponseDtoFromEntity(CartItem entity) {
        return new CartItemResponseDto(
                entity.getQuantityOfFoods(),
                foodService.getFoodById(entity.getFkFoodId()),
                entity.getPrice(),
                entity.getFoodIsChecked()
        );
    }
}
