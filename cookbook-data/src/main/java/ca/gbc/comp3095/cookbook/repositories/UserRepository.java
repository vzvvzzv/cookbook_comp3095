/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment1
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan
 * Student Number: 101203877, 101032525, 101269485
 * Date: 2021-11-06
 * Description: UserRepository.java extends the CrudRepository allows for CRUD operations to the h2-database.
 * UserRepository specifically returns User objects and possesses special queries
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    // Specially defined select query using @Query
    // Returns a user where the database username matches the given username
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);

    // Updates a user where the datebase username matches the given username
    @Modifying
    @Query("UPDATE User u SET u.firstname = :firstname, u.lastname = :lastname, u.email = :email WHERE u.username = :username")
    void updateUser(@Param("username") String username, @Param("firstname") String firstname, @Param("lastname") String lastname, @Param("email") String email);
}
