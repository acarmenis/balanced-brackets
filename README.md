# Getting Started

### Reference Documentation

# Balanced Brackets Validator App

# 1. Overview & Design Logic
#    This application validates whether a string of brackets is properly balanced.

# Core Concepts

# 1.1. Service-Oriented Architecture
#      BracketProcessingService orchestrates the validation process.
#      Maintains the stack of opening brackets.
#      Delegates the handling of closing brackets to specialized handlers via the factory.

# 1.2. Handler Abstraction
#      BracketHandler interface defines a contract for handling closing brackets.
#      Concrete handlers (ParenthesisHandler, CurlyBraceHandler, SquareBracketHandler) implement the logic for a specific bracket type.
#      This isolates bracket-specific logic, making the system extensible, maintainable, and easy to test.

# 1.3. Factory Pattern
#      BracketHandlerFactory maps each closing bracket to its corresponding handler.
#      Decouples the service from the concrete handler implementations.
#      Adding a new bracket type requires only adding a new handler and registering it in the factory.

# 1.4. Fail-Fast Input Checks
#      Null strings, strings of length ≤ 1, strings ≥ 1000, and odd-length strings immediately return false.
#      This avoids unnecessary computation and enforces problem constraints.

# 1.5. Stack-Based Validation
#      Opening brackets are pushed onto a stack.
#      Closing brackets are validated by the corresponding handler.
#      The string is valid only if the stack is empty at the end.

# 1.6. Why this approach
#      Separation of Concerns: each class has a single responsibility.
#      Extensible: supports adding new brackets without modifying existing logic.
#      Testable: handlers and service can be unit-tested independently.
#      Maintainable & Readable: avoids large switch-case statements and nested conditionals.

# 2. How to Test the Application
#    Unit Tests
#    Under the test package is implemented the BalancedBracketsApplicationTests class 
#    It contains test methods to test against any cases mentioned in the assignment's requirements.

#    2.1 There are methods annotated with @Test to test against one input string at a time 

#    2.2 Parameterized Tests
#        Use @ParameterizedTest in JUnit to test multiple strings efficiently:
#        @ParameterizedTest
#        @ValueSource(strings = { "{[{}]}", "{{[[(())]]}}" })

#    2.3 Handler Tests   
#    2.4 Factory Tests
#    2.5 Service Tests
#    2.6 Fail-Fast Checks

#    2.7 Summary
#        Run all unit tests to verify the correctness of handlers, factory mappings, and the service.
#        Add new test cases for any new bracket types or edge cases.
#        Design ensures maintainability, extensibility, and clean separation of concerns, making it ideal for production and interview discussions.

# 3. How to run the application
#    This is a simple mavenized springboot console application.
#    Find the starting point or the entry class BalancedBracketsApplication which implements CommandLineRunner 
#    As a typical springboot application, it needs to do the clean & install 
#    Then please run the test class mentioned in section 2.