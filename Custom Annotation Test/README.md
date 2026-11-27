# CampusBoot — Java Reflection & Custom Annotations

A small Java 11+ demonstration of runtime annotations, reflection, dependency injection, validation, and method routing. It uses only the Java standard library.

## Requirements
- JDK 11 or newer

## Compile
Run these commands from this directory:

```bash
javac *.java
```

## Run

```bash
java Main
```

## Files
- `Component.java`, `Value.java`, `Range.java`, `Route.java`: runtime custom annotations
- `Container.java`: component registration and configuration-value injection
- `Validator.java`: `@Range` validation
- `Router.java`: route lookup and invocation
- `GradeController.java`, `ReportPrinter.java`, `Student.java`: assignment starter classes
- `Main.java`: demonstration program
- `answers.txt`: reflection questions

The framework is intentionally small and educational; it is not a replacement for Spring.
