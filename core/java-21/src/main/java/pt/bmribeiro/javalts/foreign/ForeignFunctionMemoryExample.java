
package pt.bmribeiro.javalts.foreign;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

/**
 * Demonstrates the Foreign Function & Memory API,
 * a Preview API in Java 21.
 *
 * <p>The API provides access to native memory and enables
 * interaction with foreign functions outside the JVM.</p>
 *
 * <p>Arena controls the lifetime of memory segments.
 * MemorySegment represents a region of memory, while
 * ValueLayout describes the data stored in that region.</p>
 *
 * <p>Interview notes:
 * <ul>
 *   <li>MemorySegment represents a region of memory.</li>
 *   <li>Arena manages the lifetime and allocation of memory segments.</li>
 *   <li>ValueLayout describes the type and layout of stored values.</li>
 *   <li>Confined arenas restrict access to their owning thread.</li>
 *   <li>Closing an arena releases its associated native memory.</li>
 *   <li>FFM provides a safer alternative to many JNI use cases.</li>
 *   <li>Native function calls require additional linker and access configuration.</li>
 * </ul>
 * </p>
 *
 * <p>JEP: 442</p>
 * <p>Introduced: Java 19 (JEP 424)</p>
 * <p>Preview: Java 19 (JEP 424), Java 20 (JEP 434),
 * Java 21 (JEP 442)</p>
 * <p>Finalized: Java 22 (JEP 454)</p>
 * <p>Target Version: Java 21</p>
 * <p>Category: Foreign Function & Memory API</p>
 *
 * @see <a href="https://openjdk.org/jeps/442">
 *     JEP 442: Foreign Function & Memory API (Third Preview)</a>
 */
public final class ForeignFunctionMemoryExample {

    private ForeignFunctionMemoryExample() {
    }

    /**
     * Allocates native memory, writes an integer and reads it back.
     *
     * <p>The try-with-resources block ensures that the arena
     * is closed and its memory is released.</p>
     */
    public static int storeAndReadInt(int value) {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment segment = arena.allocate(ValueLayout.JAVA_INT);

            segment.set(ValueLayout.JAVA_INT, 0, value);

            return segment.get(ValueLayout.JAVA_INT, 0);
        }
    }

    /**
     * Allocates native memory for two integers and calculates
     * their sum using memory segment operations.
     */
    public static int sumUsingNativeMemory(int first, int second) {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment segment = arena.allocate(2 * Integer.BYTES);

            segment.set(ValueLayout.JAVA_INT, 0, first);
            segment.set(ValueLayout.JAVA_INT, Integer.BYTES, second);

            int firstValue = segment.get(ValueLayout.JAVA_INT, 0);
            int secondValue = segment.get(ValueLayout.JAVA_INT, Integer.BYTES);

            return firstValue + secondValue;
        }
    }
}
