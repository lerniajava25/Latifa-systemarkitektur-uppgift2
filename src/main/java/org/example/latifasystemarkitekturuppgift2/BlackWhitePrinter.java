package org.example.latifasystemarkitekturuppgift2;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BlackWhitePrinter implements Printer {

    // Dependency
    private final Paper paper;

    //constructor injection
    @Inject
    public BlackWhitePrinter(Paper paper) {
        this.paper = paper;
    }


    // Print method
    @Override
    public void print(String text) {
        System.out.println(text + " printed in black and white on "
                + paper.getSize() + " paper");
    }
}
