## Milestone M3

_[updated 10.05.2024]_

The SwEnt project has four graded milestones (see [README](../README.md)). This handout concerns the third milestone.

The best way to "prepare" for a milestone is to work on your project according to what we teach in SwEnt: keep your backlogs and documentation up-to-date, follow the Scrum process diligently, make meaningful code contributions every Sprint, write good code and tests, do good code reviews, demo your app in every Sprint Review, be a good teammate, and so on.  If you do everything right, then there is little extra to do for each milestone&mdash;the milestones are just a way to ensure you stay on-track and operate at the right pace.

### Due Date

Friday 17.05.2024 @ 23.59 CEST

### Overview

Each milestone tracks the evolution of your experience and skills in SwEnt: [M1](m1-deliverables.md) focused on the foundational practices and team dynamics. [M2](m2-deliverables.md) built upon this foundation and emphasized achieving a good rhythm and consistently delivering continuous value. The M3 milestone marks the point where your team should hit its stride, and your productivity should be increasing rapidly. From now on, we will have a new milestone every two Sprints.

### M3 Objectives
				
__Maturing Backlog and Task-Management Skills__: Your ability to map user stories to tasks, and to break down tasks into units of predictable work, should be nearing perfection. For M3, you should be able to demonstrate improved productivity relative to M2 and improved quality of execution (well defined, self-contained PRs, high-quality code reviews, etc.).

