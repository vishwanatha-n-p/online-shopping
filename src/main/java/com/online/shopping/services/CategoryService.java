package com.online.shopping.services;

import com.online.shopping.constants.ErrorConstants;
import com.online.shopping.entity.ProductCategory;
import com.online.shopping.enums.ProductStatus;
import com.online.shopping.exception.ProductCategoryNotFoundException;
import com.online.shopping.mapper.CategoryMapper;
import com.online.shopping.mapper.SubcategoryMapper;
import com.online.shopping.repository.CategoryRepository;
import com.online.shopping.repository.SubcategoryRepository;
import com.online.shopping.requestDto.CategoryRequestDto;
import com.online.shopping.responseDto.CategoryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private SubcategoryMapper subcategoryMapper;

    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {
        Optional<ProductCategory> categoryRequest = categoryRepository.findById(categoryRequestDto.getId());
        if (!categoryRequest.isPresent()) {
            ProductCategory categoryResponse = categoryMapper.convertDtoToEntity(categoryRequestDto);
            categoryResponse.setStatus(ProductStatus.ACTIVE);
            return categoryMapper.convertEntityToDto(categoryRepository.save(categoryResponse));
        } else {
            return categoryMapper.convertEntityToDto(categoryRepository.save(categoryRequest.get()));
        }
    }

    public List<CategoryResponseDto> getAllCategory() {
        return categoryRepository.findAll().stream().map(category -> categoryMapper.convertEntityToDto(category)).collect(Collectors.toList());
    }

    public CategoryResponseDto getSingleCategory(int categoryId) {
        ProductCategory category = categoryRepository.findById(categoryId).orElseThrow(() -> new ProductCategoryNotFoundException(ErrorConstants.PRODUCT_CATEGORY_NOT_FOUND_ERROR + categoryId));
        return categoryMapper.convertEntityToDto(category);
    }

    public CategoryResponseDto updateCategoryStatus(int categoryId) {
        ProductCategory category = categoryRepository.findById(categoryId).orElseThrow(() -> new ProductCategoryNotFoundException(ErrorConstants.PRODUCT_CATEGORY_NOT_FOUND_ERROR + categoryId));
        category.setStatus(ProductStatus.INACTIVE);
        return categoryMapper.convertEntityToDto(categoryRepository.save(category));
    }

    public String removeCategory(int categoryId) {
        ProductCategory category = categoryRepository.findById(categoryId).orElseThrow(() -> new ProductCategoryNotFoundException(ErrorConstants.PRODUCT_CATEGORY_NOT_FOUND_ERROR + categoryId));
        categoryRepository.delete(category);
        return "Successfully deleted Product category, Where id:" + categoryId;
    }

}
