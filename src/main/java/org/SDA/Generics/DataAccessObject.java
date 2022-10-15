package org.SDA.Generics;
import java.util.List;

// When generic type extends/implements another generic type, the T doesn't have to be specified
public class DataAccessObject<T> implements DAOInterface<T> {
    private List<T> values;

    private DataAccessObject() {

    }

    private DataAccessObject(List<T> values) {
        this.values = values;
    }

    @Override
    public T getValue(Integer index) {
        return values.get(index);
    }

    @Override
    public void setValue(Integer index, T value) {
        values.set(index, value);
    }

    @Override
    public void addValue(T value) {
        values.add(value);
    }

    @Override
    public void removeValue(T value) {

    }

    @Override
    public void removeAtIndex(Integer index) {

    }

    public static <TDAO> DataAccessObject<TDAO> createDAO() {
        return new DataAccessObject<>();
    }

    public static <TDAO> DataAccessObject<TDAO> createDAO(List<TDAO> initialValues) {
        return new DataAccessObject<>(initialValues);
    }
}
