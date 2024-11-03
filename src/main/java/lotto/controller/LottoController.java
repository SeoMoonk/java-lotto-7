package lotto.controller;

import java.math.BigInteger;
import lotto.service.LottoService;
import lotto.utils.LottoValidator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

    private static final LottoValidator lottoValidator = new LottoValidator();

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoService lottoService;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView,
                           LottoService lottoService) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoService = lottoService;
    }

    public void payingForLotto() {
        BigInteger purchaseAmount = paying();
        generateLotto(purchaseAmount);
        lottoOutputView.printLottoNumbers(lottoService.getAll());
    }

    //FIXME: BigInteger로 변환하는 것, Controller에서 처리하는 것이 맞는가?
    private BigInteger paying() {

        String input = lottoInputView.inputPurchaseAmount();

        try {
            lottoValidator.validatePurchaseAmount(input);
        } catch (Exception e) {
            return paying();
        }

        return new BigInteger(input);
    }

    private void generateLotto(BigInteger purchaseAmount) {
        lottoService.generateByPurchaseAmount(purchaseAmount);
    }

}
