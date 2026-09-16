# Milestone B3

This milestone focuses on implementing a third-party API in the app and on testing it.

> [!NOTE]
> B3 ships as a **template update** on the same repository and the same `main` branch (not a separate milestone branch). Once you have finished B1 and B2, set `BOOTCAMP_PART: B3` in `.github/workflows/CI.yml` so CI runs B3's public tests.

## Getting the B3 template update

The template update is pushed **directly onto your `main`** as a single commit (`Deploy B3`). It adds the new B3 tests, CI pieces, handout files, and scaffolding on top of your existing work. Your app sources under `app/src/main` and your `actualTimeB1.csv` / `actualTimeB2.csv` are **not touched**, so there is nothing to merge and no conflicts to resolve. You do not need to do anything for the update itself.

### Branches involved

| Branch | Role |
| --- | --- |
| `main` | Your working branch for all milestones. The B3 update will be here; CI and solution unlock also run here. |
| `B3-solution` | Appears later, only after `part-public` is green on `main` with `BOOTCAMP_PART: B3`. Not merged into `main` for you. |
| `calendar` | Separate staff PR for the code-review exercise (step 2). Do **not** merge it. |

### After the B3 update lands

Pull `main`, then set up your CI for B3 before you start:

```bash
git switch main
git pull
```

> [!IMPORTANT]
> The update lands as a normal commit on `main`, so `git pull` is usually a clean fast-forward. If you had **local changes to template-owned files** (a test, `CI.yml`, `build.gradle.kts`, …) `git pull` may report conflicts. Resolve them by keeping the **incoming template version** for tests, CI, and scaffolding, and **your own** code under `app/src/main`. Ask a TA if you are stuck; do not copy files from a classmate.

1. **`BOOTCAMP_PART`.** The update resets this line to `B1` in `.github/workflows/CI.yml`. Set it to:
   ```yaml
   BOOTCAMP_PART: B3
   ```
   The CI will not run the B3 tests (nor unlock the B3 solution) until you do.
2. **Open in Android Studio and sync Gradle** so the new B3 tests and dependencies are picked up.

Run local smoke tests once you are ready to implement B3:

```bash
./gradlew check -B3 -public
./gradlew connectedCheck -B3 -public   # emulator + Firebase emulator running
```

> [!IMPORTANT]
> With `BOOTCAMP_PART: B3`, **only the B3 public tests need to pass** (the `part-public` job). CI does not re-run B1/B2 for unlock.
> Once you deploy real Firestore security rules, some B2 instrumented tests can start failing if you run them again (for example with `./gradlew connectedCheck -B2` or without a part flag). That is **expected**: those helpers were written for open rules, and an obscure `PERMISSION_DENIED` / `ownerId` error usually means the old B2 query no longer matches your B3 rules, not that your rules are wrong. Focus on `-B3 -public` (and the B3 belt criteria below). Staff tests may also fail in CI; they are **not** required for unlocking `B3-solution`.

With `BOOTCAMP_PART: B3`, CI also runs Maps/`LOCAL_PROPERTIES` setup, the Firestore rules tests, and the `prReviewMCQ.md` check (in addition to the usual `part-public` / staff jobs).

Complete the tasks below for this final B3 milestone.
We provide an estimated amount of time for each step&mdash;after you complete a step, fill in the _actual_ time you spent in the `actualTimeB3.csv` file that is in the top folder of your individual repo.
Make sure you preserve the structure of the CSV file.

<table>
    <colgroup>
      <col style="width:5%; text-align:center">
      <col style="width:55%">
      <col style="width:20%; text-align:center">
      <col style="width:20%">
    </colgroup>
    <thead>
    <tr>
      <th>Step</th>
      <th>Description</th>
      <th>Estimated time (minutes)</th>
      <th>Actual time (minutes)</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>Review <a href="/bootcamp/docs/CollaborativeDevelopment.md">Collaborative Development</a> theory</td>
      <td>10</td>
      <td rowspan="9">Update <code>actualTimeB3.csv</code> file in your individual repo</td>
    </tr>
    <tr>
      <td>2</td>
      <td><a href="#code-review-a-pr">Code-review a PR</a></td>
      <td>60</td>
    </tr>
    <tr>
      <td>3</td>
      <td>Implement <a href="1-Authentication.md">authentication</a></td>
      <td>180</td>
    </tr>
    <tr>
      <td>4</td>
      <td>Implement <a href="2-AccessControl.md">access control</a></td>
      <td>60</td>
    </tr>
    <tr>
      <td>5</td>
      <td>Move to <a href="AgenticWorkflow.md">multiple agents</a> and use them to build the next step</td>
      <td>30</td>
    </tr>
    <tr>
      <td>6</td>
      <td>Implement <a href="3-LocationBasedTodos.md">forward geocoding</a></td>
      <td>150</td>
    </tr>
    <tr>
      <td>7</td>
      <td>Implement <a href="4-GoogleMaps.md">maps</a></td>
      <td>60</td>
    </tr>
    <tr>
      <td>8</td>
      <td>Review <a href="../../docs/UnitTesting.md"> Unit Testing </a> and  <a href="../../docs/AndroidTesting.md"> Android Testing</td>
      <td>60</td>
    </tr>
    <tr>
      <td>9</td>
      <td><a href="#testing">Test your implementation</a></td>
      <td>180</td>
    </tr>
  </tbody>
