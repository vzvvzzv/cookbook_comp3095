package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Query("select r from Recipe r left join r.user u where u.id =  :id")
    public List<Recipe> getListByUser(Long id);

    @Query("select r from Recipe r join r.fav_users u where u.id = :id")
    public Set<Recipe> getUserFav(Long id);
}
