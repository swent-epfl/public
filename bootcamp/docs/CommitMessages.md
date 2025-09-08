# Writing good commit messages

Commit messages are essential to work efficiently with other persons. They provide context for why a change was made, facilitate code review, and improve the overall maintainability of a project. Well-written commit messages make it easier for teams to understand the history of a project and to pinpoint issues when bugs arise.

## Best Practices

1. Write Clear and Descriptive Messages\
   A commit message should describe the **what** and **why** of the change. A good message gives an overview of the work and its purpose, making it easier for others to understand the change.
   Avoid generic messages like "fix" or "update" as they do not provide enough context.

2. Use the Imperative Mood\
   The convention is to write the message in the imperative mood, as if you are giving an order or command. For example, use "Fix bug in user login" instead of "Fixed bug in user login." This follows the style used by Git itself when creating commits (e.g., "Merge branch...").

3. Keep the Message Short and Focused\
   Limit the subject line (the first line of the commit message) to 50 characters or less.
   If more detail is needed, include a blank line after the subject line, followed by a more detailed explanation in the body. This body can include reasoning, background information, or links to related resources.

4. Capitalize the First Letter of the Subject\
   This improves readability and follows general writing conventions.

5. Use the Body to Explain What and Why (optional)\
   If the subject line is not enough to fully convey the change, add more details in the body of the commit. The body should be wrapped at 72 characters per line to ensure readability.

6. Reference Issues or Tickets (optional)\
   If your commit relates to a specific issue, reference it in the commit message by including a ticket number or issue ID. This helps track the commit back to the specific requirement or bug report it addresses.

## Examples

### Good Commit Messages

```markdown
Add user authentication feature

Add a new authentication system using JWT to handle user login and session management.
This update includes token generation, middleware for protecting routes, and unit tests.

Related to #42
```

```markdown
Fix typo in the README file
```

```markdown
refactor: extract API request logic into a service class

Moved repetitive API request logic from controllers to a dedicated service class.
This improves maintainability and adheres to the DRY principle.
```

### Bad Commit Messages

```markdown
fix
```

```markdown
Changes to the login feature
```

```markdown
Fixed bug in code
```

## Advanced: Understanding Conventional Commits

The [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) specification is a standardized format for commit messages. This convention adds a type and optional scope to your commit message, making it easier to understand the purpose of the commit at a glance.

Over the years, this practice has gained popularity, more and more developers and enterprise are using this convention. It increases the clarity of each commit, and the standardized format for the message allows scripts to classify commits, for example to automatically generate a changelog or trigger specific job in the CI/CD (release a patch on a `fix`, etc.).

Structure of a Conventional Commit:

```markdown
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

- **Type**: Describes the category of change (e.g., `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore`).
- **Scope** (Optional): A noun describing a section of the codebase affected (e.g., `auth`, `api`, `ui`).
- **Description**: A brief summary of the changes made.
- **Body** (Optional): Explains the motivation behind the change and what was done.
- **Footer** (Optional): Contains any references to issues or breaking changes.

Examples of Conventional Commits

```markdown
feat(api): add user registration endpoint

Added a new endpoint for user registration, including validation and database persistence.
```

```markdown
fix(auth): resolve password reset issue

Fixed an issue where users were unable to reset their passwords due to incorrect token validation.
Closes #56
```

> [!WARNING]
> When writing commit messages using this convention, the description of the change is **not** capitalized.

## Further Reading

- [Chris Beams' guide on writing good commit messages](https://chris.beams.io/posts/git-commit/)
- [Conventional Commits specification](https://www.conventionalcommits.org/en/v1.0.0/)
