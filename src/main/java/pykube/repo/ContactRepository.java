package pykube.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pykube.net.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}