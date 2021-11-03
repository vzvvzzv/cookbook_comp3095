package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
