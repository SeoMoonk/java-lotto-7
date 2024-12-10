package lotto.view;

import lotto.dto.response.PurchasedLottoResponse;
import lotto.entity.Lotto;

public class LottoOutputView {

    public void printPurchaseHistory(PurchasedLottoResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(response.count()).append("개를 구매했습니다.\n");
        for(Lotto lotto : response.purchasedLottos()) {
            sb.append(lotto.getNumbers()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
