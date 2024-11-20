package oncall.domain.domain;

public enum DaysOfWeek {
    MONDAY("월",false),
    TUESDAY("화", false),
    WEDNESDAY("수", false),
    THURSDAY("목", false),
    FRIDAY("금", false),
    SATURDAY("토", true),
    SUNDAY("일", true);

    public String getKoreanDay() {
        return koreanDay;
    }

    public Boolean getIsHoliday() {
        return isHoliday;
    }

    private String koreanDay;
    private Boolean isHoliday;

    DaysOfWeek(String koreanDay, boolean isHoliday) {
        this.koreanDay = koreanDay;
        this.isHoliday = isHoliday;
    }

    public static DaysOfWeek check(String koreanDay) {
        for (DaysOfWeek value : DaysOfWeek.values()) {
            if (value.koreanDay.equals(koreanDay)) {
                return value;
            }
        }
        throw new IllegalArgumentException("ERROR : 월화수목금토일 중 입력해주세요" + koreanDay);
    }
}
