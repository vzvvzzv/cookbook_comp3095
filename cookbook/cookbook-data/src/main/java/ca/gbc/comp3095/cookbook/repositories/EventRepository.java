/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: EventRepository.java extends the CrudRepository allows for CRUD operations to the h2-database.
 * EventRepository specifically returns Event objects and possesses special queries
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.Event;
import ca.gbc.comp3095.cookbook.model.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface EventRepository extends CrudRepository<Event, Long> {

    // Specially defined select queries using @Query
    // Returns set of events created by specific user (joined with user by userid)
    @Query("select i from Event i join i.eventUser r where r.id = :id")
    Set<Event> findAllByUserId(Long id);
}
