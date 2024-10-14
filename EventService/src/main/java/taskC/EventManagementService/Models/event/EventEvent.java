package taskC.EventManagementService.Models.event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class EventEvent {
    @Id @GeneratedValue
    private long appEventId;

    @Column
    private String appEventName;

    @Column
    private long eventId;

    @Column
    private long venueId;
}
