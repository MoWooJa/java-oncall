package oncall;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class People {
    private final List<Person> people;

    public People(List<Person> people) {
        validate(people);
        this.people = people;
    }

    private void validate(List<Person> people) {
        Set<Person> removedDuplicated = new HashSet<>(people);
        if (removedDuplicated.size() != people.size()) {
            throw new IllegalArgumentException(Exceptions.INVALID_INPUT.getMessage());
        }
        if (!(people.size() >= 5 && people.size() <= 35)) {
            throw new IllegalArgumentException(Exceptions.INVALID_INPUT.getMessage());
        }
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Person> sortedByNaturalOrder() {
        return people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .toList();
    }
}
