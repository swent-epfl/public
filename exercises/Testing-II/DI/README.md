# Dependency Injection with Hilt

__Dependency Injection (DI)__ is a design pattern that allows for the creation of loosely coupled components, enhancing the modularity and testability of your applications. 

## Why Dependency Injection?
For example, instead of defining a _model_ element (data, logic) in a _view-model_ (binding the UI and the data/logic), you can inject it into the view-model from the outside.

When you are **testing the view-model,** you can replace the real model with a fake one, which makes the testing easier and more reliable. Eg: instead of using a real network call to get the, you can use a fake network instance that returns a predefined response.

## DI in Android: Hilt
In the context of Android development, __Hilt__ is a dependency injection library that simplifies DI implementation by leveraging Dagger's annotation processing (compile-time dependency injection framework) capabilities to automatically generate the underlying boilerplate code. 

This exercise aims to introduce you to Dependency Injection using Hilt and provide a simple setup for you to practice.

## Exercise: Adding Hilt to the Rick & Morty Application
The application in this exercise is the Rick and Morty application we have seen before. Please refer to the **Mobile Exercises** first to understand the application!

Notice the new `di` package. This is where you will define the modules and components for Hilt. Notably: 
- We've already added the Hilt dependencies to the project.

- We've added an `@HiltAndroidApp` annotation to a `MainApplication` class, which is the entry point for the application. This annotation is required to enable Hilt in your app!

The task for you is to fill in the blanks in the codebase to correctly inject depdencies using __Hilt__, marked with `TODOs` in the code.

### Step 1: Change the CharacterViewModel to use Hilt

The `CharacterViewModel` is the class that is using the repository to get the data from the network and the database.

- `viewmodel/CharacterViewModel.kt`: 
    - The repository will be injected into the viewmodel by Hilt instead of creating it from inside of the view model, using the  `@HiltViewModel` annotation and the `@Inject` annotation in the constructor. 
    - You don't need the context anymore, so you can remove it from the constructor, and use `ViewModel()` instead of `AndroidViewModel()`.

**Hint:** here is below the syntax for a viewmodel using Hilt

```kotlin
@HiltViewModel
class MyViewModel @Inject constructor(
    private val myRepository: MyRepository
) : ViewModel() {
    // ...
}
```

### Step 2: Change the Repository to use Hilt

The `CharacterRepository` is the class that is using the network and the database to get the data. We want to inject the network and the database into the repository using Hilt instead of creating them from inside of the repository:

- Inside of `repository/CharacterRepository.kt`: 
    - Similarly to the viewmodel, you need to use the `@Inject` annotation in the constructor to inject the network and the database into the repository (but obviously not the viewmodel annotation!)
    - For the context variable, you can use the `@ApplicationContext` annotation to inject the application context into the repository.
    - A new variable is created as `@Inject lateinit var dao: CharacterDao` to inject the dao into the repository. Do the same for the `RickAndMortyApiService` variable.

### Step 3: Define the modules and components for Hilt

Dependencies should now be injected using Hilt! ... but we need to define the modules and components for Hilt to know how to inject them.

The components we've removed form `CharacterRepository` and `CharacterViewModel` should still be defined somewhere else! That is where our `di` package comes in. That is where we define our modules.

We use the following syntax to define a module:
```kotlin
@Module
@InstallIn(SingletonComponent::class)
object MyModule {
    // ...

    @Provides
    @Singleton
    fun provideMyDatabase(@ApplicationContext context: Context): MyDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            MyDatabase::class.java, "my_database_name"
        ).build()
    }

    // ...
}
```

**Hint:** Hilt automatically calls these `@Provides` annotated functions when an instance of the type they return is required. Also `@Singleton` is a scope that tells Hilt to create only one instance of the provided dependency.

As a rule of thumb, you should define a module for each dependency you want to inject. In this case, you should define a module for the database and a module for the network service.

Here are the modules you need to fill in:

- `di/DatabaseModule.kt`
    - This module should provide the `AppDatabase` and the `CharacterDao` as dependencies for the repository.
    - The `@Singleton` annotation is used to tell Hilt to create only one instance of the provided dependency: for example we only need one instance of the database. 

- `di/NetworkModule.kt`
    - This module should provide the `RickAndMortyApiService` as a dependency for the repository. It provdes the `Retrofit` instance and the `RickAndMortyApiService` instance.
    - Separating the definition of `Retrofit` and `RickAndMortyApiService` decouples the Retrofit setup from its usage. This means changes to the Retrofit configuration do not directly affect how services are created or used, making your code more resilient to changes and easier to maintain. This is good for testing too when you start to mock the network service.


[The official tutorial](https://developer.android.com/training/dependency-injection/hilt-android#kts) is good starting point to understand how to use Hilt, you need to read through the tutorial first in order to finish this exercise. 

We won't cover more advanced features, but you can follow this [coding exercise](https://developer.android.com/codelabs/android-hilt#0) to learn more about Hilt.
