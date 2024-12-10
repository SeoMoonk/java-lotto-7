package lotto.utils;

import global.constants.GlobalErrorCode;
import global.constants.GlobalStatic;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.LottoErrorCode;
import lotto.constants.LottoStatic;

public class LottoValidator {

    public static void purchaseAmountValidate(String inputPurchaseAmount) {
        int purchaseAmount = 0;
        numberInputIntegrationValidate(inputPurchaseAmount);
        purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        validateMinimumPurchaseAmount(purchaseAmount);
        validateLottoPurchaseUnit(purchaseAmount);
    }

    public static void lottoNumbersValidate(List<Integer> numbers) {
        validateLottoNumberRange(numbers);
        validateLottoNumberCount(numbers);
        validateLottoNumberDuplicate(numbers);
    }

    private static void numberInputIntegrationValidate(String numberInput) {
        validateIsNumberInput(numberInput);
        validateContainsPositiveSign(numberInput);
        validateContainsNegativeSign(numberInput);
        validateContainsBlank(numberInput);
    }

    private static void validateIsNumberInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GlobalErrorCode.INVALID_NUMBER_INPUT.getReason());
        }
    }

    private static void validateContainsPositiveSign(String input) {
        if (input.contains(GlobalStatic.NUMBER_POSITIVE_SIGN)) {
            throw new IllegalArgumentException(GlobalErrorCode.CANNOT_CONTAINS_POSITIVE_SIGN.getReason());
        }
    }

    private static void validateContainsNegativeSign(String input) {
        if (input.contains(GlobalStatic.NUMBER_NEGATIVE_SIGN)) {
            throw new IllegalArgumentException(GlobalErrorCode.CANNOT_CONTAINS_NEGATIVE_SIGN.getReason());
        }
    }

    private static void validateContainsBlank(String input) {
        if (input.contains(" ") || input.isBlank()) {
            throw new IllegalArgumentException(GlobalErrorCode.CANNOT_CONTAINS_BLANK.getReason());
        }
    }

    private static void validateMinimumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LottoStatic.LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException(LottoErrorCode.MINIMUM_PURCHASE_AMOUNT_ERROR.getReason());
        }
    }

    private static void validateLottoPurchaseUnit(int purchaseAmount) {
        if (purchaseAmount % LottoStatic.LOTTO_UNIT_PRICE != 0) {
            throw new IllegalArgumentException(LottoErrorCode.INVALID_LOTTO_PURCHASE_UNIT.getReason());
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoStatic.LOTTO_RANGE_START_NUMBER || number > LottoStatic.LOTTO_RANGE_END_NUMBER) {
                throw new IllegalArgumentException(LottoErrorCode.INVALID_LOTTO_NUMBER_RANGE.getReason());
            }
        }
    }

    private static void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoStatic.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LottoErrorCode.INVALID_LOTTO_NUMBER_COUNT.getReason());
        }
    }

    private static void validateLottoNumberDuplicate(List<Integer> numbers) {
        Set<Integer> numberTemp = new HashSet<>(numbers);
        if (numberTemp.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoErrorCode.LOTTO_NUMBERS_CONTAINS_DUPLICATE.getReason());
        }
    }
}
