package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.repositories.RecipeRepository;
import ca.gbc.comp3095.cookbook.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RecipeServiceMap extends AbstractMapService<Recipe, Long> implements RecipeService {
    @Autowired
    private final RecipeRepository recipeRepository;

    // fiddling with search function
    public List<Recipe> listAll(String keyword) {
        if (keyword != null) {
            return recipeRepository.search(keyword);
        }
        return (List<Recipe>) recipeRepository.findAll();
    }


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
        return super.findById(recipeRepository, id);
    }

    @Override
    public Recipe findByTitle(String title) {
        return null;
    }


}
