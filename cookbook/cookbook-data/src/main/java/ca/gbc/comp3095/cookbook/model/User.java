/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: User.java is a model which holds data (used with the h2-database) for the app. The data it pulls from
 * and saves to is the users table in the database
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id // Id - primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // PROPERTIES
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

    // RELATIONSHIPS
    // OneToMany relationship with Recipes (User can create many recipes)
    @OneToMany(mappedBy = "user")
    private List<Recipe> recipeList;

    // ManyToMany relationship with Recipes (user's favorite recipes)
    @ManyToMany
    @JoinTable(name = "users_favorite_recipes",
            joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private Set<Recipe> favoriteRecipes;

    // OneToMany relationship with Meals (user can have many meals)
    @OneToMany(mappedBy = "meal_user")
    private Set<Meal> user_plannedMeals;

    // OneToMany relationship with ShoppingList (User can have many shopping lists)
    @OneToMany(mappedBy = "shoppingListUser")
    private Set<ShoppingList> userShoppingListSet;

    // OneToMany relationship with Event (user can have many events)
    @OneToMany(mappedBy = "eventUser")
    private Set<Event> userEventSet;

    // GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public Set<Recipe> getFavoriteRecipes() {
        return favoriteRecipes;
    }

    public void setFavoriteRecipes(Set<Recipe> favoriteRecipes) {
        this.favoriteRecipes = favoriteRecipes;
    }

    public Set<Meal> getUser_plannedMeals() {
        return user_plannedMeals;
    }

    public void setUser_plannedMeals(Set<Meal> user_plannedMeals) {
        this.user_plannedMeals = user_plannedMeals;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // METHODS
    // equals() method, determines based off of username & password
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password);
    }
}
