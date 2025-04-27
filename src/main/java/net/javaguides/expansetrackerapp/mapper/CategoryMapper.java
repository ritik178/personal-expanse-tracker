package net.javaguides.expansetrackerapp.mapper;

import net.javaguides.expansetrackerapp.dto.CategoryDto;
import net.javaguides.expansetrackerapp.entity.Category;

public class CategoryMapper {

    public static Category mapToCategory(CategoryDto categoryDto) {
        return new Category(categoryDto.id(),
                categoryDto.name()
        );
    }

    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(category.getId(),
                category.getName()
        );
    }
}
