# Java Logging Framework Comparison

## 1. Overview

This project evaluates SLF4J, Logback, and Log4j2
using a simple Java order-processing application.

SLF4J is a logging facade that provides a common API,
while Logback and Log4j2 are logging implementations.

The application uses SLF4J for all logging operations
and switches between Logback and Log4j2 using Maven profiles.

## 2. Framework Comparison

| Feature | SLF4J | Logback | Log4j2 |
|---------|-------|---------|--------|
| Type | Logging Facade | Logging Implementation | Logging Implementation |
| Logging API | Yes | Yes | Yes |
| Console Logging | Depends on provider | Yes | Yes |
| File Logging | Depends on provider | Yes | Yes |
| Log Rotation | Depends on provider | Yes | Yes |
| Async Logging | Depends on provider | Supported | Supported |
| Configuration | Depends on provider | XML | XML, JSON, YAML, Properties |
| Integration | Works with multiple backends | Native SLF4J support | SLF4J bridge available |

## 3. Logback

### Advantages

- Simple configuration.
- Easy integration with SLF4J.
- Supports console and file logging.
- Supports log rotation.
- Suitable for general Java applications.

### Disadvantages

- Fewer advanced asynchronous logging options than Log4j2.
- Some advanced logging features require additional configuration.

## 4. Log4j2

### Advantages

- Flexible configuration options.
- Supports synchronous and asynchronous logging.
- Provides advanced filtering and routing features.
- Suitable for applications with complex logging requirements.

### Disadvantages

- Configuration can be more complex.
- Requires additional integration dependencies when using SLF4J.

## 5. Tradeoffs

Logback is easier to configure and is a good choice
for applications with standard logging requirements.

Log4j2 provides more advanced logging capabilities,
especially for asynchronous logging and complex configurations.

Both frameworks support console logging, file logging,
log rotation, and configurable logging levels.

Since the application uses SLF4J, switching between
Logback and Log4j2 does not require changes to business code.

## 6. Conclusion

Both Logback and Log4j2 meet the requirements of
this small order-processing application.

Logback is recommended for this project because
it is simple and provides all the required features.

Log4j2 may be preferred when an application needs
more advanced asynchronous logging, filtering,
or configuration options.

SLF4J helps keep the application independent
of the underlying logging implementation.

## 7. Setup Instructions

### Requirements

- Java 21
- Maven 3.9+

### Run with Logback

```bash
mvn clean compile exec:java -Plogback
```

Log output:
- Console
- logs/application.log

### Run with Log4j2

```bash
mvn clean compile exec:java -Plog4j2
```

Log output:
- Console
- logs/log4j2-application.log

### Run Unit Tests

Logback:

```bash
mvn clean test -Plogback
```

Log4j2:

```bash
mvn clean test -Plog4j2
```

Both configurations use the same Java application code.
Only the underlying logging implementation changes.