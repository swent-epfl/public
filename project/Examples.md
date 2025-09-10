# Example Project Ideas

Below you will find several project ideas that can serve as inspiration for your own proposal, if you wish.

<hr>

- [PlateSwipe](#plateswipe-1-in-fall-24-bota)
- [EndurAI](#endurai-2-in-fall-24-bota)
- [BeatLink](#beatlink-3-in-fall-24-bota)
- [ActualIA](#actualia-1-in-spring-24-bota)
- [PetPamper](#petpamper-5-in-spring-24-bota)
- [StepUp](#stepup)
- [La-Le-La](#la-le-la)
- [Roomie](#roomie)
  
<hr>

## PlateSwipe (#1 in Fall '24 BOTA)

### Pitch
Many busy professionals, health-conscious individuals, and people short on time struggle to cook healthy meals and often end up with ultra-processed food. **PlateSwipe** is an app that makes home cooking enjoyable and convenient through a personalized, swipe-based recipe discovery experience. It tailors suggestions to user preferences like budget, dietary needs, and cultural tastes. With the *Virtual Fridge* feature, users can track what ingredients they already have, plan meals more easily, and reduce food waste. The result is healthier meals with less hassle.

### Features
1. Swipe-based recipe discovery tailored to user preferences
2. Virtual Fridge to manage ingredients and make meal planning easier
3. Barcode scanning to quickly add ingredients
4. Offline access to saved recipes and fridge contents
5. Personalized suggestions for different user types (professionals, parents, enthusiasts)

### Requirements
- **Split App Model:** Recipes and fridge stored locally; profiles, preferences, and updates stored in Firebase
- **User Support:** Profiles, fridge management, and personalized recipe recommendations
- **Sensor Use:** Camera for ingredient recognition and barcode scanning; GPS for suggesting local food options and nearby markets
- **Offline Mode:** Saved recipes and fridge data available without Internet, synced when back online

## EndurAI (#2 in Fall '24 BOTA)

### Pitch
Many people want to achieve their fitness goals but struggle with building safe habits, maintaining motivation, and tracking progress effectively. **EndurAI** supports users in developing good exercise practices, monitoring performance, and preventing injuries. It provides real-time feedback on form and technique, personalized goals for motivation, and progress tracking in an interactive way. EndurAI is designed for both beginners who want guidance and athletes who seek advanced performance insights.

### Features
1. Real-time workout analysis using the camera for form recognition and feedback
2. Instant feedback to correct form (e.g., shoulder position when doing a plank)
3. Automatic repetition counting for exercises like push-ups and squats
4. Customized running plans that adapt pace and distance using GPS
5. Workout history and achievement calendar to visualize consistency of workouts
6. Graphs and charts to highlight improvements in strength and endurance

### Requirements
- **Split App Model:** Local processing for exercise recognition and workout tracking; profiles, preferences, and history stored in Firebase
- **User Support:** Accounts with profiles, preferences, workout history, and running tracks
- **Sensor Use:** Camera for live exercise analysis and repetition counting; GPS for personalized running plans
- **Offline Mode:** Local support for workout tracking, form analysis, running companion, and viewing progress when Internet is unavailable

## BeatLink (#3 in Fall '24 BOTA)

### Pitch
Many music lovers want to connect with others through the songs they listen to, but existing apps often make music a private experience. **BeatLink** makes music social by bridging the gap between listeners and their surroundings. It helps people discover what's playing nearby and build collaborative playlists, turning music into a shared experience.

### Features
1. **Music on the map:** See what songs people around you are listening to and connect through shared taste
2. **Collaborative playlists:** Create playlists with friends, let them vote for their favorite tracks, and export the top-voted songs to Spotify for your next party

### Requirements
- **Split App Model:** Local song discovery; map data, voting, and playlist are stored in Firebase 
- **User Support:** Profiles, collaborative playlist creation, and voting features
- **Sensor Use:** GPS for showing songs playing nearby
- **Offline Mode:** Locally cache recent playlists and votes for offline use


## ActualIA (#1 in Spring '24 BOTA)


### Pitch
Many people struggle to keep up with the constant flow of news while balancing busy schedules. [**ActualIA**](https://actualia.app/) delivers a personalized 1-minute daily summary of the news, tailored to each user's interests. It provides a quick, reliable way to catch up on technology, politics, society, or any topic of choice. Users can listen to a podcast-style readout, read a transcript, and check original sources for stories that matter most to them.

### Features
1. Fetch, aggregate, and filter news from the provided sources
2. Generate a summary of the news using a language-model API
3. Produce a podcast readout of the summary using AI-assisted text-to-speech

### Requirements
- **Split App Model:** News stored locally; feeds, summaries, and preferences synced through a cloud service
- **User Support:** Accounts with customizable feeds and saved topics
- **Sensor Use:** GPS is used to filter for local news when requested
- **Offline Mode:** Daily summaries and transcripts stored on the device, available to read or listen to offline



## PetPamper (#5 in Spring '24 BOTA)

### Pitch
Many independent pet groomers cannot afford to maintain a physical shop, and pet owners often struggle to find convenient, trustworthy services nearby. **PetPamper** is an app that connects pet owners with local groomers who provide at-home or mobile grooming services. It makes booking easier, supports small businesses, and helps pet owners give their pets reliable care without the hassle.

### Features
1. Groomer discovery and search
2. Booking system with availability management
3. Messaging with optional voice notes
4. Ratings and reviews with photos
5. Marketplace for pet products
6. Dual interface for groomers and pet owners
7. Service location options using GPS
8. Promotional offers and notifications
9. Progress tracking during grooming sessions

### Requirements
- **Split App Model:** Groomer and owner data stored locally; accounts, bookings, and messages stored in Firebase
- **User Support:** Accounts with profiles, booking history, and reviews
- **Sensor Use:** Microphone for voice notes, camera for review photos, GPS for locating services
- **Offline Mode:** Users can view saved profiles, past appointments, and cached messages without Internet


## StepUp

### Pitch
Many students struggle to stay active during busy schedules. **StepUp** is an app that motivates students to walk more by turning steps into tokens. It tracks steps with the phone's accelerometer (and optionally GPS for outdoor walks). Tokens can be pooled with friends for group challenges or later exchanged for rewards if sponsors join (e.g., Migros vouchers, cafeteria discounts). It makes walking fun, social, and potentially rewarding.

### Features 
1. Track steps with the accelerometer and (optionally) GPS
2. Convert steps into tokens stored in the app
3. Enable group challenges by pooling tokens with friends
4. Allow real-world rewards (with sponsor integration)

### Requirements
- **Split App Model:** Local storage for step counts, group goals and rewards stored in Firebase
- **User Support:** Users can form groups, set challenges, and track progress together
- **Sensor Use:** Accelerometer for step tracking, GPS for outdoor walks
- **Offline Mode:** Step counts and tokens are cached locally and synced once Internet is available


## La-Le-La

### Pitch

Many people want to learn a new language but find it difficult to practice regularly or connect with suitable partners. The **La-Le-La Language Learning** app helps learners find conversation partners based on the language they want to study and their availability. It provides suggested topics and tools to make practice easier, more engaging, and social.


### Features
1. Match users by language interests
2. Suggest conversation topics
3. Support direct messaging and global chat
4. Let users create vocabulary cards
5. Use geolocation to find partners nearby for in-person meetups
6. Allow community ratings of partners (e.g., helpful, friendly)

### Requirements
- **Split App Model:** Matching managed through Firebase; conversations and vocabulary stored locally and synced
- **User Support:** Users create profiles, chat, and rate partners
- **Sensor Use:** GPS for geolocation-based partner matching
- **Offline Mode:** Vocabulary cards and recent chats remain available offline

## Roomie

### Pitch
Living in a shared flat often creates challenges such as splitting bills, organizing chores, or keeping documents in order. The **Roomie** app brings all of these tasks together in one place. It helps users manage expenses, lists, and communication, while also supporting roommate and flat searches. This makes shared living more organized and collaborative.

### Features
1. Personal account system for each user
2. Find shared flats or roommates directly on the app (map, list, visit info, chat)
3. Expense tracking with clear balances showing who owes what
4. Shared documents and lists for groceries, fridge status, and bills
5. Social section for sharing deals, events, or dinners

### Requirements
- **Split App Model:** Local handling of lists and tasks; shared data managed by Firebase
- **User Support:** Personal accounts, expense tracking, and shared lists
- **Sensor Use:** GPS for location-based flat or roommate searches
- **Offline Mode:** Lists, expenses, and stored documents remain accessible offline
