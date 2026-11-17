# Java 8 — Core Features

This module demonstrates the main language and platform features introduced in **Java 8**, through practical, self-contained examples.

The goal is to understand the evolution of the Java platform, explore the problems addressed by each feature, and compare modern approaches with traditional implementations.

## Topics Covered

### 1. Lambda Expressions

**Package:** `lambda`

Demonstrates how lambda expressions simplify the implementation of functional interfaces and reduce boilerplate code.

Topics:
- Lambda expression syntax
- Functional-style filtering
- Comparison with traditional anonymous classes and imperative code

### 2. Functional Interfaces

**Package:** `functional`

Explores the functional interfaces introduced in `java.util.function`.

Topics:
- `Predicate<T>` — evaluates a condition
- `Consumer<T>` — consumes a value
- `Supplier<T>` — provides a value
- `Function<T, R>` — transforms a value
- Functional interface composition and usage

### 3. Method References

**Package:** `methodreferences`

Demonstrates how method references provide a more concise alternative to certain lambda expressions.

Topics:
- Static method references
- Bound instance method references
- Unbound instance method references
- Constructor references

### 4. Stream API

**Package:** `streams`

Explores declarative data processing using the Stream API.

**Basic operations:**
- `filter()` — selects elements based on a condition
- `map()` — transforms elements
- `sorted()` — sorts elements
- `distinct()` — removes duplicates
- `reduce()` — combines elements into a single result
- `groupingBy()` — groups elements by a classification key

**Advanced operations and collectors:**
- `flatMap()` — flattens nested collections
- `partitioningBy()` — divides elements into two groups based on a predicate
- `mapping()` — transforms elements inside a downstream collector
- `counting()` — counts elements within a collection or group
- `averagingDouble()` — calculates average values
- `joining()` — concatenates strings from stream elements

Examples use a product domain model to demonstrate data filtering, transformation, aggregation, grouping and partitioning.

### 5. Optional

**Package:** `optional`

Demonstrates how `Optional<T>` represents the possible absence of a value and helps reduce explicit null handling.

Topics:
- `ofNullable()`
- `orElse()`
- `orElseGet()`
- `orElseThrow()`
- `map()`
- `filter()`

### 6. Date and Time API

**Package:** `datetime`

Explores the modern date and time API introduced in Java 8, replacing many limitations of the legacy `Date` and `Calendar` APIs.

Topics:
- `LocalDate`
- `LocalTime`
- `LocalDateTime`
- `ZonedDateTime`
- `Period`
- `Duration`
- `DateTimeFormatter`

### 7. Default and Static Interface Methods

**Package:** `interfaces`

Demonstrates the evolution of interfaces, allowing them to include method implementations.

Topics:
- Default methods
- Static methods
- Interface evolution and backward compatibility
- Practical implementation through service interfaces

### 8. CompletableFuture

**Package:** `concurrent`

Explores asynchronous programming and the composition of asynchronous operations.

Topics:
- `supplyAsync()`
- `runAsync()`
- `thenApply()`
- `thenAccept()`
- `thenCompose()`
- `thenCombine()`
- `exceptionally()`
- Executor configuration and asynchronous task management

## Project Structure

```text
java-08/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── pt/bmribeiro/javalts/
    │           ├── concurrent/
    │           ├── datetime/
    │           ├── functional/
    │           ├── interfaces/
    │           ├── lambda/
    │           ├── methodreferences/
    │           ├── optional/
    │           └── streams/
    └── test/
        └── java/
            └── pt/bmribeiro/javalts/
                └── ...
```

Each topic is implemented in an independent example class, with corresponding unit tests.

## Requirements

- JDK 21 or compatible development environment
- Apache Maven 3.9+
- JUnit 5

**Java compatibility:** The module is compiled with `maven.compiler.release=8`, targeting the Java 8 language and platform API.

The examples must therefore remain compatible with Java 8 APIs, even when compiled using a more recent JDK.

## Running the Tests

From the repository root:

```bash
cd core/java-08
mvn clean test
```

To compile the module without running tests:

```bash
mvn clean compile
```

## Learning Objectives

By exploring this module, developers can:

- Understand the main capabilities introduced in Java 8.
- Apply functional programming concepts in Java.
- Process collections using declarative pipelines.
- Handle potentially absent values using `Optional`.
- Work with dates, times and time zones using the modern API.
- Evolve interfaces without requiring every implementation to redefine existing behavior.
- Compose asynchronous operations using `CompletableFuture`.
- Understand the practical differences between traditional and modern Java approaches.

## References

- [Java SE 8 Documentation](https://docs.oracle.com/javase/8/docs/)
- [Java 8 API Specification](https://docs.oracle.com/javase/8/docs/api/)
- [Java Language Specification — Java SE 8](https://docs.oracle.com/javase/specs/jls/se8/html/index.html)
- [Java Tutorials — Oracle](https://docs.oracle.com/javase/tutorial/)