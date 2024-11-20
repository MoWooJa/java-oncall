package oncall;

import static oncall.Exceptions.DIFFERENT_PEOPLE;

import java.util.List;

public class OnCalls {
    private final People weekdays;
    private final People weekends;

    public OnCalls(People weekdays, People weekends) {
        validate(weekdays, weekends);
        this.weekdays = weekdays;
        this.weekends = weekends;
    }

    public void validate(People weekdays, People weekends) {
        List<Person> sortedWeekends = weekends.sortedByNaturalOrder();
        List<Person> sortedWeekdays = weekdays.sortedByNaturalOrder();

        if (sortedWeekends.size() != sortedWeekdays.size()) {
            throw new IllegalArgumentException(DIFFERENT_PEOPLE.getMessage());
        }
        for (int i = 0; i < sortedWeekdays.size(); i++) {
            if (!sortedWeekends.get(i).getName().equals(sortedWeekdays.get(i).getName())) {
                throw new IllegalArgumentException(DIFFERENT_PEOPLE.getMessage());
            }
        }
    }
}
