package oncall;

import java.util.List;

public class OutputView {

    public void printResult(List<OnCallDto> onCallDtos) {
        for (OnCallDto onCallDto : onCallDtos) {
            String month = onCallDto.month();
            int day = onCallDto.day();
            String dayOfWeek = onCallDto.dayOfWeek();
            String name = onCallDto.name();
            boolean b = onCallDto.weekendStatus();

            System.out.printf("%s월 %d일 %s", month, day, dayOfWeek);
            if (onCallDto.weekendStatus() && !(onCallDto.dayOfWeek().equals("토")) && !(onCallDto.dayOfWeek().equals("일"))) {
                System.out.print("(휴일)");
            }
            System.out.printf(" %s", name);
            System.out.println();
        }
    }
}
