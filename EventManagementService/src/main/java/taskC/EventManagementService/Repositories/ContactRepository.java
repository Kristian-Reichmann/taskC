package taskC.EventManagementService.Repositories;

import taskC.EventManagementService.Models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long>{}