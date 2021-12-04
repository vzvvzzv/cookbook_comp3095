package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.Event;
import ca.gbc.comp3095.cookbook.model.Ingredient;
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
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Event object) {

    }

    @Override
    public Event findById(Long aLong) {
        return null;
    }

    @Override
    public Event save(Event Object) {
        return null;
    }

    @Override
    public Set<Event> findAllByEventId(Long eventId) {
        return eventRepository.getSetByEvent(eventId);
    }
}
