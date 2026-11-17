package pt.bmribeiro.javalts.language;

import java.util.function.BiFunction;
import java.util.function.Function;

public class VarLambdaExample {

    /**
     * Concatenates two strings using inferred lambda parameter types.
     */
    public String concatenate(String first, String second) {
        BiFunction<String, String, String> concat =
            (var left, var right) -> left + right;

        return concat.apply(first, second);
    }

    /**
     * Converts a string to uppercase using var in a lambda parameter.
     */
    public String toUpperCase(String value) {
        Function<String, String> converter =
            (var text) -> text.toUpperCase();

        return converter.apply(value);
    }
}
