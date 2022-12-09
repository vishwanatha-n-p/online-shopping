package com.online.shopping.controller;

import com.online.shopping.requestDto.SubcategoryRequestDto;
import com.online.shopping.responseDto.SubcategoryResponseDto;
import com.online.shopping.services.SubcategoryService;
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
@RequestMapping("/subcategories")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @PreAuthorize("hasRole('ROLE_Customer') or hasRole('ROLE_Manager')")
    @GetMapping
    public List<SubcategoryResponseDto> getAllSubcategory() {
        return subcategoryService.getAllSubcategory();
    }

    @PreAuthorize("hasRole('ROLE_Customer')")
    @GetMapping("/{subcategoryId}")
    public SubcategoryResponseDto getSingleSubcategory(@PathVariable int subcategoryId) {
        return subcategoryService.getSingleSubcategory(subcategoryId);
    }

    @PreAuthorize("hasRole('ROLE_Customer')")
    @GetMapping("/categories/{categoryId}")
    public List<SubcategoryResponseDto> getParticularCategorySubcategories(@PathVariable int categoryId) {
        return subcategoryService.getParticularCategorySubcategories(categoryId);
    }

    @PreAuthorize("hasRole('ROLE_Manager')")
    @PostMapping
    public SubcategoryResponseDto addSubcategory(@Valid @RequestBody SubcategoryRequestDto subcategoryDto) {
        return subcategoryService.addSubcategory(subcategoryDto);
    }

    @PreAuthorize("hasRole('ROLE_Manager')")
    @PutMapping("/updateStatus/{subcategoryId}")
    public SubcategoryResponseDto updateSubcategoryStatus(@PathVariable int subcategoryId) {
        return subcategoryService.updateSubcategoryStatus(subcategoryId);
    }

    @PreAuthorize("hasRole('ROLE_Manager')")
    @DeleteMapping("/{subcategoryId}")
    public String removeSubcategory(@PathVariable int subcategoryId) {
        return subcategoryService.removeSubcategory(subcategoryId);
    }

}
