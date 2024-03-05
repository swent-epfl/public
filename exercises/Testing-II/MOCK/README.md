# Mock Testing in Android Development

Mock testing is a powerful approach in software testing that involves creating mock objects to simulate the behavior of real components. This technique is particularly useful in unit testing to isolate the piece of code being tested from its dependencies. By using mock objects, you can simulate various scenarios that your code may interact with in the real world.

For example, in Android development, you may want to test a ViewModel that interacts with your model (data, logic). Instead of using a real model, you can use a mock model to simulate the behavior of the real model. This makes the testing easier and more reliable. For eaxmple, you won't need to rely on a real network call to get the data, you can use a fake network instance that returns a predefined response.

# MockK: A Kotlin Mocking Framework

[MockK](https://mockk.io/) is a powerful mocking framework that supports Kotlin. It's designed to offer first-class support for mocking Kotlin features, such as extension functions, coroutines, and higher-order functions. MockK provides a concise and expressive syntax that fits well with Kotlin's language features, making it a popular choice for Android developers.

## Some Key Features of MockK:

- Designed with Kotlin's syntax in mind, making it easy to write mocks.
- Fully supports Kotlin coroutines, making it easy to test asynchronous code.
- Ability to mock final classes and objects, a common scenario in Kotlin.
- Offers annotations like `@MockK`, `@InjectMockKs`, and `@RelaxedMockK` for ease of use for quick mocking.


## Exercise
We will follow the DI exercise application but add test the `CharacterViewModel` using MockK. More specifically, we want to see if its live data is porperly updated and behaves as expected.

We want to test 3 behaviors of `CharacterViewModel`:
- Refreshing the data should change the live data
- Clearing the data should change the live data and is now empty
- Checking if the live data is correct with the expected data

__Why Mocking in this case? What to mock?__ Notice how the `CharacterViewModel` is using the `CharacterRepository` to get the data. We can't rely on a real reposity, because not only most of its code is not made by us (testing network connections, local caching), but what if suddenly the API is down? We are testing the `CharacterViewModel`, and these test should not depend on the the repository (they will have their own tests, but not here).

### Following the AAA structure
Usually when testing, it is a good concept to follow the following hierarchy:
- **Arrange:** Arrange all the necessary preconditions and inputs, such as setting up the mock objects and the expected behavior. (usually in the `@Before` method in JUnit)
- **Act:** Execute the code under test, such as calling a method or triggering an event.
- **Assert:** Verify that the expected behavior occurred, such as checking the output or the interactions with the mock objects.

### Implementaiton with MockK
Let's follow along this tutorial to see how to use MockK to test the `CharacterViewModel`. We'll go through important concepts.

#### 1. Setting up the Test Environment
Before diving into the tests "making", it's essential to set up your test environment correctly. In the provided test class, two JUnit rules are defined at the beginning.

```kotlin
// This rules allows LiveData to be tested synchronously, important in our case!
@get:Rule
val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

// This rule automatically initializes late-init properties with @MockK, @RelaxedMockK, etc.
@get:Rule
val mockkRule = MockKRule(this)
```

__Notice the second rule:__ do you remember what `CharacterRepository` contains? A room database, an API service. We need to mock these dependencies, and this rule will help us with that __completely automatically!__ Without having to worry about setting them up manually.

Don't forget to specify the `viewModel` variable that we will be testing:

#### 2. Mock the Repository and Observer
And as you can see, we are using `@RelaxedMockK` to mock the `CharacterRepository`. This is because we don't want to specify the behavior of the repository, we just want to make sure that the viewmodel behaves as expected:
```kotlin
@RelaxedMockK
lateinit var repository: CharacterRepository
```
Of course you can also go into more detail and specify the behavior of the repository, but for now we'll just use `@RelaxedMockK` as it abstracts the behavior of the repository and we don't need more control over it.

Now let's create and Mock an Observer for `ApiResponse<CharactersResponse>`. We will use this observer (pretty much just observing) to check if the live data is updated correctly. Inspire yourself from the following code:

```kotlin
private val anObserver: Observer<Observee> = mockk(relaxed = true)
```

`mockk(relaxed = true)` is used to create a relaxed mock, which means that it will not throw an exception if a method is called that is not specified in the mock.

#### 3. Define Dummy Characters
We need to define a list of __dummy characters__ for testing. This list will be used to simulate the response from the repository. We can define the list as a private variable in the test class:

```kotlin
// TODO: Define a list of dummy characters for testing.
private val dummyCharacters = ...
```

You must now mock the repository response to return a list of dummy characters.

#### 4. Prepare the `@Before` section, setup steps
In the `@Before` section, we will set up the viewmodel and the observer. We will also specify the behavior of the repository to return the dummy characters when the `getCharacters` method is called. This is the `Arrange` part of the test, and as we said, it's usually done in the `@Before` section.

This is where a lot of boilerplate code is written, so that in the tests themselves, we can focus on the `Act` and `Assert` parts.

First, we set the main coroutine dispatcher to a testing-friendly environment. This ensures that coroutines run synchronously during tests, making it easier to verify outcomes immediately.

```kotlin
// Step 1: Set the main coroutine dispatcher to Unconfined for testing.
Dispatchers.setMain(Dispatchers.Unconfined)
```

Next, define the response you expect from the `getCharacters()` function of the CharacterRepository. This is some specfic behavior (the bare minimum we need to define) that we will provide for the Mock of the repository, that is necessary for the viewmodel to work properly.

This involves the list of dummy characters and setting up the repository mock to return an `ApiResponse.Success` containing these characters.

Use the `coEvery` function (check the syntax!) to specify the behavior of the repository mock: `repository.getCharacters()` should return an `ApiResponse.Success` containing the dummy characters.
    
```kotlin
// Step 2: Prepare the repository mock to return a predefined list of dummy characters.
coEvery { ... } returns ...
```

With the mock repository prepared, now instantiate the `CharacterViewModel`, passing the mock repository as a dependency. This is the ViewModel you'll be testing.

```kotlin
// Step 3: Initialize the CharacterViewModel with the mocked repository.
viewModel = ...
```

Finally, set up the observer to observe the `characters` live data in the viewmodel. This observer will be used to verify that the live data is updated correctly.

```kotlin
// Step 4: Append the observer to the live data in the viewmodel.
viewModel.characters. ...
```

Congrats, `@Before` is done (the hardest honestly...)! Now we can focus on the tests themselves.

#### 5. Writing the Tests
Following the AAA structure (skipping the first `A` because it is done in @Before), we write the 3 tests we want to perform on the `CharacterViewModel`, as explained above.

If you haven't already, check the [official documentation](https://mockk.io/) of MockK to see how to use it.

Simply call the different methods on the ViewModel and assert the expected behavior. For example, to test that refreshing the data changes the live data, call the `refreshCharacters()` method and assert that the live data is updated with the expected characters.

#### 6. Tear down (@After)
Finally, we don't forget to clean up after the tests. This is done in the `@After` section. We need to reset the main coroutine dispatcher (as we set it to `Unconfined` in the `@Before` section) and clear the mock repository by removing the observer.

This is done to ensure that the test environment is clean and ready for the next test!

__Note:__ When we add an observer to LiveData within our ViewModel, it's only for the duration of the test. If not removed, the observer could lead to memory leaks or unintended behavior in other tests.

```kotlin
// TODO: Remove the observer from the live data in the viewmodel.

// Reset the main coroutine dispatcher to the original dispatcher.
Dispatchers.resetMain()
```
___
Good luck! :)

With this, hopefully we've covered the boilerplate basics of testing this ViewModel using MockK that would be useful for you to understand and apply in your own projects!

For more info, please go to https://mockk.io and check some of the other powerful testing capabilities of MockK. It's a great tool to have in your testing toolbox! 
