package oncall;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public MonthAndDayDto validateMonthAndDay(String input) {
        List<String> inputResult = Arrays.stream(input.split(",")).toList();
        if (inputResult.size() > 2) {
            throw new IllegalArgumentException(Exceptions.INVALID_INPUT.getMessage());
        }
        Months month = Months.of(inputResult.get(0));
        Days day = Days.of(inputResult.get(1));

        return MonthAndDayDto.of(month, day);
    }
}
