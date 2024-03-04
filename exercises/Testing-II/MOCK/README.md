# Mock Testing in Android Development

Mock testing is a powerful approach in software testing that involves creating mock objects to simulate the behavior of real components. This technique is particularly useful in unit testing to isolate the piece of code being tested from its dependencies. By using mock objects, you can simulate various scenarios that your code may interact with in the real world.

## When to Use Mock Testing

- **Isolating the System Under Test:** Use mock testing when you want to isolate the system under test from external dependencies or services that are unpredictable, slow, or difficult to set up.
- **Simulating Scenarios:** Mocks are ideal for simulating specific conditions or edge cases that are hard to reproduce with real objects, such as specific weather conditions in a weather-dependent service.
- **Testing Interactions:** Use mock testing to verify that your code interacts correctly with its dependencies. You can assert that certain methods are called with the expected parameters.

## When Not to Use Mock Testing

- **Real Interactions:** Avoid mock testing when you need to test the real interactions between components or the integration of the system as a whole.
- **Overuse:** Be cautious of overusing mocks, as they can lead to tests that pass with flying colors but fail in production due to differences between the mock and the actual dependency.
- **Complex Logic in Mocks:** Avoid creating mocks with complex logic that mimic the behavior of the real components too closely. This can lead to tests that are hard to maintain and understand.

# MockK: A Kotlin Mocking Framework

[MockK](https://mockk.io/) is a powerful mocking framework that supports Kotlin. It's designed to offer first-class support for mocking Kotlin features, such as extension functions, coroutines, and higher-order functions. MockK provides a concise and expressive syntax that fits well with Kotlin's language features, making it a popular choice for Android developers.

## Key Features of MockK

- **Intuitive Syntax:** Designed with Kotlin's syntax in mind, making it easy to write mocks.
- **Coroutine Support:** Fully supports Kotlin coroutines, making it easy to test asynchronous code.
- **Immutable Mocking:** Ability to mock final classes and objects, a common scenario in Kotlin.
- **Extension Function Mocking:** Unique support for mocking Kotlin extension functions.
- **Annotations Support:** Offers annotations like `@MockK`, `@InjectMockKs`, and `@RelaxedMockK` for ease of use.


## Exercise
We will follow the DI exercise application but add test files to the application. 
We want to test the behavior of pressing _refresh_ and _clear_ button. 
And make sure the UI will be updated, through _viewmodel_.

We use MockK to mock classes that doesn't not concern our test.
