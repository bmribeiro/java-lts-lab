package pt.bmribeiro.javalts.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExpressionsExample {

    /**
     * Filters names starting with "A" using an imperative approach.
     */
    public List<String> filterNamesImperatively(List<String> names) {
        List<String> result = new ArrayList<>();

        for (String name : names) {
            if (name.startsWith("A")) {
                result.add(name);
            }
        }

        return result;
    }

    /**
     * Filters names starting with "A" using a lambda expression and Stream API.
     */
    public List<String> filterNamesWithLambda(List<String> names) {
        return names.stream()
            .filter(name -> name.startsWith("A"))
            .collect(Collectors.toList());
    }
}
