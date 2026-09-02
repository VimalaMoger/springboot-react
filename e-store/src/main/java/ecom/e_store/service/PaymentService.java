package ecom.e_store.service;

import ecom.e_store.dto.PaymentRequestDto;
import ecom.e_store.dto.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto createPaymentIntent(PaymentRequestDto paymentRequestDto);
}
