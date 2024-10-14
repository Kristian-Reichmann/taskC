package taskC.EventManagementService.Models;

import jakarta.persistence.*;

@Entity
public class Venue {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String address;
    private int capacity; //amount of people it can have
    private String[] openingHours;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    private String[] services;
    private boolean hasParking;
    private boolean hasSeats;
    private boolean hasAccommodation;

    public Venue(){}

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}

    public String[] getOpeningHours() {return openingHours;}
    public void setOpeningHours(String[] openingHours) {this.openingHours = openingHours;}

    public Contact getContact(){return contact;}
    public void setContact(Contact contact){this.contact = contact;}

    public String[] getServices() {return services;}
    public void setServices(String[] services) {this.services = services;}

    public boolean getHasParking() {return hasParking;}
    public void setHasParking(boolean hasParking) {this.hasParking = hasParking;}

    public boolean getHasSeats() {return hasSeats;}
    public void setHasSeats(boolean hasSeats) {this.hasSeats = hasSeats;}

    public boolean getHasAccommodation() {return hasAccommodation;}
    public void setHasAccommodation(boolean hasAccommodation){this.hasAccommodation = hasAccommodation;}

}
