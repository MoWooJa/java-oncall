package oncall;

public enum SpecialWeekends {
    SINJUNG("1", 1),
    SAMIL("3", 1),
    CHILD("5", 5),
    HYUNCHUNG("6", 6),
    GWANGBOK("8", 15),
    GAECHEON("10", 3),
    HANGEOUL("10", 9),
    SUNGTAN("12", 25);

    private final String month;
    private final int day;

    SpecialWeekends(String month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isSpecialWeekend(String month, int day) {
        for (SpecialWeekends specialWeekend : SpecialWeekends.values()) {
            if (!specialWeekend.month.equals(month)) {
                return false;
            }
            if (specialWeekend.day != day) {
                return false;
            }
        }
        return true;
    }
}
