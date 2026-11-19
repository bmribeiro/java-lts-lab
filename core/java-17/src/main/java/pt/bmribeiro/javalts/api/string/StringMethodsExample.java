package pt.bmribeiro.javalts.api.string;

import java.util.Locale;

/**
 * String.indent() and String.transform()
 *
 * Introduced: Java 12
 * Target Version: Java 17
 * Category: String API
 */
public class StringMethodsExample {

    public String indentText(String text, int indentation) {
        return text.indent(indentation);
    }

    public String normalizeText(String text) {
        return text.transform(String::trim)
            .transform(value -> value.toUpperCase(Locale.ROOT));
    }

    public Integer getTextLength(String text) {
        return text.transform(String::length);
    }

    public String addPrefix(String text, String prefix) {
        return text.transform(value -> prefix + value);
    }

    public String reverseText(String text) {
        return text.transform(value ->
            new StringBuilder(value).reverse().toString()
        );
    }
}
