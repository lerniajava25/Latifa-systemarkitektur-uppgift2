package org.example.latifasystemarkitekturuppgift2;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class A3Paper implements Paper {
    // Implementation of the Paper method
    @Override
    public String getSize() {
        return "A3";
    }
}
