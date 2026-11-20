
package pt.bmribeiro.javalts.foreign;

import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

/**
 * JEP: 412
 * Introduced: Java 17
 * Incubator: Java 17 (First Incubator)
 * Finalized: Java 22 (JEP 454)
 * Target Version: Java 17
 * Category: Foreign Function & Memory API
 *
 * Demonstrates native memory allocation and access
 * using the Java 17 incubator API.
 */
public class ForeignMemoryExample {

    /**
     * Allocates native memory, stores an integer and reads it back.
     *
     * @param value integer to store in native memory
     * @return value read from native memory
     */
    public int storeAndReadInteger(int value) {
        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            MemorySegment segment = MemorySegment.allocateNative(
                Integer.BYTES,
                scope
            );

            MemoryAccess.setIntAtOffset(segment, 0, value);

            return MemoryAccess.getIntAtOffset(segment, 0);
        }
    }

    /**
     * Returns the size of an integer in bytes.
     *
     * @return integer size in bytes
     */
    public long getIntegerSize() {
        return Integer.BYTES;
    }

    /**
     * Allocates native memory for an integer and reports its size.
     *
     * @return allocated memory size
     */
    public long getAllocatedMemorySize() {
        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            MemorySegment segment = MemorySegment.allocateNative(
                Integer.BYTES,
                scope
            );

            return segment.byteSize();
        }
    }
}
