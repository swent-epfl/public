# Mobile

## Exercise 1: Activities
An activity represents a single screen in your app with a UI that the user can interact with. For example, an email
app might have one activity that shows a list of emails in the inbox, another activity to write a new email, and
another activity for displaying the content of an email.

An activity's lifecycle is the set of states an activity can be in during its entire lifetime, from the time it is
initially created to when it is destroyed. As the user interacts with your app, the different activities move into
different states. When an activity transitions into and out of the different lifecycle states as it runs, the Android
system calls several lifecycle callback methods at each stage. All the callback methods can be overridden in each of
your Activity classes to define how that activity behaves when the user leaves and re-enters the activity.

![Activity Lifecycle](res/activity_lifecycle.png)

**Question:** Your friend is developing an email app, he is currently working on a new feature. When the users quit the app while
writing an email, the new feature is going to save it as a draft instead of being lost. Can you help him by
explaining how you would implement it?

## Exercise 2: Intents
All Android activities are started or activated with an intent. Intents are message objects that make a request to
the Android runtime to start an activity or other app component in your app **or in some other app**. You don't start
those activities yourself. When your app is first started from the device home screen, the Android runtime sends an
intent to your app to start your app's main activity. In addition to starting activities, intents are also used to
pass data between activities. When you create an intent to start a new activity, you can include information about
the data you want that new activity to operate on. So, for example, an email activity that displays the list of
emails in the inbox can send an intent when a user clicks on an email to the activity that displays the content of an
email. The display activity needs data about the email inorder to display it, and you can include that data in the
intent.

**Question:** Your friend is working on developing a document scanner app, she's developing a feature to be able to take a picture
of a document and another one to be able to preview a pdf file. What advice can you give her to avoid having to
develop those capabilities herself?

## Exercise 3: Services

A service is an application component that performs long-running operations, usually in the background. A service
doesn't provide a UI.

**Question:** While reviewing the pull request of a friend you notice that he periodically fetches data from the cloud in his activity? What
potential problem this could lead to, and how can you fix it?

## Exercise 4: Practical MVVM Model
In this exercise, you'll follow through and get familiar with the basic framework that you'll be using for the bootcamp and your project (Kotlin and Jetpack compose).

We assume that you have setup Android Studio with Kotlin, so if you haven't please make sure you follow the first steps of the **bootcamp** to have an environment that is ready!

Head over to [the first](./MVVM/) code base (MVVM) and follow the instructions there. Use the files provided and build upon those to create your app.

## Exercise 5: Persistence
It is common that you may want to cache data locally to avoid too many requests over the internet (slow!) or even in case you lose connection and still want to maintain a functionning app.

In [this section](./persistence/), we will expand your application from Exercise 4 and explore how to cache the data implement this local cahe feature. We provide you with a new code base with a few modifications to the previous one.