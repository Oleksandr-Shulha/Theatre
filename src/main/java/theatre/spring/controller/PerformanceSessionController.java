package theatre.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import theatre.spring.dto.request.PerformanceSessionRequestDto;
import theatre.spring.dto.response.PerformanceSessionResponseDto;
import theatre.spring.model.PerformanceSession;
import theatre.spring.service.PerformanceSessionService;
import theatre.spring.service.mapper.PerformanceSessionMapper;
import theatre.spring.util.DateTimePatternUtil;

@RestController
@RequestMapping("/performance-sessions")
public class PerformanceSessionController {
    public static final String DATE_PATTERN = DateTimePatternUtil.DATE_PATTERN;
    private final PerformanceSessionService performanceSessionService;
    private final PerformanceSessionMapper performanceSessionMapper;

    public PerformanceSessionController(
            PerformanceSessionService performanceSessionService,
            PerformanceSessionMapper performanceSessionMapper
    ) {
        this.performanceSessionService = performanceSessionService;
        this.performanceSessionMapper = performanceSessionMapper;
    }

    @PostMapping
    public PerformanceSessionResponseDto add(
            @RequestBody
            @Valid
            PerformanceSessionRequestDto requestDto
    ) {
        PerformanceSession performanceSession = performanceSessionMapper.mapToModel(requestDto);
        performanceSessionService.add(performanceSession);
        return performanceSessionMapper.mapToDto(performanceSession);
    }

    @GetMapping("/available")
    public List<PerformanceSessionResponseDto> getAll(
            @RequestParam Long performanceId,
            @RequestParam
            @DateTimeFormat(pattern = DATE_PATTERN)
            LocalDate date
    ) {
        return performanceSessionService.findAvailableSessions(performanceId, date)
                .stream()
                .map(performanceSessionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public PerformanceSessionResponseDto update(
            @PathVariable Long id,
            @RequestBody @Valid PerformanceSessionRequestDto requestDto
    ) {
        PerformanceSession performanceSession = performanceSessionMapper.mapToModel(requestDto);
        performanceSession.setId(id);
        performanceSessionService.update(performanceSession);
        return performanceSessionMapper.mapToDto(performanceSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        performanceSessionService.delete(id);
    }
}
