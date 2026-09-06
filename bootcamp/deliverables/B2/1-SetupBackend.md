# Setup Backend

## Introduction
*Firebase* is a backend platform developed by Google that's popular for building Android apps. It includes tools like a real-time database, a newer database service called *Firestore*, user authentication, and many other APIs you can explore on their website[^1].

*Firestore* is a NoSQL cloud database that follows a key-value store model. For a detailed overview of its features, please see the official documentation[^2].

In this milestone, we will use Firebase/Firestore and the *Firebase Emulator Suite*, which allows you to test your app locally without making live network calls or modifying production data. This enables more robust testing and simplifies debugging.

## Objective

This section of the bootcamp will get you started with Firebase's Firestore database and introduce the Firebase Emulator Suite for testing your app's Firebase logic locally.

We'll walk you through setting up your account and preparing your app for both online and local (emulated) backend operations.

> [!WARNING]
> All the required libraries **are already in the provided repository**. Please use only the provided versions of the libraries, as other versions may cause compatibility issues.
>
> For compatibility reasons, the Google Services plugin is deactivated in `app/build.gradle.kts` for B1. You will re-enable it **after** you add `google-services.json` (a step below), because the plugin fails to sync when that file is not present yet.

## 1 - Setting Up Firestore for our App

> [!TIP]
> Make sure you are using a personal Google account (not your EPFL account) when working with Firebase.


First, go to the Firebase console: <https://console.firebase.google.com>. On the main page, click 'Get started by setting up a Firebase project'. In the project setup wizard, name the project "bootcamp", and disable both Analytics and AI assistance.

<p align="center"><img alt="welcome screen firebase" src="assets/creatingFirebaseProject.png" width="80%" /></p>


Once the project is created, go to its 'Overview' page. You can access it via the console (link above) by clicking on the project panel with your project's name.

We need to add the Android app to the project. On top of the 'Overview' panel, below the name, click on the 'Add app' button. Then click on the Android button (a little Android logo, the robot one). Follow the instructions as needed on the page (shown in the picture below).

<p align="center"><img alt="overview Screen" src="assets/addAnApp.png" width="80%" /></p>

Under **Android package name**, enter `com.github.se.bootcamp`.

Next, you will need to put the `google-services.json` in your project **under the `app` folder**.  

> [!WARNING]
> Do not commit the file to your repository, as it contains sensitive IDs. Later we will see how we can safely add it to
> GitHub.
  
<p align="center"><img alt="overview Screen" src="assets/whereToPutGoogle-services-json.png" width="80%" /></p>

If you forgot to download the JSON file :

- Go back to the Firebase console.
- Go to the settings of the project (top left of the webpage).
- Under the 'General' tab, go to the bottom and under 'Your apps' you will find the json file.

> [!NOTE]
> Regarding the 'Adding the SDK of Firebase' you may ignore it as it is already present in the project template.

> [!IMPORTANT]
> Now that `google-services.json` is in the `app/` folder, re-enable the Google Services plugin: in `app/build.gradle.kts`, remove the comment on the line `// alias(libs.plugins.gms)` in the `plugins` block, then sync Gradle. Doing it now (and not earlier) avoids a sync failure caused by the missing file.

To add **Firestore**, the database, to the project, open **Build > Firestore Database** from the left sidebar of the console (the exact menu wording may vary slightly), then click 'Create database'.

<p align="center"><img alt="overview Screen" src="assets/addFirestore.png" width="80%" /></p>

For the database location, pick a European multi-region such as `eur3` if the picker offers it. If you cannot type or select it, any location works for the bootcamp, so keep the default and move on. Click "next" and select 'Start in test mode', which temporarily enables read and write access requiring security configuration.
Finally, click 'Create'. You now have your Firestore database ready to go!

### GitHub Secret : encoding the file

Next, we need to setup the secrets in the GitHub action.

