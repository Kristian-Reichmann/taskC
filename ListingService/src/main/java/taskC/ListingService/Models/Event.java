package taskC.ListingService.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Event name cannot be blank")
    private String name;

    private String description;

    @NotBlank(message = "Event date cannot be blank")
    private String date; // Consider using LocalDate or LocalDateTime for better date handling

    @NotBlank(message = "Venue cannot be blank")
    private String venue;

    // Constructors
    public Event() {}

    public Event(String name, String description, String date, String venue) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.venue = venue;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
