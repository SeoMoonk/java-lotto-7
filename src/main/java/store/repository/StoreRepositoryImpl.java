package store.repository;

import java.util.ArrayList;
import java.util.List;

public class StoreRepositoryImpl implements StoreRepository {
    private List<Integer> storedWeeklyNumbers = new ArrayList<>();
    private int storedBonusNumber;

    @Override
    public void saveWeeklyNumbers(List<Integer> weeklyNumbers) {
        storedWeeklyNumbers = weeklyNumbers;
    }

    @Override
    public void saveBonusNumber(int bonusNumber) {
        storedBonusNumber = bonusNumber;
    }

    @Override
    public List<Integer> findWeeklyNumbers() {
        List<Integer> weeklyNumbers = storedWeeklyNumbers;
        return weeklyNumbers;
    }

    @Override
    public  int findBonusNumber() {
        int bonusNumber = storedBonusNumber;
        return bonusNumber;
    }
}
