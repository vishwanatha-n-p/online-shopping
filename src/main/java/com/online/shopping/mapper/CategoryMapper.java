package com.online.shopping.mapper;

import com.online.shopping.responseDto.CategoryResponseDto;
import com.online.shopping.requestDto.CategoryRequestDto;
import com.online.shopping.entity.ProductCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    @Autowired
    private ModelMapper mapper;

    public ProductCategory convertDtoToEntity(CategoryRequestDto productCategoryDto) {
        return mapper.map(productCategoryDto, ProductCategory.class);
    }

    public CategoryResponseDto convertEntityToDto(ProductCategory productCategory) {
        return mapper.map(productCategory, CategoryResponseDto.class);
    }

}
