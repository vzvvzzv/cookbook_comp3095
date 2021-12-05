/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: EventService.java is an interface which extends the CrudService and works with Event & Long objects.
 * Establishes extra crud operation methods specifically for Events
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services;

import ca.gbc.comp3095.cookbook.model.Event;
import ca.gbc.comp3095.cookbook.model.Ingredient;

import java.util.Set;

public interface EventService extends CrudService<Event, Long> {

    // Find all events by user
    Set<Event> findAllByUserId(Long userId);
}
