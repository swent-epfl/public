# Solutions - Collaboration in Software Development

## Ex 1: Workflows
### Evaluation criteria

- The solution mentions the appropriate workflow for each of the two projects.
- Each answer is justified by a short explanation.

### Suggested solution

```text
While working with the Junior Entreprise of your university, a talented web 
developer has to work on a new project with a client who wants a website for 
their company. This is the client's first website and they are not familiar 
with web technology. However, the client is enthusiastic and has lots of
different ideas about how to organize the website.
```

> The client is not familiar with web technology, and has lots of different
> ideas about how to organize the website. Therefore, the requirements are not
> defined upfront, and the chosen workflow should be flexible enough to
> accommodate changes. An agile workflow (such as Scrum) would be suitable for
> this project.

```text
The Volare Space Robotics Challenge was a contest organized by the ASI (Agenzia
Spaziale Italiana) and ESA (European Space Agency). The goal was to make
high-school students design robots that unload cargo from ESA's Automated
Transfer Vehicle, while avoiding objects.
```

> An automated robot that operates in space is a very complex product. The
> requirements of the project are proposed early on and are stable. Since space
> exploration is governed by many laws, the project is subjected to different
> stages of approval at each step. The students are inexperienced. All these
> properties make the Waterfall model suitable for the project.

## Ex 2: Scrum workflow
### Evaluation criteria

- The solution mentions that the implementation discussions should not be
  done in the daily Scrum meeting.
- The solution mentions that Product Backlog items should be formulated as
  user stories or concrete bug reports.

### Suggested solution

You are part of a team developing a mobile app using Scrum.

One of your colleagues suggests that your team should organize daily
Scrum meetings to discuss the progress of the tasks and how to implement
complex features. He especially wants to discuss the implementation of
a feature that will allow users to scan a QR code to get a discount, and
would like some input from the team. What are your thoughts on this?

> The purpose of the daily Scrum meeting is to synchronize the team's work
> and to identify any impediments that might prevent the team from
> delivering the work. Therefore, the team should not be discussing the
> implementation details, of features during the meeting. Instead, the meeting
> should be solely dedicated to reporting the progress of the tasks.

When using the app, you identified multiple bugs and features which
you think should be implemented, and took some notes. You want to
share these with the Product Owner. Your backlog of tasks looks like this:

- [x] As a registered user, I can click on the settings button from the
  navigation pane, so I can access the settings screen from everywhere in the
  app.
- [ ] Login
- [ ] [Bug] The landing page doesn't render well, if the language of my device
  is not English.
- [x] [Bug] When I click on the home button, the app doesn't redirect me there
  (tested from multiple locations in the app).

Which of these items are suitable to be submitted to the Product Backlog? Why?

> The first item is a user story, and is therefore suitable to be submitted.
> The second item doesn't describe what the login experience should be.
> The first bug item is not specified properly ("doesn't render well" is not
> concrete). A bug item has to include details on what is wrong with the user
> experience.
> The second bug item is properly specified, and is therefore suitable to be
> submitted.


## Ex 3: Case Study

### Evaluation criteria

- The solution clearly identifies the problems with the workflow
- The solution suggests gradual improvements to the workflow

### Suggested solution

#### Day 1

Advice Mally to help them switch to a git repository for their code base. Git is
a very powerful versioning tool and expresses its whole power especially when
working in team. Git will help them work simultaneously on their code without
having the upload problem anymore.
For now, they need to wait on others to upload changes before they can work.
This means that only one developer can work on the project at a given time:
what a loss of productivity! Furthermore, they absolutely need to communicate
before getting the code to be sure that the last worker has uploaded everything.
It is a real mess and Git would save them.

#### Day 2

Mally should begin by talking to all developers and writing down what everyone
is working on. Then she should write each task either in the Sprint Backlog or
in the in-progress bucket. This would allow the team to have a good vision of
the project's goal and progress as everyone would know on what the others are
working and see the tasks they have done so far.

#### Day 3

The stand-up meeting. During this meeting everyone says:

1. what they did the day before;
2. what they will do today; and
3. what is blocking them, what are the problems they encountered.

