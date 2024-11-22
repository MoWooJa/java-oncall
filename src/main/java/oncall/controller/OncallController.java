package oncall.controller;

import oncall.domain.Calender;
import oncall.domain.WeekdayWorkers;
import oncall.domain.WeekendWorkers;
import oncall.service.DomainService;
import oncall.util.validater.InputValidate;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {
    private InputView inputView;
    private OutputView outputView;
    private DomainService domainService;
    public OncallController(InputView inputView, OutputView outputView, DomainService domainService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.domainService = domainService;
    }

    public void run() {
        Calender calender = setDate();
        WeekdayWorkers weekdayWorkers = setWeekdayWorkers();
        WeekendWorkers weekendWorkers = setWeekendWorkers();
        domainService.createDutySheet(calender,weekdayWorkers,weekendWorkers);
    }

    private Calender setDate() {
        String date = inputView.inputDay();
        InputValidate.validateDate(date);
        return domainService.setDutyWorkingDate(date);
    }

    private WeekdayWorkers setWeekdayWorkers() {
        String weekdayWorkers = inputView.inputWeekdayWorkers();
        InputValidate.validateWorkers(weekdayWorkers);
        return domainService.setWeekdayEmployees(weekdayWorkers);
    }

    private WeekendWorkers setWeekendWorkers() {
        String weekendWorkersStr = inputView.inputWeekendWorkers();
        InputValidate.validateWorkers(weekendWorkersStr);
        return  domainService.setWeekendWorkers(weekendWorkersStr);
    }
}
