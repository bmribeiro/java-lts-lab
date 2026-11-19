
package pt.bmribeiro.javalts.language;

/**
 * Switch Expressions
 *
 * JEP: 361
 * Introduced: Java 12 (Preview)
 * Second Preview: Java 13
 * Finalized: Java 14
 * Target Version: Java 17
 * Category: Language Features
 */
public class SwitchExpressionExample {

    public String getDayType(String day) {

        return switch (day) {
            case "SATURDAY", "SUNDAY" -> "Weekend";

            case "MONDAY", "TUESDAY",
                 "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";

            default -> "Invalid day";
        };
    }

    public String getDayDescription(String day) {

        return switch (day) {
            case "SATURDAY", "SUNDAY" -> {
                String type = "Weekend";
                yield "Day type: " + type;
            }

            case "MONDAY", "TUESDAY",
                 "WEDNESDAY", "THURSDAY", "FRIDAY" -> {
                String type = "Weekday";
                yield "Day type: " + type;
            }

            default -> "Invalid day";
        };
    }
}
