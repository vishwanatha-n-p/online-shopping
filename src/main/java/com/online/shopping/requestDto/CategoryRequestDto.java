package com.online.shopping.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class CategoryRequestDto {

    private int id;

    @NotNull(message = "Enter Category name")
    private String categoryName;

}
