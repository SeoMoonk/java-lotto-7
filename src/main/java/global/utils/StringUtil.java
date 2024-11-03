package global.utils;

import static lotto.constant.LottoStatic.ERROR_MSG_PREFIX;
import static lotto.constant.LottoStatic.WEEKLY_NUMBER_SEPARATOR;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static class PurchaseAmount {
        public static BigInteger parsingPurchaseAmount(String input) {
            try {
                return new BigInteger(input);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(ERROR_MSG_PREFIX + "숫자가 아닌 값은 입력할 수 없습니다.");
            }
        }
    }

    public static class WeeklyNumber {
        public static List<String> splitWeeklyNumberWithSeparator(String inputWeeklyNumbers) {
            String[] weeklyNumbers = inputWeeklyNumbers.split(WEEKLY_NUMBER_SEPARATOR);
            return new ArrayList<>(List.of(weeklyNumbers));
        }

        public static List<Integer> parsingWeeklyNumbers(List<String> weeklyNumbers) {
            List<Integer> numbers = new ArrayList<>();

            for (String weeklyNumber : weeklyNumbers) {
                try {
                    numbers.add(Integer.parseInt(weeklyNumber));
                } catch (NumberFormatException e) {
                    throw new NumberFormatException(ERROR_MSG_PREFIX + "숫자가 아닌 값은 입력할 수 없습니다.");
                }
            }

            return numbers;
        }
    }

    public static class BonusNumber {
        public static int parsingBonusNumber(String input) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(ERROR_MSG_PREFIX + "숫자가 아닌 값은 입력할 수 없습니다.");
            }
        }
    }
}
