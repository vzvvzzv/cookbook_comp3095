/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment1
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan
 * Student Number: 101203877, 101032525, 101269485
 * Date: 2021-11-06
 * Description: Meal.java is a model which holds data (used with the h2-database) for the app. The relationship of Meal
 *              is a joining table between Recipe & User with a Date property for the planned Meal
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_meal_recipe")
public class Meal {

    @Id // Id - primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // PROPERTIES
    private String mealName;
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;
    @Column(name = "meal_date", nullable = false)
    private Date meal_date;

    // RELATIONSHIPS
    // ManyToOne relationship with User (links recipe and user)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User meal_user;

    // ManyToOne relationship with Recipe (links recipe and user)
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe meal_recipe;

    // GETTERS & SETTERS
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

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
