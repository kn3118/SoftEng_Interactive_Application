package ic.doc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View implements Updatable {

  JTextField textField = new JTextField(10);
  JPanel panel = new JPanel();

  public View(CalculationController controller) {

    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(500, 500);

    panel.add(textField);

    initialiseButtons(controller);

    frame.getContentPane().add(panel);

    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void updateDisplay(int i) {
    textField.setText(String.valueOf(i));
  }

  private void initialiseButtons(CalculationController controller) {
    for (int i = 1; i < 5; i++) {
      panel.add(controller.intButton(i));
    }

    panel.add(controller.operatorButton("+"));
    panel.add(controller.operatorButton("-"));
    panel.add(controller.operatorButton("*"));
    panel.add(controller.operatorButton("/"));
  }

}
