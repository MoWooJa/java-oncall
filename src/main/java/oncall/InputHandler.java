package oncall;

import java.util.function.Supplier;

public class InputHandler {

    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    MonthAndDayDto askMonthAndDay() {
        return handle(inputView::getMonthAndDay);
    }

    People askWeekDaysList() {
        return handle(inputView::getWeekDaysList);
    }

    OnCalls askWeekendsList(People weekdays) {
        return handle(() -> inputView.getWeekendsList(weekdays));
    }

    private <T> T handle(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
