package ca.gbc.comp3095.cookbook.model;

import javax.persistence.*;
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
}