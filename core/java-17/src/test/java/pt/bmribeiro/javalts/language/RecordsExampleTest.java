
package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecordsExampleTest {

    private RecordsExample example;

    @BeforeEach
    void setUp() {
        example = new RecordsExample();
    }

    @Test
    void shouldCreateEmployeeRecord() {

        RecordsExample.Employee employee =
            example.createEmployee(1L, "Bruno", "IT");

        assertEquals(1L, employee.id());
        assertEquals("Bruno", employee.name());
        assertEquals("IT", employee.department());
    }

    @Test
    void shouldGenerateEmployeeToString() {

        RecordsExample.Employee employee =
            new RecordsExample.Employee(1L, "Bruno", "IT");

        assertEquals(
            "Employee[id=1, name=Bruno, department=IT]",
            employee.toString()
        );
    }

    @Test
    void shouldGenerateEmployeeEqualsAndHashCode() {

        RecordsExample.Employee first =
            new RecordsExample.Employee(1L, "Bruno", "IT");

        RecordsExample.Employee second =
            new RecordsExample.Employee(1L, "Bruno", "IT");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void shouldNotConsiderDifferentEmployeesEqual() {

        RecordsExample.Employee first =
            new RecordsExample.Employee(1L, "Bruno", "IT");

        RecordsExample.Employee second =
            new RecordsExample.Employee(2L, "Bruno", "IT");

        assertNotEquals(first, second);
    }

    @Test
    void shouldCreateProductRecord() {

        RecordsExample.Product product =
            example.createProduct(1L, "Laptop", 1299.99);

        assertEquals(1L, product.id());
        assertEquals("Laptop", product.name());
        assertEquals(1299.99, product.price(), 0.001);
    }

    @Test
    void shouldRemoveLeadingAndTrailingWhitespaceFromProductName() {

        RecordsExample.Product product =
            new RecordsExample.Product(1L, "  Laptop  ", 1299.99);

        assertEquals("Laptop", product.name());
    }

    @Test
    void shouldRejectInvalidProductId() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new RecordsExample.Product(0L, "Laptop", 1299.99)
        );
    }

    @Test
    void shouldRejectNullProductId() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new RecordsExample.Product(null, "Laptop", 1299.99)
        );
    }

    @Test
    void shouldRejectBlankProductName() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new RecordsExample.Product(1L, "   ", 1299.99)
        );
    }

    @Test
    void shouldRejectNullProductName() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new RecordsExample.Product(1L, null, 1299.99)
        );
    }

    @Test
    void shouldRejectNegativeProductPrice() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new RecordsExample.Product(1L, "Laptop", -10.0)
        );
    }

    @Test
    void shouldIdentifyExpensiveProduct() {

        RecordsExample.Product product =
            new RecordsExample.Product(1L, "Laptop", 1299.99);

        assertTrue(product.isExpensive());
    }

    @Test
    void shouldIdentifyNonExpensiveProduct() {

        RecordsExample.Product product =
            new RecordsExample.Product(2L, "Mouse", 29.99);

        assertFalse(product.isExpensive());
    }

    @Test
    void shouldReturnProductCategory() {

        assertEquals(
            "Electronics",
            RecordsExample.Product.category()
        );
    }

    @Test
    void shouldFormatEmployeeInformation() {

        RecordsExample.Employee employee =
            new RecordsExample.Employee(1L, "Bruno", "IT");

        assertEquals(
            "1 - Bruno - IT",
            example.getEmployeeInformation(employee)
        );
    }
}
