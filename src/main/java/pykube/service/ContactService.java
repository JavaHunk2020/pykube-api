package pykube.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pykube.net.Contact;
import pykube.repo.ContactRepository;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }
}
