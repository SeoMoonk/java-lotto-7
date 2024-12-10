package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.LottoInfoMsg;

public class LottoInputView {

    public String inputPurchaseAmount() {
        System.out.println(LottoInfoMsg.LOTTO_PURCHASE_START_MSG.getMsg());
        return Console.readLine();
    }

}
