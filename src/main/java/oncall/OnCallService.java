package oncall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OnCallService {
    public List<OnCallDto> makeList(OnCalls onCalls, List<Calendar> calendars) {
        List<OnCallDto> onCallDtos = new LinkedList<>();

        People weekend = onCalls.getWeekends();
        People weekday = onCalls.getWeekdays();

        int weekendIdx = 0;
        int weekdaysIdx = 0;

        String temp = "";

        for (Calendar calendar : calendars) {
            if (calendar.isWeekendStatus()) {
                int idx = weekendIdx % weekend.getPeople().size();
                OnCallDto onCallDto = OnCallDto.of(calendar.getMonth(), calendar.getDay(), calendar.getDayOfWeek(),
                        weekend.getPersonName(idx), true);
                weekendIdx++;
                onCallDtos.add(onCallDto);
                continue;
            }
            int idx = weekdaysIdx % weekday.getPeople().size();
            OnCallDto onCallDto = OnCallDto.of(calendar.getMonth(), calendar.getDay(), calendar.getDayOfWeek(),
                    weekday.getPersonName(idx),
                    false);
            weekdaysIdx++;
            onCallDtos.add(onCallDto);
        }
        return onCallDtos;
    }

    public List<OnCallDto> changeSerialPerson(List<OnCallDto> onCallDtos) {
        int size = onCallDtos.size();
        for (int i = 1; i < size - 1; i++) {
            if (onCallDtos.get(i).name().equals(onCallDtos.get(i - 1).name())) {
                Collections.swap(onCallDtos, i, i + 1);
            }
        }
        return onCallDtos;
    }


    public List<Calendar> makeCalendar(MonthAndDayDto monthAndDayDto) {
        List<Calendar> calendars = new ArrayList<>();

        Months month = monthAndDayDto.month();
        int startDayIdx = monthAndDayDto.day().getIdx();

        int start = Integer.parseInt(month.getStart());
        int end = Integer.parseInt(month.getEnd());

        int daySize = 7;
        for (int now = start; now <= end; now++) {
            int dayOfWeek = startDayIdx % daySize;
            if (dayOfWeek == 0) {
                dayOfWeek = 7;
            }
            Days daysByIdx = Days.getDaysByIdx(dayOfWeek);
            boolean weekendStatus = checkWeekend(month.getMonth(), now, daysByIdx);
            Calendar calendar = Calendar.of(month.getMonth(), now, daysByIdx.getDay(), weekendStatus);
            calendars.add(calendar);
            startDayIdx++;
        }
        return calendars;
    }

    public boolean checkWeekend(String month, int now, Days days) {
        if (days.isWeekend()) {
            return true;
        }
        return SpecialWeekends.isSpecialWeekend(month, now);
    }
}
