package oncall.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parse(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
