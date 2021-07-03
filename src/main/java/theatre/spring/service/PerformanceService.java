package theatre.spring.service;

import java.util.List;
import theatre.spring.model.Performance;

public interface PerformanceService {
    Performance add(Performance performance);

    Performance get(Long id);

    List<Performance> getAll();
}
