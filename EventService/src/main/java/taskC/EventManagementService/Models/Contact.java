package taskC.EventManagementService.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Contact {

    @Id @GeneratedValue
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "contact")
    private List<Venue> venue;

    @OneToMany(mappedBy = "contact")
    private List<Event> event;

    private String name;

    private String phone;

    private String email;

    //can add socials here too

    public Contact() {}

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

}
