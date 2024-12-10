package store.utils;

import global.utils.GlobalValidator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 값이 입력될 수 없습니다.");
        }
    }

    private static void validateWeeklyNumberCount(List<String> inputWeeklyNumbers) {
        if(inputWeeklyNumbers.size() != StoreStatic.WEEKLY_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 총 6개의 숫자가 입력되어야 합니다.");
        }
    }

    private static void validateCorrectNumberRange(int number) {
        if(number < StoreStatic.WEEKLY_NUMBER_RANGE_START || number > StoreStatic.WEEKLY_NUMBER_RANGE_END) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자가 입력되어야 합니다.");
        }
    }

    private static void validateBonusNumberDuplicate(int bonusNumber, List<Integer> weeklyNumbers) {
        if(weeklyNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에서 고르지 않은 숫자여야 합니다.");
        }
    }

}
