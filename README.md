# EPFL CS-311: The Software Enterprise

_Last updated: November 5, 2024_

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
The goal of this course is to teach you how to use software to turn ideas into solutions that work in the real world. 
The course has two phases:

1. __Fundamentals__ (weeks 1&ndash;3): The basics of software development that were not covered in previous courses, using both theory (lectures) and practice (bootcamp). The goal is to enable all students to start developing a software product that brings one or more ideas to life.

2. __Project__ (weeks 4&ndash;14): You develop, in teams, an Android app that brings your own idea to life.
The course staff guides you in this journey from idea to product.
The project has three milestones during the semester.

## Staff

Instructor: [Prof. George Candea](https://dslab.epfl.ch/people/candea)

Head TA: Yonghao Zou<br>
TAs: Sara Anejjar, Ugo Balducci, Jérémy Chaverot, Gaël Conde Losada, Florian Déjean, Albert Fares, Alexandre Goumaz, Lea Grieder, Jérémy Hugentobler, David Kalajdzic, Andrew Limond, Ludovic Mermod, Alexandre Messmer, Edouard Michelin, Lorenzo Padrini, Yuchen Qian, Cléo Renaud, David Schroeter, John Taylor

The staff is reachable at <swent-staff@dslab.org> for all private issues.
For questions whose answers could benefit other students, use the Ed forum (accessed via [Moodle](https://moodle.epfl.ch/course/view.php?id=18350)).

## Schedule

#### Lectures

- Monday 10:15&mdash;12:00 in the [CM1 auditorium](https://plan.epfl.ch/?room==CM%201%201) on 9.09 and 23.09 (_16.09 is a holiday_)
- Friday 9:15&mdash;11:00 in the [CE2 auditorium](https://plan.epfl.ch/?room==CE%201%202) on 13.09, 20.09, and 27.09

#### Recitations

- For 1h immediately after each lecture. During recitations, the course staff answer your questions about the lecture materials and assist you with the bootcamp.  Most of your work on the bootcamp is to be done independently, outside the recitations.

#### Coaching

Each student team will be assigned 1-2 coaches, who will guide and support the team throughout the semester, providing expertise and feedback to help students achieve their project goals.

The team meets with their coach(es) once a week on Friday, for 1h in the 9:15&ndash;13:00 interval (TBD together with the coaches), in one of the following rooms (TBA): [INF 019](https://plan.epfl.ch/?room==INF%20019), [ELG 116](https://plan.epfl.ch/?room==ELG%20116), [ELE 111](https://plan.epfl.ch/?room==ELE%20111), [ELG 120](https://plan.epfl.ch/?room==ELG%20120), [BC 04](https://plan.epfl.ch/?room==BC%2004), [DIA 005](https://plan.epfl.ch/?room==DIA%20005), [MED 2 2423](https://plan.epfl.ch/?room==MED%202%202423), or [MA A1 10](https://plan.epfl.ch/?room==MA%20A1%2010)

#### Week-by-week Schedule

| Week    | Topics                                                                                                                       | Deliverable                            |
|---------|------------------------------------------------------------------------------------------------------------------------------|----------------------------------------|
| Wk1      | Requirements and User Stories [[slides](lectures/Wk1.A%20-%20Requirements%20and%20User%20Stories.pdf) \| [videos](https://www.youtube.com/playlist?list=PLr41P4J9F0ZNzQwSrggaGKObGjMlxIRhI)] <br> The Mobile Platform [[slides](lectures/Wk1.B%20-%20The%20Mobile%20Platform.pdf) \| [videos](https://www.youtube.com/playlist?list=PLr41P4J9F0ZMyuALs9gJ06adyG3LKmmPe)]          | [Milestone B1](#bootcamp) + <br> [Team composition](https://moodle.epfl.ch/mod/choicegroup/view.php?id=1281076)   |
| Wk2      | Testing Fundamentals: Concepts, Metrics, TDD, BDD [[slides](lectures/Wk2.A%20-%20Testing%20Fundamentals.pdf) \| [videos](https://www.youtube.com/playlist?list=PLr41P4J9F0ZMRgp3gw1cRA0VrQOphp-SA)] <br>Advanced Testing: Mocks, Dependency Injection, UI Testing [[slides](lectures/Wk2.B%20-%20Advanced%20Testing.pdf) \| [videos](https://www.youtube.com/playlist?list=PLr41P4J9F0ZM1ebUm2QoLquU-yHA9bm6Z)]                                               | [Milestone B2](#bootcamp) + <br> [App description](https://moodle.epfl.ch/mod/quiz/view.php?id=1305118)    |
| Wk3      | Agile development processes, collaboration workflows, CI/CD <br>[[slides](lectures/Wk3.A%20-%20Collaborative%20Software%20Development.pdf) \| [videos](https://www.youtube.com/playlist?list=PLr41P4J9F0ZOs2o4OGpMvKeBipnklTyWi) \| [Scrum podcast (by AI)](https://open.spotify.com/show/4XV7k68M5rjkW1gdlNreDU)] | [Milestone B3](#bootcamp)                           |
| Wk4-Wk5 | [Project](project/README.md)                                                                                                                      |                                        |
| Wk6      | [Project](project/README.md)                                                                                                                      | [Milestone M1](project/M1.md) |
| Wk7-Wk8   | [Project](project/README.md)                                                                                                                      |                                        |
| Wk9      | [Project](project/README.md)                                                                                                                      | [Milestone M2](project/M2.md)                           |
| Wk10-Wk13 | [Project](project/README.md)                                                                                                                      |                                        |
| Wk14     | [Project](project/README.md)<br>_(no coaching meeting on 20-Dec)_                                                                                                                      | [Milestone M3](project/M3.md) + <br> Feedback survey |

All project deliverables are due at the end of that week's Sprint, before the start of the Sprint ceremonies: _M1_ on 18-Oct, _M2_ on 15-Nov, and _M3_ on 20-Dec. The bootcamp deliverables (B1, B2, B3) are due at 23:59 on the Monday following the week shown above.

We might use surveys to collect systematic student feedback that is statistically significant.
We use it as input to improving the course.
The surveys are not graded, but are a required part of the corresponding deliverable, so a submission is incomplete until the survey has been filled in.
Budget 15 minutes to complete a survey.

> [!IMPORTANT]  
> [CS-300 (Modèles stochastiques)](https://moodle.epfl.ch/course/view.php?id=14236) students: Beware that the CS-300 midterm is in the afternoon on Friday 15.11, a few hours after the deadline for the SwEnt milestone M2.
> We tried to negotiate a different date, but were unable to find a solution.
> Please plan accordingly ahead of time.


#### Bootcamp

In order to do the bootcamp, you must have submitted to us your GitHub ID, as explained [here](https://moodle.epfl.ch/mod/forum/discuss.php?d=105828). Unless you complete this step, you will not be able to start your bootcamp. After we receive your GitHub ID, we will set up a private repo for you (this might take up to a day). Once that is set up, you will be able to start your bootcamp by following the instructions at `https://github.com/swent-epfl/bootcamp-f24-<your GitHubID>/README.md`.

#### Battle of the Apps (BOTA)

This is a special event at the end of the semester, in which you can present and demo your app to an audience consisting of your class mates, the teaching staff, and other attendees from outside SwEnt.
The top-three teams win substantial prizes.
Participation is entirely optional, and it does not affect your course grade.

The BOTA will take place on Thursday, 19.12.2024 from 10:15&mdash;13:00 in [STCC - Cloud C](https://plan.epfl.ch/?room==STCC%207%208025).

## Attendance Policy

In-person attendance of the coaching meetings is mandatory, and is a crucial part of the learning process and of the evaluation. The first such meeting will take place in week 4, after the last bootcamp deliverable.

You have two joker passes: The _big joker_ pass allows you to entirely miss one coaching meeting during the semester penalty-free, no questions asked. The _little joker_ pass allows you to attend one such meeting over videoconference instead of in-person, penalty-free and no questions asked.
Once you've used your joker passes, no further absences are accepted, except as outlined in the [corresponding FAQ](faq.md#which-absences-are-excusable).

Attendance of lectures and bootcamp sessions (recitations) is not mandatory, but nevertheless is essential to learning the material.
We find that students who do not attend lectures and exercises in-person routinely end up spending much more time on the bootcamp and the project than students who do attend diligently, and in the end perform less well in SwEnt.

## Prerequisites

SwEnt has several strict prerequisites that we build upon; we move fast and do not have time to recap material from this prerequisite courses:

- CS-202 Computer systems (BA4)
- CS-214 Software construction (BA3)
- CS-173 Fundamentals of Digital Systems (BA2)

For example, we assume you already master the following material from CS-214:

- The basics of software testing
  - From tests to proofs I [
      [video](https://mediaspace.epfl.ch/media/%5BCS214+W04+SE%5D+From+tests+to+proofs+I+++II+%282023-10-11%29/0_6nouohk3?st=1401) |
      [slides](https://docs.google.com/presentation/d/1vxyJeF8FLka4PiGTLQw6Pxm71UwmbEYi4tq2-s3lElM/edit#slide=id.p)  |
      [exercises](https://cs-214.epfl.ch/exercises/se/index.html#debugging-with-tests-and-specs) ]
  - From tests to proofs II [
      [video](https://mediaspace.epfl.ch/media/%5BCS214+W05+SE%5D+From+tests+to+proofs+II+++II+%282023-10-18%29/0_nrvx06wj/56193) |
      [slides](https://docs.google.com/presentation/d/1EdZju6XAKm8oQaWfUcUQD_lAbMCn6U3WidN7sMUzZm0/edit#slide=id.p) |
      [exercises](https://cs-214.epfl.ch/exercises/se/index.html#understanding-different-kinds-of-tests) ]
  - Automated software testing [
      [video](https://mediaspace.epfl.ch/media/%5BCS214+W12+SE%5D+Automated+software+testing+%282023-12-06%29/0_izqiyisq/56193) |
      [slides](https://docs.google.com/presentation/d/1scx1jGxBjhqN08_EMT7oWuRWnXVwgESaeMOk5gt29vQ/edit#slide=id.g29b8eadca7d_0_0) ]
- Version control
  - Git basics [
      [video](https://mediaspace.epfl.ch/media/%5BCS214+W02+SE%5D+Git+Basics+%282023-09-27%29/0_99hhrxbc/56193) |
      [slides](https://docs.google.com/presentation/d/1_UzBDq1LUXArWw7jmdIH92p7iCx8f8LpHnyYxeTSW80/edit#slide=id.p) |
      [exercises](https://cs-214.epfl.ch/exercises/git-1/) ]
  - [Git demo](https://cs-214.epfl.ch/lectures/git-1/index.html)
  - Advanced Git [
      [video](https://mediaspace.epfl.ch/media/%5BCS214+W09+SE%5D+Le+retour+du+Git+%282023-11-15%29+/0_zh3nzz51/56193) |
      [slides](https://docs.google.com/presentation/d/1hHQ3H5HjcG1-nkh4-PBp87KytX5G1YNZTnQ2C3mdTw8/edit#slide=id.g29b8eadca7d_0_0) |
      [exercises](https://cs-214.epfl.ch/exercises/git-2/) ]
- Debugging [
      [video](https://mediaspace.epfl.ch/media/%5BCS214+W03+SE%5D+How+to+diagnose+%28almost%29+anything+%282023-10-04%29/0_mligtzar/56193) |
      [slides](https://docs.google.com/presentation/d/1I3fXaKDzVTmz2Kq1a9UWMj98B-pX0vqbBTAO_qzhPXM/edit#slide=id.p) ]

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

Normally, the overall course grade = 45% _Project<sub>indiv</sub>_ + 50% _Project<sub>team</sub>_ + 5% _Bootcamp_.  In other words, half the course grade is based on your team's performance and half on your individual performance.

However, if _Project<sub>indiv</sub>_ &lt; 4, then the course grade = 90% _Project<sub>indiv</sub>_ + 10% _Bootcamp_.

Late submissions will be penalized 2% per hour of lateness (e.g., a 1-day late submission will carry a ~50% penalty).  Early submissions are encouraged but cannot receive bonus points, as per EPFL policy.

## Workload

This is an 8-credit course; the [EPFL guidelines](https://www.epfl.ch/education/teaching/teaching-guide-2/getting-started/design-a-course_1/) indicate that you should expect to spend a total of 8x30=240 hours of work over the course of the semester. For a 14-week semester, this averages to a little over 17 hours/week.
You will likely experience variations in the weekly rhythm, especially around deadlines.

The average 17 hours/week workload might appear inconsistent with the course description, which shows 2h lecture + 10h project + 1h exercises per week (thus a total of 13h per week).  This is because total student workload includes both timetabled time and non-timetabled work (see [EPFL guidelines](https://www.epfl.ch/education/teaching/teaching-guide-2/getting-started/design-a-course_1/)). The average student in SwEnt will need to spend the full 17 hours/week to pass the course&mdash;13 hours/week is not enough.

## Collaboration Policy

Members of a team are of course allowed to discuss the project and share code for it. Members of different teams can discuss their project and programming issues, but not share code without prior written permission of the course instructor (not the coaches!).
Bootcamp code, however, shall not be shared with anyone else.

Collaboration can also take place on the class forum, visible to the entire class. You can ask questions about the course, programming difficulties, tooling issues, and so on. You are also welcome to answer questions from your fellow students as well, since you will most likely have solved similar problems in your team’s project.

You are allowed to use AI assistants and other sources (Stack Overflow, public GitHub repos with free licenses, etc.), as long as you understand what you are doing and you acknowledge them as contributors to your codebase.
Understanding what you're doing means that you can answer detailed questions about the code you turn in: why did you make that particular design decision, why did you use that particular library, etc.
In a comment at the top of your source file you must acknowledge the sources of inspiration that contributed to the code.
Use of any outside sources without fulfilling the above conditions is considered plagiarism.

Cheating, plagiarism, and any form of dishonesty will be handled with the maximum severity permitted under EPFL rules. If you are in doubt whether an action on your part is acceptable, please ask the course staff privately via the staff e-mail list before proceeding. Asking afterward is too late.

## Hardware Requirements

Students will develop, test, and execute the bootcamp and project on their own laptops.
We strongly recommend a minimum of 16GB of RAM (to run Android Studio), 50GB of available storage (Android Studio, Android SDK, emulator system images, course project files, etc.) on SSD or better, and WiFi.
You can probably manage with a lesser configuration, but it can be slow.

We provide Windows and Linux virtual machines in the [EPFL VDI](https://www.epfl.ch/campus/services/wp-content/uploads/2020/09/Livret_Accueil_VDI_v2.docx) infrastructure in case your laptop breaks down or you do not have the recommended configuration.
See [this tutorial](tutorials/VDIGuide.md) for how to get started.

Ideally, each team should have at least one Android phone capable of demo-ing the team's application.

## Further Questions

For answers to a list of frequently asked questions, please see the [SwEnt FAQ](faq.md).
If your question is not addressed there either, please email sweng-staff@dslab.org.