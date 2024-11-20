package oncall;

public class Application {
    public static void main(String[] args) {
        MainController mainController = OnCallFactory.mainController();
        mainController.run();
    }
}
