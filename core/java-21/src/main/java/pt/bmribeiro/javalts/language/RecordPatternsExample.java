package pt.bmribeiro.javalts.language;

/**
 * Demonstrates Record Patterns introduced by JEP 440.
 *
 * <h2>Introduction</h2>
 * Record Patterns allow record components to be extracted directly
 * through pattern matching, avoiding explicit accessor calls.
 *
 * They simplify the inspection and decomposition of structured data,
 * including nested records.
 *
 * <h2>Key Concepts</h2>
 * <ul>
 *     <li>Deconstruct records directly in pattern matching expressions.</li>
 *     <li>Extract record components using positional patterns.</li>
 *     <li>Support nested record patterns.</li>
 *     <li>Can be combined with instanceof and switch pattern matching.</li>
 * </ul>
 *
 * <h2>Interview Notes</h2>
 * <ul>
 *     <li>
 *         Record Patterns vs Records:
 *         Records define data carriers; Record Patterns provide a concise
 *         way to extract their components.
 *     </li>
 *     <li>
 *         Nested Patterns:
 *         A record pattern can contain other record patterns,
 *         allowing recursive decomposition of structured data.
 *     </li>
 *     <li>
 *         Accessors:
 *         Component accessors are invoked during pattern matching.
 *     </li>
 * </ul>
 *
 * JEP: 440
 * Introduced: Java 19 (JEP 405)
 * Preview: Java 19 (JEP 405), Java 20 (JEP 432)
 * Finalized: Java 21
 * Target Version: Java 21
 * Category: Language Features
 *
 * @see <a href="https://openjdk.org/jeps/440">JEP 440: Record Patterns</a>
 */
public final class RecordPatternsExample {

    private RecordPatternsExample() {
    }

    /**
     * Extracts the coordinates of a Point using a Record Pattern.
     *
     * @param value the object to inspect
     * @return the formatted coordinates, or "Not a point" if the object
     *         is not a Point
     */
    public static String describePoint(Object value) {

        if (value instanceof Point(int x, int y)) {
            return "Point[x=" + x + ", y=" + y + "]";
        }

        return "Not a point";
    }

    /**
     * Extracts coordinates from a Rectangle containing two nested Points.
     *
     * @param value the object to inspect
     * @return the formatted rectangle coordinates, or "Not a rectangle"
     */
    public static String describeRectangle(Object value) {

        if (value instanceof Rectangle(
            Point(int x1, int y1),
            Point(int x2, int y2)
        )) {
            return "Rectangle[(" + x1 + ", " + y1 + "), ("
                + x2 + ", " + y2 + ")]";
        }

        return "Not a rectangle";
    }

    /**
     * Represents a two-dimensional point.
     *
     * @param x horizontal coordinate
     * @param y vertical coordinate
     */
    public record Point(int x, int y) {
    }

    /**
     * Represents a rectangle defined by two points.
     *
     * @param topLeft top-left point
     * @param bottomRight bottom-right point
     */
    public record Rectangle(Point topLeft, Point bottomRight) {
    }
}
