package oncall.domain.vo;

import javax.naming.InvalidNameException;

public class Name {
    private String name;

    public Name(String name) {
        validateNameCount(name);
    }

    private void validateNameCount(String name) {
        if (name.length() >= 5 || name.isEmpty()) {
            throw new IllegalArgumentException("ERROR 이름을 올바른 형식으로 입력해주세요");
        }
    }
}
