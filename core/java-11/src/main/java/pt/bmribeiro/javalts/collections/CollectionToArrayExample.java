package pt.bmribeiro.javalts.collections;

import java.util.Collection;

public class CollectionToArrayExample {

    /**
     * Converts a collection of strings into a String array.
     */
    public String[] toStringArray(Collection<String> values) {
        return values.toArray(String[]::new);
    }

    /**
     * Converts a collection of integers into an Integer array.
     */
    public Integer[] toIntegerArray(Collection<Integer> values) {
        return values.toArray(Integer[]::new);
    }
}
