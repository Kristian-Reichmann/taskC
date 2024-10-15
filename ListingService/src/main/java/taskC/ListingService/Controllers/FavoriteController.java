package taskC.ListingService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taskC.ListingService.dto.FavoriteDTO;
import taskC.ListingService.Models.Favorite;
import taskC.ListingService.Service.FavoriteService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping
    public List<Favorite> getAllFavorites() {
        return favoriteService.getAllFavorites();
    }

    @PostMapping
    public ResponseEntity<Favorite> addFavorite(@Valid @RequestBody FavoriteDTO favoriteDTO) {
        Favorite favorite = new Favorite();
        favorite.setUserId(favoriteDTO.getUserId());
        favorite.setEventId(favoriteDTO.getEventId());
        Favorite createdFavorite = favoriteService.addFavorite(favorite);
        return ResponseEntity.ok(createdFavorite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long id) {
        favoriteService.removeFavorite(id);
        return ResponseEntity.noContent().build();
    }
}
