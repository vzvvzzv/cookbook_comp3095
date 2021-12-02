package ca.gbc.comp3095.cookbook.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredient extends BaseEntity {

    @Id // Id - primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // PROPERTIES
    private String ingredientName;
    private String quantity;

    // RELATIONSHIPS
    @ManyToMany(mappedBy = "recipeIngredientSet")
    private Set<Recipe> ingredientRecipeSet;

    // TO DO RELATIONSHIPS SHOPPING LIST
    @ManyToMany(mappedBy = "shopIngredientSet")
    private Set<ShoppingList> ingredientShopListSet;

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Set<Recipe> getIngredientRecipeSet() {
        return ingredientRecipeSet;
    }

    public void setIngredientRecipeSet(Set<Recipe> ingredientRecipeSet) {
        this.ingredientRecipeSet = ingredientRecipeSet;
    }

    public Set<ShoppingList> getIngredientShopListSet() {
        return ingredientShopListSet;
    }

    public void setIngredientShopListSet(Set<ShoppingList> ingredientShopListSet) {
        this.ingredientShopListSet = ingredientShopListSet;
    }
}
