# Software Enterprise Project

_Last updated: September 29, 2025_

## Table of Contents

- [Learning Objectives](#learning-objectives)
- [The Process](#the-process)
  - [Sprint Review](#sprint-review)
  - [Sprint Retrospective](#sprint-retrospective)
  - [Sprint Planning](#sprint-planning)
- [Working During a Sprint](#working-during-a-sprint)
  - [Doing Sprint Tasks](#doing-sprint-tasks)
  - [Reviewing Code](#reviewing-code)
  - [Stand-Up Meetings](#stand-up-meetings)
  - [Using AI](#using-ai)
- [Milestones](#milestones)
  - [M1 and M2](#m1-and-m2)
  - [M3](#m3)

<hr>

This project is an integral part of the [CS-311: The Software Enterprise](../README.md) experience.
It is here where "the rubber meets the road," where you apply what you learned about how to work efficiently in teams and to build software products.

## Learning Objectives

- How to think, ideate, build and refine products that are *real* solutions to *real* problems
- How to develop, as a team, code that is robust and maintainable
- How to plan development time to deliver value continuously
- How to review code and give constructive feedback
- How to employ an agile development method
- How to deal with common pitfalls of real-world software development, such as incomplete documentation, bugs in tools and libraries, or code that works in one place but not another

## The Process

We employ a simplified but realistic variant of Scrum.

Before your first Sprint, you need to do your [Warmup](./Warmup.md).  Pun intended.  That document provides a link to a sample Android project that can provide inspiration for your own.

Each Sprint concludes with a collaborative session with your coaches on Friday of that week. This session focuses on the three end-of-Sprint ceremonies. The Scrum Master (SM) should initiate and moderate the discussion during each ceremony.

### Sprint Review
- __Sprint Goal__ (SG): The primary focus of the Review is on whether the previously defined SG was achieved, so start by discussing the SG and how the completed work contributes to it. If you didn't define a concrete SG for your first Sprint, no worries, but make sure you do it for every Sprint thereafter.
- __Increment__: Stakeholders (in this case, the coaches) inspect the Increment and provide feedback on its functionality, usability, and completeness. Normally this would include a demo. Ask the coaches questions you have about the app's functionality. Don't panic if you have nothing to demo in your first Sprint, you're still learning. 
- Review __completed tasks__ with the coaches, and make sure that both time estimates and actual time spent are recorded. Give/receive feedback on design, process, and progress. Move issues to _Done in S1_ status.
- Go over the SM's __minutes of the stand-up meetings__.
- Product Owner (PO) discusses relevant changes that could influence future development, such as maturing thoughts on the app and its audience. In the real world, the PO could bring in __updates on the market or business environment__, competitors, etc.
- PO revises with the team the __Product Backlog__ to reflect the feedback received and any new insights gained during the Sprint. Potentially revise development plans for the project as a whole.

### Sprint Retrospective

The goal of the Retrospective is to inspect and adapt the team's processes for continuous improvement. It is crucial that this happen in a safe and open environment, where everyone feels comfortable sharing their thoughts. Reflect on how well the team worked together (including communication, roles, and responsibilities) and how the collaboration led to the Increment. Internalize the deep connection between the team's collaboration &amp; processes and the resulting Increment. 

- __What went well__: Team discusses the positive aspects of the Sprint, identifying successful practices and approaches.
- __What did not go well__: Openly discuss the challenges, obstacles, and areas for improvement encountered during the Sprint. Be honest about challenges, even if they seem minor&mdash;early identification of issues can prevent them from becoming bigger problems later.  As part of this, discuss the previous Sprint's tasks that were not completed, to understand why.
- __Improvement opportunities__: Team brainstorms on how to address issues and enhance the process, tools, and collaboration. If you come up with many points, prioritize which action items to focus on first, so that you tackle the most impactful ones in the next Sprint. If you identify a couple key points to improve for the next Sprint, it's already great.
- __Action items__: Team agrees on specific, actionable steps they will take to improve in the next Sprint. These get captured in a _**Team Retrospective**_ document that you should link from your project's GitHub wiki. (A link individualized for your team will be provided.)

We also ask that each team member do an _**Individual Retrospective**_ (link will be provided). This self-assessment is not part of standard Scrum, but it is a key ingredient to improving yourself as a professional, so you should develop the habit of doing such retrospectives regularly.

### Sprint Planning

Having reflected on the previous Sprint, you are now ready to plan the next one:

- __Define the SG__: The PO proposes the SG, and the team collaborates to refine and finalize it. You need this in order to guide the team's efforts toward a common goal. It should be concise and specific, outlining the desired outcome of the next Sprint.
- __Select PB items__: Team reviews the prioritized PB and selects items that align with the SG _and_ can realistically be completed within a 1-week Sprint. Every PB item is typically accompanied by a user story (see the [Requirements](../README.md#schedule) lecture) and, when necessary, a Figma design and/or a list of acceptance criteria along with a definition of Done. The selection of PB items should take into account not only the team's work capacity but also dependencies and the definition of Done.
- __Sprint Backlog__ (SB): For each selected PB item, break it down into Sprint tasks, and create an issue in GitHub for each one.  Estimate the effort (in person-hours) needed to complete each task. Keep an eye on overall workload. Populate the SB in your Scrum board with these tasks. The SB will help you track progress, identify dependencies, and ensure that everyone understands the work involved.
- __Assign tasks__: Decide who will take on which specific tasks. Keep an eye on workload distribution and individual expertise; adjust estimated effort if warranted. Discuss the overall approach to the work, identifying any potential roadblocks or dependencies. At the end of this exercise, the team makes a collective commitment to deliver the chosen PB items.
- __Clarifications &amp; Risk__: All uncertainties or ambiguities regarding the selected PB items need to be clarified during Sprint Planning. Give ample thought to potential risks or dependencies that could impact the Sprint, and develop mitigation strategies if necessary.

> [!IMPORTANT]  
> The dev team decides autonomously how much work it can take on in a Sprint, and is collectively responsible for finishing on time and deliver value by the end of the Sprint.  It is not the coaches who decide or impose the workload.

> [!NOTE]
> You can expect your time estimates to be (way) off in the beginning of the project. As the course progresses and you acquire experience, these estimates should become increasingly more accurate, and be spot-on by the end of the semester.

## Working During a Sprint

### Doing Sprint Tasks

To begin working on a new task, you should first create a branch for the task, as per the "feature branch" workflow described in the [Collaborative Development](../README.md#schedule) lecture. Push code frequently to the branch. Once the task is completed, including tests, open a pull request (PR).  The tests that go with the feature will be in separate commits, and potentially worked on by different people, but should be part of the same PR as the feature. If you want early feedback on code that is not finished yet, use GitHub's "draft PRs". Once you have at least one accepting code review from a teammate, and your code passes your CI checks, merge the PR and close the corresponding issue.

Sometimes, you might need to create multiple PRs for a single task. For instance, if your task is to create a new module, and a teammate needs to use that module, you can create a PR with just the module’s interface, so that you can agree with your teammate on what the interface should be. Similarly, if you realize you will not have time to finish a task in the current Sprint, you can submit a PR with a polished version of a smaller part of the task, including tests for just that part.

While writing code for a task, don’t "over-engineer" it to meet hypothetical future needs. Keep it focused on the task at hand, while designing it to be easy to modify and maintain in the future.

> [!WARNING]
> Some frequent anti-patterns we see in inexperienced students include:
>
> - Making giant commits
> - Not pushing regularly to the repo
> - Submitting PRs for review shortly before a Sprint Review
> - Submitting PRs with many unrelated (or only loosely related) changes bundled together
>
> These are bad practices. One of the things we look for when evaluating your work is whether you use good development practices. We will rely on `git` history to assess your development practices, so please remember to use meaningful commit messages, push small, regular changes, and create reasonable and well-contained PRs.

### Reviewing Code

Each PR must be reviewed by at least one teammate, in a thorough and inquisitive fashion meant to uncover any bugs that lurk in the code.
The review should discuss both the design and the implementation.
The SM ensures that developers review the PRs they've been assigned in a timely fashion, to not block other teammates.

Read the entire code, and comment on code that looks wrong or that you think could be improved.
Ask questions when you do not understand a change.
Remember to leave positive comments as well (e.g., congratulate the author for getting rid of an ugly hack).

> [!NOTE]
> A couple of things to keep in mind:
>
> - When reviewing code for a _new feature_, check if design patterns are properly used and identify issues that may arise upon integration.
> - When reviewing changes to _existing code_, the union of the code and the commit messages should explain the change in a way that will be understandable even several months later.

You can prefix your comments with one word indicating the kind of comment it is, such as "Important" or "Nitpick" or "Question". Use prefixes consistently. Remember that your comments should talk about the code, not the author.
Review the code reviewing section of the [Collaborative Development](../README.md#schedule) lecture for many more tips on code reviews.

If you really have nothing to say, a simple LGTM (“looks good to me”) is fine.
But this should only be the case for the occasional tiny pull request that fixes a simple bug, not for large changes for which there is always something to discuss and/or clarify.

In SwEnt, all code reviews should be done in English, the lingua franca of the software development world.

Here are some good examples of code reviews in past SwEnt projects [
[1](https://github.com/epfl-SDP/android/pull/255) ,
[2](https://github.com/epfl-SDP/android/pull/410) ,
[3](https://github.com/PalFinderTeam/palFinder/pull/82) ,
[4](https://github.com/PalFinderTeam/palFinder/pull/302) ]
and some examples from large open-source projects [
[1](https://github.com/dotnet/runtime/pull/81725) ,
[2](https://github.com/dotnet/runtime/pull/72712) ,
[3](https://github.com/openjdk/jdk/pull/7431) ,
[4](https://github.com/ruby/ruby/pull/5002) ,
[5](https://github.com/lampepfl/dotty/pull/16612) ].

> [!NOTE]
> Your coaches will give you feedback on your PRs, so please do them with care. You are not expected to be code-review experts from the beginning of the course, but we do want to see you achieve expert level by the end of the semester.

### Stand-Up Meetings

You are expected to hold **at least two Scrum stand-ups** a week outside the Friday meeting, at least one of which is in-person. As described in the [Collaborative Development](../README.md#schedule) lecture, these meetings last a few minutes, never more than 15 minutes. The SM is responsible to make sure that these happen. We will provide _**a template**_ for the SM to take minutes of the meetings; this helps keep things organized and gives coaches visibility into how things are going.

For reasons of efficiency and time savings, stand-ups are not for extended discussions&mdash;those happen one-on-one outside the team-wide stand-up.
The SM is responsible to coordinate the removal of impediments (e.g., by organizing a separate meeting to discuss specific design issues), and all team members are responsible for doing their utmost to remove those impediments.

If you find that your team is being inefficient, ask yourself whether there is sufficient intra-team communication.  Lack of communication is the number-one reason why teams operate poorly. Reach out to your coaches if you need help.

### Using AI

AI tools can be powerful accelerators of your work and, as said in lecture, you are encouraged to use them.
But they are not a substitute for your own understanding. 
If you lean on them blindly, you’ll usually create more work for yourself (and your teammates). 
Follow the workflow shown in the first lecture to make AI work _for_ you, not _against_ you.

> [!WARNING]
> As mentioned [here](https://github.com/swent-epfl/private/blob/main/faq.md#how-can-i-accurately-acknowledge-contributions-to-my-codebase), 
you must always acknowledge the use of AI, or else it will be considered plagiarism.

Think of AI as a summer intern: it can write boilerplate code, draft, review and suggest things, etc. but you are the senior engineer. You are responsible for quality, clarity, and correctness of everything you commit.

Coaches will regularly ask you to justify your work. For example: 

- Walk me through what this code does...
- Why did you design it this way?
- Why did you pick this API or framework?
- Why did you say this in your PR review?
- How would you implement this suggestion you wrote in your review?

If you cannot explain or defend what you wrote, it will count against you, regardless of who/what wrote it.  In summary:
- Use AI to explore, draft, and accelerate
- Acknowledge AI every time it contributes
- Own your output: you must understand and be able to justify everything in GitHub or in Scrum documents

## Milestones

The project is divided into three milestones, and at each milestone we will provide you with more formal feedback than during the weekly meetings, along with a grade.
Each milestone gives you the opportunity to demonstrate a significant delta relative to the previous milestones, so you should formulate your SGs in such a way that you accomplish this.
The pace of the project and team dynamics will change as you progress through the milestones, as you and your team accumulate experience. 
The [milestone weights](../README.md#grading) are not linear in the number of Sprints because we weigh different aspects differently as you gain experience (e.g., we don't expect you to be able to estimate task effort well during M1, but during M3 you should already be very good at it).

Your [17 hours/week](../README.md#workload) devoted to SwEnt is a big chunk of time in which you can accomplish a lot, but you can also easily waste the hours on things that are less consequential. To help you plan, we give you below a tentative break-down of your time among the various kinds of tasks.

### M1 and M2

During this time, you focus on being an individual contributor while learning how to engage in and contribute to team tasks.
We recommend that you budget ~12h for individual contributions, ~3h for team contributions (planning, CI, QA, Figma, documentation, Scrum Master, etc.), ~1h for your Scrum meetings during the week, and 1h for the Friday ceremonies with your coaches. One possible way to divide the time is as follows:

> [!NOTE]
> This is only indicative and will vary from team to team and week to week. If at any point you feel you are deviating significantly from this outline, please communicate with your coaches who will help you navigate better!

<table>
 <thead>
  <tr>
    <th>Task block</th>
    <th>Task</th>
    <th>Time</th>
    <th>Budget per week</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td rowspan="6">Design, infrastructure, organization<br><font color="gray">(each developer does a <i>subset</i> of these tasks every week)</font></td>
    <td>Figma</td>
    <td>1h30m</td>
    <td rowspan="6">≤3h per person</td>
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
    <td rowspan="4">Implementation<br><font color="gray">(each developer does <i>every</i> task each week)</font></td>
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
    <td rowspan="3">Scrum<br><font color="gray">(each developer does <i>every</i> task each week)</font></td>
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


### M3

As you head toward the final milestone and the Battle of the Apps, you're becoming an expert in team work. You've spent a lot of time focused on development, and you will continue doing so, but the time you were spending on Figma, documentation, etc. will reduce. Organization tasks should now take less time, because the experience you've accumulated makes you more efficient.

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
      <td rowspan="6"><br>Design, infrastructure, organization<br><font color="gray">(each developer does a <i>subset</i> of these tasks every week)</font></td>
      <td>Figma </td>
      <td>30m</td>
      <td rowspan="6">≤1h per person</td>
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
      <td rowspan="4">Implementation<br><font color="gray">(each developer does <i>every</i> task each week)</font></td>
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
      <td rowspan="2">Battle of the Apps<br><font color="gray">(this is optional, and thus not graded)</font></td>
      <td>Coding, testing</td>
      <td>1h30m</td>
      <td rowspan="2">3h</td>
    </tr>
    <tr>
      <td>Presentation</td>
      <td>1h30m</td>
    </tr>
  </tbody>
</table>

If you have any questions, please see the [FAQ](../faq.md) and/or reach out to your coaches and/or ask on Ed.
