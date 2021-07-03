package theatre.spring.dao;

import java.util.List;
import java.util.Optional;
import theatre.spring.model.TheatreStage;

public interface TheatreStageDao {
    TheatreStage add(TheatreStage theatreStage);

    Optional<TheatreStage> get(Long id);

    List<TheatreStage> getAll();
}
