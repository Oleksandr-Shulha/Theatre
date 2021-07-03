package theatre.spring.dao;

import java.util.Optional;
import theatre.spring.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
