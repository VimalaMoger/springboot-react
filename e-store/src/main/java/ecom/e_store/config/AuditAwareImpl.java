package ecom.e_store.config;

import ecom.e_store.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
    @Bean
    public Optional<String> getCurrentAuditor () {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            return Optional.of("Anonymous User");
        }
        Object principal = authentication.getPrincipal();
        String username;
        if(principal instanceof Customer customer){
            username = customer.getEmail();
        } else {
            username = principal.toString();
        }
        return Optional.of(username);
    }
}
