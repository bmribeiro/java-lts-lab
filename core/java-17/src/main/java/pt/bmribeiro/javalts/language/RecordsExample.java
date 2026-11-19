package pt.bmribeiro.javalts.language;

/**
 * Records
 *
 * JEP: 395
 * Introduced: Java 14 (Preview)
 * Second Preview: Java 15
 * Finalized: Java 16
 * Target Version: Java 17
 * Category: Language Features
 */
public class RecordsExample {

    public record Employee(
        Long id,
        String name,
        String department
    ) {
    }

    public record Product(
        Long id,
        String name,
        double price
    ) {

        public Product {
            if (id == null || id <= 0) {
                throw new IllegalArgumentException("Invalid product ID");
            }

            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Product name is required");
            }

            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be negative");
            }

            name = name.strip();
        }

        public boolean isExpensive() {
            return price > 1000;
        }

        public static String category() {
            return "Electronics";
        }
    }

    public Employee createEmployee(
        Long id,
        String name,
        String department
    ) {
        return new Employee(id, name, department);
    }

    public Product createProduct(
        Long id,
        String name,
        double price
    ) {
        return new Product(id, name, price);
    }

    public String getEmployeeInformation(Employee employee) {
        return employee.id() + " - "
            + employee.name() + " - "
            + employee.department();
    }
}
