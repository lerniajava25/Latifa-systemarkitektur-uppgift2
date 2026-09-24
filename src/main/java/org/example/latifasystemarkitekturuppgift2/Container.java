package org.example.latifasystemarkitekturuppgift2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Container {

    public <T> T getInstance(Class<T> clazz) {

        // Find which concrete class should be created.
        // For example: Paper -> A3Paper.
        Class<?> implementationClass = getImplementation(clazz);
        // Use reflection to find the constructor of the class.
        Constructor<?> constructor = implementationClass.getConstructors()[0];

        // Find which dependencies the constructor needs.
        // For BlackWhitePrinter, this will be Paper.
        Class<?>[] parameterTypes = constructor.getParameterTypes();

        // Create an array to store the dependencies.
        Object[] dependencies = new Object[parameterTypes.length];

        // Create every dependency automatically.
        // getInstance() calls itself, which makes this recursive.
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> implementation = getImplementation(parameterTypes[i]);
            dependencies[i] = getInstance(implementation);
        }

        // Create the requested object and give its dependencies
        // to the constructor.
        try {
            return clazz.cast(constructor.newInstance(dependencies));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    // Decide which implementation to use when an interface is requested.
    // In this project, Paper will be represented by A3Paper.
        private Class<?> getImplementation(Class<?> type) {
            if (type == Paper.class) {
                return A3Paper.class;
            }

            // If it is already a concrete class, use the same class.
            return type;
        }
    }
