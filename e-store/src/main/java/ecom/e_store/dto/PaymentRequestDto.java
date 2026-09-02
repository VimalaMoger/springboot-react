package ecom.e_store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDto {
        private Long amount;
        private String currency;
}
