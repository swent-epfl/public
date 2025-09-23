# 2. Access Control

In your current ToDo app, try the following:

- Sign in with your Google account
- Create a ToDo
- Sign out and sign back in with another Google account

You will observe that you can see the todos created by the first Google account.
This is a security flaw as any user can read or write the todos of any other user.
The goal of this section of the bootcamp is to implement _Access Control_ to prevent this behavior.
We need is a server-side mechanism that grants access to the todos based on the user making the query.
Firebase provides this functionality through _Firestore Security Rules_[^1].

## Security Rules Language

The server-side security rules are written in a specific language[^2].
Here is an example of a simple rule that allows anyone to read and write any document in the database:

```txt
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write;
    }
  }
}
```

The above rules allow any document to be read and written to by anyone:

- `match /{document=**}` means any document, at any nested level.
- `allow read, write;` authorizes any request.

If we were to replace `allow read, write;` with:

```txt
allow read: if request.auth != null;
allow write: if request.auth.uid == "123";
```

This would allow authenticated users to read any document, while only the user with a UID of 123 could write to it.
> [!NOTE]
> For finer control, `read` rules can be split into `get` and `list` rules, and `write` rules can be split into `create`, `update` and `delete` rules.

> [!TIP]
> There are other properties than `request.auth` that you can use, such as `request.path` or `request.resource`. Read more about their usage [here](https://firebase.google.com/docs/firestore/security/rules-conditions#data_validation), or see the detailed list [here](https://firebase.google.com/docs/rules/rules-language#building_conditions).

This should give you a basic idea of how Firestore security rules work. For more advanced features such as functions, local variables, or internal requests, read the detailed documentation [here](https://firebase.google.com/docs/rules/rules-language).

## Associating users with todos

Before implementing any security rules, todos must first be associated with a user, specifically the one that created it. To model this, we will use the `ownerId` field of the `ToDo` data class. This field will contain the unique identifier of the user that created the todo, and will be used by the security rules to validate requests.

> [!TIP]
>
> With Firebase Authentication, each user has a unique identifier called a UID.
> You can access the current user's UID using: Firebase.auth.currentUser?.uid

## Filtering todos when querying

Now that todos are associated with users, we can no longer simply fetch all todos from Firestore. This is because Firestore security rules are not filters, meaning that if you query all todos but some are created by other users, the entire request will fail.

Instead, we must create a query that fits the constraints of the security rules, and thus make a query that fetches only todos created by the current user. You can learn how to securely query data on this [page](https://firebase.google.com/docs/firestore/security/rules-query#queries_and_security_rules). You can also read the API reference on query filters on this [page](https://firebase.google.com/docs/reference/android/com/google/firebase/firestore/Filter).

> [!NOTE]
> You should now no longer see todos made by other users.
> However, this logic is only implemented client-side, meaning one can still retrive other todos by constructing a query sent directly to Firestore.
> Thus, it remains to write the security rules and deploy them server-side.

## Writing the rules

You should update the `firestore.rules` file in your project to implement the access control on the server-side. Make sure that:

- A user can only fetch and update its own todos
- A user can only create a new todo if `ownerId` field matches the user UID.

Locally, you can test your rules manually by connecting your app to the emulators. For a refresher, see [this](../B2/1-SetupBackend.md#usage).

## Deploying the rules

Now that your rules are written, they must be deployed to your actual Firestore database.

To do that, follow these steps:

- Copy the contents of your `firestore.rules` file.
- Navigate to the [Rules tab](https://console.firebase.google.com/project/_/firestore/rules) in the Cloud Firestore section of the Firebase console.
- Paste your rules in the editor and click publish.

> [!TIP]
> You can also use the [Firebase CLI](https://firebase.google.com/docs/firestore/security/get-started#use_the_cli) to deploy your security rules.
>
> This also lets you automatically deploy the security rules as part of your CI. This is known as _Infrastructure as code (IaC)_[^3].

## Test your implementation

Once you're done with your implementation, build and run the app to check that everything works as expected.

You can check if your rule is correct by running the `firebase/firestore/test/src/index.test.ts` test suite we provided by running the following command in your terminal:

```bash
# Start the emulators in a separate terminal
firebase emulators:start

# Go to the `firebase/firestore/test` directory
cd firebase/firestore/test

# Install dependencies
npm install

# Run the tests
npm test
```

Additionally, we recommend running the B2 test suites to verify that your app still functions properly after implementing access control.

You're done! Your app is now secured against any malicious request.

> [!NOTE]  
> Please click [here](./3-LocationBasedTodos.md) to proceed to the next step.

[^1]: <https://firebase.google.com/docs/firestore/security/get-started>
[^2]: <https://firebase.google.com/docs/rules/rules-language>
[^3]: <https://en.wikipedia.org/wiki/Infrastructure_as_code>
