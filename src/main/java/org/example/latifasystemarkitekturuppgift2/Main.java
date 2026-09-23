package org.example.latifasystemarkitekturuppgift2;

public class Main {

    public static void main(String[] args) {

        Paper paper = new A3Paper();

        Printer printer = new BlackWhitePrinter(paper);

        printer.print("Hello!");
    }
}
