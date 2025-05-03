package com.foody.foody_project.converter;

import com.foody.foody_project.dto.request.AddCartItemRequestDto;
import com.foody.foody_project.model.CartItem;
import com.foody.foody_project.service.FoodService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CartItemConverter {

    private final FoodService foodService;

    public CartItemConverter(FoodService foodService) {
        this.foodService = foodService;
    }

    public CartItem toEntityFromAddCartItemRequestDto(AddCartItemRequestDto requestDto) {
        CartItem entity = new CartItem();
        entity.setFkFoodId(requestDto.getFoodId());
        entity.setFoodIsChecked(true);
        entity.setPrice(foodService.getFoodPriceById(requestDto.getFoodId()));
        entity.setFkCartId(requestDto.getCartId());
        entity.setQuantityOfFoods(BigDecimal.ONE);

        return entity;
    }
}