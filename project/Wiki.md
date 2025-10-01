# Wiki

## Decisions

## Naming Conventions

### Branch Naming Conventions
- `feat/feature-name`        New features
- `fix/issue-number`        Bug fixes  
- `refactor/component-name`    Code improvements
- `docs/section-name`          Documentation updates
  
### Commits Naming Conventions

#### Format
`<type>[optional scope]: <short description>`

#### Allowed types
- **feat** → add a new feature  
  _Ex: `feat(api): add event clustering`_
- **fix** → fix a bug  
  _Ex: `fix(auth): resolve token expiration issue`_
- **docs** → documentation only (no code changes)  
  _Ex: `docs(readme): add setup instructions`_
- **style** → code style/formatting only (no logic changes)  
  _Ex: `style: reformat code with Prettier`_
- **refactor** → code changes that neither fix a bug nor add a feature  
  _Ex: `refactor(db): extract query builder logic`_
- **perf** → performance improvements  
  _Ex: `perf(cache): reduce response latency by 20%`_
- **test** → add or update tests  
  _Ex: `test(user): add integration tests for profile update`_
- **chore** → maintenance tasks (dependencies, configs, scripts)  
  _Ex: `chore(deps): bump Firebase SDK to v11.3.0`_
- **build** → changes to the build system or external dependencies  
  _Ex: `build(gradle): add release signing config`_
- **ci** → changes to CI/CD configuration or scripts  
  _Ex: `ci(github-actions): add lint workflow`_
- **revert** → revert a previous commit  
  _Ex: `revert: feat(auth): add social login`_
  
## Code review processes
- Each PR must be reviewed by at least one teammate, thoroughly and in time, to avoid blocking others.  
- Reviews should check both **design** (patterns, integration risks) and **implementation** (bugs, clarity).  
- Read the full code: comment on mistakes, improvements, or unclear parts; ask questions if needed.  
- Make clear comments theme (e.g., **Important**, **Question**, **Nitpick**, ...) and focus on the **code, not the author**.  
- Positive feedback is encouraged; acknowledge good solutions.

## Communication protocols
- Use `Handle-merges-and-conflicts` channel in Discord.  

## User stories

### Account / Authentication
- As a user, I want to **create an account** so that I can access the application.  
- As a user, I want to **log in to my account** so that I can retrieve my events and my own memories.  

### Events
- As a user, I want to **create an event** so that I can find people to do a certain activity.  
- As a user, I want to **join an event** so that I can participate and secure a place.  

### Memories
- As a user, I want to **add memories (images, videos, text, sounds) to a finished event** so that I can preserve my personal experiences.  

### Map
- As a user, I want to **see only my memories displayed on a map** so that I can visualize where I created my memories.
- As a user, I want to **see every available event displayed on a map** so I can decide which one to join. 
