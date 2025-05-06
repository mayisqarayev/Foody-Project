package com.foody.foody_project.controller;

import com.foody.foody_project.dto.request.PageRequestDto;
import com.foody.foody_project.dto.request.SendReviewRequestDto;
import com.foody.foody_project.dto.response.PageResponseDto;
import com.foody.foody_project.service.ReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping("/food")
    public void sendReviewToFood(@RequestBody SendReviewRequestDto requestDto) {
        service.sendReviewToFood(requestDto);
    }
    @PostMapping("/restaurant")
    public void sendReviewToRestaurant(@RequestBody SendReviewRequestDto requestDto) {
        service.sendReviewToRestaurant(requestDto);
    }

    @GetMapping("/food/{foodId}")
    public PageResponseDto getReviewsByFoodId(
            @PathVariable String foodId,
            @RequestBody PageRequestDto requestDto
    ) {
        return service.getReviewsByFoodId(foodId, requestDto);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public PageResponseDto getReviewsByRestaurantId(
            @PathVariable String restaurantId,
            @RequestBody PageRequestDto requestDto
    ) {
        return service.getReviewsByRestaurantId(restaurantId, requestDto);
    }
}
