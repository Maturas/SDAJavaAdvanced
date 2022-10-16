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

    public Calculator runCalculations(CalculatorFunction functionA, CalculatorFunction functionB) {
        Double newA = functionA.calculate(a, b);
        Double newB = functionB.calculate(a, b);

        return new Calculator(newA, newB);
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

        // Calculation sequence
        // A = 100 X
        // B = 50 X
        // A + B = 150 -> new A X
        // B -> new B X
        // 150, 50 X
        // A * B = 7500 -> new A X
        // B -> 3 X
        // A / B = 2500 -> new A X
        // B * 2 = 15000 -> new B X
        // result = A + B

        // Imperative approach - a sequence of instructions
        Calculator calc = new Calculator(100.0, 50.0);
        calc = new Calculator(calc.runCalculation((a, b) -> a + b), calc.getB());
        calc = new Calculator(calc.runCalculation((a, b) -> a * b), 3.0);
        calc = new Calculator(calc.runCalculation((a, b) -> a / b), calc.runCalculation((a, b) -> b * 2));
        Double result = calc.runCalculation((a, b) -> a + b);
        System.out.println(result);

        // Functional approach - a sequence of functions, passing their results one to another
        Double functionalResult = new Calculator(100.0, 50.0)
                .runCalculations((a, b) -> a + b, (a, b) -> b)
                .runCalculations((a, b) -> a * b, (a, b) -> 3.0)
                .runCalculations((a, b) -> a / b, (a, b) -> b * 2)
                .runCalculation((a, b) -> a + b);
        System.out.println(functionalResult);
    }
}
