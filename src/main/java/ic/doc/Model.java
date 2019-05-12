package ic.doc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Model {

  private Stack<Integer> stack = new Stack<>();
  private List<Updatable> listObservables = new ArrayList<>();

  public void addObserver(Updatable obs) {
    listObservables.add(obs);
  }

  public void integerInput(int i) {
    stack.push(i);
    updateObservers();
  }

  private void updateObservers() {
    for (Updatable obs : listObservables) {
      obs.updateDisplay(latestResult());
    }
  }

  private int latestResult() {
    return stack.peek();
  }

  public void applyOperator(String str) {
    if (stack.size() >= 2) {
      int x = stack.pop();
      int y = stack.pop();
      int result = 0;
      switch(str) {
        case "+": {
          result = x + y;
          break;
        }
        case "-": {
          result = x - y;
          break;
        }
        case "*": {
          result = x * y;
          break;
        }
        case "/": {
          result = x / y;
          break;
        }
        default:
          break;
      }
      stack.push(result);
      updateObservers();
    }
  }
}
