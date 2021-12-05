/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: Event.java is a model which holds data (used with the h2-database) for the app. The data it pulls from
 * and saves to is the events table in the database
 *********************************************************************************/
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
    // ManyToOne relationship with the User (User has many events)
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

    public void setEventUser(User eventUser) {
        this.eventUser = eventUser;
    }
}
