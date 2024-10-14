package taskC.EventManagementService.Repositories;

import taskC.EventManagementService.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long>{}
