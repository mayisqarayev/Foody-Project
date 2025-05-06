package com.foody.foody_project.controller;

import com.foody.foody_project.dto.response.RestaurantResponseDto;
import com.foody.foody_project.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping("/category/{category}")
    public List<RestaurantResponseDto> getRestaurantByFilter(@PathVariable String category) {
        return service.getRestaurantByFilter(category);
    }

    @GetMapping("/name/{name}")
    public List<RestaurantResponseDto> getRestaurantByName(@PathVariable String name) {
        return service.getRestaurantByName(name);
    }

    @GetMapping("/location/{location}")
    public List<RestaurantResponseDto> getRestaurantByLocation(@PathVariable String location) {
        return service.getRestaurantByLocation(location);
    }
}
