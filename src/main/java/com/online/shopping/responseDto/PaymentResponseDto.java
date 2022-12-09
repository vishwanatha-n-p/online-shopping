package com.online.shopping.responseDto;

import com.online.shopping.entity.CustomerDetail;
import com.online.shopping.entity.PaymentMode;
import com.online.shopping.enums.PaymentStatus;
import com.online.shopping.enums.ProductStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponseDto {

    int id;

    PaymentMode paymentMode;

    Long amount;

    LocalDateTime paymentDate;

    PaymentStatus paymentStatus;

    CustomerDetail customerDetail;

}
