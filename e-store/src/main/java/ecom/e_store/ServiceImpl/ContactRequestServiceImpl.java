package ecom.e_store.ServiceImpl;

import ecom.e_store.constants.ApplicationConstants;
import ecom.e_store.dto.ContactRequestDto;
import ecom.e_store.dto.ContactResponseDto;
import ecom.e_store.entity.Contact;
import ecom.e_store.exception.ResourceNotFoundException;
import ecom.e_store.repository.ContactRequestRepository;
import ecom.e_store.service.ContactRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactRequestServiceImpl implements ContactRequestService {

    private final ContactRequestRepository contactRequestRepository;

    @Override
    public boolean saveContacts(ContactRequestDto contactRequestDto) {

        Contact contact = transformToEntity(contactRequestDto);
        //contact.setCreatedAt(Instant.now());
        //contact.setCreatedBy(contactRequestDto.getName());
        contactRequestRepository.save(contact);
        return true;
    }

    @Override
    public List<ContactResponseDto> getAllOpenMessages() {
        List<Contact>  contacts = contactRequestRepository.fetchByStatus(ApplicationConstants.OPEN_MESSAGE);
        return contacts.stream().map(this::mapToContactResponseDto).collect(Collectors.toList());
    }

    @Override
    public void updateMessageStatus(Long contactId, String status) {
        Contact contact = contactRequestRepository.findById(contactId).orElseThrow(
                () -> new ResourceNotFoundException("Contact","ContactID", contactId.toString()));
        contact.setStatus(status);
        contactRequestRepository.save(contact);
    }


    private ContactResponseDto mapToContactResponseDto(Contact contact) {
        ContactResponseDto contactResponseDto = new ContactResponseDto(
                contact.getId(), contact.getName(), contact.getEmail(), contact.getMobileNumber(),
                contact.getMessage(), contact.getStatus()
        );
        return contactResponseDto;
    }

    // Convert DTO to Entity class
    private Contact transformToEntity(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact);
        contact.setStatus(ApplicationConstants.OPEN_MESSAGE);
        return contact;
    }
}
