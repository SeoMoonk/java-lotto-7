package global.utils;

import static lotto.constant.LottoStatic.ERROR_MSG_PREFIX;
import static lotto.constant.LottoStatic.LOTTO_END_NUMBER;
import static lotto.constant.LottoStatic.LOTTO_NUMBER_COUNTS;
import static lotto.constant.LottoStatic.LOTTO_START_NUMBER;
import static lotto.constant.LottoStatic.PURCHASE_AMOUNT_UNIT;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validatePurchaseAmount(String inputPurchaseAmount) {
        BigInteger purchaseAmount;

        plusSignValidate(inputPurchaseAmount);
        blankValidate(inputPurchaseAmount);
        decimalValidate(inputPurchaseAmount);
        notStartWithZeroValidate(inputPurchaseAmount);
        purchaseAmount = parsingValidate(inputPurchaseAmount);
        greaterThanZeroValidate(purchaseAmount);
        purchaseAmountUnitValidate(purchaseAmount);
    }

    public static void numbersDuplicateValidate(List<Integer> numbers) {
        //FIXME: 이름에 자료형을 쓰지 말 것(Set)
        Set<Integer> numberSet = new HashSet<>(numbers);    //set을 통하면 중복이 제거됨 -> 사이즈가 다르면 중복이 있다는 뜻

        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "중복된 값은 불가합니다.");
        }
    }

    public static void validateSplitWeeklyNumbers(List<String> splitWeeklyNumbers) {

        for (String input : splitWeeklyNumbers) {
            blankValidate(input);
            decimalValidate(input);
            plusSignValidate(input);
            notStartWithZeroValidate(input);
        }

        splitWeeklyNumbersCountValidate(splitWeeklyNumbers);
    }

    public static void validateParsedWeeklyNumbers(List<Integer> parsedWeeklyNumbers) {
        numbersDuplicateValidate(parsedWeeklyNumbers);
        for (int num : parsedWeeklyNumbers) {
            greaterThanZeroValidate(BigInteger.valueOf(num));
            lottoNumberRangeValidate(num);
        }
    }

    private static void notStartWithZeroValidate(String input) {
        if (input.startsWith("0") && input.length() > 1) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "0으로 시작하는 값은 입력할 수 없습니다." + input);
        }
    }

    private static void plusSignValidate(String input) {
        if (input.contains("+")) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "+ 기호가 포함된 입력은 불가합니다." + input);
        }
    }

    private static void blankValidate(String input) {
        if (input.contains(" ") || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "공백이 포함된 입력은 불가합니다." + input);
        }
    }

    private static void decimalValidate(String input) {
        if (input.contains(".")) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "소수의 입력은 불가합니다." + input);
        }
    }

    //TODO: parsing과 Validate의 간극, 있어야 할 위치 고민
    private static BigInteger parsingValidate(String input) {
        BigInteger parsedValue;

        try {
            parsedValue = new BigInteger(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MSG_PREFIX + "숫자가 아닌 값은 입력할 수 없습니다.");
        }

        return parsedValue;
    }

    private static void greaterThanZeroValidate(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "0 이하의 값은 입력할 수 없습니다.");
        }
    }

    private static void purchaseAmountUnitValidate(BigInteger purchaseAmount) {
        if (!purchaseAmount.remainder(BigInteger.valueOf(PURCHASE_AMOUNT_UNIT)).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX
                    + "%d원 단위의 입력만 가능합니다.".formatted(PURCHASE_AMOUNT_UNIT));
        }
    }

    private static void splitWeeklyNumbersCountValidate(List<String> splitWeeklyNumbers) {
        if (splitWeeklyNumbers.size() != LOTTO_NUMBER_COUNTS) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "6개의 숫자가 입력되어야 합니다.");
        }
    }

    private static void lottoNumberRangeValidate(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX
                    + "%d와 %d 사이의 값이 입력되어야 합니다.".formatted(LOTTO_START_NUMBER, LOTTO_END_NUMBER));
        }
    }
}
