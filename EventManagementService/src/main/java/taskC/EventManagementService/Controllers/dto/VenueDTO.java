package taskC.EventManagementService.Controllers.dto;

import taskC.EventManagementService.Models.Contact;

public class VenueDTO {
    private long id;
    private String name;
    private String address;
    private int capacity;
    private String[] openingHours;
    private Contact contact;
    private String[] services;
    private boolean hasParking;
    private boolean hasSeats;
    private boolean hasAccommodation;

    public VenueDTO() {}

    public void setId(long id) {this.id = id;}
    public long getId() {return id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setAddress(String address) {this.address = address;}
    public String getAddress() {return address;}

    public void setCapacity(int capacity) {this.capacity = capacity;}
    public int getCapacity() {return capacity;}

    public void setHasParking(boolean hasParking) {this.hasParking = hasParking;}
    public boolean getHasParking() {return hasParking;}

    public void setHasSeats(boolean hasSeats) {this.hasSeats = hasSeats;}
    public boolean getHasSeats() {return hasSeats;}

    public void setOpeningHours(String[] openingHours) {this.openingHours = openingHours;}
    public String[] getOpeningHours() {return openingHours;}

    public void setContact(Contact contact) {this.contact = contact;}
    public Contact getContact() {return contact;}

    public void setServices(String[] services) {this.services = services;}
    public String[] getServices() {return services;}

    public void setHasAccommodation(boolean hasAccommodation) {this.hasAccommodation = hasAccommodation;}
    public boolean getHasAccommodation() {return hasAccommodation;}

}
