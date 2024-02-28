## Mock Testing Exercise

Mock testing is a powerful approach in software testing that involves creating mock objects to simulate the behavior of real components. This technique is particularly useful in unit testing to isolate the piece of code being tested from its dependencies. By using mock objects, you can simulate various scenarios that your code may interact with in the real world.

## When to Use Mock Testing

- **Isolating the System Under Test:** Use mock testing when you want to isolate the system under test from external dependencies or services that are unpredictable, slow, or difficult to set up.
- **Simulating Scenarios:** Mocks are ideal for simulating specific conditions or edge cases that are hard to reproduce with real objects, such as specific weather conditions in a weather-dependent service.
- **Testing Interactions:** Use mock testing to verify that your code interacts correctly with its dependencies. You can assert that certain methods are called with the expected parameters.

## When Not to Use Mock Testing

- **Real Interactions:** Avoid mock testing when you need to test the real interactions between components or the integration of the system as a whole.
- **Overuse:** Be cautious of overusing mocks, as they can lead to tests that pass with flying colors but fail in production due to differences between the mock and the actual dependency.
- **Complex Logic in Mocks:** Avoid creating mocks with complex logic that mimic the behavior of the real components too closely. This can lead to tests that are hard to maintain and understand.

## Exercise

Supppose you are developing a service that recommends hikes near users based on the weather, 
and the module should take as input a weather service, a service that lists hikes,
a function that sorts hikes by length, and outputs an array of hikes.

How would you test the module and make sure it works under different weather conditions ? It's possible that new hikes are discovered and provided by the service in the future, how would you make sure the module is robust under hike changes ?
