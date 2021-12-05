package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.Event;
import ca.gbc.comp3095.cookbook.model.Ingredient;
import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.repositories.EventRepository;
import ca.gbc.comp3095.cookbook.services.EventService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service // Annotates this class as a Service to be managed by Spring Boot
public class EventServiceMap extends AbstractMapService<Event, Long> implements EventService {

    private final EventRepository eventRepository;

    public EventServiceMap(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Set<Event> findAll() {
        return super.findAll(eventRepository);
    }



    @Override
    public void deleteById(Long id) {
        super.deleteById(eventRepository, id);
    }

    @Override
    public void delete(Event object) {
        super.delete(eventRepository, object);
    }

    @Override
    public Event findById(Long aLong) {
        return super.findById(eventRepository, aLong);
    }

    @Override
    public Event save(Event event) {
        return super.save(eventRepository, event);
    }

    @Override
    public Set<Event> findAllByUserId(Long userId) {
        return eventRepository.findAllByUserId(userId);
    }
}
