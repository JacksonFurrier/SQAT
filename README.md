# SQAT Software Quality And Testing
![](https://cdn.wallpapersafari.com/9/46/fs3zir.jpg)

## 0. Prerequisites
1. [Gradle](https://docs.gradle.org/current/userguide/userguide.html)
2. [Java](https://www.java.com/en/)
3. [Docker](https://www.docker.com/)

## 1. Setting up the environment
1. We will be using [docker based gradle](https://hub.docker.com/_/gradle), so first one must install Docker
2. To install docker desktop, go to dockers [homepage](https://www.docker.com/) and fetch the suitable docker version, which almost all the time is the docker-ce version 
    * **UBUNTU**, follow the steps of [digital ocean](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04)
    * **OS-X** follow the [official](https://docs.docker.com/desktop/install/mac-install/) website steps
    * **Win64** one should follow the official steps as well ++one can use and I suggest to use the WSL2 version. More on WSL 2.0 [here](https://learn.microsoft.com/en-us/windows/wsl/install).
3. After you have finished installing docker, fetch the gradle image by running ```docker pull gradle``` which will fetch the ```latest``` tagged docker gradle image from the hub. NOTICE! Docker on
Windows will interpret your path with the nix convention so ```C:\Users\John_Doe``` needs to be passed as ```/c/Users/John_doe``` otherwise it won't work.

## 2. Running the samples

To run the samples execute to following from the sample's directory ```docker run -i -t --rm -u gradle -v "$PWD":YOUR_PATH_TO_SAMPLE -w YOUR_PATH_TO_SAMPLE gradle gradle <gradle-task>```
