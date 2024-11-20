package oncall.domain;

public enum DaysOfWeek {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    public String getKoreanDay() {
        return koreanDay;
    }

    private String koreanDay;

    DaysOfWeek(String koreanDay) {
        this.koreanDay = koreanDay;
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
