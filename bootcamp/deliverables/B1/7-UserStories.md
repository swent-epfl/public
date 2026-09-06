# User Stories

As you saw in the lectures, user requirements are often written as **user stories**.  They describe the desired functionality from the end user's perspective and help you focus on what matters to them.

In this Bootcamp, you will implement features based on the following user stories:

- As a user, I want to sign up and log into the app, so that my ToDos are kept across devices.  
- As a user, I want to create a new ToDo, so that I can add new tasks to my list.  
- As a user, I want to view a list of my ToDos, so that I can easily see all my pending tasks at once.  
- As a user, I want to edit and view details of my ToDos, so that I can update tasks or review their detailed descriptions.  
- As a user, I want to add locations to my ToDos and see them on a map, so that I can plan my work based on where tasks are.  

We provide these initial stories to give you a sense of the ToDo app.  Now it’s your turn: **Write two new user stories** that extend or improve the app. Think about what you would expect from a ToDo app!

---

## Requirements

- Write **2 new user stories**, different from the ones above.  
- Add them to the file **`userStories.txt`** at the root of your bootcamp repository.  
- Each line must contain exactly one complete user story.

> [!NOTE]
>
> Example of a valid `userStories.txt` file:
>
> ```text
> 1   As a user, I want to sign up and log into the app, so that my ToDos are kept across devices.
> 2   As a user, I want to create a new ToDo, so that I can add new tasks to my list.
> ```
>
> Example of an invalid `userStories.txt` file:
>
> ```text
> 1   As a user, I want to sign up and log into the app, 
> 2   so that my ToDos are kept across devices.
> 3
> 4   As a user, I want to create a new ToDo, so that I can add new tasks to my list.
> ```

---

Congratulations! You’ve completed the first deliverable of the bootcamp. Take a short break, and check that your Continuous Integration (CI) is green.

## Solutions

Now that you have finished B1, make sure the **`B1-public`** job is green **on `main`** (push to `main`, or a PR into `main`, with `BOOTCAMP_PART: B1`). 

Once you run the public tests, we strongly recommend that you also run the **staff** tests and work through the tests that fail, to understand why.  This work will deepend your understanding of what you wrote.

After **`B1-public`** becomes green, a branch named `B1-solution` will be created automatically in your repository with the reference solution. You can look at that branch to compare with your work; it is not merged into `main` for you. 

When you start B2, set `BOOTCAMP_PART: B2` in `.github/workflows/CI.yml` yourself.