The file we want to upload that way is the `google-services.json`. If you have committed it, [remove it from the repository](https://stackoverflow.com/questions/1143796/remove-a-file-from-a-git-repository-without-deleting-it-from-the-local-filesyste).

First, we must convert the file to a string. In this case we could simply open it as a text file, but this is not the case for every file you may have to manage, so we'll do the complete operation.
We will use [Base 64 encoding](https://en.wikipedia.org/wiki/Base64), which encodes any sequence of bytes into a string of printable characters, exactly what we need since GitHub only allows text for the secrets.

- **`google-services.json`**:

  On Linux (in the terminal):

  ```sh
  base64 path/to/google-services.json > base64_google_services.txt
  ```
  
  On MacOS (in the terminal):

  ```sh
  base64 -i path/to/google-services.json -o base64_google_services.txt
  ```

  On Windows (**in the powershell**):

  ```powershell
  [Convert]::ToBase64String([IO.File]::ReadAllBytes("path/to/google-services.json")) > base64_google_services.txt
  ```

>[!NOTE]
> The output file is created in the directory from which the command is run.

#### Uploading on GitHub

Follow this [tutorial](https://docs.github.com/en/actions/security-for-github-actions/security-guides/using-secrets-in-github-actions#creating-secrets-for-a-repository) to add the file you created in the previous step as a GitHub secret, and name the secret `GOOGLE_SERVICES`.

#### Using the secret

The final step is to retrieve the secret in the CI so the testing jobs can run correctly. This is already implemented in the bootcamp workflow.
<details>
<summary><span style="font-size:1.25em; font-weight:bold;">Libraries (Optional)</span></summary>
<br/>

The libraries required for Firebase <span style="color:red">**are already in the provided template**</span>.
However, it's useful to understand how they are managed, as you will add more libraries by yourself in your project.

1. `libs.versions.toml`  

   ```toml
   # gradle/libs.versions.toml

   [versions]
   gms = "4.5.0"
   firebaseBom = "34.18.0"

   [libraries]
   firebase-auth = { module = "com.google.firebase:firebase-auth" }
   firebase-bom = { module = "com.google.firebase:firebase-bom", version.ref = "firebaseBom" }
   firebase-firestore = { module = "com.google.firebase:firebase-firestore" }
   ```

2. Top-level `build.gradle.kts`:

   ```kotlin
   # build.gradle.kts
   plugins {
       alias(libs.plugins.gms) apply false
       ...
   }
   ```

3. `app/build.gradle.kts`:

   ```kotlin
   # app/build.gradle.kts
   dependencies {
       implementation(platform(libs.firebase.bom))
       androidTestImplementation(platform(libs.firebase.bom))

       // Firebase
       implementation(libs.firebase.firestore)
       implementation(libs.firebase.auth)
       ...
   }
   ```

4. **Sync your Gradle project**

### Summary

By defining the Firebase BOM and Google Play services libraries in `libs.versions.toml`, you centralize the management of library versions, making it easier to update and maintain dependencies across your project. This approach keeps your `build.gradle.kts` files clean and focused on their specific configuration needs. The Firebase artifacts themselves do not declare a version, the BOM supplies it.

</details>

### Tutorials

You can find many resources online about Firebase's Firestore database.

Again, you can refer to its official documentation[^2].

Feel free to explore online for videos, forums, and other websites explaining the core functionalities of Firebase.
> [!TIP]
> The best way to practice is to start with simple functions and gradually move to more complex ones.

### Remarks

Below are three important points that you may need in your database at a later date.

- Firebase provides *event listeners* that automatically trigger when the value at a specific key changes. For more information, see [this official FireBase documentation](https://firebase.google.com/docs/reference/android/com/google/firebase/firestore/EventListener) on `EventListener`
 
- In this bootcamp, we don't use Firebase's transaction feature, so concurrent updates aren't supported. You would need transactions[^3] to handle that.

- Values are automatically serialized to strings when stored in Firebase. This is particularly useful as it allows you to store Kotlin objects directly in your database.

## 2 - Setting up Firebase Emulation

Firebase Emulators[^4] simulate Firebase services locally on your machine. This enables you to test without having to manually mock every Firestore interaction in your app. They are also useful for collaborative development. For example, if a feature requires a schema change, using the emulators prevents backend conflicts with other features being developed in parallel.

### Installation

To install the Firebase Emulator Suite, you will need the following:

- [Node.js](https://nodejs.org/en/download) version **20** or higher
- [Java JDK](https://jdk.java.net/) version **21** (current Firebase Emulator Suite / `firebase-tools` requires JDK 21+)
- [The Firebase CLI](https://firebase.google.com/docs/cli)

Once everything is installed, run `firebase login` and set the credentials to the account you used to create your Firebase project. After signing in, you should be able to see your Firebase projects by running `firebase projects:list`.

The repository already ships the Firebase config (`firebase.json`, the Firestore rules and the emulator setup), so you do **not** run `firebase init`: it would clash with those existing files. The only thing missing is the link to your project. From the root directory of your application, run:

```sh
firebase use --add
```

and select your bootcamp project (the same one defined in `app/google-services.json`). This creates the missing `.firebaserc` file. At this point you are all set and can begin testing with the emulators.

### Usage

The Firebase emulators can be started by running `firebase emulators:start`. After they're running, open the dashboard at `http://localhost:4000/`.

> [!NOTE]
> The provided tests already connect to the emulators for you (see the next section), so you do **not** need the snippet below to pass them. It is only useful if you want to run the **app itself** against the emulators for manual debugging.

To point the app at the emulators during a manual debug run, call these methods **before any other Firebase API call**, and only in debug builds (never in release):

```kotlin
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

if (BuildConfig.DEBUG) {
  Firebase.firestore.useEmulator("10.0.2.2", 8080)
  Firebase.auth.useEmulator("10.0.2.2", 9099)
}
```

Pass the correct port numbers as arguments if you are not using the default ones.

`10.0.2.2` is the special alias the Android emulator uses for your laptop. The bootcamp template already includes a **debug** network security config that allows cleartext HTTP to that host, so you do not need to add `android:usesCleartextTraffic="true"`.

### Usage in Android tests

To use the Firebase Emulators in Android tests, we provide you the `FirebaseEmulatedTest` class. Extend your test classes from it, for example:

```kotlin
class LoginTest : FirebaseEmulatedTest() {
  ...
}
```

Next, launch the emulators with `firebase emulators:start` to run the Android tests. The tests will automatically connect to the emulators, so you don't have to call `.useEmulator` manually.

> [!NOTE]  
> For each test, the accounts and documents it creates in Firestore are cleared afterward, ensuring that tests run independently.

For advanced usage such as state import/export or CI integration, refer to the [Firebase documentation](https://firebase.google.com/docs/emulator-suite/install_and_configure).

[^1]: <https://firebase.google.com/products-build>
[^2]: <https://firebase.google.com/docs/firestore>
[^3]: <https://firebase.google.com/docs/firestore/manage-data/transactions>
[^4]: <https://firebase.google.com/docs/emulator-suite>

---

Congrats, you're done!

> [Next Step: Set Up Agent](AgenticWorkflow.md)
