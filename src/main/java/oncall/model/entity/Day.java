package oncall.model.entity;

import oncall.model.entity.type.Week;
import oncall.model.util.LegalHolidayChecker;

public class Day {
    private static final String OUTPUT_FORM_MONTH = "월 ";
    private static final String OUTPUT_FORM_DAY = "일 ";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final int month;
    private final int date;
    private final Week day;
    private boolean isLegalHoliday;
    private String workerName;

    public Day(int month ,int date, Week day) {
        this.month = month;
        this.date = date;
        this.day = day;
    }

    @Override
    public String toString() {
        return month + OUTPUT_FORM_MONTH + date + OUTPUT_FORM_DAY + day.getWeekName()+LINE_SEPARATOR;
    }

    public void checkLegalHoliday() {
        isLegalHoliday = LegalHolidayChecker.isLegalHoliday(month, date);
    }

    public boolean isLegalHoliday() {
        return isLegalHoliday;
    }

    public void assignWorker(String workerName) {
        this.workerName = workerName;
    }

    public boolean isAssigned(String workerName) {
        return this.workerName.equals(workerName);
    }
}
