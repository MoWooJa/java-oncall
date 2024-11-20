package oncall;

import oncall.config.AppConfig;
import oncall.controller.OncallController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OncallController oncallController = AppConfig.oncallController();
        oncallController.run();
    }
}
