package theatre.spring.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PerformanceSessionRequestDto {
    @Positive
    private Long performanceId;
    @Positive
    private Long theatreStageId;
    @NotNull
    private String showTime;

    public Long getPerformanceId() {
        return performanceId;
    }

    public Long getTheatreStageId() {
        return theatreStageId;
    }

    public String getShowTime() {
        return showTime;
    }
}
