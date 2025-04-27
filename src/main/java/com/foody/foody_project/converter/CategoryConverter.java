package com.foody.foody_project.converter;

import com.foody.foody_project.dto.request.AddCategoryRequestDto;
import com.foody.foody_project.dto.response.CategoryResponseDto;
import com.foody.foody_project.model.Category;
import com.foody.foody_project.service.CategoryTypeService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CategoryConverter {

    private final CategoryTypeConverter converter;
    private final CategoryTypeService service;

    public CategoryConverter(CategoryTypeConverter converter, CategoryTypeService service) {
        this.converter = converter;
        this.service = service;
    }

    public CategoryResponseDto toCategoryResponseDtoFromEntity(Category entity)  {
        return new CategoryResponseDto(
                entity.getCategoryName(),
                entity.getPopularityScore(),
                entity.getCategoryPhoto(),
                converter.toCategoryTypeResponseDtoFromEntity(
                        service.getCategory(entity.getFkCategoryTypeId())
                )
        );
    }

    public Category toEntityFromAddCategoryRequestDto(AddCategoryRequestDto requestDto) {
        Category entity = new Category();
        entity.setCategoryName(requestDto.getCategoryName());
        entity.setCategoryStatus(true);
        entity.setCategoryPhoto(requestDto.getCategoryPhoto());
        entity.setFkCategoryTypeId(requestDto.getFkCategoryTypeId());
        entity.setPopularityScore(BigDecimal.ZERO);

        return entity;
    }

}
