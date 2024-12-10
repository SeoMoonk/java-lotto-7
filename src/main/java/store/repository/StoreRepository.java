package store.repository;

import java.util.List;

public interface StoreRepository {
    void saveWeeklyNumbers(List<Integer> weeklyNumbers);
    void saveBonusNumber(int bonusNumber);
    List<Integer> findWeeklyNumbers();
    int findBonusNumber();
}
