package theatre.spring.dto.response;

public class PerformanceSessionResponseDto {
    private Long performanceSessionId;
    private Long performanceId;
    private String performanceTitle;
    private Long theatreStageId;
    private String showTime;

    public Long getPerformanceSessionId() {
        return performanceSessionId;
    }

    public void setPerformanceSessionId(Long performanceSessionId) {
        this.performanceSessionId = performanceSessionId;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public String getPerformanceTitle() {
        return performanceTitle;
    }

    public void setPerformanceTitle(String performanceTitle) {
        this.performanceTitle = performanceTitle;
    }

    public Long getTheatreStageId() {
        return theatreStageId;
    }

    public void setTheatreStageId(Long theatreStageId) {
        this.theatreStageId = theatreStageId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
