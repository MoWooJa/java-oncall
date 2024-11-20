package oncall;

public class Calendar {
    private final String month;
    private final int day;
    private final String dayOfWeek;
    private final boolean weekendStatus;

    public Calendar(String month, int day, String dayOfWeek, boolean weekendStatus) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.weekendStatus = weekendStatus;
    }

    public static Calendar of(String month, int day, String dayOfWeek, boolean weekendStatus) {
        return new Calendar(month, day, dayOfWeek, weekendStatus);
    }

    public String getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isWeekendStatus() {
        return weekendStatus;
    }
}
