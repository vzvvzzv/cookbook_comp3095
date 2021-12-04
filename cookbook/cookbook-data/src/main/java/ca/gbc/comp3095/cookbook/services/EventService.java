package ca.gbc.comp3095.cookbook.services;

import ca.gbc.comp3095.cookbook.model.Event;
import ca.gbc.comp3095.cookbook.model.Ingredient;

import java.util.Set;

public interface EventService extends CrudService<Event, Long> {
    // TO DO: Methods which will be overriden
    Set<Event> findAllByEventId(Long eventId);
}
