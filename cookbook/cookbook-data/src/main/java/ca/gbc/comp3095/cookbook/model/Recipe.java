package ca.gbc.comp3095.cookbook.model;

import javax.persistence.*;
import java.util.Date;

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
}