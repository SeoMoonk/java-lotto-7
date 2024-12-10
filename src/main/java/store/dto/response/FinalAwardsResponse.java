package store.dto.response;

import java.util.Map;
import store.constants.LottoPrize;

public record FinalAwardsResponse(
        Map<LottoPrize, Integer> finalResults,
        double profitRate
) {
}
