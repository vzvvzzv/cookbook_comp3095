/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment1
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan
 * Student Number: 101203877, 101032525, 101269485
 * Date: 2021-11-06
 * Description: UserServiceMap.java is a class which extends the AbstractMapService and works with
 * User & Long objects. Overrides methods & implements user specific logic
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.repositories.UserRepository;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service // Annotates this class as a Service to be managed by Spring Boot
public class UserServiceMap extends AbstractMapService<User, Long> implements UserService {

    // UserRepository dependency
    private final UserRepository userRepository;

    // Constructor Dependency Injection
    public UserServiceMap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Possibly change findAll(), deleteById, and delete later
    @Override
    public Set<User> findAll() {
        return super.findAll(userRepository);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(User user) {
        super.delete(user);
    }

    // Saves user to database by calling super.save and passing userRepository & user
    @Override
    public User save(User user) {
        return super.save(userRepository, user);
    }

    // Finds user from database by id
    @Override
    public User findById(Long id) {
        return findById(userRepository, id);
    }

    // finds user from database using username
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // updates user using user object
    @Override
    public void updateUser(User user){
        userRepository.updateUser(user.getUsername(), user.getFirstname(), user.getLastname(), user.getEmail());
    }

    // Gets a user from the database with matching username & checks if the database_user is equal
    // If it matches return true, if it doesn't match return false
    @Override
    public boolean checkCredentials(User user) {

        User database_user = findByUsername(user.getUsername());

        if (database_user != null && database_user.equals(user)){
            return true;
        } else {
            return false;
        }
    }
}
