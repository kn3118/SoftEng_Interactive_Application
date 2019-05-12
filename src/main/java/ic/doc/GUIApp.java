package ic.doc;

public class GUIApp {

  public GUIApp() {

    Model model = new Model();
    CalculationController controller = new CalculationController(model);
    Updatable view = new View(controller);

    model.addObserver(view);

  }

  public static void main(String args[]) {
    new GUIApp();
  }
}
