# Exam Practice Set 2 &mdash; Answers and Explanations

See the [exam README](./README.md) for information on the exam and corresponding practice sets.

This exercise set contains 15 questions covering the material of **week 2**.
They are meant to take on the order of 30 minutes to answer. 
Don't worry about the amount of time it takes you to answer, the point of the exam is to test your knowledge, not the speed with which you can answer. 
The exam will contain many more questions.

We strongly recommend that you answer this exercise set in one sitting, closed-book, without any external help. 
This simulates exam conditions, and will therefore give you a sense of whether the way you studied the material has prepared you well for the exam, or there are changes you need to make.

---

## Question 1
<!-- id: B2-007 -->

In the bootcamp Todo app, a user types an invalid date into the "Add Todo" form. According to B2, when should the error be shown?

- **A.** As soon as the input becomes invalid while the user is typing
- **B.** Only after the user leaves the field
- **C.** Only after the Save button is pressed
- **D.** Only after the app is restarted
- **E.** Never, because dates are stored as strings

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answer: A**

- **A is correct:** In the B2 milestone specification and acceptance tests, date validation is reactive. As the user enters text into the due date input field, the validation logic evaluates the string immediately and displays the error state as soon as the input fails format requirements.
- **B is incorrect:** The UI does not defer error reporting until the field loses focus.
- **C is incorrect:** Validation errors are displayed reactively during typing, rather than waiting for the Save submission.
- **D is incorrect:** Deferring error reporting until app restart would create a broken user experience.
- **E is incorrect:** Due dates are validated and stored internally as Firestore `Timestamp` instances, not unvalidated strings.

**Reference material:** [B2 &sect;2 Create A Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/2-CreateAToDo.md) (strict `dd/mm/yyyy` validation)
</details>

---

## Question 2
<!-- id: L-week2-TestDoubles-004 -->

You need to test whether a View correctly displays a given list of items. What kind of double would you use for the ViewModel?

- **A.** A stub
- **B.** A mock
- **C.** A fake
- **D.** A fake, so that the double also performs the filtering and sorting that the real ViewModel applies before exposing the list
- **E.** A stub for the list of items, combined with a mock that checks that the View reads the list exactly once

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answer: A**

- **A is correct:** A **stub** provides canned responses to the calls made during the test. To test that a View correctly renders a list of items, the ViewModel double only has to expose a fixed list.
- **B is incorrect:** A **mock** is used to verify interactions: which methods were called, with which arguments, and in which order. This test only needs to supply data to the View.
- **C is incorrect:** A **fake** is a working, lightweight implementation (e.g. an in-memory repository). The double in this test needs neither state management nor logic.
- **D is incorrect:** A **fake** would reproduce the ViewModel's own logic inside the test. The test would then depend on that logic being correct, and a bug in the filtering would show up as a View test failure, which is not what this test is meant to check.
- **E is incorrect:** How many times the View reads the list is an implementation detail of Compose, which re-reads state on every recomposition. Asserting on the number of reads makes the test fail for reasons that have nothing to do with what the View displays.

