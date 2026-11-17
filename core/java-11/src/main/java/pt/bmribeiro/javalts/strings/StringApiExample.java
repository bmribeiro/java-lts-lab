
package pt.bmribeiro.javalts.strings;

import java.util.stream.Stream;

public class StringApiExample {

    /**
     * Checks whether a string is empty or contains only whitespace.
     */
    public boolean isBlank(String value) {
        return value.isBlank();
    }

    /**
     * Returns a stream containing the lines of a string.
     */
    public Stream<String> getLines(String value) {
        return value.lines();
    }

    /**
     * Removes leading and trailing whitespace.
     */
    public String strip(String value) {
        return value.strip();
    }

    /**
     * Repeats a string a specified number of times.
     */
    public String repeat(String value, int count) {
        return value.repeat(count);
    }
}
