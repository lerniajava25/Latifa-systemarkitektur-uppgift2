package org.example.latifasystemarkitekturuppgift2;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


    public class Main {

        public static void main(String[] args) {

            try (WeldContainer container = new Weld().initialize()) {

                BlackWhitePrinter printer =
                        container.select(BlackWhitePrinter.class).get();

                printer.print("Hello!");
            }
        }
    }
