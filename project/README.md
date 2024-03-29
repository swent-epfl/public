# EPFL Software Enterprise Project

_[updated 29.03.2024]_

CS-311 - The Software Enterprise (SwEnt) is a course that teaches you how to work efficiently in teams and how to build and ship software products. We will study a development process that is a simplified variant of [Scrum](https://www.Scrum.org/learning-series/what-is-Scrum/) and resembles closely how software is built in the real world. The outcome of the project will be an Android application of your own choosing, based on the finalized project proposal you submitted during the initial weeks of the course, but this is not an Android programming course.

## Learning Objectives

The SwEnt project teaches you the following:

- How to think, ideate, build and refine products that solve a real problem
- How to develop, as a team, code that is robust and maintainable
- How to plan development time to deliver value continuously
- How to review code and give constructive feedback
- How to employ an agile development method
- How to deal with common pitfalls of real-world software development: incomplete documentation, bugs in tools and libraries, code that works in one place but not another, etc.

## App Requirements

Your app is expected to meet basic requirements of functionality and resilience:  it must accomplish compelling tasks for clear use cases, be easy to use and consistent with the Android UX, and it must work in the face of user errors, malice, and external issues (e.g., lack of Internet connectivity), with a test suite to demonstrate that it does so.

The app must also meet the following SwEnt-specific requirements:

- Split app model: Your mobile app must use at least one public cloud service, such as Google Firebase
- Multi-user support: Your app must support multiple users and have a concept of authentication, for instance using Android’s built-in Google authentication
- Sensor use: Your app must use at least one phone sensor (e.g., GPS, camera, microphone) as part of a core feature of the app
- Offline mode: Your app must be usable without Internet connectivity, e.g., by paring down features compared to the normal experience and/or using cached data

Review the "Mobile Platform" lecture to understand these requirements better.

Unless absolutely needed, you should not write a backend that needs self-hosting/deployment. This avoids having the app stop working in the future because the backend is no longer maintained, and makes sure that the scope of the project enables you to complete it successfully by the end of the course.

> [!NOTE]
> You may choose to use Firebase cloud functions if you wish, but please discuss your use case with your coaches beforehand. You can go ahead only if they approve.

Security, privacy, vendor lock-in, etc. are crucial real-world aspects, but we do not spend much time on them in SwEnt.

Sensor usage should drive some key behavior and functionality in the app, such as finding nearby points of interest with the GPS, or augmenting reality by drawing over a video feed. Merely getting sensor data and storing it in a field shown to users is too simple and does not satisfy the SwEnt project requirements.

> [!WARNING]
> You can use open-source alternatives to Firebase, like `appwrite` or `supabase`, but:
> 
> 1. Let your coaches know that you will be using a Firebase alternative; and
> 2. Beware that using something other than Firebase means that the SwEnt staff will be able to give you only limited tech support, and so you will largely be on your own when dealing with issues related to the database and related testing.

## Starting the Project

1. Read the [handout for Sprint 1](./handouts/Sprint-one-handout.md); the list of TODOs will help you hit the ground running
2. Look throught the [sample Android project](https://github.com/swent-epfl/Android-Sample) with gradle files, a CI script, and recommended project structure is available. This can provide inspiration for setting up your own. 
3. For the first Sprint, your primary objective should be to ensure that the project is set up and everyone is in a position to start contributing.

The experience you gained during the bootcamp will help you move fast in the beginning of the project.

## Development Process

As described in the "Collaborative Software Development" lecture, the Scrum development process relies on three key roles:

The **Product Owner (PO)** is primarily responsible for gathering user feedback and insights. The PO represents the customer and decides how to prioritize the various features.

The **Developer** is an individual member of the dev team. Developers implement the requirements laid out in Sprint tasks that are created and put on the Sprint Backlog by the dev team. These result from Product Backlog items produced by the PO.

The dev team decides autonomously how much work it can take on in a Sprint, and is collectively responsible to finish on time and deliver value by the end of the Sprint. The **Scrum Master (SM)** acts as a coordinator, not a manager, to help the dev team succeed. The SM ensures that regular standups take place, and that the team functions smoothly: helps remove blockers, engages with the PO for clarifications, etc.

> [!NOTE]
> You have seen such tickets given as user stories in the [bootcamp](https://github.com/swent-epfl/bootcamp-template/blob/main/docs/bootcamp/UserStory.md).

### Starting a Sprint

Each Sprint in Scrum starts with a Sprint Planning meeting. During this meeting, the PO communicates the priorities for the items on the Product Backlog (PB), and the dev team commits to implementing during the Sprint the top N items on the PB, where N is decided by the dev team. 

Every PB item is typically accompanied by a user story (revisit the "Requirements" lecture for details); when necessary, a Figma design and/or a list of acceptance criteria is also included. When taking an item off the PB for implementation, the dev team breaks it down into Sprint tasks that go into the Scrum board in the Sprint Backlog, then assigned to Developers. For each Sprint task, the dev team creates a ticket in GitHub and estimates the time needed to complete that task.

> [!NOTE]
> You can expect your time estimates to be way off in the beginning of the project. As the course progresses and you acquire experience, these estimates should become increasingly more accurate.

### Working on Sprint Tasks

To begin working on a new task, you should first create a branch for the task, as per the "feature branch" workflow described in lecture. Push code frequently to the branch. Once the task is completed, including tests, open a pull request (PR). If you want early feedback on code that is not finished yet, use GitHub's "draft" PRs. Once you have at least one accepting code review from a teammate, and your code passes continuous integration (CI) checks, merge the PR and close the ticket. Review the "Collaborative Software Development" lecture for details.

Sometimes, you might need to create multiple PRs for a single task. For instance, if your task is to create a new module, and a teammate needs to use that module, you can create a PR with just the module’s interface, so that you can agree with your teammate on what the interface should be. Similarly, if you realize you will not have time to finish a task in the current Sprint, you can submit a PR with a polished version of a smaller part of the task, including tests for just that part. 

While writing code for a task, don’t "overengineer" it to meet hypothetical future needs. Keep it focused on the task at hand, while designing it to be easy to modify and maintain in the future.

> [!WARNING]
> Some frequent anti-patterns we see in inexperienced students include:
> 
> - Not pushing regularly
> - Submitting PRs for review shortly before a Sprint Review meeting
> - Submitting PRs with many unrelated (or only loosely related) changes bundled together
>
> These are bad practices. One of the things we look for when evaluating your work is whether you use good development practices. We will rely on the `git` history to assess your development practices, so please remember to use meaningful commit messages, push small, regular changes, and create reasonable and well-contained PRs.

### Code Reviews

Each pull request must be reviewed by at least one teammate, in a thorough and inquisitive fashion meant to uncover any bugs that lurk in the code, discuss design, and learn about changes. The SM ensures that devs review the PRs they are assigned to in a timely fashion, to not block other teammates.

Read the entire code, and comment on code that looks wrong or that you think could be improved. Ask questions when you do not understand a change. Remember to leave positive comments as well (e.g., congratulate the author for getting rid of an ugly hack). 

> [!NOTE]
> A couple of things to keep in mind:
> 
> - When reviewing code for a _new feature_, check if design patterns are properly used, and identify issues that may arise upon integration
> - When reviewing changes to _existing code_, the union of the code and the commit messages should explain the change in a way that will be understandable even a few months later

You can prefix your comments with one word indicating the kind of comment it is, such as "Important" or "Nitpick" or "Question". Try to use prefixes consistently. Your comments should talk about the code, not the author.  For example, "you're wrong" will put your teammate on the defensive and make her/him less receptive to what you say; instead, "have you considered what happens when..." or "a possible improvement is..." would be more constructive.

Revisit the "Collaborative Software Development" lecture for more tips on code reviews.

If you really have nothing to say, a simple “looks good to me” or “LGTM” is fine. This should only be the case for the occasional tiny pull request that fixes a simple bug, not for large changes for which there is always something to discuss and/or clarify.

In SwEnt, all code reviews should be done in English, the lingua franca of the software development world.

Here are some good examples of code reviews in past projects [
[1](https://github.com/epfl-SDP/android/pull/255),
[2](https://github.com/epfl-SDP/android/pull/410),
[3](https://github.com/PalFinderTeam/palFinder/pull/82),
[4](https://github.com/PalFinderTeam/palFinder/pull/302) ]
and some examples from large open-source projects [
[1](https://github.com/dotnet/runtime/pull/81725),
[2](https://github.com/dotnet/runtime/pull/72712),
[3](https://github.com/openjdk/jdk/pull/7431),
[4](https://github.com/ruby/ruby/pull/5002),
[5](https://github.com/lampepfl/dotty/pull/16612) ].

> [!NOTE]
> Your coaches will review your PRs in the initial weeks of the project in order to give you early feedback. We of course do not expect you to be code-review experts at the beginning of the course, but we do want to see you improve.


### Standup Meetings

You are expected to hold at least two Scrum standups a week outside the Friday meeting. As described in lecture, these meetings last a few minutes, never more than 15 minutes. In a Standup, each developer covers exactly three things: what they worked on since the previous standup, what they plan to work on next, and what impediments they are facing. 

For reasons of efficiency and time savings, Standups are not for extended discussion &ndash; those happen one-on-one aside from the standup. A Standup keeps the team in sync and identifies any blocking issues. Additionally, it helps the team plan how to remove impediments, such as by organizing a separate meeting to discuss design issues or asking one member to help another.

Your team should have at least two Standups per Sprint, at least one of which is fully in-person. The SM must ensure that these meetings happen. We will require the SM to submit a weekly meeting-minutes writeup of the Standups conducted during that Sprint, so that the coaches have visibility into how the Standups went.

If you find that your team is being inefficient, ask yourself whether there is sufficient intra-team communication.  Lack of communication is often a reason why teams that do not operate optimally. Reach out to your coaches if you need help.

### Sprint Debrief + Review + Planning

You will meet your SwEnt coaches every Friday to perform the Debrief and Review for the current Sprint, and the Planning for the next Sprint. In the Debrief you will demo your Increment and receive feedback from "the customer". In the Review you will go over how the Sprint went, what worked well, what didn't work well, and how to fix it. 

Your coaches are not there to judge you, they are a resource for you: they give you input on how you can resolve issues, and help eliminate any inefficiencies in your development process. By the end of the course, we want you to be able to conduct these meetings on your own. Note that it is not your coaches who will decide your final grades, that will be done by the SwEnt staff.

## Workload

SwEnt carries 8 ECTS credits.  According to [the EPFL guidelines](https://www.epfl.ch/education/teaching/teaching-guide-2/getting-started/design-a-course_1/#:~:text=A%20full%2Dtime%20student%20is,of%20student%20work%2C%20per%20week), this corresponds to 240 hours of total study time. If we are to divide this evenly over the 14 weeks of the semester, it comes down to an average of a bit over 17 hours/week.  This is a big chunk of time in which you can accomplish a lot, but can also get easily lost. To help you plan, below are some ideas for how to break down your weekly SwEnt time.

There are two major phases in the SwEnt project :

- Milestones M1 and M2: Building v.1 of your app, which you can think of as a proof of concept (PoC)
- Milestones M3 and M4: Finalize the PoC, while starting to learn about MVP (minimum viable product) and writing a PRD (product requirements doc) for the MVP 

### M1 and M2

During this time, you act as an individual contributor while learning how to engage in and contribute to team tasks. We recommend that you budget ~12h for individual contributions, ~3h for team contributions (planning, CI, QA, Figma, documentation, being Scrum Master, etc.), ~1h for your Scrum meetings during the week, and 1h for the Friday Sprint Debrief + Retrospective + Planning with your coaches. Below is a more detailed breakdown.

> [!NOTE]
> This is only indicative and will vary from team to team and week to week. If at any point you feel you are deviating significantly from this outline, please communicate with your coaches who will help you navigate better!

<table>
 <thead>
  <tr>
    <th>Task block</th>
    <th>Task</th>
    <th>Time</th>
    <th>Block time per week</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td rowspan="6">Design, infrastructure, organization<br>(each developer does a <i>subset</i> of these tasks every week)</td>
    <td>Figma</td>
    <td>1h30m</td>
    <td rowspan="6">3h</td>
  </tr>
  <tr>
    <td>Architecture diagrams / Schema planning</td>
    <td>1h</td>
  </tr>
  <tr>
    <td>PB maintenance as PO</td>
    <td>30m</td>
  </tr>
  <tr>
    <td>Manual QA (e.g., testing that the APK works)</td>
    <td>30m</td>
  </tr>
  <tr>
    <td>Act as SM</td>
    <td>1h</td>
  </tr>
  <tr>
    <td>CI, code maintenance (Sonar, coverage), etc.</td>
    <td>1h</td>
  </tr>
  <tr>
    <td rowspan="4">Implementation<br>(each developer does <i>every</i> task each week)</td>
    <td>Coding, testing, reading documentation, etc.</td>
    <td>10h</td>
    <td rowspan="4">12h</td>
  </tr>
  <tr>
    <td>Code reviews</td>
    <td>1h</td>
  </tr>
  <tr>
    <td>Task estimation + breakdown into Sprint tasks</td>
    <td>30m</td>
  </tr>
  <tr>
    <td>Shepherd your PRs (to get them merged)</td>
    <td>30m</td>
  </tr>
  <tr>
    <td rowspan="3">Scrum<br>(each developer does <i>every</i> task each week)</td>
    <td>Standup meetings (2x / week)</td>
    <td>30m</td>
    <td rowspan="3">1h</td>
  </tr>
  <tr>
    <td>Scrum board maintenance</td>
    <td>15m</td>
  </tr>
  <tr>
    <td>Individual retrospective</td>
    <td>15m</td>
  </tr>
  <tr>
    <td>Meeting with the coaches</td>
    <td>Sprint Review + Retrospective + Planning</td>
    <td>1h</td>
    <td>1h</td>
  </tr>
</tbody>
</table>


### M3 and M4

By now, you're becoming an expert in team work. You've spent a lot of time focused on development, and you will continue doing so. But some of the time you were spending on Figma, documentation, etc. will be devoted to writing a PRD for your MVP (~3h). To guide you in this effort, you will attend one lecture every week. Organization tasks should now take less time, because the experience you've accumulated will make you more efficient. 

<table>
  <thead>
    <tr>
      <th>Task block</th>
      <th>Task </th>
      <th>Time</th>
      <th>Time/block<br>per week</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="6"><br>Design, infrastructure, organization<br><font color="gray">(each developer does a <i>subset</i> of<br>&nbsp; these tasks every week)</font></td>
      <td>Figma </td>
      <td>30m</td>
      <td rowspan="6">1h</td>
    </tr>
    <tr>
      <td>Architecture diagrams / Schema planning</td>
      <td>30m</td>
    </tr>
    <tr>
      <td>PB maintenance</td>
      <td>30m</td>
    </tr>
    <tr>
      <td>Manual QA</td>
      <td>30m</td>
    </tr>
    <tr>
      <td>Act as SM</td>
      <td>1h</td>
    </tr>
    <tr>
      <td>CI, code maintenance (Sonar, coverage), etc.</td>
      <td>30m</td>
    </tr>
    <tr>
      <td rowspan="4">Implementation<br><font color="gray">(each developer does <i>every</i><br>&nbsp; task each week)</font></td>
      <td>Coding, testing, reading documentation, etc.</td>
      <td>9h</td>
      <td rowspan="4">11h</td>
    </tr>
    <tr>
      <td>Code reviews</td>
      <td>1h</td>
    </tr>
    <tr>
      <td>Task estimation + breakdown into Sprint tasks</td>
      <td>30m</td>
    </tr>
    <tr>
      <td>Shepherd your PRs (to get them merged)</td>
      <td>30m</td>
    </tr>
    <tr>
      <td rowspan="3">Scrum<br><font color="gray">(each developer does <i>every</i><br>&nbsp; task each week)</font></td>
      <td>Standup meetings (2x / week)</td>
      <td>30m</td>
      <td rowspan="3">1h</td>
    </tr>
    <tr>
      <td>Scrum board maintenance</td>
      <td>15m</td>
    </tr>
    <tr>
      <td>Individual retrospective</td>
      <td>15m</td>
    </tr>
    <tr>
      <td>Meeting with the coaches</td>
      <td>Sprint Review + Retrospective + Planning</td>
      <td>1h</td>
      <td>1h</td>
    </tr>
    <tr>
      <td rowspan="2">PRD<br><font color="gray">(each developer does <i>every</i><br>&nbsp; task each week)</font></td>
      <td>Lectures</td>
      <td>1h30m</td>
      <td rowspan="2">3h</td>
    </tr>
    <tr>
      <td>PRD writing</td>
      <td>1h30m</td>
    </tr>
  </tbody>
</table>

## Grading

There will be four milestones in the grading of your project. Each milestone will give you enough time to have a visible delta from the previous milestone. You can expect the pace of the project and team dynamics to change from milestone to milestone, as you and your team accumulate experience. The breakdown, as % of your final course grade, is the following:

<table>
  <thead>
    <tr>
      <th>Milestone</th>
      <th>Duration</th>
      <th>Individual grade</th>
      <th>Team grade</th>
    </tr>
    </thead>
    <tbody>
    <tr>
    	<td align="center">M1</td>
    	<td>3 weeks</td>
    	<td align="center">5%</td>
    	<td align="center">5%</td>
    </tr>
    <tr>
    	<td align="center">M2</td>
    	<td>3 weeks</td>
    	<td align="center">10%</td>
    	<td align="center">6%</td>
    </tr>
    <tr>
    	<td align="center">M3</td>
    	<td>2 weeks</td>
    	<td align="center">13%</td>
    	<td align="center">6%</td>
    </tr>
    <tr>
    	<td align="center">M4</td>
    	<td>2 weeks</td>
    	<td align="center">17%</td>
    	<td align="center">13%</td>
    </tr>
    <tr>
    	<td align="center"><strong>Total</strong></td>
    	<td><strong>10 weeks</strong></td>
    	<td align="center"><strong>45%</strong></td>
    	<td align="center"><strong>30%</strong></td>
    </tr> 	
  </tbody>
</table>

The grading of each milestone is designed such that you receive nearly full credit as long as you closely follow the Scrum process and you build and deliver value every Sprint. The exact breakdown for each milestone will be shared in due course. The percentages are not linear in the amount of time between milestones because we weigh different aspects differently as you gain experience (e.g., your ability to correctly estimate task duration is worth 0 for M1 but worth more for M4) and some aspects cumulate over time (e.g., how polished the features are matters little in early milestones but a lot more in M4). As a reminder, 5% of your grade will come from the bootcamp (individual), and 20% from the PRD (team).

If you have any questions, please do not hesitate to reach out to your coaches or ask on Ed Discussion.