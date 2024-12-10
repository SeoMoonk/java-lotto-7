package store.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.constants.LottoStatic;
import lotto.entity.Lotto;
import lotto.service.LottoService;
import store.constants.LottoPrize;
import store.constants.StoreStatic;
import store.dto.response.FinalAwardsResponse;
import store.repository.StoreRepository;
import store.utils.StoreValidator;

public class StoreService {

    private final LottoService lottoService;
    private final StoreRepository storeRepository;

    public StoreService(LottoService lottoService, StoreRepository storeRepository) {
        this.lottoService = lottoService;
        this.storeRepository = storeRepository;
    }

    public List<String> splitWeeklyNumbers(String inputWeeklyNumbers) {
        return Arrays.stream(inputWeeklyNumbers.split(StoreStatic.WEEKLY_NUMBERS_SEPARATOR)).toList();
    }

    public void decideWeeklyNumbers(List<String> splitedWeeklyNumbers) {
        List<Integer> weeklyNumbers = new ArrayList<>();
        StoreValidator.weeklyNumbersValidate(splitedWeeklyNumbers);
        for (String weeklyNumber : splitedWeeklyNumbers) {
            weeklyNumbers.add(Integer.parseInt(weeklyNumber));
        }
        saveWeeklyNumbers(weeklyNumbers);
    }

    public void decideBonusNumber(String inputBonusNumber) {
        List<Integer> weeklyNumbers = storeRepository.findWeeklyNumbers();
        StoreValidator.bonusNumberValidate(inputBonusNumber, weeklyNumbers);
        saveBonusNumber(Integer.parseInt(inputBonusNumber));
    }

    private void saveWeeklyNumbers(List<Integer> weeklyNumbers) {
        storeRepository.saveWeeklyNumbers(weeklyNumbers);
    }

    private void saveBonusNumber(int bonusNumber) {
        storeRepository.saveBonusNumber(bonusNumber);
    }

    public FinalAwardsResponse finalAward() {
        List<Lotto> lottos = lottoService.getAll();
        Map<LottoPrize, Integer> finalResults = LottoPrize.getDefaultPrizeStates();
        List<Integer> weeklyNumbers = storeRepository.findWeeklyNumbers();
        int bonusNumber = storeRepository.findBonusNumber();
        for (Lotto lotto : lottos) {
            LottoPrize lottoPrize = matchingResult(weeklyNumbers, bonusNumber, lotto);
            finalResults.put(lottoPrize, finalResults.get(lottoPrize) + 1);
        }
        double profitRate = calculateProfitRate(finalResults, lottos.size());
        return new FinalAwardsResponse(finalResults, profitRate);
    }

    private int calculateTotalProfit(Map<LottoPrize, Integer> finalResults) {
        int totalProfit = 0;

        for (LottoPrize prize : finalResults.keySet()) {
            totalProfit += (prize.getPrize() * finalResults.get(prize));
        }

        return totalProfit;
    }

    private double calculateProfitRate(Map<LottoPrize, Integer> finalResults, int lottoCount) {
        int totalProfit = calculateTotalProfit(finalResults);
        int purchasedAmount = lottoCount * LottoStatic.LOTTO_UNIT_PRICE;

        double profitRate = (totalProfit / purchasedAmount) * 100.00;
        BigDecimal halfUpRate = new BigDecimal(profitRate).setScale(1, RoundingMode.HALF_UP);

        return halfUpRate.doubleValue();
    }

    private LottoPrize matchingResult(List<Integer> weeklyNumbers, int bonusNumber, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int correctCount = countCorrectedWeeklyNumbers(numbers, weeklyNumbers);
        boolean hasBonusNumber = numbers.contains(bonusNumber);

        return LottoPrize.matchingLottoPrize(correctCount, hasBonusNumber);
    }

    private int countCorrectedWeeklyNumbers(List<Integer> numbers, List<Integer> weeklyNumbers) {
        int correctCount = 0;

        for (int number : numbers) {
            if (weeklyNumbers.contains(number)) {
                correctCount++;
            }
        }

        return correctCount;
    }
}
