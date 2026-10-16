# SwEnt '26 Project-Warmup Exam — Answers and Explanations

### Instructions

 This exam contains 44 questions totaling 160 points; half cover the lectures, half the Bootcamp. You have 165 minutes to answer them. If you find yourself spending on any given question more minutes than the number of points attributed to it, you might consider moving on to the next question.

The exam consists exclusively of multiple-response questions with pattern-based partial credit (MRQP). For each question there are five answer candidates, and any number of these can be correct; the remainder are wrong. Your score for each question is determined by the whole pattern of your answers not by each option separately, as explained in the class materials. The right strategy is to mark exactly what you believe is right; don’t "play it safe" and don’t "hedge".

Upon entering the exam room, place all your belongings inside your bag and deposit it at the front of the room, then take your assigned seat and place your CAMIPRO on your desk. At your seat you may have at most: your CAMIPRO, pens, correction tape/fluid, a beverage, and a snack. Nothing else is permitted. You are not allowed to use your own paper; if the scratch paper in the exam booklet is insufficient, ask and we will give you more.

The exam is closed-book: no notes, no books, no electronic devices of any kind. Laptops, phones, and smart watches must be turned off and in your bag. If you are noise-sensitive, you may wear ear plugs or ear muffs, but you are not allowed to have any electronic device on or with you (no headphones, no earbuds, no active noise-canceling device, no e-cigarette, no calculator, etc.)

You are not permitted to interact with or receive or give any assistance for the exam except with/from the course staff. The usual EPFL rules on academic honesty apply, and we enforce them.

Use only a black or dark blue ball-point pen. Correct only with correction tape/fluid, if necessary; do not erase.

---

<!-- 11 high (66 pts), 14 medium (56 pts), 19 low (38 pts) = 160 points; 
    lectures 80, bootcamp 80 -->

### Question 1 (4 points)
<!-- id: L1-AI-010 -->
<!-- tier: medium -->

A coding agent is asked to fix a bug in which the total of an order is computed incorrectly. The agent produces a PR that changes 47 files, adding 612 lines and removing 238 lines. Which of the following is/are true?

- **A.** The reviewer's first step should be to ask the agent to split the PR
- **B.** It is legitimate to say "I can't review this" in the review of this PR.
- **C.** The person who approves the PR becomes responsible for its code, as if that person had written it
- **D.** If CI passes, the PR can be merged
- **E.** Having a second agent review the PR, and approving the PR if that agent finds no problems, is an adequate review

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A is correct: The fix for one wrong total should be a few lines in one or two files. The first step is to send the PR back: the total calculation in one PR, any configuration change in another, and the unrelated edits dropped.

B is correct: Nobody is expected to read 850 changed lines looking for the 4-5 that matter. Saying so, and asking for a split, is a review outcome, and one that is useful for both an AI and a human programmer.

C is correct: The agent is a tool. The human who clicks approve is the one who answers for the change when the code breaks in production.

D is wrong: A green CI run says the existing tests pass. The CI result says nothing about whether the files were changed correctly, and agent-written tests can execute code without asserting anything anyway.

E is wrong: A reviewer agent can help, and the lecture's multi-agent workflow includes one, but that workflow still ends with the human reviewing, approving, and owning the result. Approving because another agent found no problems hands the judgment to a tool, and an agent reviewing an 850-line diff has the same difficulty spotting the 4-5 lines that actually matter.

**Scoring**

- `{A, B, C}`: 100%.
- Any two of A, B, C: 70%.
- `{A}` or `{B}` alone: 45%. You know what to do with the PR and have not connected the PR to who is accountable.
- `{C}` alone: 35%.
- Any pattern that includes E: 0%. Approving solely on the strength of an agent's review hands ownership to a tool.
- Any pattern that includes D: 0%. Merging a 47-file change for a single wrong total because CI is green is exactly the vibe-coding problem the lecture describes.

