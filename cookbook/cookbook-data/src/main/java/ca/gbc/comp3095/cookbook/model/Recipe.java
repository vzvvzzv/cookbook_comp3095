package ca.gbc.comp3095.cookbook.model;

import javax.persistence.*;
import java.util.Set;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipeName;
    @Lob
    //annotation specifies that the database should store the property as Large Object
    private String ingredients;
    @Lob
    private String instructions;
    private String servesHowMany;
    private String cookAndPrepTime;
    private Date creationDate;

    public Recipe() {
// making this constructor makes line 8 error go away..
    }

    public Recipe(Long id, String recipeName, String ingredients, String instructions, String servesHowMany, String cookAndPrepTime, Date creationDate){
        this.id = id;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.servesHowMany = servesHowMany;
        this.cookAndPrepTime = cookAndPrepTime;
        this.instructions = instructions;
        this.creationDate = creationDate;
    }



    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(mappedBy = "favoriteRecipes")
    private Set<User> fav_users;

    @OneToMany(mappedBy = "meal_recipe")
    private Set<Meal> recipe_plannedMeals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getServesHowMany() {
        return servesHowMany;
    }

    public void setServesHowMany(String servesHowMany) {
        this.servesHowMany = servesHowMany;
    }

    public String getCookAndPrepTime() {
        return cookAndPrepTime;
    }

    public void setCookAndPrepTime(String cookAndPrepTime) {
        this.cookAndPrepTime = cookAndPrepTime;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    @Override
    public String toString(){
        return "Recipe: " + "id=" + id +
            ", recipeName='" + recipeName  + ", ingredients='" + ingredients +
            ", servesHowMany='" + servesHowMany + ", cookAndPrepTime='" + cookAndPrepTime  +
            ", instructions=" + instructions + ", creationDate='" + creationDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getFav_users() {
        return fav_users;
    }

    public void setFav_users(Set<User> fav_users) {
        this.fav_users = fav_users;
    }

    public Set<Meal> getRecipe_plannedMeals() {
        return recipe_plannedMeals;
    }

    public void setRecipe_plannedMeals(Set<Meal> recipe_plannedMeals) {
        this.recipe_plannedMeals = recipe_plannedMeals;
    }
}
