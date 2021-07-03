package theatre.spring.service.mapper;

import org.springframework.stereotype.Component;
import theatre.spring.dto.request.TheatreStageRequestDto;
import theatre.spring.dto.response.TheatreStageResponseDto;
import theatre.spring.model.TheatreStage;

@Component
public class TheatreStageMapper implements RequestDtoMapper<TheatreStageRequestDto, TheatreStage>,
        ResponseDtoMapper<TheatreStageResponseDto, TheatreStage> {
    @Override
    public TheatreStage mapToModel(TheatreStageRequestDto dto) {
        TheatreStage theatreStage = new TheatreStage();
        theatreStage.setDescription(dto.getDescription());
        theatreStage.setCapacity(dto.getCapacity());
        return theatreStage;
    }

    @Override
    public TheatreStageResponseDto mapToDto(TheatreStage theatreStage) {
        TheatreStageResponseDto responseDto = new TheatreStageResponseDto();
        responseDto.setId(theatreStage.getId());
        responseDto.setDescription(theatreStage.getDescription());
        return responseDto;
    }
}
