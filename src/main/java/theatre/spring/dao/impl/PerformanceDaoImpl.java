package theatre.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import theatre.spring.dao.AbstractDao;
import theatre.spring.dao.PerformanceDao;
import theatre.spring.model.Performance;

@Repository
public class PerformanceDaoImpl extends AbstractDao<Performance> implements PerformanceDao {
    public PerformanceDaoImpl(SessionFactory factory) {
        super(factory, Performance.class);
    }
}
