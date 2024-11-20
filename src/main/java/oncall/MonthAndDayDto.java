package oncall;

public record MonthAndDayDto(Months month, Days day) {
    public static MonthAndDayDto of(Months month, Days day) {
        return new MonthAndDayDto(month, day);
    }
}
