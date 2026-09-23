package org.example.latifasystemarkitekturuppgift2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Container {

    public <T> T getInstance(Class<T> clazz) {

        Constructor<?> constructor = clazz.getConstructors()[0];

        Class<?>[] parameterTypes = constructor.getParameterTypes();

        Object[] dependencies = new Object[parameterTypes.length];


        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> implementation = getImplementation(parameterTypes[i]);
            dependencies[i] = getInstance(implementation);
        }
        try {
            return clazz.cast(constructor.newInstance(dependencies));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

        private Class<?> getImplementation(Class<?> type) {
            if (type == Paper.class) {
                return A3Paper.class;
            }

            return type;
        }
    }
