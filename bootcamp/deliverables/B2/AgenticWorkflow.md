# Your first coding agent

*From B2 on, you build the app with an AI **agent**. This is your first hands-on: a **single agent** builds a real feature, and you stay the final validator.*

An **agent** is different from a chatbot: instead of answering in a chat window for you to copy from, it **acts on the repo** (reads files, edits them, runs the build and the tests, reads the failures, commits). Your job shifts from writing code to **specifying and reviewing**.

> [!NOTE]
> **The loop that matters:** you give a **goal** and the acceptance criteria → the agent acts on the repo (edit, build, test) → **you review the diff** → you own it.
> Agents can be *confidently wrong*, so nothing gets merged blindly. Learning to specify and validate is the real skill.

## What you will do
This page is the **method**; you apply it to the **Create a ToDo** step that follows. As a first loop, have the agent build the `ToDosRepositoryFirestore`, then carry the same loop through the rest of the feature (the `AddToDoScreen`). For each, you give the goal, check the result, and own it.

## Setup (free, a few minutes)
You need the **GitHub Student Developer Pack** (free), which gives you Copilot with 200 AI credits a month. Building B2 this way costs only a few of them.

Prerequisites: Git, the **GitHub CLI** (`gh`) signed in with `gh auth login`, a JDK (17+), Node.js (for the CLI), the **Firebase emulator** (you set it up in the Setup Backend step), and an **Android emulator** or device for the instrumented tests.

> [!NOTE]
> You work in your **own bootcamp repo**, the per-student repo you already use. Branch off **`main`** first, so you never let the agent commit on it directly:
> ```
> git switch -c milestone-B2-agent
> ```
> Merge it back into **`main`** once you are happy with it: that is where CI run (with `BOOTCAMP_PART: B2`).

Install and start the agent, from the root of your repo:

```
npm install -g @github/copilot
copilot
```

> [!TIP]
> If the global install fails with a permissions error (`EACCES`), do not use `sudo`. Point npm's global installs to a folder you own, then install again:
> ```
> mkdir -p ~/.npm-global
> npm config set prefix ~/.npm-global
> echo 'export PATH=~/.npm-global/bin:$PATH' >> ~/.zshrc
> source ~/.zshrc
> ```

`copilot` asks you to trust the folder and reuses your Copilot login. When it wants to run a command or edit a file, it asks for permission (Yes / Yes for the session / No). Press `Esc` to stop or exit.

## The rules the agent follows: `AGENTS.md`
Open the **`AGENTS.md`** at the root of the repo. It holds the **durable rules** for any agent: the MVVM architecture, ViewModels never import Firebase, run `./gradlew check` before you submit, do not touch `sigchecks/`, and acknowledge contributors at the top of the file. Putting rules in a file means you do not re-explain them in every prompt. Keep it up to date as the app grows; this is one of the habits to take into the project.

## The feature and its target
Take `ToDosRepositoryFirestore`, the bridge between your app and the Firestore database. The **provided tests** (`ToDosRepositoryFirestoreTestB2`, and later `AddToDoScreenB2Test`) are what "done" means. They live under `androidTest/`, so they are **instrumented**: start an **Android emulator** (or connect a device) and the **Firebase emulator** so the agent can run them:

```
firebase emulators:start
```

## The single-agent loop
Example prompt (your model, adapt it):

> Read `AGENTS.md` and the failing test `ToDosRepositoryFirestoreTestB2`, then implement `ToDosRepositoryFirestore` so that it passes. Do not modify the tests. Follow `AGENTS.md`, keep the diff small.

- **Agent:** edits the code, runs `./gradlew check` and the instrumented tests (`./gradlew connectedDebugAndroidTest`, with the emulators running), reads the failures and iterates, then commits on your branch.
- **You verify:** rerun the tests yourself and read every change. Green? Is the change small and sensible?
- **Why:** agents can be *confidently wrong*. You never trust output you have not checked.

> [!IMPORTANT]
> **Do not just trust the green.** The agent is sometimes wrong in ways specific to the task. On `ToDosRepositoryFirestore`, a first pass often uses Firestore's automatic object mapping, which fails because the `ToDo` data class has no no-argument constructor. The fix is to convert to and from a `Map` by hand, as the handout suggests, and you only find it by running the tests and reading the failure. Watch also for a large diff for a small change, a hallucinated import, or tests that pass but check nothing.

## What counts as done
- The provided tests pass: `./gradlew check` (unit tests) and the instrumented tests (`./gradlew connectedDebugAndroidTest`) with the Firebase and Android emulators running, and formatting passes `./gradlew ktfmtCheck`.
- The delivery follows the standards in `AGENTS.md`: Kotlin style (ktfmt), an imperative commit subject of at most 50 characters, and the contributor acknowledged at the top of the file (the AI agent is a contributor: credit it).

You own every line you submit. "The agent wrote it" is not a defence.

## Reflect
Worth a few minutes (and the kind of *why* the exam can ask):
- Where was the agent confidently wrong, and how did you catch it?
- What did you have to spell out (the goal, the acceptance criteria) to get a good result?
- What did `AGENTS.md` save you from repeating?

> [!TIP]
> Keep your goals **bounded**: one reviewable change at a time. A giant "build the whole screen and the repository and wire navigation" prompt gives a giant diff you cannot review. Small goals, reviewed and owned one by one, are faster in the end.

## Going further
In **B3** you move from one agent to **several agents working together**. Same habits, more orchestration.

---

> [Next Step: Create a ToDo](2-CreateAToDo.md)
