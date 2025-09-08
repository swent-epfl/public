# User Story

> [!TIP]
> You can also review the lecture [slides](https://moodle.epfl.ch/pluginfile.php/3317323/mod_resource/content/4/Wk1.A.pdf) and the following related lecture videos:
[Requirements Overview](https://mediaspace.epfl.ch/playlist/dedicated/60382/0_orzu1on2/0_18p5vaz4) |
[Personas](https://mediaspace.epfl.ch/playlist/dedicated/60382/0_orzu1on2/0_15cl28jy) |
[User Stories](https://mediaspace.epfl.ch/playlist/dedicated/60382/0_orzu1on2/0_rukisjsw) |
[Requirements Validation](https://mediaspace.epfl.ch/playlist/dedicated/60382/0_orzu1on2/0_lnk2499i) |
[Epics & Story Mapping](https://mediaspace.epfl.ch/playlist/dedicated/60382/0_orzu1on2/0_9bglhde9).

A user story must follow the structure:

```txt
As a [type of user], I want [an action] so that [a benefit/value].
```

- Identify the specific user or role who will benefit from the feature. This can be a real user, like a customer or admin, or an abstract user, like a bot.
- Describe the action or task the user wants to perform. This should be clear and specific.
- Explain why the user wants to perform this action. What value or benefit will it provide them? This part ensures that the user story aligns with business goals.
- (Optional) Define conditions that must be met for the story to be considered complete. This can include specific functionality, performance metrics, or user experience details.

## Best Practices

- Keep It User-Centric. Focus on the user's needs rather than technical tasks. The goal is to ensure the development team understands the value from the user's perspective.
- Be Concise but Clear. The story should be brief but informative enough to guide development. Avoid ambiguous language.
- Avoid Technical Jargon. Use language that the user would understand. This ensures that all team members can grasp the story's intent.
- Include Acceptance Criteria. Clearly outline the conditions that will make the story complete. This helps avoid misunderstandings and ensures that the development meets expectations.
- Make It Negotiable. User stories are not contracts but conversation starters. They should be flexible enough to adapt during discussions between team members.

## Examples

### Good User Stories

```markdown
As a returning customer, I want to view my previous orders so that I can quickly reorder items I liked.
```

---

```markdown
As an admin, I want to generate a monthly sales report so that I can track our store's performance.

Acceptance Criteria:

- The report includes total sales, number of transactions, and top-selling products.
- The admin can select a date range for the report.
- The report is exportable as a CSV or PDF file.
```

### Bad User Stories

```markdown
As a user, I want to log in.
```

This story lacks context about why the user wants to log in and what value this provides. A better story might specify the purpose of logging in, such as accessing personalized content or account settings.

---

```markdown
As a developer, I want to refactor the authentication module.
```

This story is developer-centric rather than user-centric. User stories should focus on the user's needs. A better story might be: "As a user, I want to log in securely so that my personal information is protected," with the refactoring work addressed as part of the implementation plan.

---

```markdown
As a customer, I want better search functionality.
```

This story is too vague. It doesn't specify what "better" means or how the user experience should improve. A more precise story could be: "As a customer, I want to filter search results by price, rating, and category so that I can find products that meet my specific needs."

## Recap of the INVEST Criteria for User Stories

To ensure your user stories are of high quality, you can follow the **INVEST** acronym:

- Independent: Each story should be self-contained and not depend on other stories.
- Negotiable: Stories should be flexible to allow for collaboration and refinement.
- Valuable: The story should deliver value to the user.
- Estimable: The team should be able to estimate the effort required to complete the story.
- Small: Stories should be small enough to be completed within a single iteration.
- Testable: The story should be clear enough to define tests that confirm the feature works as intended.

## Further Reading

- [Mountain Goat Software's Guide to User Stories](https://www.mountaingoatsoftware.com/agile/user-stories)
