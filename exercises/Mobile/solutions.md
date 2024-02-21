# Solutions: Mobile

## Exercise 1: Activities
### Evaluation Criteria

- Shows a good understanding on what is Android Activity and its lifecycles

### Proposed Solution

He should override the `onDestroy()` callback and persist the data in it, which is called when the activity is
finishing (user dismissing the activity) or being destroyed by the system. Then he should also override
the `onResume()` callback to retrieve the persisted data and to display it as a previous draft. He should also note
that in case of a sudden shutdown, because of resource constraints or not enough battery, the `onDestroy()` method will
not be called. Therefore, if it's very important he should save data as soon as the user enters it.


## Exercise 2: Intents
### Evaluation Criteria

- Shows a good understanding on what is an Intent and it's different use cases.

### Proposed Solution

If she doesn't need to have a custom camera feature, then she should simply use the set of core apps that comes with
an android by default. The way this can be done is by using an implicit intent. She needs to include just enough
information in the intent about the task she wants to perform. The Android system matches the information
in the requested intent with activities available on the device that can perform that task (e.g. a camera, or pdf
viewer).

## Exercise 3: Services
### Evaluation Criteria

- Shows a good understanding on what is a Service and how to use it properly.

### Proposed Solution

Running a blocking operation in an activity, such as a network operation, can lead to a bad user experience, because
of lack of reactivity of the app in case of a slow network. He should use a service to fetch the required data, and
he must create a new thread within the service to do that work. By using a separate thread, the application's main
thread can remain dedicated to user interaction with your activities.

## Exercise 4 and 5: Practical app coding
### Evaluation Criteria

-  Providing clean code and an app product behaving as expected.

### Proposed Solution
We have provided the solutions for both exercises that can be found in in the `app_solutions/` folder.