package oncall.domain;

import java.util.List;

public class WorkerRecord {
    private final List<DaysOfWeek> weekdays;

    private final List<DaysOfWeek> holidays;

    public WorkerRecord(List<DaysOfWeek> weekdays, List<DaysOfWeek> holidays) {
        this.weekdays = weekdays;
        this.holidays = holidays;
    }

    public List<DaysOfWeek> getWeekdays() {
        return weekdays;
    }

    public List<DaysOfWeek> getHolidays() {
        return holidays;
    }
}
