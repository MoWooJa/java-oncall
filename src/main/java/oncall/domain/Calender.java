package oncall.domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Calender {
    private static final String INPUT_PATTERN = "^\\d+,[ㄱ-ㅎ가-힣]$";
    private static final String[] WEEK_DAYS = {"일", "월", "화", "수", "목", "금", "토"};

    private Map<Integer,String> dutyWorkDate = new HashMap<>();
    private LocalDate month;
    private LocalDate day;

    public Calender(String date) {
        validate(date);
        setDutyWorkDate(date);
    }

    private void validate(String date) {
        if (!date.matches(INPUT_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 날짜 입력 형식 예외 발생");
        }
    }

    private void setDutyWorkDate(String date) {
        String[] splitedDate = date.split(",");
        int month = Integer.parseInt(splitedDate[0]);
        String day = splitedDate[1];
        int dayCount = checkDayOfMonth(month);
        setUpCalender(dayCount,day);
    }

    private int checkDayOfMonth(int month) {
        if (month == 2) {
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31;
    }

    private void setUpCalender(int dayCount, String day) {
        int startDayIndex = findByWeek(day);
        for (int i = 1; i <= dayCount; i++) {
            dutyWorkDate.put(i, WEEK_DAYS[(i + startDayIndex - 1) % 7]);
        }
    }

    private int findByWeek(String day) {
        for (int i = 0; i < WEEK_DAYS.length; i++) {
            if (WEEK_DAYS[i].equals(day)) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    public Map<Integer, String> getDutyWorkDate() {
        return dutyWorkDate;
    }
}
