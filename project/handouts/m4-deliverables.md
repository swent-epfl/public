 ## Milestone M4

 _[updated 17.05.2024]_

 The SwEnt project has four graded milestones (see [README](../README.md)). This handout concerns the fourth and final milestone.

 ### Due Date

 Friday 31.05.2024 @ 23.59 CEST

 ### Overview

M4 marks the culmination of your hands-on journey in SwEnt, transforming your initial idea into a polished PoC ready to put in the hands of users. By now, you should have a solid grasp of the Scrum methodology and how to collaborate effectively in a team. M4 is the final stretch where you leverage your acquired skills to optimize the delivery of your app. This milestone is your opportunity to integrate and refine all aspects of your app, ensuring a seamless user experience and robust functionality.

>[!NOTE]
> The Battle of the Apps (BOTA) is an optional competition in which your team can present their app to an audience consisting of your peers and outside visitors. It will take place on Thursday, May 30, in STCC. BOTA is not part of the M4 deliverables and will not be graded&mdash;it is just an opportunity for you to showcase your work and win substantial prizes.

 ### M4 Objectives

 __Finishing your PoC__: Ensure all planned features are fully implemented; prioritize core functionality over stretch goals. Refine the UX, ensure the interface is intuitive and user-friendly, and put the finishing touches on UI aesthetics. Enhance your app's utility by making sure the offline mode is meaningful, reliable, and secure. Ensure that your app makes good use of phone sensors.

 __Laying the foundations for the MVP__: Maintain the highest standards of code quality: your code should be clean, have low cognitive complexity and be well documented, be thoroughly tested, and be maintainable.  Make your app ready for beta testing, i.e., to be put in the hands of a select group of external users within your target audience. The APK should include all the core user flows, they should be coherent, and the implementation should be reliable and secure&mdash;no dummy or mock data, no hard-coded links or secrets, etc.

These aspects are important to getting feedback from initial customers, and then iterating quickly on the MVP that you will describe in your PRD.

 ### M4 Deliverables

 Your _team_ will need to prepare the following items and submit their URLs via the [M4 team submission form](https://moodle.epfl.ch/):

1. Up-to-date Figma ➡︎ _figma.com_
2. Up-to-date architecture diagram ➡︎ _your GitHub README_
3. CI with automated testing (>80% line coverage) and cognitive complexity tracking (<50 per file) ➡︎ _GitHub_ and _SonarCloud_
4. High-quality APK, ready for beta-testing on any Android smartphone ➡︎ _GitHub_
5. Polished video of your app demo (≤2 minutes), aimed at potential customers ➡︎ _platform of your choice_
6. Scrum process documents: 1 documented stand-up meeting per Sprint + 1 documented Retrospective per Sprint ➡︎ _Google sheets_ shared with the coaches
7. Team autonomy

Additionally, each _individual_ student must prepare the following items and submit them via the [M4 individual submission form](https://moodle.epfl.ch/): 

1. An individual Retrospective for each Sprint ➡︎ _Google sheet_ shared with the coaches
2. The PRs you created and were merged (≥3 PRs total, ≥1 each Sprint) ➡︎ _GitHub_
3. The PRs you reviewed (≥3 in total, ≥1 each Sprint) ➡︎ _GitHub_

#### Beta-release APK

M4 has the greatest weight among the four milestones because, in M4, we look not only at the incremental progress of the last two Sprints but also the final output of your entire course project. For M4, you produce a beta release of your app that is ready to be distributed to a small group of users outside your team, to get initial customer feedback.

We will evaluate your APK along the following dimensions:

* *Completeness*: At the beginning of the course, we set the expectation that your app should make effective use of public cloud services, work both online and in offline mode, and make meaningful use of the sensors. Feature-wise, it should have at least two meaningful epics implemented. We will evaluate if you have developed both epics and if their depth and complexity is in-line with the course expectations. We suggest that you revisit with your coaches what constitutes a meaningful epic and whether you are on track to meet expectations by the end of this milestone.

* *Functionality*: Your app should work end-to-end seamlessly and coherently. Users should be able to create accounts, interact with the app and other users of the app in natural and predictable ways, store and retrieve their data/information, be able to switch from one device to another, etc. The provided functionality should work reliably and survive the stress imposed by clueless users. 

* *Usability*: As a beta release, the app need not be pretty and sleek, but the usability needs to be there. Essential UX design elements, like navigation bars, the profile tab, filters, etc. should be ready for prime time. Usability is a fundamental part of the design.  Take a look, for instance, at the ChatGPT mobile app: it is simple, and it hides everything in a side navbar, and the main activity is a simple search textbox. This is an intuitive UI. The main user interaction is put into focus, and the number of CTAs (calls to action) needed for a user to get value from the app is kept low.


#### Code Quality

Your beta release is not only about efficient, usable functionality but also about a maintainable code base that can scale beyond the PoC. Therefore, code quality plays an important role in this milestone, and we will evaluate it along the following dimensions:

* *Maintainability:* Your code must be easy to understand and modify. This requires that it be well designed and structured, as well as have great documentation. This includes not only inline comments but also external documentation in your README that explains the architecture and the major components. Use meaningful naming conventions, keep functions focused on a single task, and avoid large classes or methods, to reduce cognitive complexity.
* *Quality assurance:* Adhere to the testing protocols we taught you, and aim to exceed the 80% line-coverage goal. You need to have well organized unit tests as well as integration tests that ensure modules work together seamlessly. End-to-end tests should simulate several user scenarios and ensure you don't get regressions when changing the code. The more complex a part of your code is (e.g., in terms of cognitive complexity), the better tested it should be. You can use Sonar's _Measures → Coverage → Overview_ to identify the complex files. 

## Grading

The breakdown of the team and individual grades for M4 is as follows:

| **Total Team Grade**        | **100%** |
|-----------------------------|----------|
| APK Completeness            | 25%      |
| APK Functionality           | 15%      |
| APK Usability               | 5%       |
| Design and Maintainability  | 15%      |
| Documentation               | 10%      |
| Code Testing                | 25%      |
| Demo video                  | 2%       |
| Team autonomy               | 3%       |

| **Total Individual Grade**                                                  | **100%** |
|-----------------------------------------------------------------------------|----------|
| Coding contributions over the project's lifetime (including M4)<sup>1</sup> | 50%      |
| Code-health contributions over the project's lifetime (including M4)        | 25%      |
| Participation<sup>2</sup>                                                   | 10%      |
| Ownership, leadership and autonomy<sup>3</sup>                              | 15%      |

<sup>1</sup>
We realize that, by now, a lot of the major functionality has been developed, so some PRs in M4 may end up being smaller (e.g., addressing bug fixes, tweaking features).
We will be looking for evidence that your overall contribution to the development effort was consistent with the time at your disposal.

<sup>2</sup>
This refers to consistent participation in the creation of value, to quality of communication, supportiveness for the rest of the team, and contributions during the Scrum ceremonies.

<sup>3</sup>
M4 is about delivering the beta, so a "get things done" attitude is that much more important: doing your tasks on-time as opposed to last-minute, doing a great job as SM and PO, going out of your way to contribute to the team's objectives, taking initiative for improving your team's development process, etc. We look for demonstrated leadership in at least one of the activities you undertake for your team.
