package theatre.spring.service;

import java.util.List;
import theatre.spring.model.TheatreStage;

public interface TheatreStageService {
    TheatreStage add(TheatreStage theatreStage);

    TheatreStage get(Long id);

    List<TheatreStage> getAll();
}
