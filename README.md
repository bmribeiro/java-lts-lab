# Java LTS Lab

**A practical laboratory exploring the evolution of Java across Long-Term Support (LTS) releases.**

## Overview

`java-lts-lab` is an educational and technical reference repository dedicated to exploring the evolution of the Java platform through practical implementations, code comparisons, automated tests, and technical documentation.

The project covers significant changes introduced across Java LTS releases, focusing on language features, standard APIs, JVM capabilities, concurrency, and modern enterprise application development.

It combines two complementary perspectives:

- **Core Java:** understanding the evolution of the language and platform independently of external frameworks.
- **Spring Boot:** applying Java capabilities in practical enterprise application scenarios.

The goal is not simply to list new features, but to understand how they work, why they were introduced, what problems they solve, and how they influence software design and development practices.

## Objectives

- Explore the evolution of Java across LTS releases.
- Understand significant language, API, JVM, and platform enhancements.
- Implement practical and reproducible examples for each relevant feature.
- Compare different approaches to solving the same problem across Java versions.
- Understand the relationship between Java language evolution and enterprise frameworks.
- Apply modern software engineering principles and development practices.
- Provide a technical reference for continuous learning, professional development, and technical interviews.

## Java Versions

The repository initially focuses on the following LTS releases:

| Java Version | Release Year | Main Areas of Exploration |
|---|---:|---|
| Java 8 | 2014 | Lambda Expressions, Streams, Optional, Date and Time API |
| Java 11 | 2018 | HTTP Client, String API, Files API |
| Java 17 | 2021 | Records, Sealed Classes, Pattern Matching |
| Java 21 | 2023 | Virtual Threads, Sequenced Collections, Pattern Matching |
| Java 25 | 2025 | Language Evolution, Concurrency, API Enhancements |

Each release is explored independently, preserving its specific language and platform capabilities.

## Repository Architecture

The repository is organized into three main areas.

### 1. Core Java

Explores Java language and platform capabilities without requiring external application frameworks.

Topics include:

- Object-Oriented Programming
- Functional Programming
- Collections and Generics
- Streams and Lambda Expressions
- Records and Sealed Classes
- Pattern Matching
- Exception Handling
- Concurrency and Multithreading
- Virtual Threads
- JVM and Memory Management
- Standard APIs

Each Java release has its own independent project configuration, examples, and tests.

### 2. Spring Boot

Demonstrates how Java features can be applied in enterprise application development.

Topics include:

- Spring Boot fundamentals
- Dependency Injection and Inversion of Control
- RESTful APIs
- Layered Architecture
- Spring Data JPA
- Database Integration
- Validation and Exception Handling
- Spring Security
- Testing and Integration Testing
- Concurrency in web applications

Spring Boot projects use versions compatible with their respective Java runtime requirements.

### 3. Comparisons

Provides cross-version analysis of implementations and technical approaches.

Examples include:

- Collections and data processing
- Functional programming
- Data modeling and immutability
- Concurrency and thread management
- REST API implementation
- Code readability and maintainability
- Migration between Java versions

## Learning Methodology

Each relevant feature follows a consistent documentation and implementation structure:

1. **Context** — the problem or requirement behind the feature.
2. **Introduction** — the Java release in which the feature was introduced.
3. **Technical Explanation** — how the feature works and its underlying concepts.
4. **Implementation** — practical, self-contained code examples.
5. **Testing** — automated tests validating the expected behavior.
6. **Comparison** — differences from previous approaches.
7. **Practical Application** — examples of usage in real-world software development.
8. **References** — official specifications, documentation, and JEPs.

Features are identified according to their release status:

- **Final:** officially delivered and generally available.
- **Preview:** available for evaluation, requiring explicit enablement.
- **Incubator:** experimental API available for exploration.
- **Proposed:** under discussion or development, not yet delivered.

Preview and incubator features are clearly distinguished from finalized functionality.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Primary programming language |
| Apache Maven | Build and dependency management |
| Spring Boot | Enterprise application development |
| JUnit 5 | Automated testing |
| Mockito | Unit testing and mocking |
| H2 / PostgreSQL | Database integration |
| Git | Version control |
| GitHub | Source code hosting and collaboration |

Technologies are introduced progressively, according to the requirements of each laboratory.

## Getting Started

### Prerequisites

- Git
- Java Development Kit (JDK)
- Apache Maven or Maven Wrapper
- An IDE such as IntelliJ IDEA or Eclipse

The required JDK version depends on the laboratory being explored.

### Clone the repository

```bash
git clone https://github.com/<your-username>/java-lts-lab.git
cd java-lts-lab
```

### Explore a Core Java laboratory

For example, to explore Java 21:

```bash
cd core/java-21
```

Run the automated tests:

```bash
./mvnw clean test
```

On Windows:

```powershell
.\mvnw.cmd clean test
```

Refer to the README inside each laboratory for its specific configuration and execution instructions.

## Engineering Principles

The project follows these principles:

- Separation of concerns.
- Single Responsibility Principle.
- High cohesion and low coupling.
- Clean and readable code.
- Consistent naming conventions.
- Independent and reproducible implementations.
- Automated testing.
- Explicit dependency management.
- Documentation of architectural and technical decisions.
- Alignment with official Java specifications and documentation.

## Official References

- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [OpenJDK](https://openjdk.org/)
- [Java Language Specification](https://docs.oracle.com/javase/specs/)
- [JDK Enhancement Proposals (JEPs)](https://openjdk.org/jeps/)
- [Apache Maven](https://maven.apache.org/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/index.html)

## Project Status

**In development.**

The repository is being built incrementally, starting with the foundational structure and Core Java laboratories, followed by Spring Boot implementations and cross-version comparisons.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.