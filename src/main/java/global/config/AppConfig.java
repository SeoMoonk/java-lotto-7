package global.config;

import global.view.InputView;
import global.view.OutputView;
import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import lotto.service.LottoService;
import store.controller.StoreController;
import store.repository.StoreRepository;
import store.repository.StoreRepositoryImpl;
import store.service.StoreService;

public class AppConfig {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoController lottoController;
    private final LottoService lottoService;
    private final LottoRepository lottoRepository;
    private final StoreController storeController;
    private final StoreService storeService;
    private final StoreRepository storeRepository;

    public AppConfig() {
        lottoRepository = new LottoRepositoryImpl();
        lottoService = new LottoService(lottoRepository);
        lottoController = new LottoController(lottoService);
        storeRepository = new StoreRepositoryImpl();
        storeService = new StoreService(storeRepository);
        storeController = new StoreController(storeService);
    }

    public LottoController getLottoController() {
        return lottoController;
    }

    public StoreController getStoreController() {
        return storeController;
    }
}
