package com.foody.foody_project.converter;

import com.foody.foody_project.dto.response.FavoriteResponseDto;
import com.foody.foody_project.dto.response.FavoritesResponseDto;
import com.foody.foody_project.dto.response.FoodResponseDto;
import com.foody.foody_project.model.Favorites;
import com.foody.foody_project.service.FoodService;
import com.foody.foody_project.service.RestaurantService;
import com.foody.foody_project.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class FavoritesConverter {

    private final UserService userService;
    private final FoodService foodService;
    private final RestaurantService restaurantService;

    public FavoritesConverter(UserService userService, FoodService foodService, RestaurantService restaurantService) {
        this.userService = userService;
        this.foodService = foodService;
        this.restaurantService = restaurantService;
    }

    public FavoritesResponseDto toFavoritesResponseDtoFromEntity(Favorites entity) {
        return new FavoritesResponseDto(
                userService.getProfile(entity.getUserId()),
                foodService.getFoodById(entity.getReceiverId())
        );
    }

    public FavoriteResponseDto toFavoriteResponseDtoFromEntity(Favorites entity) {
        return new FavoriteResponseDto(
                userService.getProfile(entity.getUserId()),
                restaurantService.getRestaurantById(entity.getReceiverId())
        );
    }

}
