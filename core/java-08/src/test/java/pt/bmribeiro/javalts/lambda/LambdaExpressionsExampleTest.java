
package pt.bmribeiro.javalts.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LambdaExpressionsExampleTest {

    private final LambdaExpressionsExample example =
        new LambdaExpressionsExample();

    @Test
    void shouldFilterNamesUsingImperativeApproach() {
        List<String> names = Arrays.asList(
            "Ana", "Bruno", "António", "Carla", "Alex"
        );

        List<String> result = example.filterNamesImperatively(names);

        assertEquals(
            Arrays.asList("Ana", "António", "Alex"),
            result
        );
    }

    @Test
    void shouldFilterNamesUsingLambdaExpression() {
        List<String> names = Arrays.asList(
            "Ana", "Bruno", "António", "Carla", "Alex"
        );

        List<String> result = example.filterNamesWithLambda(names);

        assertEquals(
            Arrays.asList("Ana", "António", "Alex"),
            result
        );
    }
}
