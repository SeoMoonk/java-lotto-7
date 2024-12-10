package global.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.LottoInfoMsg;

public class InputView {

    public static String inputPurchaseAmount() {
        System.out.println(LottoInfoMsg.LOTTO_PURCHASE_START_MSG.getMsg());
        return Console.readLine();
    }

}
