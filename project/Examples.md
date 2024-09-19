# Example project proposals from the last semester

This document shows some project proposals from the last semester.
You can refer to their designs and functionalities and then propose your proposal.

## ActuallA (\#1 in last BOTA)

### Pitch

Get your own 1 minute daily summary of news that you choose, tailored to your needs. Wake up with the latest in tech, politics, society, or any subject you’d like. You can listen to your customized news feed, read a transcript, and look into the original sources of the headlines that caught your eye.

### Implementation

  1) Fetch, aggregate and filter news from the provided sources;
  2) Using a language model API, generate a summary of these news;
  3) Use AI assisted text-to-speech to produce a podcast readout of the summary;

### Requirements

  - Split app model. News are fetched from news APIs chosen by the user, like Google News, RSS Feeds or others.
  - User Support. Users can add their own news feeds to the aggregator.
  - Sensor use. User location can be used to filter according to local news on request.
  - Offline mode. The daily transcript is stored on the app, so it is always available to read or listen through again.
  - Production Build. Every element can be embedded within the application’s apk file.

## FeedMe (\#2 in last BOTA)

### Overview of the application
Whenever we want to cook something, we eventually always fall back to our usual, familiar recipes. Should it be because of a tight budget, lack of inspiration or laziness, it is always easier to cook something familiar. The problem with that is that it creates a monotone eating habit, poor gut health and nutrient imbalances.
In order to find a new sense of excitement around cooking, and make it easier to maintain a healthy diet, we wanted to target this specific aspect. Lack of inspiration? Have an app suggest recipes! Laziness? Make that app suggest recipes based on ingredients you already have at home! Tight budget? The app can suggest cheap yummy recipes!

### Main functionalities of the application

#### Module 1 : Ingredient gathering

The goal is to identify the ingredients for the future recipe. Possible ways to detect them :

- By scanning barcode using an API (OpenFoodFacts for example).
- By doing machine learning and object recognition through the phone’s camera.
- By manually entering ingredients through a catalog (for vegetables, fruits, etc).

The sensor used is the phone’s camera.

For the offline functionality we would cache already scanned ingredients or directly input it and recipes already used. The user will then be able to use the app functionality without internet connection for the item already cached.

#### Module 2 : Recipe finding

The goal is to find a recipe adapted to the ingredients. We can create a database by parsing information coming from various cooking websites.
We will offer different possibilities regarding recipe creation :

- create a recipe only with the ingredients you have (if possible).
- suggest a recipe and additional ingredients needed for the recipe.
    
#### Optional features :

- Maps of nearby shops, using phone GPS, etc...
- Budget filter.
- Cooking difficulty filter.
- Langages.
- Rating of recipes between users.

## PetPamper (\#5 in last BOTA)

### MVP Description for Pet Pamper:
To provide a platform that connects pet owners with nearby pet groomers who offer services either at the pet owner's home or through mobile grooming units, especially targeting groomers who do not have the resources to maintain a physical location.

Core Features:
  1. Groomer Discovery
  2. Booking and Availability
  3. Messaging System + Voice Notes (microphone)
  4. Ratings and Reviews with photos (camera)
  5. Marketplace for Pet Products
  6. Dual Interface
  7. Service Location Option (gps)
  8. Promotional Offers System with notifications
  9. Track Progress of Pet Grooming (notifications)

### Here's how the app satisfies the specified requirements:
Split App Model: Pet Pamper can utilize Google Firebase to manage real-time data syncing, authentication, and hosting, providing a scalable and secure backend solution for both the pet owner and groomer interfaces.

User Support: The app can integrate Android's built-in Google authentication for a seamless and secure login experience, ensuring that users have a personalized and protected platform.

Sensor Use: The app leverages the phone's microphone for voice notes within the messaging system, camera for uploading photos in ratings and reviews, and GPS for the service location option.

Offline Mode: Pet Pamper can offer a pared-down version of the app in offline mode, allowing users to view previously loaded groomer profiles, appointments, and messages, ensuring usability even without internet connection.
