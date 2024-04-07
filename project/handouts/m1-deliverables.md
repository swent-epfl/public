## Milestone M1

_[updated 7.04.2024]_

The SwEnt project has four graded milestones (see [README](../README.md#grading)). This handout concerns the first milestone, named M1.

### Due Date

Friday 12.04.2024 @ 23:59

### Overview

Milestone M1 will provide you with feedback on how you are coming together as a team, organizing yourselves, adopting good software engineering practices, and making incremental progress toward delivering value to your users. These are essential ingredients for your success in the SwEnt project. M1 will not assess whether you are top-tier Android developers or software testers &ndash; this will be assessed in subsequent milestones, once you've had the opportunity to gain experience and acquire the relevant skills.

### Leverage Your Coaches

Ahead of M1, we encourage you to solicit (ungraded, informal) feedback from your coaches; the coaches are an important resource that you should leverage for your success. During Easter break there will not be a formal meeting with the coaches for the Sprint 2 ceremonies (i.e., Review, Retrospective, and Planning), but do reach out to them on Discord for asynchronous feedback. The whole staff is committed to helping you.

During Sprint 2, the coaches will be reviewing your PRs  in order to guide you and show you how to review effectively. These PR reviews are not a form of assessment, they're just there to help you.

### M1 Deliverables

Your _team_ will need to prepare the following items and submit their URLs into the [M1 team submission](https://moodle.epfl.ch/mod/quiz/view.php?id=1289972) on Moodle:

1. Figma of the main user flows: wireframes, mockups, and screen linking between mockup screens ➡︎ _figma.com_
- Architecture diagram ➡︎ _your GitHub README_
- Product Backlog ➡︎ _GitHub_
- Sprint Backlog for Sprint 4 ➡︎ _GitHub_
- Code repo with configured CI, analyzed by Sonar, tested with at least 1 meaningful end-to-end test, and >80% line test coverage ➡︎ _GitHub_
- Working, stable APK that features a first meaningful end-to-end user flow ➡︎ _GitHub_
- Scrum process documents: 1 documented stand-up meeting per Sprint + 1 documented Sprint Retrospective per Sprint ➡︎ _Google sheets_ shared with the coaches

Additionally, each _individual_ student must prepare the following and submit them via the [M1 individual submission](https://moodle.epfl.ch/mod/quiz/view.php?id=1289974) on Moodle:

- An individual Retrospective for each Sprint ➡︎ _Google sheet_ shared with the coaches
- The PRs you created and were merged (≥2 by M1) ➡︎ _GitHub_
- The PRs you reviewed (≥2 by M1) ➡︎ _GitHub_

Further details on some of the deliverables appear below.

#### Figma

We suggest that you start with wireframes, and then create full mockups whose screens are linked together, so that you can test out the user flow and build a shared understanding within your team of what the application should look like. This will make it easier to define clear development tasks.

For the M1 deliverable, create a named version called "M1" on figma.com, copy the link from the version history, and submit it on Moodle.

#### Architecture Diagram

Start thinking about the overall design of your app. Familiarize yourself with the [Android App Architecture](https://developer.android.com/topic/architecture/intro) guide, and then draft the UI and data layers. This will help you understand what dependencies you need to take into account when building your app.

It is still early, so we don't expect you to deliver a finalized architecture diagram for M1. However, we do want to see that you have put time into thinking about the overall architecture and the relations between its different screens, data sources, and internal state. Put this diagram in your README and submit the URL of the diagram in Moodle.

Here is an example in the spirit of the Android App Architecture guide. The Domain layer may or may not be applicable to your app. The example was drawn with [Excalidraw](https://excalidraw.com/), but you may use whatever software you want, as long as the diagram displays in your README. 

![sample architecture diagram](../assets/sample-schematic-diagram-features.png)

#### Product and Sprint Backlogs (PB and SB)

As you approach M1, you should have a PB with clear, fine-grained high-priority user stories at the top; all user stories for your first epic should be worked out in detail.  The subsequent epic should be broken down to a reasonable level, and it's OK for the user stories at the bottom of the PB to be coarse-grained &ndash; the Product Owner (PO) may not flesh out in too much detail features that could drop from the PB before release.

> [!NOTE]
> The maintenance of the PB is the responsibility of the PO. You need to wear the PO (not Dev) hat when you work on the PB. Early on, the coaches may exercise a fair amount of PO authority as well, to get you used to the separation between PO and Dev team.

For M1, we will snapshot the PB and SB you have in GitHub at the deadline.

#### Working, Stable APK

You must set up your repo with a GitHub workflow to build the app's APK such that, at the end of every Sprint, you can create a new release at the push of a button. For M1, your coaches must be able to install the APK on their phone and manually navigate around your app. The app should start without a hitch, and the completed features should work bug-free.

> [!NOTE]
> You might find yourself with functionality that is to-be-defined or simply not robust enough for M1. That is fine. What is not fine is for the app to misbehave &ndash; at the very least, have a toast message indicating that a particular function is not yet supported.

For M1, provide in Moodle the URL of the GitHub Actions workflow run that has the M1 APK in its artifacts; we will download the APK from the run's Artifacts section. 

Consider creating a [release branch](https://docs.github.com/en/repositories/releasing-projects-on-github/managing-releases-in-a-repository) called "M1" so that you have a clean snapshot of all code and assets related to M1.

#### Sprint Retrospective Documents

The team-level Retrospective is a standard part of Scrum: It forces the team to discuss what did and didn't work during the last Sprint, and then identify things to improve for the next Sprint. This is an explicit mechanism that helps you grow as a team.

We will judge positively when you identify mistakes and problems, and then come up with ways to improve. Every team, no matter how professional, faces challenges and gets things wrong occasionally.  The good teams realize this, introspect, and improve; the poor teams are oblivious and deteriorate with time.

Use the Google sheets template we provided to you, with one tab per Sprint. The document can contain sensitive information and should be shared solely with your team and coaches. Link it from your GitHub wiki, for convenience.

The individual Retrospective is SwEnt-specific, not part of Scrum. Just like with teams, any top-tier professional uses introspection to learn and improve, so please take this seriously.  Use the template we gave you; make sure the spreadsheet is accessible only to you and the course staff. 

## Grading

The breakdown of the team and individual grades for M1 is as follows:

| **Total Team Grade**                  | **100%** |
|---------------------------------------|----------|
| Figma screens, wireframes, linking    |   25%    |
| Architecture diagram                  |   10%    |
| Sprint Backlog & Product Backlog      |   15%    |
| Implementation (APK, CI, tests)       |   40%    |
| Scrum process documents               |   10%    |

| **Total Individual Grade**            | **100%** |
|---------------------------------------|----------|
| ≥2 code PRs (not documentation, drawings, etc.)   |   10%    |
| Quality of PRs<sup>1</sup>            |   30%    |
| ≥2 code PR reviews                    |   10%    |
| Quality of reviews<sup>2</sup>        |   10%    |
| Participation                         |   10%    |
| Individual Retrospective              |   10%    |
| Task ownership<sup>3</sup>            |   20%    |

<sup>1</sup> M1 is about ensuring that you start working effectively as a team; we aim to give you personalized feedback, to help you grow. Thus, the quality of a PR is not so much about code quality as much as whether you follow the best practices taught in lectures: Does the PR have a clear goal and description? Does it have a single purpose (e.g., does not mix unrelated things in one PR)? Does it align with the task's definition of "done"? 

<sup>2</sup> In M1, our judgment of the quality of a PR review has a dominant "collegiality" component: Is the feedback phrased in a constructive way? Are the suggestions useful and humble? Does the review focus on the code not the person? There is also a technical component that is secondary in M1: Did the review identify all serious problems with the PR? Since it takes some practice to get reviews right, we will only grade the ones you do in Sprint 3, after you've already given and received a few reviews.

<sup>3</sup> This is about whether you've taken proper responsibility for your Dev, PO, and/or Scrum Master tasks.  Did you do everything that could reasonably be done to ensure the successful completion of your tasks? What "proper responsibility" means depends on circumstances:

- you might finish the task yourself; and/or
- ask for help in a timely fashion when you're stuck or unavailable; and/or
- bring up the challenges latest at the stand-up meeting; or
- ask your coaches for help if your team is stuck and everything you tried has failed; and/or
- bring the serious blockers for discussion in the Retrospective and/or Planning meeting; and/or
- finish what can be finished, and discuss a change of strategy/approach for what remains; 
- ... etc.

On this aspect, you will not be penalized for failing, as long as you've truly done your best, given the time budget for this course.
