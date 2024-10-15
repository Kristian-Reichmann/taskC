package taskC.ListingService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskC.ListingService.Models.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

}
