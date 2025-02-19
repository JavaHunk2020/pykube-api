/*
 * package com.pykube.controller;
 * 
 * 
 * import java.util.List; import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.pykube.net.Contact; import com.pykube.service.ContactService;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/contacts")
 * 
 * @CrossOrigin(origins = "*") public class ContactController {
 * 
 * @Autowired private ContactService contactService;
 * 
 * @GetMapping("/hello") public Map<String,String> getContactssa(){ return
 * Map.of("Name","Nagendra Kumar"); }
 * 
 * 
 * @GetMapping public ResponseEntity<List<Contact>> getContacts() { return
 * ResponseEntity.ok(contactService.findAll()); }
 * 
 * @PostMapping public ResponseEntity<Contact> createContact(@RequestBody
 * Contact contact) { Contact savedContact =
 * contactService.saveContact(contact); return ResponseEntity.ok(savedContact);
 * }
 * 
 * @GetMapping("/{id}") public ResponseEntity<Contact>
 * getContactById(@PathVariable Long id) { System.out.println(id); return
 * contactService.getContactById(id) .map(contact -> ResponseEntity.ok(contact))
 * .orElse(ResponseEntity.notFound().build()); } }
 */