package theatre.spring.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import theatre.spring.dao.AbstractDao;
import theatre.spring.dao.ShoppingCartDao;
import theatre.spring.exception.DataProcessingException;
import theatre.spring.model.ShoppingCart;
import theatre.spring.model.User;

@Repository
public class ShoppingCartDaoImpl extends AbstractDao<ShoppingCart> implements ShoppingCartDao {
    public ShoppingCartDaoImpl(SessionFactory factory) {
        super(factory, ShoppingCart.class);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = factory.openSession()) {
            Query<ShoppingCart> getByUser = session.createQuery(
                    "SELECT DISTINCT sc FROM ShoppingCart sc "
                            + "left join fetch sc.tickets t "
                            + "left join fetch t.performanceSession ps "
                            + "left join fetch ps.theatreStage "
                            + "left join fetch ps.performance "
                            + "WHERE sc.user = :user", ShoppingCart.class);
            getByUser.setParameter("user", user);
            return getByUser.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Not found shopping cart for user " + user, e);
        }
    }
}
