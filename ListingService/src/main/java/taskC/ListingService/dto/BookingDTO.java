package taskC.ListingService.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class BookingDTO {

    @NotNull(message = "Event ID cannot be null")
    private Long eventId;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Booking date cannot be null")
    private LocalDateTime bookingDate;

    // Constructors
    public BookingDTO() {}

    public BookingDTO(Long eventId, Long userId, LocalDateTime bookingDate) {
        this.eventId = eventId;
        this.userId = userId;
        this.bookingDate = bookingDate;
    }

    // Getters and Setters

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
