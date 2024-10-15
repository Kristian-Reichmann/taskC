package taskC.EventManagementService.Controllers.dto;

import taskC.EventManagementService.Models.Contact;

import java.util.ArrayList;
import java.util.List;

public class EventDTO {
    private long id;
    private Contact contact;
    private String name;
    private String description;
    private String startTime;
    private String endTime;
    private int duration;
    private int capacity; //total number of tickets available
    private int attendees; //number of people attending event
    private int minimumAge;
    private double budget;
    private boolean isFinished;
    private boolean isCancelled;
    private boolean isVirtual;
    private boolean isAgeRestricted;
    private List<Long> availableVenues = new ArrayList<>();

    public EventDTO() {}

    public void setId(long id) {this.id = id;}
    public long getId() {return id;}

    public void setContact(Contact contact) {this.contact = contact;}
    public Contact getContact() {return contact;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setDescription(String description) {this.description = description;}
    public String getDescription() {return description;}

    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getStartTime() { return startTime; }

    public void setEndTime(String endTime) { this.endTime = endTime; }
    public String getEndTime() { return endTime; }

    public void setDuration(int duration) { this.duration = duration; }
    public int getDuration() { return duration; }

    public void setCapacity(int capacity) { this.capacity = capacity; }
    public int getCapacity() { return capacity; }

    public void setAttendees(int attendees) { this.attendees = attendees; }
    public int getAttendees() { return attendees; }

    public void setMinimumAge(int minimumAge) { this.minimumAge = minimumAge; }
    public int getMinimumAge() { return minimumAge; }

    public void setBudget(double budget) { this.budget = budget; }
    public double getBudget() { return budget; }

    public void setIsFinished(boolean isFinished) { this.isFinished = isFinished; }
    public boolean getIsFinished() { return isFinished; }

    public void setIsCancelled(boolean isCancelled) { this.isCancelled = isCancelled; }
    public boolean getIsCancelled() { return isCancelled; }

    public void setIsVirtual(boolean isVirtual) { this.isVirtual = isVirtual; }
    public boolean getIsVirtual() { return isVirtual; }

    public void setIsAgeRestricted(boolean isAgeRestricted) { this.isAgeRestricted = isAgeRestricted; }
    public boolean getIsAgeRestricted() { return isAgeRestricted; }

    public void setAvailableVenues(List<Long> availableVenues) {this.availableVenues = availableVenues;}
    public List<Long> getAvailableVenues() {return availableVenues;}
}
