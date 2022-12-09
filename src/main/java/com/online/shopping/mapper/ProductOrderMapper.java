package com.online.shopping.mapper;

import com.online.shopping.entity.ProductOrder;
import com.online.shopping.requestDto.ProductOrderRequestDto;
import com.online.shopping.requestDto.ProductOrderRequestDto2;
import com.online.shopping.responseDto.ProductOrderResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderMapper {

    @Autowired
    private ModelMapper mapper;

    public ProductOrder convertDtoToEntity(ProductOrderRequestDto orderDetailRequestDto) {
        return new ProductOrder(orderDetailRequestDto.getQuantity());
    }

    public ProductOrder convertDtoToEntity(ProductOrderRequestDto2 orderDetailRequestDto) {
        return new ProductOrder(orderDetailRequestDto.getQuantity());
    }

    public ProductOrderResponseDto convertEntityToDto(ProductOrder orderDetails) {
        return mapper.map(orderDetails, ProductOrderResponseDto.class);
    }

}
