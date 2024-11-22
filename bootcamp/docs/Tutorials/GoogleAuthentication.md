# 1 - Google Authentication - Introduction

You will need to add a way to login to your app. There are different ways to do so, here we explore to use of One Tap, which enables login with Google credentials.
You can always filter Google accounts, such as choosing to only allow accounts with a certain email domain.

## Requirement

First, make sure to enable Google authentication in Firebase. To do this, go to the left sidebar, navigate to **Build** > **Authentication** > **Sign-in method**, and select **Google**.

### Google Service Json

By this step, you should already have it in your project. You can find it here : Project Overview setting icon > project setting > general > your app (scroll down) > google-services.json

### Web Client Id

In Firebase, go to the left sidebar, navigate to **Build** > **Authentication** > **Sign-in method**, and select **Google**. Then scroll down to find **"Web SDK configuration"**.

Copy this value and paste it in `main/res/values/string.xml` inside  `<string name="default_web_client_id"> ... </string>`

### SHA Key

Next, run the gradle command `signingReport`. The command will print the SHA certificate fingerprints of different build variants of your project. Copy the `SHA1` value of the `debug` variant.

Then add it to Firebase : Project Overview setting icon > project setting > general > your app (scroll) > Add fingerprint

> [!TIP]
> SHA keys are unique to your computer.
> Updating Android Studio or your OS may require you to update your SHA key in Firebase.

## Tutorials

We recommend following [this tutorial](https://www.composables.com/tutorials/firebase-auth), which directly implements all the logic inside the composable. While this approach works, it's not considered best practice. Later, we will explore using the ViewModel and the MVVM pattern to separate the logic more effectively.

>[!WARNING]  
> Google recently released a Credential Manager API, thus deprecating the guide mentioned above. **You need to implement the above sign-in method in order to pass the tests** and not the Credential Manager.  
> Your sign-in method must utilize an Intent.

## Testing

You should isolate authentication behind an interface so that your tests for other components do not have to involve authentication directly, and can also test edge cases in users.

Try to have tests for the real authentication if possible, but keep in mind it's a small amount of code so you could choose not to cover it. You might struggle when it comes to testing the One Tap UI. This is because the One Tap component is not directly accessible. You can use [UI Automator](https://developer.android.com/training/testing/other-components/ui-automator) to "let you interact with visible elements on a device, regardless of which Activity is in focus". [Another tutorial](https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-2-user-experience/lesson-6-testing-your-ui/6-1-c-ui-testing/6-1-c-ui-testing.html#auto) on testing using UI Automator might come in handy.

Now you have a nice way to login using Google! :)

Congrats, you're done!

> [Return to the login and sign-in user story.](../ToDoApp/UserStories/UserStory.md#1-sign-in-and-login) \
> [Return to the Table of Contents](../../README.md#table-of-contents)
