package pt.bmribeiro.javalts.functional;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    /**
     * Returns names that are not null and not empty.
     */
    public List<String> filterNonEmptyNames(List<String> names) {
        return names.stream()
            .filter(Objects::nonNull)
            .filter(Predicate.not(String::isEmpty))
            .collect(Collectors.toList());
    }

    /**
     * Returns strings that contain only whitespace or are empty.
     */
    public List<String> filterBlankStrings(List<String> values) {
        return values.stream()
            .filter(Objects::nonNull)
            .filter(Predicate.not(String::isBlank))
            .collect(Collectors.toList());
    }
}
