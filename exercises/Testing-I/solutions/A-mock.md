

## Mocking exercise answer

You should mock external services:

Since the weather conditions you want to test is different from what you get from the real time service, you can create mock responses from the weather service to test how your module reacts to different weather conditions. You also need to make sure, without mocking, that the weather service works as expected. You should also cover edge cases with the mocking.  

Similarly, you can mock hike listing service to return different sets of hikes. This allows you to test the robustness of your module against varying numbers and types of hikes.
