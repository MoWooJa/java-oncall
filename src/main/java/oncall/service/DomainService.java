package oncall.service;

import oncall.domain.Calender;
import oncall.domain.DomainFactory;
import oncall.domain.WeekdayEmployees;

public class DomainService {

    private DomainFactory domainFactory;

    public DomainService(DomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }

    public void setDutyWorkingDate(String date) {
        Calender calender = domainFactory.createCalender(date);
    }

    public void setWeekdayEmployees(String weekdayEmployee) {
        WeekdayEmployees weekdayEmployees = domainFactory.createWeekdayEmployees(weekdayEmployee);
    }
}
