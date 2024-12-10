package store.utils;

import global.utils.GlobalValidator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import store.constants.StoreErrorCode;
import store.constants.StoreStatic;

public class StoreValidator {

    public static void weeklyNumbersValidate(List<String> inputWeeklyNumbers) {
        validateWeeklyNumberDuplicate(inputWeeklyNumbers);
        validateWeeklyNumberCount(inputWeeklyNumbers);
        for(String inputWeeklyNumber : inputWeeklyNumbers) {
            GlobalValidator.numberInputIntegrationValidate(inputWeeklyNumber);
            int weeklyNumber = Integer.parseInt(inputWeeklyNumber);
            validateCorrectNumberRange(weeklyNumber);
        }
    }

    public static void bonusNumberValidate(String inputBonusNumber, List<Integer> weeklyNumbers) {
        int bonusNumber;
        GlobalValidator.numberInputIntegrationValidate(inputBonusNumber);
        bonusNumber = Integer.parseInt(inputBonusNumber);
        validateCorrectNumberRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber, weeklyNumbers);
    }

    private static void validateWeeklyNumberDuplicate(List<String> inputWeeklyNumbers) {
        Set<String> numberTemp = new HashSet<>(inputWeeklyNumbers);
        if(inputWeeklyNumbers.size() != numberTemp.size()) {
            throw new IllegalArgumentException(StoreErrorCode.WEEKLY_NUMBERS_DUPLICATED_ERROR.getReason());
        }
    }

    private static void validateWeeklyNumberCount(List<String> inputWeeklyNumbers) {
        if(inputWeeklyNumbers.size() != StoreStatic.WEEKLY_NUMBER_COUNT) {
            throw new IllegalArgumentException(StoreErrorCode.WEEKLY_NUMBER_COUNT_ERROR.getReason());
        }
    }

    private static void validateCorrectNumberRange(int number) {
        if(number < StoreStatic.WEEKLY_NUMBER_RANGE_START || number > StoreStatic.WEEKLY_NUMBER_RANGE_END) {
            throw new IllegalArgumentException(StoreErrorCode.WEEKLY_NUMBER_RANGE_ERROR.getReason());
        }
    }

    private static void validateBonusNumberDuplicate(int bonusNumber, List<Integer> weeklyNumbers) {
        if(weeklyNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(StoreErrorCode.BONUS_NUMBER_DUPLICATE_ERROR.getReason());
        }
    }
}
