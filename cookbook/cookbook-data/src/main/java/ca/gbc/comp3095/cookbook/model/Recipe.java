package ca.gbc.comp3095.cookbook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipename;
    private Date creationDate;
    // per instructions all registered user recipes are posted and ideally ordered (ie. creation date).

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipename() {
        return recipename;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public Date getcreationDate() {
        return creationDate;
    }

    public void setcreationDate(Date dateAdded) {
        this.creationDate = dateAdded;
    }
}
