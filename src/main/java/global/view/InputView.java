package global.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.LottoInfoMsg;
import store.constants.StoreInfoMsg;

public class InputView {

    public static String inputPurchaseAmount() {
        System.out.println(LottoInfoMsg.LOTTO_PURCHASE_START_MSG.getMsg());
        return Console.readLine();
    }

    public static String inputWeeklyNumbers() {
        System.out.println(StoreInfoMsg.SELECT_WEEKLY_NUMBERS_MSG.getMsg());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(StoreInfoMsg.SELECT_BONUS_NUMBER_MSG.getMsg());
        return Console.readLine();
    }
}