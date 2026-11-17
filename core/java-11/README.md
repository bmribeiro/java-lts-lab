# Java 11 — Features and Improvements

This module provides practical examples of the main features introduced in **Java 11 (LTS)**, released in September 2018.

The goal is to demonstrate changes to the Java language, standard APIs, security, HTTP communication, and JVM memory management through code examples organized by functional area.

The module also documents relevant platform changes, including the removal of Java EE and CORBA modules, the separation of JavaFX from the JDK, and the deprecation of Nashorn.

## 1. Contents

### 1.1. Language and Syntax

| Feature | Description | Implementation |
|---|---|---|
| `var` in Lambda Parameters (JEP 323) | Allows the use of `var` in implicitly typed lambda parameters. | `language/VarLambdaExample.java` |
| Nest-Based Access Control (JEP 181) | Enables direct access to private members between classes belonging to the same nest. | `language/NestBasedAccessExample.java` |

### 1.2. Standard API

| Feature | Description | Implementation |
|---|---|---|
| String API | Introduces methods such as `isBlank()`, `lines()`, `strip()`, `stripLeading()`, `stripTrailing()`, and `repeat()`. | `strings/StringApiExample.java` |
| `Optional.isEmpty()` | Provides a direct way to check whether an `Optional` contains no value. | `optional/OptionalExample.java` |
| `Files.readString()` and `Files.writeString()` | Simplify reading and writing text files. | `files/FilesApiExample.java` |
| `Predicate.not()` | Provides a more expressive way to negate predicates, including method references. | `functional/PredicateExample.java` |
| `Collection.toArray(IntFunction)` | Allows collections to be converted into arrays using an array generator function. | `collections/CollectionToArrayExample.java` |

### 1.3. HTTP Communication

| Feature | Description | Implementation |
|---|---|---|
| Standardized HTTP Client API (JEP 321) | Standard API for HTTP communication, supporting HTTP/1.1, HTTP/2, and synchronous and asynchronous operations. | `http/HttpClientExample.java` |

### 1.4. Security and Cryptography

| Feature | Description | Implementation |
|---|---|---|
| TLS 1.3 (JEP 332) | Adds support for the TLS 1.3 protocol to the Java platform. | `security/TlsExample.java` |
| ChaCha20-Poly1305 (JEP 329) | Introduces an authenticated encryption algorithm through the Java Cryptography Architecture (JCA). | `security/ChaCha20Poly1305Example.java` |

### 1.5. Monitoring and Memory Management

| Feature | Description | Implementation |
|---|---|---|
| Java Flight Recorder (JEP 328) | Collects runtime events for JVM monitoring, diagnostics, and performance analysis. | `jfr/JfrExample.java` |
| ZGC (JEP 333) | Experimental garbage collector designed to minimize garbage collection pause times. | `gc/GarbageCollectorExample.java` |
| Epsilon GC (JEP 318) | Experimental garbage collector that does not reclaim memory, useful for performance testing and analysis. | `gc/GarbageCollectorExample.java` |

### 1.6. Source Code Execution

| Feature | Description | Implementation |
|---|---|---|
| Single-File Source-Code Launcher | Allows Java source files to be executed directly without explicitly compiling them beforehand. | `example/single-file/HelloWorld.java` |

## 2. Platform Changes

In addition to new features, Java 11 introduced significant changes to the composition and maintenance of the Java platform.

Further documentation is available in:

[`doc/platform-changes.md`](doc/platform-changes.md)

Topics covered:

- **JEP 320 — Removal of the Java EE and CORBA Modules:** removes Java EE and CORBA modules previously bundled with the JDK.
- **JavaFX:** no longer distributed with the JDK and available separately through OpenJFX.
- **JEP 335 — Deprecate the Nashorn JavaScript Engine:** deprecates Nashorn in Java 11. It was subsequently removed in Java 15 through JEP 372.

## 3. Project Structure

```text
core/java-11/
│
├── doc/
│   └── platform-changes.md
│
├── example/
│   └── single-file/
│       └── HelloWorld.java
│
├── src/
│   ├── main/
│   │   └── java/pt/bmribeiro/javalts/
│   │       ├── collections/
│   │       ├── files/
│   │       ├── functional/
│   │       ├── gc/
│   │       ├── http/
│   │       ├── jfr/
│   │       ├── language/
│   │       ├── optional/
│   │       ├── security/
│   │       └── strings/
│   │
│   └── test/
│       └── java/pt/bmribeiro/javalts/
│           ├── collections/
│           ├── files/
│           ├── functional/
│           ├── http/
│           ├── language/
│           ├── optional/
│           ├── security/
│           └── strings/
│
└── pom.xml
```

## 4. Technologies and Tools

- **Java 11** — target Java compatibility.
- **Maven** — dependency management and build automation.
- **JUnit 5** — automated testing.
- **Java Cryptography Architecture (JCA)** — cryptographic functionality.
- **Java HTTP Client** — HTTP communication.
- **Java Flight Recorder** — JVM monitoring and diagnostics.

## 5. Build and Test

From the `core/java-11` directory, run:

```bash
mvn clean test
```

To compile the project without running tests:

```bash
mvn clean compile
```

Automated tests are located in `src/test/java`.

JFR and Garbage Collector examples are also intended for direct execution, as they rely on specific JVM features and startup options.

## 6. Running Examples

After compiling the project, examples can be executed using the `target/classes` classpath.

Example:

```bash
java -cp target/classes pt.bmribeiro.javalts.strings.StringApiExample
```

To run the single-file source example:

```bash
java example/single-file/HelloWorld.java
```

Experimental features such as ZGC and Epsilon GC depend on the JVM version and supported startup options.

**Note:** Compiling with `--release 11` ensures compatibility with Java 11 APIs, but does not mean the application is running on a Java 11 JVM. To validate version-specific runtime behaviour, use a JDK 11 installation.

## 7. Automated Tests

The module includes unit tests for the implemented features.

Test coverage includes:

- String API;
- Optional;
- Files API;
- Predicate;
- Collection API;
- HTTP Client;
- `var` in lambda parameters;
- Nest-Based Access Control;
- TLS 1.3;
- ChaCha20-Poly1305.

The latest recorded module validation reported **29 tests executed, with no failures or errors**.

---

## References

- [Oracle — Java 11 Documentation](https://docs.oracle.com/en/java/javase/11/)
- [OpenJDK — JDK 11](https://openjdk.org/projects/jdk/11/)
- [JEP 181 — Nest-Based Access Control](https://openjdk.org/jeps/181)
- [JEP 321 — HTTP Client](https://openjdk.org/jeps/321)
- [JEP 328 — Flight Recorder](https://openjdk.org/jeps/328)
- [JEP 320 — Remove the Java EE and CORBA Modules](https://openjdk.org/jeps/320)