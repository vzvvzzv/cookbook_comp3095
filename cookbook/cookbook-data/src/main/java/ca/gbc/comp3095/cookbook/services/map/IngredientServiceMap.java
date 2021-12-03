package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.Ingredient;
import ca.gbc.comp3095.cookbook.repositories.IngredientRepository;
import ca.gbc.comp3095.cookbook.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service // Annotates this class as a Service to be managed by Spring Boot
public class IngredientServiceMap extends AbstractMapService<Ingredient, Long> implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceMap(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Set<Ingredient> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(ingredientRepository, id);
    }

    @Override
    public void delete(Ingredient object) {
        super.delete(ingredientRepository, object);
    }

    @Override
    public Ingredient findById(Long id) {
        return super.findById(ingredientRepository, id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return super.save(ingredientRepository, ingredient);
    }

    @Override
    public Set<Ingredient> findAllByRecipeId(Long recipeId) {
        return ingredientRepository.getSetByRecipe(recipeId);
    }
}
