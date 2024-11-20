package oncall.domain.domainService;

import oncall.domain.domain.DaysOfWeek;
import oncall.domain.domain.Holidays;
import oncall.domain.domain.Month;
import oncall.domain.domain.WorkerRecord;
import oncall.domain.dto.ParsedInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class    DateCalculateService {
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

        List<DaysOfWeek> weekdays = new ArrayList<>();
        List<DaysOfWeek> holidays = new ArrayList<>();

        for (int day = 1; day <= daysInMonth; day++) {
            DaysOfWeek currentDay = daysOfWeeks.get((startIndex + day - 1) % 7);
            if (currentDay.getIsHoliday() || Holidays.isHoliday(month, day)) {
                holidays.add(currentDay);
                continue;
            }

            weekdays.add(currentDay);
        }

        return new WorkerRecord(weekdays,holidays);
    }
}
