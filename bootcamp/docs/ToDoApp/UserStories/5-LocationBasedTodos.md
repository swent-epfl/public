# 5. Location-based To-Dos

## Reverse Geo-Coding - Nominatim

When a user is creating a new to-do, entering GPS coordinates for the location may not be very user-friendly. This is where Reverse Geocoding comes in handy. It allows the user to input text, which will then be converted into GPS coordinates. This is similar to how Google Maps works—where you enter text and it provides a precise location on the map. Since the reverse geocoding feature in the Google Maps API is not free, so we will be using [Nominatim](https://nominatim.org/). To query the API, we will use OkHTTP.

### OkHTTP

[OkHTTP](https://square.github.io/okhttp/) is a powerful and efficient HTTP client for Android that simplifies the process of making network requests in your app. With a clean and easy-to-use API, OkHttp handles tasks like connection pooling, request/response compression, and even supports asynchronous requests. It's built on top of the robust Okio library, making it efficient for reading and writing data. OkHttp is widely used in Android development to perform network operations, fetching data from servers, and interacting with APIs. Its simplicity and reliability make it a popular choice for developers when dealing with network communication in Android applications.

> [!WARNING]
> To test a Web Request API, we advise you to mock it in order to have idempotent tests (tests that can be run multiple times without changing the system's state after the first run).

## Map Screen

<p align="center"><img alt="homeMapMockup.png" src="../../../docs/assets/screen/MapScreen.png" width="30%" /></p>

The Map screen will display a map with the location of the toDos. You can find more information in the [documentation](https://developers.google.com/codelabs/maps-platform/maps-platform-101-compose#0) or the [Google Map Compose Sample](https://github.com/googlemaps/android-maps-compose).

## Model for the API Nominatim

To guide you, we have provided the class signatures, but you will need to implement the full functionality of these files. If you have any doubts about whether the interface is compatible with ours, remember to consult the sigcheck file. We recommend checking the sigcheck before fully implementing everything to ensure you're using the correct interface.

In the `model/map` directory, add the following files :

- a file `LocationRepository.kt`.

    ```kotlin
    interface LocationRepository {
    fun search(query: String, onSuccess: (List<Location>) -> Unit, onFailure: (Exception) -> Unit)
    }
    ```

- a file `LocationViewModel.kt`.

    ```kotlin
    class LocationViewModel(val repository: LocationRepository) {...}
    ```

- a file `NominatimLocationRepository.kt` :

    ```kotlin
    class NominatimLocationRepository(val client: OkHttpClient) : LocationRepository {...}
    ```

> [!TIP]
> To begin, try accessing the [Nominatim Search API](https://nominatim.org/release-docs/develop/api/Search/) by constructing the appropriate API call in your browser, using query parameters.  
> Make sure to include `format=json` in the URL to receive the response in JSON format.
>
> Next, implement the `NominatimLocationRepository` class to automatically make the request and parse the resulting JSON response. For making asynchronous API calls, we’ll use the OkHTTP library. You can find the relevant documentation [here](https://square.github.io/okhttp/recipes/).
>
> It's a good practice to create a helper function to handle JSON decoding. There are various ways to decode JSON in Kotlin. We recommend using the [org.json](https://developer.android.com/reference/kotlin/org/json/JSONArray).

The result should have multiple suggestions that we will display in a dropdown menu !

## Update AddToDo and EditToDo Screen

After having implemented logic, we can now finally input address in your Location placeholder. To improve consistency and reduce duplication across screens, consider defining a reusable composable component for selecting a location that can be used in multiple places, such as AddToDo and EditToDo. This aligns with best practices in Android Compose and promotes clean, maintainable code. While we won’t be testing whether you've created a component, it's essential to develop good habits in structuring your code. Be sure to include the necessary test tags for future testing.

For the dropdown menu, use a [`DropDownMenu`](https://composables.com/material3/dropdownmenu) with some `DropdownMenuItem`

You will need to modify the signature of AddToDo and EditToDo composables. To make the sigcheck compatible, we can set a default parameter for `LocationViewModel` in the compsable signatures. By default, we instantiate the `LocationViewModel` using the `viewModel()` function, which also allows us to pass a custom factory. `locationViewModel: LocationViewModel = viewModel(factory = LocationViewModel.Factory)`.  
To define a factory, see the [official documentation](https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-factories)

> [!NOTE]  
> Initiating a ViewModel as a regular Kotlin class will break the [lifecycle management provided by Jetpack's ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel). The ViewModel should be instantiated using `viewModel()` inside a Composable or by `viewModels{}` in activities or fragments. Doing so ensures that the ViewModel is properly tied to the Android lifecycle, allowing it to survive configuration changes (like screen rotations) and be automatically cleaned up when no longer needed. 


<p align="center"><img alt="click to view a to-do" src="../../../docs/assets/screen/AddToDoScreenDropdown.png" width="40%" /> <img alt="Edit a to-do" src="../../../docs/assets/screen/EditToDoScreenDropdown.png" width="40%" /></p>

---

## Validate your work

Follow these steps to validate your implementation:

1. **Run the signature checks**  
    Execute the [Signature check](../sigcheck/MapSignatureChecks.kt) for this user story. See the [doc](../sigcheck/README.md) for details.

2. **Verify UI elements**  
    Make sure your UI matches the provided design mockups. Check
    [the Figma design](https://www.figma.com/design/IDm3NGS988Myo01P0Wa0Cr/TO-DO-APP-Mockup-FALL?node-id=435-3350&node-type=CANVAS&t=G6De7qCsUE3haq35-0)  and ensure that all relevant UI components are correctly tagged for testing and match the design specifications.

---

> [!NOTE]  
> Please click [here](UserStory.md#5-location-based-todos) to come back to the corresponding user-story.
> Remember to check the SigCheck description [here](../README.md) while writing tests.
