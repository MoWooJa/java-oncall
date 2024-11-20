package oncall.domain.domainService;

import oncall.domain.domain.*;
import oncall.domain.dto.ParsedInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DateCalculateService {
    public WorkerRecord calculateWeekdaysAndHolidays(ParsedInput parsedInput) {
        Month month = Month.check(parsedInput.getMonth());

        int currentMonth = Integer.parseInt(month.getMonth());
        int monthDayCount = month.getDays();
        DaysOfWeek daysOfWeek = DaysOfWeek.check(parsedInput.getKoreanDay());

        WorkerRecord workerRecord = getWeekdays(currentMonth, monthDayCount, daysOfWeek);
        return workerRecord;
    }

    private WorkerRecord getWeekdays(int month, int daysInMonth, DaysOfWeek startDay) {
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
