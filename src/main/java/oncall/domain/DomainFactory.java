package oncall.domain;

public class DomainFactory {

    public Calender createCalender(String date) {
        return new Calender(date);
    }

    public WeekdayWorkers createWeekdayWorkers(String weekdayWorkers) {
        return new WeekdayWorkers(weekdayWorkers);
    }

    public WeekendWorkers createWeekendWorkers(String weekendWorker) {
        return new WeekendWorkers(weekendWorker);
    }

    public DutySheet createDutySheet(Calender calender, WeekdayWorkers weekdayWorkers, WeekendWorkers weekendWorkers) {
        return new DutySheet(calender, weekdayWorkers, weekendWorkers);
    }
}
