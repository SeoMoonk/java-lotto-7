package store.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import store.constants.StoreStatic;
import store.repository.StoreRepository;
import store.utils.StoreValidator;

public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<String> splitWeeklyNumbers(String inputWeeklyNumbers) {
        return Arrays.stream(inputWeeklyNumbers.split(StoreStatic.WEEKLY_NUMBERS_SEPARATOR)).toList();
    }

    public void decideWeeklyNumbers(List<String> splitedWeeklyNumbers) {
        List<Integer> weeklyNumbers = new ArrayList<>();
        StoreValidator.weeklyNumbersValidate(splitedWeeklyNumbers);
        for(String weeklyNumber : splitedWeeklyNumbers) {
            weeklyNumbers.add(Integer.parseInt(weeklyNumber));
        }
        saveWeeklyNumbers(weeklyNumbers);
    }

    public void decideBonusNumber(String inputBonusNumber) {
        List<Integer> weeklyNumbers = storeRepository.findWeeklyNumbers();
        StoreValidator.bonusNumberValidate(inputBonusNumber, weeklyNumbers);
        saveBonusNumber(Integer.parseInt(inputBonusNumber));
    }

    private void saveWeeklyNumbers(List<Integer> weeklyNumbers) {
        storeRepository.saveWeeklyNumbers(weeklyNumbers);
    }

    private void saveBonusNumber(int bonusNumber) {
        storeRepository.saveBonusNumber(bonusNumber);
    }
}
