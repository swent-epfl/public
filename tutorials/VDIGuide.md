# A guide to the SwEnt VDI machines

## Get access to VDI machines

First, please check the [official document](https://support.epfl.ch/epfl?id=epfl_kb_article_view&sysparm_article=KB0017020) about VDI machines to familiarize yourself with their usage. Learn how to log in to the platform and try to use an existing machine to understand the basic operations.


## Run Android Studio on the machine

IT only configured the Ubuntu environment for us, so if you are not familiar with Linux, please learn the basic operations, be patient, and try to solve problems by searching, asking ChatGPT, and getting help from us.

Android Studio is already installed on the machine. After starting the machine, open a terminal (it should be on the dock on the left) and run the following command to launch Android Studio:

```shell
/opt/android-studio/bin/studio.sh
```

You will see some output in the terminal, which you can usually ignore. Android Studio should now appear. Next, follow the documentation in your Bootcamp repo to initialize Android Studio.

<p align="center"><img alt="VDI Screenshot" src="./assets/VDIAndroidStudio.png" width="90%" /></p>

## Limitations of VDI machines

VDI machines are for temporary use, so files will be reset once you disconnect. To keep your files, several special directories have been made persistent. The full list is below:


```
/home/$USER/Android
/home/$USER/AndroidStudioProjects
/home/$USER/.local/share/Google
/home/$USER/.java
/home/$USER/.gradle
/home/$USER/.android
```

There are two unhidden directories in your home directory (`/home/$USER`): `Android` and `AndroidStudioProjects`. The `Android` directory is the default location for SDKs required by Android Studio, while `AndroidStudioProjects` stores your Android projects.

Directories whose names begin with `.` store temporary build results of your project. However, because these persistent directories are stored remotely, reading and writing to them is slower. If you notice that building, indexing, or downloading in these directories is slow, that is normal.

The caching directory  `~/.cache` cannot be set up as a persistent directory. Therefore, if you find that Android Studio re-indexes the code after you reconnect, that is also normal.


## Cloning the Bootcamp repo

Your Bootcamp repo should be placed in `AndroidStudioProjects` directory. To do this, navigate to `~/AndroidStudioProjects` and run  `git clone <repo>` inside that directory.

If you are using ssh-based authentication, please place your ssh keys in a persistent directory, for example, under the same parent directory as ```AndroidStudioProjects```:

```bash
$ ls ~/Desktop/myfiles/epfl_roaming/ic_in-sc/adrstd2/
AndroidStudioProjects/  ssh/
$ ls ~/Desktop/myfiles/epfl_roaming/ic_in-sc/adrstd2/ssh
key  key.pub
```

Then, make the default `~/.ssh` directory a symbolic link to your persistent `ssh/` directory, so that Git can find your keys automatically:
```bash
$ ln -s ~/Desktop/myfiles/epfl_roaming/ic_in-sc/adrstd2/ssh ~/.ssh
```

## Common Issues (Q&A)

**Q: Android Studio does not automatically start building and indexing my project. What should I do?**  
A: Check whether a bar appears asking you to trust the project. If it does, click **Trust**.

---

**Q: A pop-up window asks me which JDK to use. Which one should I choose?**  
A: It usually does not matter. In most cases, you can simply select Android Studio's JDK.

---

**Q: I see errors about not having enough space in MyNas. What can I do?**  
A: As a temporary workaround, you can re-link large directories (that are linked to MyNas) to a local folder (e.g., `/tmp/xxx`) using the `ln -s` command. Since the local storage of VDI machines is 100 GB, this is usually sufficient.
