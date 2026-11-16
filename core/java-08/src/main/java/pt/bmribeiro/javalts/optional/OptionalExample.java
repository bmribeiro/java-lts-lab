
package pt.bmribeiro.javalts.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalExample {

    private final Map<Long, String> namesById;

    public OptionalExample() {
        namesById = new HashMap<>();
        namesById.put(1L, "Ana");
        namesById.put(2L, "Bruno");
        namesById.put(3L, "Alexandre");
    }

    public Optional<String> findNameById(Long id) {
        return Optional.ofNullable(namesById.get(id));
    }

    public String findNameOrDefault(Long id, String defaultName) {
        return findNameById(id).orElse(defaultName);
    }

    public Optional<Integer> findNameLength(Long id) {
        return findNameById(id).map(String::length);
    }

    public Optional<String> findLongNameById(Long id) {
        return findNameById(id)
            .filter(name -> name.length() > 4);
    }

    public String findNameOrGenerateDefault(Long id) {
        return findNameById(id)
            .orElseGet(() -> "Unknown user");
    }

    public String findNameOrThrow(Long id) {
        return findNameById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("User not found: " + id));
    }
}
