# Location-based To-Dos

> [!NOTE]
> Build this feature with your three agents, following [Three agents, one you](AgenticWorkflow.md). You orchestrate, review and own.

## Geocoding with Nominatim

When a user is creating a new to-do, entering GPS coordinates for the location may not be very user-friendly. This is where geocoding comes in handy. It allows the user to input text, which will then be converted into GPS coordinates. This is similar to how Google Maps works: you enter text, and it provides a precise location on the map. Since the geocoding feature in the Google Maps API is not free, we will be using Nominatim[^1]. To query the API, we will use OkHTTP.

### OkHTTP

OkHTTP[^2] is a powerful and efficient HTTP client for Android that simplifies the process of making network requests in your app. With a clean and easy-to-use API, OkHttp handles tasks like connection pooling, request/response compression, and even supports asynchronous requests. It's built on top of the robust Okio library, making it efficient for reading and writing data. OkHttp is widely used in Android development to perform network operations, fetching data from servers, and interacting with APIs. Its simplicity and reliability make it a popular choice for developers when dealing with network communication in Android applications.

> [!WARNING]
> Do not call the real Nominatim API from your tests, instead mock the HTTP client.
> Results from Nominatim change as OpenStreetMap data changes, the service may be unreachable, and its usage policy allows only one request per second. 
> Since the CI runners share IPs across SwEnt, tests that issue real queries will be flaky and risk getting that IP blocked for everyone.


## Model for the Nominatim API

The `Location` data class is already in `model/map/Location.kt` (and is covered by `SignatureChecks`). You still need to **create** the repository types below—they are not stubbed in the template, and they are **not** listed in `sigchecks/` (only `Location` and `HttpClientProvider` are). Match these signatures so your UI and tests can depend on them.

In the `model/map` directory, add the following files:

- a file `LocationRepository.kt`.

  ```kotlin
  interface LocationRepository {
    suspend fun search(query: String): List<Location>
  }
  ```

- a file `NominatimLocationRepository.kt` :

    ```kotlin
    class NominatimLocationRepository(val client: OkHttpClient) : LocationRepository {...}
    ```

To begin, try accessing the Nominatim Search API by constructing the appropriate API call in your browser, using query parameters. The documentation is available [here](https://nominatim.org/release-docs/develop/api/Search/).

To make your API request, use `HttpClientProvider.client` from `MainActivity.kt` (package `com.github.se.bootcamp`).

Make sure to include `format=json` in the URL to receive the response in JSON format.

> [!WARNING]
> Nominatim has several requirements they define in their Usage Policy, that you should read [here](https://operations.osmfoundation.org/policies/nominatim/). You must adapt your code accordingly.

Next, implement the `NominatimLocationRepository` class to automatically make the request and parse the resulting JSON response. To make asynchronous API calls, we’ll use the OkHTTP library. You can find the relevant documentation [here](https://square.github.io/okhttp/recipes/).

> [!TIP]
> It's a good practice to create a helper function to handle JSON decoding. There are various ways to decode JSON in Kotlin. We recommend using [org.json](https://developer.android.com/reference/kotlin/org/json/JSONArray).

Once everything is implemented, the query response should have multiple suggestions that we will now display in a dropdown menu !

## Update AddToDo and EditToDo Screen

After having implemented the logic, we can now finally input addresses in the Location placeholder. To improve consistency and reduce duplication across screens, consider defining a reusable composable component for selecting a location that can be used in multiple places, such as AddToDo and EditToDo. This aligns with best practices in Android Compose and promotes clean, maintainable code. While we won’t be testing whether you've created a component, it's essential to develop good habits in structuring your code. Be sure to include the necessary test tags for future testing.

For the dropdown menu, use a Compose `DropdownMenu`[^3] along with several `DropdownMenuItem`.

<p align="center">
    <img alt="click to view a to-do" src="assets/AddToDoScreenDropdown.png" width="40%" />
    <img alt="Edit a to-do" src="assets/EditToDoScreenDropdown.png" width="40%" />
</p>

---

## Requirement

Your implementation should ensure that:

- The user can input a location as text when creating or editing a to-do.
  The text is then converted into GPS coordinates using the Nominatim API.
- The user can select one of the suggestions from a dropdown menu.
  Show at most **5** suggestions (the public tests use the constant `MAX_LOCATION_SUGGESTIONS_DISPLAYED` in the androidTest helpers—there is no such constant in `app/src/main`).
- On the Edit screen, the location text field **starts empty** (`locationQuery` empty) even though the todo still has a selected `Location` in state. Use a fixed search placeholder such as `Enter an Address or Location` (same on Add). Typing must drive a fresh Nominatim query. Other fields stay pre-filled as in B2. The public tests type into the tagged location field and expect suggestions—they do not assert the placeholder string.
- Each screen (Add and Edit) shows its own top bar, tagged `TOP_BAR_TITLE` and `GO_BACK_BUTTON`. In B3 the top bar moves out of `BootcampApp` into each screen, because the tests render the screens on their own.
- All queries to the Nominatim API must comply with the Nominatim usage policy: send a real `User-Agent` header that identifies your app, and make at most one request per second.

## Test your implementation

Once you're done with your implementation, build and run the app to check that everything works as expected.

We provide you with the `LocationBasedTodosB3Test` test suite for this step.
It does not check the requirements in depth.
You should write your own tests to ensure that your implementation is correct.

> [!NOTE]
> Some tests use the Firebase emulator.
> Make sure to start it first by running `firebase emulators:start` in your terminal.

As in B1, you will need to attach test tags to your UI components to pass our tests. All required test tags are defined in the `AddToDoScreenTestTags` and `EditToDoScreenTestTags` objects. Check [Figma Testing mockup](https://www.figma.com/design/IDm3NGS988Myo01P0Wa0Cr/TO-DO-APP-Mockup-FALL?node-id=435-3541) to see where each tag should be placed.

Do not edit anything under `sigchecks/`. Keep the provided signatures so `SignatureChecks` still compiles.

---

> [!NOTE]  
> Please click [here](./4-GoogleMaps.md) to proceed to the next step.

[^1]: <https://nominatim.org/>
[^2]: <https://square.github.io/okhttp/>
[^3]: <https://composables.com/docs/androidx.compose.material3/material3/1.5.0-alpha01/components/DropdownMenu>
