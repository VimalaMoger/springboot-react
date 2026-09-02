package ecom.e_store.controller;

import ecom.e_store.dto.ContactDetailsDto;
import ecom.e_store.dto.ContactRequestDto;
import ecom.e_store.service.ContactRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactRequestController {
    private final ContactRequestService contactRequestService;
    private final ContactDetailsDto contactDetailsDto;

    @PostMapping
    public ResponseEntity<String> saveContacts(@Valid @RequestBody ContactRequestDto contactRequestDto) {

        //Thread.sleep(3000);
        contactRequestService.saveContacts(contactRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Request processed successfully");
    }

    @GetMapping
    public ResponseEntity<ContactDetailsDto> getContactDetails() {
        return ResponseEntity.ok(contactDetailsDto);
    }
}
