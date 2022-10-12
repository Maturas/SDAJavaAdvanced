package org.SDA.Shapes;

public class Rectangle extends Shape {
    private final Double a;
    private final Double b;

    public Rectangle(Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Double getArea() {
        return a * b;
    }

    @Override
    public Double getCircumference() {
        return 2 * (a + b);
    }

    public void testChangeOnline() {
        System.out.println("Hello, Online VS Code!");
    }
}
