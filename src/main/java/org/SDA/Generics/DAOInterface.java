package org.SDA.Generics;

public interface DAOInterface<T> {
    T getValue(Integer index);
    void setValue(Integer index, T value);
    void addValue(T value);
    void removeValue(T value);
    void removeAtIndex(Integer index);
}
