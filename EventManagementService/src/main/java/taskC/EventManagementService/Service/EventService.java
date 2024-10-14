package taskC.EventManagementService.Service;

import taskC.EventManagementService.Controllers.dto.VenueDTO;
import taskC.EventManagementService.Models.Event;
import taskC.EventManagementService.Models.Venue;
import taskC.EventManagementService.Repositories.EventRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final RestTemplate restTemplate;
    private final ApplicationEventPublisher applicationEventPublisher;

    EventService(EventRepository eventRepository, RestTemplate restTemplate, ApplicationEventPublisher applicationEventPublisher) {
        this.eventRepository = eventRepository;
        this.restTemplate = restTemplate;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event createEvent(Event newEvent) {
        return eventRepository.save(newEvent);
    }

    public Event getEvent(long id){
        return eventRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Event updateEvent(long id, Event updatedEvent){

        Event event = eventRepository.findById(id).orElseThrow(RuntimeException::new);
        event.setName(updatedEvent.getName());
        event.setDescription(updatedEvent.getDescription());
        event.setContact(updatedEvent.getContact());
        event.setAvailableVenues(updatedEvent.getAvailableVenues());
        return eventRepository.save(event);

    }

    public void deleteEvent(long id){eventRepository.deleteById(id);}

    public List<Long> getAvailableVenues1(long id){
        return eventRepository.findById(id).orElseThrow(RuntimeException::new).getAvailableVenues();
    }

    public List<Venue> getAvailableVenues(long eventId){
        final String url = "http://localhost:8080/venues/";
        List<Venue> venues = new ArrayList<>();
        List<Long> venueIds = eventRepository.findById(eventId).orElseThrow(RuntimeException::new).getAvailableVenues();

        for(Long id : venueIds){
            venues.add(restTemplate.getForObject(url + id, Venue.class));
        }
        return venues;
    }
    public Event setAvailableVenues(long id, long venueId){
        Event event = eventRepository.findById(id).orElseThrow(RuntimeException::new);

        if(event.getAvailableVenues().contains(venueId)){
            return event;
        }
        event.addAvailableVenues(venueId);
        return eventRepository.save(event);
    }

    public Event deleteAvailableVenue(long id, long venueId){
        Event event = eventRepository.findById(id).orElseThrow(RuntimeException::new);
        if(event.getAvailableVenues().contains(venueId)){
            event.getAvailableVenues().remove(venueId);
        return eventRepository.save(event);
       }
        return event;
    }

    public List<VenueDTO> getAllVenues(){
        final String url = "http://localhost:8080/venues";
        ResponseEntity<List<VenueDTO>> responseEntity =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<VenueDTO>>() {}
                );
        List<VenueDTO> venues = responseEntity.getBody();
        return venues.stream()
                .map(venue ->{
                    VenueDTO venueDTO = new VenueDTO();
                    venueDTO.setId(venue.getId());
                    venueDTO.setName(venue.getName());
                    venueDTO.setAddress(venue.getAddress());
                    venueDTO.setCapacity(venue.getCapacity());
                    venueDTO.setOpeningHours(venue.getOpeningHours());
                    venueDTO.setContact(venue.getContact());
                    venueDTO.setServices(venue.getServices());
                    venueDTO.setHasParking(venue.getHasParking());
                    venueDTO.setHasSeats(venue.getHasSeats());
                    venueDTO.setHasAccommodation(venue.getHasAccommodation());
                    return venueDTO;
                })
                .collect(Collectors.toList());
    }
}
