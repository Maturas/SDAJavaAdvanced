package org.SDA;

import org.SDA.Annotations.ExampleClass;
import org.SDA.Reflection.Student;
import org.SDA.Reflection.StudentReflection;

import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main( String[] args ) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        ExampleClass.testAnnotations(ExampleClass.class);
        ExampleClass.getMySingleValueAnnotationFromMethod(ExampleClass.class.getMethod("markedMultiValueMethod"));
    }
}
