# Java 21 — LTS Features

A practical collection of Java 21 examples covering the most relevant language enhancements, APIs, concurrency improvements, JVM changes, and incubating features introduced in this Long-Term Support (LTS) release.

The project focuses on understanding the features, exploring their implementation, and preparing for technical interviews.

## Overview

Java 21 was released on September 19, 2023, as a Long-Term Support release.

This module covers **14 of the 15 JEPs** integrated into JDK 21 through practical examples. The remaining JEP, concerning the deprecation of the Windows 32-bit x86 port, is documented as a platform change rather than implemented as a code example.

The examples are organized according to their status in Java 21:

| Status | Number of JEPs in Java 21 | Examples in this module |
|---|---:|---:|
| Finalized features and changes | 8 | 7 |
| Preview features | 6 | 6 |
| Incubator APIs | 1 | 1 |
| **Total** | **15** | **14** |

> Preview features and incubator APIs are not equivalent to finalized Java SE features. They may change or be removed in subsequent releases.

## 1. Finalized Features

These features were finalized in Java 21 and can be used without enabling preview features.

| JEP | Feature | Example |
|---:|---|---|
| 431 | Sequenced Collections | `SequencedCollectionsExample` |
| 439 | Generational ZGC | `GenerationalZGCExample` |
| 440 | Record Patterns | `RecordPatternsExample` |
| 441 | Pattern Matching for switch | `PatternMatchingSwitchExample` |
| 444 | Virtual Threads | `VirtualThreadsExample` |
| 451 | Prepare to Disallow the Dynamic Loading of Agents | `DynamicAgentLoadingExample` |
| 452 | Key Encapsulation Mechanism API | `KeyEncapsulationMechanismExample` |

### Feature highlights

- **Sequenced Collections:** introduces interfaces that represent collections with a defined encounter order, including first and last element operations and reversed views.
- **Generational ZGC:** introduces generational support in the Z Garbage Collector to improve garbage collection efficiency.
- **Record Patterns:** enables record deconstruction in pattern matching, including nested patterns.
- **Pattern Matching for switch:** allows patterns, guards, and null handling in switch expressions and statements.
- **Virtual Threads:** introduces lightweight threads managed by the JVM, designed to support high-throughput concurrent applications.
- **Dynamic Agent Loading:** introduces warnings when agents are dynamically loaded into an already running JVM, preparing for future restrictions.
- **Key Encapsulation Mechanism API:** provides a standard API for establishing shared secrets using key encapsulation mechanisms.

## 2. Preview Features

Preview features are available for evaluation and experimentation. They require explicit enablement at compilation and runtime.

| JEP | Feature | Example |
|---:|---|---|
| 430 | String Templates | `StringTemplatesExample` |
| 442 | Foreign Function & Memory API (Third Preview) | `ForeignFunctionMemoryExample` |
| 443 | Unnamed Patterns and Variables | `UnnamedPatternsVariablesExample` |
| 445 | Unnamed Classes and Instance Main Methods | `UnnamedClassesExample` |
| 446 | Scoped Values | `ScopedValuesExample` |
| 453 | Structured Concurrency | `StructuredConcurrencyExample` |

### Feature highlights

- **String Templates:** introduces template expressions that combine literal text with embedded expressions and processors.
- **Foreign Function & Memory API:** enables Java applications to interact with native code and native memory without relying on JNI.
- **Unnamed Patterns and Variables:** allows `_` to represent unused variables and pattern components.
- **Unnamed Classes and Instance Main Methods:** simplifies Java entry points by allowing source files without explicit class declarations and non-static main methods.
- **Scoped Values:** provides a mechanism for sharing immutable data within a bounded execution scope.
- **Structured Concurrency:** treats related concurrent tasks as a single unit of work, improving task management, cancellation, and error handling.

## 3. Incubator APIs

Incubator APIs are experimental APIs made available for evaluation and feedback. They are not finalized Java SE APIs.

| JEP | Feature | Example |
|---:|---|---|
| 448 | Vector API (Sixth Incubator) | `VectorAPIExample` |

### Feature highlights

- **Vector API:** enables vector computations that can be mapped to SIMD instructions supported by the underlying processor.
- Supports operations on multiple data elements through vector instructions.
- Uses `VectorSpecies` to represent vector shape and preferred hardware characteristics.
- Requires the `jdk.incubator.vector` module.

## 4. Platform Change Not Implemented as a Code Example

