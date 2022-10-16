package org.SDA.FunctionalCalculator;

public class Calculator {
    private final Double a;
    private final Double b;

    public Calculator(Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Double runCalculation(CalculatorFunction function) {
        return function.calculate(a, b);
    }

    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }

    public static void example() {
        Calculator calculator = new Calculator(10.0, 5.0);

        // Traditional approach - define a class AdditionFunction, create an instance, pass the instance as parameter
        AdditionFunction additionFunction = new AdditionFunction();
        Double addResult = calculator.runCalculation(additionFunction);
        System.out.println(addResult);

        // Anonymous approach - pass an anonymous implementation of the CalculatorFunction interface as parameter
        Double subResult = calculator.runCalculation(new CalculatorFunction() {
            @Override
            public Double calculate(Double a, Double b) {
                return a - b;
            }
        });
        System.out.println(subResult);

        // Lambda approach with variable - implement the CalculatorFunction interface with a lambda expression
        // and store it in a variable, then pass it as a parameter
        /*
        @Override
        public Double calculate(Double a, Double b) {
            return a * b;
        }
        */
        CalculatorFunction mulFunction = (a, b) -> a * b;
        Double mulResult = calculator.runCalculation(mulFunction);
        System.out.println(mulResult);

        // Lambda approach without variable - implement the Calculator Function interface directly as a paramter
        Double divResult = calculator.runCalculation((a, b) -> a / b);
        System.out.println(divResult);
    }
}
