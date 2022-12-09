package com.online.shopping.controller;

import com.online.shopping.requestDto.CategoryRequestDto;
import com.online.shopping.responseDto.CategoryResponseDto;
import com.online.shopping.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryResponseDto> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @PreAuthorize("hasRole('ROLE_Customer')")
    @GetMapping("/{categoryId}")
    public CategoryResponseDto getSingleCategory(@PathVariable int categoryId) {
        return categoryService.getSingleCategory(categoryId);
    }

    @PreAuthorize("hasRole('ROLE_Manager')")
    @PostMapping
    public CategoryResponseDto addCategory(@Valid @RequestBody CategoryRequestDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    @PreAuthorize("hasRole('ROLE_Manager')")
    @PutMapping("/updateStatus/{categoryId}")
    public CategoryResponseDto updateCategoryStatus(@PathVariable int categoryId) {
        return categoryService.updateCategoryStatus(categoryId);
    }

    @PreAuthorize("hasRole('ROLE_Manager')")
    @DeleteMapping("/{categoryId}")
    public String removeCategory(@PathVariable int categoryId) {
        return categoryService.removeCategory(categoryId);
    }

}
