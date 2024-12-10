package lotto.controller;

import lotto.dto.response.PurchasedLottoResponse;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoService lottoService;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView, LottoService lottoService) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoService = lottoService;
    }

    public void tryPurchaseLotto() {
        try {
            String purchaseAmount = lottoInputView.inputPurchaseAmount();
            lottoService.purchaseLottos(purchaseAmount);
            PurchasedLottoResponse purchasedResponse = lottoService.getPurchasedResponse();
            lottoOutputView.printPurchaseHistory(purchasedResponse);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            tryPurchaseLotto();
        }
    }
}
