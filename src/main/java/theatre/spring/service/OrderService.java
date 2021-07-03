package theatre.spring.service;

import java.util.List;
import theatre.spring.model.Order;
import theatre.spring.model.ShoppingCart;
import theatre.spring.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
