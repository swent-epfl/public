## Sprint 1 Handout: Android Development and Scrum Management

### Overview

_[15.03.2024]_

Welcome to Sprint 1. 

This handout describes a list of TODOs you can follow to get started with your project. We have also setup a Discord Server that has the entire SwEnt Staff. There are channels for every team, and your coaches are already on it. You can join Discord [here](https://discord.gg/tXtPWcG6ak). Throughout the project, we will primarily use Discord for quick communication and Tech Support.

>[!NOTE]
> Please use Discord in priority for all project related question and ED discussion for general question about the class

### Getting Started

To get started with your project as a team, you need two things - 

1. A collaborative working environment.
2. An initial plan!
   
To help you with these, we have put together a checklist that will help you get started. You need to go through the following setup steps so that you are in a good position to work on the project efficiently.

1. **Version Control System (VCS) Setup**: Ensure that all team members are familiar with Git commands and workflows. This includes branching strategies, merge requests, and conflict resolution. [See list one below](#setup-github).
   
2. **Initial Product Backlog**: Create a SCRUM board. Populate your product backlog with User Stories identified during project ideation. Follow the guidelines for writing good user stories as discussed in the lecture. [See list two below](#setting-up-a-scrum-board). 

3. **Wireframes**: Utilize Figma to create wireframes of your application. This step is essential for visualizing the user interface and planning the user experience early in the development process. [See list three below](#setup-figma).

4. **Project Initialization**: Start with a simple skeleton project. This should be similar to something you've already done in your bootcamp, providing a familiar structure to build upon. Once the project boilerplate is in place, and everyone has it working locally, moving forward in the project will be simpler. [See list four below](#project-initialization).

## Checklists for Starting the Project:

### Setup Github

- [ ] Set up a Github Organization.
- [ ] Create a project repository for your application code.
- [ ] Keep the repository public for when you will integrate SonarCloud.
- [ ] Ensure all team members have access.
- [ ] Add your coaches to your github organization.
  - [ ] Give them `maintain` access :) 
- [ ] Setup Branch Protection Rules on your Github Repo.
  - [ ] Pushing to `main` or `master` is not allowed.
  - [ ] Enable `Require pull request reviews before merging` with `1` review for approval.
  - [ ] Enable `Require status checks to pass before merging` and ensure that your Android tests are added to the status checks
  - [ ] Enable `Do not allow bypassing the above settings`. None of the team members should be allowed to push unapproved changes.

### Setting up a SCRUM Board

A SCRUM board is your holy grail for implementing a collaborative workflow. As you will see in the semester, maintaining your SCRUM board diligently will give a significant boost to your efficiency as a team.

- [ ] Create a Project under your Github organization for maintaining your SCRUM board.
- [ ] Add columns for :
  - [ ] Product Backlog
  - [ ] Sprint Backlog
  - [ ] In Development
  - [ ] In Review
  - [ ] Done in “Sprint #X”
- [ ] Add Properties For tickets on the board - 
  - [ ] Sprint (iteration)
  - [ ] Task Type (e.g., Frontend, Backend, Figma, etc.)
  - [ ] Nature (e.g., User Story, Sprint Task)
  - [ ] Epic (categorize tasks under relevant epics or as technical/miscellaneous)
  - [ ] Assignee
  - [ ] Views
    - [ ] **Global**: Overview of all tasks across all sprints.
    - [ ] **Sprint View**: Focused view on the current sprint’s backlog and tasks.
    - [ ] **Planning**: View for sprint planning, including backlogs and "user stories" filtered.
    - [ ] **Me**: Personalized view showing tasks assigned to the individual.
- [ ] Create initial product backlog items, ensuring they are well-defined and prioritized.

### Setup Figma

- [ ] Create a figma project and share with the rest of the team. 
- [ ] Ensure everyone has access to Figma and link it in the project’s README.
- [ ] Ensure all team members have access to the figma, and are able to create their own forks of it, for when they need to get exact styling and fonts.
  - Having their own figma forks out of sync is a common mistake that teams often make in the beginning. Please try to avoid this anti-pattern.
> [!WARNING]
> It is important to note that working solely on figma and design for the entire semester (or even for an entire Milestone is unacceptable and will be penalized in this course). Figma work is important and part of the evaluation, however doing _only figma_ will do more harm than good. 

#### CI Setup

- [ ] Setup a test running CI for running tests for your project. 
  - To help you with this, we have setup a sample Android Project repository [here](https://github.com/swent-epfl/Android-Sample). You are welcome to refer to it for inspiration.
- [ ] Integrate [SonarCloud](https://docs.sonarsource.com/sonarcloud/getting-started/github/) for code quality checks.
> [!NOTE]
> SonarCloud is free for public repos.

### Project Initialization

- [ ] Initialize the project repository with a basic android app skeleton.
  - Your bootcamp code can be a good starting point for this as well.
  - We have provided a sample project repository [here](https://github.com/swent-epfl/Android-Sample). 
- [ ] Find and add a good `.gitignore` for your Android Project.
- [ ] Make sure everyone has the common project running locally.
- [ ] Set up Firebase, including API keys.
- [ ] Add deploy secrets to your repo.
> [!WARNING]
> Do not check-in API keys into your VCS. There should be a `.env` file in your `.giignore` that prevents accidental pushes, and you should use that file to store them when developing locally.

## Sprint 1 Tasks

The below tasks, in addition to the checklist above, are given to help you with the plan (pt2 mentioned above).

- [ ] Start developing wireframes on Figma for the landing screen to outline the user interface and experience.
  - It will be good to have at least the initial few screens designed on figma so that you can work on them in Sprint 2. 
- [ ] Implement Google Authentication for your application.

## Standup Meetings

Regular communication is key to a successful Scrum team. For this sprint:

- Nominate a Scrum Master amongst the team members.
- Plan an initial setup meeting before Friday to ensure everyone is on the same page and technical environments are configured correctly.
- Ensure each team member has at least one task to complete before the Friday meeting with coaches.
  - This task should reflect on the SCRUM board.
  - Once done, a PR should be raised for it as descried in the [process workflow](../README.md/#working-on-sprint-tasks).

> [!NOTE]
> The Scrum Master should write down minutes of the standup meeting. We have created a template for taking minutes. It is available [here](https://docs.google.com/spreadsheets/d/1qgPaKuiMlu4J4IG_mdkGi_TnweDqm---ZZDY71DqFU4/edit#gid=0). You should make a copy of this template, add it to the github wiki and share access with your coaches.

## Ending Sprint 1

The conclusion of Sprint 1 will be a collaborative session with the coaches on Friday. This meeting will focus on:

- Reviewing completed tasks and giving feedback on progress.
- Addressing any outstanding issues or questions.
- Doing a Sprint Retrospective to find, identify and implement improvements in the process.
  
### Checklist For Friday 

_[22.03.2024]_

- [ ] Meet your coaches in person; team introduction :) 
- [ ] Go over the minutes of the standup meeting.
- [ ] Review the work finished in Sprint 1 with coaches; move tickets to "Done in Sprint #1".
- [ ] Conduct and document Sprint Retrospective; add it to the GitHub Wiki.
- [ ] Plan Sprint 2 with your coaches.