package global.utils;

import static global.utils.StringUtil.BonusNumber.parsingBonusNumber;
import static global.utils.StringUtil.PurchaseAmount.parsingPurchaseAmount;
import static global.utils.StringUtil.WeeklyNumber.parsingWeeklyNumbers;
import static global.utils.StringUtil.WeeklyNumber.splitWeeklyNumberWithSeparator;
import static lotto.constant.LottoStatic.ERROR_MSG_PREFIX;
import static lotto.constant.LottoStatic.LOTTO_END_NUMBER;
import static lotto.constant.LottoStatic.LOTTO_NUMBER_COUNTS;
import static lotto.constant.LottoStatic.LOTTO_START_NUMBER;
import static lotto.constant.LottoStatic.PURCHASE_AMOUNT_UNIT;
import static lotto.constant.LottoStatic.WEEKLY_NUMBER_SEPARATOR;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validateLottoNumbers(List<Integer> numbers) {
        lottoNumberCountValidate(numbers);
        numbersDuplicateValidate(numbers);
    }

    private static void lottoNumberCountValidate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNTS) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX +
                    "로또 번호는 %d개여야 합니다.".formatted(LOTTO_NUMBER_COUNTS));
        }
    }

    private static void numbersDuplicateValidate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);    //set을 사용하면 중복이 제거됨
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "중복된 값은 불가합니다.");
        }
    }

    public static void validatePurchaseAmount(String inputPurchaseAmount) {
        plusSignValidate(inputPurchaseAmount);
        blankValidate(inputPurchaseAmount);
        decimalValidate(inputPurchaseAmount);
        notStartWithZeroValidate(inputPurchaseAmount);
        BigInteger parsedPurchaseAmount = parsingPurchaseAmount(inputPurchaseAmount);
        greaterThanZeroValidate(parsedPurchaseAmount);
        purchaseAmountUnitValidate(parsedPurchaseAmount);
    }

    private static void purchaseAmountUnitValidate(BigInteger purchaseAmount) {
        if (!purchaseAmount.remainder(BigInteger.valueOf(PURCHASE_AMOUNT_UNIT)).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX
                    + "%d원 단위의 입력만 가능합니다.".formatted(PURCHASE_AMOUNT_UNIT));
        }
    }

    public static void validateWeeklyNumbers(String inputWeeklyNumbers) {
        separatorAtStartOrEndValidate(inputWeeklyNumbers);
        List<String> splitInput = splitWeeklyNumberWithSeparator(inputWeeklyNumbers);
        validateSplitWeeklyNumbers(splitInput);
        List<Integer> weeklyNumbers = parsingWeeklyNumbers(splitInput);
        validateParsedWeeklyNumbers(weeklyNumbers);
    }

    private static void validateSplitWeeklyNumbers(List<String> splitWeeklyNumbers) {
        for (String input : splitWeeklyNumbers) {
            blankValidate(input);
            decimalValidate(input);
            plusSignValidate(input);
            notStartWithZeroValidate(input);
        }
        splitWeeklyNumbersCountValidate(splitWeeklyNumbers);
    }

    private static void splitWeeklyNumbersCountValidate(List<String> splitWeeklyNumbers) {
        if (splitWeeklyNumbers.size() != LOTTO_NUMBER_COUNTS) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "6개의 숫자가 입력되어야 합니다.");
        }
    }

    private static void validateParsedWeeklyNumbers(List<Integer> parsedWeeklyNumbers) {
        numbersDuplicateValidate(parsedWeeklyNumbers);
        for (int num : parsedWeeklyNumbers) {
            greaterThanZeroValidate(BigInteger.valueOf(num));
            lottoNumberRangeValidate(num);
        }
    }

    private static void separatorAtStartOrEndValidate(String input) {
        if (input.startsWith(WEEKLY_NUMBER_SEPARATOR) || input.endsWith(WEEKLY_NUMBER_SEPARATOR)) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "공백이 포함된 입력은 불가합니다." + input);
        }
    }

    public static void validateBonusNumber(String inputBonusNumber, List<Integer> weeklyNumbers) {
        plusSignValidate(inputBonusNumber);
        blankValidate(inputBonusNumber);
        decimalValidate(inputBonusNumber);
        notStartWithZeroValidate(inputBonusNumber);
        int bonusNumber = parsingBonusNumber(inputBonusNumber);
        greaterThanZeroValidate(BigInteger.valueOf(bonusNumber));
        lottoNumberRangeValidate(bonusNumber);
        weeklyAndBonusNumbersDuplicateValidate(bonusNumber, weeklyNumbers);
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

    private static void greaterThanZeroValidate(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "0 이하의 값은 입력할 수 없습니다.");
        }
    }

    private static void lottoNumberRangeValidate(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX
                    + "%d와 %d 사이의 값이 입력되어야 합니다.".formatted(LOTTO_START_NUMBER, LOTTO_END_NUMBER));
        }
    }

    private static void weeklyAndBonusNumbersDuplicateValidate(int bonusNumber, List<Integer> weeklyNumbers) {
        if (weeklyNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "이미 당첨 번호로 설정된 중복 숫자입니다" + bonusNumber);
        }
    }
}
