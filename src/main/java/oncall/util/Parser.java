package oncall.util;

import oncall.domain.dto.ParsedInput;

public class Parser {
    public static String DELIMITER = ",";

    public static ParsedInput parseInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("ERROR : 빈 값을 입력할 수 없습니다");
        }
        String[] parts = input.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException("ERROR : 올바른 형식으로 입력해주세요");
        }
        parts[0] = parts[0].trim();
        parts[1] = parts[1].trim();

        return new ParsedInput(parts[0], parts[1]);
    }

}
