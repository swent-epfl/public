# User Stories for the ToDo App

## Definition of Done (DoD)

For all of the user stories below, we assume that the following criteria are met for the story to be considered "done":

- The acceptance criteria are tested

## 1. Sign-in and Login

**User Story:** As a user, I want to sign-up and log into the app, so that my ToDos are kept across devices.

**Acceptance Criteria:**

- The login screen offers the ability to authenticate with Google.
- The authentication is based on the Firebase Authentication solution.
- Post-login, the user is informed of a successful login.

**Bootcamp Resources:**

- [Assignment description to create a login](1-SignInAndLogin.md)
- [Google Authenticator tutorial](../../Tutorials/GoogleAuthentication.md)

## 2. Create/Add a ToDo

**User Story:** As a user, I want to create a new ToDo, so that I can add new tasks to my list.

**Acceptance Criteria:**

- The user can go back to the previous screen.
- When creating ToDo, the user can enter the title, detailed description, assignee, location and due date.
- Upon submission, the ToDo is saved to the Firestore database.
- The fields are validated to ensure the title is not empty before submission, and the due date is valid.
- The (Firestore) database has been created with an appropriate schema and stores the ToDos.

**Bootcamp Resources:**

- [Assignment description to create a ToDo](2-AddATodo.md)

## 3. List of ToDos

**User Story:** As a user, I want to view a list of my ToDos, so that I can easily see all my pending tasks at once.

**Acceptance Criteria:**

- The user can navigate using a navigation menu to other views.
- The list of todo must be scrollable to accommodate a potentially large number of ToDos.
- If the list of ToDos is empty, a text must prompt the user to create a ToDo.
- Each item in the list displays the ToDo title.
- ToDos are fetched upon a successful sign-in/log-in.
- The list of ToDos is automatically updated to include newly created/edited ToDos.

**Bootcamp Resources:**

- [Assignment description to create a list of ToDos](3-ListOfTodos.md)

## 4. Edit a ToDo

**User Story:** As a user, I want to edit and view details of my ToDos, so that I can update tasks or review their detailed descriptions.

**Acceptance Criteria:**

- Clicking on a ToDo item in the list of ToDo navigates the user to a editable view of that ToDo.
- The editable view displays the ToDo title, detailed description, assignee, location and due date.
- From this view, the user can modify all of the above and the ToDo state, or delete the task.
- Changes are saved to the Firestore database.
- The app navigates **back** to the ToDo list after the edit is saved or deleted, reflecting the changes immediately.
- The user can be go back to the previous screen.

**Bootcamp Resources:**

- [Assignment description to edit/view a ToDo](4-EditATodo.md)

## 5. Location-based ToDos

**Story:** As a user, I want to geo-locate my ToDos and see them on a map, so that I can plan my work based on the ToDos location.

**Acceptance Criteria:**

- The user can set a location for a ToDo when creating/editing it.
- The Nominatim API is used to reverse geocode named locations to coordinates.
- A separate map view is available where ToDos with locations are displayed as pins on the map.
- Tapping a pin displays the title and description of the ToDo.
- The map view integrates with the Google Maps API to render maps and manage locations.

**Bootcamp Resources:**

- [Assignment description to implement location in our ToDos](5-LocationBasedTodos.md)
