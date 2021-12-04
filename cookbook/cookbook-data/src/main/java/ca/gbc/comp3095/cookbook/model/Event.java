package ca.gbc.comp3095.cookbook.model;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event extends BaseEntity{

    @Id // Id - primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // PROPERTIES
    private String eventName;

    @Lob // annotation tells database to store the property as a large object
    private String eventDetails;

    // RELATIONSHIPS
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User eventUser;

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public User getEventUser() {
        return eventUser;
    }

    public void setEventUser(String eventUser) {
        this.eventUser = eventUser;
    }
}
