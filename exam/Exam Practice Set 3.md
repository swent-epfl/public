# Exam Practice Set 3 &mdash; Answers and Explanations

See the [exam README](./README.md) for information on the exam and corresponding practice sets.

This exercise set contains 15 questions covering the material of **week 3**.
They are meant to take on the order of 30 minutes to answer. 
Don't worry about the amount of time it takes you to answer, the point of the exam is to test your knowledge, not the speed with which you can answer. 
The exam will contain many more questions.

We strongly recommend that you answer this exercise set in one sitting, closed-book, without any external help. 
This simulates exam conditions, and will therefore give you a sense of whether the way you studied the material has prepared you well for the exam, or there are changes you need to make.

---

## Question 1
<!-- id: B3-020 -->

A developer adds `ownerId`-based security rules, and a previously working "fetch all todos" query now fails outright instead of returning fewer results. Why does this happen?

- **A.** Firestore security rules evaluate the query as a whole; if any potentially returned document could violate the rules, the entire query is denied
- **B.** Security rules act as a filter: Firestore silently drops the documents the user may not read, so the failure must come from something other than the rules
- **C.** The query itself must be scoped, e.g. filtered by `ownerId` matching the current UID, so it can only match documents the rules allow
- **D.** This is a bug in Firestore and does not reflect intended behavior
- **E.** The failure is most likely due to the number of requested todos, since fetching all todos could be too much for the Firestore API

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, C**

- **A is correct:** "Rules are not filters." Firestore security rules evaluate the query as a whole; if any potentially matching document could violate the rule, the entire query is denied outright.
- **B is incorrect:** Security rules are not filters. Firestore never trims a query's results down to what the rules allow; it rejects the whole query.
- **C is correct:** The query itself must include a `.whereEqualTo("ownerId", currentUserId)` clause so that Firestore can verify upfront that every document the query could return is allowed by the security rule.
- **D is incorrect:** This is the intentional and documented design of Firestore security rules.
- **E is incorrect:** The failure is due to permission denied (security rule violation), not request size or volume.

**Scoring**

- `{A, C}`: 100%.
- `{A}`: 60%.
- `{C}`: 45%.
- Any pattern that includes B: 0%. Treating rules as a filter is the misconception this question is about.
- Any pattern that includes D or E: at most 20%.

**Reference material:** [B3 &sect;2 Access Control](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/2-AccessControl.md)

</details>

---

## Question 2
<!-- id: L-week3-CodeReview-001 -->

While reviewing a teammate's PR for a user profile feature, reviewer Alice leaves the following comments:
- Comment 1: *"Please replace these 4 spaces with 2 spaces on lines 15, 28, and 45 to match our Kotlin formatting."*
- Comment 2: *"Why did you write this method like this? You clearly don't understand coroutines. Rewrite it."*
- Comment 3: *"This database query in UserProfileViewModel runs on Dispatchers.Main. On slower devices, this could block the UI thread and cause dropped frames. Can we switch this to Dispatchers.IO?"*

Evaluating Alice's review against collaborative software engineering best practices, which of the following statements are correct?

- **A.** Comment 1 addresses an issue that should be delegated to automated tooling (e.g., ktfmt) rather than consuming manual human review time.
- **B.** Comment 2 is counter-productive because it attacks the author personally rather than critiquing the code constructively with actionable feedback.
- **C.** Comment 3 represents a constructive code review comment: it identifies a concrete technical risk, explains why it matters, and suggests a specific solution.
- **D.** Reviewers should try to catch whitespace, import ordering, and indentation errors, leaving thread safety and architecture to compiler warnings.
- **E.** Alice should approve the PR for now and fix these issues herself on a separate branch to avoid delaying the Sprint.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

- **A is correct:** "Delegate to computers everything computers can do." Checks for linting and formatting should be automated.
- **B is correct:** Give feedback about the code, not the author, and be constructive: say how to improve the code rather than only what is wrong. Comment 2 insults the author and does not say what to change.
- **C is correct:** Comment 3 explains the hazard (UI thread blocking, dropped frames) and offers a clear, constructive remedy (`Dispatchers.IO`).
- **D is incorrect:** Human reviewers should focus on architecture, correctness, security, and edge cases, leaving formatting to linters.
- **E is incorrect:** Silently fixing another person's code robs the author of the learning opportunity, duplicates effort, and circumvents the code review process.

