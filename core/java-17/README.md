# Java 17 — Language, API and JVM Features

## Overview

This module explores the major language, API, JVM, garbage collection, and platform changes introduced in or relevant to **Java 17 (LTS)**.

It provides practical Java examples and JUnit 5 tests covering selected features across multiple Java releases, including features finalized in Java 17, features introduced in earlier versions, and preview or incubator APIs available in Java 17.

The objective is to understand the evolution of the Java platform, explore modern language capabilities, and demonstrate their practical application through executable examples.

## Topics Covered

The module contains **25 implementation examples**, organized into the following categories.

### 1. Language Features

| Feature | JEP | Introduced | Finalized |
|---|---:|---|---|
| Switch Expressions | 361 | Java 12 (Preview) | Java 14 |
| Text Blocks | 378 | Java 13 (Preview) | Java 15 |
| Pattern Matching for instanceof | 394 | Java 14 (Preview) | Java 16 |
| Records | 395 | Java 14 (Preview) | Java 16 |
| Sealed Classes | 409 | Java 15 (Preview) | Java 17 |

**Implementation examples:**
- `SwitchExpressionExample`
- `TextBlocksExample`
- `PatternMatchingInstanceofExample`
- `RecordsExample`
- `SealedClassesExample`

### 2. Pattern Matching

| Feature | JEP | Introduced | Finalized |
|---|---:|---|---|
| Pattern Matching for switch | 406 | Java 17 (Preview) | Java 21 (JEP 441) |

**Implementation example:**
- `PatternMatchingSwitchExample`

The example demonstrates type patterns, null handling, and guarded patterns using the Java 17 preview syntax.

The implementation requires preview features to be enabled.

### 3. Standard API Enhancements

| Feature | JEP / Reference | Introduced |
|---|---|---|
| Files.mismatch() | JDK API | Java 12 |
| HexFormat | JDK API | Java 17 |
| Random Generator API | JEP 356 | Java 17 |
| Collectors.teeing() | JDK API | Java 12 |
| Stream.mapMulti() | JDK API | Java 16 |
| Stream.toList() | JDK API | Java 16 |
| String.indent() and transform() | JDK API | Java 12 |

**Implementation examples:**
- `FilesMismatchExample`
- `HexFormatExample`
- `RandomGeneratorExample`
- `CollectorsTeeingExample`
- `StreamMapMultiExample`
- `StreamToListExample`
- `StringMethodsExample`

### 4. Diagnostics and Runtime Improvements

| Feature | JEP | Introduced |
|---|---:|---|
| Helpful NullPointerExceptions | 358 | Java 14 |

**Implementation example:**
- `HelpfulNullPointerExceptionsExample`

Demonstrates enhanced NullPointerException messages that help identify the precise expression responsible for a null dereference.

### 5. Foreign Function & Memory API

| Feature | JEP | Introduced | Status in Java 17 |
|---|---:|---|---|
| Foreign Function & Memory API | 412 | Java 17 | First Incubator |

**Implementation example:**
- `ForeignMemoryExample`

Explores the Java 17 incubator API for accessing native memory outside the traditional Java heap.

The example uses the Java 17 API based on:
- `MemorySegment`
- `MemoryAccess`
- `ResourceScope`
- `jdk.incubator.foreign`

The API evolved through subsequent preview and incubator releases and was finalized in Java 22 (JEP 454).

### 6. Garbage Collection

| Feature | JEP | Relevant Version |
|---|---:|---|
| Abortable Mixed Collections (G1) | 344 | Java 12 |
| Promptly Return Unused Committed Memory (G1) | 346 | Java 12 |
| Shenandoah GC | 379 | Production in Java 15 |
| ZGC | 377 | Production in Java 15 |
| Concurrent Thread-Stack Processing (ZGC) | 376 | Java 16 |

**Implementation examples:**
- `G1GcExample`
- `ShenandoahGcExample`
- `ZGcExample`
- `ZGcConcurrentStackProcessingExample`

These examples explore garbage collector evolution, low-latency collection strategies, memory reclamation, and JVM thread-stack processing improvements.

### 7. Numeric and Floating-Point Semantics

| Feature | JEP | Introduced |
|---|---:|---|
| Always-Strict Floating-Point Semantics | 306 | Java 17 |

**Implementation example:**
- `FloatingPointExample`

Demonstrates the restoration of always-strict floating-point semantics across the Java platform.

### 8. Platform Changes and Deprecations

