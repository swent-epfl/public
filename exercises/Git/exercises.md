# Git Finger Exercises

## Introduction. Why Git?

Where do you store your code, and how do you make changes to it? 

If you're writing software on your own, this is not a problem, as you can use your own machine and change whichever files you want whenever you want. 

But if you're working with someone else, it starts being problematic. You could use an online cloud service where you store files, and coordinate who changes which file and when. You could email each other changes to sets of files. But this does not work so well when you have more people, and it is completely unusable when you have tens or hundreds of people working on the same codebase. 

This is where the Git infrastructure comes in.


## Prerequisites: installing Git on your machine.

- Install Git. On Windows, use [WSL](https://docs.microsoft.com/en-us/windows/wsl/install) as Git is designed mostly for Linux.
  On macOS, see [the git documentation](https://git-scm.com/download/mac). On Linux, Git may already be installed, or use your distribution's package manager.
  If you have successfully installed Git, running `git --version` in the command line should show a version number.

- Create a GitHub account (you do not have to use an existing GitHub account, you can create one just for this course if you wish).

- Set up an SSH key for GitHub by following [their documentation](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account)

- Tell Git who you are by running `git config --global user.name 'your_name'` with your name and `git config --global user.email 'your_email'` with the e-mail you used for GitHub

- Choose an editor Git will open to write a summary of your changes with `git config --global core.editor 'your_editor'`, since Git defaults to `vi` which is hard to use for newcomers.
    - On **Windows** with WSL you can use `notepad.exe`, which will open Windows's Notepad.
    - On **macOS** you can use `open -e -W -n` which will open a new TextEdit window.
    - On **Linux** you can use your distribution's built-in graphical text editor, or `nano`.

If you use Windows with WSL, note that running `explorer.exe .` from the Linux command line will open Windows's Explorer in the folder your command-line is, which is convenient.

Optionally, you may want to set the Git config setting `core.autocrlf` to `true` on Windows and `input` on Linux and macOS,
so that Git converts between Unix-style line endings (`\n`) and Windows-style line separators (`\r\n`) automatically.

## Exercise 1: How does one use Git?

Now that we've seen the theory, let's do some practice!
You will create a repository, make some changes, and publish it online. Then we'll see how to contribute to an existing online repository.

Make sure you follow along this step by step guided tutorial.

Git has a few basic everyday commands that we will see now, and many advanced commands we won't discuss here.
You can always look up commands on the Internet, both basic and advanced ones.
You will eventually remember the basics after using them enough, but there is no shame at all in looking up what to do.

We will use Git on the command line for this tutorial, since it works the same everywhere.
However, for everyday tasks you may prefer using graphical user interfaces such as [GitKraken](https://www.gitkraken.com/), [GitHub Desktop](https://desktop.github.com/), or the Git support in your favorite IDE.

Start by creating a folder and _initializing_ a repository in that folder:

```sh
~$ mkdir example
~$ cd example
~/example$ git init
```

Git will tell you that you have initialized an empty Git repository in `~/example/.git/`.
This `.git/` folder is a special folder Git uses to store metadata. It is not part of the repository itself, even though it is in the repository folder.

Let's create a file:

```sh
$ echo 'Hello' > hello.txt
```

We can now ask Git what it thinks is going on:

```sh
$ git status
...
Untracked files:
        hello.txt
```

Git tells us that it sees we added `hello.txt`, but this file isn't tracked yet.
That is, Git won't include it in a commit unless we explicitly ask for it. So let's do exactly that:

```sh
$ git add -A
```

This command asks Git to include all current changes in the repository for the next commit.
If we make more changes, we will have to ask for these new changes to be tracked as well.
But for now, let's ask Git what it thinks:

```sh
$ git status
...
Changes to be committed:
        new file:   hello.txt
```

Now Git knows we want to commit that file. So let's commit it:

```sh
$ git commit
```

This will open a text editor for you to type the commit message in. As we saw earlier, the commit message should be a description of _why_ the changes were made.
Often the very first commit in a repository sets up the basic file structure as an initial commit, so you could write `Initial commit setting up the file` or something similar.
You will then see output like this:

```sh
[...] Initial commit.
 1 file changed, 1 insertion(+)
 create mode 100644 hello.txt
```

Git repeats the commit message you put, here `Initial commit.`, and then tells you what changes happened. Don't worry about that `mode 100644`, it's more of an implementation detail.

Let's now make a change by adding one line:

```sh
$ echo 'Goodbye' >> hello.txt
```

We can ask git for the details of what changes we did:

```sh
$ git diff
```

This will show a detailed list of the differences between the state of the repository as of the latest commit and the current state of the repository, i.e., we added one line saying `Goodbye`.

Let's track the changes we just made:

```sh
$ git add -A
```

What happens if we ask for a list of differences again?

```sh
$ git diff
```

...Nothing! Why? Because `diff` by default shows differences that are not tracked for the next commit.
There are three states for changes to files in Git: modified, staged, and committed.
By default changes are modified, then with `git add -A` they are staged, and with `git commit` they are committed.
We have been using `-A` with `git add` to mean "all changes", but we could in fact add only specific changes, such as specific files or even parts of files.

In order to see staged changes, we have to ask for them:

```sh
$ git diff --staged
```

We can now commit our changes. Because this is a small commit that does not need much explanation, we can use `-m` to write the commit message directly in the command:

```sh
$ git commit -m 'Say goodbye'
```

Let's now try out branches, by creating a branch and switching to it:

```sh
git switch -c feature/today
```

The slash in the branch name is nothing special to Git, it's only a common naming convention to distinguish the purpose of different branches.
For instance, you might have branches named `feature/delete-favorites` or `bugfix/long-user-names`.
But you could also name your branch `delete-favorites` or `bugfix/long/user/names` if you'd like, as long as everybody using the repository agrees on a convention for names.

Now make a change to the single line in the file, such as changing "Hello" to "Hello today".
Then, track the changes and commit them:

```sh
$ git add -A && git commit -m 'Add time'
```

You will notice that Git tells you there is `1 insertion(+), 1 deletion (-)`.
This is a bit odd, we changed one line, why are there two changes?
The reason is that Git tracks changes at the granularity of lines.
When you edit a line, Git sees this as "you deleted the line that was there, and you added a new line". The fact that the "deleted" and the "added" lines are similar is not relevant.

If you've already used Git before, you may have heard of the `-a` to `git commit`, which could replace the explicit `git add -A` in our case.
The reason we aren't using it here, and the reason why you should be careful if using it, is that `-a` only adds changes to existing files.
It does not add changes to new files or deleted files.
This makes it very easy to accidentally forget to include some new or deleted files in the commit, and to then have to make another commit with just these files, which is annoying.

Anyway, we've made a commit on our `feature/today` branch.
In case we want to make sure that we are indeed on this branch, we can ask Git:

```sh
$ git branch
```

This will output a list of branches, with an asterisk `*` next to the one we are on.

Let's now switch to our main branch.
Depending on your Git version, this branch might have different names, so look at the output of the previous command and use the right one, such as `master` or `main`:

```sh
$ git switch main
```

To see what happens when two commits conflict, let's make a change to our `hello.txt` file that conflicts with the other branch we just made.
For instance, replace "Hello" with "Hello everyone".
Then, track the change and commit it as before.

At this point, we have two branches, our main branch and `feature/today`, that have diverged: they both have one commit that is not in the other.
Let's ask Git to merge the branches, that is, add the commits from the branch we specify into the current branch:

```sh
$ git merge feature/today
```

Git will optimistically start with `Auto-merging hello.txt`, but this will soon fail with a `Merge conflict in hello.txt`.
Git will ask us to fix conflicts and commit the result manually.

What does `hello.txt` look like now?

```sh
$ cat hello.txt
<<<<<<< HEAD
Hello everyone
=======
Hello today
>>>>>>> feature/today
Goodbye
```

Let's take a moment to understand this. The last line hasn't changed, because it's not a part of the conflict.
The first line has been expanded to include both versions: between the `<<<` and `===` is the version in `HEAD`, that is, the "head", the latest commit, in the current branch.
Indeed, on our main branch the first line was `Hello everyone`.
Between the `===` and the `>>>` is the version in `feature/today`.
What we need to do is manually merge the changes, i.e., edit the file to replace the conflict including the `<<<`, `===`, and `>>>` lines with the merged changes we want.
For instance, we could end up with a file containing the following:

```sh
$ cat hello.txt
Hello everyone today
Goodbye
```

This is one way to merge the file. We could also have chosen `Hello today everyone`, or perhaps we would rather discard one of the two changes and keep `Hello everyone` or `Hello today`.
Or perhaps we want yet another change, we could have `Hello hello` instead. Git does not care, it only wants us to decide what the merged version should be.

Once we have made our merge changes, we should add the changes and commit as before:

```sh
$ git add -A && git commit -m 'Merge'
```

Great. Wait, no, actually, not so great. That's a pretty terrible commit message. It's way too short and not descriptive.
Thankfully, _because we have not published our changes to another clone of the repository yet_, we can make changes to our commits!
This is just like how a falling tree makes no sound if there's no one around to hear it. If nobody can tell, it did not happen.
We can change our commit now, and when we push it to another clone the clone will only see our modified commit.
However, if we had already pushed our commit to a clone, our commit would be visible, so we could not change it any more as the clone would get confused by a changing commit since commits are supposed to be immutable.

To change our commit, which again should only be done if the commit hasn't been pushed yet, we "amend" it:

```sh
$ git commit --amend -m 'Merge the feature/today branch'
```

We have only modified the commit message here, but we could also modify the commit contents, i.e., the changes themselves.

Sometimes we make changes we don't actually want, for instance temporary changes while we debug some code.
Let's make a "bad" change:

```sh
$ echo 'asdf' >> hello.txt
```

We can restore the file to its state as of the latest commit to cancel this change:

```sh
$ git restore hello.txt
```

Done! Our temporary changes have disappeared.
You can also use `.` to restore all files in the current directory, or any other path.
However, keep in mind that "disappeared" really means disappeared. It's as if we never changed the file, as the file is now in the state it was after the latest commit.
Do not use `git restore` unless you actually want to lose your changes.

Sometimes we accidentally add files we don't want. Perhaps a script went haywire, or perhaps we copied some files by accident.
Let's make a "bad" new file:

```sh
$ echo 'asdf' > mistake.txt
```

We can ask Git to "clean" the repository, which means removing all untracked files and directories.
However, because this will delete files, we'd better first run it in "dry run" mode using `-n`:

```sh
$ git clean -fdn
```

This will show a list of files that _would_ be deleted if we didn't include `-n`.
If we're okay with the proposed deletion, let's do it:

```sh
$ git clean -fd
```

Now our `mistake.txt` is gone.

Finally, before we move on to GitHub, one more thing: keep in mind that Git only tracks _files_, not _folders_.
Git will only keep track of folders if they are a part of a file's path.

So if we create a folder and ask Git what it sees, it will tell us there is nothing, because the folder is empty:

```sh
$ mkdir folder
$ git status
```

If you need to include an "empty" folder in a Git repository for some reason, you should add some empty file in it so that Git can track the folder as part of that file.

Let's now publish our repository. Go to [GitHub](https://github.com) and create a repository using the "New" button on the home page.
You can make it public or private, but do not create files such as "read me" files or anything else, just an empty repository.

Then, follow the GitHub instructions for an existing repository from the command line. Copy and paste the commands GitHub gives you.
These commands will add the newly-created GitHub repository as a "remote" to your local repository, which is to say, another clone of the repository that Git knows about.
Since it will be the only remote, it will also be the default one. The default remote is traditionally named `origin`.
The commands GitHub provide will also push your commits to this remote.
Once you've executed the commands, you can refresh the page on your GitHub repository and see your files.

Now make a change to your `hello.txt`, track the change, and commit it.
You can then sync the commit with the GitHub repository clone:

```sh
$ git push
```

You can also get commits from GitHub:

```sh
$ git pull
```

Pulling will do nothing in this case, since nobody else is using the repository.
In a real-world scenarios, other developers would also have a clone of the repository on their machine and use GitHub as their default remote.
They would push their changes, and you would pull them.

Importantly, `git pull` only synchronizes the current branch. If you would like to sync commits from another branch, you must `git switch` to that branch first.

Similarly, `git push` only synchronizes the current branch, and if you create a new branch you must tell it where to push with `-u` by passing both the remote name and the branch name:

```sh
$ git switch -c example
$ git push -u origin example
```

Publishing your repository online is great, but sometimes there are files you don't want to publish.
For instance, the binary files compiled from source code in the repository probably should not be in the repository, since they can be recreated easily and would only take up space.
Files that contain sensitive data such as passwords should also not be in the repository, especially if it's public.
Let's simulate a sensitive file:

```sh
$ echo '1234' > password.txt
```

We can tell Git to pretend this file doesn't exist by adding a line with its name to a special file called `.gitignore`:

```sh
$ echo 'password.txt' >> .gitignore
```

Now, if you try `git status`, it will tell you that `.gitignore` was created but ignore `password.txt` since you told Git to ignore it.

You can also ignore entire directories.
Note that this only works for files that haven't been committed to the repository yet.
If you had already made a commit in which `password.txt` exists, adding its name to `.gitignore` will only ignore future changes, not past ones.
If you accidentally push to a public repository a commit with a file that contains a password, you should assume that the password is compromised and immediately change it.
There are bots that scan GitHub looking for passwords that have been accidentally committed, and they will find your password if you leave it out there, even for a few seconds.

Now that you have seen the basics of Git, time to contribute to an existing project!
You will do this through a _pull request_, which is a request that the maintainers of an existing project pull your changes into their project.
This is a GitHub concept, as from Git's perspective it's merely syncing changes between clones of a repository.

Go to <https://github.com/sweng-example/hello> and click on the "Fork" button.
A _fork_ is a clone of the repository under your own GitHub username, which you need here because you do not have write access to `sweng-example/hello` so you cannot push changes to it.
Instead, you will push changes to your fork, to which you have write access, and then ask the maintainers of `sweng-example/hello` to accept the change.
You can create branches within a fork as well, as a fork is just another clone of the repository.
Typically, if you are a collaborator of a project, you will use a branch in the project's main repository, while if you are an outsider wanting to propose a change, you will create a fork first.

Now that you have a forked version of the project on GitHub, click on the "Code" button and copy the SSH URL, which should start with `git@github.com:`.
Then, ask Git to make a local clone of your fork, though you should go back to your home directory first, since creating a repository within a repository causes issues:

```sh
$ cd ~
$ git clone git@github.com:...
```

Git will clone your fork locally, at which point you can make a change, commit, and push to your fork.
Once that's done, if you go to your fork on GitHub, there should be a banner above the code telling you that the branch in your fork is 1 commit ahead of the main branch in the original repository.
Click on the "Contribute" button and the "Open pull request" button that shows up, then confirm that you want to open a pull request, and write a description for it.

Congratulations, you've made your first contribution to an open source project!

The best way to get used to Git is to use it a lot. Use Git even for your own projects, even if you do not plan on using branches.
You can use private repositories on GitHub as backups, so that even if your laptop crashes you will not lose your code.

There are many advanced features in Git that can be useful in some cases, such as `bisect`, `blame`, `cherry-pick`, `stash`, and many more.
Read the [official documentation](https://git-scm.com/docs/) or find online advanced tutorials for more if you're curious!

## Exercise 2
You just started an internship in an IT services company.

Your first task is about maintaining an old version of a product still used by a large customer. A bug just got fixed in the latest version of the product, and you must fix it in the old version.

You ask where the source code is, and a developer shows you a repository in which the development team makes a single commit each week with the week's work. The old version is in another repository, which is a copy of the original repository made back when the version was released.

Suggest (1) a better way to handle old versions, (2) a better way to apply bugfixes to these versions, and (3) a process to apply your recommendations starting from the current state.

## Exercise 3: Good commit messages
Below are five commit messages. For each message, determine if it's a good or bad commit message and justify your reasoning.

### Commit message 1
```
Fixed bug
```

### Commit message 2
```
Refactor ShoppingCart class for better readability
```

### Commit message 3
```
Update README.md to include setup instructions
```

### Commit message 4
```
I changed the color of the submit button due to accessibility reasons
```

### Commit message 5
```
Apply changes discussed in person related to user login
```

## Exercise 4: Write a commit message
Fixing a Security Vulnerability.

During a routine security check, you discovered a vulnerability in the user authentication process that could allow an attacker to bypass password verification under certain conditions. You have successfully patched this vulnerability by implementing additional checks and validation steps in the authentication flow.

Write a good commit message that describes your work in fixing this security vulnerability.

## Bonus for you: Useful git cheat sheets
There are also online tutorials such as [Git's tutorial](https://git-scm.com/docs/gittutorial),
[GitHub's Git cheat sheets](https://training.github.com/), the [Quick & Simple Git Guide](https://rogerdudler.github.io/git-guide/) that you can look back at any time, or [Atlassian's Git tutorial](https://www.atlassian.com/git).

However, it's truly during live coding sessions, with your team's codebase hanging in the balance, that the real things happen. This is when the seemingly straightforward commands you've learned can lead to unexpected twists. 

Merge conflicts, detached heads, reverting files, or cancelling commits. Navigating through these with your team, the aha moments of understanding git's power, and, yes, sometimes the collective facepalms. 

But fear not, these are the moments that will cement your familiarity with version controlling, as you learn to repair the ugliest git mess-ups. Remember, you should Google up things: if you're having issues with it yourself, then it probably already happened with someone else.

Welcome to the fun side of version control: every mistake is a learning opportunity!