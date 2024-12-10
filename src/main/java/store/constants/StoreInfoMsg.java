package store.constants;

public enum StoreInfoMsg {
    SELECT_WEEKLY_NUMBERS_MSG("당첨 번호를 입력해 주세요."),
    SELECT_BONUS_NUMBER_MSG("\n보너스 번호를 입력해 주세요.");

    private String msg;

    StoreInfoMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
