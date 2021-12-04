package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.Event;
import ca.gbc.comp3095.cookbook.model.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface EventRepository extends CrudRepository<Event, Long> {
    @Query("select i from Event i join i.eventUser r where r.id = :id")
    Set<Event> getSetByEvent(Long id);
    // TO DO: query SELECT EVENTS BY USER ID
}
