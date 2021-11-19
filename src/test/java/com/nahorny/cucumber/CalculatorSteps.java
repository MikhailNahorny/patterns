package com.nahorny.cucumber;

import com.nahorny.automationqa.rest.Calculator;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CalculatorSteps {

    private Calculator calc;

    double a;
    double b;
    double result;

    @Before
    public void setUp() {
        this.calc = new Calculator();
    }

    @After
    public void cleanUp() {
        this.calc = null;
    }

    private void set_given_args(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Given("^one number -(\\d+)$")
    public void given_5(double a) {
        this.a = -a;
    }

    @Given("^one number (\\d)$")
    public void given_6(double a) {
        this.a = a;
    }

    @Given("^two numbers -(\\d+) and (\\d+)$")
    public void given_1(double a, double b) {
        set_given_args(-a, b);
    }

    @Given("^two numbers -(\\d+) and -(\\d+)$")
    public void given_2(double a, double b) {
        set_given_args(-a, -b);
    }

    @Given("^two numbers (\\d+) and -(\\d+)$")
    public void given_4(double a, double b) {
        set_given_args(a, -b);
    }

    @Given("^two numbers (\\d) and (\\d)")
    public void given_3(double a, double b) {
        set_given_args(a, b);
    }

    @When("^we try to find sum of our numbers")
    public void when_1() {
        result = calc.sum(a, b);
    }

    @When("^we try to find pow of the number")
    public void when_2() {
        result = calc.pow(a);
    }

    @Then("^result should be (\\d)")
    public void then_1(double res) {
        Assert.assertEquals(res, result, 0.0001);
    }

    @Then("^result should be -(\\d+)")
    public void then_2(double res) {
        Assert.assertEquals(-res, result, 0.0001);
    }

    @When("^just example of DataTable $")
    public void enterData(DataTable table) {
        //Initialize data table
        List<List<String>> data = table.raw();
        System.out.println(data.get(1).get(1));
    }
}
