/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: Ingredient.java is a model which holds data (used with the h2-database) for the app.
 * The data it pulls from and saves to is the ingredients table in the database
 *********************************************************************************/
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
    // ManyToMany relationship with Recipe (Many Recipes can have Many Ingredients)
    @ManyToMany(mappedBy = "recipeIngredientSet")
    private Set<Recipe> ingredientRecipeSet;

    // ManyToMany relationship with ShoppingList (Many ShoppingLists can have Many Ingredients)
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

    // Methods
    // equals() method determines if objects are equal based on ingredientName & quantity
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return ingredientName.equals(that.ingredientName) && quantity.equals(that.quantity);
    }
}
