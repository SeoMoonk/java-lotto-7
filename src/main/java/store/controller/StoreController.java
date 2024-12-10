package store.controller;

import global.view.InputView;
import global.view.OutputView;
import java.util.List;
import store.service.StoreService;

public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    public void decideWeeklyLottoNumbers() {
        selectWeeklyNumbers();
        selectBonusNumber();
    }

    private void selectWeeklyNumbers() {
        try {
            String inputWeeklyNumbers = InputView.inputWeeklyNumbers();
            List<String> splitedWeeklyNumbers = storeService.splitWeeklyNumbers(inputWeeklyNumbers);
            storeService.decideWeeklyNumbers(splitedWeeklyNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e.getMessage());
            selectWeeklyNumbers();
        }
    }

    private void selectBonusNumber() {
        try {
            String inputBonusNumber = InputView.inputBonusNumber();
            storeService.decideBonusNumber(inputBonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e.getMessage());
            selectBonusNumber();
        }
    }
}
