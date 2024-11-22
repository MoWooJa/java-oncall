package oncall.domain.model;

public class DayInfo {
    private int date;
    private DaysOfWeek daysOfWeek;

    public DayInfo(int date, DaysOfWeek daysOfWeek) {
        this.date = date;
        this.daysOfWeek = daysOfWeek;
    }

    public boolean isHoliday(int month) {
        return daysOfWeek.getIsHoliday() || Holidays.isHoliday(month, date);
    }
}
