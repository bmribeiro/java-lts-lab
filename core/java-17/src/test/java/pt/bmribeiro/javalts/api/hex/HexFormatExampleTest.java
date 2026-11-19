
package pt.bmribeiro.javalts.api.hex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HexFormatExampleTest {

    private final HexFormatExample example = new HexFormatExample();

    @Test
    void shouldFormatBytesAsHexadecimal() {
        byte[] data = {10, 20, 30};

        assertEquals("0a141e", example.formatBytes(data));
    }

    @Test
    void shouldParseHexadecimalIntoBytes() {
        byte[] expected = {10, 20, 30};

        assertArrayEquals(
            expected,
            example.parseHex("0a141e")
        );
    }

    @Test
    void shouldFormatBytesWithDelimiterAndUpperCase() {
        byte[] data = {10, 20, 30};

        assertEquals(
            "0A:14:1E",
            example.formatBytesWithDelimiter(data)
        );
    }

    @Test
    void shouldFormatBytesAsUpperCase() {
        byte[] data = {10, 20, 30};

        assertEquals(
            "0A141E",
            example.formatBytesAsUpperCase(data)
        );
    }

    @Test
    void shouldReturnTrueForValidHexadecimal() {
        assertTrue(example.isValidHex("0a141e"));
        assertTrue(example.isValidHex("ABCDEF"));
    }

    @Test
    void shouldReturnFalseForInvalidHexadecimal() {
        assertFalse(example.isValidHex("0a14xz"));
        assertFalse(example.isValidHex("123"));
    }

    @Test
    void shouldFormatEmptyArrayAsEmptyString() {
        assertEquals("", example.formatBytes(new byte[0]));
    }

    @Test
    void shouldParseEmptyStringAsEmptyArray() {
        assertArrayEquals(
            new byte[0],
            example.parseHex("")
        );
    }
}
