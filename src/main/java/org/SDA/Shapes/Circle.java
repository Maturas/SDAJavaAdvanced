package org.SDA.Shapes;

public class Circle extends Shape {
    private final Double r;

    public Circle(Double r) {
        this.r = r;
    }

    @Override
    public Double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public Double getCircumference() {
        return 2 * Math.PI * r;
    }
}
