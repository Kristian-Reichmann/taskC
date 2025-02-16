package taskC.ListingService.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Event ID cannot be null")
    private Long eventId;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Booking date cannot be null")
    private LocalDateTime bookingDate;

    // Constructors
    public Booking() {}

    public Booking(Long eventId, Long userId, LocalDateTime bookingDate) {
        this.eventId = eventId;
        this.userId = userId;
        this.bookingDate = bookingDate;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}
