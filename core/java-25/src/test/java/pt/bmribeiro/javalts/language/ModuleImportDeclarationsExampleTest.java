package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModuleImportDeclarationsExampleTest {

    @Test
    void shouldIndexFruitsByInitial() {

        Map<String, String> result =
            ModuleImportDeclarationsExample.indexByInitial(
                "apple",
                "berry",
                "citrus"
            );

        assertEquals(
            Map.of(
                "A", "apple",
                "B", "berry",
                "C", "citrus"
            ),
            result
        );
    }

    @Test
    void shouldKeepFirstFruitWhenInitialIsRepeated() {

        Map<String, String> result =
            ModuleImportDeclarationsExample.indexByInitial(
                "apple",
                "apricot",
                "berry"
            );

        assertEquals(
            Map.of(
                "A", "apple",
                "B", "berry"
            ),
            result
        );
    }

    @Test
    void shouldReturnEmptyMapWhenNoFruitsAreProvided() {

        Map<String, String> result =
            ModuleImportDeclarationsExample.indexByInitial();

        assertEquals(Map.of(), result);
    }
}
