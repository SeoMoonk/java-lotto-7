package lotto.constants;

public enum LottoErrorCode {
    MINIMUM_PURCHASE_AMOUNT_ERROR("로또 최소 구입 금액은 %d원 입니다.".formatted(LottoStatic.LOTTO_UNIT_PRICE)),
    INVALID_LOTTO_PURCHASE_UNIT("로또는 %d원 단위로만 구매할 수 있습니다.".formatted(LottoStatic.LOTTO_UNIT_PRICE)),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 %d과 %d 사이의 숫자로 구성되어야 합니다."
            .formatted(LottoStatic.LOTTO_RANGE_START_NUMBER, LottoStatic.LOTTO_RANGE_END_NUMBER)),
    INVALID_LOTTO_NUMBER_COUNT("로또는 %d개의 숫자로 구성되어야 합니다.".formatted(LottoStatic.LOTTO_NUMBERS_COUNT)),
    LOTTO_NUMBERS_CONTAINS_DUPLICATE("로또 번호에 중복된 번호가 포함되어 있습니다.");

    private String reason;

    LottoErrorCode(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
