package pt.bmribeiro.javalts.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TextBlocksExampleTest {

    private TextBlocksExample example;

    @BeforeEach
    void setUp() {
        example = new TextBlocksExample();
    }

    @Test
    void shouldCreateJsonUsingTextBlock() {

        String expected = """
                {
                    "name": "Bruno",
                    "role": "Java Developer",
                    "active": true
                }
                """;

        assertEquals(expected, example.createJson());
    }

    @Test
    void shouldCreateSqlUsingTextBlock() {

        String expected = """
                SELECT id, name, email
                FROM users
                WHERE active = true
                ORDER BY name
                """;

        assertEquals(expected, example.createSql());
    }

    @Test
    void shouldCreateHtmlUsingTextBlock() {

        String result = example.createHtml();

        assertTrue(result.contains("<html>"));
        assertTrue(result.contains("<h1>Java 17</h1>"));
        assertTrue(result.contains("</html>"));
    }

    @Test
    void shouldCreateMultilineText() {

        String expected = """
                First line
                Second line
                Third line
                """;

        assertEquals(expected, example.createMultilineText());
    }

    @Test
    void shouldContinueLineWithoutAddingLineBreak() {

        assertEquals(
            "Java is a programming language.\n",
            example.createContinuedLine()
        );
    }

    @Test
    void shouldPreserveTrailingSpace() {

        assertEquals(
            "Java \n17\n",
            example.preserveTrailingSpace()
        );
    }
}