It is important that the developer does not go too much into implementation
details but keeps it short.
All members stay standing to encourage the meeting to be short. It is always
possible to continue talking about something after the meeting.

#### Day 7

There are plenty of tools to let you do this like GitHub projects, Trello, Jira.
Even non-digital things like a classic white board in the office.

In this tool (or white board), every feature needs to be explained as a user
story: "As a `<user-type`>, I can do `<feature`> to achieve `<goal`>". This
helps to remove any implementation details from the product backlog and keep
focused on features visible by the client.

#### Day 24

This is the Sprint Review. During this meeting, the whole team will meet the
Product Owner (Tom) and the stakeholders (customers). The team will go through
what has been done, what has not and will do a demo to the customers. After the
demo, the team will collaborate with the customers to decide what will be done
next.

__Planning:__ 

This is the Sprint Planning. During this part the team will choose how many and
which user stories from the Product Backlog will be in the Sprint Backlog. The
Product Owner (or customers) can only prioritize in the Product Backlog, the
Sprint Backlog is managed by the team.

#### Day 27

Mally needs to say no to Tom, we cannot change the sprint backlog during the
sprint. She is taking the role of Scrum Master, she needs to check that the team
is not doing tasks that are not in the Sprint Backlog.

#### Day 34

Rose has to communicate this to Mally and Tom. She cannot take the decision on
her own (in most cases), even if the bug is severe. There are many possible ways
to handle the situation. For example:

- The bug is minor and can be fixed right away while you're doing some other
  work in the same code. You can just fix it.
- Log the bug into the issue tracking system you use.
- Log the bug and raise an alarm to the Product Owner and the Scrum Master.
- The bug is severe enough for you to believe it has to take priority over
  anything else: Then, log it, communicate with the Product Owner and the Scrum
  Master and move away other items in the Sprint Backlog.


## Ex 4: Case Study
### Evaluation criteria

- The solutions show a good theoretical understanding of the use of a scrum board
- The solution shows a good understanding of the practical use of GitHub projects

### Suggested solution

4. Create 3 User Stories as notes in the Product Backlog.

- Q: Who should be updating the Product Backlog?
- A: The Product Owner is responsible for populating the Product Backlog and prioritizing it according to their own
  criteria.
- Q: What is the format of a User Story?
- A: As a 'type of user' I can 'do this' in order to 'accomplish that'

5. Place one of the User Stories in the Sprint Backlog.

- Q: Is testing a separate task or is it a part of each task?
- A: This is a choice that the Development Team has to make. Testing can be _recorded_ in the Board either ways.
- Q: Who pulls items from the Product Backlog to the Sprint Backlog? How do you determine how many items to put there?
- A: The Development Team decides how many User Stories to pull into the Sprint Backlog during the Sprint Planning
  session. They have to decide how much work they can accomplish for the duration of the Sprint according to their
  estimations and historical data (sometimes referred to as _velocity_.) The amount of time required for the User
  Stories should always be less than the total amount of time, it does not need to be exact. For example, 3 developers
  working 8 hours per day for a Sprint of 5 days makes 120 hours. If the top 6 User Stories take 125 hours, then the
  Development Team has to take only the top 5 User Stories (from the Product Backlog) even if these 5 User Stories make
  up only 100 hours.

6. Create issues for tasks in the descriptions of the User Stories.

- Q: Where should you place these tasks?
- A: In the Sprint Backlog, this is the decomposition of User Stories into tasks.

7. Imagine you have teammates, how would you assign the Tasks in the Sprint Backlog to the different people on the
   team?

- Developers should self-assign

8. Where do you put bugs?

- In the Product Backlog. The Product Owner should prioritize the bugs along with the other Items in the Product
  Backlog.

## Ex 5: Code Review
### Evaluation criteria

- The solutions clearly identifies multiple different issues with the reviewed code

### Suggested solution

Here is an example reviewed version of the pull request:

![Image1](res/screenshot1.png)![Image2](res/screenshot2.png)
![Image3](res/screenshot3.png)![Image2](res/screenshot4.png)