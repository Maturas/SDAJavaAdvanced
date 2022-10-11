package org.SDA.Shapes;

public class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(Double a) {
        super(a, a, a, a * Math.sqrt(3) / 2);
    }
}
