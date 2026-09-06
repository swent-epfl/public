# SwEnt Bootcamp

This Bootcamp is an assignment for the [SwEnt course](/README.md) course.
It starts on Monday, 7-Sep-2026, and ends on Wednesday, 23-Sep-2026.
The Bootcamp is split into three milestones, each one corresponding to roughly one week of work (8&ndash;12 hours) for the course.
You will find here all the information you need to complete the Bootcamp.

  - [The Assignment](#the-assignment)
  - [Deliverables](#deliverables)
  - [Levels](#levels)
  - [Getting Help](#getting-help)
  - [Getting Started](#getting-started)

## The Assignment

<p align="center">
  <img alt="Android Studio MoreActions button" src="assets/AuthScreen.png" width="20%" />
  <img alt="Android Studio MoreActions button" src="assets/OverviewScreenFull.png" width="20%" /> <img alt="Android Studio MoreActions button" src="assets/MapScreen.png" width="20%" />
</p>

In this Bootcamp, you will build a mobile app for managing ToDos, i.e., for creating, viewing, and managing things you want to get done.
The app will include several features that are common in modern mobile applications, such as:

- Google authentication
- cloud-based backend (Firebase database)
- use of the current location and use of the Google Maps API
- use of the Nominatim API for geocoding and location-based information

### Learning Objectives

SwEnt is an engineering _methodology_ course, not a programming course.
The Bootcamp is meant as a guide to familiarize you with the Android ecosystem and to provide pointers for what to read in more depth in preparation for the project.
The Android ecosystem uses a variety of tools and frameworks, such as Kotlin, Jetpack Compose, or Firebase.
Learning them is an engineering task that will need to be performed in parallel with completing the Bootcamp&mdash;we will not be teaching any of these in lectures.

By the end of the Bootcamp, you should be able to start your own Android project from scratch, and in the project implement an amazing app by the end of the semester!

As part of the Bootcamp, you will experience some of the pitfalls of real-world software engineering: dealing with ambiguous and incomplete documentation, working around bugs and limitations of third-party tools, organizing code for compliance and integration with blackbox pipelines, etc. You will start learning how to plan and estimate development time effectively, in order to stay on schedule despite these pitfalls. During the project, you will hone these skills to mastery.

### Deliverables

Each week has one deliverable, corresponding to one milestone. The deliverables are described in the [README](deliverables/README.md) in the [deliverables](deliverables/) folder. You do not need to turn these in to us, they're to give you an indication of the expected pace. 

> [!IMPORTANT]  
> The Bootcamp is not a graded assignment. It's role is to help you ground in practice the concepts taught in lecture, and to get you ready for the project. 

> [!WARNING]  
> The Bootcamp is required material for the [exam](/exam/README.md). Do not use an LLM or agents to write the code, because that will deprive you of gaining the knowledge and practice needed on the exam. You are encouraged however to use an LLM to help you understand deeper the bootcamp, and an agent can review the code you write and suggest improvements.

By pushing your solution to your individual repository `https://github.com/swent-epfl/bootcamp-26-<your GitHub username>`, you will receive quick feedback: the CI runs tests on each milestone work branch (`main` for B1, `B2` for B2, `B3` for B3), and a green CI is a good indicator that you have understood the milestone and wrote the right code.

> [!NOTE]  
> Once all the public tests pass in the CI on a milestone branch (or on a PR for it), we will push the reference solution to your repo on a branch called `Bi-solution`, where `i`∈ {*1,2,3*}. This will allow you to advance in the bootcamp at your own pace.

## Levels

### General Principles

- We have five tiers of performance, defined by analogy to the belts in martial arts:
  - <span style="background-color: #f2f2f2;">White Belt</span> is where students start. Typically the lack of effort and investment (and more rarely the lack of ability) keeps some students within this tier, where they do not achieve a satisfactory command of the basics, and so they do not pass the course.
  - <span style="background-color: #FCE883;">Yellow Belt</span> is for students who have more or less learned the basics, but do not demonstrate much more than a basic competence.
  - <span style="background-color: #77DD77;">Green Belt</span> is for average students, i.e., those who have a good command of the basics and know some of the more advanced topics but not all.
  - <span style="background-color: #87CEFA;">Blue Belt</span> is for the good students, i.e., those who fully master the basics and are in good command of the more advanced aspects of the course.
  - <span style="background-color: #3F3F3F; color: white;">Black Belt</span> is for those who demonstrate full mastery and true excellence.
- It gets progressively _harder_ to achieve higher tiers (e.g., going from Blue to Black is much harder than going from Yellow to Green), but does not require progressively _more work_ (e.g., going from Blue to Black does not require more time than going from Yellow to Green). In other words, what distinguishes tiers is the amount of ingenuity, creativity, insight, and refinement required to achieve the desired outcome. We don't reward the volume of work invested.  Sometimes, one could make up for lack of ingenuity by taking the more tedious path and working longer hours (e.g., debugging by hand instead of using the appropriate tools), but that comes at the expense of doing other things. Work smarter, not harder. 
- In order to move to an upper tier, you must fulfill all requirements for the lower tiers. For example, to reach the Blue Belt tier, you must first have met every requirement for the Green Belt (and recursively for Yellow and White).

## Getting Help

In the [docs](docs/) folder, we prepared some theory recaps and tutorials.
There are also useful links to help you understand the Android ecosystem. Feel free to read them whenever you need to. They are optional.

Do not hesitate to look for help on your own.
You can ask your favorite LLM for explanations, read the Android documentation, etc.
Piecing together code snippets in the hope of patching together a Bootcamp deliverable is a poor strategy, because you will spend a lot of time and learn little.
Work smartly and keep your long-term interests in mind. And don't forget the exam at the end of week 3.

## Getting Started

Once you read the information above, you can start the assignment.
Remember that this is a Bootcamp that will help you discover the Android ecosystem and prepare you for the project.
You will have to invest 8&ndash;12 hours per week to successfully complete the Bootcamp.
Keep that in mind, and don't wait until the last minute to get started.

Proceed now to the [deliverables](deliverables/README.md).
