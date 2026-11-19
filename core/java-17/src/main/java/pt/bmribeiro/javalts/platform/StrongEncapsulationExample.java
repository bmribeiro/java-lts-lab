package pt.bmribeiro.javalts.platform;

import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;

/**
 * Strong Encapsulation of JDK Internals
 *
 * JEP: 403
 * Introduced: Java 17
 * Finalized: Java 17
 * Target Version: Java 17
 * Category: Platform / Module System
 */
public class StrongEncapsulationExample {

    public boolean isFieldAccessible(Class<?> type, String fieldName) {
        try {
            Field field = type.getDeclaredField(fieldName);
            return field.trySetAccessible();
        } catch (NoSuchFieldException exception) {
            return false;
        }
    }

    public String getEncapsulationStatus(Class<?> type, String fieldName) {
        try {
            Field field = type.getDeclaredField(fieldName);

            return field.trySetAccessible()
                ? "Accessible"
                : "Strongly encapsulated";
        } catch (NoSuchFieldException exception) {
            return "Field not found";
        } catch (InaccessibleObjectException exception) {
            return "Strongly encapsulated";
        }
    }
}
