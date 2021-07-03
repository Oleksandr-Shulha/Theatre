package theatre.spring.service;

import theatre.spring.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
