
package pt.bmribeiro.javalts.text;

/**
 * Text Blocks
 *
 * JEP: 378
 * Introduced: Java 13 (Preview)
 * Second Preview: Java 14
 * Finalized: Java 15
 * Target Version: Java 17
 * Category: Language Features
 */
public class TextBlocksExample {

    public String createJson() {

        return """
                {
                    "name": "Bruno",
                    "role": "Java Developer",
                    "active": true
                }
                """;
    }

    public String createSql() {

        return """
                SELECT id, name, email
                FROM users
                WHERE active = true
                ORDER BY name
                """;
    }

    public String createHtml() {

        return """
                <html>
                    <body>
                        <h1>Java 17</h1>
                        <p>Text Blocks example</p>
                    </body>
                </html>
                """;
    }

    public String createMultilineText() {

        return """
                First line
                Second line
                Third line
                """;
    }

    public String createContinuedLine() {

        return """
                Java is a programming \
                language.
                """;
    }

    public String preserveTrailingSpace() {

        return """
                Java\s
                17
                """;
    }
}
