# Programmierungskurs - Programming Course Exercises

This repository contains programming exercises for the course.

## Project Structure

```
├── src/
│   ├── main/java/
│   │   ├── exercise1/    # Exercise 1: OOP concepts
│   │   └── exercise3/    # Exercise 3: Unit Testing with Mockito
│   └── test/java/
│       └── exercise3/    # Unit tests for Exercise 3
├── pom.xml               # Maven build configuration
└── README.md
```

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Building the Project

To compile the project:

```bash
mvn clean compile
```

## Running Tests

To run all tests:

```bash
mvn test
```

To run tests with verbose output:

```bash
mvn test -X
```

## Exercise 3: Unit Testing with Mockito

This exercise demonstrates unit testing using JUnit 5 and Mockito to isolate the class under test from its dependencies.

### Key Concepts

- **Unit Testing in Isolation**: The `StudentManagerTest` class tests only the `StudentManager` class, without depending on the actual implementations of `Student`, `Course`, or `ExerciseGroup`.
- **Mocking with Mockito**: All external dependencies are replaced with mock objects using Mockito's `@Mock` annotation.
- **Test Coverage**: Two test cases cover:
  1. Successful student distribution generation
  2. Exception handling when course is not found

### Dependencies

The project uses:
- **JUnit 5** (5.10.0) - Testing framework
- **Mockito** (5.5.0) - Mocking framework

### Running Exercise 3 Tests

```bash
# Run only Exercise 3 tests
mvn test -Dtest=StudentManagerTest

# Run with detailed output
mvn test -Dtest=StudentManagerTest -X
```

### Understanding the Test Structure

The test class uses:
- `@ExtendWith(MockitoExtension.class)` - Enables Mockito annotations
- `@Mock` - Creates mock objects for dependencies
- `when().thenReturn()` - Defines behavior for mock methods
- `verify()` - Confirms methods were called on mocks
- `@BeforeEach` - Sets up test fixtures before each test

### Example Test Output

```
[INFO] Running exercise3.StudentManagerTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
```

## License

This project is for educational purposes.
