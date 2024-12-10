package store.constants;

public enum StoreErrorCode {
    WEEKLY_NUMBERS_DUPLICATED_ERROR("당첨 번호에 중복된 값이 입력될 수 없습니다."),
    WEEKLY_NUMBER_COUNT_ERROR("당첨 번호는 총 %d개의 숫자가 입력되어야 합니다.".formatted(StoreStatic.WEEKLY_NUMBER_COUNT)),
    WEEKLY_NUMBER_RANGE_ERROR("당첨 번호는 %d부터 %d 사이의 숫자가 입력되어야 합니다."
            .formatted(StoreStatic.WEEKLY_NUMBER_RANGE_START, StoreStatic.WEEKLY_NUMBER_RANGE_END)),
    BONUS_NUMBER_DUPLICATE_ERROR("보너스 번호는 당첨 번호에서 고르지 않는 숫자여야 합니다.");

    private String reason;

    StoreErrorCode(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}