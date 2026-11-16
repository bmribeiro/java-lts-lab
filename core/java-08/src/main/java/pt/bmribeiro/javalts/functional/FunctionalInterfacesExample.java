package pt.bmribeiro.javalts.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesExample {

    public boolean isLongName(String name) {
        Predicate<String> predicate =
            value -> value.length() > 5;

        return predicate.test(name);
    }

    public String printName(String name) {
        StringBuilder result = new StringBuilder();

        Consumer<String> consumer = result::append;
        consumer.accept(name);

        return result.toString();
    }

    public String getDefaultGreeting() {
        Supplier<String> supplier =
            () -> "Hello, Java 8!";

        return supplier.get();
    }

    public Integer getNameLength(String name) {
        Function<String, Integer> function =
            value -> value.length();

        return function.apply(name);
    }
}