| Feature | JEP | Introduced / Applied |
|---|---:|---|
| Removal of Nashorn JavaScript Engine | 372 | Removed in Java 15 |
| Removal of RMI Activation | 407 | Removed in Java 17 |
| Deprecate the Security Manager for Removal | 411 | Java 17 |
| Strong Encapsulation of JDK Internals | 403 | Java 17 |

**Implementation examples:**
- `NashornRemovalExample`
- `RmiActivationRemovalExample`
- `SecurityManagerDeprecationExample`
- `StrongEncapsulationExample`

These examples demonstrate important platform changes, API removals, deprecations, and stronger encapsulation of internal JDK components.

### 9. Vector API

| Feature | JEP | Introduced | Java 17 Status |
|---|---:|---|---|
| Vector API | 414 | Java 16 (Incubator) | Second Incubator |

**Implementation example:**
- `VectorApiExample`

Explores vector computations and SIMD-oriented operations through the incubating Vector API.

The API requires the `jdk.incubator.vector` module and evolved through subsequent incubator releases.

## Project Structure

```text
core/
└── java-17/
    ├── pom.xml
    └── src/
        ├── main/
        │   └── java/
        │       └── pt/bmribeiro/javalts/
        │           ├── api/
        │           │   ├── files/
        │           │   ├── hex/
        │           │   ├── random/
        │           │   ├── stream/
        │           │   └── string/
        │           ├── diagnostics/
        │           ├── foreign/
        │           ├── gc/
        │           ├── language/
        │           ├── numeric/
        │           ├── patternmatching/
        │           ├── platform/
        │           ├── text/
        │           └── vector/
        └── test/
            └── java/
                └── pt/bmribeiro/javalts/
                    └── corresponding test packages
```

## Technologies

- Java 17 (LTS)
- Maven
- JUnit 5
- Java Preview Features
- Java Incubator Modules

## Requirements

- JDK 17
- Apache Maven
- JAVA_HOME configured to point to a Java 17 installation

The project uses Java 17 preview features and incubator modules.

The following modules are required:

- `jdk.incubator.vector`
- `jdk.incubator.foreign`

## Build and Test

Navigate to the module directory:

```bash
cd core/java-17
```

Configure Java 17.

**PowerShell:**

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-17"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
```

Verify the Java version:

```bash
java -version
```

Run the test suite:

```bash
mvn clean test
```

The Maven configuration enables preview features and the required incubator modules for compilation and test execution.

## Test Coverage

Each implementation example has a corresponding JUnit 5 test class.

The module currently contains:

- 25 implementation classes
- 25 test classes
- 165 automated tests

**Latest validated result:**

```text
Tests run: 165, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS
```

## Important Technical Notes

### Preview Features

Preview features are not finalized Java language or platform features.

Pattern Matching for switch was introduced as a preview feature in Java 17 (JEP 406) and finalized in Java 21 (JEP 441).

To compile and execute the examples, preview features must be enabled using:

```bash
--enable-preview
```

### Incubator Modules

The Foreign Function & Memory API and Vector API are incubator APIs in Java 17.

They require explicit module activation:

```bash
--add-modules=jdk.incubator.vector,jdk.incubator.foreign
```

These APIs are version-specific and should not be confused with their later Java releases.

### Java Version Compatibility

This module targets Java 17.

Examples that use preview features or incubator APIs must be compiled and executed using the corresponding Java 17 runtime.

## Official References

- [Java 17 Documentation](https://docs.oracle.com/en/java/javase/17/)
- [Java Language Changes](https://docs.oracle.com/en/java/javase/17/language/java-language-changes.html)
- [Java Enhancement Proposals (JEPs)](https://openjdk.org/jeps/0)
- [JEP 356 — Enhanced Pseudo-Random Number Generators](https://openjdk.org/jeps/356)
- [JEP 403 — Strongly Encapsulate JDK Internals](https://openjdk.org/jeps/403)
- [JEP 406 — Pattern Matching for switch (Preview)](https://openjdk.org/jeps/406)
- [JEP 409 — Sealed Classes](https://openjdk.org/jeps/409)
- [JEP 411 — Deprecate the Security Manager for Removal](https://openjdk.org/jeps/411)
- [JEP 412 — Foreign Function & Memory API (Incubator)](https://openjdk.org/jeps/412)
- [JEP 414 — Vector API (Second Incubator)](https://openjdk.org/jeps/414)
- [JEP 441 — Pattern Matching for switch](https://openjdk.org/jeps/441)
- [JEP 454 — Foreign Function & Memory API](https://openjdk.org/jeps/454)

---

**Part of the Java LTS Lab repository**, a practical exploration of Java language evolution, standard APIs, JVM capabilities, and platform improvements across Long-Term Support releases.