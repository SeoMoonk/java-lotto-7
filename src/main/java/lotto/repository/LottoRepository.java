package lotto.repository;

import java.util.List;
import lotto.entity.Lotto;

public interface LottoRepository {
    void save(Lotto lotto);
    List<Lotto> findAll();
}
