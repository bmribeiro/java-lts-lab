
package pt.bmribeiro.javalts.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AdvancedStreamExample {

    /**
     * Flattens a collection of tag lists into a single list.
     */
    public List<String> flattenTags(List<List<String>> tagsByProduct) {
        return tagsByProduct.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }

    /**
     * Returns all distinct tags across multiple products.
     */
    public List<String> getDistinctTags(List<List<String>> tagsByProduct) {
        return tagsByProduct.stream()
            .flatMap(List::stream)
            .distinct()
            .collect(Collectors.toList());
    }

    /**
     * Returns distinct tags starting with the specified prefix.
     */
    public List<String> getTagsStartingWith(
        List<List<String>> tagsByProduct,
        String prefix) {

        return tagsByProduct.stream()
            .flatMap(List::stream)
            .filter(tag -> tag.startsWith(prefix))
            .distinct()
            .collect(Collectors.toList());
    }


    /**
     * Partitions products according to their availability.
     */
    public Map<Boolean, List<Product>> partitionByAvailability(
        List<Product> products) {

        return products.stream()
            .collect(Collectors.partitioningBy(Product::isAvailable));
    }

    /**
     * Returns only available products.
     */
    public List<Product> getAvailableProducts(
        List<Product> products) {

        Map<Boolean, List<Product>> partitioned =
            partitionByAvailability(products);

        return partitioned.get(true);
    }

    /**
     * Returns only unavailable products.
     */
    public List<Product> getUnavailableProducts(
        List<Product> products) {

        Map<Boolean, List<Product>> partitioned =
            partitionByAvailability(products);

        return partitioned.get(false);
    }

    /**
     * Partitions products according to a custom condition.
     */
    public Map<Boolean, List<Product>> partitionByPrice(
        List<Product> products,
        double minimumPrice) {

        Predicate<Product> expensiveProduct =
            product -> product.getPrice() >= minimumPrice;

        return products.stream()
            .collect(Collectors.partitioningBy(expensiveProduct));
    }


    /**
     * Groups product names by category.
     */
    public Map<String, List<String>> getProductNamesByCategory(
        List<Product> products) {

        return products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.mapping(
                    Product::getName,
                    Collectors.toList()
                )
            ));
    }

    /**
     * Counts products by category.
     */
    public Map<String, Long> countProductsByCategory(
        List<Product> products) {

        return products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.counting()
            ));
    }

    /**
     * Counts available products by category.
     */
    public Map<String, Long> countAvailableProductsByCategory(
        List<Product> products) {

        return products.stream()
            .filter(Product::isAvailable)
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.counting()
            ));
    }


    /**
     * Calculates the average price of all products.
     */
    public double calculateAveragePrice(List<Product> products) {

        return products.stream()
            .collect(Collectors.averagingDouble(Product::getPrice));
    }

    /**
     * Calculates the average price of products grouped by category.
     */
    public Map<String, Double> calculateAveragePriceByCategory(
        List<Product> products) {

        return products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.averagingDouble(Product::getPrice)
            ));
    }

    /**
     * Calculates the average price of available products by category.
     */
    public Map<String, Double> calculateAverageAvailablePriceByCategory(
        List<Product> products) {

        return products.stream()
            .filter(Product::isAvailable)
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.averagingDouble(Product::getPrice)
            ));
    }


    /**
     * Concatenates all product names using a comma separator.
     */
    public String joinProductNames(List<Product> products) {

        return products.stream()
            .map(Product::getName)
            .collect(Collectors.joining(", "));
    }

    /**
     * Concatenates product names with a custom prefix and suffix.
     */
    public String joinProductNamesFormatted(List<Product> products) {

        return products.stream()
            .map(Product::getName)
            .collect(Collectors.joining(", ", "[", "]"));
    }

    /**
     * Concatenates available product names by category.
     */
    public Map<String, String> joinAvailableProductNamesByCategory(
        List<Product> products) {

        return products.stream()
            .filter(Product::isAvailable)
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.mapping(
                    Product::getName,
                    Collectors.joining(", ")
                )
            ));
    }

}
