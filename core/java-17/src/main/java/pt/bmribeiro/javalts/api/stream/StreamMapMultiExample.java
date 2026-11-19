package pt.bmribeiro.javalts.api.stream;

import java.util.List;

/**
 * Stream.mapMulti()
 *
 * Introduced: Java 16
 * Target Version: Java 17
 * Category: Stream API
 */
public class StreamMapMultiExample {

    public List<String> expandCharacters(List<String> words) {
        return words.stream()
            .<String>mapMulti((word, consumer) -> {
                for (char character : word.toCharArray()) {
                    consumer.accept(String.valueOf(character));
                }
            })
            .toList();
    }

    public List<Integer> expandNumbers(List<Integer> numbers) {
        return numbers.stream()
            .<Integer>mapMulti((number, consumer) -> {
                if (number > 0) {
                    consumer.accept(number);
                    consumer.accept(number * 2);
                }
            })
            .toList();
    }

    public List<String> filterAndExpand(List<String> words) {
        return words.stream()
            .<String>mapMulti((word, consumer) -> {
                if (word.length() > 3) {
                    consumer.accept(word);
                    consumer.accept(word.toUpperCase());
                }
            })
            .toList();
    }

    public List<String> extractNonEmptyWords(List<String> words) {
        return words.stream()
            .<String>mapMulti((word, consumer) -> {
                if (word != null && !word.isBlank()) {
                    consumer.accept(word.trim());
                }
            })
            .toList();
    }
}
