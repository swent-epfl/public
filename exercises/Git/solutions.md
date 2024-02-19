# Solutions: Git Finger Exercises

## Exercise 2
### Evaluation criteria

- The recommendations should be based on good version control practices
- The recommendations should be realistic, and not only theoretical
  (for instance, it is unrealistic to cut up years' worth of history into commits each corresponding to a single change, even if this would be useful)


### Suggested solution

1. Each old version should be in a branch of the repository, not in another repository
2. Instead of one commit per week, each developer should make one commit per new feature or bug fix
3. The team should create a new branch per version and copy-paste the existing code for that version in the branch, which will create one large commit per version.
   Then, the team can enforce that all developers must use pull requests to merge changes.
   Fixes that need backporting to old versions can then done by "cherry picking" the relevant commits.

## Exercise 3:
### Commit Message 1: "Fixed bug"

Bad

**Justification:** The message lacks specificity about what bug was fixed, why it was fixed, or how. It doesn’t provide any context or information that would be useful for team members or for future referencing.

### Commit Message 2: "Refactor ShoppingCart class for better readability"

Good

**Justification:** Clear and to the point. It states what was done (refactoring the ShoppingCart class) and why (for better readability), which is useful for understanding the purpose of the changes without delving into the code.

### Commit Message 3: "Update README.md to include setup instructions"

Good

**Justification:** This is a good commit message because it precisely describes what was changed (README.md) and for what purpose (to include setup instructions). It provides clear and actionable information about the content and intent of the commit.

### Commit Message 4: "I changed the color of the submit button due to accessibility reasons"

Bad (but could be improved)

**Justification:** While the message explains what was done and why, the use of the first person ("I changed") is not in line with best practices for commit messages, which should be written in imperative mood. A better version could be "Change submit button color to improve accessibility".

### Commit Message 5: "Apply changes discussed in person related to user login"

Bad

**Justification:** Referring to an offline discussion is useless for anyone who was not part of it, and even for those who were since they are likely to forget after a while. It should explain what these changes were, and additionnaly provide info in the commit message body about the discussion, if needed for more context.

## Exercise 4:
### Evaluation Criteria
- The commit message should clearly summarize the fix in one line, using the imperative mood
- The detailed explanation should describe the nature of the vulnerability and the approach taken to fix it, without delving into technical specifics that can be seen in the code
- The message should convey the importance of the fix and its impact on the system's security.

### Suggested solution

```
Fix security vulnerability in user authentication process

Addressed a critical security issue where attackers could 
bypass password verification under specific scenarios. The 
fix introduces additional checks and validation steps in 
the authentication flow to ensure the integrity of user 
authentication. This patch enhances system security and 
protects against potential unauthorized access, following 
best practices for secure authentication mechanisms.
```