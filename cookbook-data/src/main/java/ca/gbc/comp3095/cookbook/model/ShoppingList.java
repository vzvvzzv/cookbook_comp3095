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
    @ManyToMany
    @JoinTable(name = "shopping_list_ingredients",
        joinColumns = @JoinColumn(name = "shopping_list_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> shopIngredientSet;

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
}
