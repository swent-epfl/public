# Milestone Deliverables

- [Milestone B1](#milestone-b1) due at 23:59 on 17.09.2024
- [Milestone B2](#milestone-b2) due at 23:59 on 23.09.2024
- [Milestone B3](#milestone-b3) due at 23:59 on 30.09.2024

The steps you follow as you complete the three milestones will guide you from the basics to more advanced concepts of Android development. Good luck, and happy coding!

## Milestone B1

This milestone focuses on setting up your Android development infrastructure, plus a few basics of the ToDo app.

| Status | Task                                                                                                                                                  | Estimated Time | Actual Time |
| ------ | ----------------------------------------------------------------------------------------------------------------------------------------------------- | -------------- | ----------- |
| ☐      | [Initial Setup](Setup.md#setting-up-your-development-environment)                                                                                     | 1 hour         | -           |
| ☐      | [Create a Simple Android Application](Setup.md#getting-started-with-android)                                                                          | 1 hour         | -           |
| ☐      | [Set up Continuous Integration (CI)](Setup.md#setting-up-the-continuous-integration)                                                                  | 1.5 hours      | -           |
| ☐      | [Build the APK](Setup.md#building-an-apk)                                                                                                             | 1 hour         | -           |
| ☐      | Read [Ensuring Compatibility and Parity with SigCheck and Screen](sigcheck/README.md)                                                                 | 10 min         | -           |
| ☐      | Review [User Stories](../Theory.md#1-user-stories) theory                                                                                             | 10 min         | -           |
| ☐      | Review [Good Commit Messages](../Theory.md#2-commit-messages) theory                                                                                  | 10 min         | -           |
| ☐      | Write user stories (see below)                                                                                                                        | 30 min         | -           |
| ☐      | Implement the [Sign-in and Login](UserStories/UserStory.md#1-sign-in-and-login) user story by following [these steps](UserStories/1-SignInAndLogin.md)| 2.5 hours      | -           |

We provide you with a few [initial user stories](UserStories/UserStory.md) that give you a better understanding of the ToDo app.
For the _Write user stories_ deliverable, you need to write two additional user stories.
Write your user stories in a file named `userStories.txt` at the root of your repo, one story per long line (this is essential in order to enable grading).
In other words, the file should contain exactly two lines of text, each line containing one user story.

> [!NOTE]
> You do not have to implement the features, so be creative in your user stories!

### B1 Grading

> [!IMPORTANT]  
> Automated grading will apply to the `main` branch of this repo, using the last commit you made before 24:00 on 17.09.2024.
> If you start working on B2 before the deadline for B1, we recommend that you do so on a branch called `milestone-B2`, which you then merge into `main` before the B2 deadline.

- Bronze
  - Pass all the public B1 tests, which check that your environment is properly set up
  - Pass all the public tests for [Greeting UI](Setup.md#getting-started-with-android)
- Gold: In addition to Bronze,
  - Pass all the staff tests for [Sign-in and Login](UserStories/UserStory.md#1-sign-in-and-login)
  - Your commit messages are good
  - The two user stories are good
- Platinum: In addition to Gold,
  - Your commit messages are perfect
  - The two user stories are perfect

Continuous Integration (CI) will run the public tests, so you can just check the CI output.

Since we will grade the commit messages that accompany the pushes to your repository,  make sure you follow from the start the guidelines summarized [here](../Theory.md#2-commit-messages).

## Milestone B2

This milestone focuses on creating the basic app with its core features, and beginning to test it.

| Status | Task                                                                                                                                              | Estimated Time  | Actual Time |
| ------ | ------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ----------- |
| ☐      | Review [Using Modularity and Abstraction](../Theory.md#3-using-modularity-and-abstraction) theory                                                 | 15 min          | -           |
| ☐      | Review [Implementing the MVVM Model](../Theory.md#4-implementing-the-mvvm-pattern) theory                                                         | 15 min          | -           |
| ☐      | Implement the [Create a ToDo](UserStories/UserStory.md#2-create-a-todo) user story by following [these steps](UserStories/2-AddATodo.md)          | 6 hours         | -           |
| ☐      | Implement the [View List of ToDos](UserStories/UserStory.md#3-list-of-todos) user story by following [these steps](UserStories/3-ListOfTodos.md)  | 2 hours         | -           |
| ☐      | Implement the [Edit a ToDo](UserStories/UserStory.md#4-edit-a-todo) user story by following [these steps](UserStories/4-EditATodo.md)             | 2 hours         | -           |

### B2 Grading

> [!IMPORTANT]  
> Automated grading will apply to the `main` branch of this repo, using the last commit you made before 24:00 on 23.09.2024.
> If you start working on B3 before the deadline for B2, we recommend that you do so on a branch called `milestone-B3`, which you then merge into `main` before the B3 deadline.

- Bronze
  - Pass all the signature checks
  - Pass all the public B1 tests
  - Pass all the public B2 tests for [Create a ToDo](UserStories/UserStory.md#2-create-a-todo)
- Gold: In addition to Bronze,
  - Pass all the public B2 tests for [View List of ToDos](UserStories/UserStory.md#3-list-of-todos) and [Edit a ToDo](UserStories/UserStory.md#4-edit-a-todo)
  - Pass all the staff B2 gold tests
  - Commit messages conform perfectly to the [SwEnt guidelines](../Theory.md#2-commit-messages)
- Platinum: In addition to Gold,
  - Pass all the staff B2 platinum tests
  - Commit messages conform perfectly to the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) spec

Continuous Integration (CI) will run the signature checks and public tests, so you can just check the CI output.

## Milestone B3

This milestone focuses on testing the app you wrote, and on developing advanced features.

| Status | Task                                                                                                                                                             | Estimated Time   | Actual Time |
| ------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------- | ----------- |
| ☐      | Review [Collaborative Development](../Theory.md#5-collaborative-development) theory                                                                              | 10 min           | -           |
| ☐      | [Code-review a PR](#code-review-a-pr)                                                                                                                            | 1 hour           | -           |
| ☐      | Implement the [Location-based ToDos](UserStories/UserStory.md#5-location-based-todos) user story by following [these steps](UserStories/5-LocationBasedTodos.md) | 3 hours          | -           |
| ☐      | Write unit tests for ToDoApp (see the [Unit Testing](../Tutorials/UnitTesting.md) tutorial)                                                                      | 2 hours          | -           |
| ☐      | Write UI tests for ToDoApp (see the [UI Testing](../Tutorials/AndroidTesting.md) tutorial)                                                                       | 4 hours          | -           |
| ☐      | Implement [advanced features](#advanced-features-platinum) (Platinum tier only)                                                                                  | 3 hours          | -           |

### Code-Review a PR

We ask that you review a Pull Request (PR) made by our team on your repository.
This PR introduces a calendar-like feature that displays your ToDos in a timeline view.
The code contains several issues, and we will grade how carefully you identify these issues, the changes you request, and how you do it.

We recommend that you start by reading the PR description using GitHub's web interface (see the "Pull requests" tab at the top) to understand what it's about.
Next, run and test the code. The easiest way to do this is using a `git fetch origin` followed by a `git switch calendar`.
Once you're on the `calendar` branch, just follow the instructions in the PR description to connect the calendar code to your app.
After you've played around with the feature, start your code review through the web interface.
For example, you can click on "Files changed" to view the file affected by this PR and start commenting on the code.

> [!WARNING]
> Do not merge the PR. If you did so accidentally, you must [revert](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/incorporating-changes-from-a-pull-request/reverting-a-pull-request) it before the deadline.

### Testing

You are required to implement your own tests to increase the code coverage for the parts of the code you have developed. Coverage will be taken into account when grading B3, so it’s important that your tests thoroughly cover the new functionality you’ve implemented, including corner cases.

You should not modify the provided test files. Instead, create new test files to implement your own tests. This will allow you to maintain the integrity of the provided tests while ensuring you are able to increase the coverage with your own testing strategies.
To check your coverage, run the Gradle tasks `check`, `connectCheck`, and `jacocoTestReport`, and then inspect the `index.html` generated by JaCoCo.

### Advanced Features (Platinum)

Milestone B3 gives you an opportunity to go beyond the basic functionality of your ToDo app and develop some more advanced features.
We deliberately do not provide step-by-step instructions for how to perform these tasks.
These advanced features require that you work smartly, because otherwise they can take a lot of time and you might still not succeed.
But if you master your tools, apply what you learned in lecture, and know how to search for solutions in an autonomous manner, they should take on the order of 3 hours.

Make sure you have finished the Gold requirements completely before starting on these Platinum-tier advanced features.
In order for the teaching staff to properly assess your work, you must copy the file [`B3-AdvancedFeatures.md`](B3-AdvancedFeatures.md) to the root of your repository and fill it out.

- __Mockup of a new user story__

  Write a new user story in `B3-AdvancedFeatures.md` that does not appear in any of the code or documentation provided by us or by you.
  Then create a Figma prototype for a new user story, featuring a wireframe, that follows the bootcamp design guidelines.

- __TDD approach to the new user story__

  Define the acceptance criteria for your user story in `B3-AdvancedFeatures.md` and commit it to the main branch.
  Then create a new branch called `B3-TDD` and write the corresponding tests there.
  Commit the tests, even though they should all fail.
  You are not required to implement the feature itself (i.e., no need to make the tests pass).
  However, the tests must fully cover all the acceptance criteria of your user story.

- __Conditional branch coverage__

  Improve the branch coverage of the ToDo app. The objective here is to be efficient: maximally boost the branch coverage with a minimal number of tests. When grading, we will analyze the ratio between branch-coverage improvement and the number of individual test executions (not test files) you used to achieve that improvement.
  The highest such ratio achieved by a student in SwEnt will receive the maximum number of points, and all others will be scaled accordingly.

  > For us to be able to grade this, the conditional branch coverage must be calculated automatically using JaCoCo, so make sure that your tests are present in the `main` branch.

### B3 Grading

> [!IMPORTANT]  
> Automated grading will start on the `main` branch of this repo at 24:00 on 30.09.2024, so please make sure that your submission is pushed to `main` before then.

- Bronze
  - Pass all the signature checks plus all public B1 and B2 test (there are no public B3 tests)
  - Pass all the staff B3 Bronze tests (these do <u>not</u> test any of the [advanced features](#advanced-features))
  - Achieve 60% line coverage
- Gold: In addition to Bronze,
  - Pass all the staff B3 Gold tests (these do <u>not</u> test any of the [advanced features](#advanced-features))
  - Achieve 70% line coverage
  - Commit messages conform perfectly to the [SwEnt guidelines](../Theory.md#2-commit-messages)
- Platinum: In addition to Gold,
  - Pass all the staff B3 Platinum tests, which also test the [advanced features](#advanced-features)
  - Achieve 80% line coverage
  - Commit messages conform perfectly to the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) spec

The CI will run the public tests and compute the coverage using JaCoCo, so check the CI output. Our public tests already achieve a certain level of coverage, and that contributes to the overall coverage (and thus to the coverage figures above).

> [!CAUTION]
> Do not modify anything in this file other than the time and progress tracking.
