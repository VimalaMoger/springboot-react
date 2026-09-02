package ecom.e_store.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("contact")
public record ContactDetailsDto(String phone, String email, String address) {
}
