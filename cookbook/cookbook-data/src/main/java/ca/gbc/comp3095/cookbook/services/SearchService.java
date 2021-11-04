package ca.gbc.comp3095.cookbook.services;

import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    // fiddling with search for recipe
    @Autowired
    private SearchRepository searchRepository;

    public List<Recipe> listAll(String keyword) {
        return searchRepository.search(keyword);
    }
}