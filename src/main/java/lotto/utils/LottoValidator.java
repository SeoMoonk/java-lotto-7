package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 숫자로 변환할 수 없는 값은 입력될 수 없습니다.");
        }
    }

    private static void validateContainsPositiveSign(String input) {
        if(input.contains("+")) {
            throw new IllegalArgumentException("[ERROR] : + 기호가 포함된 숫자는 입력될 수 없습니다.");
        }
    }

    private static void validateContainsNegativeSign(String input) {
        if(input.contains("-")) {
            throw new IllegalArgumentException("[ERROR] : - 기호가 포함된 숫자는 입력될 수 없습니다.");
        }
    }

    private static void validateContainsBlank(String input) {
        if(input.contains(" ") || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] : 공백이거나 공백이 포함된 숫자는 입력할 수 없습니다.");
        }
    }

    private static void validateMinimumPurchaseAmount(int purchaseAmount) {
        if(purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] : 로또 최소 구입 금액은 1000원 입니다.");
        }
    }

    private static void validateLottoPurchaseUnit(int purchaseAmount) {
        if(purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] : 로또는 1000원 단위로만 구매할 수 있습니다.");
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] : 로또 번호는 1과 45 사이의 숫자로 구성되어야 합니다.");
            }
        }
    }

    private static void validateLottoNumberCount(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] : 로또는 6개의 숫자로 구성되어야 합니다.");
        }
    }

    private static void validateLottoNumberDuplicate(List<Integer> numbers) {
        Set<Integer> numberTemp = new HashSet<>(numbers);
        if(numberTemp.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] : 로또 번호에 중복된 번호가 포함되어 있습니다.");
        }
    }
}
