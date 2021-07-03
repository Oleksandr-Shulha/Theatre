package theatre.spring.dao;

import java.util.List;
import theatre.spring.model.Order;
import theatre.spring.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
