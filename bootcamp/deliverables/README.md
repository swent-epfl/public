# Deliverables

The Bootcamp consists of three milestones, each one with its own set of deliverables and its own deadline:

- [B1: Environment setup and getting started with Android](B1/README.md) should be completed latest by the end of Fri, 11.09.2026
- [B2: Building a ToDo app](B2/README.md) should be completed latest by the end of Thu, 17.09.2026
- [B3: Third-party APIs and test coverage](B3/README.md) should be completed latest by the end of Wed, 23.09.2026

These deadlines are there to help you pace yourself; nothing needs to be turned in. If you finish a milestones earlier, just start working on the next one. B1 and B2 ship in your template from day one; B3 arrives later in the same repo, with the same workflow. If you finish one milestone early, edit `BOOTCAMP_PART` (see below) and start the next.

The steps you follow as you complete the three milestones will guide you from the basics to more advanced concepts of Android development. Good luck, and happy coding!

## Working on your Deliverables

On 07.09.2026, all students who have confirmed their Steve account will receive a personalized repo containing an initial template for the Bootcamp.
You can access this repository at `https://github.com/swent-epfl/bootcamp-26-<your GitHub username>`, where `<your GitHub username>` is the GitHub username you provided when confirming your Steve account.
> [!NOTE]
> If you are registered for the course in IS Academia and have not received by email a link for your Steve account, then get in touch with swent-staff@dslab.org right away. You cannot start the bootcamp without completing this step.

The template already includes the tests for the milestones that have shipped (B1 and B2 at the start; B3 later). Test classes are labelled by milestone&mdash;`OverviewScreenB1Test`, `NavigationB2Test`, `ToDosRepositoryLocalTestB1`&mdash;and the staff tests additionally carry `Staff` in the class name, so you can run just the ones you care about (see [Tests and Provided Code](#tests-and-provided-code)).

### Choosing the current milestone

Set which milestone you are working on by editing **one line** in `.github/workflows/CI.yml`:

```yaml
BOOTCAMP_PART: B1   # or B2 (later B3)
```

CI always runs a few always-on checks, plus the tests for the **current part only** (not cumulative).

When you finish a part and want to start the next one, edit that same line to `B2` (or later `B3`). Unlocking solutions does **not** change `BOOTCAMP_PART` for you.

Even though the Bootcamp is not graded, there are at least two concrete reasons to push your solutions to the right branch anyway:

- **The CI tells you where you stand.** Every push to `main` (or PR into `main`) runs the public tests for your current `BOOTCAMP_PART`, and a green `{part}-public` job is a good indicator that you have acquired a basic understanding of the material in that milestone.
- **You get the solutions on a dedicated branch.** When the **`{part}-public`** job is green on `main` (push to `main`, or a PR into `main`), we automatically publish the reference solutions onto a branch in *your* repository (`B1-solution`, `B2-solution`, or later `B3-solution`). That should appear within 1 hour after the CI goes green. This is not tied to the deadline for the milestone: if your public tests are green on Monday, you can get the solutions on Monday and move on to the next milestone (by editing `BOOTCAMP_PART` yourself).

> [!IMPORTANT]
> A green CI on some other branch (for example a personal feature branch that never reaches `main`) does **not** unlock solutions. Push or open a PR into `main` if you want the unlock.
> You can use short-lived feature branches while developing; merge them into `main` when you want CI and unlock to count.

## Tests and Provided Code

We check your Bootcamp automatically by running two kinds of tests on your code, in the CI.
You can also run these tests yourself, in your repo.

- The `Bi` _public tests_ are the ones that you need to pass in order to unlock the solution for `Bi`
- The `Bi` _staff tests_ go beyond the basics of the public tests, and are not required for you to receive the `Bi` solution; they carry `Staff` in the class name. The CI runs them after the public tests on the **same** emulator; they do **not** need to pass for solutions—only the `{part}-public` job counts for unlocking the solution.

To run one milestone, or one kind of test, pass the `-B1` / `-B2` and `-public` / `-staff` flags. They combine, and with no flag the whole suite runs:

```bash
./gradlew check -B1                   # only the B1 unit tests
./gradlew connectedCheck -B1 -public  # only the B1 public instrumented tests
./gradlew connectedCheck -B2 -staff   # only the B2 staff instrumented tests
```

To make sure that we can run our tests on your code, we provide you a skeleton of the app. You can modify the skeleton, as long as you keep the original signatures of the provided classes, methods, and functions. The Bootcamp template contains for you a signature check file `sigchecks/SignatureChecks.kt` to ensure that you do not modify the signatures of the provided code. If you modify any signature, building your app is likely to fail, and so none of the provided tests will be able to run. However, this does not mean that you should feel constrained by the template, signature checks, and tests&mdash;if you are an advanced Android programmer, you should feel free to solve the Bootcamp in whichever way you think is best.

> [!NOTE]
> You are free to add any file/class/function you want to the project.
> You can add any default parameters/properties to the provided functions/classes.
> For example, if a function `foo(a: Int)` is provided, you can change it to `foo(a: Int, b: String = "default")`.
> However, make sure to not modify the name of the existing parameters/properties.

Commit message quality is part of the belt requirements for each milestone.
Make sure you read this [guide on how to write good commit messages](/bootcamp/docs/CommitMessages.md) before starting the Bootcamp.
