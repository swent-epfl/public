# Frequently Asked Questions

_Last updated: September 10, 2025_

## Table of Contents
- [How can I get help?](#how-can-i-get-help)
- [Can I choose the time of the Friday meeting with coaches?](#can-i-choose-the-time-of-the-friday-meeting-with-coaches)
- [Why use Kotlin/Jetpack instead of cross-platform frameworks?](#why-use-kotlinjetpack-instead-of-cross-platform-frameworks)
- [Can we use something other than Kotlin/Jetpack for our project?](#can-we-use-something-other-than-kotlinjetpack-for-our-project)
- [Why does SwEnt use curving?](#why-does-swent-use-curving)
- [Can we do the Scrum ceremonies in French?](#can-we-do-the-scrum-ceremonies-in-french)
- [Which absences are excusable?](#which-absences-are-excusable)
- [Why are my hours invested not counted in grading?](#why-are-my-hours-invested-not-counted-in-grading)
- [Why is presence at the weekly Scrum ceremonies mandatory?](#why-is-presence-at-the-weekly-scrum-ceremonies-mandatory)
- [Is there any grade penalty if we use external sources?](#is-there-any-grade-penalty-if-we-use-external-sources)
- [How can I accurately acknowledge contributions to my codebase?](#how-can-i-accurately-acknowledge-contributions-to-my-codebase)
- [What if one of our teammates is lazy?](#what-if-one-of-our-teammates-is-lazy)
- [What if one of our teammates is too forceful?](#what-if-one-of-our-teammates-is-too-forceful)
- [Why do Figma wireframes in addition to mockups?](#why-do-figma-wireframes-in-addition-to-mockups)


## How can I get help?

There are three ways to get your questions answered: on your own, your peers, or the SwEnt staff.
In real life, it is primarily on your own that you find answers, and next in line is your peers.
While still a student, the course staff is here to help, but most importantly they are here to prepare you to be self-sufficient in the real world.
There are several methods to get help in SwEnt:

1. We teach you several methods for how to find information on your own, in a self-sufficient manner. The first step is to use online resources on your own (documentation, tutorials, etc.) to understand the context around your question and its answer.  Web search provides a good way to find answers, though the context may be missing. LLMs provide excellent starting points in your search, because they can understand the broader context of your question, but sometimes their plausably looking answers can lead you down the wrong path and waste your time.
2. The next step is to post your question on Ed. Here you would get help from your peers, as well as the course staff. You can even post anonymously to your peers, if you are shy (the staff always knows the identity of the poster). The best way to get help is to explain what you have already done to try and answer the question on your own&mdash;if others see that you invested time in getting an answer, they will be more willing to also invest their own time to help you find the answer.
3. If this fails, reach out to your coaches. The same criterion as above applies: explain what you have done to solve the problem on your own.
4. If the coaches cannot help, then email swent-staff@dslab.org.
5. If you have a private matter that you wish to discuss exclusively with Prof. Candea (e.g., a personal situation that is affecting you emotionally), then send him email directly.

The SwEnt staff is here to help you become someone who successfully solves the world's problems using software.
Providing you with the right amount of support (and not more) at the right point in time (and not earlier) is central to our  mission.

## Can I choose the time of the Friday meeting with coaches?

Mostly yes. 
If you have a commitment for an hour or two on Friday mornings (e.g., you're a student assistant in a course, you're taking another course whose lecture is at that time, etc.) you can discuss with your team and find a time that works for the entire team to meet in-person with the coaches.
The coaches will then ask each of their teams for their availabilities and will strive to schedule the meetings such that everyone can be accommodated.
With a bit of flexibility on your part, this will be easy to resolve.

## Why use Kotlin/Jetpack instead of cross-platform frameworks?

Cross-platform frameworks, like Flutter or React Native, can significantly speed up development, by allowing a single codebase to target both Android and iOS. This reduces the time, cost, and effort needed to maintain two separate native codebases. They have features that make it easier to test and debug simultaneously across multiple platforms. They are great candidates if the goal is to reach both platforms quickly without needing separate teams for each.

So why do so many developers in the real world opt for native code? There are three main reasons:

- _Performance_:  Both Kotlin/Java (Android) and Swift (iOS) compile to native machine code, which results in fast, responsive apps that consume less battery for the same functionality compared to an interpreted language. This is particularly important for games, AR/VR apps, etc.  Some cross-platform frameworks can incur overhead due to intermediate layers, like JavaScript having to be interpreted in V8 (for React Native). cross-platform frameworks have been improving (e.g., Flutter uses its own rendering engine), but they're still not on par with fully native apps in all cases.

- _Look & feel_: Using native languages and frameworks makes it easier to incorporate the platform's unique design guidelines (e.g., Material Design on Android) and build apps that look and feel consistent with that platform. Cross-platform frameworks result in UIs that feel less "native" or familiar to users. Flutter, for instance, delivers the exact same UI on both Android and iOS (and hence relies on a custom rendering engine to draw the UI directly, rather than relying on native platform UI components). Many cross-platform frameworks allow customization that can get close to native feel if done well, though this can require significant effort.

- _Native access_: With Kotlin/Java (Android) and Swift (iOS) you get direct access to all of the platform's APIs, including hardware integrations, platform-specific UI components, advanced OS capabilities, etc. Cross-platform frameworks can do so too, through plugins or bridges, but typically lag behind native support. So developers might end up having to write some native code themselves anyway, which defeats the purpose. So, for complex apps that require deep platform integration (e.g., financial, enterprise, security-sensitive apps), native development is often preferred, because it provides a level of control and integration that is not available in a cross-platform framework.

In the SwEnt course, we focus on a single platform and use a native framework in order to avoid facing too many development challenges at once.

## Can we use something other than Kotlin/Jetpack for our project?

We are open to making exceptions to the Kotlin/Jetpack policy, as long as you make a good case for it.

Doing your project using a different framework/language entails several risks that you should carefully assess ahead of time:

- Coaches and course staff will not be able to help you with technical challenges as well as they can with Kotlin/Jetpack, so you may often find yourself on your own
- Integration with various tools and services (e.g., Sonar Cloud for measuring line coverage and cognitive complexity) could be tricky for the tech stack you choose, so check ahead of time that you will be able to complete the deliverables for all project milestones. We will not grant exceptions for lack of compatibility with your chosen framework/language.
- Evaluation of your work may end up being less precise, depending on the coaches' familiarity with the tech stack you chose.

If you wish to use something other than Kotlin/Jetpack, email swent-staff@dslab.org asap.
We will then assess whether your _entire_ team wishes to adopt a different framework/language, whether doing so will be beneficial to the students and the project, and whether we have staff who can coach you if you use that framework/language.

## Why does SwEnt use curving?

The form of curving we use in SwEnt helps normalize the scores to adapt to the difficulty of the milestone, and it provides a consistent method for evaluating performance across different cohorts (so that a grade of X in SwEnt means the same thing this year as it did last year). The manual thresholding we do mitigates the effect of extreme scores, so that outliers don't skew the grades.

We do spend a lot of time making sure that the grades are computed fairly, and we rely on more than a decade of experience teaching this course.
By now, we have converged onto a fair and correct grading scheme for a course like this one. 
We do however always want to hear arguments for how the grading (or any aspect of the course) can be improved; many of the changes we made were actually ideas we got from students.

## Can we do the Scrum ceremonies in French?

All Scrum ceremonies are to be done in English, both on Fridays with the coaches and within the team on its own, even if everyone in the team and the coaches speak French.

The reasons is that you will have to be fluent in English if you are to be competitive as a software engineer. 
In your career, you will inevitably be part of multi-lingual, multi-cultural teams in which the lingua franca will be English. 
So, alongside learning Scrum, Kotlin, Android, etc. we want you to learn how to communicate with other software developers in English.

## Which absences are excusable?

You already have [2 joker passes](README.md#attendance-policy), which should account for most instances. For the rest, see below.

Conflicts with other courses or exams are not excusable absences. The dates of midterms and final exams are announced at the start of the semester, so it is your responsibility to identify conflicts early and work on a solution with the staffs of the involved courses.

The exceptions listed in the _Absence aux épreuves_ section of the [official EPFL policy](https://www.epfl.ch/education/studies/reglement-et-procedure/questions-frequentes/inscriptions-cours-examens-retirer/) apply to the weekly SwEnt Scrum ceremonies as well. Just contact swent-staff@dslab.org with the relevant certificate to make suitable arrangements.

## Why are my hours invested not counted in grading?

Grades reflect the quality and outcomes of the work rather than the time invested; the degree of learning and skill acquired is measured by meeting (and exceeding) project requirements. In professional software development, the focus is on delivering results efficiently, so taking a long time to deliver a good result is actually not rewarded in the real world, quite the opposite. In SwEnt, we try to get you used to this concept. 

It is for this reason that we spend so much time in Lecture 1 discussing how to become a master of your tools, adopt best practices to optimize your workflow rather than just putting in more hours, and how to seek and get help. A big part of your professional development is to learn how to manage time effectively and work efficiently; this skill is crucial not only in software development but in many other fields. A client (or an employer) will care about the functionality, usability, and quality of your output, not how long it took you to develop it.

## Is there any grade penalty if we use external sources?

As long as you comply with the [collaboration policy](README.md#collaboration-policy), there is no penalty.
Quite the opposite: we encourage you to seek inspiration and help from outside, to learn how to maximize your productivity while upholding the highest ethical standards.
Having _Portions of this code were generated with the help of GitHub Copilot_ comments at the top of your source file will in no way hurt your grade.
We value more the student who is honest about his/her intellectual contribution than the one who pretends to have done more than they actually did.

## How can I accurately acknowledge contributions to my codebase?

The [collaboration policy](README.md#collaboration-policy) requires students to acknowledge contributions to their codebase that come from AI assistants, Stack Overflow, public GitHub repos with free licenses, etc.
Keeping track of which parts of your code were inspired by external sources, or who contributed them, is more cumbersome than not doing so.
However, it is essential that we respect the intellectual property of those who share their work with us.

The easiest is to make a note of the source at the moment when you use it, in order to avoid having to remember weeks later which the sources were.

If you copy-paste code from elsewhere without modification, you might state

```
This function comes from an answer by Alan Turing on Stack Overflow:
https://stackoverflow.com/a/12345678
Licensed under CC BY-SA 4.0 (https://creativecommons.org/licenses/by-sa/4.0/)`
```

If you used an AI assistant, then a broad statement at the top of your source file would suffice, such as:

```
Portions of this code were generated with the help of GitHub Copilot.
```

If you merely derive inspiration from an external source, it's up to you to decide what the right thing is. If you looked at Knuth's books to refresh your memory on heap sort, and then implemented it, you don't need to call that an inspiration and acknowledge it. But if you read a blog post or a tutorial, and then adapted code or ideas from there, you would write:

```
This class was adapted from Section 2 of https://dev.to/xyzfoobar/how-we-built-300ms-typo-correction-at-Facebook
Licensed under CC BY-SA 4.0 (https://creativecommons.org/licenses/by-sa/4.0/)`
```

While it may seem tedious to go through these steps, it is essential to our profession that we respect the intellectual property of others, and that others respect our intellectual property.

## What if one of our teammates is lazy?

Please contact your coaches as soon as it becomes apparent that one of your teammates is "slacking off" (not showing up for meetings, not delivering their work on time, not answering emails, etc.).
There are many reasons why this might happen, and the coaches can help you work through it.
Do not just endure and hope you'll make it to the end of the semester.

## What if one of our teammates is too forceful?

Just like above, please contact your coaches as soon as it becomes apparent that one of your teammates is "taking over" the team (pushing people around, replacing code you wrote, making changes without discussing with the team, etc.).
This is unprofessional, but there can be many reasons for this, and the coaches can help you work through it.
Do not persist in suffering just out of camaraderie.

## Why do Figma wireframes in addition to mockups?

Wireframes are important for thinking about layout, structure, hierarchy, functionality, etc. before diving into aesthetics.
Mockups are more detailed and have the full visual design, including colors, typography, etc.
One can easily get bogged down into aesthetics and end up compromising on structure if they don't start with wireframes.
And this can come back to bite them later (i.e., spend more time later than they would've if they had done the wireframes).

## Why is presence at the weekly Scrum ceremonies mandatory?

This is probably the first time you get to develop software collaboratively in a large team, and this involves many challenges.
SwEnt's raison d'être is to teach you how to handle these challenges before you go out in the real world and face them for real.
What works for teams of 2-3 people rarely works for teams of 6-7 people.
And, while working as a team in-person is hard, working as a team _remotely_ is even harder. 
Here are a few reasons:

- _Problem solving and brainstorming_:
Complex issues will come up, and such issues are solved more quickly through in-person discussions.
Nuances can be clarified in real-time.
In-person interaction leads to high-bandwidth communication, in contrast to instant messaging or Slack.
In-person collaboration makes it easy to pair-program, troubleshoot together, and share insights in real-time.
SwEnt has a huge workload, and you cannot afford the inefficiencies introduced by remote participation.

- _Work efficiency_:
Physical presence plus discipline enhance focus and participation, while working from home introduces distractions.
In remote settings, technical issues, an incomplete view of each other, and communication barriers make it hard for people to create a rapport.
Consider having a 5-hour hackathon in-person every week instead of working remotely and being on Discord 1h every day.

- _Team cohesion_:
Face-to-face interactions build trust, camaraderie, and a sense of shared purpose among team members.
This, in turn, helps overcome the inevitable hurdles that show up.
Teams where some of the members are remote will inevitably fragment and, by the end of the semester, break apart.
Misunderstandings and conflicts are the classic undoings of teams.
Consider meeting in-person 3-4 times/week during the start of the semester, and then switch to 1-2 times/week in the second half of the semester, once your team gels.

- _Accountability and motivation_:
Regular in-person meetings help ensure everyone stays on track, identify potential roadblocks early, and motivate the team members.
A central part of Scrum, the agile method we practice in SwEnt, is the daily standup, and the role of this standup is to get everyone on the same page and keep the team members accountable and motivated. 

- _Improved distribution of workload_:
In-person discussions facilitate a fairer and more transparent process of assigning responsibilities and adjusting load.
You will make estimates during sprint planning, but these estimates have serious margins of error, and thus need to be adjusted during the sprint.

The meeting between your team and the coaches also must be in-person, and here are some of the reasons:

- _Clearer guidance and feedback_:
Direct, face-to-face communication allows for immediate clarification of project requirements, expectations, and detailed feedback on progress.
Our staff are trained for such in-person debriefs and feedback sessions.

- _Building mentor relationships_: In-person meetings foster a stronger connection between the student team and staff, leading to more personalized mentorship and support.

- _Resolving conflicts proactively_: Potential misunderstandings or conflicts can be addressed quickly and constructively in face-to-face settings, preventing escalation. The staff are trained to pick up early signals of conflicts, and to mediate; these signals are likely to get lost in the case of remote attendance.

- _Demonstration of commitment and professionalism_: In-person meetings signify the team's dedication and value for the staff's time and expertise. 
Our staff have invested hundreds of person-hours to prepare this course, and they are very motivated to help you become the most accomplished and competitive professionals you can be.

> [!NOTE]
>When moving from in-person interaction to on-line interaction, teams lose something very precious: non-verbal communication. This includes facial expressions (smiles, frowns, raised eyebrows, etc.), body language (posture, gestures, eye contact, etc.), paralanguage (tone of voice, pitch, volume, pace), touch (handshakes, pats on the back, etc.), and appearance. Humans have evolved to use all these in order to transmit information to each other. In teams, non-verbal communication builds trust and rapport, non-verbal cues offer insights beyond spoken words (e.g., body language and tone of voice reveal a person's true emotions, leading to a better understanding of their message and potential concerns; much of this is lost over Zoom or Discord). Non-verbal communication enhances collaboration: nodding, gestures, and mirroring body language signal agreement, engagement, and active listening, making discussions more productive and inclusive. Non-verbal signals prevent misunderstandings, especially in cross-cultural teams. 

It is impossible for an engineer to be effective at remote collaboration before becoming effective at in-person collaboration. This is not only the conclusion of scientific studies but also our own personal conclusion. First, over the years we've been teaching this course, we found that the teams where members skip meetings or do not engage fully with the rest of the members are precisely the teams that have serious collaboration problems and lead to the formation of cliques The typical outcome is failure of the entire team. And there are no winners on a losing team. Second, our friends and peers who are currently managing large software organizations are observing that recent graduates really need to be present in the office to become effective as part of a team (and they are referring to engineers who have already graduated with a Masters, who have more project experience than SwEnt students). 
SwEnt aims to teach you how to work as a team in-person, and this must come before you can operate as a team remotely.
You must learn to walk before you run.

If you look at the software industry, there is an increasing shift from the peak of fully-remote work during Covid towards a greater degree of in-person interaction, trending toward a hybrid model. Companies that initially went fully remote have experienced challenges with long-term remote work (in particular w.r.t. collaboration and the sense of belonging), which has led them to revise their policies to encourage more in-person time, even though this means an increase in costs for leasing office space. We implement such a hybrid approach in SwEnt: there is one time period (Friday morning) when you are required to invariably be on-campus, and the other days of on-campus activities with your team can be scheduled at the convenience of the team. When scheduling this in-person time, keep in mind that your primary goal at this point is to get the best education you can, because it is the best investment you can make for your future. As a future employee you will have to be better than the AI.