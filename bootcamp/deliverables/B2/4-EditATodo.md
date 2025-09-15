# Edit a Todo

In this step, you will implement a feature that lets users edit their existing todos.

The user story for this feature is:

> As a user, I want to view, modify, and delete an existing Todo, so that I can keep my task list accurate and up to date.

As with the AddTodo feature, this can be implemented using a dedicated ViewModel to manage state and interact with the repository.

## Implementing the Edit ToDo Screen

The Overview screen displays the list of todos.
When the user clicks on a todo, should be directed to a second screen where they can both view and edit it.

This new screen (Edit ToDo) is similar to the screen used to create a todo, with two additional elements: a **delete button** and a **status button** that cycles through the todo's state.  
It mirrors the AddToDo interface but have these extra features.

<p align="center">
   <img alt="click to view a to-do" src="assets/EditInputOverviewScreen.png" width="30%" />
   <img alt="Edit a to-do" src="assets/EditToDoScreen.png" width="30%" />
   <img alt="Edit a to-do input validation" src="assets/EditToDoScreenValidation.png" width="30%" />

</p>

### Error handling

Similar to what you did in AddToDo, use `OutlinedTextField` components to handle user input validation and to display error messages. See [official documentation](https://developer.android.com/develop/ui/compose/quick-guides/content/validate-input#validate_input_as_the_user_types_2) for more details.

---

## Requirements

- **UI layout**  
  - All input fields follow the same validation rules as in `AddToDoScreen` (title mandatory, date format, error messages, etc.).  
  - Fields are **pre-filled** with the current values of the selected todo.  
  - Provide a **Save button** to confirm changes.  
  - Provide a **Delete button** to remove the todo.  
  - Provide a **Status button** that cycles through enum values in order (CREATED → STARTED → … → ARCHIVED → CREATED).  
  - Provide a **Back button** to return to the Overview screen.  
  - All UI elements must be visible on a 1080x2400 screen (Medium phone on Android Studio), as this screen size is used in the automated tests.

- **Navigation**  
  - Save button does nothing if inputs are invalid.  
  - If valid → return to the **Overview screen** in a fresh state.  
  - On delete → return to the **Overview screen** in a fresh state.  

- **Refresh**  
  - On save or delete, fetch todos before navigating, so the Overview screen can immediately reflect the changes.  

> [!NOTE]  
> For the moment:  
>
> - Hard-code a `val Location` for editing a todo and use a placeholder `OutlinedTextField`.  
> - Hard-code an `ownerId` value (e.g., empty string) but do not create a text field for it.  
>
> These will be implemented properly in **B3**.

---

## Test your implementation

Once you're done with your implementation, build and run the app to check that everything works as expected. Don't forget to update the `BootcampApp` composable in `MainActivity.kt` with your code.

To perform basic checks to see if your implementation meets the requirements, run the `EditToDoScreenTest` and `NavigationB2Test` suite. Since the tests may use the Firebase emulator, start it first with:

```bash
firebase emulators:start
```

As usual, you'll need to attach test tags to your UI components to pass our tests. All the required tags are in the `AddToDoScreenTestTags`, `EditToDoScreenTestTags`, and `OverviewScreenTestTags` objects. Check the [Figma testing mockup](https://www.figma.com/design/IDm3NGS988Myo01P0Wa0Cr/TO-DO-APP-Mockup-FALL?node-id=435-3350) to see where to put each tag.


Finally, make sure your app builds the signature check files.

---

Congratulations! You have completed the second deliverable of the bootcamp. Don’t forget to check that your Continuous Integration (CI) pipeline is passing before moving on.
