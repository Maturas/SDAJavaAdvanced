package org.SDA.FunctionalCalculator;

public class AdditionFunction implements CalculatorFunction {
    @Override
    public Double calculate(Double a, Double b) {
        return a + b;
    }
}
