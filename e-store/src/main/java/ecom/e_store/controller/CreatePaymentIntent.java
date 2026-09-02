package ecom.e_store.controller;


import ecom.e_store.dto.PaymentRequestDto;
import ecom.e_store.dto.PaymentResponseDto;
import ecom.e_store.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/payment")
@AllArgsConstructor
public class CreatePaymentIntent {
    private final PaymentService paymentService;

    @PostMapping("/create-payment-intent")
    public ResponseEntity<PaymentResponseDto> createPaymentIntent (@RequestBody PaymentRequestDto paymentRequestDto) {
        PaymentResponseDto paymentResponseDto = paymentService.createPaymentIntent(paymentRequestDto);
        return ResponseEntity.ok(paymentResponseDto);
    }
}
