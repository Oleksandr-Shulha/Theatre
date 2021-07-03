package theatre.spring.service;

import theatre.spring.model.PerformanceSession;
import theatre.spring.model.ShoppingCart;
import theatre.spring.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
