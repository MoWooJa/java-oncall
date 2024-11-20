package oncall.controller;

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
        setDate();
        setWeekdayWorkers();
        setWeekendWorkers();
    }

    private void setDate() {
        String date = inputView.inputDay();
        InputValidate.validateDate(date);
        domainService.setDutyWorkingDate(date);
    }

    private void setWeekdayWorkers() {
        String weekdayEmployees = inputView.inputWeekdayWorkers();
        InputValidate.validateWorkers(weekdayEmployees);
        domainService.setWeekdayEmployees(weekdayEmployees);
    }

    private void setWeekendWorkers() {
        String weekdayWorkers = inputView.inputWeekdayWorkers();
        InputValidate.validateWorkers(weekdayWorkers);
    }
}
