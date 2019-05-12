package ic.doc;

import javax.swing.JButton;

public class CalculationController {

  private final Model model;

  public CalculationController(Model model) {
    this.model = model;
  }

  public JButton intButton(int i) {
    JButton button = new JButton(String.valueOf(i));
    button.addActionListener(e -> model.integerInput(i));
    return button;
  }

  public JButton operatorButton(String str) {
    JButton button = new JButton(str);
    button.addActionListener(e -> model.applyOperator(str));
    return button;
  }

}
