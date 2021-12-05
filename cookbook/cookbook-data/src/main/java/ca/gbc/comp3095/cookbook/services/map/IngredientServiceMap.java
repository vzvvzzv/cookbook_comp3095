/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: IngredientServiceMap.java is a class which extends the AbstractMapService and
 * works with Ingredient & Long objects. Overrides methods & implements ingredient specific logic
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.Ingredient;
import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.repositories.IngredientRepository;
import ca.gbc.comp3095.cookbook.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

@Service // Annotates this class as a Service to be managed by Spring Boot
public class IngredientServiceMap extends AbstractMapService<Ingredient, Long> implements IngredientService {

    // IngredientRepository dependency
    private final IngredientRepository ingredientRepository;

    // Constructor Dependency Injection
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

    @Override
    public void saveIngredientSet(Set<Ingredient> ingredientSet, Set<Recipe> recipeSet) {
        Iterator ingredientIterator = ingredientSet.iterator();

        // Save Ingredients to Database
        while (ingredientIterator.hasNext()) {
            Ingredient temp = (Ingredient) ingredientIterator.next();
            temp.setIngredientRecipeSet(recipeSet);
            this.save(temp);
        }
    }
}
