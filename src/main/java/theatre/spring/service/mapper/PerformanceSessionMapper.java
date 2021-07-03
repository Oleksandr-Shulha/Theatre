package theatre.spring.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import theatre.spring.dto.request.PerformanceSessionRequestDto;
import theatre.spring.dto.response.PerformanceSessionResponseDto;
import theatre.spring.model.PerformanceSession;
import theatre.spring.service.PerformanceService;
import theatre.spring.service.TheatreStageService;
import theatre.spring.util.DateTimePatternUtil;

@Component
public class PerformanceSessionMapper implements RequestDtoMapper<PerformanceSessionRequestDto,
        PerformanceSession>,
        ResponseDtoMapper<PerformanceSessionResponseDto, PerformanceSession> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final TheatreStageService theatreStageService;
    private final PerformanceService performanceService;

    public PerformanceSessionMapper(TheatreStageService theatreStageService,
                                    PerformanceService performanceService) {
        this.theatreStageService = theatreStageService;
        this.performanceService = performanceService;
    }

    @Override
    public PerformanceSession mapToModel(PerformanceSessionRequestDto dto) {
        PerformanceSession performanceSession = new PerformanceSession();
        performanceSession.setPerformance(performanceService.get(dto.getPerformanceId()));
        performanceSession.setTheatreStage(theatreStageService.get(dto.getTheatreStageId()));
        performanceSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return performanceSession;
    }

    @Override
    public PerformanceSessionResponseDto mapToDto(PerformanceSession performanceSession) {
        PerformanceSessionResponseDto responseDto = new PerformanceSessionResponseDto();
        responseDto.setPerformanceSessionId(performanceSession.getId());
        responseDto.setTheatreStageId(performanceSession.getTheatreStage().getId());
        responseDto.setPerformanceId(performanceSession.getPerformance().getId());
        responseDto.setPerformanceTitle(performanceSession.getPerformance().getTitle());
        responseDto.setShowTime(performanceSession.getShowTime().format(formatter));
        return responseDto;
    }
}
