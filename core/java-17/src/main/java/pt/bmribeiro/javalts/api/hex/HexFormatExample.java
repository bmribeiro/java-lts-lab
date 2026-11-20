package pt.bmribeiro.javalts.api.hex;

import java.util.HexFormat;

/**
 * HexFormat
 * <p>
 * Introduced: Java 17
 * Finalized: Java 17
 * Target Version: Java 17
 * Category: Hexadecimal API
 */
public class HexFormatExample {

    private final HexFormat hexFormat = HexFormat.of();

    public String formatBytes(byte[] bytes) {
        return hexFormat.formatHex(bytes);
    }

    public byte[] parseHex(String hexadecimal) {
        return hexFormat.parseHex(hexadecimal);
    }

    public String formatBytesWithDelimiter(byte[] bytes) {
        return HexFormat.ofDelimiter(":")
            .withUpperCase()
            .formatHex(bytes);
    }

    public String formatBytesAsUpperCase(byte[] bytes) {
        return hexFormat.withUpperCase().formatHex(bytes);
    }

    public boolean isValidHex(String hexadecimal) {
        try {
            hexFormat.parseHex(hexadecimal);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
