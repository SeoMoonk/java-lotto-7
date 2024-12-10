package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.entity.Lotto;

public class LottoRepositoryImpl implements LottoRepository {

    private List<Lotto> storage = new ArrayList<>();

    @Override
    public void save(Lotto lotto) {
        storage.add(lotto);
    }

    @Override
    public List<Lotto> findAll() {
        List<Lotto> lottos = storage;
        return lottos;
    }
}
