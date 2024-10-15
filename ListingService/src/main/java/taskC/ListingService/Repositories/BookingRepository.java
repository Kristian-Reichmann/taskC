package taskC.ListingService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskC.ListingService.Models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
