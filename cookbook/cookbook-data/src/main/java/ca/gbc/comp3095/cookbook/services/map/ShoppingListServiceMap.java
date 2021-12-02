package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.ShoppingList;
import ca.gbc.comp3095.cookbook.repositories.ShoppingListRepository;
import ca.gbc.comp3095.cookbook.services.ShoppingListService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service // Annotates this class as a Service to be managed by Spring Boot
public class ShoppingListServiceMap extends AbstractMapService<ShoppingList, Long> implements ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListServiceMap(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public Set<ShoppingList> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(ShoppingList object) {

    }

    @Override
    public ShoppingList findById(Long aLong) {
        return null;
    }

    @Override
    public ShoppingList save(ShoppingList Object) {
        return null;
    }
}
