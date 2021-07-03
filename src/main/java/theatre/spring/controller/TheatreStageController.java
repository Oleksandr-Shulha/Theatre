package theatre.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theatre.spring.dto.request.TheatreStageRequestDto;
import theatre.spring.dto.response.TheatreStageResponseDto;
import theatre.spring.model.TheatreStage;
import theatre.spring.service.TheatreStageService;
import theatre.spring.service.mapper.TheatreStageMapper;

@RestController
@RequestMapping("/theatre-stage")
public class TheatreStageController {
    private final TheatreStageService theatreStageService;
    private final TheatreStageMapper theatreStageMapper;

    public TheatreStageController(
            TheatreStageService theatreStageService,
            TheatreStageMapper theatreStageMapper
    ) {
        this.theatreStageService = theatreStageService;
        this.theatreStageMapper = theatreStageMapper;
    }

    @PostMapping
    public TheatreStageResponseDto add(@RequestBody @Valid TheatreStageRequestDto requestDto) {
        TheatreStage theatreStage =
                theatreStageService.add(theatreStageMapper.mapToModel(requestDto));
        return theatreStageMapper.mapToDto(theatreStage);
    }

    @GetMapping
    public List<TheatreStageResponseDto> getAll() {
        return theatreStageService.getAll()
                .stream()
                .map(theatreStageMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
