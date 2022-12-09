package com.online.shopping.mapper;

import com.online.shopping.entity.Payment;
import com.online.shopping.requestDto.PaymentRequestDto;
import com.online.shopping.responseDto.PaymentResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    @Autowired
    private ModelMapper mapper;

    public Payment createPaymentEntity(PaymentRequestDto paymentRequestDto) {
        return new Payment();
    }

    public PaymentResponseDto convertEntityToDto(Payment payment) {
        return mapper.map(payment, PaymentResponseDto.class);
    }

}
