package taskC.EventManagementService.Repositories;

import taskC.EventManagementService.Models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    Venue findByAddress(String address);
}
