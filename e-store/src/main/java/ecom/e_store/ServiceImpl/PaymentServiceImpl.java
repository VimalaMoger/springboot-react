package ecom.e_store.ServiceImpl;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import ecom.e_store.dto.PaymentRequestDto;
import ecom.e_store.dto.PaymentResponseDto;
import ecom.e_store.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentResponseDto createPaymentIntent(PaymentRequestDto paymentRequestDto) {
        try {
            PaymentIntentCreateParams createParams = PaymentIntentCreateParams.builder()
                    .setAmount(paymentRequestDto.getAmount())
                    .setCurrency(paymentRequestDto.getCurrency())
                    .addPaymentMethodType("card").build();
            PaymentIntent paymentIntent = PaymentIntent.create(createParams);
            return new PaymentResponseDto(paymentIntent.getClientSecret());
        } catch (StripeException exception) {
            throw new RuntimeException("Failed to create payment intent", exception);
        }
    }
}
