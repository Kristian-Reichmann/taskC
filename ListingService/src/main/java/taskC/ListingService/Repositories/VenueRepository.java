package taskC.ListingService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskC.ListingService.Models.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

}
