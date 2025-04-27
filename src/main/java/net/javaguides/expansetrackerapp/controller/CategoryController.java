package net.javaguides.expansetrackerapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.expansetrackerapp.dto.CategoryDto;
import net.javaguides.expansetrackerapp.entity.Category;
import net.javaguides.expansetrackerapp.mapper.CategoryMapper;
import net.javaguides.expansetrackerapp.repository.CategoryRepository;
import net.javaguides.expansetrackerapp.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST API for Category Resources",
        description = "CRUD REST API for Category resources - Create Category +" +
                "Update category, get Category, getAll category and delete category"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private CategoryService categoryService;

    @Operation(
            summary = "Create Category REST API",
            description = "create category Rest api to save category into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTPS STATUS 201 CREATED"
    )
    @PostMapping("post")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {

        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category,HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET Category REST API",
            description = "GET category Rest api to get category into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTPS STATUS 200 OK"
    )
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId) {
        CategoryDto category = categoryService.getCategoryById(categoryId);

        return new ResponseEntity<>(category,HttpStatus.OK);

    }

    @Operation(
            summary = "GetALL Category REST API",
            description = "GET ALL category Rest api to getall category into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTPS STATUS 200 OK"
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {

       List<CategoryDto> categories = categoryService.getAllCategories();
       return ResponseEntity.ok(categories);
    }

    //build update category RestApi

    @Operation(
            summary = "update Category REST API",
            description = "update category Rest api to update category into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTPS STATUS 200 OK"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,@RequestBody CategoryDto categoryDto) {
        CategoryDto updatedCategory = categoryService.updateCategory(categoryId, categoryDto);
        return ResponseEntity.ok(updatedCategory);
    }

    @Operation(
            summary = "DELETE Category REST API",
            description = "DELETE category Rest api to delete category into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTPS STATUS 200 OK"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {

        categoryService.deleteCategory(categoryId);

        return ResponseEntity.ok("Deleted Category with id " + categoryId);
    }


}

