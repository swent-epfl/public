# EPFL Software Enterprise Project

The CS-311 Project is aimed at teaching you how to work efficiently in teams and how to build and ship software products. To achieve this, you will work in a fashion inspired by the [SCRUM](https://www.scrum.org/learning-series/what-is-scrum/) development process. The [development process](#development-process) described for the project closely resembles how software is built in the real world. 
You will build a project for Android based on the finalized project proposal submitted during the initial weeks of the course. 

## Learning Objectives

The CS-311 project structure is designed to teach you the following - 

- How to think, ideate, build and refine products that solve a real problem.
- How to write robust and maintainable code as part of a team.
- How to plan development time effectively to deliver value continuously.
- How to review code and give constructive feedback to maintain code quality.
- How to apply SCRUM in the real world.
- How to deal with the pitfalls of real-world software engineering, such as dealing with incomplete documentation, bugs in tools and libraries, fixing code that only works on one developer's machine.

## App Requirements

All apps must meet the basic requirements of functionality and resilience: apps must accomplish compelling tasks for clear use cases, in a way that is easy to use and consistent with the Android experience; and apps must work in the face of user errors, malice, and external issues such as a lack of Internet connectivity, with a test suite to demonstrate this.

All apps must also meet the following requirements:

- Split app model: the app must use a public cloud service, such as Google Firebase
- User support: the app must have a concept of authentication, for instance using Android’s built-in Google authentication
- Sensor use: the app must use at least one phone sensor, such as GPS, camera, or microphone, as part of a core feature of the app
- Offline mode: the app must be usable without Internet connectivity, by paring down features compared to the normal experience.

Unless absolutely needed, teams are discouraged from writing backend that need self-hosting/deployment. This is to ensure (a) the app will still work in the future without requiring someone to set up and maintain a backend, and (b) the project scope is restricted enough for timely completion within the duration of the course.

> [!NOTE]
> You may choose to use firebase cloud functions if you wish, however please discuss your use-case with your coaches prior to deciding to use it. Only if your coaches approve the necessity of a backend, should you set one up.

Security, privacy, and vendor lock-in are valid concerns but outside the scope of the course project's considerations.

Sensor usage should drive some behavior and functionality in the app, such as finding nearby points of interest with the GPS, or augmenting reality by drawing over a video feed. Merely getting sensor data and storing it in a field shown to users is too simple and not does not satisfy the minimum project requirements.

> [!WARNING]
> You can also use open-source alternatives to firebase if you wish, however again - 
> 1. Ensure that you let your coaches know that you will be using a Firebase alternative like `appwrite` or `supabase`.
> 2. Know that using something other than firebase will mean that you will get limited tech support, and you will largely be on your own when dealing with issues related to database and database-testing.

## Starting the Project

1. A handout for Sprint 1, along with a list of TODOs to help you hit the ground running is provided [here](./handouts/sprint-one-handout.md).
2. A sample Android Project with gradle files, a CI script, and recommended project structure is available [here](https://github.com/swent-epfl/Android-Sample). You can take inspiration from it when setting up your own project. 
3. Your bootcamp code (and experience) will be an invaluable resource in helping you move fast in the beginning of the project.
4. For the first Sprint, your primary objective should be to ensure the project is setup and everyone is in a position to start contributing.

## Development Process

The SCRUM development process relies on three key roles:

1. Product Owner
2. Scrum Master
3. Developer(s)

The Product Owner or PO is primarily responsible for gathering user feedback and insights, and deciding the product's priority, by dictating what features the team should implement next.

The Scrum Master or SM is primarily responsible for deciding how much work the team can take on in a Sprint such that they can reasonably finish the Sprint in time and deliver value by the end of the Sprint. Once the Sprint has started, the SM is responsible for conducting standups, and ensuring smooth functioning of the team - unblocking developers, involving the PO for clarifications when needed.

The Developer is an IC (Individual Contributor) who is tasked with implementing the requirements laid out in a _ticket_ by the PO (almost always accompanied with a User Story). Where necessary, a _ticket_ must also come with a figma and a clear list of _Acceptance Criteria_. 

> [!NOTE]
> You have seen such tickets given as User Stories in the [bootcamp](https://github.com/swent-epfl/bootcamp-template/blob/main/docs/bootcamp/UserStory.md).

### Starting a Sprint

Each Sprint in SCRUM starts with a planning meeting. During this meeting, the _Product Owner_ decides the product's priority by prioritizing the User Stories in the _Product Backlog_. Then, s/he works with the Scrum Master to decide which User Stories will be implemented during the Sprint. 

All _tickets_ for a Sprint are agreed upon at the start of the Sprint, frozen on the SCRUM board in the "Sprint Backlog", and assigned to Developers. Once the Sprint Backlog is frozen, each Developer breaks down their ticket into smaller Sprint Tasks and estimates the time for each task.

### Working on Sprint Tasks

To begin working on a new task, you should create a branch for the task, and begin your implementation. **You should push code frequently** to it; once the task is completed, including tests, then open a pull request. If you want early feedback on code that is not finished yet, use GitHub's "draft" pull requests. Once you have at least one accepting code review from a teammate, and your code passes continuous integration checks, merge the pull request.

You may, at times, need to create multiple pull requests for a single task. For instance, if your task is to create a new module, and a teammate needs to use that module, you can create a pull request with just the module’s interface, so that you can agree with your teammate on what the interface should be. Similarly, if you realize you will not have time to finish a task in the current sprint, you can submit a pull request with a polished version of a smaller part of the task, including tests for just that part. 

> [!NOTE]
> It is normal for your time estimates to be occasionally inaccurate in the beginning. However, this should happen less often as the course progresses.

While writing code for a task, you must balance two concerns: making clean self-contained code, and making code that is easy to evolve in the near future. Don’t make your design overly complex for hypothetical future changes that may never happen, but think about the next few tasks that are likely to come up and how they will fit in your code.

> [!WARNING]
> The most commonly seen anti-patterns when working on Sprint tasks are - 
> 1. Not pushing regularly.
> 2. Raising PRs shortly before a Sprint Review Meeting.
> 3. Raising PRs with 1000s of LoC.
>
> These are very bad practices and are strongly discouraged. Following good development practices is something you will be evaluated on during the project. We will depend on the `git` history when doing this evaluation, so please remember to push small, regular changes and create reasonable and well-contained PRs.


### Code Reviews

Each pull request must be reviewed by at least one teammate, in a thorough and inquisitive fashion to uncover bugs, discuss design, and learn about changes.
The Scrum Master is responsible for ensuring people review the pull requests they are assigned to in a timely fashion.

Read the entire code, and comment on code that looks wrong or that you think could be improved.
Ask questions when you do not understand a change.
Leave positive comments as well, such as congratulating the author for getting rid of an ugly hack.

> [!NOTE]
> A good heuristic for reviewing code is as follows - 
> 1. When reviewing code for a new feature: look for design-pattern comments or near-team integration issues that may arise.
> 2. When reviewing changes to existing code: Always remember that the code + the commit messages should satisfactorily explain the change.

You can prefix your comments with one word indicating the kind of comment it is, such as "important" or "nitpick" or "question".
Make sure you talk about the code, not the author. "You are wrong" or "Your code is bad" will put your teammates on the defensive, whereas "Have you considered what happens when.." or "An improvement that I see here..." is constructive.

If you really have nothing to say, a simple “looks good to me” or “LGTM” for short is fine.
This should only be the case for the occasional tiny pull request that fixes a simple bug, not for large changes for which there is always something to discuss or learn from.

Here are some good examples of code reviews in past projects:
[1](https://github.com/epfl-SDP/android/pull/255),
[2](https://github.com/epfl-SDP/android/pull/410),
[3](https://github.com/PalFinderTeam/palFinder/pull/82),
[4](https://github.com/PalFinderTeam/palFinder/pull/302).

And some examples from large open-source projects:
[1](https://github.com/dotnet/runtime/pull/81725),
[2](https://github.com/dotnet/runtime/pull/72712),
[3](https://github.com/openjdk/jdk/pull/7431),
[4](https://github.com/ruby/ruby/pull/5002),
[5](https://github.com/lampepfl/dotty/pull/16612)

> [!NOTE]
> Your coaches will review your PRs in the initial weeks of the project. This is a great opportunity to get early feedback during the Sprint on how you are progressing. You should consider creating "draft" PRs early on to get more feedback!

### Standup Meetings

To help team members know what others are doing, you are **strongly encouraged** to hold what Scrum calls "standup meetings". These are short meetings, maximum 15 minutes. In standup meetings, each team member explains what they worked on since the previous standup, what they plan to work on next, and whether they are blocked on anything. 

**Standup meetings are not for extended discussion**. They are meant to serve two purposes:

1. Keep the team in sync during the course of a Sprint. 
2. Help the team identify any blocking issues.

Together, these help in keeping inefficiencies to a minimum. Additionally, it helps the team in planning how to tackle blockers, such as holding a later meeting to discuss a design issue or asking one member to help another.

Your team should have at least two standup meetings per sprint. The Scrum Master is responsible for planning and conducting the standups. **The Scrum Master will also be required to submit a weekly meeting-minutes of the standups conducted during the sprint.**

### Sprint Review Meetings

You will meet your SwEnt coaches every Friday. These meetings are meant to serve as Sprint Review Meetings. In these meetings, you will go over how the sprint went, what worked well, what didn't work well, what deliverables were finished in the Sprint and what you will do in the next Sprint. 

In these meetings, your coaches are there as a resource for you. They are there to give you inputs on how you can resolve issues, and improve upon any inefficiencies in your development process. 

**Your coaches are not there to judge you. Your final grading is done by the SwEnt staff.**


## Grading

The Project will be graded at 4 different points during the development cycle. Each "mark" or Milestone is chosen in a way that reflects enough time to have a "visible delta" on the project. It is anticipated that the pace of the project and team dynamics will change during each Milestone. The high-level breakdown of points assigned to each Milestone are as follows - 

| Milestone | Duration | Individual Grade | Group Grade |
|-----------|--| ------------------|-------------|
| Milestone 1 | 2 Weeks | 5% | 5% |
| Milestone 2 | 3 Weeks | 10 % | 5% |
| Milestone 3 | 3 Weeks | 12.5 % | 5% |
| Milestone 4 | 2 Weeks | 17.5% | 15% |
| **Total** | 10 Weeks | **45%** | **30%** |

The exact breakdown for each milestone will be shared in due course. However, the grading rubric is designed in a way that ensures that following the SCRUM process, and building and delivering value on a per-sprint basis will achieve (near) full grade.