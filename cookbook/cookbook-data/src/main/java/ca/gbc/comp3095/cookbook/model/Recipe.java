package ca.gbc.comp3095.cookbook.model;

public class Recipe extends BaseEntity{

    private String recipename;

    public String getRecipename() {
        return recipename;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }
}