**Reference material:** Test Doubles: Mocks, Stubs, and Fakes [[pdf](https://drive.google.com/file/d/1XKh1dFWOIUSnI2Bi7-n0t9a_A7dIMoAB/view) | [video](https://www.youtube.com/watch?v=QqUIqVwLhzE)]
</details>

---

## Question 3
<!-- id: L-week2-Coverage-003 -->

Consider the following function and its corresponding test suite:

```kotlin
fun calculateDiscount(price: Double, count: Int): Double {
    var discount = 0.0
    if (count >= 10) {
        discount = price * 0.20
    }
    return price - discount
}

@Test
fun testDiscounts() {
    calculateDiscount(100.0, 10) // executes the "count >= 10" branch
    calculateDiscount(100.0, 5)  // executes the "count < 10" branch
}
```

The test runner reports that `calculateDiscount` has achieved 100% statement coverage and 100% branch coverage. Which of the following statements correctly explain(s) the limitations of this coverage result and why bugs might still go undetected?

- **A.** The test suite contains no assertions; 100% statement and branch coverage only shows that lines and branches were executed, not that the returned values were correct.
- **B.** Neither test case uses a value just below or just above the threshold, such as `count = 9` or `count = 11`, so an off-by-one error (e.g. if the developer wrote `count > 10` instead of `count >= 10`) could remain undetected.
- **C.** Negative prices or negative counts (e.g., `price = -50.0`, `count = -1`) are not tested, so invalid inputs that the function does not handle are not exposed by high coverage alone.
- **D.** 100% branch coverage with no exceptions thrown during testing proves formally that the code is free of runtime exceptions on all possible paths.
- **E.** Coverage tools measure which code was executed, but they cannot detect missing statements (e.g., missing input validation checks that were never written in the source code).

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answers: A, B, C, E**

- **A is correct:** Coverage measures which lines and branches ran, not whether the results were checked. A test suite that runs every line without a single assertion reaches 100% coverage while verifying no behavior at all.
- **B is correct:** Branch coverage only requires that each branch evaluates to true and false at least once. It does not require testing the values around the threshold ($N-1$, $N$, and $N+1$). If the relational operator was mistakenly inverted or off by one, testing only 10 and 5 will not expose it.
- **C is correct:** Coverage says nothing about which inputs were used. Invalid or extreme values (e.g., negative counts, NaN prices) can harbor critical bugs that coverage metrics completely overlook.
- **D is incorrect:** Coverage records which code the tests executed; it proves nothing about the inputs that were not tried, so it cannot rule out runtime exceptions.
- **E is correct:** Coverage can only track existing code. If the developer forgot to validate that `count >= 0` or that `price >= 0`, the coverage tool has no way of detecting that required logic was omitted.

**Reference material:** Coverage Metrics [[pdf](https://drive.google.com/file/d/1j3rJAyKKTTIwl9lEB7PmXMJUmixj1Mi1/view) | [video](https://www.youtube.com/watch?v=yMSbO17WDAs)] &middot; What Coverage Doesn't Catch [[pdf](https://drive.google.com/file/d/1a9ty0D7bVA0h8fGjWMkBHD-aQGOy4Fcx/view) | [video](https://www.youtube.com/watch?v=514JYysdVtc)]
</details>

---

## Question 4
<!-- id: B2-010 -->

In the bootcamp Todo app, what should happen when the user presses Save while a mandatory field is blank or the date is invalid?

- **A.** The todo is not sent to the Firestore repository
- **B.** The app saves the todo and displays the error later
- **C.** The app deletes the existing todo
- **D.** The app silently replaces the invalid value with a default
- **E.** The app navigates to Overview regardless of validity

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answer: A**

- **A is correct:** When mandatory fields are blank or validation fails, the submission is halted. The repository's `addTodo` method must not be invoked, preventing invalid records from reaching Firestore.
- **B is incorrect:** The application must never commit invalid records to the backend database.
- **C is incorrect:** Failing to save a new todo must not delete existing todos.
- **D is incorrect:** Silently substituting a value hides the user's mistake and stores data the user never entered.
- **E is incorrect:** The app must remain on the form so the user can correct validation errors; it must not navigate back to the Overview screen on failure.

**Reference material:** [B2 &sect;2 Create A Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/2-CreateAToDo.md) (Save behavior on invalid input)
</details>

---

## Question 5
<!-- id: L-week2-testingLevel-003 -->

You have finished the 'CarFinder' app and want to check that the fully assembled app works, running in a test environment rather than against live production services. Which is the earliest level in the progression unit → integration → system → end-to-end → acceptance that meets this need?

- **A.** Unit
- **B.** Integration
- **C.** System
- **D.** End-to-end
- **E.** Acceptance

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answer: C**

- **A is incorrect:** Unit tests evaluate individual classes, functions, or modules in strict isolation. They cannot evaluate the whole app working together.
- **B is incorrect:** Integration tests check how two or more collaborating components interact (e.g. Service + Repository), but do not exercise the fully assembled application as a unified whole.
- **C is correct:** System testing is the first level in the progression that evaluates the entire integrated system as a whole, in a test environment, to verify that it meets the specified requirements.
- **D is incorrect:** End-to-end testing exercises the system within its complete operational environment, often against live production-like backends and external services. System testing already covers the fully assembled app in a test environment, and comes earlier in the progression.
- **E is incorrect:** Acceptance testing evaluates whether the software meets the customer's requirements, from the user's perspective, and is typically conducted after system testing.

**Reference material:** Levels of Testing [[pdf](https://drive.google.com/file/d/1lFBondvYlDjHikZuSkCXEqvG5z-KEO7q/view) | [video](https://www.youtube.com/watch?v=URvMd41BIwI)]
</details>

---

## Question 6
<!-- id: B2-005 -->

In the bootcamp Todo app, a `DocumentSnapshot` must be converted into a `ToDo` object. Which responsibility/-ies belong(s) in the helper that performs this conversion?

- **A.** Querying Firestore for the fields that are missing from the document
- **B.** Converting the stored values into the corresponding `ToDo` properties
- **C.** Handling an invalid document according to the repository's error policy
- **D.** Rendering the resulting todo as a Compose card
- **E.** Navigating to the Overview screen

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answers: B, C**

- **A is incorrect:** A conversion helper should be a pure, synchronous transformation. It parses the data already present in the `DocumentSnapshot` and never makes network requests to fetch what is missing.
- **B is correct:** Extracting stored fields (`getString("name")`, `getTimestamp("dueDate")`, etc.) and constructing the domain `ToDo` model is the central responsibility of a conversion function.
- **C is correct:** Handling malformed, missing, or corrupt document attributes (e.g. by returning `null` or throwing an appropriate exception) ensures that data integrity rules are enforced before domain objects enter the application.
- **D is incorrect:** UI rendering is the responsibility of Composable views in Jetpack Compose, not the data layer.
- **E is incorrect:** Screen navigation is handled by the UI navigation layer (`NavHostController`), not data conversion helpers.

**Reference material:** [B2 &sect;2 Create A Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/2-CreateAToDo.md) (`DocumentSnapshot` conversion helper)
</details>

---

## Question 7
<!-- id: B2-016 -->

B2 requires every UI element of the Add Todo screen to be visible on a 1080x2424 screen, the size of the Pixel 10a emulator. Why does this requirement exist?

- **A.** Automated UI tests need to locate and interact with all required controls
- **B.** Firestore rejects applications with small layouts
- **C.** Compose only supports one screen size
- **D.** It guarantees that every device has the same resolution
- **E.** The screen size determines the todo uid

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answer: A**

- **A is correct:** The automated UI tests run on an emulator with exactly that screen size. If a control is clipped, pushed off-screen, or hidden behind another element, the test cannot find its test tag or click on it, and the test fails.
- **B is incorrect:** Firestore is a database service, and it knows nothing about the app's layout.
- **C is incorrect:** Compose is designed for adaptive layouts, across any screen size.
- **D is incorrect:** Android devices vary widely in screen size, aspect ratio, and resolution, and no app requirement can change that.
- **E is incorrect:** A todo's `uid` is generated independently of the screen size.

**Reference material:** [B2 &sect;2 Create A Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/2-CreateAToDo.md) (1080x2424 screen) &middot; [B2 &sect;4 Edit a Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/4-EditATodo.md)
</details>


---

## Question 8
<!-- id: L-week2-testingLevel-005 -->

A mobile development team has built a profile update feature, in which the user edits their profile and the app validates the fields before saving. In their CI pipeline, the team relies almost exclusively on full Android UI tests, running on emulators, to test this form. Developers complain that CI takes 35 minutes and that tests frequently fail because of UI rendering timing or network hiccups.

Which of the following statements correctly evaluate(s) how the team should restructure their tests across the testing levels (unit, integration, and system/end-to-end)?

- **A.** Input validation logic (e.g. email format and non-empty name) should be tested with unit tests on the local JVM.
- **B.** Verifying that the ViewModel correctly handles repository success and error responses can be done at the unit level, with a fake repository, on the local JVM.
- **C.** End-to-end UI tests should be removed from the project entirely, because unit tests alone can guarantee that UI composables, navigation, and backend services are correctly integrated.
- **D.** End-to-end UI tests are slower and more fragile than unit tests, because they depend on UI thread synchronization, device resource availability, and network and emulator stability.
- **E.** When an end-to-end test fails, finding the cause is typically much more difficult and time-consuming than when a focused unit test fails.

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answers: A, B, D, E**

- **A is correct:** Pure algorithmic and validation logic belongs in unit tests. Local JVM unit tests run orders of magnitude faster than instrumented emulator tests and pinpoint defects to exact lines of code.
- **B is correct:** Giving the ViewModel a fake repository keeps the test at the unit level: only the ViewModel's own code runs, and the test can drive both the success path and the error path by choosing what the fake returns. Such a test validates state management without triggering Android framework layout rendering or UI timing flakes. A test that combines the ViewModel with a real repository, for example against the Firebase emulator, would be an integration test instead.
- **C is incorrect:** End-to-end tests should not be removed. While they should form the smallest part of the test suite, a focused set of them is what verifies that wiring, permissions, layout, and system navigation work together.
- **D is correct:** UI and instrumented tests have many failure modes that have nothing to do with the code under test: emulator crashes, animation timing, frame drops, rendering latency.
- **E is correct:** Finding the cause of an end-to-end failure is difficult: a failed assertion can come from an asynchronous race condition, a faulty network mock, a broken button click listener, or a bug in the domain logic.

**Reference material:** Levels of Testing [[pdf](https://drive.google.com/file/d/1lFBondvYlDjHikZuSkCXEqvG5z-KEO7q/view) | [video](https://www.youtube.com/watch?v=URvMd41BIwI)] &middot; UI Testing for Your App [[pdf](https://drive.google.com/file/d/1E2JCYZyUf14-5GGsDsj8EZS7XdLr3EUZ/view) | [video](https://www.youtube.com/watch?v=SIPYX5ZUEGs)] &middot; [Android testing guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/AndroidTesting.md)
</details>

---

## Question 9
<!-- id: L-week2-RegressionTesting-004 -->

A team's automated test suite has grown to over 1,200 tests. Running the complete suite on every commit now takes over 45 minutes, which delays developers and blocks pull requests in CI.

Which of the following strategies is/are sound ways to speed up regression testing without giving up software quality?

- **A.** Define a fast smoke test suite, covering the core features of the app, that runs on every pull request, and run the full regression suite before each release.
- **B.** Move the checks that do not need the Android framework out of instrumented UI tests and into JVM unit tests that use test doubles, so that far fewer tests need an emulator.
- **C.** Disable automated regression testing entirely on branches, but rely instead on manual testing by QA engineers after features are merged to `main`.
- **D.** Whenever a regression bug is discovered in production and fixed, add a new targeted regression test to the suite to ensure the same defect does not recur in future releases.
- **E.** When regression test suites become too slow, have an AI agent delete older tests without inspection, because bugs in older features can be expected to never resurface after these older features are thoroughly tested and released.

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answers: A, B, D**

- **A is correct:** Running two suites of different sizes is the standard solution to long CI feedback loops: a fast smoke suite, built from the core features of the feature matrix, gates each pull request, while the expensive full regression suite runs before each release.
- **B is correct:** Much of what a UI test checks (validation rules, state transitions, error handling) is logic that can be exercised at the unit level with a fake repository. JVM unit tests run in milliseconds and need no emulator, so moving these checks down a level removes most of the 45 minutes without losing what is being tested.
- **C is incorrect:** Relying only on manual testing, and disabling automated testing on branches, lets regressions reach `main`, where they cost far more to find and fix.
- **D is correct:** This is Rule #1 of regression testing: when you fix a bug, add a test that proves its absence forever. The test fails if a later commit reintroduces the bug, so the bug cannot come back unnoticed.
- **E is incorrect:** Deleting tests without understanding what they cover risks letting previously caught defects back in. A regression is precisely an old feature breaking when new code is introduced, so the tests of old features are the ones that catch it.

**Reference material:** Regression Testing [[pdf](https://drive.google.com/file/d/1jvjD5hflB1mwTaEw0LXY6VLyDodhhQuV/view) | [video](https://www.youtube.com/watch?v=kNFqffUBj8o)]
</details>

---

## Question 10
<!-- id: B2-009 -->

In the bootcamp Todo app, a user fills in the Add Todo form with valid data and presses Save. According to the B2 requirements, which of the following is/are true?

- **A.** The app passes the new todo to the repository
- **B.** The app navigates to the Overview screen
- **C.** The new todo appears in the Overview list without any further action from the user
- **D.** The todo can be saved only if the Location field is not blank
- **E.** The app sets the todo's due date to the current date and time

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A: Save creates the todo and passes the todo to the repository, which writes the todo to Firestore.

B: The user is redirected to the Overview screen, as forward navigation.

C: B2 requires the new todo to be in the list with no further user action (no manual refresh).

D is wrong. In B2, Location is optional and may be left blank.

E is wrong. The due date is the one the user typed in `dd/mm/yyyy` format. Overwriting the date with the current time discards the user's input.

**Scoring**

- `{A, B, C}`: 100%.
- Any two of A, B, C: 65%.
- Any one of A, B, C: 35%.
- Any pattern that includes D, and not E: at most 40%. You would reject valid todos without a location.
- Any pattern that includes E: at most 20%. You would discard every due date the user enters.

**Reference material:** [B2 &sect;2 Create A Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/2-CreateAToDo.md) &middot; [B2 &sect;3 List of ToDos](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/3-TodoList.md)
</details>

---

## Question 11
<!-- id: L-week2-TDDBDD-003 -->

Given the following user story:

*As a registered user, I want to filter my task list by due date, so that I can focus on tasks that are due today.*

Which of the following scenarios represents a **well-crafted, maintainable BDD acceptance scenario** (following Given-When-Then principles) for this user story?

- **A.**
  ```gherkin
  Given the user is on the main screen
  When they click on the Android button with resource ID R.id.btn_filter_date
  And the app makes an HTTP GET request to /api/v1/tasks?filter=today
  Then the server returns a 200 OK status code with a JSON payload of tasks
  ```
- **B.**
  ```gherkin
  Given a user has tasks with different due dates in their task list
  When the user selects the "Due Today" filter
  Then only tasks scheduled for today should be displayed in the list
  ```
- **C.**
  ```gherkin
  When the user filters their tasks by today's date
  Then the tasks are filtered properly
  ```
- **D.**
  ```gherkin
  Given a user has tasks due today
  When the user filters by today
  Then the tasks are displayed
  And the user clicks on the first task
  And the user edits the description
  And the user deletes another task
  And the user logs out of the app
  ```
- **E.**
  ```gherkin
  Given a user creates a new task with title "Buy milk"
  When they open the calendar picker and select today's date
  Then the task status in the Firestore collection "todos" should be set to CREATED
  ```

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answer: B**

- **A is incorrect:** It leaks implementation details. BDD scenarios must describe behavioral business requirements, not implementation details like resource IDs (`R.id.btn_filter_date`), HTTP methods (`GET`), endpoints (`/api/v1/tasks`), or status codes (`200 OK`). Such tests break whenever UI styling or API routes change, even if behavior remains identical.
- **B is correct:** It follows standard declarative BDD best practices:
  - **Given:** Establishes the initial state and context (tasks with varying due dates exist).
  - **When:** Expresses the user's intent and action ("Due Today" filter selected).
  - **Then:** Expresses the observable business outcome (only today's tasks visible).
- **C is incorrect:** It omits the initial context (`Given`) and provides a tautological, non-verifiable outcome ("tasks are filtered properly").
- **D is incorrect:** It daisy-chains multiple unrelated features (filtering, editing, deleting, logging out) into a single scenario. Acceptance scenarios should focus on a single behavior.
- **E is incorrect:** It describes task creation and database internals (`Firestore collection "todos"`), which does not test the filtering user story.

**Reference material:** Behavior-Driven Development (BDD) [[pdf](https://drive.google.com/file/d/1PNItauYWp_Tjiu6yMnqhPY3t8yABAUvR/view) | [video](https://youtu.be/qt5PDa50-VE)]
</details>

---

## Question 12
<!-- id: L-week2-DependencyInjection-003 -->

A development team is evaluating two different ways for `ToDoViewModel` to obtain its dependencies (`ToDosRepository` and `OkHttpClient`):

```kotlin
// Approach 1
class ToDoViewModel : ViewModel() {
    private val repository: ToDosRepository = 
        ToDosRepositoryFirestore(Firebase.firestore)
    private val httpClient: OkHttpClient = OkHttpClient()

    fun loadTodos() { /* ... */ }
}

// Approach 2
class ToDoViewModel(
    private val repository: ToDosRepository,
    private val httpClient: OkHttpClient
) : ViewModel() {

    fun loadTodos() { /* ... */ }
}
```

Which approach is better, and why?

- **A.** Approach 2 is better, because it lets unit tests supply test doubles (such as an in-memory repository or a fake HTTP client), so that the ViewModel can be tested on the local JVM without a live Firebase or network connection.
- **B.** Approach 1 is better, because creating dependencies internally simplifies the ViewModel's constructor and eliminates the need to pass dependencies from repository providers or dependency injection frameworks.
- **C.** Approach 2 is better, because the ViewModel receives whichever implementation of `ToDosRepository` the caller provides, so the data layer can change without modifying the ViewModel.
- **D.** Approach 2 is better, because passing dependencies via the constructor allows the compiler to automatically verify at compile time that the remote Firestore database is reachable.
- **E.** Approach 1 is better, because instantiating a new `OkHttpClient()` directly inside each ViewModel gives each screen an independent connection pool and cache, which improves network performance.

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answers: A, C**

- **A is correct:** Constructor injection allows automated unit tests to substitute lightweight fakes or mocks (e.g., `ToDosRepositoryLocal`, `FakeHttpClient`) on the local JVM. Tests run in milliseconds without network latency, emulator overhead, or Firebase authentication state.
- **B is incorrect:** While Approach 1 avoids constructor arguments, it tightly couples the ViewModel to concrete platform classes (`ToDosRepositoryFirestore`, `FirebaseFirestore`). This makes automated testing and later refactoring much harder, and it violates separation of concerns.
- **C is correct:** In Approach 2, the ViewModel never names a concrete repository class; it works with whatever implementation of the `ToDosRepository` interface it is given. If the team migrates from Firestore to Room or to a REST API, only the code that creates the ViewModel changes, and the ViewModel itself remains unchanged.
- **D is incorrect:** The Kotlin compiler only validates types and syntax at compile time; it cannot check runtime network connectivity or cloud database reachability.
- **E is incorrect:** Creating a new `OkHttpClient` instance inside every ViewModel wastes system resources (each instance allocates its own thread pools and connection sockets). Best practices dictate sharing a single, centralized `OkHttpClient` instance.

**Reference material:** Dependency Injection [[pdf](https://drive.google.com/file/d/1Gs4JAkJ73bZ5rJf2HxO7wt3bXCXNlVYc/view) | [video](https://www.youtube.com/watch?v=nS6A4Kaiupc)]
</details>

---

## Question 13
<!-- id: L-week2-Coverage-004 -->

Consider the following function with two sequential decision points:

```kotlin
fun evaluateCandidate(yearsExperience: Int, hasDegree: Boolean): String {
    var rating = "Junior"
    if (yearsExperience >= 5) {
        rating = "Senior"
    }
    if (hasDegree) {
        rating += " with Degree"
    }
    return rating
}
```

A developer writes a test suite consisting of exactly **two test cases**:

- Test 1: `evaluateCandidate(yearsExperience = 6, hasDegree = true)`
- Test 2: `evaluateCandidate(yearsExperience = 2, hasDegree = false)`

Which of the following statements about this two-test suite is/are true?

- **A.** 100% Statement Coverage
- **B.** 100% Branch Coverage
- **C.** 100% Path Coverage
- **D.** Adding one more test case would bring the suite to 100% Path Coverage
- **E.** None of the above coverage metrics reach 100%

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answers: A, B**

- **A is correct (statement coverage is 100%):**
  - In Test 1 (`yearsExperience = 6`, `hasDegree = true`), `yearsExperience >= 5` is true (executing `rating = "Senior"`), and `hasDegree` is true (executing `rating += " with Degree"`). Every single line in the function is executed in Test 1 alone. Thus, statement coverage is 100%.
- **B is correct (branch coverage is 100%):**
  - Decision 1 (`yearsExperience >= 5`): Test 1 takes the `True` branch; Test 2 (`yearsExperience = 2`) takes the `False` branch (skipping the assignment).
  - Decision 2 (`hasDegree`): Test 1 takes the `True` branch; Test 2 (`hasDegree = false`) takes the `False` branch.
  - Both branches of both decision points are traversed across the two tests. Thus, branch coverage is 100%.
- **C is incorrect (path coverage is not 100%):**
  - There are two independent binary decisions, giving $2 \times 2 = 4$ distinct execution paths:
    1. `(years >= 5: true, hasDegree: true)` &rarr; Tested by Test 1.
    2. `(years >= 5: true, hasDegree: false)` &rarr; **Not tested**.
    3. `(years >= 5: false, hasDegree: true)` &rarr; **Not tested**.
    4. `(years >= 5: false, hasDegree: false)` &rarr; Tested by Test 2.
  - Only 2 out of 4 paths are executed (50% path coverage).
- **D is incorrect:**
  - Two of the four paths are missing, not one. Adding a single test (for example, `evaluateCandidate(6, false)`) brings the suite to 3 out of 4 paths, i.e. 75%. Two more tests are needed for 100% path coverage.
- **E is incorrect:** two of the criteria, statement coverage and branch coverage, do reach 100%.

**Reference material:** Coverage Metrics [[pdf](https://drive.google.com/file/d/1j3rJAyKKTTIwl9lEB7PmXMJUmixj1Mi1/view) | [video](https://www.youtube.com/watch?v=yMSbO17WDAs)] &middot; Coverage in Practice [[pdf](https://drive.google.com/file/d/1fnIuyyevoL5--dGTf_tEUDk3kVfJ6SuP/view) | [video](https://www.youtube.com/watch?v=X2H2FrmylFw)]
</details>

---

## Question 14
<!-- id: B2-008-B -->

For the bootcamp Todo app, an AI agent writes the `addTodo()` method in `AddTodoViewModel`:

```kotlin
fun addTodo() {
    val state = _uiState.value

    // 1. Parse date
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val parsedDate = dateFormat.parse(state.dueDate) ?: return

    val newTodo = ToDo(
        uid = repository.getNewUid(),
        name = state.title,
        description = state.description,
        assigneeName = state.assigneeName,
        dueDate = Timestamp(parsedDate),
        location = state.selectedLocation,
        status = ToDoStatus.CREATED,
        ownerId = "user"
    )

    // 2. Persist to repository
    runBlocking {
        repository.addTodo(newTodo)
    }
}
```

Which of the following reviews about this piece of code is/are valid?

- **A.** Invoking `runBlocking` from the main thread blocks the Android UI thread until the network write completes. This risks frame drops or an Application Not Responding (ANR) error; the call must be launched in `viewModelScope.launch`.
- **B.** `SimpleDateFormat.parse` throws a `ParseException` when given an invalid date string rather than returning `null`. The Elvis operator `?: return` will not catch this exception, causing an unhandled crash whenever the user enters malformed input.
- **C.** In Bootcamp B2, the input contract strictly requires the `dd/MM/yyyy` format (using forward slashes, rejecting formats like `"25-12-2023"` or single digits). The code fails to enforce this structural contract (e.g., using a regex) before parsing.
- **D.** If `dateFormat.parse` fails, the function exits silently (`?: return`) without setting `_uiState.value.errorMsg`, leaving the user with no visual feedback as to why the item was not saved.
- **E.** Calling `repository.getNewUid()` is invalid because IDs must always be generated by the Composable UI before invoking ViewModel methods.

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answers: A, B, C, D**

- **A is correct:** `runBlocking` bridges non-coroutine and coroutine worlds by blocking the calling thread. Inside an Android ViewModel, asynchronous operations must be launched using `viewModelScope.launch { ... }` so execution remains non-blocking.
- **B is correct:** In Java and Kotlin, `SimpleDateFormat.parse(String)` throws a checked `ParseException` when parsing fails; it never returns `null`. Therefore, the Elvis operator `?: return` is unreachable for parse failures, and entering an invalid date string will crash the application with an uncaught exception unless wrapped in a `try-catch` block or `runCatching`.
- **C is correct:** In Bootcamp B2, input validation requires strict conformance to `dd/MM/yyyy` (including two-digit day and month padding and forward slash separators). Relying on date parsing alone without verifying the string against a structural regex check (such as `Regex("""^\d{2}/\d{2}/\d{4}$""")`) allows alternate separators or single-digit formats to bypass the required format contract.
- **D is correct:** When inputs fail validation, the ViewModel should update the UI state with a descriptive error message (`setErrorMsg("Invalid format, date must be DD/MM/YYYY.")`).
- **E is incorrect:** ID generation belongs in the domain/data layer via `repository.getNewUid()`.

**Reference material:** [B2 &sect;2 Create A Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/2-CreateAToDo.md) (date format contract, error messages)
</details>


---

## Question 15
<!-- id: B2-014 -->

In the bootcamp Todo app, why are Save and Delete treated differently from Back on the Edit Todo screen?

- **A.** Save and Delete commit a change and navigate forward, while Back abandons edits and returns to the previous state
- **B.** Back always commits the changes, while Save and Delete only change local UI state
- **C.** Delete is only a visual operation and never changes the repository
- **D.** Save and Delete must both restore unsaved screen states
- **E.** There is no behavioral difference between them

<details>
<summary><b>Show the answer & explanation</b></summary>

**Correct Answer: A**

- **A is correct:** Save and Delete are mutating actions that persist modifications (or removal) to the repository and navigate upon successful completion. Back is a cancellation action that discards unsaved local changes and returns to the previous screen without modifying the repository.
- **B is incorrect:** Back explicitly cancels and discards changes without committing to the repository.
- **C is incorrect:** Delete triggers a persistent deletion on the repository (`repository.deleteTodo(uid)`).
- **D is incorrect:** Save and Delete write to the repository; they do not restore unsaved screen state.
- **E is incorrect:** There is a clear operational difference between committing mutations and aborting edits.

**Reference material:** [B2 &sect;4 Edit a Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/4-EditATodo.md)
</details>
