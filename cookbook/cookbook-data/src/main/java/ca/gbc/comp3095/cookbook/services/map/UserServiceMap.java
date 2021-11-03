package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.repositories.UserRepository;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceMap extends AbstractMapService<User, Long> implements UserService {

    private final UserRepository userRepository;

    public UserServiceMap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    @Override
    public Set<User> findAll() {
        return super.findAll();
    }
    */

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

    /*
    @Override
    public User save(User user) {
        return super.save(user.getId(), user);
    }
    */

    @Override
    public User save(User user) {
        return super.save(userRepository, user);
    }

    /*
    @Override
    public User findById(Long id) {
        return findById(id);
    }
    */

    @Override
    public User findById(Long id) {
        return findById(userRepository, id);
    }

    @Override
    public User findByUserName(String username) {
        return null;
    }
}
