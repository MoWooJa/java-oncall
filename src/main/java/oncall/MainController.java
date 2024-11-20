package oncall;

public class MainController {
    private final InputHandler inputHandler;

    public MainController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        MonthAndDayDto monthAndDay = inputHandler.askMonthAndDay();
        People weekDays = inputHandler.askWeekDaysList();
        OnCalls onCalls = inputHandler.askWeekendsList(weekDays);
    }
}
