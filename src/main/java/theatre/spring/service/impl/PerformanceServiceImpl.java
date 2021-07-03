package theatre.spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import theatre.spring.dao.PerformanceDao;
import theatre.spring.exception.DataProcessingException;
import theatre.spring.model.Performance;
import theatre.spring.service.PerformanceService;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    private final PerformanceDao performanceDao;

    public PerformanceServiceImpl(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }

    @Override
    public Performance add(Performance performance) {
        return performanceDao.add(performance);
    }

    @Override
    public Performance get(Long id) {
        return performanceDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get performance by id " + id));
    }

    @Override
    public List<Performance> getAll() {
        return performanceDao.getAll();
    }
}
