package global.constants;

public enum GlobalErrorCode {
    INVALID_NUMBER_INPUT("숫자로 변환할 수 없는 값은 입력될 수 없습니다."),
    CANNOT_CONTAINS_POSITIVE_SIGN("+ 기호가 포함된 숫자의 입력은 불가합니다."),
    CANNOT_CONTAINS_NEGATIVE_SIGN("- 기호가 포함된 숫자의 입력은 불가합니다."),
    CANNOT_CONTAINS_BLANK("공백이거나 공백이 포함된 값의 입력은 불가합니다.");

    private String reason;

    GlobalErrorCode(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
