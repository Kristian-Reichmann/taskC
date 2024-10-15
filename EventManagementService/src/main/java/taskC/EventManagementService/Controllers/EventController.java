package taskC.EventManagementService.Controllers;

import taskC.EventManagementService.Controllers.dto.VenueDTO;
import taskC.EventManagementService.Controllers.dto.EventDTO;
import taskC.EventManagementService.Models.Event;
import taskC.EventManagementService.Service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    //List all events
    @GetMapping("/events")
    List<EventDTO> allEvents() {
        return eventService.getAllEvents()
                .stream()
                .map(event -> {
                    EventDTO eventDTO = new EventDTO();
                    eventDTO.setId(event.getId());
                    eventDTO.setName(event.getName());
                    eventDTO.setDescription(event.getDescription());
                    eventDTO.setStartTime(event.getStartTime());
                    eventDTO.setEndTime(event.getEndTime());
                    eventDTO.setDuration(event.getDuration());
                    eventDTO.setCapacity(event.getCapacity());
                    eventDTO.setAttendees(event.getAttendees());
                    eventDTO.setMinimumAge(event.getMinimumAge());
                    eventDTO.setBudget(event.getBudget());
                    eventDTO.setIsFinished(event.getIsFinished());
                    eventDTO.setIsCancelled(event.getIsCancelled());
                    eventDTO.setIsVirtual(event.getIsVirtual());
                    eventDTO.setIsAgeRestricted(event.getIsAgeRestricted());
                    eventDTO.setContact(event.getContact());
                    eventDTO.setAvailableVenues(event.getAvailableVenues());
                    return eventDTO;
                }).collect(Collectors.toList());
    }

    //Create a new event - There's no way to avoid duplication as id auto-generated if it's left out in the request body
    @PostMapping("/events")
    EventDTO createEvent(@RequestBody Event newEvent) {
        Event event = eventService.createEvent(newEvent);
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setStartTime(event.getStartTime());
        eventDTO.setEndTime(event.getEndTime());
        eventDTO.setDuration(event.getDuration());
        eventDTO.setCapacity(event.getCapacity());
        eventDTO.setAttendees(event.getAttendees());
        eventDTO.setMinimumAge(event.getMinimumAge());
        eventDTO.setBudget(event.getBudget());
        eventDTO.setIsFinished(event.getIsFinished());
        eventDTO.setIsCancelled(event.getIsCancelled());
        eventDTO.setIsVirtual(event.getIsVirtual());
        eventDTO.setIsAgeRestricted(event.getIsAgeRestricted());
        eventDTO.setContact(event.getContact());
        eventDTO.setAvailableVenues(event.getAvailableVenues());
        return eventDTO;
    }

    //List the specified event
    @GetMapping("/events/{id}")
    EventDTO getEvent(@PathVariable long id) {

        EventDTO eventDTO = new EventDTO();
        Event event = eventService.getEvent(id);
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setStartTime(event.getStartTime());
        eventDTO.setEndTime(event.getEndTime());
        eventDTO.setDuration(event.getDuration());
        eventDTO.setCapacity(event.getCapacity());
        eventDTO.setAttendees(event.getAttendees());
        eventDTO.setMinimumAge(event.getMinimumAge());
        eventDTO.setBudget(event.getBudget());
        eventDTO.setIsFinished(event.getIsFinished());
        eventDTO.setIsCancelled(event.getIsCancelled());
        eventDTO.setIsVirtual(event.getIsVirtual());
        eventDTO.setIsAgeRestricted(event.getIsAgeRestricted());
        eventDTO.setContact(event.getContact());
        eventDTO.setAvailableVenues(event.getAvailableVenues());
        return eventDTO;
    }

    //Update the specified event
    @PostMapping("/events/{id}")
    EventDTO updateEvent(@PathVariable long id, @RequestBody Event updatedEvent) {
        Event event = eventService.updateEvent(id, updatedEvent);
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setStartTime(event.getStartTime());
        eventDTO.setEndTime(event.getEndTime());
        eventDTO.setDuration(event.getDuration());
        eventDTO.setCapacity(event.getCapacity());
        eventDTO.setAttendees(event.getAttendees());
        eventDTO.setMinimumAge(event.getMinimumAge());
        eventDTO.setBudget(event.getBudget());
        eventDTO.setIsFinished(event.getIsFinished());
        eventDTO.setIsCancelled(event.getIsCancelled());
        eventDTO.setIsVirtual(event.getIsVirtual());
        eventDTO.setIsAgeRestricted(event.getIsAgeRestricted());
        eventDTO.setContact(event.getContact());
        eventDTO.setAvailableVenues(event.getAvailableVenues());
        return eventDTO;
    }

    //Delete the specified event
    @DeleteMapping("/events/{id}")
    void deleteEvent(@PathVariable long id) {
        eventService.deleteEvent(id);
    }


    //Add a venue as an event host
    @PostMapping("/events/{id}/venues/{venueId}")
    EventDTO setEventVenue(@PathVariable long id, @PathVariable long venueId) {
        Event event = eventService.setAvailableVenues(id, venueId);
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setStartTime(event.getStartTime());
        eventDTO.setEndTime(event.getEndTime());
        eventDTO.setDuration(event.getDuration());
        eventDTO.setCapacity(event.getCapacity());
        eventDTO.setAttendees(event.getAttendees());
        eventDTO.setMinimumAge(event.getMinimumAge());
        eventDTO.setBudget(event.getBudget());
        eventDTO.setIsFinished(event.getIsFinished());
        eventDTO.setIsCancelled(event.getIsCancelled());
        eventDTO.setIsVirtual(event.getIsVirtual());
        eventDTO.setIsAgeRestricted(event.getIsAgeRestricted());
        eventDTO.setContact(event.getContact());
        eventDTO.setAvailableVenues(event.getAvailableVenues());
        return eventDTO;
    }

    // Remove specified venue hosting the event
    @DeleteMapping("/events/{id}/venues/{venueId}")
    EventDTO deleteEventVenue(@PathVariable long id, @PathVariable long venueId) {
        Event event = eventService.deleteAvailableVenue(id, venueId);
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setStartTime(event.getStartTime());
        eventDTO.setEndTime(event.getEndTime());
        eventDTO.setDuration(event.getDuration());
        eventDTO.setCapacity(event.getCapacity());
        eventDTO.setAttendees(event.getAttendees());
        eventDTO.setMinimumAge(event.getMinimumAge());
        eventDTO.setBudget(event.getBudget());
        eventDTO.setIsFinished(event.getIsFinished());
        eventDTO.setIsCancelled(event.getIsCancelled());
        eventDTO.setIsVirtual(event.getIsVirtual());
        eventDTO.setIsAgeRestricted(event.getIsAgeRestricted());
        eventDTO.setContact(event.getContact());
        eventDTO.setAvailableVenues(event.getAvailableVenues());
        return eventDTO;
    }

    //Returns all venues that are hosting this event
    @GetMapping("/events/{id}/venues")
    List<VenueDTO> getEventVenue(@PathVariable long id) {
        return eventService.getAvailableVenues(id)
                .stream()
                .map(venue -> {
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
                }).collect(Collectors.toList());
    }

    //get all venues
    @GetMapping("/events/venues")
    List<VenueDTO> getAllVenues() {
        return eventService.getAllVenues();
    }
}
