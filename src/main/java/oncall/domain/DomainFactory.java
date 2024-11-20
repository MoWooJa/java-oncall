package oncall.domain;

public class DomainFactory {

    public Calender createCalender(String date) {
        return new Calender(date);
    }

    public WeekdayWorkers createWeekdayWorkers(String weekdayWorkers) {
        return new WeekdayWorkers(weekdayWorkers);
    }
}
