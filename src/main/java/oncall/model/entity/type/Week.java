package oncall.model.entity.type;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Week {
    MONDAY(0, "월"),
    TUESDAY(1, "화"),
    WEDNESDAY(2, "수"),
    THURSDAY(3, "목"),
    FRIDAY(4, "금"),
    SATURDAY(5, "토"),
    SUNDAY(6, "일");

    private static final Map<String, Week> NAME_TO_WEEK_MAP = new LinkedHashMap<>();

    static {
        for (Week week : Week.values()) {
            NAME_TO_WEEK_MAP.put(week.weekName, week);
        }
    }

    public final int weekValue;
    public final String weekName;

    Week(int weekValue, String weekName) {
        this.weekValue = weekValue;
        this.weekName = weekName;
    }

    public int getWeekValue() {
        return weekValue;
    }

    public String getWeekName() {
        return weekName;
    }

    public static Week fromName(String name) {
        return NAME_TO_WEEK_MAP.get(name);
    }
}
