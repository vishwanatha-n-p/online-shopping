package com.online.shopping.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class CurrencyRequestDto {

    int id;

    @NotEmpty(message = "Enter Country")
    String country;

    @NotEmpty(message = "Enter currency code")
    String currencyCode;

}
