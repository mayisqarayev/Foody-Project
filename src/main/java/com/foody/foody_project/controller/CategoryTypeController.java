package com.foody.foody_project.controller;

import com.foody.foody_project.service.CategoryTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category-type")
public class CategoryTypeController {

    private final CategoryTypeService service;

    public CategoryTypeController(CategoryTypeService service) {
        this.service = service;
    }


}
