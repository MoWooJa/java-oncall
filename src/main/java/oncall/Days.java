package oncall;

import static oncall.Exceptions.INVALID_INPUT;

public enum Days {
    MON("월"),
    TUE("화"),
    WED("수"),
    THURS("목"),
    FRI("금"),
    SAT("토"),
    SUM("일");

    private final String day;

    Days(String day) {
        this.day = day;
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
}
