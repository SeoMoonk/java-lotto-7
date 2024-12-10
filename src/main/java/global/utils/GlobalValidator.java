package global.utils;

import global.constants.GlobalErrorCode;
import global.constants.GlobalStatic;

public class GlobalValidator {

    public static void numberInputIntegrationValidate(String numberInput) {
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
}
