package theatre.spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import theatre.spring.dao.TheatreStageDao;
import theatre.spring.exception.DataProcessingException;
import theatre.spring.model.TheatreStage;
import theatre.spring.service.TheatreStageService;

@Service
public class TheatreStageServiceImpl implements TheatreStageService {
    private final TheatreStageDao theatreStageDao;

    public TheatreStageServiceImpl(TheatreStageDao theatreStageDao) {
        this.theatreStageDao = theatreStageDao;
    }

    @Override
    public TheatreStage add(TheatreStage theatreStage) {
        return theatreStageDao.add(theatreStage);
    }

    @Override
    public TheatreStage get(Long id) {
        return theatreStageDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get theatre stage by id " + id));
    }

    @Override
    public List<TheatreStage> getAll() {
        return theatreStageDao.getAll();
    }
}
