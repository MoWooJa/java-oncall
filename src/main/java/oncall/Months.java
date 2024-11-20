package oncall;

import static oncall.Exceptions.INVALID_INPUT;

public enum Months {
    JAN("1", "1", "31"),
    FEB("2", "1", "28"),
    MAR("3", "1", "31"),
    APR("4", "1", "30"),
    MAY("5", "1", "31"),
    JUN("6", "1", "30"),
    JUL("7", "1", "31"),
    AUG("8", "1", "31"),
    SEP("9", "1", "30"),
    OCT("10", "1", "31"),
    NOV("11", "1", "30"),
    DEC("12", "1", "31");

    private final String month;
    private final String start;
    private final String end;

    Months(String month, String start, String end) {
        this.month = month;
        this.start = start;
        this.end = end;
    }

    public String getMonth() {
        return month;
    }

    public static Months of(String request) {
        for (Months day : Months.values()) {
            if (day.getMonth().equals(request)) {
                return day;
            }
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
