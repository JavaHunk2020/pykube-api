package pykube.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pykube.net.Contact;
import pykube.service.ContactService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/save")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact savedContact = contactService.saveContact(contact);
        return ResponseEntity.ok(savedContact);
    }

    @GetMapping("/get/contact/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
    	System.out.println(id);
        return contactService.getContactById(id)
                .map(contact -> ResponseEntity.ok(contact))
                .orElse(ResponseEntity.notFound().build());
    }
}