**Reference material:** Agentic Software Development (part 2) [[pdf](https://drive.google.com/file/d/1tBQMQ_FUT6NGSScMMbAfDrkeFw9mToPr/view) | [video](https://youtu.be/bZJ0YpXxxFc)] &middot; Code Reviews [[pdf](https://drive.google.com/file/d/1oJw_v8WWL1EgEZOlx_phUWunf5DjKVl0/view) | [video](https://www.youtube.com/watch?v=cA20Xw9bpok)]

</details>

---

### Question 2 (2 points)
<!-- id: L1-android-004 -->
<!-- tier: low -->

A Family Calendar app keeps the user's events (date, time, place, participants) in a structured database on the phone; by design, the events never leave the phone. A separate "Trip Planner" app, installed on the same phone, needs to query these events in order to suggest free days, without getting direct access to the Family Calendar app's database files. Which Android mechanism is the best fit for giving the Trip Planner app this access?

- **A.** `SharedPreferences`
- **B.** A content provider
- **C.** The cache directory
- **D.** SQLite / Jetpack Room
- **E.** A cloud/backend service

<details>
<summary><b>Show the answer</b></summary>

**Full credit: B**

B is correct: A content provider exposes data to other apps through a query interface (URIs, projections, selection arguments) with permissions the Family Calendar app controls. The Trip Planner app asks for "events between July 1 and July 31" and gets rows back; the Trip Planner app never opens the database file. The system Calendar and Contacts apps work exactly this way.

D is wrong: SQLite / Jetpack Room is how the Family Calendar app most likely stores the data internally, and a content provider is often implemented on top of a Room or SQLite database. But the database file sits in the app's private storage, so Room alone gives the Trip Planner app no access at all. The question asks how to expose the data.

A is wrong: `SharedPreferences` is for small key-value settings, is private to the app, and cannot be queried.

C is wrong: The cache directory is private and the system may delete its contents when storage runs low.

E is wrong: The events are designed never to leave the phone, and both apps run on that phone. Uploading the events to a backend would break that design, add a network dependency, and fail offline.

**Scoring**

- `{B}`: 100%.
- `{B, D}`: 60%. You picked the right mechanism and also marked the storage behind the content provider, which does not by itself let the Trip Planner app read anything.
- `{D}` alone: 20%. You thought about how to store the data, not about how another app reaches it.
- Any pattern that includes E, and neither A nor C: 20%.
- Any pattern that includes A or C: 0%. Both are private to the app, which is the opposite of what the question asks.

**Reference material:** Inside A Mobile OS [[pdf](https://drive.google.com/file/d/1VFsC_hV5U16GOok0e4ya5jZnPUdlbnKl/view) | [video](https://www.youtube.com/watch?v=6zYcDYlbtvs)] &middot; Components of A Mobile App [[pdf](https://drive.google.com/file/d/1QqxpwkUY2DnOKCk4on9RG0dT70SgMkd6/view) | [video](https://www.youtube.com/watch?v=X_-CVsngxzQ)]

</details>

---

### Question 3 (2 points)
<!-- id: L1-android-005 -->
<!-- tier: low -->

Which of the following is/are true about mobile operating systems and/or server operating systems?

- **A.** Both are designed to be used by multiple different users
- **B.** Android runs on thousands of distinct device models, while iOS runs only on iPhones and a few other Apple devices
- **C.** On mobile, users interact with the OS in many ways (touch, voice, sensors), while servers are typically administered through a command line or a remote GUI
- **D.** Both are used interactively all the time, so both need a smooth, real-time, visually appealing GUI
- **E.** Mobile operating systems prioritize battery efficiency, while server operating systems prioritize throughput and uptime, because power consumption is rarely a primary constraint for servers

<details>
<summary><b>Show the answer</b></summary>

**Full credit: B, C, E**

B is correct: Android runs on more than 24,000 distinct device models from many vendors. iOS runs only on Apple's own hardware.

C is correct: Mobile input is touch, gestures, voice, and sensors. A server is headless; administrators SSH into the server or use a remote admin GUI.

E is correct: This is the power-management and execution-model comparison from the lecture. A phone is battery-powered, throttles background work, and gets killed and restarted at the OS's discretion. A server has always-on power, runs daemons without restriction, uses throughput-optimized scheduling, and runs processes indefinitely. This doesn't mean that power doesn't matter for server software and OSes; it is just not generally a primary consideration.

A is wrong: A mobile OS assumes a single user who owns the device and distrusts the apps; a server OS has many users with roles and permissions and distrusts the users.

D is wrong: For a server, UI is "not applicable". Only the mobile side needs a real-time, smooth interface.

**Scoring**

- `{B, C, E}`: 100%.
- Any two of B, C, E: 70%.
- Any one of B, C, E: 40%.
- `{A, B, C, E}`: 40%. Android does support multiple user profiles on some devices, but the security model is built around one user and many untrusted apps, which is the point of the comparison.
- Any two of B, C, E, plus A: 30%.
- Any one of B, C, E, plus A: 15%.
- Any pattern that includes D: 0%. A server with a polished real-time GUI means the headless server model has not registered.

**Reference material:** Mobile OS vs. Server OS [[pdf](https://drive.google.com/file/d/1GPf_-hICP0udMpht8fA0MtYmC4dduEBa/view) | [video](https://www.youtube.com/watch?v=FEXEzNhveg4)]

</details>

---

### Question 4 (4 points)
<!-- id: L1-android-010 -->
<!-- tier: medium -->

Bob uses a SwEnt app to record an audio note. While he is recording, a low-battery dialog appears on top of the app's recording screen. The dialog stays there for 40 seconds, until Bob notices the dialog and dismisses it. Which of the following is/are true?

- **A.** The app's activity remains visible for the whole time the dialog is shown
- **B.** Android calls a method in the app's code when the dialog appears
- **C.** It is correct for the app to keep updating the recording timer on screen during those 40 seconds
- **D.** The app should release the microphone as soon as the dialog appears
- **E.** The app should write the elapsed recording time to storage when the dialog appears, because this is the app's last guaranteed opportunity to save data

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A is correct: The dialog covers part of the screen. The recording screen loses focus but stays visible behind the dialog, which corresponds to the `Paused` state.

B is correct: The system notifies the app via a callback when the activity loses focus to a dialog; whether the app does anything in response is up to the app developer.

C is correct: While paused, an app may keep updating its UI when that makes sense for the user; in lecture we gave as an example a navigation map. The recording is still running, so a timer that keeps counting shows Bob the truth.

D is wrong: Bob is in the middle of recording. Releasing the microphone because a battery warning appeared cuts his note off, and he may not notice until later. Releasing resources makes sense when the app is no longer visible (`onStop()`) or when the recording ends.

E is wrong: The `onPause()` callback should be brief and is not the place for storage writes, and a dialog appearing does not signal that the app is about to be terminated. Heavy saving belongs in `onStop()`, which is also the last callback that the system guarantees before the system may kill the process.

**Scoring**

- `{A, B, C}`: 100%.
- `{A, B}`: 60%. You have the lifecycle right and assume the UI must freeze while paused, which leaves Bob looking at a stopped timer.
- `{B, C}`: 50%.
- `{A, C}`: 50%. You know what the user sees but not that your code is told about the dialog.
- Any single one of A, B, C: 35%.
- `{A, B, C, E}`: 50%.
- `{A, B, E}`: 25%.
- `{B, C, E}` or `{A, C, E}`: 20%.
- Any one of A, B, C, plus E: 10%.
- Any pattern that includes D: 0%. Releasing the microphone on a dialog destroys the user's recording.

**Reference material:** Lifecycle of an Android Activity [[pdf](https://drive.google.com/file/d/1IIg8T3Z1h0YS2hprMiL1WCERPN3slTMY/view) | [video](https://www.youtube.com/watch?v=UplTsKuonbM)]

</details>

---

### Question 5 (2 points)
<!-- id: L1-PM-001 -->
<!-- tier: low -->

A mobile app lets woodworking enthusiasts create and post detailed project plans. Many of the app's users are asking for a way to undo or delete their posts. Which of the following is/are correct?

- **A.** The requests may be a sign of frustration with the post creation workflow, for example unclear confirmation steps or no auto-save. The team should investigate before deciding what to build.
- **B.** The team should simply implement the feature: if enough users ask for the feature, the problem is necessarily that the feature is missing.
- **C.** The team does not need to add the feature, because users will get used to the current UI.
- **D.** The request is reasonable: users always make mistakes, and a content creation workflow should let users correct or remove their mistakes.
- **E.** The team does not need to add the feature; the team should instead work on unrelated features that make the app more enjoyable, so that the complaints matter less.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, D**

A is correct: A feature request is often the user's proposed solution to a problem they have not yet articulated. Many requests for "undo/delete" may mean posts are published by accident: no preview, a Publish button next to Save Draft, no auto-save so users publish to avoid losing work. Find out which before deciding what to build.

D is correct: Users make mistakes no matter how good the workflow is, so being able to correct or remove your own content is a baseline expectation. A and D do not conflict: you can add a delete and also investigate whether there is anything you should fix in the workflow.

B is wrong: The problem is the word "necessarily". The number of requests tells you there is user pain, not which change removes it. Remember the Ford quote from lecture: "If I had asked people what they wanted, they would have said faster horses."

C is wrong: Waiting for users to get used to a UI that frustrates them is how you lose them; the Windows Phone story in the lecture illustrates the price of not listening to users.

E is wrong: Adding unrelated features does not fix the problem users are reporting.

**Scoring**

- `{A, D}`: 100%.
- `{A}`: 70%. You investigate before building, and missed that delete is a reasonable feature regardless.
- `{D}`: 50%. You would build delete and never find out why so many posts need deleting.
- `{B}` or `{B, D}`: 25%. You take the request at face value, instead of looking at the big picture.
- `{A, B}` or any other pattern with both A and B: 0%. One says investigate first, the other says the cause is already known, which yields a self-contradicting answer.
- Any pattern that includes C or E: 0%.

**Reference material:** Requirements [[pdf](https://drive.google.com/file/d/1lU0j6tVLpzMhWsCut3B5KPbb0HR_qYKM/view) | [video](https://youtu.be/7AbFphIDaRs)] &middot; Validating and Prioritizing Requirements [[pdf](https://drive.google.com/file/d/1RWsnOHHE9W1Aa6SpqBb7bqXE9n_CIfHa/view) | [video](https://youtu.be/5oTkRcNK4Q4)]

</details>

---

### Question 6 (6 points)
<!-- id: L1-PM-006 -->
<!-- tier: high -->

Consider the following user story:

> As a student, I want the app to be fast, so that I don't waste time.

Which of the following is/are true when this story is checked against the INVEST criteria?

- **A.** The story fails "Testable"
- **B.** The story fails "Estimable"
- **C.** Whether the story is "Small" cannot be assessed until its scope is defined
- **D.** Replacing its benefit with a more specific one, such as "so that I can check my next room between classes", would be enough to make the story satisfy "Valuable"
- **E.** Replacing "fast" with "in under 3 seconds" would be enough to make the story satisfy all INVEST criteria

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C, D**

A is correct: "Fast" has no acceptance criterion. Nobody can say when the story is done.

B is correct: You cannot estimate the effort to "make the app fast" without knowing which screens, from what baseline, on which devices.

C is correct: Whether the story fits in a Sprint depends on scope. Making the todo list load in under 2 s is small; making every screen of the app fast is an epic.

D is correct: "So that I don't waste time" could be attached to any feature of any app; the clause does not say where time is lost or why saving that time matters. "So that I can check my next room between classes" names the situation and the need, which tells the team what to prioritize and which screen to make fast. The revised story satisfies Valuable, even though it still fails Testable because of "fast".

E is wrong: "In under 3 seconds" still does not say which operation, on what device, over what network. Performance is a property of other stories; a performance target is better written as an acceptance criterion on specific ones ("the todo list appears within 3 s on a Pixel 6a on 4G").

**Scoring**

- `{A, B, C, D}`: 100%.
- `{A, B, C}`: 75%. You see which INVEST criteria the story violates, but not how to improve the user story.
- `{A, B}`, `{A, B, D}`, `{A, C}`, `{A, C, D}`, `{B, C}`, `{B, C, D}`: 50%.
- `{A}`, `{A, D}`, `{B}`, `{B, D}`, `{C}`, `{C, D}`, or `{D}`: 40%.
- `{A, B, C, D, E}`: 30%. You think a number alone makes the story good.
- Any three of A, B, C, D, plus E: 20%.
- Any two of A, B, C, D, plus E: 10%.
- Any one of A, B, C, D, plus E: 5%.

**Reference material:** User Stories and INVEST [[pdf](https://drive.google.com/file/d/1ng7yTpFYbkvTOFzPZGCJwRLUC35BSbfs/view) | [video](https://youtu.be/tbf3sNT5JCw)] &middot; Epics [[pdf](https://drive.google.com/file/d/1PinFSZPqDla69jnlXJS6P7ZwyZsz4Ln2/view) | [video](https://youtu.be/l_spnWitbYM)]

</details>

---

### Question 7 (2 points)
<!-- id: L-week2-testingLevel-003 -->
<!-- tier: low -->

You are implementing an `OfflineSyncCoordinator` in a mobile app. When network requests fail, it buffers pending actions, computes exponential backoff retry delays (e.g., retrying after 2s, 4s, 8s up to a maximum cap), and purges actions that have exceeded a 24-hour expiration window. The class receives its collaborators (`Clock` and `TaskRepository`) as injected interfaces via its constructor.

You want to verify that the coordinator correctly calculates exponential delay intervals, enforces the retry cap, and purges expired actions under various daylight-saving and leap-year boundaries, without waiting for real time to elapse. What is the lowest testing level that best meets your needs?

- **A.** Unit
- **B.** Integration
- **C.** System
- **D.** End-to-end
- **E.** Acceptance
<details>
<summary><b>Show the answer</b></summary>

**Full credit: A**

A is correct: Because `Clock` and `TaskRepository` are abstracted behind interfaces and injected via the constructor, you can supply test doubles (a controllable fake `Clock` and mock `TaskRepository`). This allows all retry calculations, state transitions, and time edge cases to be tested deterministically on the local JVM in milliseconds. Unit testing is the lowest level capable of verifying this internal orchestration logic.

B is wrong: An integration test would test the coordinator against real implementations of the repository or a real database/network client. While valuable later, it is not the lowest level at which one can verify the retry backoff and expiration algorithm.

C is wrong: System tests run the fully assembled app, introducing network latency and test flakiness, which is unnecessarily heavy and slow for verifying deterministic state-machine logic.

D is wrong: End-to-end tests run the fully assembled app through its UI, suffering from the same problems as option C above.

E is wrong: Acceptance testing validates high-level user stories from the stakeholder perspective, not internal backoff and expiration calculations.

**Scoring**

- `{A}`: 100%.
- `{B}`: 10%.
- Any pattern that includes C, D, or E: 0%. These levels run the assembled app and cannot control the clock, so they cannot test the backoff and expiration logic deterministically.

**Reference material:** Levels of Testing [[pdf](https://drive.google.com/file/d/1lFBondvYlDjHikZuSkCXEqvG5z-KEO7q/view) | [video](https://www.youtube.com/watch?v=URvMd41BIwI)] &middot; Test Doubles: Mocks, Stubs, and Fakes [[pdf](https://drive.google.com/file/d/1XKh1dFWOIUSnI2Bi7-n0t9a_A7dIMoAB/view) | [video](https://www.youtube.com/watch?v=QqUIqVwLhzE)] &middot; Dependency Injection [[pdf](https://drive.google.com/file/d/1Gs4JAkJ73bZ5rJf2HxO7wt3bXCXNlVYc/view) | [video](https://www.youtube.com/watch?v=nS6A4Kaiupc)]

</details>

---

### Question 8 (2 points)
<!-- id: L-week2-TDDBDD-001 -->
<!-- tier: low -->

Which statement best describes the difference between Test-Driven Development (TDD) and Behavior-Driven Development (BDD)?

- **A.** TDD is applied only at the unit level, while BDD is applied only at the end-to-end level.
- **B.** BDD should be used only for user interfaces, while TDD should be used only for backend services.
- **C.** TDD centers on writing technical tests before the implementation, while BDD centers on describing the expected behavior from the user's perspective.
- **D.** TDD and BDD are two names for the same practice, with no meaningful difference.
- **E.** BDD requires writing the tests after the implementation is complete, while TDD requires writing the tests first.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: C**

C is correct: TDD writes failing _technical_ tests first, then the code that makes the tests pass. BDD writes the expected behavior first, as Given/When/Then scenarios _in language that non-technical stakeholders can read_, and turns those scenarios into automated tests.

A is wrong: TDD applies at any level, and BDD scenarios can drive tests below the UI.

B is wrong: Neither practice is tied to a layer of the app.

D is wrong: BDD grew out of TDD, but it differs in its focus on behavior as described by the stakeholders.

E is wrong: Both write the specification before the implementation.

**Scoring**

- `{C}`: 100%.
- `{A, C}`, `{B, C}`, `{C, D}`, or `{C, E}`: 20%.
- Any pattern without C: 0%.

**Reference material:** Test-Driven Development (TDD) [[pdf](https://drive.google.com/file/d/19TF5c77_uaUOuzVVY5WKCeJcdc1Y1v9n/view) | [video](https://youtu.be/weLFZSx6KpA)] &middot; Behavior-Driven Development (BDD) [[pdf](https://drive.google.com/file/d/1PNItauYWp_Tjiu6yMnqhPY3t8yABAUvR/view) | [video](https://youtu.be/qt5PDa50-VE)]

</details>

---

### Question 9 (2 points)
<!-- id: L-week2-TDDBDD-002 -->
<!-- tier: low -->

Consider the following user story:

> As a registered user, I want to reset my password via email, so that I can regain access to my account if I forget my password.

Which scenario matches this story?

- **A.** Given a registered user has requested a password reset, When the user clicks the link in the reset email, Then the user should be able to set a new password.
- **B.** Given a registered user is logged in, When the user changes the password on the settings screen, Then the user should be able to log in with the new password.
- **C.** Given a person who is not registered requests a password reset, When that person enters an email address, Then that person should receive a reset link.
- **D.** Given a registered user has forgotten the password, When the user emails the support team, Then an administrator should set a new password for the user.
- **E.** Given a registered user, When the user wants to change the password, Then a form for changing the password should be displayed.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A**

A is correct: It matches the story's role (registered user), action (reset via an emailed link), and goal (regain access by setting a new password).

B is wrong: The user is already logged in, so there is no lost access to regain, and no email is involved. This is a scenario for a "change password" story.

C is wrong: The story is about registered users. Sending a reset link to an address that has no account would be a bug, not the behavior this story asks for.

D is wrong: "Via email" in the story means a self-service reset through an emailed link. A support process where an administrator sets the password is a different feature, and such a process does not let the user regain access on their own.

E is wrong: "When the user wants to change the password" is not an action anyone can perform in a test, "Then a form for changing the password should be displayed" is a UI artifact rather than the outcome the user cares about, and the email part of the story is missing.

**Scoring**

- `{A}`: 100%.
- `{A, E}` or `{A, D}`: 40%.
- `{E}` or `{D}` alone: 15%.
- Any pattern that includes B or C: 0%.

**Reference material:** Behavior-Driven Development (BDD) [[pdf](https://drive.google.com/file/d/1PNItauYWp_Tjiu6yMnqhPY3t8yABAUvR/view) | [video](https://youtu.be/qt5PDa50-VE)] &middot; User Stories and INVEST [[pdf](https://drive.google.com/file/d/1ng7yTpFYbkvTOFzPZGCJwRLUC35BSbfs/view) | [video](https://youtu.be/tbf3sNT5JCw)]

</details>

---

### Question 10 (4 points)
<!-- id: L-week2-RegressionTesting-003 -->
<!-- tier: medium -->

Your app identifies plants by scanning them with the camera, and scanning requires a signed-in account. The app also offers messaging between users, profile pictures, and rating of scanned plants. Before every release, the team runs a small, fast regression suite covering only the user flows without which the app has no purpose. Which user flow(s) belong(s) in that suite?

- **A.** Changing the profile picture
- **B.** Scanning a plant
- **C.** Sending messages
- **D.** Creating an account and signing in for the first time
- **E.** Rating a plant

<details>
<summary><b>Show the answer</b></summary>

**Full credit: B, D**

B is correct: Scanning is the reason the app exists. If a change breaks scanning, the app is useless.

D is correct: Scanning requires a signed-in account, so a broken sign-up flow or first sign-in blocks every new user from reaching the scanner.

A, C, and E are wrong: Changing the profile picture, sending messages, and rating a plant are secondary features. A regression in any of these degrades the app but does not stop the app from identifying plants.

**Scoring**

- `{B, D}`: 100%.
- `{B}`: 70%. You protected the core feature and forgot that users have to reach the scanner first.
- `{B, D, E}`: 50%. You included a flow that depends on scanning, which is not the same as being required for it.
- `{D}`: 40%.
- `{B, E}`: 20%.
- `{A, B, D}` or `{B, C, D}`: 20%.
- `{A, B}` or `{B, C}` or `{A, B, D, E}` or `{B, C, D, E}` or `{A, B, C, D}`: 10%.

**Reference material:** Regression Testing [[pdf](https://drive.google.com/file/d/1jvjD5hflB1mwTaEw0LXY6VLyDodhhQuV/view) | [video](https://www.youtube.com/watch?v=kNFqffUBj8o)] &middot; UI Testing for Your App [[pdf](https://drive.google.com/file/d/1E2JCYZyUf14-5GGsDsj8EZS7XdLr3EUZ/view) | [video](https://www.youtube.com/watch?v=SIPYX5ZUEGs)]

</details>

---

### Question 11 (2 points)
<!-- id: L-week3-CommitMessage-001 -->
<!-- tier: low -->

A developer pushes a commit with the following commit message:

```text
fixed bug.

i changed line 42 in UserRepository.kt from == null to != null because otherwise it was throwing a NullPointerException whenever the user profile picture was missing. also reformatted the file.
```

Which of the following critiques of this commit message are correct?
- **A.** The subject line fails to use the imperative mood ("Fix ...").
- **B.** The subject line is vague and fails to summarize what was actually fixed within the recommended 50-character limit.
- **C.** The commit improperly combines two unrelated concerns: a bug fix and general file reformatting.
- **D.** The body narrates the code change ("changed line 42 from `== null` to `!= null`"), which the diff already shows.
- **E.** The commit message should be one-line only.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C, D**

A is correct: The lecture's rule for the subject line is to use the imperative mood ("Fix profile image crash", not "fixed" or "fixes").

B is correct: The subject line "fixed bug." gives no context on which subsystem or defect was addressed and squanders the 50-character subject budget.

C is correct: The lecture notes that if a subject line is hard to write, the commit probably contains too many changes at once. Here, the reformatting belongs in a separate commit.

D is correct: The lecture's rule for the body is to explain *what* problem was solved and *why*, not to narrate the diff ("how"). "Changed line 42 from `== null` to `!= null`" repeats what anyone can read in the diff, and citing specific line numbers is fragile anyway, because subsequent commits shift lines.

E is wrong: Having a subject line and a body, separated by a blank line, is valid.

**Scoring**
- `{A, B, C, D}`: 100%.
- Any three of A, B, C, D: 70%.
- Any two of A, B, C, D: 35%.
- Any single one of A, B, C, D: 20%.
- `{A, B, C, D, E}`: 20%. A subject line and a body separated by a blank line is the format the lecture recommends; the body's problem is what it says, not the fact that it exists.
- Any three of A, B, C, D, plus E: 10%.

**Reference material:** Writing Good Commit Messages [[pdf](https://drive.google.com/file/d/1JjXkOzGVbd-3MIclaial4zcmi67X0BMc/view) | [video](https://www.youtube.com/watch?v=vbNDUFe5U6I)] &middot; [Commit messages guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/CommitMessages.md)

</details>

---

### Question 12 (2 points)
<!-- id: L-week3-CodeReview-002 -->
<!-- tier: low -->

Bob is conducting a code review on a pull request that adds an offline caching layer. During review, he notices:
1. Several lines use tabs instead of spaces.
2. An unhandled SQLite exception in a background worker will crash the app when the disk is full.
3. The PR spans 1,400 lines across 38 files, combining the offline cache, a complete rewrite of the user profile screen, and updated Gradle dependencies.

How should Bob proceed according to professional code review best practices?

- **A.** Bob can legitimately request the author to split the PR into smaller, cohesive pull requests before performing a deep review.
- **B.** Bob should treat the missing exception handling as a critical defect and explain the crash scenario in a "Request Changes" review.
- **C.** Indentation and tab/space discrepancies should be delegated to automated CI linters rather than debated line-by-line in manual comments.
- **D.** If the automated CI build is currently green, Bob should approve the PR without questioning the architectural design.
- **E.** Bob should spend his review session meticulously writing 40 individual comments pointing out each tab character across all 38 files.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A is correct: "I cannot review this" is a legitimate response to an oversized, sprawling PR. Slicing it into distinct PRs (e.g., one for the cache layer, one for the profile UI, and one for the build dependencies) ensures that each can be reviewed thoroughly and by the right people.

B is correct: Unhandled crash paths are showstopper bugs that justify blocking the merge ("Request Changes") with an explanation of the failure mode.

C is correct: Formatting enforcement belongs to automated tools (linter/formatter), not human reviewers.

D is wrong: Green CI only proves that existing tests pass; it does not prove code is architecturally sound or free of logical edge cases.

E is wrong: Wasting human review effort on syntax formatting causes reviewer fatigue and lets critical bugs (like the unhandled exception) slip through.

**Scoring**

- `{A, B, C}`: 100%.
- Any two of A, B, C: 65%.
- Any single one of A, B, C: 30%.
- `{A, B, C, E}`: 20%. Spending the review on formatting is exactly what automated tools are for.
- Any two of A, B, C, plus E: 10%.
- Any one of A, B, C, plus E: 5%.
- Any pattern that includes D: 0%. A green CI run says the tests pass, not that the design is sound or that the crash path is handled. Getting this wrong is a very serious mistake.

**Reference material:** Code Reviews [[pdf](https://drive.google.com/file/d/1oJw_v8WWL1EgEZOlx_phUWunf5DjKVl0/view) | [video](https://www.youtube.com/watch?v=cA20Xw9bpok)] &middot; Branches and Pull Requests [[pdf](https://drive.google.com/file/d/19YBisRY1N3zL-WzPAgv7t6sg0Sh661It/view) | [video](https://www.youtube.com/watch?v=zRzpq-qFEs8)] &middot; Coding Standards [[pdf](https://drive.google.com/file/d/1AIb53C4Ad_KcnBorQ8v6v7zt6PED_blg/view) | [video](https://www.youtube.com/watch?v=t5fAWsdzBzA)]

</details>

---

### Question 13 (4 points)
<!-- id: L-week3-PR-001 -->
<!-- tier: medium -->

On Thursday evening before project Milestone 1, Developer Alice finishes writing a profile-edit screen for the team's Android app. Her task's user story is "As a user, I want to edit my display name (3–20 characters) so that other users can recognize me."

Alice verifies that typing a new name and tapping "Save" updates the text on her own emulator. She pushes her commits to `main` and marks the user story issue as "Done in M1". 

On Friday morning during the Sprint Review:
1. When the coach tries entering an empty name, the app crashes with an unhandled exception, because input validation was never implemented.
2. The CI pipeline reports that overall project test coverage dropped by 5% because Alice wrote no unit or UI tests for the new screen or ViewModel.
3. Her teammates complain that they never had a chance to review the code.

Which of the following statements correctly evaluate(s) Alice's actions and the team's engineering workflow?

- **A.** The task should not have been marked as "Done", because completing a story requires satisfying both its functional acceptance criteria (validating 3–20 characters) and the standards the team requires of every story before calling it done (peer review, automated tests, no drop in coverage).
- **B.** Pushing directly to `main` is acceptable in a small team, as long as the developer has tested the change manually.
- **C.** Automated test coverage regressions indicate that new code was merged without corresponding tests, which is not good Continuous Integration practice.
- **D.** Alice is correct to declare a task ready for milestone delivery. The team can add tests and fix bugs later in separate issues.
- **E.** The team could relax the standards a task must meet to count as done right before milestone deadlines to be able to ship features on time, as long as they know what are missing.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, C**

A is correct: A task is only "Done" when it fulfills both its story-specific acceptance criteria (input length validation) and the standards the team requires of every story (code reviewed through a PR, passing automated tests, no drop in coverage).

B is wrong: The team's workflow should require that every change be implemented through a feature branch and a pull request, with teammates reviewing it before it is merged into `main`. A manual check on the developer's own emulator does not replace that review, as the crash found by the coach demonstrates.

C is correct: CI pipelines track coverage (e.g., via JaCoCo) precisely to prevent untested code from eroding the project's code health.

D is wrong: "Works on my machine" for a single happy-path manual check does not guarantee correctness or maintainability.

E is wrong: Diluting quality criteria under deadline pressure accumulates technical debt, masks defects, and creates a false impression of progress.

**Scoring**

- `{A, C}`: 100%.
- `{A}`: 60%.
- `{C}`: 40%.
- `{A, B, C}`: 30%. B skips the review that is needed to ensure only good quality code reaches `main`.
- `{A, B}`: 20%.
- `{B, C}`: 15%.
- Any pattern that includes D or E: 0%. Both accept shipping untested, unreviewed work as "done".

**Reference material:** Branches and Pull Requests [[pdf](https://drive.google.com/file/d/19YBisRY1N3zL-WzPAgv7t6sg0Sh661It/view) | [video](https://www.youtube.com/watch?v=zRzpq-qFEs8)] &middot; Scrum – The Sprint and Its Events [[pdf](https://drive.google.com/file/d/17iSI0hso5XlcxSkoyM0vTmSMGry4lrqw/view) | [video](https://www.youtube.com/watch?v=GIjtLefk164)] &middot; Coverage in Practice [[pdf](https://drive.google.com/file/d/1fnIuyyevoL5--dGTf_tEUDk3kVfJ6SuP/view) | [video](https://www.youtube.com/watch?v=X2H2FrmylFw)] &middot; Code Reviews [[pdf](https://drive.google.com/file/d/1oJw_v8WWL1EgEZOlx_phUWunf5DjKVl0/view) | [video](https://www.youtube.com/watch?v=cA20Xw9bpok)] &middot; Continuous Integration & Continuous Delivery [[pdf](https://drive.google.com/file/d/1ctfJFpo_jvppAl4nqzpIt8OhtjGIyGVU/view) | [video](https://www.youtube.com/watch?v=35S_p3B0E_4)] &middot; User Stories and INVEST [[pdf](https://drive.google.com/file/d/1ng7yTpFYbkvTOFzPZGCJwRLUC35BSbfs/view) | [video](https://youtu.be/tbf3sNT5JCw)] &middot; [Collaborative development guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/CollaborativeDevelopment.md)

</details>

---

### Question 14 (2 points)
<!-- id: L-week3-standup-001 -->
<!-- tier: low -->

During a 15-minute Daily Scrum:
1. Developer A describes an issue with a slow Firestore query. Developer B immediately starts arguing about NoSQL index structures, and the two debate database schema design for 11 minutes.
2. Developer C reports: "Yesterday I finished the Todo item card composable. Today I will wire it to the ViewModel. I have no blockers."
3. Developer D reports: "I cannot test the checkout screen because the mock authentication provider that Developer E is building is not merged yet, so I am blocked."

Which of the following statements correctly evaluate(s) these events?

- **A.** The technical debate between Developer A and Developer B should be deferred by the Scrum Master to an offline discussion, to be organized after the Daily Scrum.
- **B.** Developer C's report exemplifies the recommended format: it is concise and answers the three standard questions.
- **C.** Developer D properly identified an impediment (blocker), which the team should coordinate to resolve following the Daily Scrum.
- **D.** The Daily Scrum should be extended to 45 minutes in case team members want to brainstorm an architectural solution.
- **E.** The primary objective of the Daily Scrum is for the Scrum Master to assign tasks and evaluate individual developer's work in full detail.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A is correct: The Daily Scrum is a 15-minute synchronization event, not an architecture design workshop. In-depth technical discussions should be taken offline and involve only the related parties.

B is correct: Developer C reports what was done since the last Standup, what will be done before the next Standup, and whether there are blockers.

C is correct: Calling out blockers openly allows teammates (in this case Developer E) to prioritize work that unblocks their peer.

D is wrong: The 15-minute max for a Standup is strict, to avoid wasting developer time and to keep the meeting energized and focused.

E is wrong: Scrum teams are self-organizing. The Scrum Master's job is not to assign tasks or evaluate work during the short Daily Scrum.

**Scoring**

- `{A, B, C}`: 100%.
- Any two of A, B, C: 65%.
- Any single one of A, B, C: 30%.
- Any pattern that includes D: 0%. The Daily Scrum is timeboxed and never extended, and this is a key tenet of Scrum. Another important principle is that problem solving happens after the Standup. Choosing D indicates an important misunderstanding of Scrum.
- Any pattern that includes E: 0%. The developers manage their own work; the Scrum Master does not assign tasks. Again, choosing E demonstrates a significant misunderstanding of Scrum.

**Reference material:** Scrum – The Sprint and Its Events [[pdf](https://drive.google.com/file/d/17iSI0hso5XlcxSkoyM0vTmSMGry4lrqw/view) | [video](https://www.youtube.com/watch?v=GIjtLefk164)] &middot; Scrum – The Team and the Backlog [[pdf](https://drive.google.com/file/d/1s7lvoaiKihvt26yf0cymYqN3lUbi8Uo8/view) | [video](https://www.youtube.com/watch?v=f2EAI5u3GcU)]

</details>

---

### Question 15 (2 points)
<!-- id: L-week3-sprintReviewAndRetrospective-001 -->
<!-- tier: low -->

During a session with project stakeholders and client representatives, a software engineering team starts demonstrating their newly built authentication flow. Mid-demo, an internal dispute erupts: two developers begin arguing with teammate Leo about his Git habits, complaining that he rarely pulls from `main` before pushing, causing repeated merge conflicts and broken builds.

How should these discussions be structured in Scrum events within a Sprint?

- **A.** The demo of the working Increment and gathering usability feedback from stakeholders belongs in the Sprint Review.
- **B.** Evaluating internal workflow friction, Git branching habits, and interpersonal cooperation belongs in the Sprint Retrospective.
- **C.** The Sprint Review focuses on what was built (the product), whereas the Sprint Retrospective focuses on how the team worked together (the process).
- **D.** External stakeholders and customers should participate in the Retrospective to help judge individual developer friction.
- **E.** The Sprint Retrospective should conclude with concrete, actionable steps that the team commits to implementing in the upcoming Sprint.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C, E**

A is correct: The Sprint Review is designed for inspecting the Increment and gathering feedback with external stakeholders and customers.

B is correct: Internal process issues (Git habits, merge conflicts, collaboration breakdowns) belong in the Retrospective.

C is correct: The Sprint Review differs from the Retrospective in that the former focuses on Product/Value, while the latter on Process/People/Tools.

D is wrong: The Retrospective is an internal team event where developers can speak candidly without external stakeholders or customers present.

E is correct: The primary outcome of a Retrospective is actionable improvement items captured for the subsequent Sprints, starting with the very next one.

**Scoring**

- `{A, B, C, E}`: 100%.
- `{A, B, C}`: 80%.
- Any two of A, B, C, plus E: 65%.
- Any two of A, B, C, E: 40%.
- Any single one of A, B, C, E: 20%.
- `{A, B, C, D, E}`: 30%.
- `{A, B, C, D}`: 25%.
- Any two of A, B, C, plus D and E: 20%.
- Any two of A, B, C, E, plus D: 10%.
- Any one of A, B, C, E, plus D: 5%.

**Reference material:** Scrum – The Sprint and Its Events [[pdf](https://drive.google.com/file/d/17iSI0hso5XlcxSkoyM0vTmSMGry4lrqw/view) | [video](https://www.youtube.com/watch?v=GIjtLefk164)]

</details>

---

### Question 16 (4 points)
<!-- id: L-week3-CodingStandards-003 -->
<!-- tier: medium -->

During a code review for an Android app's offline caching feature, Developer Dave submits the following method in `UserProfileCache.kt`:

```kotlin
class UserProfileCache(private val context: Context) {
    var c: MutableMap<String, UserProfile>? = null

    fun update(id: String, p: UserProfile, flag: Int) {
        try {
            if (flag == 3) {
                val f = File(context.filesDir, "cache.dat")
                f.writeText(p.id + ":" + p.name + ":" + p.email)
            }
            c?.put(id, p)
        } catch (e: Exception) {
            // Continue without crashes
        }
    }
}
```

Teammate Sarah reviews the code. Which of the following critiques correctly identify(ies) violations of professional coding standards and maintainability best practices in Dave's implementation?

- **A.** The empty `catch (e: Exception)` block silently swallows all errors (e.g., disk full, file permission errors, serialization failures), masking critical bugs and making production failures nearly impossible to diagnose.
- **B.** Using the raw literal `flag == 3` is a "magic number" (a hard-coded literal whose meaning is unclear); it should be replaced with a meaningful enum or named constant (e.g., `SyncPolicy.PERSIST_TO_DISK`) that clearly reveals business intent.
- **C.** The single-letter identifiers (`c`, `p`, `f`) violate naming standards by failing to express their domain purpose, increasing cognitive load for teammates reading and maintaining the code.
- **D.** Relying on a nullable `var` for the in-memory cache (`var c: MutableMap<...>?`) introduces needless null checks and mutable state hazards, whereas a `val` with a non-null map would be more robust.
- **E.** Dave's implementation of the `try`-`catch` block is a recommended defensive coding technique because mobile applications should always try to suppress runtime exceptions to ensure the user never experiences an error message.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C, D**

A is correct: Silent failure is one of the most harmful coding practices. Catching and ignoring generic `Exception` conceals fatal defects, corrupts state without warning, and obstructs debugging. Errors should be handled, logged, or re-thrown.

B is correct: Magic numbers obscure code semantics. Named constants or enums document the code self-sufficiently and prevent typos.

C is correct: Meaningful, intent-revealing names (e.g., `profileCache`, `userProfile`, `cacheFile`) communicate meaning instantly, fulfilling the primary purpose of coding standards: reducing reader cognitive load.

D is correct: Preferring immutability (`val`) and non-nullable references where possible avoids writing code that checks for null pointers, and avoids null pointer bugs and accidental reassignment.

E is wrong: Silently swallowing errors is dangerous; it hides bugs from developers and leaves the application in an unpredictable or corrupted state.

**Scoring**

- `{A, B, C, D}`: 100%.
- Missing exactly one of A, B, C, D: 70%.
- Missing two of A, B, C, D: 40%.
- Any single one of A, B, C, D: 20%.
- Any pattern that includes E: 0%. E wrongly endorses empty `catch` blocks, which are among the most harmful problems in code.

**Reference material:** Coding Standards [[pdf](https://drive.google.com/file/d/1AIb53C4Ad_KcnBorQ8v6v7zt6PED_blg/view) | [video](https://www.youtube.com/watch?v=t5fAWsdzBzA)] &middot; Code Reviews [[pdf](https://drive.google.com/file/d/1oJw_v8WWL1EgEZOlx_phUWunf5DjKVl0/view) | [video](https://www.youtube.com/watch?v=cA20Xw9bpok)]

</details>

---

### Question 17 (2 points)
<!-- id: B1-004 -->
<!-- tier: low -->

In the architecture of the bootcamp Todo app, what is the primary responsibility of the ViewModel?

- **A.** Storing the todos persistently, so that the todos survive app restarts
- **B.** Drawing each todo card and deciding the card's layout on screen
- **C.** Managing the screen's UI state and coordinating between the View and the repository
- **D.** Navigating between screens by starting a new Activity for each screen
- **E.** Defining the `ToDo` data class and its fields

<details>
<summary><b>Show the answer</b></summary>

**Full credit: C**

C is correct: The ViewModel holds the screen's state, exposes that state as a `StateFlow`, and calls the repository in response to user actions.

A is wrong: Storage belongs to the repository, and in B1 `ToDosRepositoryLocal` does not persist anything: the list is lost when the app closes. The ViewModel itself lives only as long as its screen.

B is wrong: Drawing and layout are the View's job: the composables in the View render whatever state the ViewModel exposes.

D is wrong: The bootcamp app is a single Activity; navigation happens between composable destinations through the navigation component, not by starting Activities, and navigation is not the ViewModel's job.

E is wrong: The `ToDo` data class is part of the model, which the ViewModel uses but does not define.

**Scoring**

- `{C}`: 100%.
- Any other pattern: 0%. You significantly misunderstood the MVVM design pattern.

**Reference material:** MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) &middot; [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md)

</details>

---

### Question 18 (2 points)
<!-- id: B1-006 -->
<!-- tier: low -->

In the bootcamp Todo app, which of the following responsibilities belong to the View (the composables), rather than to the ViewModel or the repository?

- **A.** Showing a message when the list of todos is empty
- **B.** Attaching test tags to each todo card
- **C.** Keeping the todos sorted in insertion order
- **D.** Using a `LazyColumn` to display the list
- **E.** Deciding when to call `getAllTodos()`

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, D**

A is correct: Deciding to show "no todos" text when the list in the UI state is empty is presentation, and B1 lists it as a requirement of the Overview screen.

B is correct: Test tags are assigned in the View using `Modifier.testTag(...)` on UI elements defined by composables. UI tests then use these tags to locate and interact with those elements.

D is correct: `LazyColumn` displays a vertically scrollable list, composing items as needed; using it to render the todos is the View's responsibility, and the ViewModel supplies the UI state, not the layout.

C is wrong: B1 requires the list to be in insertion order. That ordering is data logic, and that logic belongs in the repository or the ViewModel, where a JVM unit test can check the ordering.

E is wrong: Only the ViewModel calls `getAllTodos()`, in `init` and in `refreshUIState()`, inside `viewModelScope`. The View only triggers `refreshUIState()` and never calls the repository.

**Scoring**

- `{A, B, D}`: 100%.
- Any two of A, B, D: 65%.
- Any one of A, B, D: 35%.

Patterns that include C, but not E:
- `{A, B, C, D}`: 30%. For C, sorting in the View puts testable logic where only UI tests can reach it.
- Any two of A, B, D, plus C: 20%.
- Any one of A, B, D, plus C: 10%.

Patterns that include E, but not C:
- `{A, B, D, E}`: 20%.
- Any two of A, B, D, plus E: 10%.
- Any one of A, B, D, plus E: 5%.

Patterns that include both C and E:
- `{A, B, C, D, E}`: 10%.
- Any two of A, B, D, plus C and E: 5%.
- Any one of A, B, D, plus C and E: 0%.

**Reference material:** MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) &middot; [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md)

</details>

---

### Question 19 (2 points)
<!-- id: B1-008 -->
<!-- tier: low -->

In the bootcamp Todo app, a student decides to write the UI code for every todo by hand, inside one large composable. Which of the following changes best improve(s) maintainability?

- **A.** Moving the large composable into its own file, without changing the per-todo code
- **B.** Creating a reusable composable that displays a single todo
- **C.** Having `OverviewViewModel` build the UI element for each todo and expose the list of UI elements
- **D.** Replacing the per-todo code with a single `Text` that joins all todos into one formatted string
- **E.** Wrapping each todo's code in its own `Column`, with all of these `Column`s nested inside one scrollable parent `Column`

<details>
<summary><b>Show the answer</b></summary>

**Full credit: B**

B is correct: A reusable composable for one todo (the `TodoListItem` from the B1 hint) is written once and used inside the `LazyColumn` for each item. A change to how a todo looks is made in one place.

A is wrong: The duplicated per-todo code is still duplicated; the code has only moved.

C is wrong: The ViewModel exposes state, not UI elements. A ViewModel that builds composables cannot be tested without Compose, and the View is no longer a function of the state.

D is wrong: Combining all todos into a single `Text` eliminates code duplication, but prevents each todo from having its own formatting, test tags, and interaction handlers (e.g., clicking a todo to edit it). B1 requires each value to be displayed in its own `Text` element.

E is wrong: Wrapping each todo in a `Column` does not eliminate the duplicated code. Moreover, placing all these `Column`s inside a scrollable parent `Column` causes all todos to be composed at once, unlike `LazyColumn`, which composes items as needed.

**Scoring**

- `{B}`: 100%.
- `{A, B}` or `{B, E}`: 30%.
- Any pattern that includes C or D, or any pattern without B: 0%.

**Reference material:** [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) &middot; MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md)

</details>

---

### Question 20 (2 points)
<!-- id: B1-005-B -->
<!-- tier: low -->

In the bootcamp Todo app, is `StateFlow` appropriate for exposing the Overview screen's state? Why?

- **A.** Yes, because it lets the UI observe state changes in a lifecycle-aware way
- **B.** Yes, because it automatically creates Firestore documents
- **C.** Yes, because it automatically persists the screen's state across app restarts
- **D.** No, because exposing state through a `StateFlow` prevents the `ViewModel` from updating it
- **E.** No, because `StateFlow` is intended only for one-time events

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A**

A is correct: `StateFlow` always holds a current value, so a composable that starts collecting it with `collectAsState` gets the latest state immediately rather than waiting for the next emission. As the [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md) puts it, the ViewModel manages UI-related data in a lifecycle-aware manner and exposes it through observable data holders like `StateFlow`: the state lives in the ViewModel, so it survives recomposition and rotation, which is why B1 has you keep the Overview state in a `StateFlow` inside the `ViewModel`.

B is wrong: Documents are created by repository code calling Firestore. `StateFlow` is a Kotlin type and knows nothing about your app's backend.

C is wrong: The value lives in memory. Kill the app and the flow starts again from whatever initial value the `ViewModel` gives it.

D is wrong: It describes the pattern backwards. The `ViewModel` keeps the `MutableStateFlow` private and exposes the read-only `StateFlow`. It updates the value; the UI cannot. That asymmetry is the reason for the pattern, not an obstacle to it.

E is wrong: It states the exact opposite of the truth: `StateFlow` always holds a current value, which is what makes it suited to screen state. Even a one-time message such as an error can live in that state: the B2 solution stores `errorMsg` in the UI state, shows it once in a `LaunchedEffect`, and then clears it by calling `clearErrorMsg()` on the ViewModel.

**Scoring**

- `{A}`: 100%.
- `{A, C}`: 40%. Right that the UI observes changes, wrong in thinking in-memory state survives a restart. 
- `{A, B}`: 40%. The same error with Firestore in place of persistence: a Kotlin flow type has no idea your app's backend exists.
- Any pattern that includes D: 0%. D says the pattern prevents the `ViewModel` from updating the state, when keeping `MutableStateFlow` private and exposing the read-only `StateFlow` is the entire point: the `ViewModel` writes, the UI only reads.
- Any pattern that includes E: 0%. Both D and E answer No. Answering No here means you would build the Overview screen some other way, and the other ways are worse.

**Reference material:** MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) (`StateFlow` in `OverviewViewModel`) &middot; [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md)

</details>

---

### Question 21 (6 points)
<!-- id: B1-019 -->
<!-- tier: high -->

A developer puts navigation decisions, repository calls, and UI rendering all inside `MainActivity`. The app works. What is/are the drawback(s) of this design?

- **A.** With this design, the only way to test the navigation and data-loading logic is by running the app on a device or an emulator
- **B.** The app cannot have a UI, because `MainActivity` cannot contain composables
- **C.** The code becomes harder to maintain: a change to one concern (for example, navigation) can accidentally break another concern (for example, data access)
- **D.** The design loses the main benefit of repositories, which is to access data and render that data in the UI
- **E.** The design makes the APK significantly larger

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, C**

A is correct: The navigation decisions and the coordination of repository calls live inside an Activity, so the only way to call and exercise them is to run the Android framework (an instrumented test on a device or emulator). If, instead, the logic was in a ViewModel, then a plain JVM test with a fake repository could cover it in milliseconds. The repository class itself can still be unit-tested; it is the logic around it that cannot.

C is correct: `MainActivity` now has to change whenever either the navigation, the data access, or the layout changes. Since all three are in the same class, often in the same function, a change made for one of them can break another: adding a new destination, for example, can stop a screen from reloading its data.

One class now has three reasons to change. Adding a destination edits the same file, and often the same function, that decides when data is loaded, so a navigation change can break data access.

B is wrong: `MainActivity` calls `setContent { ... }` and hosts composables; that is how the bootcamp app starts.

D is wrong: The option misstates what a repository is for: repositories provide data, and rendering is the View's job. Moving the calls into `MainActivity` does not make the repository render anything.

E is wrong: Moving code between classes does not change the size of the APK in any meaningful way.

**Scoring**

- `{A, C}`: 100%.
- `{C}`: 65%. You see the maintenance cost and not the testing cost.
- `{A}`: 55%.
- Any pattern that includes B: 0%.

Patterns that include E, and neither B nor D:
- `{A, C, E}`: 30%.
- `{C, E}`: 20%.
- `{A, E}`: 15%.

Patterns that include D, but neither B nor E:
- `{A, C, D}`: 20%. D has the repository's role wrong.
- `{C, D}`: 15%.
- `{A, D}`: 10%.

Patterns that include both D and E, but not B:
- `{A, C, D, E}`: 10%.
- `{C, D, E}` or `{A, D, E}`: 5%.

**Reference material:** MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; [B1 &sect;4 Navigation](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/4-Navigation.md) &middot; Dependency Injection [[pdf](https://drive.google.com/file/d/1Gs4JAkJ73bZ5rJf2HxO7wt3bXCXNlVYc/view) | [video](https://www.youtube.com/watch?v=nS6A4Kaiupc)] &middot; Levels of Testing [[pdf](https://drive.google.com/file/d/1lFBondvYlDjHikZuSkCXEqvG5z-KEO7q/view) | [video](https://www.youtube.com/watch?v=URvMd41BIwI)] &middot; [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md)

</details>

---

### Question 22 (6 points)
<!-- id: B1-022 -->
<!-- tier: high -->

A user of the bootcamp Todo app rotates the phone while the Overview screen shows a list of todos. Which of the following is/are true?

- **A.** Because the ViewModel exposes the list as a `StateFlow`, the list survives the rotation
- **B.** If the list were kept in a plain local variable inside the composable, the list would be lost
- **C.** Recomposition alone does not destroy the ViewModel
- **D.** Because `ToDosRepositoryLocal` works offline, the todos also survive closing the app
- **E.** The composable must query the repository again on every recomposition for the list to stay correct

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A is correct: The ViewModel is retained across the configuration change, and its `StateFlow` still holds the list when the new composition collects it.

B is correct: A plain local variable is re-initialized on every recomposition, and even `remember` loses its value when the Activity is recreated.

C is correct: Recomposition re-runs composable functions. Recomposition does not touch the ViewModel, which lives until its owner is finished for good.

D is wrong: B1 states that `ToDosRepositoryLocal` is in memory only, so the list resets when the app is closed. "Offline" means no network, not persisted.

E is wrong: The composable doesn't have to do this; plus, recomposition can happen many times per second. Querying the repository each time is wasted work in B1, and in B2 each query becomes a Firestore read on every frame the state changes.

**Scoring**

- `{A, B, C}`: 100%.
- Any two of A, B, C: 60%.
- `{A}`, `{B}` or `{C}`: 30%.
- `{A, B, C, D}`: 15%. You conflate in-memory with persisted, which B1 says explicitly is not the case.
- Any two of A, B, C, plus D: 10%
- `{A, D}`: 10%.
- `{B, D}` or `{C, D}`: 5%.
- Any pattern that includes E: 0%.

**Reference material:** MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; Lifecycle of an Android Activity [[pdf](https://drive.google.com/file/d/1IIg8T3Z1h0YS2hprMiL1WCERPN3slTMY/view) | [video](https://www.youtube.com/watch?v=UplTsKuonbM)] &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) &middot; [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md)

</details>

---

### Question 23 (4 points)
<!-- id: B1-023 -->
<!-- tier: medium -->

The `app/build.gradle.kts` file of an app contains `compileSdk = 37` and `minSdk = 29`. Which of the following is/are true?

- **A.** The app cannot be installed on a device running API level 28
- **B.** `compileSdk` is the API level that the app is compiled against
- **C.** Raising `minSdk` reduces the number of devices on which the app can be installed
- **D.** `compileSdk` determines the oldest Android version on which the app can run
- **E.** In the bootcamp template, plugin and library versions are defined centrally in `gradle/libs.versions.toml`

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C, E**

A is correct: The setting `minSdk = 29` is the lowest API level the app runs on. The Play Store does not offer the app to API 28 devices, and a direct install fails.

B is correct: The `compileSdk` setting is the level of the API to which the compiler targets the compiled code.

C is correct: Every increase of `minSdk` drops the devices running the levels below it.

E is correct: The bootcamp template declares library and plugin versions in the version catalog, `gradle/libs.versions.toml`, and the build files reference them by alias (for example `libs.firebase.bom`).

D is wrong: It is `minSdk` that imposes the given limitation. `compileSdk` can be higher than the oldest supported device; newer API calls are then guarded by version checks.

**Scoring**

- `{A, B, C, E}`: 100%.
- Missing only E: 85%. You understand the SDK levels and not where the template keeps versions.
- Missing exactly one of A, B, C: 65%.
- Missing two of A, B, C, E: 30%.
- `{A}`, `{B}`, `{C}`, or `{E}`: 10%.
- Any pattern that includes D: 0%. Confusing `compileSdk` with `minSdk` is the error this question tests.

**Reference material:** [B1 &sect;1 Environment Setup](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/1-EnvironmentSetup.md) &middot; Modern Android Development [[pdf](https://drive.google.com/file/d/11cKopMlVmtCwpot6UFlDnvqsvDBvJggU/view) | [video](https://www.youtube.com/watch?v=sqrdwCVkvRs)]

</details>

---

### Question 24 (4 points)
<!-- id: B2-001 -->
<!-- tier: medium -->

In the bootcamp Todo app, a developer wants to replace the local todo storage with Firestore without rewriting the screens. Which design choice(s) support(s) this goal?

- **A.** The ViewModels depend on the `ToDosRepository` interface, rather than on a concrete repository class
- **B.** All Firestore-specific code stays inside the repository implementation
- **C.** The concrete repository is chosen in a single provider or injection point
- **D.** Each composable calls Firestore directly
- **E.** All todo state is moved into `MainActivity`

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A is correct: Screens and ViewModels that know only the `ToDosRepository` interface do not change when the implementation behind the interface does.

B is correct: Firestore types (`DocumentSnapshot`, `Task`, collection names) stay inside `ToDosRepositoryFirestore`. Nothing above the repository imports them.

C is correct: The concrete choice is made in one place. In B2 that place is `ToDosRepositoryProvider`, where one line switches from the local repository to the Firestore one.

D is wrong: If a composables called Firestore directly, it would have to be rewritten when the backend changes&mdash;this is exactly the bad practice this question is aimed at.

E is wrong: State in `MainActivity` is lost on rotation and couples every screen to the Activity.

**Scoring**

- `{A, B, C}`: 100%.
- Any two of A, B, C: 60%.
- Any one of A, B, C: 30%.
- Any pattern that includes D or E: 0%.

**Reference material:** [B2 &sect;3 List of ToDos](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/3-TodoList.md) &middot; [Modularity and abstraction guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/ModularityAndAbstraction.md) &middot; MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; Dependency Injection [[pdf](https://drive.google.com/file/d/1Gs4JAkJ73bZ5rJf2HxO7wt3bXCXNlVYc/view) | [video](https://www.youtube.com/watch?v=nS6A4Kaiupc)]

</details>

---

### Question 25 (4 points)
<!-- id: B2-002 -->
<!-- tier: medium -->

In the bootcamp Todo app, why should the Firestore operations in `ToDosRepositoryFirestore` be declared as `suspend` functions?

- **A.** `suspend` functions allow asynchronous database work without blocking the main thread
- **B.** `suspend` functions guarantee that the operation completes before the screen is drawn
- **C.** `suspend` functions make the Firestore call run on a background thread
- **D.** `suspend` functions can be called from a composable body without a coroutine scope
- **E.** `suspend` functions make the returned data survive configuration changes

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A**

A is correct: A Firestore call can take hundreds of milliseconds. As a `suspend` function using `await()`, the function suspends the coroutine while the request is in flight and releases the thread, so the UI keeps responding.

B is wrong: Option B describes the opposite: the screen is drawn and stays responsive while the operation is in flight, and the UI updates when the result arrives.

C is wrong: The `suspend` keyword does not choose a thread; that is what dispatchers do. The Firestore SDK does its network work on its own threads, but that is true whether or not the repository function is `suspend`. What `suspend` adds is that the caller waits for the result without blocking.

D is wrong: A `suspend` function can only be called from a coroutine or from another `suspend` function; in the bootcamp, that is `viewModelScope`.

E is wrong: Surviving configuration changes comes from holding the data in the ViewModel, not from how the data was fetched.

**Scoring**

- `{A}`: 100%.
- `{A, C}`: 50%. You know the main thread stays free and attribute this to the wrong mechanism.
- `{C}` alone: 10%.
- `{A, E}`: 20%.
- Any pattern that includes B or D: 0%.

**Reference material:** Modern Android Development [[pdf](https://drive.google.com/file/d/11cKopMlVmtCwpot6UFlDnvqsvDBvJggU/view) | [video](https://www.youtube.com/watch?v=sqrdwCVkvRs)] &middot; [B2 &sect;2 Create A Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/2-CreateAToDo.md) &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md)

</details>

---

### Question 26 (2 points)
<!-- id: B2-003 -->
<!-- tier: low -->

In the bootcamp Todo app, a user saves a new todo, and the Firestore write fails because of a permission error or a network error. Which of the following is/are consistent with the B2 design?

- **A.** The repository lets the database exception propagate to the ViewModel
- **B.** The ViewModel exposes an error state that the UI can display
- **C.** The UI tells the user that the todo was not saved
- **D.** The repository returns normally without reporting the error, so that the UI stays simple
- **E.** The app treats the todo as saved, because the user pressed Save

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A is correct: B2 requires database operation failures to propagate from the repository to the ViewModel.

B is correct: The ViewModel catches the exception and turns the exception into state the UI can render, for example an error message.

C is correct: The user must learn that the todo was not saved, or they will rely on something that does not exist.

D is wrong: B2 warns about exactly this: silently swallowing the exception makes the app look as if the app had saved a todo that is not in the database.

E is wrong: Like D, it makes the app look as if it had saved a todo that is not in the database. A button press is not a successful write.

**Scoring**

- `{A, B, C}`: 100%.
- `{A, C}`: 80%.
- `{A, B}`: 75%.
- `{B, C}`: 70%. Right UI behavior, and no account of how the ViewModel learns about the failure.
- `{A}` alone: 40%.
- `{B}` or `{C}`: 20%.
- Any pattern that includes D or E: 0%.

**Reference material:** [B2 &sect;2 Create A Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/2-CreateAToDo.md) &middot; MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)]

</details>

---

### Question 27 (4 points)
<!-- id: B2-006-B -->
<!-- tier: medium -->

In the bootcamp Todo app, a student is writing repository tests and must choose between running them against the live production Firestore database or against the Firebase Emulator Suite. Which of the following give(s) a correct choice together with a correct reason?

- **A.** The Emulator Suite, because tests that run against the emulator do not modify production data
- **B.** The production database, because the Emulator Suite requires a paid Firebase Blaze plan to run in a Continuous Integration (CI) pipeline
- **C.** The Emulator Suite, because the test data can be isolated and cleared between tests
- **D.** The production database, because only the production database reproduces real-world network latency and offline caching
- **E.** The Emulator Suite, because the emulator makes network operations synchronous

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, C**

A is correct: Tests create and delete documents. Against production, they modify real data, and other people's data modifies your test results.

C is correct: The provided `FirebaseEmulatedTest` clears the accounts and documents each test creates, so every test starts from a known state, which makes it predictable.

B is wrong: The Emulator Suite runs locally and in CI at no cost; the bootcamp CI runs against the emulator.

D is wrong: Real network latency matters for performance tests, but these are repository tests that check the repository’s logic, and for them latency only makes the tests slower and flakier. Even a performance test should not run against production: a separate Firebase project has the same latency and no real users’ data. The other half of D’s reason, offline caching, is done on the device by the Firestore client library, so it works the same way against the emulator.

E is wrong: The calls are still asynchronous; tests await them.

**Scoring**

- `{A, C}`: 100%.
- `{A}` or `{C}`: 50%.
- `{A, C, E}`: 30%.
- `{A, E}` or `{C, E}`: 20%.
- Any pattern that includes B or D: 0%. Both choose production for tests.

**Reference material:** Test Doubles: Mocks, Stubs, and Fakes [[pdf](https://drive.google.com/file/d/1XKh1dFWOIUSnI2Bi7-n0t9a_A7dIMoAB/view) | [video](https://www.youtube.com/watch?v=QqUIqVwLhzE)] &middot; [B2 &sect;1 Setup Backend](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/1-SetupBackend.md) &middot; Levels of Testing [[pdf](https://drive.google.com/file/d/1lFBondvYlDjHikZuSkCXEqvG5z-KEO7q/view) | [video](https://www.youtube.com/watch?v=URvMd41BIwI)]

</details>

---

### Question 28 (4 points)
<!-- id: B2-009 -->
<!-- tier: medium -->

In the bootcamp Todo app, a user fills in the Add Todo form with valid data and presses Save. According to the B2 requirements, which of the following is/are true?

- **A.** The app passes the new todo to the repository
- **B.** The app navigates to the Overview screen
- **C.** The new todo appears in the Overview list without any further action from the user
- **D.** The todo can be saved only if the Location field is not blank
- **E.** The app sets the todo's due date to the current date and time

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A is correct: Save creates the todo and passes the todo to the repository, which writes the todo to Firestore.

B is correct: The user is redirected to the Overview screen, as forward navigation.

C is correct: B2 requires the new todo to be in the list with no further user action (no manual refresh).

D is wrong: In B2, Location is optional and may be left blank.

E is wrong: The due date is the one the user typed in `dd/mm/yyyy` format. Overwriting the date with the current time discards the user's input.

**Scoring**

- `{A, B, C}`: 100%.
- Any two of A, B, C: 60%.
- Any one of A, B, C: 30%.

Patterns that include D, but not E:
- `{A, B, C, D}`: 40%. D rejects valid todos without a location.
- Any two of A, B, C, plus D: 20%.
- Any one of A, B, C, plus D: 10%.

Patterns that include E, but not D:
- `{A, B, C, E}`: 20%. E discards every due date the user enters.
- Any two of A, B, C, plus E: 10%.
- Any one of A, B, C, plus E: 5%.

Patterns that include both D and E: 0%.

**Reference material:** [B2 &sect;2 Create A Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/2-CreateAToDo.md) &middot; [B2 &sect;3 List of ToDos](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/3-TodoList.md)

</details>

---

### Question 29 (4 points)
<!-- id: B2-013 -->
<!-- tier: medium -->

In the bootcamp Todo app, a user scrolls down the Overview list and opens a todo on the Edit Todo screen. The user edits the todo's description and due date, then changes the todo's title, and then presses the system Back button, without pressing Save. According to the B1 and B2 requirements, which of the following is/are true?

- **A.** The app returns to the Overview screen, and the list shows the todo with its original values
- **B.** The Overview list is scrolled to the same position as before the user opened the todo
- **C.** The app should write the edited values to Firestore when the Edit Todo screen closes, so that the changes are not lost
- **D.** The next time the user opens this todo, the Edit Todo screen should show the values that the user typed before pressing Back
- **E.** Pressing Back counts as forward navigation to the Overview screen, so the Overview list starts again at the top

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B**

A is correct: B2 requires that Back from the Edit Todo screen returns to Overview, discards unsaved changes, and shows the list as it was before the user opened the todo.

B is correct: Back navigation restores the state of the previous screen, including the scroll position. This is the B1 navigation requirement, and B2 keeps all B1 requirements.

C is wrong: Pressing Back without Save discards the changes. Writing them to Firestore anyway would save changes the user chose not to keep.

D is wrong: B2 requires the Edit Todo fields to be pre-filled with the todo's current values, and the stored values were never changed.

E is wrong: Back is back navigation, not forward navigation, so the Overview state is restored rather than reset.

**Scoring**

- `{A, B}`: 100%.
- `{A}`: 60%. You know the changes are discarded and do not know what Back does to the previous screen.
- `{B}`: 40%.
- Any other pattern: 0%.

**Reference material:** [B2 &sect;4 Edit a Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/4-EditATodo.md) &middot; [B1 &sect;4 Navigation](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/4-Navigation.md)

</details>

---

### Question 30 (2 points)
<!-- id: B2-015 -->
<!-- tier: low -->

In the bootcamp Todo app, a developer copies the entire Add Todo form into the Edit Todo screen, and then modifies each copy separately. Which maintainability problem(s) is/are likely?

- **A.** The input validation rules (for example, the strict `dd/mm/yyyy` date format) and the error messages can end up different on the two screens as the code evolves
- **B.** The two screens will end up writing todos to different Firestore collections
- **C.** Navigating between the two screens will no longer restore state
- **D.** Each screen will recompose twice as often, because the same code exists in two places
- **E.** The Kotlin compiler will reject two composables with identical bodies in the same package

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A**

A is correct: Two copies of the form will inevitably evolve separately. If, for instance, the date validation code is fixed for Add and not Edit, the latter may keep an old bug; when a field is added to one, it has to be added manually to the other too. B3 recommends a single reusable location component for both screens for this reason.

B is wrong: Where todos are written is decided by the repository, which both screens share through their ViewModels.

C is wrong: State restoration depends on the navigation setup and the back stack, not on how the screens' code is organized.

D is wrong: Recomposition happens when the state a composable reads changes. A copy of the code in another screen does not run unless that screen is displayed.

E is wrong: Two functions with different names may have identical bodies; the compiler has no rule against identical bodies.

**Scoring**

- `{A}`: 100%.
- `{A, B}`: 10%.
- Any pattern that includes C, D, or E, or any pattern without A: 0%.

**Reference material:** [B2 &sect;4 Edit a Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/4-EditATodo.md) &middot; [B3 &sect;3 Location-based Todos](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/3-LocationBasedTodos.md) &middot; Coding Standards [[pdf](https://drive.google.com/file/d/1AIb53C4Ad_KcnBorQ8v6v7zt6PED_blg/view) | [video](https://www.youtube.com/watch?v=t5fAWsdzBzA)]

</details>

---

### Question 31 (2 points)
<!-- id: B2-017 -->
<!-- tier: low -->

In the bootcamp Todo app, a todo with `uid` `task-7` is already stored in Firestore. The app then calls `addTodo` with a different todo that also has `uid` `task-7`. Which of the following is/are required by B2?

- **A.** The repository must not end up storing two different todos with the same `uid`
- **B.** The repository must always generate a new `uid` inside `addTodo`, so that a collision cannot happen
- **C.** The repository must use Firestore's auto-generated document ID as the key, and ignore the todo's `uid`
- **D.** The repository must store both todos, because Firestore identifies documents by their contents rather than by `uid`
- **E.** The repository must compare the titles of the two todos, and keep both todos if the titles differ

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A**

A is correct: B2 requires that no two todos have the same `uid` and lets you choose how: throw an exception, or overwrite the existing todo.

B is wrong: B2 states that the repository does not manage `uid`s; a caller that wants a new todo generates the `uid` before calling `addTodo`. A repository that replaced the `uid` would also break callers that later look the todo up by the `uid` they passed in.

C is wrong: `ToDo`s are identified by their `uid`. With auto-generated IDs, two todos with the same `uid` would be stored as two documents, which violates the requirement.

D is wrong: Firestore identifies documents by their ID within a collection, not by their contents. Storing both also violates the requirement.

E is wrong: Titles are not identifiers; two different todos may share a title, and uniqueness is defined on `uid`.

**Scoring**

- `{A}`: 100%.
- `{A, B}`: 30%.
- Any other pattern: 0%.

**Reference material:** [B2 &sect;2 Create A Todo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/2-CreateAToDo.md)

</details>

---

### Question 32 (4 points)
<!-- id: B3-001 -->
<!-- tier: medium -->

A user who is not signed in opens the bootcamp Todo app. Which of the following is/are consistent with the B3 requirements?

- **A.** The app starts on the `SignIn` screen
- **B.** The app may start on the `Overview` screen and show an empty list until the user signs in
- **C.** After a successful sign-in, the app takes the user to the `Overview` screen
- **D.** The user can sign in only with the Google account that is already set up on the phone
- **E.** If the user was signed in the last time the app was closed, the app must ask the user to sign in again

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, C**

A is correct: B3 requires a user who is not signed in to start on `SignInScreen`.

C is correct: B3 requires a successful sign-in to redirect the user to the Overview screen.

B is wrong: B3 requires a user who is not signed in to start on the Sign-in screen. An empty Overview screen would also mislead a returning user who has been signed out: the user would see no todos and conclude the todos were lost.

D is wrong: B3 requires that users can sign in with any Google account, including an account that is not yet on the phone.

E is wrong: B3 leaves this as a free choice: the app may resume the previous session or ask the user to sign in again.

**Scoring**

- `{A, C}`: 100%.
- `{A}` or `{C}`: 55%.
- `{A, C, D}` or `{A, C, E}`: 30%. Both turn a detail that B3 leaves open, or requires the other way, into a rule.
- `{A, D}` or `{A, E}` or `{C, D}` or `{C, E}`: 15%.
- `{A, C, D, E}`: 15%.
- `{A, D, E}` or `{C, D, E}`: 5%.
- Any pattern that includes B: 0%. Option B contradicts A.

**Reference material:** [B3 &sect;1 Authentication](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/1-Authentication.md)

</details>

---

### Question 33 (2 points)
<!-- id: B3-003 -->
<!-- tier: low -->

A user of the bootcamp Todo app signs out successfully. Which outcome(s) is/are required by B3?

- **A.** The app takes the user to the `SignIn` screen
- **B.** The user can still create new todos, but the app does not save them
- **C.** The app deletes the todos that the user created previously
- **D.** If the user signs in again with the same account, the user's previous todos are still there
- **E.** The app keeps showing the `Overview` screen without checking authentication

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, D**

A is correct: After a successful sign-out, B3 requires a redirect to the Sign-in screen.

D is correct: Todos are stored in Firestore under the user's `ownerId`. Signing out ends the session and leaves the data in Firestore; the acceptance criteria require the user to see them again after signing back in.

B is wrong: After sign-out the user is on the Sign-in screen and cannot create todos.

C is wrong: Sign-out does not delete data. A user who signs out to switch accounts would lose everything.

E is wrong: Option E contradicts A.

**Scoring**

- `{A, D}`: 100%.
- `{A}`: 55%.
- `{D}`: 45%.
- `{A, B, D}`: 20%.
- `{A, B}`: 10%.
- `{B, D}`: 5%.
- Any pattern that includes C or E: 0%. C deletes the user's data; E contradicts a stated requirement.

**Reference material:** [B3 &sect;1 Authentication](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/1-Authentication.md) &middot; [B3 &sect;2 Access Control](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/2-AccessControl.md)

</details>

---

### Question 34 (6 points)
<!-- id: B3-023 -->
<!-- tier: high -->

You are developing the bootcamp Todo app and want to establish an automated agentic workflow to implement and verify new features. Consider the following five proposed development loops. Which of the following workflows represent valid, sound agentic software engineering workflows?

- **A.**
  1. You define acceptance criteria using a domain interface (`LocationRepository`).
  2. A test agent writes unit tests that mock the injected `OkHttpClient` with `mockk`, so the tests never hit the network.
  3. The coding agent implements `NominatimLocationRepository.kt` and invokes `./gradlew testDebugUnitTest` via its terminal tool.
  4. The coding agent inspects compiler outputs and test failures, iterating autonomously on its implementation without modifying the test files until all tests pass.
  5. You inspect the resulting `git diff` for architectural boundaries and error handling, stage the files, and commit.
- **B.**
  1. You check out a dedicated feature branch (`milestone-B3-agent`) and task a coding agent with implementing `CalendarViewModel`.
  2. A test agent writes unit tests verifying UI state emissions and error handling.
  3. Once tests pass, a reviewer agent is launched in a fresh, independent CLI session with an isolated context window, and you give it a structured review checklist to review the pull request diff.
  4. You review the changes and the results of the review checklist, run local `./gradlew check`, and make the final merge decision.
- **C.**
  1. You prompt an agent in a chat session to write `ToDosRepositoryFirestore`.
  2. The agent outputs code, and you ask in the same session: "Please review your code and verify it has no bugs or security defects."
  3. The agent replies: "I have verified my code; it adheres 100% to all guidelines with zero defects."
  4. You merge the code into `main` and push the updated `main` branch to GitHub.
- **D.**
  1. You prompt an autonomous agent: "Make `./gradlew check -B2 -public` pass."
  2. The agent runs the check and encounters compilation errors in `SignatureChecks.kt` and failures in `AddToDoScreenB2Test`.
  3. The agent alters `SignatureChecks.kt` and deletes failing assertion lines in `AddToDoScreenB2Test`.
  4. The check passes green, and the agent commits the changes.
- **E.**
  1. You issue a prompt: "Add Google Maps to the overview screen."
  2. The agent refactors the entire navigation graph and updates Gradle build dependencies across 20 files.
  3. The agent executes `git add .`, commits with message `"update"`, and runs `git push origin main`.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B**

A is correct: It exemplifies the sound single-agent test-driven loop: bounded task definition, objective tool feedback (compilation and test execution), iterative refinement against fixed acceptance tests, and human diff gatekeeping before commit.

B is correct: It exemplifies the sound multi-agent pipeline: separation of concerns (Coder, Tester, Reviewer), a fresh session for the reviewer, which stops the reviewer from simply defending the coder, structured checklist guidelines, and human review ownership.

C is wrong: Asking the agent to review its own code in the same session teaches you little, because the reviewer ends up simply defending the coder. Conversational claims of correctness ("it has no bugs") are untrustworthy without automated tool execution (`./gradlew check`) and human diff inspection.

D is wrong: Unconstrained goal-seeking may cause agents to mutate the tests (deleting assertions or modifying grading signatures) rather than fixing the implementation.

E is wrong: Unbounded prompts trigger massive diff sprawl, blanket staging (`git add .`) can pull in files that nobody reviewed, and pushing directly to `main` bypasses review and CI.

**Scoring**

- `{A, B}`: 100%.
- `{A}` or `{B}`: 55%.
- `{A, B, C}`: 25%. An agent reviewing its own code in the same session tells you little, and C merges on the strength of that review.
- `{A, C}` or `{B, C}`: 15%.
- Any pattern that includes D or E: 0%. D lets the agent weaken the tests and signature checks to get a green run; E pushes an unreviewed, sprawling change straight to `main`.

**Reference material:** Agentic Software Development (part 2) [[pdf](https://drive.google.com/file/d/1tBQMQ_FUT6NGSScMMbAfDrkeFw9mToPr/view) | [video](https://youtu.be/bZJ0YpXxxFc)] &middot; [B2 Agentic Workflow](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/AgenticWorkflow.md) &middot; [B3 Agentic Workflow](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/AgenticWorkflow.md)

</details>

---

### Question 35 (4 points)
<!-- id: B3-006 -->
<!-- tier: high -->

The bootcamp Todo app sends a Firestore query for all todos, without filtering by owner. The B3 security rules are deployed. What happens?

- **A.** The request fails, because the query does not satisfy the security rules
- **B.** The app may receive todos that do not belong to the signed-in user
- **C.** Firestore returns only the todos owned by the signed-in user
- **D.** If the same query is sent from a third-party client instead of the app, Firestore returns all todos, because the rules apply only to requests sent by the app
- **E.** The app receives an arbitrary subset of the todos

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A**

A is correct: Firestore security rules are not filters. For each query, Firestore checks whether the query could return a document the user is not allowed to read. An unfiltered query over `todos` could, so the whole request is rejected, even if every document happened to belong to the user.

B is wrong: That is the behavior without the rules, which B3 exists to fix.

C is wrong: Firestore does not rewrite your query to match the rules. This is the most common misconception about rules, and B3 warns about this misconception.

D is wrong: Security rules are deployed to and evaluated by Firestore itself. A third-party client sends its queries to the same server and is checked against the same rules, so the client's unfiltered query fails as well.

E is wrong: Firestore never returns an arbitrary subset; a query either succeeds in full or fails.

**Scoring**

- `{A}`: 100%.
- `{A, D}`: 20%. You know unfiltered queries fail, but believe the rules are enforced by the app rather than by the server.
- Any other pattern is a self-contradicting answer: 0%.

**Reference material:** [B3 &sect;2 Access Control](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/2-AccessControl.md)

</details>

---

### Question 36 (6 points)
<!-- id: B3-024 -->
<!-- tier: medium -->

For the bootcamp Todo app, a student orchestrates a multi-agent workflow where a coding agent implements a new feature. The student opens a pull request containing the agent's implementation and asks a reviewer agent to review the PR diff against project conventions. The pull request contains the following code:

```kotlin
@Composable
fun CalendarToDo(
    todosRepository: ToDosRepository,
    viewModel: CalendarViewModel = viewModel()
) {
    val todos by viewModel.todos.collectAsState()
    val scope = rememberCoroutineScope()
    
    val groupedTodos = todos.groupBy { SimpleDateFormat("yyyy-MM-dd").format(it.dueDate.toDate()) }

    LazyColumn {
        items(groupedTodos.keys.toList(), key = { it }) { date ->
            DateHeader(date)
            groupedTodos[date]?.forEach { todo ->
                TodoItemRow(
                    todo = todo,
                    onToggleDone = {
                        val updated = todo.copy(status = ToDoStatus.ENDED)
                        // Calling repository directly from UI
                        scope.launch {
                            todosRepository.editTodo(todo.uid, updated)
                        }
                    }
                )
            }
        }
    }
}
```

Which of the following review comments accurately identify defects or poor practices in this piece of code?

- **A.** MVVM Violation: `CalendarToDo` directly accepts `ToDosRepository` and calls `todosRepository.editTodo(...)` from the UI; the composable must instead dispatch user actions to `viewModel.setTodoDone(todo)`.
- **B.** Poor decoupling of logic: Grouping by `todos.groupBy` should belong in `CalendarViewModel`. Furthermore, in the current implementation, a fresh `SimpleDateFormat` object has to be created on every recomposition, which is inefficient.
- **C.** Testability impairment: Embedding grouping logic and direct repository mutations inside the composable prevents this behavior from being verified with fast JVM unit tests; moving these responsibilities to the ViewModel allows testing all grouping and status-change logic without launching an Android emulator or UI test runner.
- **D.** UI state out of sync: Directly mutating the repository from the UI bypasses the ViewModel's state management, preventing the ViewModel from coordinating UI state transitions, displaying loading indicators, or capturing error messages if the update fails.
- **E.** State encapsulation: In MVVM, composables can be allowed to talk directly to repositories if a ViewModel becomes too large.

<details>
<summary><b>Show the answer & explanation</b></summary>

**Full credit: A, B, C, D**

A is correct: In MVVM, Views (Composables) only render state and send events to the ViewModel. Passing repositories into composables creates tight coupling and bypasses ViewModel state management.

B is correct: Grouping should be performed in the ViewModel and exposed as ready-to-display UI state. Performing data transformations (`groupBy`) during composition repeats the work every time the composable recomposes.

C is correct: Logic embedded inside UI composables cannot be tested using lightweight, fast local JVM unit tests. Placing data transformation and mutation logic in the ViewModel ensures it can be tested in isolation with fast, deterministic JVM unit tests.

D is correct: In MVVM, state goes from the ViewModel to the UI, and user actions go from the UI to the ViewModel. Calling the repository directly from the UI creates a side channel that the ViewModel knows nothing about, leaving the ViewModel's UI state out of sync and unable to manage errors or loading states.

E is wrong: Bypassing the ViewModel directly contradicts the project's core MVVM guidelines and erodes architectural boundaries.

**Scoring**

- `{A, B, C, D}`: 100%.
- Missing exactly one of A, B, C, D: 70%.
- Missing two of A, B, C, D: 40%.
- Any single one of A, B, C, D: 20%.
- Any pattern that includes E: 0%. E contradicts A: composables talking directly to repositories is what MVVM rules out.

**Reference material:** MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; [B3 Agentic Workflow](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/AgenticWorkflow.md) &middot; Code Reviews [[pdf](https://drive.google.com/file/d/1oJw_v8WWL1EgEZOlx_phUWunf5DjKVl0/view) | [video](https://www.youtube.com/watch?v=cA20Xw9bpok)] &middot; [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md) &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md)

</details>

---

### Question 37 (2 points)
<!-- id: B3-017 -->
<!-- tier: low -->

Why is it difficult to reach high unit-test coverage for code that integrates Google Maps? And what should you do about it?

- **A.** Because the classes in the Google Maps SDK are final and cannot be mocked, standard unit testing of map interactions is impractical
- **B.** UI tests of the map are limited, because the inputs to the map component cannot easily be controlled
- **C.** Code that uses Google Maps cannot be tested at all, so no coverage should be expected for that code
- **D.** The recommended approach is to keep the logic independent of the map components, so that the logic can still be tested
- **E.** JaCoCo cannot measure coverage of files that import the Google Maps SDK

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, D**

A is correct: B3 states that the classes of the Google Maps SDK are final, so the standard way of replacing them with mocks in unit tests does not work.

B is correct: UI tests can render the map, but you cannot easily drive the map's inputs (camera moves, marker taps), so large parts of the code stay unexercised.

D is correct: Keep the logic (which todos get markers, where to center the camera, what happens on a tap) in plain Kotlin code that takes and returns data. That code is testable; the map composable becomes a thin layer that only displays the result.

C is wrong: The code can be partially tested, and the logic around it fully.

E is wrong: JaCoCo instruments bytecode and does not care which libraries a file imports.

**Scoring**

- `{A, B, D}`: 100%.
- `{B, D}`: 100%. We accept this because of how option A was phrased.
- `{A, B}` or `{A, D}`: 65%.
- `{D}` alone: 45%.
- `{A}` or `{B}`: 35%.
- Any pattern that includes C or E: 0%.

**Reference material:** Test Doubles: Mocks, Stubs, and Fakes [[pdf](https://drive.google.com/file/d/1XKh1dFWOIUSnI2Bi7-n0t9a_A7dIMoAB/view) | [video](https://www.youtube.com/watch?v=QqUIqVwLhzE)] &middot; [B3 &sect;4 Google Maps](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/4-GoogleMaps.md) &middot; Coverage in Practice [[pdf](https://drive.google.com/file/d/1fnIuyyevoL5--dGTf_tEUDk3kVfJ6SuP/view) | [video](https://www.youtube.com/watch?v=X2H2FrmylFw)] &middot; UI Testing for Your App [[pdf](https://drive.google.com/file/d/1E2JCYZyUf14-5GGsDsj8EZS7XdLr3EUZ/view) | [video](https://www.youtube.com/watch?v=SIPYX5ZUEGs)]

</details>

---

### Question 38 (6 points)
<!-- id: B3-025 -->
<!-- tier: high -->

You are implementing `NominatimLocationRepository` for your bootcamp Todo app, which queries the OpenStreetMap Nominatim REST API to convert location search strings into a list of `Location(latitude, longitude, name)` objects. The repository receives an `OkHttpClient` via `HttpClientProvider.client`.

You prompt a test agent to write unit tests for `NominatimLocationRepository`. The agent generates a test suite and reports 100% test pass rate. Your reviewer agent reviews the newly added test files and reports the following. Which of the following findings indeed represent(s) defective test designs or poor practices that should be rejected?

- **A.** The test method invokes `repository.search("EPFL")` without configuring a test double, allowing the `OkHttpClient` to send a live HTTP request over the internet to `nominatim.openstreetmap.org`.
- **B.** The test method executes `val results = repository.search("EPFL")` and only asserts `assertNotNull(results)` and `assertTrue(results.isNotEmpty())`, without asserting that `results[0].latitude`, `longitude`, and `name` match expected coordinates and names.
- **C.** The test uses `mockk` or `Mockito` to mock `NominatimLocationRepository` itself, stubbing `every { mockRepo.search(any()) } returns listOf(...)`, and asserts that the mock returns the stubbed list.
- **D.** The test configures a fake HTTP client (such as `FakeHttpClient` using an `Interceptor`) that intercepts the request and returns a simulated HTTP 500 response to verify that the repository handles server errors gracefully, instead of sending requests to the real sesrver.
- **E.** The test intercepts the outgoing HTTP request and verifies that the `User-Agent` header is set to a descriptive application identifier in compliance with the Nominatim usage policy.

<details>
<summary><b>Show the answer & explanation</b></summary>

**Full credit: A, B, C**

A is correct: Unit tests must be isolated, deterministic, and should not hit the network in this context. Live HTTP requests introduce network flakiness, latency, dependency on external server uptime, and risk getting IP-blocked by Nominatim's strict rate limits. Tests must use test doubles (`FakeHttpClient`, `MockWebServer`, or mocked `OkHttp` clients).

B is correct: This is the classic "vacuous test" failure mode of AI agents. `assertNotNull` and `isNotEmpty` pass even if the JSON parsing in `parseBody()` inverted latitude and longitude or left the display name empty. Meaningful tests must assert specific field values (e.g., `assertEquals(46.519, results[0].latitude, 0.001)`).

C is correct: Mocking the class under test (`NominatimLocationRepository`) instead of its dependency (`OkHttpClient`) tests nothing but the mocking library itself. Zero lines of actual repository logic (URL building, network execution, JSON parsing) are exercised.

D is wrong: This is not a valid objection. Simulating a network failure (HTTP 500, a timeout) with an interceptor or fake client is fine in a unit test: the fake stands in for the server, so the test checks only the repository’s error handling, without depending on any real external system.

E is wrong: Nominatim strictly requires a valid `User-Agent` header and blocks requests that omit it. Verifying this header in outgoing requests ensures adherence to API contracts.

**Scoring**

- `{A, B, C}`: 100%.
- Any two of A, B, C: 60%.
- Any single one of A, B, C: 30%.
- `{A, B, C, D}`: 50%. Thinking that D is not a valid unit test is a mistake more subtle than other ones in this question.
- `{A, B, C, E}`: 20%. Rejecting a test that checks the `User-Agent` header the Nominatim usage policy requires, means rejecting exactly the tests the bootcamp asks for.
- Any two of A, B, C, plus one of D (or E): 20% (respectively 10%).
- Any one of A, B, C, plus one of D (or E): 10% (respectively 5%).
- `{A, B, C, D, E}`: 10%.
- Any two of A, B, C, plus D and E: 5%.
- Any other pattern: 0%.

**Reference material:** Test Doubles: Mocks, Stubs, and Fakes [[pdf](https://drive.google.com/file/d/1XKh1dFWOIUSnI2Bi7-n0t9a_A7dIMoAB/view) | [video](https://www.youtube.com/watch?v=QqUIqVwLhzE)] &middot; [B3 &sect;3 Location-based Todos](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/3-LocationBasedTodos.md) &middot; [B3 Agentic Workflow](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B3/AgenticWorkflow.md) &middot; [Unit testing guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/UnitTesting.md) &middot; [Web API guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/WebAPI.md)

</details>

---

### Question 39 (6 points)
<!-- id: L-week2-CyclomaticComplexity-001 -->
<!-- tier: high -->

Consider the following function:

```kotlin
fun shippingFee(order: Order): Double {
    var fee = 5.0
    if (order.isExpress && order.weightKg > 2.0) {
        fee += 10.0
    }
    for (item in order.items) {
        if (item.isFragile) {
            fee += 2.0
        }
    }
    if (order.total > 100.0) {
        fee = 0.0
    }
    return fee
}
```

Which of the following is/are true?

- **A.** The cyclomatic complexity of `shippingFee` is 6
- **B.** A test suite that exercises a basis set of linearly independent paths through `shippingFee` reaches 100% branch coverage of `shippingFee`
- **C.** Reaching 100% branch coverage of `shippingFee` requires at least as many tests as the cyclomatic complexity of `shippingFee`
- **D.** `shippingFee` has 2 × 2 × 2 = 8 paths, one for each combination of outcomes of its three `if` statements
- **E.** If the `for` loop is moved into a new function `fragileSurcharge(items)` and `shippingFee` calls that function, the cyclomatic complexity of `shippingFee` drops to 4

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, E**

A is correct: The count starts at 1. The first `if` has two conditions joined by `&&`, which adds 2. The `for` loop adds 1, the `if` inside the loop adds 1, and the last `if` adds 1. Total: 1 + 2 + 1 + 1 + 1 = 6.

B is correct: A basis set of linearly independent paths covers every edge of the control-flow graph, so testing those paths guarantees 100% branch coverage. This is basis-set testing.

E is correct: After the extraction, `shippingFee` contains only the first `if` (+2) and the last `if` (+1), so its complexity is 1 + 2 + 1 = 4. The loop and its `if` now count toward `fragileSurcharge`, which has a complexity of 3. The total decision logic has not disappeared, but each function is simpler to read and to test on its own. This is because the call itself adds nothing to cyclomatic complexity, just as the call to `weeklyDiscounts.getOrDefault(...)` in the lecture’s `totalAfterDiscounts` example adds nothing, even though `getOrDefault` makes a decision internally: cyclomatic complexity is computed per function, from that function’s own control-flow graph.

C is wrong: Cyclomatic complexity indicates the number of tests that basis-set testing uses, not the minimum needed for branch coverage. Two tests are enough here: one with an express order heavier than 2 kg, containing one fragile and one non-fragile item, with a total above 100; and one with a non-express order with no items, so its total is 0. Together they take every branch.

D is wrong: Each additional item runs the loop body again, and each run can take either outcome of the inner `if`. The number of paths therefore grows with the number of items and has no fixed bound. 2 × 2 × 2 = 8 ignores the loop.

**Scoring**

- `{A, B, E}`: 100%.
- `{A, B}`: 70%. You can compute the complexity and did not see how extraction moves the complexity.
- `{A, E}`: 65%.
- `{B, E}`: 50%. You understand what the number means and miscounted the complexity (most often by counting `a && b` as 1).
- `{A}` alone: 40%.
- `{B}` or `{E}`: 30%.

Patterns that include C, but not D:
- `{A, B, C, E}`: 30%. You confused the size of the basis set with the minimum number of tests for branch coverage.
- `{A, B, C}` or `{A, C, E}`: 20%.
- `{B, C, E}`: 15%.
- `{A, C}`: 10%.
- `{B, C}` or `{C, E}`: 5%.

Patterns that include D, but not C:
- `{A, B, D, E}`: 20%.
- `{A, B, D}`: 15%.
- `{A, D, E}` or `{B, D, E}`: 10%.
- `{A, D}` or `{B, D}` or `{D, E}`: 5%.

Patterns that include both C and D:
- `{A, B, C, D, E}`: 10%.
- `{A, B, C, D}` or `{A, C, D, E}` or `{B, C, D, E}`: 5%.
- `{A, C, D}` or `{B, C, D}` or `{C, D, E}`: 0%.

**Reference material:** Coverage Metrics [[pdf](https://drive.google.com/file/d/1j3rJAyKKTTIwl9lEB7PmXMJUmixj1Mi1/view) | [video](https://www.youtube.com/watch?v=yMSbO17WDAs)] &middot; Coverage in Practice [[pdf](https://drive.google.com/file/d/1fnIuyyevoL5--dGTf_tEUDk3kVfJ6SuP/view) | [video](https://www.youtube.com/watch?v=X2H2FrmylFw)]

</details>

---

### Question 40 (4 points)
<!-- id: L-week2-Coverage-003 -->
<!-- tier: medium -->

Consider the following function `ticketPrice` and its three tests T1, T2, and T3:

```kotlin
fun ticketPrice(age: Int, isStudent: Boolean, isWeekend: Boolean): Double {
    var price = 20.0
    if (age < 16) {
        price = 10.0
    } else if (isStudent) {
        price = 14.0
    }
    if (isWeekend) {
        price += 3.0
    }
    return price
}

// T1 invokes ticketPrice(12, isStudent = false, isWeekend = false)
// T2 invokes ticketPrice(20, isStudent = true,  isWeekend = true)
// T3 invokes ticketPrice(12, isStudent = true,  isWeekend = true)
```

Which of the following is/are true?

- **A.** `ticketPrice` has 6 paths
- **B.** T1, T2, and T3 together reach 50% path coverage of `ticketPrice`
- **C.** T1, T2, and T3 together reach 100% branch coverage of `ticketPrice`
- **D.** Adding a test T4 that invokes `ticketPrice(30, isStudent = false, isWeekend = false)` raises path coverage to 4/6 and branch coverage to 100%
- **E.** `ticketPrice` has 8 paths, because the path depends on three Boolean conditions

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, D**

A is correct: The first `if`/`else if` has three outcomes: child (`age < 16`), student (`age >= 16` and `isStudent`), and regular. The second `if` has two outcomes. The two decisions are independent, so there are 3 × 2 = 6 paths.

B is correct: T1 takes path (yes child, not weekend). T2 takes (yes student, yes weekend). T3 takes (yes child, yes weekend): its `isStudent = true` is never checked, because `age < 16` is true. The three tests cover 3 distinct paths out of 6, so path coverage is 50%.

D is correct: T4 takes path (yes regular, not weekend), a path that none of T1–T3 takes, so path coverage becomes 4/6. T4 is also the first test in which `isStudent` is checked and false, which was the only branch still missing, so branch coverage becomes 100%.

C is wrong: The `else if (isStudent)` condition is evaluated only when `age >= 16`, and in T1–T3 that happens only in T2, where `isStudent` is true. The false branch of `isStudent` is never taken.

E is wrong: The parameter `isStudent` is not checked when `age < 16`, so the combinations (child, student) and (child, not student) run the same code. Counting three independent Boolean conditions gives 8, but only 6 distinct paths exist.

**Scoring**

- `{A, B, D}`: 100%.
- Any two of A, B, D: 65%.
- Any one of A, B, D: 35%.
- Any pattern that includes both A and E: 0%. A and E cannot both be true.

Patterns that include C, but not E:
- `{A, B, C, D}`: 30%. C treats T3's `isStudent = true` as if that value were checked.
- `{A, B, C}` or `{A, C, D}` or `{B, C, D}`: 20%.
- `{A, C}` or `{B, C}` or `{C, D}`: 10%.

Patterns that include E, but not A or C:
- `{B, D, E}`: 20%.
- `{B, E}` or `{D, E}`: 10%.

Patterns that include both C and E, but not A:
- `{B, C, D, E}`: 10%.
- `{B, C, E}` or `{C, D, E}`: 5%.

**Reference material:** Coverage Metrics [[pdf](https://drive.google.com/file/d/1j3rJAyKKTTIwl9lEB7PmXMJUmixj1Mi1/view) | [video](https://www.youtube.com/watch?v=yMSbO17WDAs)]

</details>

---

### Question 41 (6 points)
<!-- id: L-week3-git-002 -->
<!-- tier: high -->

Ana has finished her feature branch `feature-offline-sync`, which contains 14 commits. One of these commits explains why she abandoned her first approach (a local cache) and switched to a different one. While Ana was working, her teammates merged several PRs into `main`. Yesterday, her teammate Ben pulled `feature-offline-sync` and created his own branch from it, because his feature builds on Ana's work.

Ana's PR is approved, and the team is deciding how to merge it into `main`. Which of the following statements is/are true?

- **A.** As things stand, Ana's branch cannot be merged into `main` with a fast-forward merge, because `main` has advanced since Ana created her branch.
- **B.** If Ana rebases her branch onto the current `main` and pushes it, Ben's copy still contains her old commits, while her branch now contains new commits with different identifiers, so Git treats them as unrelated work and Ben may end up with duplicates of commits he already has.
- **C.** If the team merges Ana's branch with a merge commit, her 14 commits keep their identifiers, so the commits that Ben built his branch on become part of `main` unchanged.
- **D.** If the team squash-merges Ana's branch and a bug is later traced to her feature, the history of `main` still lets the team find which of her 14 commits introduced the bug.
- **E.** Rebase and merge gives `main` a straight-line history while keeping Ana's original commits with their original identifiers.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A is correct: A fast-forward merge is possible only when `main` has not advanced beyond the point where the branch was created. Here, teammates merged PRs into `main` while Ana worked, so the team needs a merge commit or a rebase first.

B is correct: Rebasing replays Ana's commits on top of the current `main`, which creates new commits with new identifiers. Ben's copy still has the old ones, so Git sees two unrelated histories. This is why the rule is to never rebase a branch that somebody else has already pulled (as Ben has).

C is correct: A merge commit joins the two histories and records the conflict resolution in a commit of its own. Nothing is rewritten: Ana's commits keep their identifiers, and Ben's branch still sits on top of commits that are now in `main`.

D is wrong: A squash merge combines all 14 commits into one new commit on `main`. If the team later needs to find which change broke something, the smallest unit it can test in `main`'s history is the whole feature. Ana's original commits, including the one that explains why she abandoned the cache approach, are no longer part of `main`'s history. They survive only in copies of her branch, such as Ben's, and only until those are deleted.

E is wrong: Rebase and merge does give a straight-line history, but the replayed commits are new commits with new identifiers, not the ones Ana made. That is exactly what causes the problem in B.

**Scoring**

- `{A, B, C}`: 100%.
- `{B, C}`: 70%. You understand what rebasing does to a shared branch, and missed when a fast-forward is possible.
- `{A, B}` or `{A, C}`: 60%.
- `{A}`, `{B}`, or `{C}`: 30%.
- `{A, B, C, D}`: 30%. You missed what a squash merge gives up.
- `{B, C, D}`: 20%.
- `{A, B, D}` or `{A, C, D}`: 15%.
- `{A, D}`, `{B, D}`, or `{C, D}`: 5%.
- Any pattern that includes E: 0%. Believing that rebasing keeps commit identifiers leads directly to the duplicated work described in B, and E contradicts B.

**Reference material:** Branches and Pull Requests [[pdf](https://drive.google.com/file/d/19YBisRY1N3zL-WzPAgv7t6sg0Sh661It/view) | [video](https://www.youtube.com/watch?v=zRzpq-qFEs8)] &middot; [Collaborative development guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/CollaborativeDevelopment.md)

</details>

---

### Question 42 (6 points)
<!-- id: L-week3-CICD-002 -->
<!-- tier: high -->

Two teams run automated CI/CD pipelines that build, test, and package every change that is merged into `main`.

- *Team Bank* builds a banking app. The bank's compliance officer must sign off on every release; the team ships a new version to users on the first Monday of each month.
- *Team Stream* runs a video streaming service. Every change that passes the pipeline goes to production automatically, starting first with a few "canary" servers.

Which of the following statements is/are true?

- **A.** Team Bank can practice continuous delivery, even though it ships only once a month.
- **B.** Since Team Bank ships only once a month, running the automated tests on every push is wasted effort; running them in the week before each release catches the same bugs.
- **C.** Team Stream practices continuous deployment: once the pipeline passes, the change reaches production without anybody pressing a button.
- **D.** If Team Stream's canary servers show a higher error rate than the rest of production, the new build is rolled back, and only the users served by the canary servers were exposed to it.
- **E.** Because canary analysis catches a bad build before it reaches most users, Team Stream can skip unit and integration tests in its pipeline.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, C, D**

A is correct: Continuous delivery means the software is always "deployable": after the tests pass, each build is packaged and ready to go out. Deciding when it actually goes out is a separate choice, and a team can have continuous delivery and still ship on specific dates.

C is correct: Continuous deployment goes one step further than delivery: the change is deployed, all the way to production, with nobody pressing a button. "Delivery" means deployable; "deployment" means deployed.

D is correct: Canary analysis deploys the new build to a small subset of production servers, collects performance and error-rate metrics, and compares them with the rest of production. If the metrics look off, the deployment is rolled back. The canaries limit how many users see a bad build.

B is wrong: The goal of CI is to catch bugs and integration problems as early as possible, while they are cheap to fix. Tests that run only in the week before release find a month's worth of bugs at once, each far from the change that caused it, which is the expensive end of the cost curve. How often a team ships has no bearing on this.

E is wrong: In lecture we described the Netflix CI/CD pipeline, where canary analysis comes after the build has passed unit tests, integration tests, and static analysis. A canary only compares production metrics such as error rates and performance; it cannot catch a bug that does not show up in them, and any bug it does catch has already reached real users, the most expensive point at which to find it.

**Scoring**

- `{A, C, D}`: 100%.
- `{C, D}`: 65%. You know what continuous deployment and canaries do, and missed that delivery does not require shipping every build.
- `{A, C}` or `{A, D}`: 65%.
- `{A}`, `{C}`, or `{D}`: 30%.
- `{A, B, C, D}`: 20%. Tying the frequency of testing to the frequency of releases misreads what CI is for.
- `{A, B, C}`, `{A, B, D}`, or `{B, C, D}`: 10%.
- `{A, B}`, `{B, C}`, or `{B, D}`: 5%.
- Any pattern that includes E: 0%. This basically implies treating real, production users as a test suite.

**Reference material:** Continuous Integration & Continuous Delivery [[pdf](https://drive.google.com/file/d/1ctfJFpo_jvppAl4nqzpIt8OhtjGIyGVU/view) | [video](https://www.youtube.com/watch?v=35S_p3B0E_4)] &middot; The Cost of Bugs [[pdf](https://drive.google.com/file/d/10086QBuZSBhiLPEmfzwozM4KAGZQo3oi/view) | [video](https://www.youtube.com/watch?v=ykDqtsdtPHI)]

</details>

---

### Question 43 (6 points)
<!-- id: L-week2-CostOfBugs-001 -->
<!-- tier: high -->

A SwEnt team uses coding agents and now produces about three times as much code per Sprint as before. Their app depends on a backend that another team is still building. To avoid wasted effort, they plan to do most of their testing in the last week before the milestone, once the backend is ready. Which of the following statements about the cost of bugs is/are true?

- **A.** Bugs found during integration and system testing tend to cost more to fix than bugs found by unit tests, partly because it is harder to tell which part of the system is responsible for a failure.
- **B.** A bug whose fix is a one-line change costs about the same whether a unit test catches it or a user reports it in production.
- **C.** A known bug that the team decides not to fix keeps generating costs, even if nobody works on it again.
- **D.** Because the agents write tests along with the code, producing three times as much code does not increase the number of bugs that reach the last week of the Sprint.
- **E.** Testing against fakes of the backend lets the team test code that depends on the backend before the backend exists, which moves the detection of these bugs earlier.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, C, E**

A is correct: As testing moves from unit to integration to system level, the test scenarios increase in complexity and it becomes harder to find which part of the failure is the real troublemaker. Dependent systems also make failures harder to reproduce. The cost of a fix grows the later the bug is found.

C is correct: This is the cost of having a bug, separate from the cost of fixing it. While the bug lives, people write workarounds (technical debt), the people who understand the code may leave (lost knowledge), and other code starts depending on the buggy behavior (entrenchment), so that eventually the bug cannot be fixed without breaking its users.

E is correct: This is what we called "shift-left testing" in lecture. Integration and system tests cannot run while the systems they depend on are unavailable, but test doubles make it possible to test the code's behavior without the whole system, so the team finds these bugs much earlier.

B is wrong: The size of the fix is only part of the cost. Remember the CrowdStrike incident: the fix was reverting a single file, yet the damage ran into billions of dollars and recovery took days. If the bug manifests in production, the cost also includes lost users and reputation, several teams diagnosing under pressure, and the regression testing needed before the fix can ship.

D is wrong: Three times as much code means more bugs enter the code, and tests written along with that code catch only some of them: an agent-written test can run code without checking anything meaningful, and no test catches a bug in code it does not exercise. Here, the code that depends on the missing backend cannot be tested at all until the backend exists, unless the team uses fakes (option E). So more bugs reach the last week, where finding and fixing them is most expensive. As the lecture puts it, agents raise the number of bugs introduced but do not, on their own, move their detection earlier.

**Scoring**

- `{A, C, E}`: 100%.
- `{A, E}`: 70%. You know why late bugs cost more, and missed that bugs incur cost (tech debt) even when left alone.
- `{A, C}` or `{C, E}`: 60%.
- `{A}`, `{C}`, `{E}`: 30%.
- `{A, B, C, E}`: 25%. Equating the cost of a bug with the size of its fix is an oversimplification that runs contrary to the taught material.
- `{A, B, E}`: 20%.
- `{A, B, C}` or `{B, C, E}`: 15%.
- `{A, B}`, `{B, C}`, `{B, E}`: 5%.
- Any pattern that includes D: 0%. It is the assumption that makes this team's plan look safe but incur technical debt rapidly.

**Reference material:** The Cost of Bugs [[pdf](https://drive.google.com/file/d/10086QBuZSBhiLPEmfzwozM4KAGZQo3oi/view) | [video](https://www.youtube.com/watch?v=ykDqtsdtPHI)] &middot; Test Doubles: Mocks, Stubs, and Fakes [[pdf](https://drive.google.com/file/d/1XKh1dFWOIUSnI2Bi7-n0t9a_A7dIMoAB/view) | [video](https://www.youtube.com/watch?v=QqUIqVwLhzE)]

</details>

---

### Question 44 (6 points)
<!-- id: L-week2-UITesting-001 -->
<!-- tier: high -->

A team's sign-in screen follows the structure from the UI testing lecture. `SignInScreen` is a thin wrapper that obtains the ViewModel and collects its state. `SignInContent(state, onSubmit)` draws the screen: a "You're offline" banner, tagged `offline_banner`, and a "Sign in" button, tagged `submit_button`. The banner is shown when `state.isOffline` is true, and the button is enabled only when `state.canSubmit` is true.

A teammate submits the following UI test:

```kotlin
class SignInScreenTest {
    @get:Rule val rule = createComposeRule()

    @Test
    fun offlineBannerAppears() {
        val vm = SignInViewModel(AuthRepositoryFirebase(Firebase.auth))
        rule.setContent { SignInScreen(vm) }

        vm.onConnectivityChanged(isConnected = false)

        rule.onNodeWithText("You're offline").assertIsDisplayed()
        assertEquals(42.dp, rule.onNodeWithText("You're offline").getBoundsInRoot().top)
        rule.onNodeWithText("Sign in").assertIsNotEnabled()
    }
}
```

Which of the following review comments is/are correct?

- **A.** The test finds the banner and the button by their displayed text, so the test breaks as soon as someone rewords a label or the app is translated. The test should find them by their tags.
- **B.** The assertion on the banner's position fails if someone changes the padding, even though nothing is broken. The test should check state, such as whether the banner is displayed, rather than appearance.
- **C.** The test should render `SignInContent` with a fixed state, `SignInUiState(isOffline = true, canSubmit = false)`, instead of building a real ViewModel with a real repository, so that the test only checks that the state reaches the screen.
- **D.** This UI test is also the right place to check that `onConnectivityChanged(false)` sets `isOffline` to true, because only a test with a real screen shows whether the offline logic works.
- **E.** Since UI tests are slow, the team should replace this test with a ViewModel unit test that checks `isOffline`: if a teammate later renames a field in the UI state and the banner stops appearing, that ViewModel test will fail.

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A is correct: A test finds elements by their semantics. Without tags, it has to match visible text, which makes it fragile: rewording a label breaks tests for no good reason, and supporting another language requires a whole new set of tests. With `onNodeWithTag("offline_banner")` and `onNodeWithTag("submit_button")`, both problems disappear.

B is correct: A UI test should assert on state: is the element displayed, is it enabled, does it contain this text. It should not assert that something sits 42 pixels (or dp) from the top. A padding change causes such a test to fail without anything being truly broken.

C is correct: The job of a UI test is to check the wiring, i.e., that the ViewModel's state reaches the screen. Testing `SignInContent` with a fixed state does exactly that, with no ViewModel logic and no Firebase underneath. The submitted test instead runs the real repository, which makes it slower, dependent on the network, and likely to be flaky.

D is wrong: Whether losing connectivity sets `isOffline` is logic, and logic belongs in the ViewModel, where a unit test checks it in milliseconds without a screen. UI tests check the wiring; ViewModel tests check the logic.

E is wrong: A ViewModel test would still pass after such a rename, because the state is still correct. What breaks is the connection between the state and the screen, which only a UI test can catch. Checking `isOffline` in a ViewModel test is right, but it complements this UI test rather than replacing it.

**Scoring**

- `{A, B, C}`: 100%.
- `{A, B}`: 70%. You know how to write a robust assertion, and missed what a UI test is for.
- `{A, C}` or `{B, C}`: 60%.
- `{A}`, `{B}`, or `{C}`: 30%.
- `{A, B, C, D}`: 25%. Testing logic through the screen is the most common mistake the lecture warns about.
- `{A, B, D}` or `{A, C, D}` or `{B, C, D}`: 15%.
- `{A, D}`, `{B, D}`, `{C, D}`: 5%.
- Any pattern that includes E: 0%. This would remove the only test that catches broken wiring between state and screen.

**Reference material:** UI Testing for Your App [[pdf](https://drive.google.com/file/d/1E2JCYZyUf14-5GGsDsj8EZS7XdLr3EUZ/view) | [video](https://www.youtube.com/watch?v=SIPYX5ZUEGs)] &middot; MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; Test Doubles: Mocks, Stubs, and Fakes [[pdf](https://drive.google.com/file/d/1XKh1dFWOIUSnI2Bi7-n0t9a_A7dIMoAB/view) | [video](https://www.youtube.com/watch?v=QqUIqVwLhzE)]

</details>

