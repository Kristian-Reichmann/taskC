package taskC.ListingService.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taskC.ListingService.Models.Event;
import taskC.ListingService.Repositories.EventRepository;

import java.time.LocalDate;

@SpringBootTest
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @BeforeEach
    public void setUp() {
        // Clear any existing data to ensure a clean test environment
        eventRepository.deleteAll();

        // Create and save test events
        Event event1 = new Event();
        event1.setName("Spring Boot Workshop");
        event1.setDescription("Learn the basics of Spring Boot.");
        event1.setDate("10/10/2024");
        event1.setVenue("Online");

        Event event2 = new Event();
        event2.setName("Java Conference");
        event2.setDescription("A conference about all things Java.");
        event2.setDate("20/10/2024");
        event2.setVenue("New York");

        eventRepository.save(event1);
        eventRepository.save(event2);
    }

    @Test
    public void testPrintAllEvents() {
        // This will print all events in the console
        eventService.printAllEventDetails();
    }

    @Test
    public void testPrintEventById() {
        // This will print event details by ID (e.g., ID = 1)
        eventService.printEventDetailsById(1L);
    }
}

