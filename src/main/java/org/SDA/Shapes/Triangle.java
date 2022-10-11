package org.SDA.Shapes;

public class Triangle extends Shape {
    private final Double a;
    private final Double b;
    private final Double c;
    private final Double h;

    public Triangle(Double a, Double b, Double c, Double h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    public Double getArea() {
        return a * h / 2;
    }

    @Override
    public Double getCircumference() {
        return a + b + c;
    }
}
