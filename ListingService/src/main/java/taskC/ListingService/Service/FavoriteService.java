package taskC.ListingService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskC.ListingService.Exceptions.ResourceNotFoundException;
import taskC.ListingService.Models.Favorite;
import taskC.ListingService.Repositories.FavoriteRepository;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public void removeFavorite(Long id) {
        if (!favoriteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Favorite not found with id: " + id);
        }
        favoriteRepository.deleteById(id);
    }
}
