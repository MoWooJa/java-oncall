package oncall.model.util;

import java.util.LinkedHashMap;
import java.util.List;

public class LegalHolidayChecker {
    static final private LinkedHashMap<Integer, List<Integer>> holidays = new LinkedHashMap<>();

    static {
        holidays.put(1,List.of(1));
        holidays.put(3,List.of(1));
        holidays.put(5,List.of(5));
        holidays.put(6,List.of(6));
        holidays.put(8,List.of(15));
        holidays.put(10,List.of(3,9));
        holidays.put(12,List.of(25));
    }
    public static boolean isLegalHoliday(int month, int day) {
        return holidays.containsKey(month) && holidays.get(month).contains(day);
    }
}
