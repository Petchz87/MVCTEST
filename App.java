import Controller.QueryController;
import Model.QueryEngine;
import View.QueryView;

public class App {
    public static void main(String[] args) {
        QueryEngine model = new QueryEngine();
        QueryView view = new QueryView();
        QueryController controller = new QueryController(model, view);
        view.createGUI(controller);
    }
}
