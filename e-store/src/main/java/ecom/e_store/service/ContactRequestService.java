package ecom.e_store.service;

import ecom.e_store.dto.ContactRequestDto;
import ecom.e_store.dto.ContactResponseDto;
import java.util.List;

public interface ContactRequestService {

    boolean saveContacts(ContactRequestDto contactRequestDto);
    List<ContactResponseDto> getAllOpenMessages();
    void updateMessageStatus(Long contactId, String status);
}

