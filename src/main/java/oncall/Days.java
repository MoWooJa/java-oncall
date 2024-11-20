package oncall;

import static oncall.Exceptions.INVALID_INPUT;

public enum Days {
    MON("월", false, 1),
    TUE("화", false, 2),
    WED("수", false, 3),
    THURS("목", false, 4),
    FRI("금", false, 5),
    SAT("토", true, 6),
    SUM("일", true, 7);

    private final String day;
    private final boolean weekendStatus;

    private final int idx;

    Days(String day, boolean weekendStatus, int idx) {
        this.day = day;
        this.weekendStatus = weekendStatus;
        this.idx = idx;
    }

    public String getDay() {
        return day;
    }

    public static Days of(String request) {
        for (Days day : Days.values()) {
            if (day.getDay().equals(request)) {
                return day;
            }
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }

    public int getIdx() {
        return idx;
    }

    public boolean isWeekend() {
        return weekendStatus;
    }

    public static Days getDaysByIdx(int idx) {
        for (Days day : Days.values()) {
            if (day.idx == idx) {
                return day;
            }
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }
}
