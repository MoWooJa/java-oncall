package oncall;

import java.util.List;

public class MainController {
    private final InputHandler inputHandler;
    private final OnCallService onCallService;
    private final OutputView outputView;

    public MainController(InputHandler inputHandler, OnCallService onCallService, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.onCallService = onCallService;
        this.outputView = outputView;
    }

    public void run() {
        MonthAndDayDto monthAndDay = inputHandler.askMonthAndDay();
        People weekDays = inputHandler.askWeekDaysList();
        OnCalls onCalls = inputHandler.askWeekendsList(weekDays);
        List<Calendar> calendars = onCallService.makeCalendar(monthAndDay);
        List<OnCallDto> onCallDtos = onCallService.makeList(onCalls, calendars);
        List<OnCallDto> result = onCallService.changeSerialPerson(onCallDtos);
        outputView.printResult(result);
    }
}
