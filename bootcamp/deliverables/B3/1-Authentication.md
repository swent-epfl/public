# Authentication

Now that you have a working ToDo application, it’s time to switch it into a user-based application.
Each user will have their own account, and their own set of ToDos.

<p align="center"><p align="center">
  <img alt="Greeting 2.0 app screenshot-1" src="assets/SignInScreen.png" width="30%" />
  <img alt="Greeting 2.0 app screenshot-1" src="assets/OverviewScreen.png" width="30%" />
</p>

In this section, you will use **Google Sign-In** to authenticate users.

## Google Credential Setup

To implement the Google Sign-In feature, you will use the [Credential Manager API](https://developers.google.com/identity/android-credential-manager) and [Firebase Authentication](https://firebase.google.com/docs/auth/android/google-signin).
The required libraries have already been added to your project.
You can verify that in the `app/build.gradle.kts` file of your app module.

You will need to add your SHA fingerprints to Firebase so it can use it to verify that sign-in requests really come from your signed app and not from someone else.

To do this run `./gradlew signingReport`, you can also run it from the gradle interface in Android Studio.

To add your SHA-1 fingerprint into your Firebase console, go to **Project Settings** → **General** → **Your apps** → **Add fingerprint**.

You need to enable Google as a sign-in method in the Firebase console: go to **Project console** → **Authentication** → **Sign-in method** → **Google**.

After enabling Google Sign-in, you must download an updated `google-services.json` file from Firebase, as enabling this authentication method generates additional configuration data that your app needs.
Put the new file under `app/google-services.json` (replace the old one).

Then **update the GitHub secret** the same way you did in B2 ([Setup Backend — uploading `GOOGLE_SERVICES`](../B2/1-SetupBackend.md#uploading-on-github)):

1. Base64-encode the new file (same commands as in B2).
2. Open your repo → **Settings → Secrets and variables → Actions**.
3. Update the existing secret named **`GOOGLE_SERVICES`** with the new base64 contents (or create it if it is missing).

CI uses that secret, not whatever is only on your laptop. This is **not** the Maps secret (`LOCAL_PROPERTIES` from the [Maps](4-GoogleMaps.md) step)—leave that one alone unless you change your Maps API key.

You will also use the MVVM architecture that you already used for the todos and the map.
You can take a look at [this refresher](https://github.com/swent-epfl/public/blob/main/bootcamp/docs/MVVM.md) on the MVVM pattern.
Read `AGENTS.md` at the repo root for how to work with agents; for authentication, structure the feature as sketched below (same shape as the reference solution).

## Recommended structure (not sigchecked)

These types are **not** in the template stubs and **not** enforced by `sigchecks/`. They are the intended layout:

- `model/authentication/AuthRepository.kt` — interface with `signInWithGoogle(credential: Credential): Result<FirebaseUser>` and `signOut(): Result<Unit>`.
- `model/authentication/AuthRepositoryFirebase.kt` — Firebase implementation: turn the Credential Manager result into a Google ID token, then `FirebaseAuth.signInWithCredential(...)`; `signOut()` calls `Firebase.auth.signOut()`.
- `model/authentication/GoogleSignInHelper.kt` — small helper interface (plus a default implementation) to extract the Google ID token from the credential `Bundle` and build a Firebase `AuthCredential`. Keeps the repository unit-testable without statically mocking the Google SDK.
- `ui/authentication/SignInViewModel.kt` — holds `AuthUIState` (`isLoading`, `user`, `errorMsg`, `signedOut`), takes an `AuthRepository` (default `AuthRepositoryFirebase()`), and exposes `signIn(context, credentialManager)` that:
  1. builds a `GetSignInWithGoogleOption` with `R.string.default_web_client_id`,
  2. asks the injected `CredentialManager` for a credential,
  3. calls `repository.signInWithGoogle(...)`,
  4. updates the UI state.
- `SignInScreen` — composable that takes the injected `credentialManager` (and a `SignInViewModel`), shows the Google button, and triggers `viewModel.signIn(...)`.
- Logout on Overview — use the **same** `credentialManager` instance; clear the Firebase session (via your auth repository / `Firebase.auth`) and navigate back to `SignInScreen`.

Wire `BootcampApp` so unsigned users land on `SignInScreen` and signed-in users on `OverviewScreen`.

## Sign In with Google

This feature is described by the following user stories:

> As a user, I want to sign up and log into the app, so that my ToDos are kept across devices.
> As a user, I want to sign in with my Google account, so that I can securely access my personal ToDos.

From these user stories, we define the following acceptance criteria:

- The user can sign in with their Google account.
- The user can sign out from their account.
- If a user logs out and logs back in with the same account, they can see their previously created ToDos (once [access control](2-AccessControl.md) is in place, those ToDos must belong to that account).

> [!NOTE]
> Restricting which ToDos a user can see or modify is the next step ([Access Control](2-AccessControl.md)). Do not skip it.

You can start by implementing the UI for the sign-in screen.
You can find a mockup of the screen on [Figma](https://www.figma.com/design/IDm3NGS988Myo01P0Wa0Cr/TO-DO-APP-Mockup-FALL?node-id=435-3350)

> [!NOTE]
>
> `BootcampApp` already takes a `credentialManager` parameter (default: `CredentialManager.create(context)`).
> Pass that same instance into your `SignInScreen` (add a parameter with a default value if you need to).
> Instrumented tests inject a **fake** `CredentialManager` into `BootcampApp` so they can sign in without a real Google account—your code must use the injected instance, not create a second one inside the screen.

Once you are done with the screen, you can implement the sign-in logic.
We recommend you to read [Authenticate users with Google on Android](https://firebase.google.com/docs/auth/android/google-signin).
They explain the core concepts to implement the sign-in feature.

> [!NOTE]
>
> The Credential Manager allows you to obtain credentials from a user.
> You can then use these credentials to authenticate the user with Firebase Authentication.

The *requirements* for the Sign-In feature are the following:

- Users can sign in using their Google account.
  When the sign in process completes successfully, they should be redirected to the Overview screen.
- Users can log out by pressing the log out button on the Overview screen.
  If the log out is successful, they should be redirected to the Sign-in screen.
- Users can sign in with any Google account. The account does not need to be the device's account and should allow users to enter a new Google account.

You will also need to update your `BootcampApp` composable to satisfy the following requirements:

- If the user is not signed in, the app starts on the `SignInScreen`.
- If the user is signed in, the app starts on the `OverviewScreen`.
- There is not explicit requirement on how to handle the case where the user exits the app while signed in.
  In other words, you can choose to resume existing sessions or to require the user to sign in again.

> [!NOTE]
>
> The same credential manager instance should be used for both sign-in and sign-out.
<p align="center"><img alt="Greeting 2.0 app screenshot-1" src="assets/OverviewScreen.png" width="30%" />

### Test your implementation

Once you're done with your implementation, build and run the app to check that everything works as expected.
We provide you with the `AuthenticationB3Test` test suite for this step.
It does not check the requirements in depth.
You should write your own tests to ensure that your implementation is correct.

> [!NOTE]
> Some tests use the Firebase emulator.
> Make sure to start it first by running `firebase emulators:start` in your terminal.

As in B1, you will need to attach test tags to your UI components to pass our tests. All required test tags are defined in the `SignInScreenTestTags` and `OverviewScreenTestTags` objects. Check [Figma Testing mockup](https://www.figma.com/design/IDm3NGS988Myo01P0Wa0Cr/TO-DO-APP-Mockup-FALL?node-id=435-3350&p=f) to see where each tag should be placed.

Do not edit anything under `sigchecks/`. Keep the provided signatures so `SignatureChecks` still compiles.

---

Congrats, you're done!

> [Next Step: Access Control](2-AccessControl.md)
