package com.online.shopping.responseDto;

import com.online.shopping.enums.ProductStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class CategoryResponseDto {

    public int id;

    public String categoryName;

    private LocalDateTime updatedAt;

    ProductStatus status;

}
