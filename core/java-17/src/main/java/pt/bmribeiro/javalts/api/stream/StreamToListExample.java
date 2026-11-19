
package pt.bmribeiro.javalts.api.stream;

import java.util.List;

/**
 * Stream.toList()
 *
 * Introduced: Java 16
 * Target Version: Java 17
 * Category: Stream API
 */
public class StreamToListExample {

    public List<String> filterLongNames(List<String> names) {
        return names.stream()
            .filter(name -> name.length() > 3)
            .toList();
    }

    public List<Integer> getEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
            .filter(number -> number % 2 == 0)
            .toList();
    }

    public List<String> convertToUpperCase(List<String> names) {
        return names.stream()
            .map(String::toUpperCase)
            .toList();
    }

    public List<String> getDistinctNames(List<String> names) {
        return names.stream()
            .distinct()
            .toList();
    }
}
