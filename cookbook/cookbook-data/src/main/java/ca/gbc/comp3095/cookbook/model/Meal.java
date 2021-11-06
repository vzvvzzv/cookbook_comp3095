package ca.gbc.comp3095.cookbook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_meal_recipe")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "meal_date", nullable = false)
    private Date meal_date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User meal_user;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe meal_recipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getMeal_date() {
        return meal_date;
    }

    public void setMeal_date(Date meal_date) {
        this.meal_date = meal_date;
    }

    public User getMeal_user() {
        return meal_user;
    }

    public void setMeal_user(User meal_user) {
        this.meal_user = meal_user;
    }

    public Recipe getMeal_recipe() {
        return meal_recipe;
    }

    public void setMeal_recipe(Recipe meal_recipe) {
        this.meal_recipe = meal_recipe;
    }
}
