package org.example.latifasystemarkitekturuppgift2;

public class Main {

    public static void main(String[] args) {

        Container container = new Container();

        BlackWhitePrinter printer =
                container.getInstance(BlackWhitePrinter.class);

        printer.print("Hello!");
    }
}