**Scoring**

- `{A, B, C}`: 100%.
- Any two of A, B, C: 65%.
- Any single one of A, B, C: 30%.
- Any pattern that includes D: at most 20%. It spends the reviewer's attention on what a formatter does automatically.
- Any pattern that includes E: 0%. Approving a PR you have objections to, then rewriting it yourself, bypasses the review.

**Reference material:** Code Reviews [[pdf](https://drive.google.com/file/d/1oJw_v8WWL1EgEZOlx_phUWunf5DjKVl0/view) | [video](https://www.youtube.com/watch?v=cA20Xw9bpok)]

</details>

---

## Question 3
<!-- id: B3-019 -->

In the unit tests in your bootcamp Todo app, is it advised to use the real Nominatim API or to mock these network calls? Why?

- **A.** Mock these network calls, because unit tests must be fast and deterministic, whereas real network calls introduce latency and flakiness due to network or server instability.
- **B.** Mock these network calls, because automated test runs hitting the live Nominatim service risk violating its acceptable usage policy and triggering IP rate-limits or bans.
- **C.** Mock these network calls, because Nominatim's public servers actively detect and reject all HTTP requests originating from automated test suites.
- **D.** Use the real Nominatim API, because unit tests should verify end-to-end network connectivity and ensure live third-party endpoints are reachable.
- **E.** Use the real Nominatim API, because mocking eliminates the ability to test and validate JSON parsing logic.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B**

- **A is correct:** Unit tests need to be fast, repeatable, and deterministic. Hitting a live API over the network introduces latency, flakiness, and failures whenever the network drops or the server is slow.
- **B is correct:** Nominatim is a free, community-supported service, and its usage policy allows at most one request per second, which B3 makes a requirement for the app. Running test suites repeatedly against the live server breaks that limit and risks getting the IP blocked.
- **C is incorrect:** Nominatim does not intrinsically detect or differentiate test runners from real apps; it enforces rate limits and user-agent headers across all incoming traffic.
- **D is incorrect:** Unit tests are designed to verify the logic of individual components in isolation, not live internet connectivity or third-party server uptime.
- **E is incorrect:** Mocked network responses can provide realistic JSON payloads that thoroughly test and validate the deserialization logic without making real HTTP requests.

**Scoring**

- `{A, B}`: 100%.
- `{A}`: 60%.
- `{B}`: 45%.
- Any pattern that includes C, and neither D nor E: at most 25%. The reason to mock is not that Nominatim detects test runners; it is that the tests must be fast, deterministic, and within the usage policy.
- Any pattern that includes D or E: 0%. Both send test traffic to a public service that B3 tells you to spare.

**Reference material:** Test Doubles: Mocks, Stubs, and Fakes [[pdf](https://drive.google.com/file/d/1XKh1dFWOIUSnI2Bi7-n0t9a_A7dIMoAB/view) | [video](https://www.youtube.com/watch?v=QqUIqVwLhzE)] &middot; [B3 &sect;3 Location-based Todos](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/3-LocationBasedTodos.md) &middot; [Unit testing guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/UnitTesting.md)

</details>

---

## Question 4
<!-- id: L-week3-ci-002 -->

Team "CloudNine" has an automated CI pipeline on GitHub Actions that runs linter checks, compiles the Android project, and executes unit and UI tests on every pull request. Over time, several developers adopt the habit of clicking "Merge pull request" despite failing CI checks, claiming: "The test that failed is just a flaky test and unrelated to my PR."

Which of the following statements about this practice and CI principles are correct?

- **A.** Merging PRs with red CI checks destroys the core guarantee of Continuous Integration: that the shared branch is always in a deployable state.
- **B.** Allowing unverified code into `main` encourages other developers to ignore CI failures as well.
- **C.** Flaky tests must be fixed, rather than used as a justification to bypass CI gates.
- **D.** Merging such a pull request is acceptable in a small team, as long as the developers have tested their code and remember to fix the flaky tests later.
- **E.** Disabling CI on branches and running tests only once at the end of the Sprint is the recommended way to prevent flaky tests from blocking developers.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

- **A is correct:** CI's primary value is maintaining a known-good baseline on `main`. Merging red PRs nullifies this guarantee.
- **B is correct:** Once failing builds are tolerated, developers stop trusting CI, leading to rapid degradation of codebase stability.
- **C is correct:** Flaky tests erode trust in CI. They must be fixed, or taken out of the suite until they are fixed, rather than ignored.
- **D is incorrect:** As explained above, this is poor practice even in a small team.
- **E is incorrect:** Deferring testing to the end of a Sprint is poor practice and leads to significant integration problems.

**Scoring**

- `{A, B, C}`: 100%.
- Any two of A, B, C: 65%.
- Any single one of A, B, C: 30%.
- Any pattern that includes D: 0%. Team size does not change what merging a red build does to `main`.
- Any pattern that includes E: 0%. It defers integration problems to the end of the Sprint, when they are most expensive.

**Reference material:** Continuous Integration & Continuous Delivery [[pdf](https://drive.google.com/file/d/1ctfJFpo_jvppAl4nqzpIt8OhtjGIyGVU/view) | [video](https://www.youtube.com/watch?v=35S_p3B0E_4)]

</details>

---

## Question 5
<!-- id: B3-026 -->

A developer instructs an AI coding agent to implement `NominatimLocationRepository(private val client: OkHttpClient)` in the bootcamp Todo app. The agent generates the following implementation for `search`:

```kotlin
class NominatimLocationRepository(private val client: OkHttpClient) : LocationRepository {
    override suspend fun search(query: String): List<Location> {
        val url = "https://nominatim.openstreetmap.org/search?q=$query&format=json"
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute() // Synchronous blocking call
        return parseBody(response.body?.string() ?: "")
    }
}
```

Which of the following statements correctly evaluate technical flaws or testing considerations for this agent-generated code?

- **A.** Calling `client.newCall(request).execute()` inside `search` blocks the thread that calls `search`, which is the main thread when the ViewModel calls it from `viewModelScope`.
- **B.** The request fails to specify a custom `User-Agent` header, which violates OpenStreetMap's Nominatim usage policy and will result in requests being blocked or throttled by the server.
- **C.** Building the URL by string interpolation (`q=$query`) does not escape characters that have a meaning in URLs, so a search for `Fish & Chips, Lausanne` sends Nominatim a truncated query.
- **D.** Because the repository accepts `client: OkHttpClient` as a constructor parameter, unit tests can pass in a mocked `OkHttpClient` (for example, with `mockk`) to test the response parsing without network access.
- **E.** The method should return `List<Location>?` and return `null` when no matching locations are found.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C, D**

- **A is correct:** `execute()` is synchronous: it waits for the server's answer before returning. Declaring `search` as `suspend` does not change that. `viewModelScope` runs on the main thread, so the call holds the main thread for as long as the request takes (in practice, Android refuses network calls on the main thread outright). The bootcamp's Web API guide contrasts `execute`, which runs on the calling thread, with `enqueue`, which makes the request in the background.
- **B is correct:** Nominatim explicitly requires a descriptive `User-Agent` header identifying the application. Requests with default or missing user agents are rejected by OpenStreetMap servers.
- **C is correct:** In a URL, `&` separates query parameters, so `q=Fish & Chips, Lausanne` ends the `q` parameter after "Fish " and adds a stray parameter; a `#` would cut off everything after it. Building the URL with `HttpUrl.Builder().addQueryParameter("q", query)` escapes these characters.
- **D is correct:** Constructor injection lets tests supply a test double for the client. B3's agentic workflow asks for unit tests that mock the injected `OkHttpClient` with `mockk`, so the tests never hit the network.
- **E is incorrect:** Returning empty collections (`emptyList()`) rather than `null` for empty query results is standard API design practice, avoiding unnecessary null checks and preventing `NullPointerException`s in the UI layer.

**Scoring**

- `{A, B, C, D}`: 100%.
- Missing exactly one of A, B, C, D: 70%.
- Missing two of A, B, C, D: 40%.
- Any single one of A, B, C, D: 20%.
- Any pattern that includes E: at most 25%. Returning `null` for "no results" pushes a null check onto every caller, and an empty list already says it.

**Reference material:** [Web API guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/WebAPI.md) &middot; [B3 &sect;3 Location-based Todos](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/3-LocationBasedTodos.md) &middot; [B3 Agentic Workflow](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/AgenticWorkflow.md)

</details>

---

## Question 6
<!-- id: L-week3-CommitMessage-002 -->

Consider the following Git commit message submitted in a team pull request:

```text
Add exponential backoff retry to Nominatim client

When the device experiences transient packet loss or Nominatim throttles
rapid requests while the user types a location, geocoding queries fail
permanently. This change wraps the HTTP call in a retry loop with
exponential backoff (up to 3 attempts) so intermittent network errors
recover automatically.
```

Which of the following statements about this commit message are correct?

- **A.** The subject line adheres to the imperative mood ("Add...") and fits within the recommended 50-character limit.
- **B.** The subject line correctly separates itself from the body with a blank line.
- **C.** The body properly focuses on why the change is necessary and what behavior it introduces, rather than narrating diff syntax.
- **D.** The message is considered poor because it does not list the specific line numbers modified in the source files.
- **E.** The subject line should be changed to "Added exponential backoff retry..." because the code has already been written.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

- **A is correct:** "Add exponential backoff retry to Nominatim client" is 49 characters, capitalized, and in the imperative mood.
- **B is correct:** Separating subject and body with a blank line allows Git tools (`git log --oneline`, GitHub UI) to render the subject as a title and the rest as description.
- **C is correct:** The body clearly identifies the motivation (transient failures while the user types a location) and the mechanism (exponential backoff up to 3 attempts) without regurgitating exact code diffs.
- **D is incorrect:** Commit messages should never cite line numbers; the diff is the source for indicating the lines changed.
- **E is incorrect:** The convention is to use the imperative mood ("Add"), not past tense ("Added").

**Scoring**

- `{A, B, C}`: 100%.
- Any two of A, B, C: 65%.
- Any single one of A, B, C: 30%.
- Any pattern that includes D, and not E: at most 25%. The diff already shows which lines changed; the body is for what and why.
- Any pattern that includes E: 0%. It rejects the imperative mood, which is the rule this message follows.

**Reference material:** Writing Good Commit Messages [[pdf](https://drive.google.com/file/d/1JjXkOzGVbd-3MIclaial4zcmi67X0BMc/view) | [video](https://www.youtube.com/watch?v=vbNDUFe5U6I)] &middot; [Commit messages guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/CommitMessages.md)

</details>

---

## Question 7
<!-- id: B3-002 -->

A student implements Google sign-in in the bootcamp Todo app. Which design choices are consistent with the B3 requirements?

- **A.** Use the provided credential manager instance in `BootcampApp`
- **B.** Use the same credential manager instance for sign-in and sign-out
- **C.** Redirect to Overview after a successful sign-in
- **D.** Put the call to `Firebase.auth.signOut()` in the auth repository's `signOut()`, and have the ViewModel call it
- **E.** Allow sign-in only from the device's default Google account

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C, D**

- **A is correct:** `BootcampApp` already takes a `credentialManager` parameter, and the instrumented tests inject a fake one into it, so the screen must use the injected instance rather than create a second one.
- **B is correct:** B3 asks for the **same** `credentialManager` instance for logout as for sign-in.
- **C is correct:** Once authentication completes successfully, the user should be routed from `SignInScreen` to `OverviewScreen`.
- **D is correct:** In the structure B3 recommends, `AuthRepository` declares `signOut(): Result<Unit>`, and `AuthRepositoryFirebase.signOut()` calls `Firebase.auth.signOut()`. The ViewModel orchestrates the sign-out: `OverviewViewModel.signOut(credentialManager)` calls the repository, sets `signedOut` in the UI state so the app returns to `SignInScreen`, and clears the credential state with the `CredentialManager` instance the screen passes in.
- **E is incorrect:** The user must be able to sign in with any Google account, not only the one already on the device.

**Scoring**

- `{A, B, C, D}`: 100%.
- Missing exactly one of A, B, C, D: 70%.
- Missing two of A, B, C, D: 40%.
- Any single one of A, B, C, D: 20%.
- Any pattern that includes E: 0%. B3 requires that users can sign in with any Google account, including one that is not already on the device.

**Reference material:** [B3 &sect;1 Authentication](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/1-Authentication.md)

</details>

---

## Question 8
<!-- id: L-week3-PR-002 -->

Team "Appventure" finds that their pull requests frequently sit unreviewed for 4 to 5 days, and subtle regressions are often discovered in the `main` branch. Their PRs currently average 850 lines of code.

Which of the following techniques should the team adopt to improve review quality and cycle time?

- **A.** Keep individual PRs small and focused on a single logical change.
- **B.** Slice their features into PRs that can each be reviewed on their own. For example, submit the data model and repository interface in a first PR, followed by ViewModel logic, then UI screens.
- **C.** Reviewers should inspect code at a sustainable pace (roughly 200–500 lines of code per hour, not exceeding 60 minutes in one sitting).
- **D.** Authors should perform a thorough self-review of their own diff before requesting reviews from teammates.
- **E.** Eliminate code reviews and rely on green CI builds to maximize merge speed.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C, D**

- **A is correct:** Small, cohesive PRs are reviewed faster and with greater depth.
- **B is correct:** Incremental PRs allow teammates to review and merge foundational pieces early rather than reviewing the entire feature at the end.
- **C is correct:** It is recommended to review at ~200–500 LOC/hour for no more than an hour at a time to maintain focus and catch defects.
- **D is correct:** Self-reviewing before requesting review catches stray debug code, forgotten TODOs, and unclear names before wasting teammates' time.
- **E is incorrect:** CI cannot verify architectural sanity, code maintainability, or alignment with user requirements. Code review remains indispensable.

**Scoring**

- `{A, B, C, D}`: 100%.
- Missing exactly one of A, B, C, D: 70%.
- Missing two of A, B, C, D: 40%.
- Any single one of A, B, C, D: 20%.
- Any pattern that includes E: 0%. A green build says the tests pass, not that the design is right; it is not a substitute for review.

**Reference material:** Branches and Pull Requests [[pdf](https://drive.google.com/file/d/19YBisRY1N3zL-WzPAgv7t6sg0Sh661It/view) | [video](https://www.youtube.com/watch?v=zRzpq-qFEs8)] &middot; Code Reviews [[pdf](https://drive.google.com/file/d/1oJw_v8WWL1EgEZOlx_phUWunf5DjKVl0/view) | [video](https://www.youtube.com/watch?v=cA20Xw9bpok)]

</details>

---

## Question 9
<!-- id: B3-013 -->

Should you commit `local.properties` to the repository? Why?

- **A.** No, because it contains sensitive credentials (such as the Google Maps API key) that should never be exposed in version control or to anyone with repository access.
- **B.** No, because the CI workflow receives the Maps API key through a GitHub secret, so the file does not need to be in the repository.
- **C.** No, because `local.properties` stores active user login passwords and Firebase authentication tokens generated during app execution.
- **D.** Yes, because all team members and CI pipelines need `local.properties` tracked in version control to resolve the project's Android SDK path and dependencies.
- **E.** Yes, because committing secrets and configuration files to version control is safe and acceptable as long as the repository is private.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B**

- **A is correct:** `local.properties` contains sensitive secrets like the Google Maps API key. Committing it permanently records these credentials in Git history where they can be leaked, scraped, or abused.
- **B is correct:** B3 has you upload the contents of `local.properties`, encoded in base64, as a GitHub secret, and the CI workflow reads the key from that secret. Nothing that needs the file depends on it being committed.
- **C is incorrect:** `local.properties` does not store Firebase authentication tokens, passwords, or runtime session data.
- **D is incorrect:** CI gets what it needs from `local.properties` through the GitHub secret, and each developer keeps their own copy of the file locally. The template lists `/local.properties` in `.gitignore`, and B3 asks you to keep that rule.
- **E is incorrect:** Secrets should never be committed to version control regardless of repository visibility; private repositories can be leaked, opened to third-party collaborators, or converted to public repositories.

**Scoring**

- `{A, B}`: 100%.
- `{A}`: 60%.
- `{B}`: 45%.
- Any pattern that includes C, and neither D nor E: at most 25%.
- Any pattern that includes D or E: 0%. Both put the Maps API key into the repository's history.

**Reference material:** [B3 &sect;4 Google Maps](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/4-GoogleMaps.md)

</details>

---

## Question 10
<!-- id: L-week3-git-002-bis -->

Developer Dave is working on branch `feature-search`. Meanwhile, teammate Alice merges a commit into `main` that refactors `LocationService` into `GeoLocationProvider`. Dave wants to incorporate Alice's changes into his feature branch while maintaining a clean, linear commit history before submitting his PR.

Which of the following statements regarding Dave's Git workflow options is/are correct?

- **A.** Running `git rebase main` while on `feature-search` replays Dave's local commits on top of the latest commit on `main`, creating a linear history.
- **B.** If a merge conflict occurs during `git rebase`, Dave must resolve the conflicting files, mark them resolved with `git add`, and run `git rebase --continue`.
- **C.** If a teammate had already pulled `feature-search` to build on Dave's work, Dave should merge `main` into his branch instead of rebasing it.
- **D.** Merging `main` into `feature-search` would give Dave the same linear history as rebasing, with Alice's commits interleaved by date.
- **E.** Rebase rewrites commit hashes for all replayed commits on the feature branch.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C, E**

- **A is correct:** `git rebase` transplants the branch commits to begin at the tip of the target branch (`main`), avoiding merge commits.
- **B is correct:** Rebase pauses at each conflicting commit, prompting resolution, staging (`git add`), and continuation (`git rebase --continue`).
- **C is correct:** Rebasing gives the replayed commits new identifiers. A teammate who already pulled the old ones ends up with two copies of the same work, which is why you never rebase a branch that somebody else has pulled. Merging leaves the existing commits untouched.
- **D is incorrect:** Merging `main` into `feature-search` creates a merge commit that joins the two histories, so the history is not linear. That is the trade-off: merge preserves the commits as they are, rebase gives the linear history Dave wants.
- **E is correct:** Replaying commits produces brand-new commit objects with different parent hashes and timestamps, giving them new SHA hashes.

**Scoring**

- `{A, B, C, E}`: 100%.
- Missing exactly one of A, B, C, E: 70%.
- Missing two of A, B, C, E: 40%.
- Any single one of A, B, C, E: 20%.
- Any pattern that includes D: at most 25%. Confusing merge with rebase means not seeing why one of them leaves a merge commit.

**Reference material:** Branches and Pull Requests [[pdf](https://drive.google.com/file/d/19YBisRY1N3zL-WzPAgv7t6sg0Sh661It/view) | [video](https://www.youtube.com/watch?v=zRzpq-qFEs8)] &middot; [Collaborative development guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/CollaborativeDevelopment.md)

</details>

---

## Question 11
<!-- id: B3-005 -->

In the bootcamp Todo app, why must a new todo's `ownerId` be validated against `request.auth.uid` in the security rules, rather than trusting the client to set it correctly?

- **A.** A malicious or buggy client could set an arbitrary `ownerId` on a new todo, such as impersonating another user
- **B.** The rule provides server-side enforcement that cannot be bypassed by modifying the client app
- **C.** Firebase automatically overwrites the `ownerId` field to match the authenticated user, so validation is redundant
- **D.** Without this check, `request.auth.uid` would always match `ownerId` regardless of who sends the request
- **E.** It ensures access control decisions rely on server-verified identity rather than client-supplied data

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, E**

- **A is correct:** Never trust the client. A compromised or buggy client could forge any `ownerId` (e.g. associating todos with another victim's account).
- **B is correct:** Firestore security rules execute on the server and cannot be bypassed or modified by altering client-side code.
- **C is incorrect:** Firestore does not automatically overwrite fields on write; whatever fields the client sends are stored unless validated/restricted by rules.
- **D is incorrect:** `request.auth.uid` is the authenticated user's token UID, completely independent of whatever arbitrary `ownerId` string is in the document payload.
- **E is correct:** True access control requires server-side validation against `request.auth.uid`, which is cryptographically verified by Firebase Auth.

**Scoring**

- `{A, B, E}`: 100%.
- Any two of A, B, E: 65%.
- Any single one of A, B, E: 30%.
- Any pattern that includes C: 0%. Believing Firestore fixes `ownerId` for you is the misconception that makes the rule look unnecessary.
- Any pattern that includes D, and not C: at most 25%.

**Reference material:** [B3 &sect;2 Access Control](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/2-AccessControl.md)

</details>

---

## Question 12
<!-- id: L-week3-planning-001 -->

During Sprint Planning, the Product Owner demands that the development team commit to 10 user stories estimated at 80 person-days of work in total, even though, in previous Sprints, the team has completed about 40 person-days of work per Sprint. The PO insists: "I am the Product Owner, and the business needs all of these stories, so you must commit to them."

Which of the following statements accurately critique(s) the PO's position?

- **A.** The PO's demand violates the recommended practice for Scrum teams. The development team should autonomously decide how much work it can realistically take on based on its capacity.
- **B.** The PO's role is to order and prioritize items in the Product Backlog, not to impose the amount of work onto the developers.
- **C.** Arbitrarily inflating Sprint commitments leads to cutting corners, accumulated technical debt, skipped tests, and uncompleted work at the Sprint deadline.
- **D.** The Scrum Master should coach the PO on the self-organizing nature of the development team and protect the team from unrealistic external pressure.
- **E.** The Scrum Master has the final say on exactly how many person-days of work the developers must commit to for each Sprint.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C, D**

- **A is correct:** The dev team is self-organizing and pulls work into the Sprint based on capacity; work is never pushed onto them.
- **B is correct:** The PO controls the order of the Product Backlog, but the developers control the amount of work selected.
- **C is correct:** Imposing unrealistic commitments incentivizes poor engineering practices, broken builds, and missed deadlines.
- **D is correct:** The Scrum Master's duty includes coaching stakeholders and POs on Scrum principles and protecting the team's sustainable pace.
- **E is incorrect:** Neither the PO nor the Scrum Master imposes workload; the developers decide autonomously.

**Scoring**

- `{A, B, C, D}`: 100%.
- Missing exactly one of A, B, C, D: 70%.
- Missing two of A, B, C, D: 40%.
- Any single one of A, B, C, D: 20%.
- Any pattern that includes E: at most 20%. Neither the Product Owner nor the Scrum Master decides how much work the developers take on.

**Reference material:** Scrum – The Team and the Backlog [[pdf](https://drive.google.com/file/d/1s7lvoaiKihvt26yf0cymYqN3lUbi8Uo8/view) | [video](https://www.youtube.com/watch?v=f2EAI5u3GcU)] &middot; Scrum – The Sprint and Its Events [[pdf](https://drive.google.com/file/d/17iSI0hso5XlcxSkoyM0vTmSMGry4lrqw/view) | [video](https://www.youtube.com/watch?v=GIjtLefk164)]

</details>

---

## Question 13
<!-- id: B3-007 -->

A student writes an app that creates a location repository, `NominatimLocationRepository`, which searches for locations through the Nominatim web API, as in the bootcamp Todo app. Which of the following responsibility(ies) belong(s) to this repository?

- **A.** Building the search URL, including `format=json`
- **B.** Sending the HTTP request without blocking the main thread
- **C.** Converting the JSON response into a list of `Location` objects
- **D.** Keeping the text that the user has typed in the location field
- **E.** Setting a `User-Agent` header that identifies the app, as the Nominatim usage policy requires

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C, E**

- **A is correct:** The repository turns a search query into the Nominatim URL, including `format=json` so that the response is JSON.
- **B is correct:** The repository sends the request through OkHttp as a `suspend` operation, so the main thread stays free.
- **C is correct:** The repository parses the JSON array into `List<Location>`. Callers receive locations and never see HTTP or JSON.
- **D is incorrect:** The text in the location field is UI state, held by the screen's ViewModel. The repository receives the query as an argument to `search` and keeps no state about the screen.
- **E is correct:** B3 requires every Nominatim request to send a real `User-Agent` header that identifies the app. The header is part of the HTTP request, so the code that builds the request sets the header.

**Scoring**

- `{A, B, C, E}`: 100%.
- `{A, B, C}`: 75%. You have the repository's structure right and missed the usage-policy requirement.
- Missing exactly one of A, B, C: 65%.
- Missing two of A, B, C, E: 40%.
- Any single one of A, B, C, E: 20%.
- Any pattern that includes D: at most 20%. Option D puts UI state in the data layer.

**Reference material:** [B3 &sect;3 Location-based Todos](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/3-LocationBasedTodos.md) &middot; The Split-App Model [[pdf](https://drive.google.com/file/d/1oL5cQG5iQJosz5Qc-oOqnMJQ-1v0UQt0/view) | [video](https://www.youtube.com/watch?v=Cvfb7-fjczo)] &middot; [Web API guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/WebAPI.md)

</details>

---

## Question 14
<!-- id: L-week3-CodingStandards-001 -->

During their first Sprint, a team spends 40 minutes of their meeting debating whether Kotlin function opening braces should be placed on the same line or on a new line, and whether indentation should be 2 spaces or 4 spaces. How should the team best address this?

- **A.** Agree on an established coding style guide (such as the official Android/Kotlin style guide) and codify it using automated tooling (e.g., ktfmt).
- **B.** Integrate the automated style checker into the CI pipeline to automatically flag or reject PRs with formatting violations.
- **C.** Require code reviewers to manually inspect every PR to ensure all indentation and bracket conventions are followed.
- **D.** Automating formatting enforcement frees up human reviewers to focus on architecture, edge cases, and functional correctness.
- **E.** Strict coding standards are considered poor practice in agile development because they restrict individual developer creativity.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, D**

- **A is correct:** Style arguments should be settled by picking an established standard and enforcing it with a tool.
- **B is correct:** Placing the linter in CI ensures that no badly-formatted code can enter `main`.
- **C is incorrect:** Manual formatting checks are a wasteful use of human review capacity.
- **D is correct:** Automating such checks frees reviewers to spot logic bugs and architectural flaws.
- **E is incorrect:** Consistent coding standards improve readability, simplify onboarding, and reduce cognitive load for the entire team.

**Scoring**

- `{A, B, D}`: 100%.
- Any two of A, B, D: 65%.
- Any single one of A, B, D: 30%.
- Any pattern that includes C, and not E: at most 25%. Checking indentation by hand is the work you are trying to delegate to the tool.
- Any pattern that includes E: 0%. A shared style is what keeps the diff readable and the review focused on the change.

**Reference material:** Coding Standards [[pdf](https://drive.google.com/file/d/1AIb53C4Ad_KcnBorQ8v6v7zt6PED_blg/view) | [video](https://www.youtube.com/watch?v=t5fAWsdzBzA)] &middot; Continuous Integration & Continuous Delivery [[pdf](https://drive.google.com/file/d/1ctfJFpo_jvppAl4nqzpIt8OhtjGIyGVU/view) | [video](https://www.youtube.com/watch?v=35S_p3B0E_4)]

</details>

---

## Question 15
<!-- id: B3-012 -->

Why is it necessary to add your app's SHA-1 fingerprint to the Firebase console before implementing Google Sign-In?

- **A.** It lets Firebase verify that sign-in requests indeed come from your signed app and not an impersonator
- **B.** It is required so Firebase can generate the OverviewScreen UI automatically
- **C.** Without it, Google Sign-In requests from your app would not be trusted by Firebase
- **D.** It replaces the need to enable Google as a sign-in provider in the Firebase console
- **E.** It only matters for release builds, not for local development and testing

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, C**

- **A is correct:** The SHA-1 fingerprint allows Google Play Services and Firebase to verify that OAuth token requests originate from your genuine signed APK and not an impersonating package.
- **B is incorrect:** SHA-1 is purely an authentication and security credential; it has nothing to do with Compose UI rendering.
- **C is correct:** Without the SHA-1 registered in Firebase, Google Sign-In will fail with an APIException (typically status code 10) because the calling package is untrusted.
- **D is incorrect:** Registering the SHA-1 is an additional security requirement; Google Sign-In must still be explicitly enabled in Firebase Auth.
- **E is incorrect:** The debug SHA-1 fingerprint is required for local development and running tests on emulators.

**Scoring**

- `{A, C}`: 100%.
- `{A}` or `{C}`: 55%.
- Any pattern that includes E, and neither B nor D: at most 25%. The debug fingerprint is what makes sign-in work on your machine and in the emulator.
- Any pattern that includes B or D: 0%.

**Reference material:** [B3 &sect;1 Authentication](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/1-Authentication.md)

</details>
