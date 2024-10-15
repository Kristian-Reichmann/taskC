package taskC.EventManagementService.Controllers;

import taskC.EventManagementService.Models.Contact;
import taskC.EventManagementService.Models.Venue;
import taskC.EventManagementService.Repositories.ContactRepository;
import taskC.EventManagementService.Repositories.VenueRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VenueController {
    private final VenueRepository venueRepository;
    private final ContactRepository contactRepository;

    public VenueController(VenueRepository venueRepository, ContactRepository contactRepository) {
        this.venueRepository = venueRepository;
        this.contactRepository = contactRepository;
    }

    @GetMapping("/venues")
    public List<Venue> getAllVenues() {return venueRepository.findAll();}

    //Create a new venue if there is no venue with the same address
    @PostMapping("/venues")
    public Venue createVenue(@RequestBody Venue venue) {
        if(venueRepository.findByAddress(venue.getAddress()) == null) {
            if (contactRepository.findById(venue.getContact().getId()).isEmpty()) {
                contactRepository.save(venue.getContact());
            }
            venue.setContact(contactRepository.findById(venue.getContact().getId()).orElseThrow(RuntimeException::new));
            return venueRepository.save(venue);
        }
        return venue;
    }

    @GetMapping("/venues/{id}")
    public Venue getVenueById(@PathVariable long id) {return venueRepository.findById(id).orElseThrow(RuntimeException::new);}

    @PostMapping("/venues/{id}")
    public Venue updateVenueById(@PathVariable long id, @RequestBody Venue venue) {
        if(contactRepository.findById(venue.getContact().getId()).isEmpty() ){
            contactRepository.save(venue.getContact());
        }else{
            Contact newContact = contactRepository.findById(venue.getContact().getId()).orElseThrow(RuntimeException::new);
            newContact.setId(venue.getContact().getId());
            newContact.setName(venue.getContact().getName());
            newContact.setEmail(venue.getContact().getEmail());
            newContact.setPhone(venue.getContact().getPhone());
            contactRepository.save(newContact);
        }

        Venue oldVenue = venueRepository.findById(id).orElseThrow(RuntimeException::new);
        oldVenue.setName(venue.getName());
        oldVenue.setAddress(venue.getAddress());
        oldVenue.setCapacity(venue.getCapacity());
        oldVenue.setOpeningHours(venue.getOpeningHours());
        oldVenue.setContact(contactRepository.findById(venue.getContact().getId()).orElseThrow(RuntimeException::new));
        oldVenue.setServices(venue.getServices());
        oldVenue.setHasParking(venue.getHasParking());
        oldVenue.setHasSeats(venue.getHasSeats());
        oldVenue.setHasAccommodation(venue.getHasAccommodation());

        return venueRepository.save(venue);
    }

    @DeleteMapping("/venues/{id}")
    public void deleteVenueById(@PathVariable long id) {venueRepository.deleteById(id);}
}
