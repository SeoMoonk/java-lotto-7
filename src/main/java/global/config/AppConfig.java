package global.config;

import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class AppConfig {

    private final LottoInputView lottoInputView = new LottoInputView();
    private final LottoOutputView lottoOutputView = new LottoOutputView();
    private final LottoController lottoController;
    private final LottoService lottoService;
    private final LottoRepository lottoRepository;

    public AppConfig() {
        lottoRepository = new LottoRepositoryImpl();
        lottoService = new LottoService(lottoRepository);
        lottoController = new LottoController(lottoInputView, lottoOutputView, lottoService);
    }

    public LottoController getLottoController() {
        return lottoController;
    }
}
