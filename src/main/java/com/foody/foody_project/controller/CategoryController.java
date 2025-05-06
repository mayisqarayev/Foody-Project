package com.foody.foody_project.controller;

import com.foody.foody_project.dto.request.AddCategoryRequestDto;
import com.foody.foody_project.dto.response.CategoryResponseDto;
import com.foody.foody_project.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoryResponseDto> getCategories() {
        return service.getCategories();
    }

    @PostMapping
    public void addCategory(AddCategoryRequestDto requestDto) {
        service.addCategory(requestDto);
    }
}
