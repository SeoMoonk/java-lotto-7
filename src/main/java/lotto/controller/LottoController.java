package lotto.controller;

import lotto.dto.response.PurchasedLottoResponse;
import lotto.service.LottoService;
import global.view.InputView;
import global.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void tryPurchaseLotto() {
        try {
            String purchaseAmount = InputView.inputPurchaseAmount();
            lottoService.purchaseLottos(purchaseAmount);
            PurchasedLottoResponse purchasedResponse = lottoService.getPurchasedResponse();
            OutputView.printPurchaseHistory(purchasedResponse);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e.getMessage());
            tryPurchaseLotto();
        }
    }
}
