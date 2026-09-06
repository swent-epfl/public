
# Setting up the Continuous Integration

During the Bootcamp, your code will be tested automatically through **Continuous Integration (CI)**. For now, the CI runs on a cluter of self-hosted machines at EPFL. Later in your project, you will switch to GitHub-provided Actions runners.

This page will guide you through understanding the CI and the tools involved.

## Continuous Integration with GitHub Actions

CI ensures your code compiles and tests pass every time you push.  

The configuration is defined in `.github/workflows/CI.yml`.

Near the top of that file, one line selects which milestone CI is grading:

```yaml
BOOTCAMP_PART: B1   # change to B2 (later B3) when you start the next milestone
```

CI always runs a few always-on checks, plus the tests for the **current part**. For that part you will typically see:

1. **`{part}-public`** runs the public tests for the current part, then the staff tests on that same emulator. **Public must pass** for this job to be green (and for solutions unlock). Staff may fail; that only shows as a warning and does not block the unlock of the solutions.
2. **Always-on checks** — formatting / assemble / lint.
3. **User story checks** — validates that your `userStories.txt` file has the correct format. You will write the user stories in the [User Stories](7-UserStories.md) step.
4. **Time tracking** — validates that the `actualTimeB*.csv` files have been completed for the milestones you have started.

## Code Coverage

Throughout the semester, we measure code coverage using [JaCoCo](https://www.eclemma.org/jacoco/). This is already installed in your project, so you don’t need to configure it yourself.


To generate a coverage report:

```bash
./gradlew check connectedCheck jacocoTestReport -B1
```

The HTML report will be located at:

```
app/build/reports/jacoco/jacocoTestReport/html/index.html
```

> [!TIP] 
> `jacocoTestReport` depends on the results of `check` (unit tests) and `connectedCheck` (instrumented tests).  
> Always run them together as shown above.

<details>
<summary>Optional: How JaCoCo is configured</summary>

Configuration is already present in `app/build.gradle.kts`.  


```gradle
android {
    ...
    buildTypes {
        ...
        debug {
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
        }
    }
}
```

And the following at the end of the file. It sets up coverage for the `debug` build type and excludes generated files.  

```gradle
tasks.register("jacocoTestReport", JacocoReport::class) {
    mustRunAfter("testDebugUnitTest", "connectedDebugAndroidTest")

    reports {
        xml.required = true
        html.required = true
    }

    val fileFilter =
        listOf(
            "**/R.class",
            "**/R$*.class",
            "**/BuildConfig.*",
            "**/Manifest*.*",
            "**/*Test*.*",
            "android/**/*.*",
            "**/sigchecks/**",
        )
    val debugTree =
        fileTree(project.layout.buildDirectory) {
            include(
                // AGP 9 compiles Kotlin with its built-in compiler, which writes here
                "intermediates/built_in_kotlinc/debug/compileDebugKotlin/classes/**",
                // Fallback for the AGP 8 layout
                "tmp/kotlin-classes/debug/**",
            )
            exclude(fileFilter)
        }
    val mainSrc = "${project.projectDir}/src/main/java"

    sourceDirectories.setFrom(files(mainSrc))
    classDirectories.setFrom(files(debugTree))
    executionData.setFrom(
        fileTree(project.layout.buildDirectory) {
            include("outputs/unit_test_code_coverage/debugUnitTest/testDebugUnitTest.exec")
            include("outputs/code_coverage/debugAndroidTest/connected/*/coverage.ec")
        }
    )
}
```


If you use tools like [Hilt](https://developer.android.com/training/dependency-injection/hilt-android), you may need to exclude additional generated classes (e.g. `**/*Hilt*.*`, `hilt_aggregated_deps/**`, etc.).


</details>



## Use Robolectric to Speed up Testing (Optional)

In Android, tests can run in two ways:

1. **`androidTest/` (instrumented tests)**  
   Run on a real or emulated device. Used for **UI tests** (buttons, screens, navigation) or anything needing the Android system.  

2. **`test/` (unit tests)**  
   Run directly on your computer. Used for **logic tests** (calculations, helpers, small classes).  


The problem: UI tests in `androidTest/` are slow. **Robolectric** lets you write some UI tests in `test/`, so they run faster.  

You may use it to speed up development, but note:  
- They may not behave exactly like on a real device  
- Debugging is harder since there is no visual feedback  

<details>
<summary>Optional: How to set up Robolectric</summary>

Add Robolectric to your dependencies:

```gradle
testImplementation("org.robolectric:robolectric:4.16.1")
```

By default, unit tests run twice: once for **debug** and once for **release** builds.  
In our project, there is almost no difference between the two, so running both only makes tests slower.

To save time, you can disable the release unit test task by adding this at the end of your `build.gradle.kts`:

```gradle
tasks.withType<Test> {
    onlyIf { !name.toLowerCaseAsciiOnly().contains("release") }
}
```

Create `app/src/test/assets/robolectric.properties`:

```properties
sdk=36
qualifiers=w360dp-h640dp-xhdpi
```


Now you can write UI tests in the `test/` sourceset (instead of `androidTest/`).  
To do that, duplicate any `androidTestImplementation` dependencies as `testImplementation`.

> :warning: JaCoCo and Robolectric are not fully compatible.  
> When running tests, you may see errors like:
> ```
> java.lang.instrument.IllegalClassFormatException: Error while instrumenting androidx/core/R$id with JaCoCo 0.8.8
> ```
> There is currently no simple workaround with the Android Gradle Plugin, but these messages are harmless and do not affect test results.


</details>



### Common issue

If you see:

```
Caused by: java.lang.ClassNotFoundException: org.gradle.wrapper.GradleWrapperMain
```

Run:

```bash
./gradlew wrapper
```

Then commit and push the updated `gradle/wrapper/gradle-wrapper.properties`.



All set! Your CI is now running. From now on, every time you push code, the CI will automatically build your app and run the tests to make sure everything still works.

> [Next step: Build your first APK](6-APK.md)
