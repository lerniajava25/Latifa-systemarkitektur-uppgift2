package org.example.latifasystemarkitekturuppgift2;

public class Main {

    public static void main(String[] args) {

        Container container = new Container();

        // Ask the container to create BlackWhitePrinter and its dependencies.
        BlackWhitePrinter printer =
                container.getInstance(BlackWhitePrinter.class);

        // Use the created printer.
               printer.print("Hello!");
    }
}
