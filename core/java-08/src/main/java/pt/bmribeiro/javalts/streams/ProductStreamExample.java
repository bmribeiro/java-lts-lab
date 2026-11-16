package pt.bmribeiro.javalts.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductStreamExample {

    private final List<Product> products = Arrays.asList(
        new Product(1L, "Laptop", "Electronics", 1200.00, true),
        new Product(2L, "Mouse", "Electronics", 25.00, true),
        new Product(3L, "Keyboard", "Electronics", 75.00, false),
        new Product(4L, "Desk", "Furniture", 250.00, true),
        new Product(5L, "Chair", "Furniture", 180.00, true),
        new Product(6L, "Monitor", "Electronics", 350.00, true)
    );

    // filter(): selects products by condition
    public List<Product> findAvailableProducts() {
        return products.stream()
            .filter(Product::isAvailable)
            .collect(Collectors.toList());
    }

    // map(): transforms each product into its name
    public List<String> getProductNames() {
        return products.stream()
            .map(Product::getName)
            .collect(Collectors.toList());
    }

    // sorted(): orders products by price
    public List<Product> sortProductsByPrice() {
        return products.stream()
            .sorted((p1, p2) ->
                Double.compare(p1.getPrice(), p2.getPrice()))
            .collect(Collectors.toList());
    }

    // distinct(): removes duplicate values
    public List<String> getDistinctCategories() {
        return products.stream()
            .map(Product::getCategory)
            .distinct()
            .collect(Collectors.toList());
    }

    // reduce(): aggregates prices into a total
    public double calculateTotalPrice() {
        return products.stream()
            .map(Product::getPrice)
            .reduce(0.0, Double::sum);
    }

    // collect(): groups products by category
    public java.util.Map<String, List<Product>> groupByCategory() {
        return products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
    }
}
