# Exam Practice Set 1 &mdash; Answers and Explanations

This is a set of questions meant to get you habituated to the exam that will be held at the end of week 3. Each question will present 5 choices, of which 0, 1, 2, 3, 4, or 5 are correct. They are the same kind of questions you can expect to see on the exam (except that the exam will cover all the material of the first three weeks).

This exercise set is not graded; it is provided purely for your benefit. The actual exam will count toward 20% of your SwEnt course grade.

This exercise set contains 15 questions meant to take on the order of 30 minutes to answer. Don't worry about the amount of time it takes you to answer, the point of the exam is to test your knowledge, not the speed with which you can answer. The exam will of course have many more questions.

We strongly recommend that you answer this exercise set in one sitting, closed-book, without any external help. This simulates exam conditions, and will therefore give you a sense of whether what you have done during this first week has prepared you well for the exam.

## How the Scoring Works

The exam is made of multiple-response questions with pattern-based partial credit (MRQP), described in the [exam page](https://github.com/swent-epfl/public/blob/main/exam/README.md). Each question offers five candidates, of which 0 to 5 are correct, and your score depends on the whole pattern you mark, not on each checkbox separately. Two patterns that differ by a single box can score very differently, because what is graded is what the pattern reveals about your understanding. Leaving out a correct choice usually means your picture is incomplete, and costs part of the point. Checking a choice that only someone who has the concept backwards would check costs the whole point, no matter how much else you got right.

This is why hedging is the worst strategy available to you. Marking everything plausible does not look cautious to us, it looks like you cannot tell the options apart, and that is precisely what the question is measuring. Mark exactly what you believe.

This practice set is not graded. The scoring under each question is what that pattern would be worth on the real exam, and the short reason given with it is what we read into it. Each question also lists the material it is built on, so you can go back to the source for anything you got wrong.

---

## Question 1

It is Wednesday. Your project milestone is due Friday morning, and you realize that your team will not finish everything. What should you do?

- **A.** Tell your coach now, before the deadline, rather than explaining afterwards
- **B.** Decide with the team which subset to finish properly, and cut the rest
- **C.** Ship a smaller amount of working, tested, reviewed code rather than more code of unknown quality
- **D.** Merge the unfinished work anyway so the effort is visible to the graders
- **E.** Have everyone work independently through the night so more gets done in parallel

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A, B, and C are the three moves of recovering from a deadline you are going to miss: face the facts early, reduce scope, and turn in less work of known quality. Telling your coach on Wednesday gives them two days to help you re-plan; telling them on Friday only explains a failure that already happened.

B: Sort the remaining work into must-have, nice-to-have, and optional, finish the must-haves, and drop the rest. Hoping to make up the time is the mirage.

C: The same idea stated in terms of the deliverable. 80% of the functionality, working and tested, beats 100% of it in a flaky state.

D is wrong. Half-finished work on the main branch breaks the build for six teammates and costs them hours. Effort is not what gets graded; a working app is.

E is wrong on both counts. An all-nighter produces the buggiest code of the week, and seven people working independently on a shared codebase at the last minute produces merge conflicts, not throughput. This is the moment for more communication, not less.

**Scoring**

- `{A, B, C}`: 100%. You treat the deadline as a planning problem with three parts: tell the person who can help, decide what to drop, protect the quality of what stays.
- `{A, B}` or `{A, C}`: 80%. B and C are two faces of the same move, so having one of them plus the coach is nearly the whole answer.
- `{B, C}` without A: 70%. You know how to rescue the work but you are doing it silently. This is the most common regret past students report, and it is why the coach hears about the problem on Friday instead of Wednesday.
- Any single one of A, B, C: 40%. One instinct, no plan around it.
- Any pattern that includes E: 20%, and 0 if it also includes D. If you cut scope on Wednesday you do not need the all-nighter, so marking E alongside B and C means you did not notice that the two answers are alternatives.
- Any pattern that includes D: 0%. Merging unfinished work so that graders see the effort says you think effort is the deliverable, and it costs six teammates a broken build at the worst possible moment.

**Reference material:** Introduction [[pdf](https://drive.google.com/file/d/1GXf3MCy-fcfG1s0l9YmQuMwA4PZEPHIt/view) | [video](https://www.youtube.com/watch?v=-TU946Pckc8)]

</details>

---

## Question 2

You're building a messaging app and want to store users' draft messages so they survive an app restart, without needing to expose them to other apps. Which persistence mechanism fits best?

- **A.** `SharedPreferences`
- **B.** Content provider
- **C.** Cache directory
- **D.** SQLite / Jetpack Room
- **E.** Cloud/backend service

<details>
<summary><b>Show the answer</b></summary>

**Full credit: D**

Drafts are structured records: a conversation ID, the body text, a timestamp, possibly attachments. There can be many of them, they change often, and you need to look up the one belonging to a given conversation. That is a database. Room sits on top of SQLite, stores its file in the app's private directory, so no other app can read it, and survives restarts.

A is the tempting wrong answer. `SharedPreferences` is a key-value store for small, simple settings: the selected theme, whether onboarding was shown. Every write rewrites the whole file, and there is no way to query "the draft for conversation 47" other than by convention in the key names.

B is backwards. The entire purpose of a content provider is to expose your data to other apps, which the question explicitly rules out.

C is wrong because the cache directory is exactly what Android deletes when the device runs low on storage. A draft that silently disappears is a bug report.

E is wrong for a local feature: it adds a network round trip, fails when the user is offline, and sends private unsent text to a server for no reason. Drafts are the canonical example of data that should stay on the device until the user chooses to send.

**Scoring**

- `{D}`: 100%.
- `{A}`: 40%. You read the requirement correctly (local, private, survives restart) and then picked a key-value store for records that have fields, multiply, and need lookup by conversation. Right constraints, wrong mechanism.
- `{A, D}`: 50%. The same confusion, plus a hedge. You can see the two local options and cannot say which one the data calls for.
- `{C}` or `{C, D}`: 25%. The cache directory is app-private, so the instinct is not random, but a draft the system may delete to reclaim space fails the one requirement the question states.
- Any pattern that includes B: 0%. The question says the drafts must not be exposed to other apps, and a content provider exists to expose data to other apps. This reads as either not knowing what a content provider is or not reading the requirement.
- Any pattern that includes E: 0%. Sending unsent private text to a backend for a purely local feature breaks offline use, which every SwEnt app is required to support.

**Reference material:** The Split-App Model [[pdf](https://drive.google.com/file/d/1oL5cQG5iQJosz5Qc-oOqnMJQ-1v0UQt0/view) | [video](https://www.youtube.com/watch?v=Cvfb7-fjczo)] &middot; Components of A Mobile App [[pdf](https://drive.google.com/file/d/1QqxpwkUY2DnOKCk4on9RG0dT70SgMkd6/view) | [video](https://www.youtube.com/watch?v=X_-CVsngxzQ)] &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) (in-memory repository) &middot; [B2 &sect;1 Setup Backend](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/1-SetupBackend.md)

</details>

---

## Question 3

Ana opens PolyFood's camera screen to scan a QR code on a restaurant table. Mid-scan, a notification banner drops down and she taps it, switching to the messaging app. She spends a minute replying to the message, then returns to PolyFood. Which of the following are true?

- **A.** PolyFood should release the camera on the way out, and reacquire it when Ana returns to PolyFood
- **B.** A scan result already stored in the `ViewModel` is still there when she returns
- **C.** The camera preview should stop being drawn before the app becomes fully invisible
- **D.** The `Activity` object is destroyed and recreated during this sequence
- **E.** The sequence that PolyFood follows on the way back to the foreground begins with `onCreate()`

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

A: The camera is an exclusive resource. If PolyFood keeps holding it while in the background, the messaging app cannot use its camera to take a photo, and on some devices PolyFood itself will fail to reacquire it later. Release it on the way out, reacquire it on the way back.

B: A one-minute trip to another app does not destroy the `Activity`, and even if it were destroyed and recreated the `ViewModel` would survive. The scan result is still in memory.

C: The notification banner already covers part of the screen, so PolyFood is partially obscured before it is fully hidden. Stopping the preview belongs to that earlier step (`onPause()`), not to the later one.

D is wrong. The system can kill the whole process under memory pressure, but that is not what happens in the normal sequence described here. PolyFood is stopped, not destroyed.

E is wrong. `onCreate()` runs only when the `Activity` is created. Coming back from stopped, the sequence is `onRestart()`, `onStart()`, `onResume()`.

**Scoring**

- `{A, B, C}`: 100%. You have the two separate ideas the question combines: what the system does to your `Activity`, and what you owe the rest of the device on the way out.
- `{A, C}` without B: 70%. Your resource handling is right and you are unsure what survives. This error is in the safe direction: you would rebuild state that was still there.
- `{B, C}` without A: 60%. You know the lifecycle but forgot that the camera is exclusive. In practice this is the bug where the messaging app cannot open its camera until PolyFood is killed.
- Any single one of A, B, C: 40%.
- Any pattern that includes D: 25%. Believing a one-minute app switch destroys the `Activity` leaves you writing defensive code for a case that is not happening.
- Any pattern that includes both B and D: 0%. The two cannot both be true, and marking both means you were covering options rather than deciding what happens.
- Any pattern that includes E: 0%. `onCreate()` on the way back from the background is the misunderstanding that produces duplicated listeners, re-initialized state, and a camera acquired twice.

**Reference material:** Lifecycle of an Android Activity [[pdf](https://drive.google.com/file/d/1IIg8T3Z1h0YS2hprMiL1WCERPN3slTMY/view) | [video](https://www.youtube.com/watch?v=UplTsKuonbM)] &middot; MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; Components of A Mobile App [[pdf](https://drive.google.com/file/d/1QqxpwkUY2DnOKCk4on9RG0dT70SgMkd6/view) | [video](https://www.youtube.com/watch?v=X_-CVsngxzQ)]

</details>

---

## Question 4

In the bootcamp Todo app, on Overview the user scrolls halfway down the list, taps the Map tab, then taps the Overview tab again. Which of the following are true?

- **A.** The list should be back at the top
- **B.** If instead they opened AddTodo and pressed system Back, the scroll position would be preserved
- **C.** Tapping Overview while already on Overview should leave the scroll position alone
- **D.** Using `popUpTo(startDestination) { saveState = true }` together with `launchSingleTop = true` is sufficient to restore the Overview scroll position
- **E.** Pressing system Back on Overview should return to the Map screen

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B, C**

The three correct choices are the three navigation requirements of B1, and the point of the question is that they are three different cases, not one.

A: Switching tabs is forward navigation, and forward navigation does not restore state. Coming back to Overview through the tab gives you a screen that starts fresh, with the list at the top.

B: Back navigation does restore state. AddTodo is pushed on top of Overview, Overview's back stack entry stays on the stack with its saved state, and popping AddTodo brings the user back to the list scrolled where they left it.

C: Re-selecting the tab you are already on is neither of the above, and it should do nothing at all. `launchSingleTop = true` is what stops a second copy of Overview from going on top of the first with a fresh, scrolled-to-top list.

D is wrong twice over. `saveState = true` saves the state of the destinations being popped, but nothing puts it back unless the navigate call also passes `restoreState = true`. And restoring the scroll position across a tab switch is the opposite of what requirement A asks for.

E is wrong. From Overview, system Back closes the app. It is from the Map tab that Back returns you to Overview.

**Scoring**

- `{A, B, C}`: 100%. You can tell the three cases apart: forward navigation starts fresh, back navigation restores, re-selecting the current tab changes nothing.
- `{A, B}` or `{A, C}`: 75%.
- `{B, C}` without A: 65%. You know what gets preserved and have collapsed the tab switch into the same case, which is the reading that makes A and C look contradictory. They are not: one is forward navigation, the other is not navigation at all.
- Any single one of A, B, C: 40%.
- Any pattern that includes E: 25%. You have the back stack wrong, but the error is about navigation structure rather than about state.
- Any pattern that includes D: 0%. `saveState` without `restoreState` is the half-configuration that looks right, compiles, and silently does nothing. A student who marks D would ship the bug and then have no idea where to look, which is why B1 calls this pair out explicitly.

**Reference material:** [B1 &sect;4 Navigation](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/4-Navigation.md) (the `NavigationB1Test` requirements)

</details>

---

## Question 5

A repository method is marked `suspend`. What is the main reason for doing this?

- **A.** It allows the repository method to perform potentially long-running I/O without blocking the calling thread
- **B.** It allows asynchronous work without blocking the main thread
- **C.** It forces the function to run on the UI thread
- **D.** It makes the function usable only in unit tests
- **E.** It automatically persists the returned data

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B**

A and B state the same property from two angles, and both are true. A `suspend` function can pause at a suspension point while a Firestore read or a disk write is in flight; the thread it was running on is released to do other work and the function resumes when the result arrives. The caller is typically the main thread, which is why B matters in practice: a 300 ms blocking read on the main thread is 18 dropped frames and a visible stutter.

C is wrong, and is close to the opposite of the truth. `suspend` says nothing about which thread the work runs on; that is what dispatchers and scopes are for, and in the bootcamp the call goes through `viewModelScope`, which runs it off the main thread.

D is wrong. There is nothing test-specific about `suspend`. It is callable from any coroutine or from another `suspend` function, in production code just as much as in tests.

E is wrong. Persistence comes from what the function body does (writes to Room, writes to Firestore), not from the keyword. A `suspend` function that computes a sum persists nothing.

**Scoring**

- `{A, B}`: 100%.
- `{A}` or `{B}` alone: 75%. The two options state the same property from the two ends, so marking one and not the other is a reading slip rather than a gap in understanding.
- Any pattern that includes E: 30%. Thinking the keyword persists anything confuses a language mechanism with a repository responsibility, though you may still use `suspend` correctly.
- Any pattern that includes D: 30%.
- Any pattern that includes C: 0%. `suspend` exists so that the calling thread, usually the main thread, is free while I/O is in flight. Believing it forces the work onto the UI thread is the concept exactly backwards, and it is the belief behind frozen screens.

**Reference material:** [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) (suspending functions, and the `viewModelScope` hint) &middot; [B2 &sect;2 Create a ToDo](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B2/2-CreateAToDo.md) &middot; [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md)

</details>

---

## Question 6

You tell an agent "build the ordering feature." It returns 800 lines across 30 files. Which of the following are true?

- **A.** You need to read the 800 lines carefully
- **B.** You failed to supply the agent with a decomposition of the feature
- **C.** You failed to supply the agent the necessary acceptance criteria
- **D.** The sprawl is due to using an inappropriate agent
- **E.** A larger context window would have prevented such a big PR

<details>
<summary><b>Show the answer</b></summary>

**Full credit: B, C**

B and C are two of the four things the agentic loop is blind to and that only you can supply. Decomposition means turning "build the ordering feature" into work that fits in one reviewable change. An agent handed a vague goal will happily produce eight hundred lines, and that is your failure, not its failure.

C: Without acceptance criteria the agent decides for itself what "done" means, and it decides optimistically. That is how you end up with 30 files: it built the cart, the checkout, the order history, and a notification service, because nothing told it where the feature stops.

A looks right, because you do own every line you merge and nothing goes in unread. But an 800-line change across 30 files is not reviewable, and reading it carefully is not the fix. The fix is to discard it and re-issue the work as pieces you can actually review. If your plan is to read 800 agent-written lines carefully, you have already lost the time the agent saved you.

D is wrong. No agent turns a one-sentence goal into a small, reviewable change on its own. The prompt caused the sprawl, not the choice of tool.

E is wrong, and backwards: a bigger context window lets an agent touch more of your codebase, not less. Scope comes from the task you hand it.

**Scoring**

- `{B, C}`: 100%. You locate the failure in the goal you gave, which is where the lecture puts it.
- `{A, B, C}`: 80%. Your instinct that you own every line you merge is right, and it is what separates agentic coding from vibe coding. What you missed is that reviewability is created upstream: nobody reviews 800 lines across 30 files carefully, so the move is to throw this diff away and re-issue the work in pieces.
- `{B}` or `{C}` alone: 55%. Half the diagnosis.
- `{A}` alone: 25%. You accept the 800-line diff as a fact of life and plan to read all of it. That is the chatbot-era reflex, where your job is to process whatever the model hands back.
- Any pattern that includes D or E: 0%. Blaming the agent or the context window puts the failure on the machine. Agentic coding requires you to know enough to judge a diff and to state what done means; neither a different agent nor a bigger window supplies either.

**Reference material:** Agentic Software Development (part 1) [[pdf](https://drive.google.com/file/d/1AYv7qwH1uKl42Lha-l9lODfYnwy9Evs5/view) | [video](https://youtu.be/6ZEIdlLYiZY)] (what the agent does not know: context, decomposition, acceptance criteria, permissions)

</details>

---

## Question 7

GitHub reports 78% more merged PRs when moving from editor-based work to agents that open their own PRs; adding a second agent delivers a further 41% increase on top of that. Which of the following are true?

- **A.** End to end this is about +151%
- **B.** The smaller second gain is consistent with a serial bottleneck
- **C.** Developers were randomly assigned to these phases
- **D.** End to end this is +119%
- **E.** These figures measure delivered value

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, B**

A: The gains compound rather than add, because the second increase is measured on top of the first. 1.78 &times; 1.41 = 2.51, so about a 2.5&times; improvement end to end, which is +151%.

B: You still review, approve, and own the result, and you do that serially. By Amdahl's law the serial fraction sets the ceiling on the speedup. An agent that reviews PRs aims at that bottleneck but cannot remove it, so the second gain is smaller than the first. This is also why you cannot add dozens of agents and get 100&times;.

C is wrong. These are observed numbers from a usage dashboard, not a randomized trial. Teams that move to an agent-native setup differ from those that do not in ways nobody controlled for, so the numbers show an association, not a measured causal effect.

D is wrong: 78 + 41 = 119 adds two percentages that should be multiplied. This is the arithmetic trap in the question.

E is wrong. Merged PRs are a throughput measure. A merged PR can implement a feature nobody wanted, or add 800 lines that a teammate will rewrite next sprint.

**Scoring**

- `{A, B}`: 100%. You compound the two gains correctly and you can say why the second one is smaller.
- `{B}` alone: 65%. You have the part that transfers to your project: the human review step is serial, so the serial fraction sets the ceiling no matter how many agents you add. You just did not do the multiplication.
- `{A}` alone: 60%. Arithmetic right, and no account of why the second agent buys less than the first.
- Any pattern that includes C: 25%. Treating a vendor usage dashboard as a randomized experiment means you would repeat the claim as a causal one, which in this course is a judgment failure rather than a fact you forgot.
- Any pattern that includes E: 20%. A team that merges twice as many PRs of agent-written code nobody scrutinized has doubled its output of unknown quality, not its delivered value.
- Any pattern that includes D: 0%, including `{A, D}`, which marks two numbers that cannot both be right. Adding 78 and 41 is the trap, and marking both means you were guessing.

**Reference material:** Agentic Software Development (part 2) [[pdf](https://drive.google.com/file/d/1tBQMQ_FUT6NGSScMMbAfDrkeFw9mToPr/view) | [video](https://youtu.be/bZJ0YpXxxFc)] (multi-agent productivity, Amdahl's law, "owning the result cannot be delegated")

</details>

---

## Question 8

In the following `ChatVM` / `ChatScreen` code example (taken from lecture), which class plays the role of the Model?

```kotlin
class DumbLLM {
    private val _msgs = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _msgs
    suspend fun send(text: String) {
        _msgs.value += Message(true, text)
        delay(500)
        _msgs.value += Message(false, "You said \"$text\"")
    }
}

class ChatVM(val llm: DumbLLM) : ViewModel() { /* ... */ }

@Composable
fun ChatScreen(vm: ChatVM) { /* ... */ }
```

- **A.** `Message`
- **B.** `DumbLLM`
- **C.** `ChatVM`
- **D.** `ChatScreen`
- **E.** `StateFlow`

<details>
<summary><b>Show the answer</b></summary>

**Full credit: B**

`DumbLLM` owns the data (the list of messages), owns the operation that changes it (`send`), and exposes the result as an observable stream. Nothing in it knows that a UI exists. That is the Model layer: in your bootcamp app the same slot is filled by `ToDosRepository`.

A is wrong: `Message` is a data class that the model stores and passes around, not the model. Mistaking the data class for the Model is the common error here.

C is wrong by name and by role: `ChatVM` is the ViewModel. It holds UI state and calls into the model; it does not own the data.

D is wrong: `ChatScreen` is the View, the composable that renders state and forwards user events.

E is wrong: `StateFlow` is the Kotlin coroutines type the model publishes through. It is a mechanism, not an architectural layer.

**Scoring**

- `{B}`: 100%.
- `{A, B}`: 50%. You found the model layer and then hedged with the data class it stores.
- `{A}` alone: 25%. Mistaking the data class for the Model at least keeps data on the data side, but MVVM layers are about responsibility, not about which class holds the nouns.
- `{E}`: 10%.
- Any pattern that includes C or D: 0%. Calling `ChatVM` or `ChatScreen` the Model collapses the separation MVVM exists for. The View is supposed to be computable from the ViewModel, which is only meaningful if the three are distinct in your head.

**Reference material:** MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md)

</details>

---

## Question 9

You're developing an app called FitTrack. Which of the following are good user stories per the INVEST criteria?

- **A.** As a runner, I want the app to work well, so that I can track my fitness
- **B.** As a developer, I want to implement OAuth2 with Google for the login screen
- **C.** As a runner, I want to log my run distance and duration, so that I can track my progress over time
- **D.** As a beginner runner, I want the app to suggest a weekly training plan, along with a calendar view, streak counter, social sharing, and personalized coaching
- **E.** As a user with a smartwatch, I want to see my heart rate synced automatically during a run, so that I can monitor my effort without checking my phone

<details>
<summary><b>Show the answer</b></summary>

**Full credit: C, E**

C: One persona, one behavior, a stated benefit, and acceptance criteria you can actually write ("after a run, distance in km and duration in mm:ss appear in the history list"). Small enough to fit in a sprint, independent of the rest of the app.

E: Independent and testable, and the persona matters here. A smartwatch owner has different acceptance criteria than a phone-only runner, so the distinction belongs in the story rather than being hidden behind "as a user". The criterion is clear: heart rate appears without the user touching the phone.

A fails Testable. "Work well" has no acceptance criterion; no one can say whether it is done. It also fails Estimable, since you cannot size it.

B fails Valuable and is written from the wrong point of view. It names an implementation (OAuth2, the login screen) rather than a user-visible outcome, and its persona is a developer. Rewritten properly it reads: as a Google account owner, I want to sign in with my Gmail address, so that I don't have to create another password. How you implement that is a design decision, not part of the story.

D fails Small, and with it Estimable and Negotiable. A training plan, a calendar view, a streak counter, social sharing, and coaching are five features. That is an epic, and it needs to be split into stories that can be prioritized separately.

**Scoring**

- `{C, E}`: 100%.
- `{C}` alone: 60%. You recognize the story that fits the template. Rejecting E suggests you read the smartwatch persona as decoration, when it changes the acceptance criteria.
- `{E}` alone: 50%.
- Any pattern that includes A: 30%. Accepting "I want the app to work well" means accepting a story with no acceptance criteria, which is how a sprint ends in an argument over whether the work is done.
- Any pattern that includes D: 10%. A story with a calendar view, a streak counter, social sharing, and coaching in it cannot be estimated, cannot be prioritized, and will not fit a sprint. Accepting it as good is a planning failure, not a vocabulary failure.
- Any pattern that includes B: 0%. It names an implementation, from the developer's point of view, with no user value stated. If this looks like a user story to you, your backlog will be a task list with As-a clauses glued on.

**Reference material:** User Stories and INVEST [[pdf](https://drive.google.com/file/d/1ng7yTpFYbkvTOFzPZGCJwRLUC35BSbfs/view) | [video](https://youtu.be/tbf3sNT5JCw)] &middot; Epics [[pdf](https://drive.google.com/file/d/1PinFSZPqDla69jnlXJS6P7ZwyZsz4Ln2/view) | [video](https://youtu.be/l_spnWitbYM)] &middot; [B1 &sect;7 User Stories](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/7-UserStories.md) &middot; [User story guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/UserStory.md)

</details>

---

## Question 10

In the bootcamp Todo app, why should the Overview screen obtain todo data through a repository instead of reading data directly from the UI code?

- **A.** To make the UI responsible for database access
- **B.** To separate data access from presentation and make the code easier to test
- **C.** To avoid using Kotlin data classes
- **D.** To ensure todos are permanently stored
- **E.** To eliminate the need for a `ViewModel`

<details>
<summary><b>Show the answer</b></summary>

**Full credit: B**

The repository puts data access behind an interface, which buys you two things. You can test the Overview logic against a fake in-memory repository instead of standing up a live Firestore, and when you change backends you edit one class rather than every screen that touched the database. That is exactly the move you make between B1 and B2: `ToDosRepositoryLocal` is replaced by the Firestore implementation, and the Overview screen does not change.

A is the arrangement the repository exists to prevent, not a reason for it.

C is unrelated: your todos are Kotlin data classes either way.

D confuses the pattern with the storage. `ToDosRepositoryLocal` is a repository and it keeps everything in memory, so the todos are gone when the app closes. Permanence comes from what sits behind the interface.

E is wrong: you still need a `ViewModel` to hold the screen's state, survive configuration changes, and own the `viewModelScope` that the repository is called from.

**Scoring**

- `{B}`: 100%.
- `{B, D}`: 50%. You have the reason right and also believe the pattern is what makes data durable. B1's local repository is the counterexample.
- `{D}` alone: 10%.
- Any pattern that includes E: 0%. Dropping the `ViewModel` leaves nobody to hold screen state across a configuration change or to own the coroutine scope the repository is called from.
- Any pattern that includes A: 0%. A states the arrangement the repository exists to prevent, so marking it means the question read as being about something else entirely.

**Reference material:** MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) (local repository) &middot; [Modularity and abstraction guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/ModularityAndAbstraction.md)

</details>

---

## Question 11

A student places repository calls directly inside a composable body. What problems could this cause?

- **A.** Compose caches the results of function calls inside a composable body, so the UI risks showing outdated data instead of the repository's latest state
- **B.** The UI becomes tightly coupled to the data source
- **C.** The repository call may be triggered repeatedly when Compose recomposes the UI
- **D.** The repository automatically becomes persistent
- **E.** The composable becomes a better replacement for the `ViewModel`

<details>
<summary><b>Show the answer</b></summary>

**Full credit: B, C**

C is the immediate damage: a composable body re-runs on every recomposition, so the call fires again every time any state it reads changes. A Firestore read in that position can run dozens of times while the user types in a text field, which costs you latency, quota, and money. This is why the bootcamp has you launch the call from a `ViewModel` method through `viewModelScope` rather than from the composable.

B is the structural damage: the composable now needs a live repository to run at all, so you cannot preview it, cannot test it in isolation, and cannot reuse it with a different data source.

A inverts what actually happens. Compose does not cache the result of a call in a composable body; that is what `remember` is for, and its absence gives you repeated calls, not stale ones.

D is wrong: nothing becomes persistent by virtue of where it is called from.

E has it backwards. State belongs in the `ViewModel`, and the calls belong in a scope it controls, precisely so that the composable stays computable from the state it is given.

**Scoring**

- `{B, C}`: 100%. You have both the cost you will measure and the cost you will feel later.
- `{C}` alone: 70%. The repeated calls are the damage that shows up first, in latency and in Firestore reads, and seeing it means you understand what recomposition does.
- `{B}` alone: 50%. Coupling is the architectural objection, and you can hold it without knowing how a composable body behaves.
- Any pattern that includes A: 25%. A says Compose caches the call and C says it re-runs. Marking both means you have not settled what recomposition does, and that question decides how you write every screen this semester.
- Any pattern that includes D: 20%.
- Any pattern that includes E: 0%. Promoting the composable to a replacement for the `ViewModel` is the architecture the whole module argues against.

**Reference material:** MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; Modern Android Development [[pdf](https://drive.google.com/file/d/11cKopMlVmtCwpot6UFlDnvqsvDBvJggU/view) | [video](https://www.youtube.com/watch?v=sqrdwCVkvRs)] &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) (calling a `suspend` function from `viewModelScope`) &middot; [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md)

</details>

---

## Question 12

In the bootcamp Todo app, is `StateFlow` appropriate for exposing the Overview screen's state? Why?

- **A.** Yes, because it lets the UI observe state changes in a lifecycle-aware way
- **B.** Yes, because it automatically creates Firestore documents
- **C.** Yes, because it automatically persists the screen's state across app restarts
- **D.** No, because exposing state through a `StateFlow` prevents the `ViewModel` from updating it
- **E.** No, because `StateFlow` is intended only for one-time events

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A**

`StateFlow` always holds a current value, so a composable that starts collecting gets the latest state immediately rather than waiting for the next emission. Collected with `collectAsStateWithLifecycle`, it delivers updates while the screen is started and stops while it is stopped, so a backgrounded Overview screen consumes nothing. It also survives recomposition and rotation, which is why B1 has you keep the Overview state in a `StateFlow` inside the `ViewModel`.

B is wrong: documents are created by repository code calling Firestore. `StateFlow` is a Kotlin type and knows nothing about your backend.

C is wrong: the value lives in memory. Kill the app and the flow starts again from whatever initial value the `ViewModel` gives it.

D describes the pattern backwards. The `ViewModel` keeps the `MutableStateFlow` private and exposes the read-only `StateFlow`. It updates the value; the UI cannot. That asymmetry is the reason for the pattern, not an obstacle to it.

E is the opposite of the truth. One-time events (show a snackbar, navigate once) are what `StateFlow` handles badly, because a new collector immediately receives the last value and the snackbar appears again after a rotation. Those belong in a `Channel` or a `SharedFlow`.

**Scoring**

- `{A}`: 100%.
- `{A, C}`: 40%. Right that the UI observes changes, wrong in thinking in-memory state survives a restart. Clear this up before B2: it is the difference between state and storage.
- `{A, B}`: 40%. The same error with Firestore in place of persistence: a Kotlin flow type has no idea your backend exists.
- Any pattern that includes D: 0%. D says the pattern prevents the `ViewModel` from updating the state, when keeping `MutableStateFlow` private and exposing the read-only `StateFlow` is the entire point: the `ViewModel` writes, the UI only reads.
- Any pattern that includes E: 0%. Both D and E answer No. Answering No here means you would build the Overview screen some other way, and the other ways are worse.

**Reference material:** MVVM [[pdf](https://drive.google.com/file/d/1MAgbcML071eCwBYZxQ3hZSSG7jGmt6g9/view) | [video](https://www.youtube.com/watch?v=3OsVxvfrNrw)] &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) (`StateFlow` in `OverviewViewModel`) &middot; [MVVM guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md)

</details>

---

## Question 13

In your bootcamp Todo app, is it more suitable to use `Column` or `LazyColumn` for displaying a potentially large list of todos? Why?

- **A.** `LazyColumn`, because it automatically sorts the todos by creation date
- **B.** `LazyColumn`, because it renders items efficiently as they become visible on screen
- **C.** `LazyColumn`, because it automatically fetches new todos from the repository only when the user scrolls to the bottom of the list (pagination)
- **D.** `Column`, because it permanently stores all todos on the device
- **E.** `Column`, because `LazyColumn` can only display a fixed number of items

<details>
<summary><b>Show the answer</b></summary>

**Full credit: B**

`LazyColumn` composes and lays out only the items in the viewport plus a small buffer, and disposes of them as they scroll away. With 500 todos, the cost is roughly one screenful of work. A `Column` with `verticalScroll` composes all 500 up front, which shows up as a frozen screen when the list opens.

A is wrong: `LazyColumn` preserves whatever order you give it. Sorting is your job, in the `ViewModel` or in the query.

C is the plausible-sounding distractor. `LazyColumn` does not fetch anything; it does not know your repository exists. Pagination is something you implement, for example by watching the list state and requesting the next page when the last visible index approaches the end.

D is wrong: neither composable stores anything. They draw what you hand them.

E is wrong: `LazyColumn` has no item limit. The one with a practical limit is `Column`, which starts to hurt in the hundreds.

**Scoring**

- `{B}`: 100%.
- `{B, C}`: 60%. Right about why `LazyColumn` wins, wrong in thinking pagination comes for free. The consequence is that you never write the code that fetches the next page, then wonder why the list stops at 50 todos.
- `{A, B}`: 50%.
- Any pattern that includes D or E: 0%. Both answer `Column`, and both reasons are invented: `Column` stores nothing, and `LazyColumn` has no item limit. Choosing `Column` for a large list is the decision that makes the screen freeze when it opens.

**Reference material:** Modern Android Development [[pdf](https://drive.google.com/file/d/11cKopMlVmtCwpot6UFlDnvqsvDBvJggU/view) | [video](https://www.youtube.com/watch?v=sqrdwCVkvRs)] &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) (`LazyColumn` and `Card`)

</details>

---

## Question 14

You want to write a test that needs to interact with Compose buttons and text fields on an emulator. Where would you place it, and why?

- **A.** In `androidTest`, because it requires an Android runtime and UI environment
- **B.** In `androidTest`, because tests that interact with Compose must modify the Gradle files
- **C.** In `androidTest`, because tests that interact with Compose must modify the Gradle files
- **D.** In `test`, because in `androidTest` it cannot use assertions
- **E.** In `test`, because it should run independently of Android

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A**

Driving a Compose UI means clicking real nodes and typing into real text fields, which needs the Android framework and a running Compose hierarchy. That makes it an instrumented test: it goes in `src/androidTest` and executes on an emulator or a device. Tests in `src/test` run on the JVM, which is why they are much faster and why the bootcamp's `ToDosRepositoryLocalTest` lives there while the UI tests do not.

B and C give the reason as a Gradle change. You do declare an `androidTestImplementation` dependency for the Compose test library, but that follows from the test being instrumented; it is not what decides where the test goes. (These two options are identical, which is a defect in this practice set, not a hint.)

D is wrong: instrumented tests use the same assertion machinery as unit tests, plus the Compose assertions such as `assertIsDisplayed()`.

E is wrong on the facts: a test that clicks Compose nodes cannot run independently of Android, which is the whole reason it is slower and needs a device.

**Scoring**

- `{A}`: 100%.
- `{A, B}`, `{A, C}`, or `{A, B, C}`: 60%. Right location, wrong reason. Since B and C are the same statement, marking both is the same error twice, not two errors.
- Any pattern that includes D: 0%. Instrumented tests use the assertions you already use, plus the Compose ones.
- Any pattern that includes E: 0%. Putting a Compose interaction test in `test/` means it will not run at all, and a student who believes otherwise will spend an evening on the resulting error message.

**Reference material:** [Unit testing guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/UnitTesting.md) (project structure for tests) &middot; [Android testing guide](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/AndroidTesting.md) &middot; [B1 &sect;3 Todo List](https://github.com/swent-epfl/public/blob/main/bootcamp/deliverables/B1/3-TodoList.md) (`test` vs. `androidTest`)

</details>

---

## Question 15

SwEnt is an 8-credit course. At EPFL, how much work does this represent?

- **A.** A bit over 17 hours per week over a 14-week semester
- **B.** Around 12 hours per week over a 14-week semester (1.5 &times; credits)
- **C.** About 8 hours per week (1 &times; credits)
- **D.** The number of hours include lectures, bootcamp, project work, and exam preparation
- **E.** The number of hours is an average, so weeks with a milestone due will run above it, other weeks below it

<details>
<summary><b>Show the answer</b></summary>

**Full credit: A, D, E**

A: The EPFL guideline is 30 hours of student work per credit, so 8 &times; 30 = 240 hours for the semester, and 240 / 14 = 17.1 hours per week.

D: The 240 hours cover everything you do for the course, not just timetabled time. The course description lists 2 h lecture + 10 h project + 1 h exercises = 13 h per week, and the difference between 13 and 17 is the non-timetabled work: the bootcamp, watching the lecture videos, exam preparation, and the work your team does outside the scheduled slot.

E: 17 h/week is an average over the semester. The week a milestone is due runs well above it, and a quiet sprint week runs below.

B is wrong: 1.5 &times; credits is not the EPFL guideline, and 12 h/week gives 168 hours for the semester, 72 hours short.

C is wrong by more than a factor of two: 8 h/week is 112 hours, less than half the expected workload.

**Scoring**

- `{A, D, E}`: 100%. You know the number, what it includes, and that it is an average.
- `{A, D}` or `{A, E}`: 80%.
- `{A}` alone: 55%. You know the figure and have not thought about what it covers or how it is distributed across the semester.
- `{D, E}` without A: 50%. You understand how the number is built and do not know what it is, which is the half that would have changed your calendar.
- Any pattern that includes B or C: 0%. These understate the workload by a third to a half. This is not an arithmetic slip: a student who plans the semester around 8 or 12 hours a week is the student who is behind by M1, and whose team absorbs the difference.

**Reference material:** [Workload](https://github.com/swent-epfl/public/blob/main/README.md#workload) in the course README &middot; Introduction [[pdf](https://drive.google.com/file/d/1GXf3MCy-fcfG1s0l9YmQuMwA4PZEPHIt/view) | [video](https://www.youtube.com/watch?v=-TU946Pckc8)]

</details>
