# Unit testing

This guide, in two parts, reviews the material covered in lectures, with a focus on testing in Android, covering **unit tests** and **UI tests**. By the end of this guide, you'll understand the difference between these types of tests and how to set up and use them in your Android projects. You can also refer to the lectures on _Testing Fundamentals_ [[slides](https://github.com/swent-epfl/public/blob/main/lectures/Wk2.A%20-%20Testing%20Fundamentals.pdf) \| [videos](https://www.youtube.com/playlist?list=PLr41P4J9F0ZMRgp3gw1cRA0VrQOphp-SA)] and _Advanced Testing_ [[slides](https://github.com/swent-epfl/public/blob/main/lectures/Wk2.B%20-%20Advanced%20Testing.pdf) \| [videos](https://www.youtube.com/watch?v=yrOH3XrDBuU&list=PLr41P4J9F0ZM1ebUm2QoLquU-yHA9bm6Z)]. 

When developing Android applications, it's crucial to ensure that both individual components and the entire app behave as expected. This is where unit tests and UI tests come in:

- **Unit Tests**: These allow you to test individual components, such as methods or classes. For example, you can verify that a `pow(a, b)` function correctly returns `a^b` in all cases.
- **UI Tests**: These tests validate the behavior of the app's user interface. For example, you can check that clicking the "Log in" button opens the login form.

Both types of tests complement each other to provide comprehensive test coverage.

>[!NOTE]  
> UI Test require an android emulator, hence an *instrument*, this is why they are often referred to as **Instrumented test** or **AndroidTests**.

## Project Structure for Tests

In a standard Android project, tests are organized into two folders:

- `src/test`: Contains **unit tests** that run directly on your computer.
- `src/androidTest`: Contains **UI tests** that run on the Android emulator within your app.

UI tests allow you to interact with app components like activities and UI elements and verify that they behave as expected.

## Frameworks for Testing

To set up a testing environment for Jetpack Compose, we recommend the following testing libraries. We have already added them to your `app/build.gradle` and `libs.versions.toml`.  

- **[Robolectric](https://robolectric.org/)**: Allows running Android tests on the JVM without needing an emulator or physical device.
- **[JUnit](https://junit.org/junit4/) (AndroidX Test Extension)**: Provides support for running unit tests on Android components.
- **[Mockito](https://site.mockito.org/) (Core and Inline)**: A framework for creating mock objects to test interactions and behaviors in isolation.

- **[Espresso](https://developer.android.com/training/testing/espresso/) (AndroidX)**: A UI testing framework for simulating user interactions and verifying UI states.
- **[Kaspresso](https://kasperskylab.github.io/Kaspresso/)**: An advanced UI testing framework built on top of Espresso and UiAutomator. This is optional, but highly recommended for the project.
- **Kaspresso Compose Support**: Provides support for testing Jetpack Compose UI components with Kaspresso.

- **Jetpack Compose BOM**: Manages compatible versions of Jetpack Compose libraries to prevent conflicts.

## Simple Unit test

Here is an example of a basic unit test:

```java
package com.github.se.bootcamp

import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
  @Test
  fun additionIsCorrect() {
    assertEquals(4, 2 + 2)
  }
}

```

## Mocking & Dependency Injection

Unit tests focus on testing methods or classes in isolation. To do so, we often need to mock dependencies so that we don't rely on the actual implementation, as we saw in the _Advanced Testing_ lecture [[slides](https://github.com/swent-epfl/public/blob/main/lectures/Wk2.B%20-%20Advanced%20Testing.pdf) \| [videos](https://www.youtube.com/watch?v=yrOH3XrDBuU&list=PLr41P4J9F0ZM1ebUm2QoLquU-yHA9bm6Z)]. 

### Example

Let's say we have a `ProfileRepository` that fetches a `Profile` object.  

```kotlin
// Profile model
data class Profile(val name: String, val age: Int)

interface ProfileRepository {
    fun getProfile(): Profile
}

class ProfileViewModel(private val repository: ProfileRepository) { // The repository is a parameter of the ViewModel to allow dependency injection
    fun getProfileName(): String {
        return repository.getProfile().name
    }
}
```

In our unit test, we want to test the `ProfileViewModel` without actually calling the repository.  
So in order to do so, we need to create a `ProfileRepository` a mock instance that we can manipulate ourselves.

```kotlin
// Unit test for ProfileViewModel
class ProfileViewModelTest {

    // Mocked instance of ProfileRepository initialization
    private lateinit var profileRepository: ProfileRepository
    private lateinit var profileViewModel: ProfileViewModel

    @Before
    fun setUp() {
        // Initialize the mock repository before each test
        profileRepository = mock(ProfileRepository::class.java)
        profileViewModel = ProfileViewModel(profileRepository)
    }

    @Test
    fun `test getProfileName returns correct name`() {
        // Arrange: Set up the mock to return a specific Profile object
        `when`(profileRepository.getProfile()).thenReturn(Profile("John Doe", 30))

        // Act: Call the method to test
        val profileName = profileViewModel.getProfileName()

        // Assert: Verify the method returns the expected value
        assertEquals("John Doe", profileName)
    }
}
```

>[!NOTE]  
> The [`lateinit var`](https://kotlinlang.org/docs/properties.html#late-initialized-properties-and-variables) keyword is used to declare a non-null variable that will be initialized at a later point in time, before it is accessed.  
> This is particularly useful in unit tests where objects such as mocks or view models need to be initialized in a setup method ( `@Before` ), rather than at the point of declaration.

### Further Reading on Mocking

If you wish to gain a better understanding of mocking, we recommend the following readings.

- [MockK Feature](https://blog.kotlin-academy.com/mocking-is-not-rocket-science-mockk-features-e5d55d735a98)
- [MockK Advanced Features](https://blog.kotlin-academy.com/mocking-is-not-rocket-science-mockk-advanced-features-42277e5983b5)
- [MockK Documentation](https://mockk.io/#examples-guides--articles)  

---

Now, it is your turn to write unit tests for the different parts of your application.\
Happy Testing!

> [Part Two : Android Test](AndroidTesting.md) \
> [Return to the Timeline](../ToDoApp/README.md#week-1-environment-setup-and-getting-started) \
> [Return to the Table of Contents](../../README.md#table-of-contents)
