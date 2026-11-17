
package pt.bmribeiro.javalts.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdvancedStreamExampleTest {

    private AdvancedStreamExample example;

    @BeforeEach
    void setUp() {
        example = new AdvancedStreamExample();
    }

    @Test
    void shouldFlattenNestedTagLists() {
        List<List<String>> tags = Arrays.asList(
            Arrays.asList("electronics", "portable"),
            Arrays.asList("electronics", "wireless"),
            Arrays.asList("furniture", "office")
        );

        List<String> result = example.flattenTags(tags);

        assertEquals(
            Arrays.asList(
                "electronics", "portable",
                "electronics", "wireless",
                "furniture", "office"
            ),
            result
        );
    }

    @Test
    void shouldReturnDistinctTags() {
        List<List<String>> tags = Arrays.asList(
            Arrays.asList("electronics", "portable"),
            Arrays.asList("electronics", "wireless"),
            Arrays.asList("furniture", "office")
        );

        List<String> result = example.getDistinctTags(tags);

        assertEquals(
            Arrays.asList(
                "electronics", "portable",
                "wireless", "furniture", "office"
            ),
            result
        );
    }

    @Test
    void shouldFilterTagsByPrefix() {
        List<List<String>> tags = Arrays.asList(
            Arrays.asList("electronics", "portable"),
            Arrays.asList("electronics", "wireless"),
            Arrays.asList("furniture", "office")
        );

        List<String> result =
            example.getTagsStartingWith(tags, "elec");

        assertEquals(
            Collections.singletonList("electronics"),
            result
        );
    }

    @Test
    void shouldReturnEmptyListWhenInputIsEmpty() {
        List<String> result =
            example.flattenTags(Collections.<List<String>>emptyList());

        assertEquals(Collections.emptyList(), result);
    }


    @Test
    void shouldPartitionProductsByAvailability() {
        List<Product> products = Arrays.asList(
            new Product(1L, "Laptop", "Electronics", 1200.0, true),
            new Product(2L, "Mouse", "Electronics", 25.0, true),
            new Product(3L, "Keyboard", "Electronics", 75.0, false),
            new Product(4L, "Desk", "Furniture", 250.0, true)
        );

        Map<Boolean, List<Product>> result =
            example.partitionByAvailability(products);

        assertEquals(3, result.get(true).size());
        assertEquals(1, result.get(false).size());
        assertEquals("Keyboard", result.get(false).get(0).getName());
    }

    @Test
    void shouldPartitionProductsByMinimumPrice() {
        List<Product> products = Arrays.asList(
            new Product(1L, "Laptop", "Electronics", 1200.0, true),
            new Product(2L, "Mouse", "Electronics", 25.0, true),
            new Product(3L, "Keyboard", "Electronics", 75.0, false),
            new Product(4L, "Desk", "Furniture", 250.0, true)
        );

        Map<Boolean, List<Product>> result =
            example.partitionByPrice(products, 100.0);

        assertEquals(2, result.get(true).size());
        assertEquals(2, result.get(false).size());

        assertTrue(result.get(true).stream()
            .allMatch(product -> product.getPrice() >= 100.0));
    }


    @Test
    void shouldGroupProductNamesByCategory() {
        List<Product> products = Arrays.asList(
            new Product(1L, "Laptop", "Electronics", 1200.0, true),
            new Product(2L, "Mouse", "Electronics", 25.0, true),
            new Product(3L, "Keyboard", "Electronics", 75.0, false),
            new Product(4L, "Desk", "Furniture", 250.0, true),
            new Product(5L, "Chair", "Furniture", 180.0, true),
            new Product(6L, "Monitor", "Electronics", 350.0, true)
        );

        Map<String, List<String>> result =
            example.getProductNamesByCategory(products);

        assertEquals(
            Arrays.asList("Laptop", "Mouse", "Keyboard", "Monitor"),
            result.get("Electronics")
        );

        assertEquals(
            Arrays.asList("Desk", "Chair"),
            result.get("Furniture")
        );
    }

    @Test
    void shouldCountProductsByCategory() {
        List<Product> products = createProducts();

        Map<String, Long> result =
            example.countProductsByCategory(products);

        assertEquals(Long.valueOf(4), result.get("Electronics"));
        assertEquals(Long.valueOf(2), result.get("Furniture"));
    }

    @Test
    void shouldCountAvailableProductsByCategory() {
        List<Product> products = createProducts();

        Map<String, Long> result =
            example.countAvailableProductsByCategory(products);

        assertEquals(Long.valueOf(3), result.get("Electronics"));
        assertEquals(Long.valueOf(2), result.get("Furniture"));
    }

    private List<Product> createProducts() {
        return Arrays.asList(
            new Product(1L, "Laptop", "Electronics", 1200.0, true),
            new Product(2L, "Mouse", "Electronics", 25.0, true),
            new Product(3L, "Keyboard", "Electronics", 75.0, false),
            new Product(4L, "Desk", "Furniture", 250.0, true),
            new Product(5L, "Chair", "Furniture", 180.0, true),
            new Product(6L, "Monitor", "Electronics", 350.0, true)
        );
    }


    @Test
    void shouldCalculateAveragePrice() {
        List<Product> products = createProducts();

        double result = example.calculateAveragePrice(products);

        assertEquals(346.6666666666667, result, 0.000001);
    }

    @Test
    void shouldCalculateAveragePriceByCategory() {
        List<Product> products = createProducts();

        Map<String, Double> result =
            example.calculateAveragePriceByCategory(products);

        assertEquals(412.5, result.get("Electronics"), 0.000001);
        assertEquals(215.0, result.get("Furniture"), 0.000001);
    }

    @Test
    void shouldCalculateAverageAvailablePriceByCategory() {
        List<Product> products = createProducts();

        Map<String, Double> result =
            example.calculateAverageAvailablePriceByCategory(products);

        assertEquals(525.0, result.get("Electronics"), 0.000001);
        assertEquals(215.0, result.get("Furniture"), 0.000001);
    }


    @Test
    void shouldJoinProductNames() {
        List<Product> products = createProducts();

        String result = example.joinProductNames(products);

        assertEquals(
            "Laptop, Mouse, Keyboard, Desk, Chair, Monitor",
            result
        );
    }

    @Test
    void shouldJoinProductNamesWithPrefixAndSuffix() {
        List<Product> products = createProducts();

        String result = example.joinProductNamesFormatted(products);

        assertEquals(
            "[Laptop, Mouse, Keyboard, Desk, Chair, Monitor]",
            result
        );
    }

    @Test
    void shouldJoinAvailableProductNamesByCategory() {
        List<Product> products = createProducts();

        Map<String, String> result =
            example.joinAvailableProductNamesByCategory(products);

        assertEquals(
            "Laptop, Mouse, Monitor",
            result.get("Electronics")
        );

        assertEquals(
            "Desk, Chair",
            result.get("Furniture")
        );
    }

    @Test
    void shouldReturnEmptyStringWhenJoiningEmptyList() {
        String result = example.joinProductNames(
            Collections.<Product>emptyList()
        );

        assertEquals("", result);
    }


}
