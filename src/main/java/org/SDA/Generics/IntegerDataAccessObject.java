package org.SDA.Generics;

// When non-generic type extends/implements a generic type, the T has to be specified
public class IntegerDataAccessObject implements DAOInterface<Integer> {
    @Override
    public Integer getValue(Integer index) {
        return null;
    }

    @Override
    public void setValue(Integer index, Integer value) {

    }

    @Override
    public void addValue(Integer value) {

    }

    @Override
    public void removeValue(Integer value) {

    }

    @Override
    public void removeAtIndex(Integer index) {

    }
}
