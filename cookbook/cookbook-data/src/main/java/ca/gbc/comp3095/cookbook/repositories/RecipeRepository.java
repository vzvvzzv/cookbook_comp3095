/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment1
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan
 * Student Number: 101203877, 101032525, 101269485
 * Date: 2021-11-06
 * Description: RecipeRepository.java extends the CrudRepository allows for CRUD operations to the h2-database.
 * RecipeRepository specifically returns Recipe objects and possesses special queries
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    // Specially defined select queries using @Query
    // Returns set of recipes created by specific user (joined with user by userid)
    @Query("select r from Recipe r left join r.user u where u.id =  :id")
    Set<Recipe> getSetByUser(Long id);

    // Returns set of recipes by "users favorite recipes" (joined with users_favorite_recipes)
    @Query("select r from Recipe r join r.fav_users u where u.id = :id")
    Set<Recipe> getUserFav(Long id);

    // Returns set of recipes where recipeName matches wildcard (for searching)
    @Query("select r from Recipe r where LOWER(r.recipeName) LIKE %:recipeName%")
    Set<Recipe> getSetByKeyword(@Param("recipeName") String recipeName);
}
