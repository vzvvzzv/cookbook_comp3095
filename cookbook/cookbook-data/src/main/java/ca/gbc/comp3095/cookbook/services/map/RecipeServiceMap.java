package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.Meal;
import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.repositories.MealRepository;
import ca.gbc.comp3095.cookbook.repositories.RecipeRepository;
import ca.gbc.comp3095.cookbook.services.RecipeService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceMap extends AbstractMapService<Recipe, Long> implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceMap(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    /*
    @Override
    public Set<Recipe> findAll() {
        return super.findAll();
    }
    */

    @Override
    public Set<Recipe> findAll() {
        return super.findAll(recipeRepository);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Recipe recipe) {
        super.delete(recipe);
    }

    /*
    @Override
    public Recipe save(Recipe recipe) {
        return super.save(recipe.getId(), recipe);
    }
     */

    @Override
    public Recipe save(Recipe recipe) {
        return super.save(recipeRepository, recipe);
    }

    /*
    @Override
    public Recipe findById(Long id) {
        return super.findById(id);
    }
    */

    @Override
    public Recipe findById(Long id) {
        Recipe toReturn =  super.findById(recipeRepository, id);
        //System.out.println(toReturn);
        if (toReturn == null) {
            toReturn = new Recipe();
            toReturn.setId(-1L);
            return toReturn;
        } else {
            return toReturn;
        }
    }

    @Override
    public Recipe findByTitle(String title) {
        return null;
    }

    @Override
    public List<Recipe> findByUser(Long id) {
        return recipeRepository.getListByUser(id);
    }

    @Override
    public Set<Recipe> findByFavUser(Long id) {
        return recipeRepository.getUserFav(id);
    }

    @Override
    public Set<Recipe> findByKeyword(String key) {
        Set<Recipe> tempSet = recipeRepository.getSetByKeyword(key);
        if (tempSet == null) {
            tempSet = Collections.emptySet();
            Recipe tempRecipe = tempSet.iterator().next();
            System.out.println(tempRecipe.getId() + " " + tempRecipe.getRecipeName());
            return tempSet;
        } else {
            System.out.println(tempSet);
            return tempSet;
        }
    }
}
