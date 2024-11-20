package oncall;

public enum Exceptions {

    INVALID_INPUT("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    DIFFERENT_PEOPLE("[ERROR] 휴일 근무자와 평일 근무자가 동일하지 않습니다."),

    PEOPLE_RANGE_ERROR("[ERROR] 5명에서 35명 사이의 사람들만 입력 가능합니다"),

    NICKNAME_DUPLICATE("[ERROR] 닉네임이 중복됩니다."),

    NICKNAME_LENGTH_ERROR("[ERROR] 닉네임 길이는 1 ~ 5 사이여야 합니다.");

    private final String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
