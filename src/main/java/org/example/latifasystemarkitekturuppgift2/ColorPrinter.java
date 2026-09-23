package org.example.latifasystemarkitekturuppgift2;

import java.awt.*;

    public class ColorPrinter implements Printer {

        // Dependency
        private final Paper paper;

        //constructor injection
        public ColorPrinter(Paper paper) {
            this.paper = paper;
        }

        // Print method
        @Override
        public void print(String text) {
            System.out.println(text + " printed on " + paper.getSize() + " paper");
        }
    }
