package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
// fiddling with search for recipe
public interface SearchRepository  extends JpaRepository<Recipe, Long> {

    List<Recipe> search(String keyword);
}
