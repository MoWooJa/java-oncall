package oncall.config;

import oncall.controller.OncallController;
import oncall.service.DomainService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {

    public OncallController oncallController() {
        return new OncallController(inputView(), outputView(), domainService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView():
    }

    private DomainService domainService() {
        return new DomainService();
    }
}
