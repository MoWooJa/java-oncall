package oncall;

public class Person {
    private final String name;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(Exceptions.INVALID_INPUT.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
