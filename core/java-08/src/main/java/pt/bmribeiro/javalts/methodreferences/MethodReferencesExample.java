
package pt.bmribeiro.javalts.methodreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import java.util.stream.Collectors;

public class MethodReferencesExample {

    // 1. Static method reference
    public Integer parseNumber(String value) {
        Function<String, Integer> parser = Integer::parseInt;
        return parser.apply(value);
    }

    // 2. Instance method reference of a specific object
    public String appendName(String name) {
        StringBuilder builder = new StringBuilder();

        Consumer<String> appender = builder::append;
        appender.accept(name);

        return builder.toString();
    }

    // 3. Instance method reference of an arbitrary object
    public List<String> convertToUpperCase(List<String> names) {
        return names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }

    // 4. Constructor reference
    public List<String> copyNames(List<String> names) {
        Function<List<String>, ArrayList<String>> copier =
            ArrayList::new;

        return copier.apply(names);
    }
}
