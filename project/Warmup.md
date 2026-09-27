# Project Warmup

_Last updated: September 26, 2026_

## Table of Contents

- [Initial Setup](#initial-setup)
- [Preparation for Sprint 1](#preparation-for-sprint-1)
- [After the First Coaching Meeting](#after-the-first-coaching-meeting)

<hr>

Welcome to the first step in your project, where you will use software to solve a _real_ problem for _real_ people.
This checklist will guide you through some preparatory steps that will set you and your team up for success.
These steps are intended to be taken **prior** to the first formal meeting with your coaches&mdash;at that meeting, you will plan your Sprint 1.
Feel free to paste this document into a GitHub issue and check the tasks off as they are completed.

The goal of this warmup is to:
- Ensure that your team has a good collaborative setup; and
- Be ready to plan. As the saying goes, _the difference between a dream and a goal is a plan._  While dreams and goals may start as similar ideas, a plan is what turns a dream into an achievable, concrete goal. So you need to lay the groundwork for your project by setting up tools, planning tasks, and preparing for the first coaching meeting.

After the exam, take a short break, then do the [initial infrastructure setup](#initial-setup), and then meet as a team in-person to [prepare for Sprint 1](#preparation-for-sprint-1).
In your first informal meeting with the coaches, you already got to know each other and familiarized yourselves with the preparation tasks.
The Warmup is due **Fri 2-Oct at 08:45**, at your first _formal_ coaching meeting, where you will plan Sprint 1; by then, your entire project must be ready to go.

## Initial Setup

**1. Set up Team Communication:**
To ensure smooth collaboration throughout the semester, you need to have a reliable way to communicate with your team members and coaches.
- [ ] Join the SwEnt Discord using the invitation link posted on Moodle. You can use Discord to communicate with your coaches as well as with other students.
- [ ] See the `#announcements` channel for details on how to join your group's personal channel. 
- [ ] If any of your team members are not present on Discord, contact them and remind them to join.

**2. Set up GitHub:**
GitHub provides many tools to help manage your project efficiently. Do the following to set it up (we let you research how to do these things):
- [ ] Create a GitHub organization with all team members, your coaches, head TA Zhekai Jiang (GitHub ID _zhekai-jiang_), and Prof. Candea (GitHub ID _candea_) in it.
- [ ] Create a project repository; make sure it's public.
- [ ] Grant the _Maintain_ role on the repository to your coaches, Zhekai, and Prof. Candea, so they can give you the right level of help.
- [ ] Set up branch protection rules:
     - No direct push to `main`
     - Require pull request reviews with at least one reviewer
     - Require status checks before merging (e.g., Android tests)
- [ ] Add the description of your app to the README of the new repository.

**3. Initialize the Project:**
- [ ] Initialize the Android project in GitHub using your own bootcamp, or our [sample Android project](https://github.com/swent-epfl/Android-Sample).
- [ ] Make sure your repository has a `.gitignore` for Android projects (the sample project already includes one).
- [ ] Make sure all team members can clone the repository and run this new project locally.
- [ ] Add an `AGENTS.md` at the root of your repository with the rules your coding agents must follow (architecture, how to run `./gradlew check`, commit conventions, how to acknowledge AI), like in the bootcamp. Optionally, add your team's code-review checklist as a skill in `.github/skills/`.
- [ ] Set up your cloud backend (Firebase or Supabase), including API keys. For backend code, you'd normally configure secrets via Firebase config or a secrets manager, instead of putting them in the repo, but for a frontend app, API keys can remain in config since they aren’t secret. The one exception is the Supabase `service_role` key: it bypasses all access rules, so never put it in the app, and enable Row Level Security on every table.

> [!NOTE]
> Firebase Auth and Firestore work on the free Spark plan, with no credit card needed. Cloud Storage (videos, documents, etc.) and Cloud Functions need the Blaze plan, which requires a credit card (new accounts get a time-limited $300 trial credit). If you upgrade, set a budget alert.
> If you are not comfortable with that, Supabase is a good alternative (auth, SQL database, storage), and your MVVM architecture stays the same. But keep in mind:
> - the bootcamp, the sample project, and the Firebase emulator are Firebase-based, so you will have less starter code and a different test setup;
> - Firestore gives you offline support for free, whereas with Supabase you have to implement local caching yourself (e.g., with Room) to meet the offline-mode requirement.
>
> Tell your coaches early if you go with Supabase.

**4. Set up a Scrum Board:**
Having this is essential for managing collaborative work, and it will significantly boost your team's efficiency. Here are our suggestions:
- [ ] Create a project in your GitHub org to manage your Scrum board.  Take a look at the [scrumboard in the sample Android project](https://github.com/orgs/swent-epfl/projects/17) for inspiration.
- [ ] Add the following columns to your board:
     - `Product Backlog` for the user stories that define your application
     - `Sprint Backlog` for the tasks to be completed during the current Sprint
     - `In Development` for the tasks that are currently being worked on
     - `In Review` for the tasks under review by other team members before being merged
     - `Done in Si` for tasks completed in Sprint _i_, where _i = 1, 2, ..., 10_.
- [ ] Define properties for tasks on the Scrum board:
     - `Sprint` to identify the sprint to which that task belongs
     - `Type` (e.g., Frontend, Backend, Figma)
     - `Priority` (e.g., P0, P1, P2)
     - `Nature` (e.g., User Story, Sprint Task)
     - `Epic` to group tasks under relevant epics, or as technical/miscellaneous
     - `Assignee` to identify who is responsible for the task
     - `Estimated Time` where you will put your best guess as to how many person-hours it will take to complete the task
     - `Actual Time` for recording the time it effectively took to complete the task
- [ ] Create several views for your Scrum board:
     - *Global* : overview of all tasks across all Sprints
     - *Sprint* : view focused on the current Sprint's backlog and tasks
     - *Planning* : view for Sprint planning, with backlogs and user stories filtered
     - *My Tasks* : personalized view showing tasks assigned to each individual

**5. Set up your CI:**
- [ ] Set up a CI pipeline to run tests on your repository
- [ ] Integrate [SonarCloud](https://sonarcloud.io) for code quality checks. It is free for public repositories, but the free plan is limited to 5 members; adding our account as an administrator lets us move you to the SwEnt enterprise plan. An **owner of your GitHub organization** should:
     1. Create a SonarCloud organization by importing the GitHub organization of your SwEnt project, and select **only your project repository**.
     2. Analyze your repository **With GitHub Actions**, and keep the organization and project keys that SonarCloud proposes.
     3. In `Administration` > `Members`, add `justin.favey@epfl.ch` and put it in the `Owners` group. Keep it there all semester.

**6. Set up Figma:**
You will use Figma to create mockups and track design work
- [ ] Create a Figma project and share it with the entire team
- [ ] Link the Figma file from your project's README
- [ ] Ensure all team members have edit access and can access Figma in dev mode (Dev Mode requires a paid seat, which you can get for free with the [Figma Education plan](https://www.figma.com/education/))
- [ ] Ensure your Figma is publicly accessible, so that the course staff have access to it

**7. Connect your project to Steve:**
Do this last: Steve checks your GitHub organization, your repository and your SonarCloud setup. Its Technical setup screen opens once your app description has been approved.
- [ ] An **owner** of your project's GitHub organization clicks **Install the Steve app** on that screen, installs it on your organization, and gives it access to your project repository and no other.
- [ ] Steve then tells you what is missing. Fix it and run the checks again until everything is green.

## Preparation for Sprint 1

Organize an in-person, all-hands meeting of your team.
During this meeting you should:

**1. Define Process**

- [ ] Define a clear _code review process_ and set expectations for what a good pull request should look like (see [these guidelines](./README.md#reviewing-code)).
- [ ] Agree on a communication protocol for handling complex merges or potential conflicts.
- [ ] Create branch naming conventions (e.g., `feature/feature-name`, `bugfix/issue-number`, etc.).
- [ ] Decide on the time and place of your regular Stand-Up meetings; these meetings are crucial to keeping the team on track.
- [ ] Each member should have a clear time budget for working on the project (see [this example](./README.md#m1-and-m2)); discuss any exceptions.
- [ ] For each Sprint, one of you will have to be Scrum Master and another will be Product Owner.  Discuss how you want to rotate these roles, such that each team member gets as much practice with these roles as possible.  (In SwEnt, the SM and PO will also be Developers during the Sprint, just not at 100%.)

**2. Risk Planning:**
- Identify potential risks early on, such as unfamiliar technology, and document them.
- Consider whether the team has the necessary knowledge and resources to overcome these risks (e.g., finding and using an API for the idea you want to implement). Evaluate factors such as whether the API is publicly available, its cost, whether it meets the project's requirements, and if it can be easily integrated into your solution.

**3. Plan Sprint 1**

While the formal Sprint planning will occur during the first formal meeting with your coaches, you should do the following in advance:
- [ ] Populate the Product Backlog with your initial user stories, ensuring they are well-defined and prioritized.
- [ ] Break down the highest-priority user stories into Sprint Tasks, add them to the Scrum Board, and assign them to team members.
- [ ] Ensure that each team member has *at least one assigned task* before the Friday with your coaches.
- [ ] Nominate a Scrum Master for Sprint 1.
- [ ] Start developing Figma wireframes for the main screens to outline the user interface and experience.

After every meeting, you will need to keep track of all important decisions in one place. This will help team members refer back to them when needed, ensuring that everyone knows how to handle defined procedures and avoid confusion. A good place to define this is in the Wiki of your project repository in GitHub. Capture in this Wiki the results of this first team meeting (decisions, code review processes, communication protocol, naming conventions, etc.) Make it a habit to update the Wiki as new decisions are made in the team.

**4. Prepare for the Coaching Meeting**

- [ ] Finalize the project setup so you can present your progress to your coaches.
- [ ] Ensure your Scrum board is up to date with tasks and progress.

## After the First Coaching Meeting

 - [ ] Make sure you have a Scrum Master (SM) from among the team members
 - [ ] Make sure you have a Product Owner (PO) from among the team members
 - [ ] Make sure all the infrastructure is set up, and the CI is running
 - [ ] Have at least two in-person Stand-ups before the next Friday
 - [ ] The SM keeps minutes of the Stand-ups meetings (see [README](./README.md) for details)
 - [ ] Ensure that the Scrum board is updated regularly
 - [ ] When you complete a task, submit a PR as described in the [README](./README.md)

By following this checklist, your team will be well prepared to collaborate effectively, initiate your project successfully, and make the most of your Sprint 1 planning meeting.
