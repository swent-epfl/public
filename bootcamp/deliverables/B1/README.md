# Milestone B1

This milestone focuses on setting up your Android development infrastructure, plus a few basics of the Todo app.

The following tasks should be completed for the first milestone.
We provide an estimated amount of time for each step.
After you complete a step, fill in the _actual_ time you spent in the `actualTimeB1.csv` CSV file that is already in the top folder of your individual repo.
Do not edit this README, and make sure you preserve the structure of the CSV file.

<table>
    <colgroup>
      <col style="width:5%; text-align:center">
      <col style="width:55%">
      <col style="width:20%; text-align:center">
      <col style="width:20%">
    </colgroup>
    <thead>
    <tr>
      <th>Step #</th>
      <th>Step description</th>
      <th>Estimated time (minutes)</th>
      <th>Actual time (minutes)</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td><a href="1-EnvironmentSetup.md">Environment Setup</a></td>
      <td>60</td>
      <td rowspan="7">Update <code>actualTimeB1.csv</code> file in your individual repo</td>
    </tr>
    <tr>
      <td>2</td>
      <td>Create your first Android application: <a href="2-GettingStartedWithAndroid.md">Greeting App</a></td>
      <td>150</td>
    </tr>
    <tr>
      <td>3</td>
      <td>First feature of the Todo App: <a href="3-TodoList.md">Todo List screen</a></td>
      <td>180</td>
    </tr>
    <tr>
      <td>4</td>
      <td>Set up the <a href="4-Navigation.md">Navigation</a></td>
      <td>120</td>
    </tr>
    <tr>
      <td>5</td>
      <td>Set up <a href="5-ContinuousIntegration.md">Continuous Integration</a> on GitHub</td>
      <td>15</td>
    </tr>
    <tr>
      <td>6</td>
      <td><a href="6-APK.md">Build the APK</a></td>
      <td>15</td>
    </tr>
    <tr>
      <td>7</td>
      <td><a href="7-UserStories.md">Write user stories</a> for the Todo app</td>
      <td>30</td>
    </tr>
  </tbody>
</table>

> [!NOTE]
> Initially the Continuous Integration (CI) will fail, as it runs the tests to check your code automatically. By the end of B1, make sure your last commit of B1 successfully passes all the CI checks. To see if your code passes, go to the Actions tab in your GitHub repository.

## B1 Grading

> [!IMPORTANT]
> Automated grading will apply to the `main` branch of your repo, based on the last commit you make and push **before 23:59 on 15.09.2025**.
> If you start working on B2 before the deadline for B1, do so on a branch called `milestone-B2`, which you then merge into `main` after the B1 deadline.

We use the belt system described in the [README](../../README.md) to grade your Bootcamp.

### Requirements

- <span style="background-color: #f2f2f2;">White Belt</span> : You committed something to the repository before the deadline
- <span style="background-color: #FCE883;">Yellow Belt</span>: In addition to White,
  - Pass all the public tests for [Greeting](2-GettingStartedWithAndroid.md) and [Todo List](3-TodoList.md)
  - Your commit messages are acceptable
  - The two user stories are acceptable
- <span style="background-color: #77DD77;">Green Belt</span>: In addition to Yellow,
  - Pass all the public tests for [Navigation](4-Navigation.md)
  - Your commit messages are good
  - The two user stories are good
- <span style="background-color: #87CEFA;">Blue Belt</span>: In addition to Green,
  - Pass all the staff tests for [TodoList](3-TodoList.md) and [Navigation](4-Navigation.md)
  - Your commit messages are good
  - The two user stories are good
- <span style="background-color: #3F3F3F; color: white;">Black Belt</span>: In addition to Blue,
  - Your commit messages are perfect
  - The two user stories are perfect
