# 4. Edit a To-Do

<p align="center"><img alt="click to view a to-do" src="../../assets/AssignmentDescription_TheTODOApp/EditInputOverviewScreen.png" width="40%" /> <img alt="Edit a to-do" src="../../assets/screen/EditToDoScreen.png" width="40%" /></p>

In `app/src/main/java/com/github/se/bootcamp/ui/overview/`, create the `EditToDo.kt` file, and implement the `EditToDoScreen` composable.

As illustrated above, this step involves implementing the functionality for editing and viewing a to-do. The overview screen displays your list of to-do items (in the provided example, there is only one to-do). Upon clicking on a to-do, you are directed to a second screen where you can both view and edit it.

On this detailed screen, similar to the creation screen, you can find additional elements, like a delete button and a button to modify the to-do's status. It mirrors the creation interface but includes these extra features.

After making changes to the to-do, including altering its status, it is expected that the user clicks on the save button to propagate the modifications to the data layer (in Firestore). Subsequently, the screen transitions back to the overview, reflecting the updated information.

For the status update, each click should change the status to the next one, i.e., `CREATED` -> `STARTED` ... `ARCHIVED` -> `CREATED` ...

> [!NOTE]  
> For the moment, hard-code a `val` `Location` for the editing of a to-do and a placeholder `OutlinedTextField`. In B3 you will implement the [`Nominatim API`](https://nominatim.org/).

---
## Validate your work

Follow these steps to validate your implementation:

1. **Run the signature checks**  
   Execute the [sigcheck](../sigcheck/EditToDosSignatureChecks.kt) for this user story.
   See the [sigcheck README](../sigcheck/README.md) for details.

2. **Verify UI elements**  
   Make sure your UI matches the provided design mockups. Check [the Figma design](https://www.figma.com/design/IDm3NGS988Myo01P0Wa0Cr/TO-DO-APP-Mockup-FALL?node-id=435-3368&node-type=SECTION&t=G6De7qCsUE3haq35-0) and ensure that all relevant UI components are correctly tagged for testing and match the design specifications.

3. **Run tests**  
   Copy the following test file to the right place and run it to validate the functionality of your app:
   - [`EditToDoScreenTest.kt`](../tests/EditToDoScreenTest.kt) to `app/src/androidTest/java/com/github/se/bootcamp/ui/overview/EditToDoScreenTest.kt`
