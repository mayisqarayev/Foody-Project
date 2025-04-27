package com.foody.foody_project.converter;

import com.foody.foody_project.dto.response.CategoryTypeResponseDto;
import com.foody.foody_project.model.CategoryType;
import com.foody.foody_project.service.CategoryTypeService;
import org.springframework.stereotype.Component;

@Component
public class CategoryTypeConverter {

    public CategoryTypeResponseDto toCategoryTypeResponseDtoFromEntity(CategoryType entity)  {
        return new CategoryTypeResponseDto(
                entity.getCategoryTypeName()
        );
    }
}
