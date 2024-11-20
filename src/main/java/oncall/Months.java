package oncall;

import static oncall.Exceptions.INVALID_INPUT;

public enum Months {
    JAN("1"),
    FEB("2"),
    MAR("3"),
    APR("4"),
    MAY("5"),
    JUN("6"),
    JUL("7"),
    AUG("8"),
    SEP("9"),
    OCT("10"),
    NOV("11"),
    DEC("12");

    private final String month;

    Months(String month) {
        this.month = month;
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
}
