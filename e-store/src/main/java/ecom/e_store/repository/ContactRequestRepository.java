package ecom.e_store.repository;

import ecom.e_store.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ContactRequestRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByStatus(String status);

    @Query(name = "Contact.findStatus")
    List<Contact> fetchByStatus(String status);
}
