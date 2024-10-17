package taskC.ListingService.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import taskC.ListingService.Models.Event;
import taskC.ListingService.Service.EventService;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventWebController {

    @Autowired
    private EventService eventService;

    /**
     * Display a list of all events.
     */
    @GetMapping
    public String listEvents(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "events"; // Corresponds to events.html
    }

    /**
     * Show the form to create a new event.
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        return "create_event"; // Corresponds to create_event.html
    }

    /**
     * Handle the submission of the create event form.
     */
    @PostMapping("/create")
    public String createEvent(@ModelAttribute("event") Event event) {
        eventService.createEvent(event);
        return "redirect:/events";
    }

    /**
     * Show the form to edit an existing event.
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Event event = eventService.getEventById(id); // Ensure this method exists
        model.addAttribute("event", event);
        return "edit_event"; // Corresponds to edit_event.html
    }

    /**
     * Handle the submission of the edit event form.
     */
    @PostMapping("/edit/{id}")
    public String updateEvent(@PathVariable("id") Long id, @ModelAttribute("event") Event event) {
        eventService.updateEvent(id, event);
        return "redirect:/events";
    }

    /**
     * Delete an event.
     */
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }

    /**
     * View details of a specific event.
     */
    @GetMapping("/{id}")
    public String viewEvent(@PathVariable("id") Long id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "event"; // Corresponds to event.html
    }
}

