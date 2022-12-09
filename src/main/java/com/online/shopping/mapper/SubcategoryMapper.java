package com.online.shopping.mapper;

import com.online.shopping.entity.ProductSubcategory;
import com.online.shopping.requestDto.SubcategoryRequestDto;
import com.online.shopping.responseDto.SubcategoryResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryMapper {

    @Autowired
    private ModelMapper mapper;

    public ProductSubcategory convertDtoToEntity(SubcategoryRequestDto productSubcategoryDto) {
        return new ProductSubcategory(productSubcategoryDto.getSubcategoryName());
    }

    public SubcategoryResponseDto convertEntityToDto(ProductSubcategory productSubcategory) {
        return mapper.map(productSubcategory, SubcategoryResponseDto.class);
    }

}