| JEP | Feature | Reason |
|---:|---|---|
| 449 | Deprecate the Windows 32-bit x86 Port for Removal | Platform and distribution change; no meaningful standalone Java example. |

This change is part of the Java 21 release scope but does not require a dedicated Java example class.

## 5. Project Structure

The Java 21 module follows the same Maven-based organization as the other modules in this repository.

```text
java-21/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── pt/
    │           └── bmribeiro/
    │               └── javalts/
    │                   ├── collections/
    │                   ├── concurrency/
    │                   ├── foreign/
    │                   ├── gc/
    │                   ├── instrumentation/
    │                   ├── language/
    │                   ├── security/
    │                   └── vector/
    └── test/
        └── java/
            └── pt/
                └── bmribeiro/
                    └── javalts/
```

The Unnamed Classes and Instance Main Methods example is a special case: it uses Java source-file mode and has no explicit package or class declaration. It is kept outside the conventional Maven source structure.

Each conventional example is accompanied by a JUnit 5 test class.

## 6. Requirements

- JDK 21.
- Apache Maven.
- IntelliJ IDEA or another Java-compatible IDE.
- JUnit 5.

Preview features and the Vector API require additional compiler and runtime options.

## 7. Maven Configuration

The module uses the following Java compiler configuration:

```xml
<properties>
    <maven.compiler.release>21</maven.compiler.release>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <junit.version>5.11.4</junit.version>
    <maven.compiler.plugin.version>3.13.0</maven.compiler.plugin.version>
    <maven.surefire.plugin.version>3.5.2</maven.surefire.plugin.version>
</properties>
```

The compiler plugin must enable preview features and the incubator Vector API module:

```xml
<configuration>
    <release>21</release>
    <compilerArgs>
        <arg>--enable-preview</arg>
        <arg>--add-modules</arg>
        <arg>jdk.incubator.vector</arg>
    </compilerArgs>
</configuration>
```

The Surefire plugin must enable the corresponding runtime options:

```xml
<configuration>
    <useModulePath>false</useModulePath>
    <argLine>--enable-preview --add-modules jdk.incubator.vector</argLine>
</configuration>
```

These options are scoped to the Java 21 module.

## 8. Running the Examples

### Run the Maven test suite

From the `java-21` module directory:

```bash
mvn clean test
```

### Run a Preview source-file example

The Unnamed Classes and Instance Main Methods example is executed directly through the Java launcher:

```bash
java --enable-preview --source 21 UnnamedClassesExample.java
```

### Run a program using the Vector API

The Vector API requires the incubator module:

```bash
java --add-modules jdk.incubator.vector YourApplication
```

### Enable Preview features

For standalone applications using Java 21 Preview features:

```bash
java --enable-preview YourApplication
```

## 9. Testing Strategy

JUnit 5 tests validate the examples' functional behaviour and relevant edge cases.

The test suite includes, where applicable:

- Expected results and return values.
- Input validation and exception handling.
- Empty collections and arrays.
- Boundary conditions and remaining vector elements.
- Immutability and collection ordering.
- Concurrency behaviour.
- Cryptographic shared-secret agreement.
- Correct JVM option construction.

The Vector API tests compare vectorized results with expected scalar calculations, including elements that do not fill a complete vector.

The Foreign Function & Memory API tests exercise native-memory allocation and access within bounded arena lifetimes.

The Dynamic Agent Loading tests validate JVM option construction. They do not attach a real Java agent to a running JVM.

## 10. Learning Objectives

By completing this module, developers should be able to:

- Identify the main enhancements introduced by Java 21.
- Distinguish finalized features from Preview and Incubator APIs.
- Understand the impact of virtual threads on concurrent application design.
- Apply modern pattern matching techniques.
- Work with the new sequenced collection interfaces.
- Understand the evolution of garbage collection in Java.
- Explore native interoperability through the Foreign Function & Memory API.
- Understand the purpose and limitations of the Vector API.
- Recognize the security and operational implications of dynamic Java agent loading.
- Explain the main Java 21 changes in technical interviews.

## 11. Official References

- [OpenJDK — JDK 21](https://openjdk.org/projects/jdk/21/)
- [JEP Index](https://openjdk.org/jeps/0)
- [Oracle — Java 21 Release Notes](https://www.oracle.com/java/technologies/javase/21-relnote-issues.html)
- [Oracle — Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)

---

**Project:** Java LTS Lab
**Module:** Java 21
**Target JDK:** 21
**Release Type:** Long-Term Support (LTS)