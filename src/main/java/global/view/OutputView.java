package global.view;

import global.constants.GlobalStatic;
import java.util.Map;
import lotto.constants.LottoInfoMsg;
import lotto.dto.response.PurchasedLottoResponse;
import lotto.entity.Lotto;
import store.constants.LottoPrize;
import store.constants.StoreInfoMsg;
import store.dto.response.FinalAwardsResponse;

public class OutputView {

    public static void printPurchaseHistory(PurchasedLottoResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append(LottoInfoMsg.LOTTO_PURCHASE_RESULT_MSG.getMsg().formatted(response.count())).append("\n");
        for(Lotto lotto : response.purchasedLottos()) {
            sb.append(lotto.getNumbers()).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void printErrorMsg(String reason){
        System.out.println(GlobalStatic.ERROR_MSG_PREFIX + reason);
    }

    public static void printFinalResult(FinalAwardsResponse response) {
        StringBuilder sb = new StringBuilder();
        Map<LottoPrize, Integer> finalResults = response.finalResults();
        sb.append(StoreInfoMsg.FINAL_RESULT_PRINT_START_MSG.getMsg()).append("\n------\n");
        for(LottoPrize prize : finalResults.keySet()) {
            if(!prize.equals(LottoPrize.NONE_PRIZE)) {
                sb.append(formattedFinalResult(finalResults, prize)).append("\n");
            }
        }
        sb.append(StoreInfoMsg.FINAL_PROFIT_RATE_PRINT_FORM.getMsg().formatted(response.profitRate())).append("\n");
        System.out.println(sb.toString());
    }

    private static String formattedFinalResult(Map<LottoPrize, Integer> finalResults, LottoPrize prize) {
        String resultForm = StoreInfoMsg.FINAL_RESULT_PRINT_NORMAL_FORM.getMsg();

        if(prize == LottoPrize.SECOND_PRIZE) {
            resultForm = StoreInfoMsg.FINAL_RESULT_PRINT_SECOND_PRIZE_FORM.getMsg();
        }

        return resultForm.formatted(prize.getCorrectCount(), prize.getFormattedPrize(), finalResults.get(prize));
    }
}
