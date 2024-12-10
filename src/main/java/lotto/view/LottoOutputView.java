package lotto.view;

import global.constants.GlobalStatic;
import lotto.constants.LottoInfoMsg;
import lotto.dto.response.PurchasedLottoResponse;
import lotto.entity.Lotto;

public class LottoOutputView {

    public void printPurchaseHistory(PurchasedLottoResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append(LottoInfoMsg.LOTTO_PURCHASE_RESULT_MSG.getMsg().formatted(response.count())).append("\n");
        for(Lotto lotto : response.purchasedLottos()) {
            sb.append(lotto.getNumbers()).append("\n");
        }
        System.out.println(sb.toString());
    }

    public void printErrorMsg(String reason){
        System.out.println(GlobalStatic.ERROR_MSG_PREFIX + reason);
    }
}
