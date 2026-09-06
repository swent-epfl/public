# Three agents, one you

*You built B2 with a single agent. B3 steps up to **multi-agent**: three agents, one you. They write the code, write the tests, and review; you **orchestrate, review, approve and own**.*

> [!NOTE]
> **The loop is the same, multiplied.** You still give the goal and own the result. What changes is that **writing, testing and reviewing are delegated to separate agents**, and you are the one who ties it together. Owning the result cannot be delegated.

## What you will do
This page is the **method**; you apply it to the **Location-based To-Dos** step that follows. You build that feature (the **Nominatim location repository**, forward geocoding) with three roles:

1. a **code** agent writes the feature,
2. a **test** agent writes its tests,
3. a **reviewer** agent reviews the pull request.

You launch each role, check its output, and decide what happens next.

## Setup
Same as B2: the **GitHub Copilot CLI** (`copilot`), signed in with `gh auth login`, and the **`AGENTS.md`** at the repo root that every agent reads. Branch off **`main`** first:

```
git switch -c milestone-B3-agent
```

Merge it back into **`main`** once you are happy with it: that is where CI and solutions unlock run (with `BOOTCAMP_PART: B3`).

> [!TIP]
> Give each role a **fresh session** (run `copilot` again). A fresh session starts from a blank context: the agent does not remember the previous chat, it only sees the current state of the repo. This is what stops the reviewer from simply defending the coder.

## The flow
The **first** role comes with an example prompt, to show you the shape. For the **next two**, you write the prompt yourself: phrasing the task for an agent is part of the skill. For each role: the goal, what the agent does, what **you** verify, and why.

### 1. Code agent
Example prompt (your model for the rest):

> Read `AGENTS.md`, the `Location` model and the provided `LocationRepository` signature, then implement `LocationRepository` and `NominatimLocationRepository` in `model/map/` so they query the Nominatim search API with OkHttp and parse the JSON into a `List<Location>`. Keep the provided signatures unchanged (a sigcheck enforces them). Follow `AGENTS.md`, keep it focused.

- **Agent:** creates the files and makes them compile.
- **You verify:** read the code. Does it do what you asked, and respect the Nominatim usage policy (a real `User-Agent`)?
- **Why:** the agent writes fast; you decide whether it is right.

### 2. Test agent
**Your goal (write the prompt):** get an agent to write **mocked, idempotent** unit tests for the repository (mock the injected `OkHttpClient` so the tests never hit the network; `mockk` and `mockito` are already in the template, or add `MockWebServer` if you prefer a fake server), asserting the parsed `Location` fields.

- **Agent:** writes the tests and runs them.
- **You verify:** do the tests actually assert the parsed fields (name, latitude, longitude), or do they pass without checking anything?
- **Why:** "tests that pass and check nothing" is a real failure mode. Coverage going up does not mean correctness went up.

### 3. Reviewer
Start a **fresh session** so the reviewer does not defend the coder's work.

First, package your review checklist as a **skill**, so every reviewer agent holds to the same bar without you retyping it. A skill is a named, reusable capability the agent loads on demand, a step beyond `AGENTS.md` and something a plain chatbot cannot do. Create `.github/skills/review-checklist/SKILL.md`:

```
---
name: review-checklist
description: How to review an agent's pull request in SwEnt
---
Review against AGENTS.md and these points:
- the tests pass, and they actually assert behaviour, not just counts or empty checks;
- the diff is bounded and reviewable; a small feature should not touch unrelated files;
- error handling and edge cases are covered;
- the code follows MVVM and does not touch generated or sigcheck files;
- contributors are acknowledged at the top of the file.
Report each point as OK or ISSUE, and refuse to approve what you cannot review.
```

Copilot **discovers** skills in `.github/skills/` automatically. In your fresh reviewer session, confirm it is loaded:

```
copilot skill list
```

**Your goal (write the prompt):** open a pull request with the code and the tests, then get a reviewer agent to review it using the `review-checklist` skill, and flag anything off.

- **Agent:** opens the pull request, then posts its findings on it.
- **You:** read them, keep what holds, drop what does not, and have the final say.
- **Why:** separating author from reviewer catches what the author missed, and the skill means every review holds to the same standard. You remain the validator.

> [!NOTE]
> On your own pull request, GitHub only lets you leave **comments**, not a formal Approve or Request changes. For a real second-identity review you can also request the **Copilot code review** bot.

> [!TIP]
> Running three agents burns more of your monthly credits than one. A well-known skill, **Caveman** ([JuliusBrussee/caveman](https://github.com/JuliusBrussee/caveman)), makes agents drop filler and answer tersely; its author reports cutting token usage by around 65 percent. You add it with `copilot skill add`, and it is worth knowing when you orchestrate several agents.

## Judge the diff
A small feature that arrives as a **sprawling pull request** touching unrelated files is a red flag. Do not approve it: ask for it to be **split** into one reviewable change, and drop the unrelated edits. A change you cannot review is a change you cannot own. Watch for **architecture drift** too: every feature fine in isolation, but nothing fits together anymore.

## What counts as done
- The code compiles and the tests pass.
- The tests actually check the behaviour (you verified this yourself).
- The delivery follows `AGENTS.md`, and contributors are acknowledged.

You own every line, and the exam is **closed-book**, so make sure you understand what the agents produced.

## Reflect
- What did the reviewer agent catch that you missed? What did it flag that was wrong?
- Were the agent's tests meaningful, or did they pass without checking anything?
- What did the `review-checklist` skill save you, run across every review? What else could you turn into a skill?
- Where would you still refuse to trust the agents without checking?

> [!TIP]
> **Did you know:** with `git worktree` you can check out several branches into separate folders from the same repo at once. That lets you run the **three agents in parallel**, each in its own worktree, without them stepping on each other, exactly the multi-agent setup, sped up.

---

> [Next Step: Location-based To-Dos](3-LocationBasedTodos.md)
