package ecom.e_store;

import ecom.e_store.dto.ContactDetailsDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@EnableConfigurationProperties(value = {ContactDetailsDto.class})
public class EStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EStoreApplication.class, args);
	}

}
