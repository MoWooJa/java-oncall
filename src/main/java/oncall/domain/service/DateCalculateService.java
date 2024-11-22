package oncall.domain.service;

import oncall.domain.model.*;
import oncall.domain.dto.ParsedInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DateCalculateService {
    public WorkerRecord calculateWeekdaysAndHolidays(ParsedInput parsedInput) {
        Month month = Month.check(parsedInput.getMonth());
        int currentMonth = Integer.parseInt(month.getMonth());
        int daysInMonth = month.getDays();
        DaysOfWeek startDay = DaysOfWeek.check(parsedInput.getKoreanDay());

        return calculateDays(currentMonth, daysInMonth, startDay);
    }

    private WorkerRecord calculateDays(int month, int daysInMonth, DaysOfWeek startDay) {
        List<DaysOfWeek> daysOfWeeks = Arrays.asList(DaysOfWeek.values());
        int startIndex = daysOfWeeks.indexOf(startDay);

        List<DayInfo> weekdays = new ArrayList<>();
        List<DayInfo> holidays = new ArrayList<>();

        for (int day = 1; day <= daysInMonth; day++) {
            DaysOfWeek currentDay = daysOfWeeks.get((startIndex + day - 1) % 7);
            DayInfo dayInfo = new DayInfo(day, currentDay);

            if (dayInfo.isHoliday(month)) {
                holidays.add(dayInfo);
            }
            weekdays.add(dayInfo);
        }

        return new WorkerRecord(weekdays,holidays);
    }
}
