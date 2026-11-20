package pt.bmribeiro.javalts.language;

import module java.base;

/**
 * Demonstrates Module Import Declarations introduced by JEP 511.
 *
 * JEP: 511
 * Introduced: Java 23 (Preview - JEP 476)
 * Second Preview: Java 24 (JEP 494)
 * Finalized: Java 25
 * Preview: No
 * Compilation: Java 25
 * Category: Language Features
 *
 * Module Import Declarations allow importing all public
 * top-level types from packages exported by a module.
 *
 * The java.base module exports packages such as:
 * - java.lang
 * - java.util
 * - java.util.function
 * - java.util.stream
 * - java.nio.file
 *
 * This eliminates the need for multiple package imports.
 */
public class ModuleImportDeclarationsExample {

    /**
     * Creates a map associating each fruit's initial
     * with its original name.
     *
     * Demonstrates the use of Collections, Streams,
     * Functional Interfaces and utility classes
     * imported through a single module declaration.
     *
     * @param fruits array containing fruit names
     * @return map associating initials with fruit names
     */
    public static Map<String, String> indexByInitial(String... fruits) {

        return Stream.of(fruits)
            .collect(Collectors.toMap(
                fruit -> fruit.substring(0, 1)
                    .toUpperCase(Locale.ROOT),
                Function.identity(),
                (first, second) -> first,
                LinkedHashMap::new
            ));
    }

    public static void main(String[] args) {

        Map<String, String> fruits = indexByInitial(
            "apple",
            "berry",
            "citrus"
        );

        fruits.forEach((initial, fruit) ->
            System.out.println(initial + " -> " + fruit)
        );
    }
}
