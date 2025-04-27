package net.javaguides.expansetrackerapp.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.expansetrackerapp.dto.CategoryDto;
import net.javaguides.expansetrackerapp.entity.Category;
import net.javaguides.expansetrackerapp.exception.ResourceNotFoundException;
import net.javaguides.expansetrackerapp.mapper.CategoryMapper;
import net.javaguides.expansetrackerapp.repository.CategoryRepository;
import net.javaguides.expansetrackerapp.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {


    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        // convert Categorydto to Category entity
        Category category = CategoryMapper.mapToCategory(categoryDto);

        //save category to database
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));

        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map((category) -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());

    }

    @Override
    public CategoryDto updateCategory(Long categoryId,CategoryDto categoryDto) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));

        category.setName(categoryDto.name());
        Category updatedCategory =  categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {

        //check if id is available or not
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));

        categoryRepository.delete(category);
    }
}
