package com.foody.foody_project.controller;

import com.foody.foody_project.dto.request.AddFavoritesRequestDto;
import com.foody.foody_project.dto.response.FavoriteResponseDto;
import com.foody.foody_project.dto.response.FavoritesResponseDto;
import com.foody.foody_project.service.FavoritesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorites")
public class FavoritesController {
    private final FavoritesService service;

    public FavoritesController(FavoritesService service) {
        this.service = service;
    }

    @PostMapping("/food")
    public void addFoodToFavorites(AddFavoritesRequestDto requestDto) {
        service.addFoodToFavorites(requestDto);
    }

    @PostMapping("/restaurant")
    public void addRestaurantToFavorites(AddFavoritesRequestDto requestDto) {
        service.addRestaurantToFavorites(requestDto);
    }

    @GetMapping("/food/{userId}")
    public List<FavoritesResponseDto> getFavoriteFoodsByUserId(@PathVariable String userId) {
        return service.getFavoriteFoodsByUserId(userId);
    }

    @GetMapping("/restaurant/{userId}")
    public List<FavoriteResponseDto> getFavoriteRestaurantsByUserId(@PathVariable String userId) {
        return service.getFavoriteRestaurantsByUserId(userId);
    }

    @DeleteMapping("/food/{foodId}")
    public void removeFoodFromFavorites(@PathVariable String foodId) {
        service.removeFoodFromFavorites(foodId);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public void removeRestaurantFromFavorites(@PathVariable String restaurantId) {
        service.removeRestaurantFromFavorites(restaurantId);
    }
}
