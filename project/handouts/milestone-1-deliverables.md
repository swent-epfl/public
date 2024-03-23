## Milestone One

The project in CS-311 is divided into four graded Milestones. Each Milestone is set to serve as a marker for you to assess how you are progressing in the project.

### Date

Friday, April 12, 23:59

### Overview

Milestone One will provide you with graded feedback in how you're coming together as a team, organizing and adopting good software engineering practices, as well as making incremental progress towards delivering value to your users. We consider these elements to be essential for you to succeed in the project as a whole.

By contrast, this milestone is not aimed at assessing whether you are great with Android development or software testing. This kind of assessment will come in subsequent milestones, as you gain more experience, and we want to ensure you have the necessary time to acquire those skills before you get evaluated on them.

### You, the coaches and Easter

Ahead of Milestone One, we encourage each and every one of you to invest in yourself and your skills and ask for (ungraded, informative) feedback from your coaches. Your interactions with the coaches are a fantastic opportunity to benefit from their experience.

While Easter won't allow the coaches to be with you for the Sprint 2 ceremonies (review, retrospective, planning), you should feel free to reach out to them on Discord for asynchronous feedback. The whole team is committed to helping you ! 

Furthermore, as part of Sprint 2, the coaches will also be reviewing your PRs - feel free to ask for that proactively if you need early feedback. Importantly, these reviews are not a form of assessment - the coaches are just here to help, guide you on the right path and show you how to review effectively.

### Expected Outcomes

By Milestone One, your team needs to produce the following deliverables:

- Figma (or equivalent) of the main user flows
  - Wireframes
  - Mockups
  - Screen linking (between mockup screens)
- Architecture Diagram
- Product backlog
- Plan for Sprint 4
  - Incl. Sprint Tasks
- A code repository with a configured CI
  - Analyzed by Sonar
  - Tested with at least 1 meaningful end-to-end test
  - With a code coverage >80%
- Working, stable APK
  - Featuring a first meaningful end-to-end user flow
- Scrum process documents
  - At least 1 documented stand-up per sprint
  - 1 sprint retrospective document per sprint

Furthermore, as an individual, you will need to submit:

- Individual retrospective per sprint (before the meeting with your coaches)
- The PRs you created (and were merged), at least 1 per sprint (2 by Milestone One)
- The PRs you reviewed, at least 1 per sprint (3 by Milestone One)

**Attention:** Some of these elements will need to be submitted through Moodle !

You will find below, specific information about some of the deliverables detailed above.

#### Figma

While we suggest you start with wireframes, we urge you to create full mockups whose screens are linked together, so that you can test out the user's flow and build a shared understanding within your team of what the application should look like, which will make defining clear development tasks easier as well.

Figma's Dev Mode may also assist you in building the UI faster.

#### Architecture Diagram

Much like you'll think of the UI when working on Figma, it's important that you think of the general shape of your software solution. 
We strongly urge you to get familiar with [Android's App Architecture guide](https://developer.android.com/topic/architecture/intro) and thinking of what your application UI and data layers might look like, so as to help you understand what dependencies you need to take into account when building your project.

Since this is early on in the project, we don't expect to see a definitive diagram.
We do however want to see that, as a team, you took time to think about the overall architecture of your application and the relations between its different screens, data sources, internal state, etc.

The diagram might look something like the following, which was designed with [Excalidraw](https://excalidraw.com/), though a "domain layer" may or may not be applicable in your use case.

![sample architecture diagram](../assets/sample-schematic-diagram-features.png)

#### Product Backlog

As you approach Milestone 1, you should have a clear backlog with fine-grained, high-priority user stories at the top, and increasingly coarse-grained user stories at the bottom - it doesn't make sense to plan in detail something that you won't have time to develop until many weeks from now.

In particular, we expect remaining user stories for your first epic to be pretty detailed, and to see a reasonable breakdown of the subsequent epic. Making sure the *product* backlog is maintained is the responsibility of the Product Owner in any given sprint.

#### Working, stable APK

We ask that you setup your repository to build the app's APK, so that at the end of every sprint you could create a new release. At Milestone One, your coaches must be able to download the APK, install it on their phone and test out your app.

We do expect the app to start and completed features to be working bug-free - to the best of your abilities, of course.

#### Retrospective

The **team** retrospective is a space for you to grow as a team, discuss what worked or didn't during the last sprint and subsequently identify things to improve for the next iteration.

You will not be judged negatively for identifying issues, on the contrary - you're learning and even professionals occasionally get things wrong.
We do however expect you to treat this seriously, analyze the way you're working together and to come up with reasonable solutions for whatever issues you've been facing as a team.

This document may contain sensitive information and can stay private on Google Drive, we ask that you simply put a link to it in your GitHub wiki for ease of access.

The **individual** retrospective is a document for yourself, accessible only to you and the course staff. We only ask that you fill it seriously, take it as an occasion to reflect about your own work and learning through this project, what you need to focus on moving forward and to recognize the people who've helped you along the way.

## Grading

Milestone One accounts for 10% of your total grade, split evenly between the individual and the group component. The breakdown of Group and Inidividual grades is as follows:

### Group Grade

| Deliverables                          |  Points  |
|---------------------------------------|----------|
| Figma / Screens, Wireframes, Linking  |   25%    |
| Architecture Diagram                  |   10%    |
| Sprint Planning & Product backlog     |   15%    |
| Implementation (APK, CI, tests)       |   40%    |
| Sprint Retrospective                  |   10%    |
| **Total**                             | **100%** |

All these elements reflect the expected outcomes described above.

### Individual Grade

| Deliverables                          |  Points  |
|---------------------------------------|----------|
| (At least) 2 Code PRs                 |   10%    |
| Quality of PRs *                      |   30%    |
| 3 Code Reviews                        |   10%    |
| Quality of Reviews (Sprint 3 only) *  |   10%    |
| Attendance                            |   10%    |
| Individual Retrospective              |   10%    |
| Task Ownership *                      |   20%    |
| **Total**                             | **100%** |

#### * Quality of PRs and Reviews

Milestone One is about ensuring you start working effectively as a team and giving you personalize feedback to help you grow.

As such, "Quality of PRs" will not be about code quality - that will come later.
Instead, we will highlight if you're following the class's recommendations for good PRs.

In particular, we'll be looking at things like whether each PR:
- aligns with a given task's definition of done,
- has a clear goal and description,
- has a single purpose (i.e. not mixing 3 unrelated things in one PR)

As for reviews, we'll be looking at things like:
- is the feedback phrased in a constructive way
- are the suggestions useful, humble
- is it focused on the code, not the person
- have you missed serious, major flaws

#### * Task Ownership

This is about whether you've taken responsibility for the tasks assigned to you, as a developer, Product Owner or Scrum Master.
Basically, whatever task you were responsible for, you made sure that everything that could (realistically) be done has been done to ensure its successful completion.

We recognize completing a task (or success) isn't always granted, and that's why task ownership can look like different things:
- finishing the task yourself,
- asking for help in a timely fashion when you're stuck or unavailable
- bringing up the challenges during the stand-up meeting (at the latest)
- asking the coaches if your team is completely stuck and the teams' attempts have failed
- raising serious blockers for discussion in the retrospective and/or planning
- finishing what can be finished, and discussing a change of strategy/approach for what's left,
- etc.

In summary, you won't be penalized for trying hard and failing to complete a task, but we do expect you to take any and all necessary measures to see them through, coherently with the time you have available for this class.
