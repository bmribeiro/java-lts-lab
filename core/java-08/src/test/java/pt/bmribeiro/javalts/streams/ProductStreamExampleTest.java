package pt.bmribeiro.javalts.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductStreamExampleTest {

    private final ProductStreamExample example =
        new ProductStreamExample();

    @Test
    void shouldFindAvailableProducts() {
        List<Product> result = example.findAvailableProducts();

        assertEquals(5, result.size());
        assertTrue(result.stream().allMatch(Product::isAvailable));
    }

    @Test
    void shouldExtractProductNames() {
        List<String> result = example.getProductNames();

        assertEquals(6, result.size());
        assertEquals("Laptop", result.get(0));
    }

    @Test
    void shouldSortProductsByPrice() {
        List<Product> result = example.sortProductsByPrice();

        assertEquals("Mouse", result.get(0).getName());
        assertEquals("Laptop", result.get(5).getName());
    }

    @Test
    void shouldReturnDistinctCategories() {
        List<String> result = example.getDistinctCategories();

        assertEquals(
            Arrays.asList("Electronics", "Furniture"),
            result
        );
    }

    @Test
    void shouldCalculateTotalPrice() {
        assertEquals(2080.00, example.calculateTotalPrice(), 0.001);
    }

    @Test
    void shouldGroupProductsByCategory() {
        Map<String, List<Product>> result =
            example.groupByCategory();

        assertEquals(4, result.get("Electronics").size());
        assertEquals(2, result.get("Furniture").size());
    }
}
