package org.SDA.Reflection;

import java.lang.reflect.*;

public class StudentReflection {
    public static void displayFields(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            System.out.printf("%s %s%n", field.getName(), field.getType().getSimpleName());
        }

        System.out.println();
    }

    public static void displayMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.printf("%s Returns: %s Parameters: ", method.getName(), method.getReturnType().getSimpleName());
            for (Parameter parameter : method.getParameters()) {
                System.out.printf("%s, ", parameter.getType().getSimpleName());
            }
            System.out.println();
        }
    }

    public static void displayConstructors(Class<?> clazz) {
        Constructor<?>[] ctors = clazz.getDeclaredConstructors();

        for (Constructor<?> ctor : ctors) {
            for (Parameter parameter : ctor.getParameters()) {
                System.out.printf("%s, ", parameter.getType().getSimpleName());
            }
            System.out.println();
        }
    }

    public static Object createObject(Class<?> clazz, Object[] params) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // Get a collection of constructors of given class
        Constructor<?>[] ctors = clazz.getDeclaredConstructors();

        Object object = null;

        // Look for a constructor that matches given params
        for (Constructor<?> ctor : ctors) {
            // Check whether constructor has the same amount of parameters
            Parameter[] ctorParams = ctor.getParameters();
            if (ctorParams.length != params.length)
                continue;

            // Check whether constructor's parameters have the same types in the same order
            Boolean parametersValid = true;

            for (Integer i = 0; i < params.length; i++) {
                Class<?> ctorParamType = ctorParams[i].getType();
                Class<?> paramType = params[i].getClass();

                if (!paramType.equals(ctorParamType)) {
                    parametersValid = false;
                    break;
                }
            }

            if (!parametersValid)
                continue;

            // Create a new instance with this constructor
            object = ctor.newInstance(params);
            break;
        }

        return object;
    }

    public static Object getPrivateField(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);

        return field.get(object);
    }

    public static void setPrivateField(Object object, String fieldName, Object newValue) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);

        if (field.getType().equals(newValue.getClass())) {
            field.set(object, newValue);
        }
    }

    public static Object invokeMethod(Object object, String methodName, Object[] params) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = object.getClass().getDeclaredMethods();

        Object result = null;

        for (Method method : methods) {
            if (!method.getName().equals(methodName))
                continue;

            Parameter[] methodParams = method.getParameters();
            if (methodParams.length != params.length)
                continue;

            Boolean parametersValid = true;

            for (Integer i = 0; i < params.length; i++) {
                Class<?> ctorParamType = methodParams[i].getType();
                Class<?> paramType = params[i].getClass();

                if (!paramType.equals(ctorParamType)) {
                    parametersValid = false;
                    break;
                }
            }

            if (!parametersValid)
                continue;

            result = method.invoke(object, params);

            break;
        }

        return result;
    }
}
