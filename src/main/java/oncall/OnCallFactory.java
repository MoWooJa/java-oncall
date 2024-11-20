package oncall;

public class OnCallFactory {
    public static MainController mainController() {
        return new MainController(inputHandler());
    }

    private static InputHandler inputHandler() {
        return new InputHandler(inputView());
    }

    private static InputView inputView() {
        return new InputView(inputValidator());
    }

    private static InputValidator inputValidator() {
        return new InputValidator();
    }
}
