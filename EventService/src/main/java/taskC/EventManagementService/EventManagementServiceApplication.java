package taskC.EventManagementService;

import taskC.EventManagementService.Models.Contact;
import taskC.EventManagementService.Models.Event;
import taskC.EventManagementService.Repositories.ContactRepository;
import taskC.EventManagementService.Repositories.EventRepository;
import taskC.EventManagementService.Models.Venue;
import taskC.EventManagementService.Repositories.VenueRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EventManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner commandLineRunner(EventRepository eventRepository, VenueRepository venueRepository, ContactRepository contactRepository) throws Exception{
		return args -> {

			String[] openingHours = {
					"Monday: 10:30 - 22:00",
					"Tuesday: 10:30 - 22:00",
					"Wednesday: 10:30 - 22:00",
					"Thursday: 10:30 - 22:00",
					"Friday: 10:30 - 22:00",
					"Saturday: 10:30 - 22:00",
					"Sunday: 10:30 - 22:00",
			};

			Contact contact1 = new Contact();
			contact1.setName("John Doe");
			contact1.setEmail("john.doe@gmail.com");
			contact1.setPhone("1234567890");
			contactRepository.save(contact1);

			Contact contact2 = new Contact();
			contact2.setName("Kristian Reichmann");
			contact2.setEmail("kr290@uowmail.edu.au");
			contact2.setPhone("1122334455");
			contactRepository.save(contact2);

			Venue venue1 = new Venue();
			venue1.setName("Blah Blah");
			venue1.setAddress("King Kong Ding Dong Rd");
			venue1.setCapacity(15000);
			venue1.setOpeningHours(openingHours);
			venue1.setContact(contact1);
			venue1.setServices(new String[]{"Bar", "Dining", "Blah"});
			venue1.setHasParking(true);
			venue1.setHasSeats(true);
			venue1.setHasAccommodation(false);
			venueRepository.save(venue1);

			Venue venue2 = new Venue();
			venue2.setName("Computer Town");
			venue2.setAddress("123 Wingdang Rd");
			venue2.setCapacity(30000);
			venue2.setOpeningHours(openingHours);
			venue2.setContact(contact2);
			venue2.setServices(new String[]{"NOTHING"});
			venue2.setHasParking(true);
			venue2.setHasSeats(false);
			venue2.setHasAccommodation(false);
			venueRepository.save(venue2);

			Event event1 = new Event();
			event1.setName("Event1");
			event1.setDescription("Event1 Description");
			event1.setStartTime("12:30");
			event1.setEndTime("18:30");
			event1.setDuration(6);
			event1.setCapacity(10);
			event1.setAttendees(2);
			event1.setBudget(15000);
			event1.setIsFinished(false);
			event1.setIsCancelled(false);
			event1.setIsVirtual(false);
			event1.setIsAgeRestricted(true);
			if(event1.getIsAgeRestricted()) event1.setMinimumAge(18);
			event1.setContact(contact1);
			event1.addAvailableVenues(1L);
			eventRepository.save(event1);


			Event event2 = new Event();
			event2.setName("Event2");
			event2.setDescription("Event2 Description");
			event2.setStartTime("10:30");
			event2.setEndTime("14:30");
			event2.setDuration(4);
			event2.setCapacity(10);
			event2.setAttendees(2);
			event2.setBudget(15000);
			event2.setIsFinished(false);
			event2.setIsCancelled(false);
			event2.setIsVirtual(true);
			event2.setIsAgeRestricted(true);
			if(event2.getIsAgeRestricted()) event2.setMinimumAge(18);
			event2.setContact(contact2);
			event2.addAvailableVenues(2L);
			eventRepository.save(event2);
		};
	}
}
