package oncall.domain.domain;

import java.util.List;

public class WorkerRecord {
    private final List<DayInfo> weekdays;

    private final List<DayInfo> holidays;

    public WorkerRecord(List<DayInfo> weekdays, List<DayInfo> holidays) {
        this.weekdays = weekdays;
        this.holidays = holidays;
    }

    public List<DayInfo> getWeekdays() {
        return weekdays;
    }

    public List<DayInfo> getHolidays() {
        return holidays;
    }
}
