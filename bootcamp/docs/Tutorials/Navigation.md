# Navigation in Jetpack Compose

> [!WARNING]
> This is mandatory for the bootcamp.  
> All the provided code must be implemented for the bootcamp.

## Introduction

Navigation in Compose is based on a **single-activity model**, enabling dynamic UI management through a `NavController` object. This document will guide you through setting up a navigation system.

## Navigation Setup

To manage navigation in a Jetpack Compose app, you need to define navigation actions and destinations. Here is an overview of the classes and objects you will need to create:

First create a folder in `bootcamp/ui` called `navigation`, then create the following files inside of it  :

- `BottomNavigationMenu.kt` a composable file that define navigation bar UI at the bottom of the screen.
- `NavigationActions.kt` a file containing all the logic of our navigation. **Every object and class we define below must be in this file**.

### 1. `Route` & `Screen`

The `Route` object defines top-level sections of the app, where each route serves as an identifier for a group of related screens.

```kotlin
object Route {
    const val OVERVIEW = "Overview"
    const val MAP = "Map"
    const val AUTH = "Auth"
}
```

The `Screen` object defines individual views or screens within a route. Each screen represents a specific part of the user interface associated with that route.

```kotlin
object Screen {
    const val OVERVIEW = "Overview Screen" 
    const val ADD_TODO = "Add ToDo Screen"
    ...
}
```

### 2. `TopLevelDestination`

This **data class** represents the top-level destinations of the app and includes the following properties:

- `route`: A unique route (String) identifier for the destination.
- `icon`: The icon representing the destination in the UI.
- `textId`: The text (String) ID for the destination

Those will be the icons at the bottom of your app!
![alt text](../assets/Tutorials/topLevelDestination.png)

### 3. `TopLevelDestinations`

This object contains all the top-level destinations for the app, utilizing our data class. It is utilized to create the bottom navigation bar and manage navigation state.

```kotlin
object TopLevelDestinations {
  val OVERVIEW = TopLevelDestination(route = Route.OVERVIEW, icon = Icons.Outlined.Menu, textId = "Overview")
  ...
}
val LIST_TOP_LEVEL_DESTINATION = listOf(TopLevelDestinations.OVERVIEW, TopLevelDestinations.MAP)

```

### 4. `NavigationActions`

This class contains the navigation actions for the app, such as `navigateTo`. It utilizes a [`NavHostController`](https://developer.android.com/reference/androidx/navigation/NavHostController) to manage screen transitions.

```kotlin
open class NavigationActions(
    private val navController: NavHostController,
) {
    /**
    * Navigate to the specified [TopLevelDestination]
    *
    * @param destination The top level destination to navigate to.
    * 
    * Clear the back stack when navigating to a new destination.
    */
    open fun navigateTo(destination: TopLevelDestination) {}

    /**
    * Navigate to the specified screen.
    *
    * @param screen The screen to navigate to
    */
    open fun navigateTo(screen: String) {}

    /** Navigate back to the previous screen. */
    open fun goBack() {}

    /**
    * Get the current route of the navigation controller.
    *
    * @return The current route
    */
    open fun currentRoute(): String {}
}
```

> [!TIP]  
> Look into the method the navController offer!  
> More information on how to create navigation actions can be found in the [official Jetpack Compose navigation documentation](https://developer.android.com/jetpack/compose/navigation).

> [!NOTE]
> For testing purposes, the class and all its methods are marked with `open`, which allows us to inherit the class and override its methods.

## Bottom Navigation Bar UI

The bottom navigation bar is essential for navigating between different tabs of the app. To create a bottom navigation bar in Jetpack Compose, you can use the `BottomNavigation` composable from [material](https://composables.com/material/bottomnavigation).

### Example Implementation

In `BottomNavigationMenu.kt` define what the bottom menu should look like.
Have a look at the [documentation](https://developer.android.com/develop/ui/compose/navigation#bottom-nav)  

```kotlin
@Composable
fun BottomNavigationMenu(
    onTabSelect: (TopLevelDestination) -> Unit,
    tabList: List<TopLevelDestination>,
    selectedItem: String
) {
    ...
}
```

> [!WARNING]
> For testing purposes, each `NavigationBarItem` must include the modifier `modifier = Modifier.testTag(tab.textId)`.

### Integrating Navigation in the App

The [`NavHost`](https://developer.android.com/develop/ui/compose/navigation#getting-started) is a composable responsible for selecting which screen should be displayed, based on the `NavHostController`. Inside, [`navigation`](https://developer.android.com/reference/kotlin/androidx/navigation/NavGraphBuilder#(androidx.navigation.NavGraphBuilder).navigation(kotlin.Any,kotlin.collections.Map,kotlin.Function1)) defines a _destination_ (aka routes), each of them contains one or more _composables_ (aka screens), defined with [`composable`](https://developer.android.com/reference/kotlin/androidx/navigation/NavGraphBuilder#(androidx.navigation.NavGraphBuilder).composable(kotlin.String,kotlin.collections.List,kotlin.collections.List,kotlin.Function1)).

Now, every screens that require to perform some navigation action must have as a parameters `navigationActions: NavigationActions` .

To use the bottom navigation bar within your app, integrate it with the [`Scaffold`](https://developer.android.com/develop/ui/compose/components/scaffold) inside the bottomBar section.  

In the inside your mainActivity, create a composable `BootcampApp` and with a [`NavHost`](https://developer.android.com/develop/ui/compose/navigation#getting-started) we will define our navigation inside it:

```kotlin
@Composable
fun BootcampApp() {
    val navController = rememberNavController()
    val navigationActions = NavigationActions(navController)

    NavHost(navController = navController, startDestination = Route.AUTH) {
        navigation( 
            startDestination = Screen.AUTH,
            route = Route.AUTH,
        ) {
            composable(Screen.AUTH) { SignInScreen(navigationActions) }
        }
        navigation(
            ...
        ){
            ...
        }
        ...
    }        
}
```

> [!NOTE]
> In the navigation graph, the `navigation()` function groups related screens under a specific route, typically when there's a hierarchy (e.g., an authentication flow).

> If your bottom bar is stuck under the android UI, remove [`enableEdgeToEdge()`](https://developer.android.com/develop/ui/views/layout/edge-to-edge)

## Cool features

- **Sub-routes**: Allow navigation within specific Route
- **Back Navigation**: Go back to the previous route visited !
- **[Navigate with arguments](https://developer.android.com/develop/ui/compose/navigation#nav-with-args)** : Pass directly relevant information inside the route as parameter

Keep these features in mind, as they could prove useful for your app!

## Further Reading

- [Jetpack Compose Navigation Documentation](https://developer.android.com/jetpack/compose/navigation)
- [Reply Sample App - Navigation Example](https://github.com/android/compose-samples/tree/main/Reply)
- [Modern Android Development (MAD)](https://developer.android.com/modern-android-development)

---

### Conclusion

By using the above approach, all navigation-related information has been extracted from the main document into a separate one. This new document provides a focused guide on implementing and managing navigation within a Jetpack Compose app, ensuring clarity and ease of understanding for developers looking specifically for navigation guidance.

> [Return to the Table of Contents](../../README.md#structure)
