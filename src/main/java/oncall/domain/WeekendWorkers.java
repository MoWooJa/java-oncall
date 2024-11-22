package oncall.domain;

import java.util.Arrays;
import java.util.List;

public class WeekendWorkers {
    
    List<String> weekendWorkers;
    
    public WeekendWorkers(String weekendWorker) {
        this.weekendWorkers = parseWeekendWorkers(weekendWorker);
    }

    private List<String> parseWeekendWorkers(String weekdayWorker) {
        String[] workers = weekdayWorker.split(",");
        List<String> checkWokrekrs = Arrays.asList(workers);
        validate(checkWokrekrs);
        return checkWokrekrs;
    }

    private void validate(List<String> checkWokrekrs) {
        validateDuplicate(checkWokrekrs);
    }

    private void validateDuplicate(List<String> checkWokrekrs) {
        if (checkWokrekrs.size() != checkWokrekrs.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 사원은 허용 되지 않음");
        }
    }
}
