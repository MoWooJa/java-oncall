package oncall.service;

import oncall.domain.Calender;
import oncall.domain.DomainFactory;
import oncall.domain.DutySheet;
import oncall.domain.WeekdayWorkers;
import oncall.domain.WeekendWorkers;

public class DomainService {

    private DomainFactory domainFactory;

    public DomainService(DomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }

    public Calender setDutyWorkingDate(String date) {
        return domainFactory.createCalender(date);
    }

    public WeekdayWorkers setWeekdayEmployees(String weekdayEmployee) {
        return domainFactory.createWeekdayWorkers(weekdayEmployee);

    }
    public WeekendWorkers setWeekendWorkers(String weekendWorker) {
        return domainFactory.createWeekendWorkers(weekendWorker);
    }

    public DutySheet createDutySheet(Calender calender, WeekdayWorkers weekdayWorkers, WeekendWorkers weekendWorkers) {
        return domainFactory.createDutySheet(calender, weekdayWorkers, weekendWorkers);
    }
}
