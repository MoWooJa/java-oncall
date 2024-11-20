package oncall;

public record OnCallDto(String month, int day, String dayOfWeek, String name, boolean weekendStatus) {
    public static OnCallDto of(String month, int day, String dayOfWeek, String name, boolean weekendStatus) {
        return new OnCallDto(month, day, dayOfWeek, name, weekendStatus);
    }
}
