package ca.gbc.comp3095.cookbook.model;

public class Recipe extends BaseEntity{

    private String recipeName;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
