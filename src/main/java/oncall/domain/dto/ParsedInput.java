package oncall.domain.dto;

public class ParsedInput {
    String month;
    String koreanDay;

    public ParsedInput(String month, String koreanDay) {
        this.month = month;
        this.koreanDay = koreanDay;
    }

    public String getMonth() {
        return month;
    }

    public String getKoreanDay() {
        return koreanDay;
    }
}
