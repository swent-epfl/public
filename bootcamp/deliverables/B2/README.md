# Milestone B2

This milestone focuses on creating the basic app with its core features, and beginning to test it.

The following tasks should be completed for this milestone.
We provide an estimated amount of time for each step.
After you complete a step, fill in the _actual_ time you spent in the `actualTimeB2.csv` CSV file that is already in the top folder of your individual repo.
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
      <td>Review <a href="/bootcamp/docs/ModularityAndAbstraction.md">Using Modularity and Abstraction</a> theory</td>
      <td>15</td>
      <td rowspan="6">Update <code>actualTimeB2.csv</code> file in your individual repo</td>
    </tr>
    <tr>
      <td>2</td>
      <td>Implement the <a href="1-SetupBackend.md">Setup Backend</a></td>
      <td>120</td>
    </tr>
    <tr>
      <td>3</td>
      <td>Set up your <a href="AgenticWorkflow.md">coding agent</a> and use it to build the next step</td>
      <td>30</td>
    </tr>
    <tr>
      <td>4</td>
      <td>Implement the <a href="2-CreateAToDo.md">Create a ToDo</a> user story</td>
      <td>300</td>
    </tr>
    <tr>
      <td>5</td>
      <td>Implement the <a href="3-TodoList.md">View List of ToDos</a> user story</td>
      <td>30</td>
    </tr>
    <tr>
      <td>6</td>
      <td>Implement the <a href="4-EditATodo.md">Edit a ToDo</a> user story</td>
      <td>180</td>
    </tr>
  </tbody>
</table>

## B2 Requirements

> [!IMPORTANT]
> Pushing B2 is not an obligation. Work on (or PR into) **`main`**, with `BOOTCAMP_PART: B2` in `.github/workflows/CI.yml`. As soon as the **`B2-public`** job is green on `main`, we publish the B2 reference solutions on a dedicated branch in your repo (`B2-solution`), usually within **20 minutes to 1 hour** — the sooner that happens, the sooner you can move on to B3 when it ships (edit `BOOTCAMP_PART` yourself when you are ready). The deadline of **23:59 on 17.09.2026** is only indicative.

We use the belt system described in the [README](../../README.md) for your Bootcamp.

- <span style="background-color: #f2f2f2;">White Belt</span> : You should be confident that your B1 work still holds (you built on it). CI for B2 only runs B2 public tests—unlock does not re-check B1.
- <span style="background-color: #FCE883;">Yellow Belt</span>: In addition to White,
  - Pass all the public B2 tests for [CreateAToDo](2-CreateAToDo.md)
  - You respected the template for the commit messages
- <span style="background-color: #77DD77;">Green Belt</span>: In addition to Yellow,
  - Pass all the public B2 tests for [View List of ToDos](3-TodoList.md) and [Edit a ToDo](4-EditATodo.md)
- <span style="background-color: #87CEFA;">Blue Belt</span>: In addition to Green,
  - Pass all the staff B2 tests for [CreateAToDo](2-CreateAToDo.md), [View List of ToDos](3-TodoList.md) and [Edit a ToDo](4-EditATodo.md)
- <span style="background-color: #3F3F3F; color: white;">Black Belt</span>: In addition to Blue,
  - Pass the staff B2 End to End test

## Solutions

When the **`B2-public`** job is green **on `main`** (push to `main`, or a PR into `main`, with `BOOTCAMP_PART: B2`), a branch named `B2-solution` is created automatically in your repository with the reference solutions.  You can browse or check out that branch to compare with your work, it is not merged into `main` for you.

> [!NOTE]
> The unlock script runs on a schedule. Expect the branch to appear within about **20 minutes to 1 hour** after the CI succeeds on `main` — you do not need to do anything else. Unlock does not change `BOOTCAMP_PART`; when B3 ships and you start it, set `BOOTCAMP_PART: B3` in `.github/workflows/CI.yml` yourself.
