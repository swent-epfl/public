# Android Test

This is Part Two of our Android testing tutorial, focusing on UI testing.
We covered UI testing in the _Advanced Testing_ lecture [[slides](https://github.com/swent-epfl/public/blob/main/lectures/Wk2.B%20-%20Advanced%20Testing.pdf) \| [videos](https://www.youtube.com/watch?v=yrOH3XrDBuU&list=PLr41P4J9F0ZM1ebUm2QoLquU-yHA9bm6Z)]. Here we make it more concrete for the Android environment.

> **Part One : [Unit Testing](./UnitTesting.md)**

## Choosing a UI Testing Framework

To write UI tests, you can use the [Kaspresso](https://kasperskylab.github.io/Kaspresso/) framework.
It's a collection of functions you can use in tests to interact automatically with the app and to ensure that the displayed content matches some criteria. Android also offers the [Espresso](https://developer.android.com/training/testing/espresso), upon which Kaspresso is built. For the bootcamp we will use the former.

## Configuring the Emulator

> [!WARNING]  
> Before running UI tests, you need to configure your Android emulator by **disabling certain features**:

1. **Enable Developer Options**:

   - Launch the emulator, open the **Settings** app, and go to **About emulated device**.
   - Tap the **Build number** multiple times (around ten) until you see a message saying you are now a developer.

2. **Disable Animations**:
   - Navigate to **System** -> **Developer options** -> **Drawing** section.
   - Disable the following settings by setting them to **Animations off**:
     - Window animation scale
     - Transition animation scale
     - Animator duration scale

Disabling animations helps prevent test flakiness by ensuring the UI state is immediately ready for assertions.

## Using Espresso for Testing

Espresso allows you to work with the elements of your application as a white box (white box testing). You can find the desired element on the screen using a test `tag` and then perform different actions or checks.

> [!TIP]  
> To add a tag to a composable, use the following modifier to it `Modifier.testTag("my_tag")`

```kotlin
// This annotation is here to make the test is appropriate for JVM environment (with Robolectric)
@RunWith(AndroidJUnit4::class)
class MyComposeEspressoTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun testMyComposableWithEspresso() {
        // Set the Compose content for testing
        composeTestRule.setContent {
            MyComposable()  // the compose UI to test
        }

        // Verify the button is displayed
        composeTestRule.onNodeWithTag("my_button")
            .assertIsDisplayed()

        // Click the button
        composeTestRule.onNodeWithTag("my_button")
            .performClick()

        // Verify that "Hello World!" text appears
        composeTestRule.onNodeWithText("Hello World!")
            .assertIsDisplayed()

        // Verify that the node with the tag has text "Hello Miami"
        composeTestRule.onNodeWithTag("my_text")
            .assertTextEquals("Hello Miami")

    }
}
```

> [!NOTE]  
> [Testing cheatsheet](https://developer.android.com/develop/ui/compose/testing/testing-cheatsheet) for Espresso

> [!WARNING]  
> This works well for simple static screens, but as your application becomes more complex, and require multiple test, writing test tags every time becomes **cumbersome**.
> Next we will see how to define a screen UI that regroup all of those tags. This is called Page Objects Pattern (POP). This is where Kaspresso comes in.

## Advanced: Using Kaspresso for Testing

> [!NOTE]
> This section is not required, but we highly recommend you to use this in your project.

For more complex task, Kaspresso is based on Google testing framework [Espresso](https://developer.android.com/training/testing/espresso).

Kaspresso is based on [Kakao](https://github.com/KakaoCup/Kakao) - Android framework for UI automated tests. Kakao provides a simple Kotlin DSL. This makes the tests more readable.
Kaspresso aim at providing :

1. **_Good readability_**. Espresso has a problem with this because of the huge hierarchy of matchers. When we have a lot of matches, the code becomes difficult to read. Poor readability means difficult to maintain
2. **_Hight stability_**. Espresso does not work well with interfaces whose elements are displayed asynchronously. You can configure Idling, but that still won't solve all problems.
3. **_Logging_**. After completing the test with Espresso, you do not have a step-by-step workflow sequence of actions.
4. **_Screenshots_**. We also want to have some screenshots for the test report.
5. **_Сode architecture_**. We want to have a clean code architecture in our tests, the ability to reuse code, move some blocks in abstractions. One code style for all developers.

> [!TIP]
> Does the above paragraph looks GPT generated ? Well it's not us, but the [official documentation](https://github.com/KasperskyLab/Kaspresso/blob/master/docs/Wiki/Espresso_as_the_basis.en.md#what-do-we-want) :)

> [!NOTE]  
> [Domain-Specific Languages (DSL)](https://medium.com/kotlin-and-kotlin-for-android/kotlin-dsl-introduction-6123c43ae770) are meant to be effective solving that particular problem since their syntax is focused on being easily read, maintainable and sometimes they are even optimized as in the case of SQL.

### Page Objects Pattern

Page object pattern is a test abstraction that describes the screen with some view elements using tags. These view items can be interacted with during tests.
This is a similar concept to the Page Object Model mentioned in the _Advanced Testing_ lecture [[slides](https://github.com/swent-epfl/public/blob/main/lectures/Wk2.B%20-%20Advanced%20Testing.pdf) \| [videos](https://www.youtube.com/watch?v=yrOH3XrDBuU&list=PLr41P4J9F0ZM1ebUm2QoLquU-yHA9bm6Z)]. 

The description of the screen elements will be in a separate class.

```kotlin
// Screen class representing the UI components for testing using tags: POP
class ComposeMainScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<ComposeMainScreen>(
        semanticsProvider = semanticsProvider,
        viewBuilderAction = {
            hasTestTag("ComposeMainScreen")  // Identifies the screen by test tag
        }
) {

    // Child element defined within the ComposeMainScreen
    val simpleFlakyButton: KNode = child {
        hasTestTag("main_screen_simple_flaky_button") // Button identified by its test tag
    }
}
```

> [!WARNING]  
> We always recommend using screens to test your app.  
> For the test itself, Kaspresso syntax differs a bit from Espresso but remains similar

### Write the Tests

Here is an example of Kaspresso test for Jetpack Compose for a static screen.

```kotlin
@RunWith(AndroidJUnit4::class)
class ComposeSimpleFlakyTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withComposeSupport() // Enable Jetpack Compose support in Kaspresso
) {

    // Initializes a Compose test rule for testing Composables in isolation without an Android Activity
    @get:Rule
    val composeTestRule = createComposeRule()

    // Test method to execute the defined steps
    @Test
    fun testFlakyButtonInteraction() = run {
        step("Open Flaky screen") {
            onComposeScreen<ComposeMainScreen>(composeTestRule) {
                simpleFlakyButton {
                    assertIsDisplayed()
                    performClick()
                }
            }
        }

        step("Click on the First button") {
            onComposeScreen<ComposeMainScreen>(composeTestRule) {
                firstButton {
                    assertIsDisplayed()
                    performClick()
                }
            }
        }
    }
}
```

> [!NOTE]  
> Writing `step` helps to understand what is actually being tested.
> This may seem silly on the previous example but the more complex the test is, the harder it is to read it.

As you can see, we need to first create the screen class that will save all the links to the UI elements. Then, we can use these links in the tests with Espresso actions and assertions to perform. For more example on basic testing of Kaspresso, see [this tutorial](https://kasperskylab.github.io/Kaspresso/Tutorial/Writing_simple_test/#add-simpleactivitytest).

## Advanced: Firebase Emulation

> [!NOTE]
> This section is not required, but we highly recommend you to use this in your project.

[Firebase Emulators](https://firebase.google.com/docs/emulator-suite) simulate Firebase services locally on your machine. This enables you to test without having to manually mock every Firestore interaction in your apps.

> [!NOTE]  
> Setting up Firebase Emulators isn't necessary for the bootcamp, it can be incredibly useful for testing and development in your own app.

---

Happy Testing!

> [Return to the Table of Contents](../../README.md#table-of-contents)
