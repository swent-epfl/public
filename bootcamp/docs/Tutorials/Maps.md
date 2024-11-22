# 2 - Google Maps - Introduction

Google Maps is an API that you are likely to use in your application. It can be used in many ways: to indicate the position of certain elements on the map, indicate areas of interest or to guide you to a certain point using GPS.

## API Key

Before being able to use Google Maps in your application, you will need to create an API key for Google Maps. You will find [here](https://developers.google.com/maps/documentation/android-sdk/get-api-key) a tutorial on how to set up the API key.

Unfortunately, Google asks for billing information to generate this API key but there is a workaround:

First, go to your project's webpage and get its ID for later (go to this page and select the correct project, or create one):
<https://console.cloud.google.com/welcome>

Then, go to this page (by replacing "YOUR-PROJECT-ID" with the correct id) and click "ENABLE".
This will load a page asking you to turn on billing, don't answer it, to skip it :

<https://console.cloud.google.com/marketplace/product/google/maps-android-backend.googleapis.com?project=YOUR-PROJECT-ID>

Go to this page (still replacing "YOUR-PROJECT-ID" with the correct id) and click **"CREATE CREDENTIALS"**, then select **"API key"**. This will generate an API key that you can now use without needing to give Google your billing information:

<https://console.cloud.google.com/apis/credentials?project=YOUR-PROJECT-ID>

The newly generated API key should appear on this same page with an orange triangle as it is unrestricted.

<p align="center"><img alt="welcome screen firebase" src="../assets/Tutorials/bootcamp-api-keys.png" width="80%" /></p>

> [!NOTE]
> You can verify that  Maps SDK for Android is enabled by using the second link again or by restricting your api key and see all the service available with it directly (click on the key>API restrictions).

## Setting the key in your project

To avoid publishing your key, we will use local file : `local.properties` to store it.

In `local.properties` paste your key

```properties
MAPS_API_KEY=xyz

// Do NOT use quotation marks. "xyz"
```

<details>
<summary>Why do this ? Here is an explanation</summary>  
  
To avoid publishing your key, on your github, we used some gradle script to inject it when running the app.

In your `AndroidManifest.xml` in the `<application>` tag, we normally define the key but instead we used a variable.

```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="${MAPS_API_KEY}" />
```

Then in `app/build.gradle.kts` in the section `android` we added the following :

```kts
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly
import java.io.FileInputStream
import java.util.Properties

android {
    // Load the API key from local.properties
    val localProperties = Properties()
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localProperties.load(FileInputStream(localPropertiesFile))
    }

    val mapsApiKey: String = localProperties.getProperty("MAPS_API_KEY") ?: ""

    defaultConfig {
        ...
        manifestPlaceholders["MAPS_API_KEY"] = mapsApiKey
  }
}  
```

</details>

## Tutorials

You can simply test the map with the following example. It should display San Francisco.

```kotlin
@Composable
fun SimpleMap() {
    // Create a CameraPositionState to control the camera position
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(37.7749, -122.4194), 10f) // San Francisco
    }

    // Display the Google Map
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    )
}
```

You will find examples and tutorials on how to set up google map:

- [Setup of a map with markers](https://developers.google.com/maps/documentation/android-sdk/map-with-marker)
- [Working with lines and shapes](https://developers.google.com/maps/documentation/android-sdk/polygon-tutorial)
- [Set current place](https://developers.google.com/maps/documentation/android-sdk/current-place-tutorial)

> [!WARNING]
> If your map does not display anything except the Google layout, this is likely because your key is set up incorrectly. You may have missed a [step](#api-key).
>
## Cool features

Google Maps has many more advanced features that might interest you. Here are some examples of such features.

The markers are fully customizable, you can modify the icon of the marker and all its properties (e.g. the opacity).

It is possible to add layers above the map. For instance, [here](https://developers.google.com/maps/documentation/android-sdk/utility/heatmap) is how to create a heatmap of the density of points that have been added on top of the map.

[Geocoder](https://developer.android.com/reference/android/location/Geocoder) lets you convert longitude and latitude coordinates to an address

You will find everything you need to know in the [Google Maps documentation](https://developers.google.com/maps/documentation/android-sdk/overview) and in the [API reference](https://developers.google.com/android/reference/com/google/android/gms/maps/package-summary).

## Testing

To test your code for Google Maps, you will have to write unit tests, but they will cause you some trouble because all classes in Google Maps are final so you cannot create a mock of them.
You will have to write UI tests, but since you cannot set the inputs, it will be difficult to achieve 100% coverage.

Therefore, we advise you to write code that is independent from map components and that you can easily test as much as possible.

## Warning

You may want to draw lines and shapes on the map, compute line intersections or project the current position of the user on a certain road. Don't forget that the longitude latitude coordinates are **NOT** cartesian, it is spherical. So if you want to compute line intersections, projections, etc. you will have results that may surprise you. When working on small areas, you can change coordinate space before and after computations, but due to its nature, the result will always be an approximation.

Congrats, you're done!

> [Return to the Set Up](../ToDoApp/Setup.md#google-map-tutorial) \
> [Return to the Table of Contents](../../README.md#table-of-contents)
