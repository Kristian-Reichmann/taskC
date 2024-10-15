package taskC.ListingService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskC.ListingService.Models.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
