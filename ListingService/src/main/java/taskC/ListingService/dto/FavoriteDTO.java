package taskC.ListingService.dto;

import jakarta.validation.constraints.NotNull;

public class FavoriteDTO {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Event ID cannot be null")
    private Long eventId;

    // Constructors
    public FavoriteDTO() {}

    public FavoriteDTO(Long userId, Long eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
