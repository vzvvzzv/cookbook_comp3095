/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: UserService.java is an interface which extends the CrudService and works with User & Long objects.
 * Establishes extra crud operation methods specifically for User
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services;

import ca.gbc.comp3095.cookbook.model.User;

public interface UserService extends CrudService<User, Long>{

    // Methods to be implemented and expanded upon
    // returns true or false based on if given user equals database user
    boolean checkCredentials(User user);

    // returns user based on given username
    User findByUsername(String username);

    // returns user based on given email
    User findByEmail(String email);

    // updates user given user data
    void updateUser(User user);
}
