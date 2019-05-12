package ic.doc;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.apache.tools.ant.taskdefs.UpToDate;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ReversePolishNotationTest {

  Model model = new Model();

//  Mock Object Approach!
//  @Rule
//  public JUnitRuleMockery context = new JUnitRuleMockery();
//  public Updatable display = context.mock(Updatable.class);


  FakeDisplay display = new FakeDisplay();

  class FakeDisplay implements Updatable {

    public int value;

    @Override
    public void updateDisplay(int i) {
      this.value = i;
    }
  }

  @Before
  public void configuration() {
    model.addObserver(display);
  }

  @Test
  public void updatesDisplayAsCalculatiorProceeds() {

//    // Mock Object Approach!
//    context.checking(new Expectations() {
//      {
//        exactly(1).of(display).updateDisplay(1);
//      }
//    });
//
//    model.integerInput(1);

    model.integerInput(1);
    assertThat(display.value, is(1));

    model.integerInput(2);
    assertThat(display.value, is(2));

    model.applyOperator("+");
    assertThat(display.value, is(3));

    model.integerInput(6);
    assertThat(display.value, is(6));

    model.applyOperator("*");
    assertThat(display.value, is(18));

    model.integerInput(22);
    model.applyOperator("-");
    assertThat(display.value, is(4));
  }

  @Test
  public void DoesNotUpdateDisplayWhenInsufficientNumbers() {

    model.integerInput(2);
    model.applyOperator("+");
    assertThat(display.value, is(2));

    model.integerInput(8);
    model.applyOperator("-");
    model.applyOperator("*");
    assertThat(display.value, is(6));

//    // Mock Object Approach!
//    context.checking(new Expectations() {
//      {
//        exactly(1).of(display).updateDisplay(2);
//      }
//    });
//
//    model.integerInput(2);
//
//    context.checking(new Expectations() {
//      {
//        never(display);
//      }
//    });
//
//    model.applyOperator("+");
//
//    context.checking(new Expectations() {
//      {
//        exactly(1).of(display).updateDisplay(8);
//      }
//    });
//
//
//    model.integerInput(8);
//
//    context.checking(new Expectations() {
//      {
//        exactly(1).of(display).updateDisplay(6);
//      }
//    });
//
//    model.applyOperator("-");
//
//    context.checking(new Expectations() {
//      {
//        never(display);
//      }
//    });
//
//    model.applyOperator("*");
  }

}
