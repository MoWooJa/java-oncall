package oncall.domain.domain;

public enum Month {
    JANUARY("1",31),
    FEBRUARY("2",28),
    MARCH("3",31),
    APRIL("4",30),
    MAY("5",31),
    JUNE("6",30),
    JULY("7",31),
    AUGUST("8",31),
    SEPTEMBER("9",30),
    OCTOBER("10",31),
    NOVEMBER("11",30),
    DECEMBER("12",31);

    public String getMonth() {
        return month;
    }

    public int getDays() {
        return days;
    }

    private String month;
    private int days;

    Month(String month, int days) {
        this.month = month;
        this.days = days;
    }

    public static Month check(String month) {
        for (Month value : Month.values()) {
            if (month.equals(value.month)) {
                return value;
            }
        }
        throw new IllegalArgumentException("1 ~ 12월을 입력해주세요.");
    }

}
