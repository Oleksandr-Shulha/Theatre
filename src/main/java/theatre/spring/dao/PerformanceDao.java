package theatre.spring.dao;

import java.util.List;
import java.util.Optional;
import theatre.spring.model.Performance;

public interface PerformanceDao {
    Performance add(Performance performance);

    Optional<Performance> get(Long id);

    List<Performance> getAll();
}
