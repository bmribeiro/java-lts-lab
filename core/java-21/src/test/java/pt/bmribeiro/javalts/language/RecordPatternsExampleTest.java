
package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordPatternsExampleTest {

    @Test
    void shouldExtractCoordinatesUsingRecordPattern() {
        RecordPatternsExample.Point point =
            new RecordPatternsExample.Point(10, 20);

        String result = RecordPatternsExample.describePoint(point);

        assertEquals("Point[x=10, y=20]", result);
    }

    @Test
    void shouldReturnNotAPointWhenValueIsNotPoint() {
        String result = RecordPatternsExample.describePoint("not a point");

        assertEquals("Not a point", result);
    }

    @Test
    void shouldReturnNotAPointWhenValueIsNull() {
        String result = RecordPatternsExample.describePoint(null);

        assertEquals("Not a point", result);
    }

    @Test
    void shouldExtractNestedRecordComponents() {
        RecordPatternsExample.Rectangle rectangle =
            new RecordPatternsExample.Rectangle(
                new RecordPatternsExample.Point(0, 0),
                new RecordPatternsExample.Point(100, 50)
            );

        String result =
            RecordPatternsExample.describeRectangle(rectangle);

        assertEquals(
            "Rectangle[(0, 0), (100, 50)]",
            result
        );
    }

    @Test
    void shouldReturnNotARectangleWhenValueIsNotRectangle() {
        String result =
            RecordPatternsExample.describeRectangle("not a rectangle");

        assertEquals("Not a rectangle", result);
    }

    @Test
    void shouldReturnNotARectangleWhenValueIsNull() {
        String result =
            RecordPatternsExample.describeRectangle(null);

        assertEquals("Not a rectangle", result);
    }
}
