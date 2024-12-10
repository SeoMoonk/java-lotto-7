package lotto.constants;

public enum LottoInfoMsg {
    LOTTO_PURCHASE_START_MSG("구입금액을 입력해 주세요."),
    LOTTO_PURCHASE_RESULT_MSG("\n%d개를 구매했습니다.");

    private String msg;

    LottoInfoMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
