## Milestone M2

> [!CAUTION]  
> This document is for the old edition of the course.
> The one for this edition is coming soon.

_[updated 1.05.2024]_

The SwEnt project has four graded milestones (see [README](../README.md)). This handout concerns the second milestone, named M2.

### Due Date

Friday 3.05.2024 @ 23.59

### Overview

The specifics of each milestone are synchronized with how we expect your experience and skills to be developing over time. [M1](m1-delverables.md) focused on the foundational practices and team dynamics. Milestone M2, in turn, builds upon this foundation and emphasizes the rhythm and consistency of your team's Scrum practices, and the delivery of continuous value. 

The best way to "prepare" for a milestone is to work on your project according to what we teach in SwEnt: keep your backlogs and documentation up-to-date, follow the Scrum process diligently, make meaningful contributions to your code every Sprint, do good testing and good code reviews, demo your app in every Sprint Review, be a good teammate, and so on.  If you do everything right, then there is little extra to do for each milestone&mdash;the milestones are just a way to ensure you stay on-track and operate at the right pace.

### M2 Objectives

__Delivering Continuous Value__: 
Developing a successful product requires excellent alignment with the stakeholders' expectations and needs. This requires engaging early with initial customers, potential investors, and incubators. Regular demonstrations of progress and capability are essential to maintaining their support and interest. 

__App Demos__: Starting in Sprint 5, allocate 5 minutes during each Sprint Review to present a demo of your app, which  demonstrates continuous improvement. This demo should focus on the functionality developed during the Sprint and explain how feedback from previous demos influenced the present one. You should always have a demo ready to show, and improve your elevator pitch from Sprint to Sprint (see the end of [the first lecture](https://moodle.epfl.ch/pluginfile.php/3317323/mod_resource/content/2/Wk1.1%20-%20Introduction%20%2B%20Requirements.pdf)). Don't forget that you will need to have a perfect demo for the Battle of the Apps.

__Task Management__: As your proficiency with the technology stack improves, your ability to break down tasks into units of predictable work should also improve. For the M2 milestone, you should be able to demonstrate improved productivity (e.g., more PRs and code reviews) and improved estimation capabilities (e.g., tasks are more granular, they are more self-contained, each PR represents a complete, discrete piece of functionality).

### M2 Deliverables

Your _team_ will need to prepare the following items and submit their URLs via the [M2 team submission form](https://moodle.epfl.ch/mod/questionnaire/view.php?id=1294073): 

1. Updated Figma : Should cover, at the very least, the functional flows for both planned epics ➡︎ _figma.com_
2. Updated architecture diagram ➡︎ _your GitHub README_
3. Product Backlog ➡︎ _GitHub_
4. Sprint Backlog for Sprint 7 ➡︎ _GitHub_
5. Sprint tasks for Sprint 7 ➡︎ _GitHub_
6. M2 release branch with automated APK generation ➡︎ _GitHub_
7. CI with automated testing that achieves >80% line test coverage ➡︎ _GitHub_
9. A 2-minute video demo of your app targeted at potential customers/investors ➡︎ _platform of your choice_
10. Working, stable APK that features at least 2 epics ➡︎ _GitHub_
11. Scrum process documents: 1 documented stand-up meeting per Sprint + 1 documented Retrospective per Sprint ➡︎ _Google sheets_ shared with the coaches
12. Demonstrated autonomy (at the latest during Sprint 6)

Additionally, each _individual_ student must prepare the following item and submit them via the [M2 individual submission form](https://moodle.epfl.ch/mod/questionnaire/view.php?id=1294077):

1. An individual Retrospective for each Sprint ➡︎ _Google sheet_ shared with the coaches
2. The PRs you created and were merged (≥1 in each Sprint) ➡︎ _GitHub_
4. The PRs you reviewed (≥1 in each Sprint) ➡︎ _GitHub_

#### Figma

For the M2 deliverable, create a named version called "M2" on figma.com, copy the link from the version history, and submit it via the form. This version should fully cover your epic #1, as well as most functionality for epic #2.

#### Architecture Diagram

Update the architectural diagram to include all new components and interactions. If your data models have relationships, then we suggest you create a separate diagram to show these.

#### Working, Stable APK

Your APK must demonstrate the full functionality of epic #1 and initial functionality of epic #2.

You must set up your repo with a GitHub workflow to build the app's APK. At the end of every Sprint, you should be able to create a new release APK "at the push of a button."

Create a [release branch](https://docs.github.com/en/repositories/releasing-projects-on-github/managing-releases-in-a-repository) called "M2" so that you have a clean snapshot of all code and assets related to this milestone. In Moodle, provide the URL of the GitHub Actions workflow run that has the M2 APK in its artifacts; we will download the APK from the run's Artifacts section. 

> [!TIP]
> Automatically remove old builds to avoid using up the limited storage space you have on GitHub.

There will be no alternate means of submitting the APK for M2.

#### Video Demo

You can produce the video either by screencasting your device or directly with the "Screen record" feature of the Android emulator. Store the video in a persistent location and put its URL in the submission form. The video must be publicly accessible via that URL and in a widely used format (e.g., MP4 or AVI) that is easily played in a browser or a default video player. If we cannot access or play the video, we cannot count it toward your M2 deliverables.

For M2, the production quality is not a key factor. What matters the most is that you think through the steps of the demo and what you show vs. what you do not show. Don't spend time on voice-over or adding audio.

#### Team Autonomy

The goal of SwEnt is to enable you, as a team, to run a software project from A-to-Z on your own. We therefore expect that the Sprint Review and Retrospective for Sprint 6 and the Sprint Planning for Sprint 7 will be organized and run entirely by you. The coaches will only watch and possibly ask questions. Of course, the sooner you achieve autonomy, the better&mdash;no need to wait until Sprint 6.

Evaluation of your autonomy will include an assessment of your ability to define precise user stories, prioritize them in your PB, and scope them well enough to be broken down into Sprint tasks. We will also evaluate your ability to take on the right amount of work and deliver by the end of the Sprint a concrete value Increment.

## Grading

The breakdown of the team and individual grades for M2 is as follows:

| **Total Team Grade**                      | **100%** |
|-------------------------------------------|----------|
| Figma screens, wireframes, linking        |   10%    |
| Architecture diagram                      |   5%     |
| Sprint Backlog & Product Backlog          |   10%    |
| Implementation (APK, code quality)        |   40%    |
| Demo video                                |    5%    |
| Consistent delivery of value<sup>1</sup>  |    5%    |
| Scrum process (documents, autonomy)       |   25%    |

| **Total Individual Grade**                | **100%** |
|-------------------------------------------|----------|
| ≥3 high-quality code PRs                  |   35%    |
| ≥3 high-quality PR reviews                |   30%    |
| Individual Retrospective                  |   10%    |
| Participation and proactivity<sup>2</sup> |   25%    |

<sup>1</sup>
We will evaluate the work increment for each of your Sprints 4-6 and the amount of value it delivers to the app (seen through the perspective of the PB). You need to meaningfully increase the value of your app with every Sprint.

<sup>2</sup>
By participation and proactivity we understand task ownership (as in M1) plus contribution to the value of the app, proactivity within the team, quality of communication, and level of participation in the meetings with coaches. 
