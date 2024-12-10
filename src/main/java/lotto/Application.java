package lotto;

import global.config.AppConfig;
import lotto.controller.LottoController;
import store.controller.StoreController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottoController = appConfig.getLottoController();
        StoreController storeController = appConfig.getStoreController();

        lottoController.tryPurchaseLotto();
        storeController.decideWeeklyLottoNumbers();
        storeController.finalAward();
    }
}
