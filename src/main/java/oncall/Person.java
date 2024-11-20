package oncall;

public class Person {
    private final String name;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException(Exceptions.NICKNAME_LENGTH_ERROR.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
