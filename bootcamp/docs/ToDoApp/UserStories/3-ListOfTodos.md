# 3. List of ToDos

<p align="center"><img alt="OverviewOverviewScreen.png" src="../../assets/screen/OverviewScreenFull.png" width="40%" /> <img alt="NoTodoHomescreen" src="../../assets/screen/OverviewScreenEmpty.png" width="40%" /></p>

## Update the ViewModel

Our ViewModel needs to serve the data (our list of to-dos) to the UI. Have a look at [`MutableStateFlow`](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow); it allows emitting the current and new state updates to its collectors, in our case the UI.

> [!TIP]  
> To fetch the to-dos initially, use `init { }`. Init will run at the time of initialization of the ViewModel. Make sure the Repository is ready to access the database too.

## Update the `Overview` composable

In the `Overview.kt` file, update the `OverviewScreen` composable to match the user story and Figma.

For the status, the text should be the content of the status in lowercase, with spaces instead of underscores, and the first letter capitalized. E.g., `IN_PROGRESS` should be displayed as _`In progress`_.

Every time the `MutableStateFlow` emits a new value, the UI should update itself with the latest data. Take a look at [`collectAsState`](<https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#(kotlinx.coroutines.flow.StateFlow).collectAsState(kotlin.coroutines.CoroutineContext)>).

The body of the scaffold will consist of a `LazyColumn` composable. This composable is optimized to display a list of items of unknown size. You can find more information on how to use it in [the official documentation](https://developer.android.com/develop/ui/compose/lists#lazy).

---

## Validate your work

Follow these steps to validate your implementation:

1. **Run the signature checks**  
   Execute the [sigcheck](../sigcheck/ViewToDosSignatureChecks.kt) for this user story.
   See the [sigcheck README](../sigcheck/README.md) for details.

2. **Verify UI elements**  
   Make sure your UI matches the provided design mockups. Check [the Figma design](https://www.figma.com/design/IDm3NGS988Myo01P0Wa0Cr/TO-DO-APP-Mockup-FALL?node-id=435-3477&node-type=SECTION&t=G6De7qCsUE3haq35-0) and ensure that all relevant UI components are correctly tagged for testing and match the design specifications.

3. **Run tests**  
   Copy the following test file to the right place and run it to validate the functionality of your app:
  - [`OverviewScreenTest.kt`](../tests/OverviewScreenTest.kt) to `app/src/androidTest/java/com/github/se/bootcamp/ui/overview/OverviewScreenTest.kt`