__Maturing PoC__: As mentioned in the [MVP lecture](https://moodle.epfl.ch/pluginfile.php/3337623/mod_resource/content/1/WK11-MVP%20and%20Product%20Architecture.pdf), your app is a "proof of concept" (PoC). By the end of M3, your PoC should have at least two fully implemented epics with all the bells and whistles, your app should use the sensors effectively, and the only things that remain for the last two Sprints should be secondary user flows, stretch goals, and clean-up. You are delivering a demo of your app at every Sprint Review, and it's becoming smoother and more user-focused&mdash;by the time of the Battle of the Apps (BOTA), you will have the perfect demo. 

> [!NOTE]
> As announced in the [Intro lecture](https://moodle.epfl.ch/pluginfile.php/3317323/mod_resource/content/2/Wk1.1%20-%20Introduction%20%2B%20Requirements.pdf), the BOTA competition will allow you to showcase your app and compete with other teams for substantial prizes and SwEnt swag. It will take place on Thursday 30.05, at the tail end of your release Sprint.

### M3 Deliverables

Your _team_ will need to prepare the following items and submit their URLs via the [M3 team submission form](https://moodle.epfl.ch/mod/questionnaire/view.php?id=1295093): 

1. Updated Figma ➡︎ _figma.com_ (not graded)
2. Updated architecture diagram ➡︎ _your GitHub README_ (not graded)
3. Product Backlog ➡︎ _GitHub_
4. Sprint Backlog for Sprint 9 ➡︎ _GitHub_
5. Sprint tasks for Sprint 9 ➡︎ _GitHub_
6. CI with automated testing (>80% line coverage) and code complexity tracking (<50 per file) ➡︎ _GitHub_ and _SonarCloud_
7. Polished video of your app demo (≤2 minutes), aimed at potential customers ➡︎ _platform of your choice_
8. High quality APK showcasing 2 complete epics ➡︎ _GitHub_
9. Scrum process documents: 1 documented stand-up meeting per Sprint + 1 documented Retrospective per Sprint ➡︎ _Google sheets_ shared with the coaches
10. Team autonomy
11. Outline of your PRD ➡︎ _PDF file_ uploaded to Moodle

Additionally, each _individual_ student must prepare the following items and submit them via the [M3 individual submission form](https://moodle.epfl.ch/mod/questionnaire/view.php?id=1295094):

1. An individual Retrospective for each Sprint ➡︎ _Google sheet_ shared with the coaches
2. The PRs you created and were merged (≥3 PRs total, ≥1 each Sprint) ➡︎ _GitHub_
4. The PRs you reviewed (≥3 in total, ≥1 each Sprint) ➡︎ _GitHub_

The expectations for the quality of code, APK, testing, PRs, and code reviews is higher in M3 than in M2.

#### High Quality APK

Your app's APK should demonstrate the full functionality of both epic #1 and #2, and should be bug-free. By "full functionality" we mean that the UI connects to the true database, authentication is real, use of sensors is real, the app can be used reliably across multiple logins and multiple users, etc.  By this stage, your APK should already be able to demonstrate most of the initial value you set out to deliver. We reiterate that the quality standards are higher than for M2 (e.g., no crashes permitted). 

You must set up your repo with a GitHub workflow to build the APK automatically, on a [release branch](https://docs.github.com/en/repositories/releasing-projects-on-github/managing-releases-in-a-repository) called "M3". In the submission form on Moodle, provide the URL of the GitHub Actions workflow run that has the M3 APK in its artifacts. 

> [!TIP]
> Automatically remove old builds, otherwise you might run out of space on GitHub.

#### Code and Test Quality

You need to pay increasing attention to the reliability, security, and maintainability of your code. In this vein, you will start using SonarCloud's _cognitive complexity_ metric to assess the difficulty of understanding the code you wrote. This metric is an evolution of the classic cyclomatic complexity we taught in the [Testing Fundamentals lecture](https://moodle.epfl.ch/pluginfile.php/3322745/mod_resource/content/2/Wk2.2%20-%20Testing%20I%20-%20Fundamentals%20%28Spring%202024%29.pdf). By augmenting your integration with SonarCloud to track cognitive complexity, you will better understand how to refactor your code to make it easy to read and maintain. For M3, we expect each of your code files to have cognitive complexity less than 50. For a deeper understanding of the metric, you can read [the whitepaper](https://www.sonarsource.com/docs/CognitiveComplexity.pdf).

> [!TIP]
> The Sonar tool gives you source-code-level suggestions for how to reduce cognitive complexity. Just go to a Sonar run and navigate to _Measures &rarr; Complexity &rarr; Cognitive Complexity_, then open any file with high complexity and click on the dot next to a code block. Alternatively, you can go to _Issues &rarr; Adaptability_ and see the list of source-code locations that are increasing cognitive complexity.

Your testing needs to have reached an improved degree of thoughtfulness. You should be doing end-to-end testing of user flows as well as thorough unit testing. The minimum line coverage is 80%, but you should aim higher. Your automated tests should be thorough enough to ensure that the app APK runs reliably in the hands of users other than you.

#### Team Autonomy

The goal of SwEnt is to enable you, as a team, to run a software project A-to-Z on your own. For both Sprints leading to M3, you will conduct the Scrum ceremonies on your own, under the watchful eye of your coaches. They will assess your ability to define precise user stories, prioritize them in your PB, and scope them well enough to be broken down into Sprint tasks. They will also evaluate your ability to take on the right amount of work and deliver by the end of the Sprint a concrete value Increment.

#### Product Requirements Document (PRD)

It is time to start thinking about your PRD, which will be due at the end of the semester. To demonstrate that you have started thinking about it, we will ask you to submit an outline of the PRD with, at a minimum, the project name filled in, the correct titles of the 11 sections, and preferably some bullets with initial thoughts of what you will put in there. Please follow the instructions in the [`swent-epfl/prd`](https://github.com/swent-epfl/prd/) repo to produce the deliverable in PDF format. Don't leave this for the last minute.

## Grading

The breakdown of the team and individual grades for M2 is as follows:

| **Total Team Grade**                      | **100%** |
|-------------------------------------------|----------|
| Sprint Backlog & Product Backlog          |   20%    |
| APK quality                               |   30%    |
| Code quality                              |    5%    |
| Test quality                              |   10%    | 
| Demo video                                |    4%    |
| PRD outline                               |    1%    |
| Scrum process (documents, autonomy)       |   30%    |

| **Total Individual Grade**                | **100%** |
|-------------------------------------------|----------|
| ≥3 high-quality code PRs                  |   30%    |
| ≥3 high-quality PR reviews                |   24%    |
| Individual Retrospective                  |    6%    |
| Participation<sup>1</sup>                 |   15%    |
| Ownership and leadership<sup>2</sup>      |   25%    |  

<sup>1</sup>
This refers to consistent participation in the creation of value, to quality of communication, supportiveness for the rest of the team, and contributions during the Scrum ceremonies. 

<sup>2</sup>
M3 will significantly reward a "get things done" attitude: doing your tasks on-time as opposed to last-minute, doing a great job as SM and PO, going out of your way to contribute to the team's objectives, taking initiative for improving your team's development process, etc. We look for demonstrated leadership in at least one of the activities you undertake for your team.
