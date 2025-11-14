# EPFL CS-311: The Software Enterprise

_Last updated: October 7, 2025_

## Table of Contents

- [Staff](#staff)
- [Schedule](#schedule)
- [Prerequisites](#prerequisites)
- [App Requirements](#app-requirements)
- [Grading](#grading)
- [Attendance Policy](#attendance-policy)
- [Workload](#workload)
- [Collaboration Policy](#collaboration-policy)
- [Hardware Requirements](#hardware-requirements)
- [Further Questions](#further-questions)

<hr>

Welcome to "The Software Enterprise: From Ideas to Products". 
The goal of this course is to teach you how to turn ideas into solutions for the real world through software.
The course has two phases:

1. __Fundamentals__ (weeks 1&ndash;3): The basics of software development that were not covered in previous courses, using both theory (lectures) and practice (bootcamp). The goal is to enable all students to start developing a software product that brings one or more ideas to life.

2. __Project__ (weeks 4&ndash;14): You develop, in teams, an Android app that brings your own idea to life.
The course staff guides you in this journey from idea to product.
The project has three milestones during the semester.

## Staff

- Instructor: [Prof. George Candea](https://dslab.epfl.ch/people/candea)
- Head TA: [Fan Chung](https://fanchung.net/)<br>

The staff is reachable at <swent-staff@dslab.org> for all private issues.
For questions whose answers could benefit other students, use the [Ed forum](https://moodle.epfl.ch/mod/lti/view.php?id=1280679).
## Schedule

#### Lectures

- Monday (8-Sep and 15-Sep) from 10:15&mdash;12:00 in the [CM1 auditorium](https://plan.epfl.ch/?room==CM%201%201)  _(22-Sep is a holiday)_
- Friday (12-Sep and 19-Sep) from 9:15&mdash;11:00 in the [CM2 auditorium](https://plan.epfl.ch/?room=%3DCM%201%202)

#### Recitations

- For 1h immediately after each lecture. During recitations, the course staff answer your questions about the lecture materials and assist you with the bootcamp.  Most of your work on the bootcamp is to be done independently, outside the recitations.

#### Coaching meetings

- Each student team will be assigned 2 coaches, who will guide and support the team throughout the semester, providing expertise and feedback to help students achieve their project goals.
- The team meets with their coaches once a week on Friday, for 1h in the 9:15&ndash;12:00 interval, in one of the following rooms: [BC 04](https://plan.epfl.ch/?room==BC%2004), [CM 013](https://plan.epfl.ch/?room==CM%20013), [DIA 005](https://plan.epfl.ch/?room==DIA%20005), [ELG 116](https://plan.epfl.ch/?room==ELG%20116), [ELG 120](https://plan.epfl.ch/?room==ELG%20120), [INF 019](https://plan.epfl.ch/?room==INF%20019), [INF 213](https://plan.epfl.ch/?room==INF%20213), [MA A1 10](https://plan.epfl.ch/?room==MA%20A1%2010), [MED 2 2423](https://plan.epfl.ch/?room==MED%202%202423). The coaching meetings are in-person and mandatory. The time and room is TBD with your coaches.

#### Battle of the Apps (BOTA)

- The BOTA will take place on Friday, 19-Dec from 9:15&ndash;13:00 in [STCC - Cloud C](https://plan.epfl.ch/?room==STCC%207%208025); see more details [here](project/BOTA.md).
- This is a special event in which you can present and demo your app to an audience consisting of your class mates, the teaching staff, and other attendees from outside SwEnt.
The top-three teams win substantial prizes.
Participation is entirely optional, and it does not affect your course grade.

#### Week-by-week Schedule

| Week    | Topics                                                                                                                       | Deliverable(s)                            |
|---------|------------------------------------------------------------------------------------------------------------------------------|----------------------------------------|
| Wk1      | Tools, Requirements, User Stories [[slides](https://moodle.epfl.ch/pluginfile.php/3464607/mod_folder/content/0/Wk1.A%20-%20Tools%2C%20Requirements%2C%20User%20Stories.pdf?forcedownload=1)] <br> The Mobile Platform  [[slides](https://moodle.epfl.ch/pluginfile.php/3464607/mod_folder/content/0/Wk1.B%20-%20The%20Mobile%20Platform.pdf?forcedownload=1)] <br>  | [Bootcamp B1](bootcamp/README.md) + [Team composition](https://moodle.epfl.ch/mod/choicegroup/view.php?id=1342023) <!-- (https://moodle.epfl.ch/mod/choicegroup/view.php?id=1281076) --> <br> due 15-Sep @ 23:59 |
| Wk2      | Testing Fundamentals: Concepts &amp; Metrics [[slides](https://moodle.epfl.ch/pluginfile.php/3464607/mod_folder/content/0/Wk2.A%20-%20Testing%20Fundamentals.pdf?forcedownload=1)] <br>&nbsp;&nbsp;&nbsp;&nbsp;TDD [[slides](https://moodle.epfl.ch/pluginfile.php/3464607/mod_folder/content/0/Wk2.A%20-%20Testing%20Fundamentals%20-%20TDD.pdf?forcedownload=1) \| [video](https://youtu.be/weLFZSx6KpA)], BDD [[slides](https://moodle.epfl.ch/pluginfile.php/3464607/mod_folder/content/0/Wk2.A%20-%20Testing%20Fundamentals%20-%20BDD.pdf?forcedownload=1) \| [video](https://youtu.be/qt5PDa50-VE)] <br> Agile Development, Collaboration workflows, CI/CD [[draft slides](https://moodle.epfl.ch/pluginfile.php/3464607/mod_folder/content/0/Wk3.A%20-%20Collaborative%20Software%20Development.pdf?forcedownload=1)] <br>&nbsp;&nbsp;&nbsp;Commit Messages [[slides](https://moodle.epfl.ch/pluginfile.php/3464607/mod_folder/content/0/Wk3.A%20-%20Collaborative%20Software%20Development%20-%20Commit%20Messages.pdf?forcedownload=1) \| [video](https://www.youtube.com/watch?v=vbNDUFe5U6I)], Coding Standards [[slides](https://moodle.epfl.ch/pluginfile.php/3464607/mod_folder/content/0/Wk3.A%20-%20Collaborative%20Software%20Development%20-%20Coding%20Standards.pdf?forcedownload=1) \| [video](https://www.youtube.com/watch?v=t5fAWsdzBzA)] | [Bootcamp B2](bootcamp/README.md) + [App description](https://moodle.epfl.ch/mod/quiz/view.php?id=1305118) <br> due 23-Sep @ 23:59 |
| Wk3      |  Advanced Testing: Mocks, Dependency Injection, UI Testing [[slides](https://moodle.epfl.ch/pluginfile.php/3464607/mod_folder/content/0/Wk3.A%20-%20Advanced%20Testing.pdf?forcedownload=1) \| [videos](https://www.youtube.com/playlist?list=PLr41P4J9F0ZM1ebUm2QoLquU-yHA9bm6Z)] <br>1<sup>st</sup> coaching meeting | [Bootcamp B3](bootcamp/README.md) <br> due 29-Sep @ 23:59 |
| Wk4 | [Project Warmup](project/README.md)                           | [Warmup](project/Warmup.md) due  3-Oct @ 08:45 |
| Wk5 | [Project Sprint 1](project/README.md)           |                                        |
| Wk6  | [Project Sprint 2](project/README.md)                        | [M1](project/M1.md) due 17-Oct @ 08:45         |
| | _Fall Break_ |
| Wk7  | [Project Sprint 3](project/README.md)                        |                                                |
| Wk8  | [Project Sprint 4](project/README.md)                        |                                                |
| Wk9  | [Project Sprint 5](project/README.md)                        | [M2](project/M2.md) due 14-Nov @ 08:45                          |
| Wk10 | [Project Sprint 6](project/README.md)                        |                                                |
| Wk11 | [Project Sprint 7](project/README.md)                        |                                                |
| Wk12 | [Project Sprint 8](project/README.md)                        |                                                |
| Wk13 | [Project Sprint 9](project/README.md)                        |                                                |
| Wk14 | [Project Sprint 10](project/README.md)<br>Battle of the Apps | [M3](project/M3.md) due 18-Dec @ 08:45 <br> Feedback survey     |

We might use surveys to collect systematic student feedback that is statistically significant.
We use it as input to improving the course.
The surveys are not graded, but are a required part of the corresponding deliverable, so a submission is incomplete until the survey has been filled in.
Budget 15 minutes to complete a survey.

> [!IMPORTANT]  
> Since this is a project course where your teammates depend on you, it is not possible to withdraw from the course after the registration deadline.

<!--
> [!IMPORTANT]  
> [CS-300 (Modèles stochastiques)](https://moodle.epfl.ch/course/view.php?id=14236) students: Beware that the CS-300 midterm is in the afternoon on Friday 15.11, a few hours after the deadline for the SwEnt milestone M2.
> We tried to negotiate a different date, but were unable to find a solution.
> Please plan accordingly ahead of time.
-->

#### Bootcamp

In order to do the bootcamp, you must have submitted to us your GitHub username, as explained on Moodle. 
Unless you complete this step, you will not be able to start your bootcamp. 
After we receive your GitHub username, we will set up a private repo for you.
Once that is set up, you will be able to start your bootcamp by following the instructions at <code>https://github.com/swent-epfl/bootcamp-25-<i>yourGitHubUsename</i>/README.md</code>.

## Attendance Policy

In-person attendance of the coaching meetings is mandatory, and is a crucial part of the learning process and of the evaluation. The first such meeting will take place in week 4, after the last bootcamp deliverable.

You have two joker passes: The _big joker_ pass allows you to entirely miss one coaching meeting during the semester penalty-free, no questions asked. The _little joker_ pass allows you to attend one such meeting over videoconference instead of in-person, penalty-free and no questions asked.
Once you've used your joker passes, no further absences are accepted, except as outlined in the [corresponding FAQ](faq.md#which-absences-are-excusable).

Attendance of lectures and bootcamp sessions (recitations) is not mandatory, but nevertheless is essential to learning the material.
We find that students who do not attend lectures and exercises in-person routinely end up spending much more time on the bootcamp and the project than students who do attend diligently, and in the end perform less well in SwEnt.

## Prerequisites

SwEnt has several strict prerequisites that we build upon; we move fast and do not have time to recap material from this prerequisite courses. 
First, you must be a **proficient programmer** in Java-like languages.
Second, you must have **successfully passed** these courses in order to take SwEnt:

- CS-214 Software construction (BA3)
- CS-202 Computer systems (BA4)
- CS-173 Fundamentals of Digital Systems (BA2)

For example, we will assume that you already master the following material from [CS-214](https://cs-214.epfl.ch):

- The basics of software testing (From tests to proofs I, From tests to proofs II, Automated software testing)
- Version control (Git basics, Git demo, Advanced Git)
- Debugging

## App Requirements

> [!NOTE]
> You are responsible for forming 7-student teams and then submitting your team's composition with deliverable B1.
> As a team, you decide on the problem you want to solve and the description of the app, both of which you must submit with deliverable B2.
> If you wish, check out [these app examples](project/Examples.md) for inspiration.

All apps must meet the basic requirements of functionality and resilience: apps must accomplish compelling tasks for clear use cases, in a way that is easy to use and consistent with the Android experience; and apps must work in the face of user errors, malice, and external issues such as a lack of Internet connectivity, with a test suite to demonstrate this.

To ensure that students encounter real-world challenges, and to provide fair grading conditions across teams, all apps must also meet the following requirements:

- Split app model: the app must use a public cloud service, such as Google Firebase
- User support: the app must have a concept of authentication, for instance using Android’s built-in Google authentication
- Sensor use: the app must use at least one phone sensor, such as GPS, camera, or microphone, as part of a core feature of the app
- Offline mode: the app must be usable without Internet connectivity, by paring down features compared to the normal experience

Teams are not allowed to write their own backend unless they have a good reason approved in writing by the instructor. This is to ensure (a) the app will still work in the future without someone to set up and maintain a backend, and (b) the project scope is restricted enough to be feasible within the course. Security, privacy, and vendor lock-in are valid concerns but outside the scope of this course.

Sensor usage should drive some behavior in the app, such as finding nearby points of interest with the GPS, or augmenting reality by drawing over a video feed. Merely getting sensor data and storing it in a field shown to users is too simple and not enough.

> [!NOTE]
> By default, the apps should be developed using the Android SDK and Kotlin.
> If you wish to use a different framework/language, we might be able to make an exception if the case is well argued and the entire team wants this.
> Please get in touch with the staff.

## Grading

The bootcamp spans the first 3 weeks and has weekly deliverables (B1, B2, B3)&mdash;these are all entirely individual work.
Each deliverable is equally weighted in computing the _Bootcamp_ grade = ⅓ B1 + ⅓ B2 + ⅓ B3.
See your bootcamp documentation for more details.

The project spans the remaining 11 weeks and has 3 milestones (M1, M2, M3) with concrete deliverables. For each milestone, students receive separate grades for individual and team performance. The overall individual _Project<sub>indiv</sub>_ grade and team _Project<sub>team</sub>_ grade are computed as 20% M1 + 30% M2 + 50% M3.


> [!IMPORTANT]  
> Normally, the overall course grade = 45% _Project<sub>indiv</sub>_ + 50% _Project<sub>team</sub>_ + 5% _Bootcamp_.  In other words, half the course grade is based on your team's performance and half on your individual performance.
> However, if _Project<sub>indiv</sub>_ &lt; 4, then the course grade = 90% _Project<sub>indiv</sub>_ + 10% _Bootcamp_.

Late submissions will be penalized 2% per hour of lateness (e.g., a 1-day late submission will carry a ~50% penalty).  Early submissions are encouraged but cannot receive bonus points, as per EPFL policy.

In SwEnt, we use a _belt system_ inspired by martial arts.
Developing mastery is like building a house: first the foundation (White), then walls (Yellow), then a ceiling (Green), then the roof (Blue), and finally the pipes, wiring, parquet, lights, etc. (Black). You can’t add a roof without walls, and you can’t build walls without a foundation.
The rule is simple: you only move forward once you’ve demonstrated mastery of what comes before. That way, your growth is solid and lasting.

Deliverables (both in the Bootcamp and the Project) are grouped by belt.
To earn points at belt level N+1, you must have fully earned belt N.
For example, no Yellow-belt points until you’ve earned White, and no Black-belt points until you’ve completed Blue.

We offer nothing beyond Black belt&mdash;not because you've reached ultimate superiority but because you've reached the point where you can _self_-improve without our help, thereby beginning a lifelong journey of steadily deepening your mastery.

## Workload

This is an 8-credit course; the [EPFL guidelines](https://www.epfl.ch/education/teaching/teaching-guide-2/getting-started/design-a-course_1/) indicate that you should expect to spend a total of 8x30=240 hours of work over the course of the semester. For a 14-week semester, this averages to **a little over 17 h per week**.
You will likely experience variations in the weekly rhythm, especially around deadlines.

The average 17 hours/week workload might appear inconsistent with the course description, which shows 2h lecture + 10h project + 1h exercises per week, which adds up to 13h per week.  This is because total student workload includes both timetabled time and non-timetabled work (see [EPFL guidelines](https://www.epfl.ch/education/teaching/teaching-guide-2/getting-started/design-a-course_1/)). The average student in SwEnt will need to spend the full 17 hours/week to pass the course&mdash;13 hours/week is just not enough.

## Collaboration Policy

Members of a team are of course allowed to discuss the project and share code for it. Members of different teams can discuss their project and programming issues, but not share code without prior written permission of the course instructor (not the coaches!).
Bootcamp code, however, shall not be shared with anyone else.

Collaboration can also take place on the class forum, visible to the entire class. You can ask questions about the course, programming difficulties, tooling issues, and so on. You are also welcome to answer questions from your fellow students as well, since you will most likely have solved similar problems in your team’s project.

You are allowed to use AI assistants and other sources (Stack Overflow, public GitHub repos with free licenses, etc.), as long as you understand what you are doing and **you acknowledge them as contributors**.
Understanding what you're doing means, for example, that you can answer detailed questions about the code you turn in: why did you make that particular design decision, why did you use that particular library, etc.
In a comment at the top of your source file you must acknowledge the sources of inspiration that contributed to the code.
Use of any outside sources without fulfilling the above conditions is considered plagiarism.

Cheating, plagiarism, and any form of dishonesty will be handled with the maximum severity permitted under EPFL rules. If you are in doubt whether an action on your part is acceptable, please ask the course staff privately via the staff e-mail list before proceeding. Asking afterward is too late.

## Hardware Requirements

Students will develop, test, and execute the bootcamp and project on their own laptops.
We strongly recommend a minimum of 16GB of RAM (to run Android Studio), 50GB of available storage (Android Studio, Android SDK, emulator system images, course project files, etc.) on SSD or better, and WiFi.
You can probably manage with a lesser configuration, but it can be slow.

We provide Linux virtual machines in the [EPFL VDI](https://support.epfl.ch/epfl?id=epfl_kb_article_view&sysparm_article=KB0016486) infrastructure in case your laptop breaks down or you do not have the recommended configuration.
See [this tutorial](tutorials/VDIGuide.md) for how to get started with VDI in SwEnt.

Ideally, each team should have at least one Android phone capable of demo-ing the team's application.

## Further Questions

For answers to a list of frequently asked questions, please see the [SwEnt FAQ](faq.md).
If your question is not addressed there either, please email swent-staff@dslab.org.