package taskC.EventManagementService.Controllers;

import taskC.EventManagementService.Models.Venue;
import taskC.EventManagementService.Repositories.VenueRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VenueController {
    private final VenueRepository venueRepository;

    public VenueController(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @GetMapping("/venues")
    public List<Venue> getAllVenues() {return venueRepository.findAll();}

    @PostMapping("/venues")
    public Venue addVenue(@RequestBody Venue venue) {return venueRepository.save(venue);}

    @GetMapping("/venues/{id}")
    public Venue getVenueById(@PathVariable long id) {return venueRepository.findById(id).orElseThrow(RuntimeException::new);}

    @PostMapping("/venues/{id}")
    public Venue updateVenueById(@PathVariable long id, @RequestBody Venue venue) {return venueRepository.save(venue);}

    @DeleteMapping("/venues/{id}")
    public void deleteVenueById(@PathVariable long id) {venueRepository.deleteById(id);}
}
