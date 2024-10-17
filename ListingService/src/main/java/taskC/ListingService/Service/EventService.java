package taskC.ListingService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskC.ListingService.Exceptions.ResourceNotFoundException;
import taskC.ListingService.Models.Event;
import taskC.ListingService.Repositories.EventRepository;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    /**
     * Retrieve all events.
     */
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Create a new event.
     */
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    /**
     * Retrieve an event by its ID.
     */
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
    }

    /**
     * Update an existing event.
     */
    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);
        event.setName(eventDetails.getName());
        event.setDescription(eventDetails.getDescription());
        event.setDate(eventDetails.getDate());
        event.setVenue(eventDetails.getVenue());
        return eventRepository.save(event);
    }

    /**
     * Delete an event.
     */
    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }

     public void printAllEventDetails() {
        List<Event> events = getAllEvents();
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            for (Event event : events) {
                System.out.println("Event ID: " + event.getId());
                System.out.println("Name: " + event.getName());
                System.out.println("Description: " + event.getDescription());
                System.out.println("Date: " + event.getDate());
                System.out.println("Venue: " + event.getVenue());
                System.out.println("---------------------------------");
            }
        }
    }

    public void printEventDetailsById(Long id) {
        Event event = getEventById(id);
        System.out.println("Event ID: " + event.getId());
        System.out.println("Name: " + event.getName());
        System.out.println("Description: " + event.getDescription());
        System.out.println("Date: " + event.getDate());
        System.out.println("Venue: " + event.getVenue());
        System.out.println("---------------------------------");
    }
}

