package lotto.utils;

public class LottoValidator {

    public static void purchaseAmountValidate(String inputPurchaseAmount) {
        int purchaseAmount = 0;
        totalNumberInputValidate(inputPurchaseAmount);
        purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        validateMinimumPurchaseAmount(purchaseAmount);
        validateLottoPurchaseUnit(purchaseAmount);
    }

    private static void totalNumberInputValidate(String numberInput) {
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
}
