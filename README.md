# Java Logging Framework Comparison

## 1. Project Overview

This project evaluates three popular Java logging technologies: **SLF4J, Logback, and Log4j2**.

It uses a simple order-processing application to demonstrate logging levels, console logging, file logging, and log rotation.

The application uses SLF4J as the common logging API and Maven profiles to switch between Logback and Log4j2 without changing the Java business code.

## 2. Technologies Used

- Java 21
- Maven
- SLF4J 2.x
- Logback 1.5.x
- Log4j2 2.x
- JUnit 5

## 3. Project Structure

```text
java-logging-framework-comparison/
├── pom.xml
├── README.md
├── docs/
│   └── comparison.md
├── src/
│   ├── main/
│   │   ├── java/com/example/logging/
│   │   │   ├── Main.java
│   │   │   └── OrderService.java
│   │   └── resources/
│   │       ├── logback.xml
│   │       └── log4j2.xml
│   └── test/
│       └── java/com/example/logging/
│           └── OrderServiceTest.java
└── logs/ (generated at runtime)
```

## 4. Features

- Supports DEBUG, INFO, WARN, and ERROR logging levels.
- Outputs logs to the console and files.
- Supports log rotation.
- Uses SLF4J for a consistent logging API.
- Switches logging implementations using Maven profiles.
- Includes JUnit 5 tests for the mock order-processing application.

## 5. Setup Instructions

### Prerequisites

- JDK 21
- Maven 3.9 or later

Verify the environment:

```bash
java -version
mvn -version
```

### Run with Logback

```bash
mvn clean compile exec:java -Plogback
```

Logs are written to:

```text
logs/application.log
```

### Run with Log4j2

```bash
mvn clean compile exec:java -Plog4j2
```

Logs are written to:

```text
logs/log4j2-application.log
```

Both commands execute the same Java application with different logging implementations.

## 6. Mock Application

The application simulates three order-processing scenarios:

1. Normal order — successful processing.
2. Large order — generates a warning.
3. Invalid order — generates an error log.

### Example Log Output

```text
INFO  Main - Application started
INFO  OrderService - Processing order: ORDER-1001
INFO  OrderService - Payment successful for order: ORDER-1001
INFO  OrderService - Order completed successfully: ORDER-1001
INFO  OrderService - Processing order: ORDER-1002
WARN  OrderService - Large order detected: ORDER-1002, amount: 1500.0
INFO  OrderService - Processing order: ORDER-1003
ERROR OrderService - Invalid amount for order: ORDER-1003
INFO  Main - Application finished
```

Timestamps and thread names are omitted here for readability.

## 7. Unit Tests

The project includes three JUnit 5 tests:

- Successful order processing
- Invalid order amount
- Invalid order ID

Run tests with Logback:

```bash
mvn clean test -Plogback
```

Run tests with Log4j2:

```bash
mvn clean test -Plog4j2
```

The tests validate the mock application's business logic under both logging implementations.

## 8. Framework Comparison

| Feature | SLF4J | Logback | Log4j2 |
|---|---|---|---|
| Type | Logging facade | Logging implementation | Logging implementation |
| Console logging | Via provider | Yes | Yes |
| File logging | Via provider | Yes | Yes |
| Log rotation | Via provider | Yes | Yes |
| Async logging | Via provider | Supported | Supported |
| Configuration | Provider-dependent | XML | XML, JSON, YAML, Properties |
| Main advantage | API independence | Simplicity | Advanced features |

### Tradeoffs

**SLF4J** provides a common logging interface and makes it easier to switch implementations.

**Logback** is straightforward to configure and works well for applications with standard logging requirements.

**Log4j2** provides flexible configuration, advanced filtering, and powerful asynchronous logging capabilities, but some features require additional setup.

For this small application, Logback is the preferred choice because it meets all the requirements with relatively simple configuration.

Log4j2 may be a better choice for applications requiring advanced logging features or specific performance optimizations.

## 9. Conclusion

Both Logback and Log4j2 successfully support the mock order-processing application's logging requirements.

Using SLF4J allows the application to remain independent of the underlying logging implementation.

The project demonstrates how developers can evaluate logging frameworks based on configuration complexity, features, and application requirements.

For more details, see [Framework Comparison](docs/comparison.md).