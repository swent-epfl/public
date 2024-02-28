package org.example.steps;

import org.example.calculator.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Step definitions for the calculator feature.
 * Here, we define the TEXTUAL steps that Cucumber
 * will use to execute the feature file.
 */
public class CalculatorSteps {
    private Calculator calculator;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator(0);
    }

    @Given("I have a calculator displaying {int}")
    public void i_have_a_calculator_displaying(int start) {
        calculator = new Calculator(start);
    }

    @When("I add {int}")
    public void i_add(int a) {
        calculator.add(a);
    }

    @When("I subtract {int}")
    public void i_subtract(int a) {
        calculator.subtract(a);
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(expected, calculator.getState());
    }
}
