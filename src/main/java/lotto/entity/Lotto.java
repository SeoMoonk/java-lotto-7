package lotto.entity;

import java.util.List;
import lotto.utils.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.lottoNumbersValidate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
