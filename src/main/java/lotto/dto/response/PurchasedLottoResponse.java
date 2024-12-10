package lotto.dto.response;

import java.util.List;
import lotto.entity.Lotto;

public record PurchasedLottoResponse(
        int count,
        List<Lotto> purchasedLottos
) {
}
