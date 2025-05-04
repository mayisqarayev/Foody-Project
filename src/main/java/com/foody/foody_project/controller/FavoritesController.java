package com.foody.foody_project.controller;

import com.foody.foody_project.service.FavoritesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/favorites")
public class FavoritesController {
    private final FavoritesService service;

    public FavoritesController(FavoritesService service) {
        this.service = service;
    }
}