</table>

## Code-Review a PR

We ask that you review a Pull Request (PR) made by our team on your repository.
This PR introduces a calendar-like feature that displays your ToDos in a timeline view.
The code contains several issues: identify them carefully, and request the corresponding changes.
For many of you, this is the first opportunity to do a serious code reviews; you will be doing many of them in SwEnt going forward.

We recommend that you start by reading the PR description using GitHub's web interface (see the "Pull requests" tab at the top) to understand what it's about.
Next, run and test the code. The easiest way to do this is using a `git fetch origin` followed by a `git switch calendar`.
Once you're on the `calendar` branch, integrate the `CalendarToDo` component into your navigation implementation to enable the calendar feature in your app.
After you've played around with the feature, start your code review through the web interface.
For example, you can click on "Files changed" to view the file affected by this PR and start commenting on the code.
Feel free to ask your favorite LLM for further tips on how to use this interface productively.

After you finished your review, answer the multiple-choice questions in the `prReviewMCQ.md` file at the top level of your repo. 
These questions are designed to help you identify mistakes and propose improvements during the review.
The questions do **not** cover all the issues in the PR&mdash;you are expected to find additional ones.
> [!WARNING]
> Do not merge the PR. If you do so accidentally, you will need to [revert](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/incorporating-changes-from-a-pull-request/reverting-a-pull-request) it.

## Testing

You are required to implement your own tests to increase the code coverage for the parts of the code you have developed. It’s important that your tests thoroughly cover the new functionality you’ve implemented, including corner cases.

You should not modify the provided test files. Instead, create new test files to implement your own tests. This will allow you to maintain the integrity of the provided tests while ensuring you are able to increase the coverage with your own testing strategies.
To check your coverage, run the Gradle tasks `check`, `connectedCheck`, and `jacocoTestReport`, and then inspect the `index.html` generated by JaCoCo. To focus on B3 only locally, pass `-B3` (and optionally `-public` / `-staff`), for example `./gradlew check -B3 -public` and `./gradlew connectedCheck -B3 -public`.

## B3 Requirements

> [!NOTE]
> Pushing B3 is not an obligation. After the [B3 template update](#getting-the-b3-template-update) is on `main`, work on (or PR into) **`main`** with `BOOTCAMP_PART: B3` in `.github/workflows/CI.yml`. After the `part-public` job is green on `main`, we will publish the B3 reference solutions on a dedicated branch in your repo (`B3-solution`), usually within 1 hour. The deadline of 23:59 on 23.09.2026 is only indicative and meant to guide you.
> <br>Do not change the Gradle wrapper, Android Gradle Plugin, or other version-catalog pins away from the bootcamp template (including “upgrading” them). Diverging from the template toolchain will break the test framework.

We use the belt system described in the [README](../../README.md) for your Bootcamp.

- <span style="background-color: #f2f2f2;">White Belt</span>: You should be confident that your app still works end-to-end on top of your B1/B2 features. The CI for B3 only runs B3 public tests; as explained, some older B2 tests may fail under B3 security rules.
- <span style="background-color: #FCE883;">Yellow Belt</span>: In addition to White,
  - Pass all the public and staff B3 tests for [Authentication](1-Authentication.md)
  - You reviewed the PR and completed `prReviewMCQ.md`
  - Your B3 commit messages are acceptable
- <span style="background-color: #77DD77;">Green Belt</span>: In addition to Yellow,
  - Pass all the public B3 tests for [Access Control](2-AccessControl.md)
  - Pass all the public and staff B3 tests for [LocationBasedTodos](3-LocationBasedTodos.md)
  - Your B3 commit messages are good
- <span style="background-color: #87CEFA;">Blue Belt</span>: In addition to Green,
  - Pass all the public and staff B3 tests for [Google Maps](4-GoogleMaps.md)
  - Reach 85% statement (line) coverage
  - Your B3 commit messages are good
- <span style="background-color: #3F3F3F; color: white;">Black Belt</span>: In addition to Blue,
  - Reach 65% branch coverage
  - Your B3 commit messages are perfect
