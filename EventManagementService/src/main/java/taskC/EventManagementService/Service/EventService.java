package taskC.EventManagementService.Service;

import taskC.EventManagementService.Controllers.dto.EventDTO;
import taskC.EventManagementService.Controllers.dto.VenueDTO;
import taskC.EventManagementService.Models.Contact;
import taskC.EventManagementService.Models.Event;
import taskC.EventManagementService.Models.Venue;
import taskC.EventManagementService.Repositories.ContactRepository;
import taskC.EventManagementService.Repositories.EventRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import taskC.EventManagementService.Repositories.VenueRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final ContactRepository contactRepository;
    private final RestTemplate restTemplate;
    private final ApplicationEventPublisher applicationEventPublisher;

    EventService(EventRepository eventRepository, ContactRepository contactRepository , RestTemplate restTemplate, ApplicationEventPublisher applicationEventPublisher, VenueRepository venueRepository) {
        this.eventRepository = eventRepository;
        this.contactRepository = contactRepository;
        this.restTemplate = restTemplate;
        this.applicationEventPublisher = applicationEventPublisher;
        this.venueRepository = venueRepository;
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event createEvent(Event newEvent) {
        Contact contact = new Contact();
        contactRepository.save(newEvent.getContact());
        return eventRepository.save(newEvent);
    }

    public Event getEvent(long id){
        return eventRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    //Update the specified event
    public Event updateEvent(long id, Event updatedEvent){
        Event event = eventRepository.findById(id).orElseThrow(RuntimeException::new);
        Contact contact = new Contact();
        contactRepository.save(updatedEvent.getContact());
        event.setName(updatedEvent.getName());
        event.setDescription(updatedEvent.getDescription());
        event.setStartTime(updatedEvent.getStartTime());
        event.setEndTime(updatedEvent.getEndTime());
        event.setDuration(updatedEvent.getDuration());
        event.setCapacity(updatedEvent.getCapacity());
        event.setAttendees(updatedEvent.getAttendees());
        event.setMinimumAge(updatedEvent.getMinimumAge());
        event.setBudget(updatedEvent.getBudget());
        event.setIsFinished(updatedEvent.getIsFinished());
        event.setIsCancelled(updatedEvent.getIsCancelled());
        event.setIsVirtual(updatedEvent.getIsVirtual());
        event.setIsAgeRestricted(updatedEvent.getIsAgeRestricted());
        event.setContact(updatedEvent.getContact());
        event.setAvailableVenues(updatedEvent.getAvailableVenues());
        return eventRepository.save(event);
    }

    public void deleteEvent(long id){eventRepository.deleteById(id);}

    public List<Venue> getAvailableVenues(long id){
        List<Venue> venues = new ArrayList<>();
        List<Long> venueIds = eventRepository.findById(id).orElseThrow(RuntimeException::new).getAvailableVenues();
        System.out.println(venueIds);

        for(Long venueId : venueIds){
            venues.add(venueRepository.findById(venueId).orElseThrow(RuntimeException::new));
        }
        return venues;
    }

//    public List<Venue> getAvailableVenues(long eventId){
//        final String url = "http://localhost:8080/venues/";
//        List<Venue> venues = new ArrayList<>();
//        List<Long> venueIds = eventRepository.findById(eventId).orElseThrow(RuntimeException::new).getAvailableVenues();
//
//        for(Long id : venueIds){
//            venues.add(restTemplate.getForObject(url + id, Venue.class));
//        }
//        return venues;
//    }


//    public List<Event> fetchEvents(){
//        final String url = "http://localhost:8080/events";
//        List<Event> events = new ArrayList<>();
//        events.add(restTemplate.getForObject(url, Event.class));
//
//        return events;
//    }

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
