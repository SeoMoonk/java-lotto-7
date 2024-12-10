package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import lotto.constants.LottoStatic;
import lotto.dto.response.PurchasedLottoResponse;
import lotto.entity.Lotto;
import lotto.repository.LottoRepository;
import lotto.utils.LottoValidator;

public class LottoService {

    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void purchaseLottos(String inputPurchaseAmount) {
        int purchaseCount = 0;
        LottoValidator.purchaseAmountValidate(inputPurchaseAmount);
        purchaseCount = Integer.parseInt(inputPurchaseAmount) / LottoStatic.LOTTO_UNIT_PRICE;

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = generateSortedLottoNumbers();
            create(numbers);
        }
    }

    private List<Integer> generateSortedLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoStatic.LOTTO_RANGE_START_NUMBER,
                LottoStatic.LOTTO_RANGE_END_NUMBER, LottoStatic.LOTTO_NUMBERS_COUNT);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    private void create(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        lottoRepository.save(lotto);
    }

    public PurchasedLottoResponse getPurchasedResponse() {
        List<Lotto> purchasedLottos = lottoRepository.findAll();
        return new PurchasedLottoResponse(purchasedLottos.size(), purchasedLottos);
    }
}
