package ecom.e_store.entity;

import jakarta.persistence.*;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "CONTACTS")
@NamedQuery(name="Contact.findStatus", query = "SELECT c FROM Contact c WHERE c.status=:status")
//@NamedNativeQuery(name="Contact.findByStatus", query = "SELECT * FROM contacts WHERE status=:status", resultClass = Contact.class)
public class Contact extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "MOBILE_NUMBER", nullable = false, length = 15)
    private String mobileNumber;

    @Column(name = "MESSAGE", nullable = false, length = 500)
    private String message;

    @Column(name = "status", nullable = false, length = 50)
    private String status;
}
