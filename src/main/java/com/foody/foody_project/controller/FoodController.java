package com.foody.foody_project.controller;

import com.foody.foody_project.dto.request.FilterFoodRequestDto;
import com.foody.foody_project.dto.response.FoodResponseDto;
import com.foody.foody_project.model.Food;
import com.foody.foody_project.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
public class FoodController {

    private final FoodService service;

    public FoodController(FoodService service) {
        this.service = service;
    }

    @PostMapping("/price")
    public List<FoodResponseDto> getFoodsByPrice(@RequestBody FilterFoodRequestDto requestDto) {
        return service.getFoodsByFilterByPrice(requestDto);
    }

    @PostMapping("/price-asc")
    public List<FoodResponseDto> getFoodsByPriceAsc(@RequestBody FilterFoodRequestDto requestDto) {
        return service.getFoodsByFilterByPriceAsc(requestDto);
    }

    @PostMapping("/rating")
    public List<FoodResponseDto> getFoodsByRating(@RequestBody FilterFoodRequestDto requestDto) {
        return service.getFoodsByFilterByRatingDesc(requestDto);
    }

    @PostMapping("/rating-asc")
    public List<FoodResponseDto> getFoodsByRatingAsc(@RequestBody FilterFoodRequestDto requestDto) {
        return service.getFoodsByFilterByRatingAsc(requestDto);
    }

    @GetMapping("/name/{name}")
    public List<FoodResponseDto> getSearchedFoodsByName(@PathVariable String name) {
        return service.getSearchedFoodsByName(name);
    }

    @GetMapping("/description/{description}")
    public List<FoodResponseDto> getSearchedFoodsByDescription(@PathVariable String description) {
        return service.getSearchedFoodsByDescription(description);
    }

    @GetMapping("/category/{categoryName}")
    public List<FoodResponseDto> getSearchedFoodsByCategory(@PathVariable String categoryName) {
        return service.getSearchedFoodsByCategory(categoryName);
    }
}
