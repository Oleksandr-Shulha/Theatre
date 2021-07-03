package theatre.spring.dao.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import theatre.spring.dao.RoleDao;
import theatre.spring.exception.DataProcessingException;
import theatre.spring.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory factory;

    public RoleDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void add(Role role) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert role " + role, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public Optional<Role> getRoleByName(Role.RoleName roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> findByName = session.createQuery(
                    "FROM Role WHERE name = :name", Role.class);
            findByName.setParameter("name", roleName);
            return findByName.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role with name " + roleName + " not found", e);
        }
    }
}
