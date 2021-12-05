/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: ShoppingList.java is a model which holds data (used with the h2-database) for the app.
 * The data it pulls from and saves to is the shopping_list table in the database
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_list")
public class ShoppingList extends BaseEntity {

    @Id // Id - primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // PROPERTIES
    private String shoppingListName;

    // RELATIONSHIPS
    // ManyToMany relationship with ingredients (Many ingredients can be a part of many shopping lists)
    @ManyToMany
    @JoinTable(name = "shopping_list_ingredients",
        joinColumns = @JoinColumn(name = "shopping_list_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> shopIngredientSet;

    // ManyToOne relationship with User (User can possess many shopping lists)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User shoppingListUser;

    // GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShoppingListName() {
        return shoppingListName;
    }

    public void setShoppingListName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }

    public Set<Ingredient> getShopIngredientSet() {
        return shopIngredientSet;
    }

    public void setShopIngredientSet(Set<Ingredient> shopIngredientSet) {
        this.shopIngredientSet = shopIngredientSet;
    }

    public User getShoppingListUser() {
        return shoppingListUser;
    }

    public void setShoppingListUser(User shoppingListUser) {
        this.shoppingListUser = shoppingListUser;
    }
}
