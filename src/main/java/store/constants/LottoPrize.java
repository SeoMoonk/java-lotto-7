package store.constants;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public enum LottoPrize {
    NONE_PRIZE(0, false, 0),
    FIFTH_PRIZE(3, false, 5000),
    FOURTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 1500000),
    SECOND_PRIZE(5, true, 30000000),
    FIRST_PRIZE(6, false, 2000000000);

    private int correctCount;
    private boolean hasBonusNumber;
    private int prize;

    LottoPrize(int correctCount, boolean hasBonusNumber, int prize) {
        this.correctCount = correctCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static LottoPrize matchingLottoPrize(int correctCount, boolean hasBonusNumber) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize.getCorrectCount() == correctCount && lottoPrize.hasBonusNumber == hasBonusNumber) {
                return lottoPrize;
            }
        }
        return NONE_PRIZE;
    }

    public static Map<LottoPrize, Integer> getDefaultPrizeStates() {
        Map<LottoPrize, Integer> results = new LinkedHashMap<>();
        for (LottoPrize prize : values()) {
            results.put(prize, 0);
        }

        return results;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getFormattedPrize() {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(getPrize());
    }
}
