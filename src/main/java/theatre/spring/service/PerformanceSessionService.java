package theatre.spring.service;

import java.time.LocalDate;
import java.util.List;
import theatre.spring.model.PerformanceSession;

public interface PerformanceSessionService {
    List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date);

    PerformanceSession add(PerformanceSession session);

    PerformanceSession get(Long id);

    PerformanceSession update(PerformanceSession performanceSession);

    void delete(Long id);
}
