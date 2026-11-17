package pt.bmribeiro.javalts.optional;

import java.util.Optional;

public class OptionalExample {

    /**
     * Checks whether an Optional does not contain a value.
     */
    public boolean isEmpty(Optional<String> value) {
        return value.isEmpty();
    }

    /**
     * Returns a message when the Optional is empty.
     */
    public String getStatus(Optional<String> value) {
        if (value.isEmpty()) {
            return "No value present";
        }

        return "Value present: " + value.get();
    }
}
