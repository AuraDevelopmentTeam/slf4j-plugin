# slf4j-plugin

![Current Version](https://badge.fury.io/gh/AuraDevelopmentTeam%2Fslf4j-plugin.svg)
[![Build Status](https://gitlab.aura-dev.team/AuraDev/slf4j-plugin/badges/master/build.svg)](https://gitlab.aura-dev.team/AuraDev/slf4j-plugin/pipelines)
[![Coverage Report](https://gitlab.aura-dev.team/AuraDev/slf4j-plugin/badges/master/coverage.svg)](https://gitlab.aura-dev.team/AuraDev/slf4j-plugin/pipelines)
[![License](https://img.shields.io/github/license/AuraDevelopmentTeam/slf4j-plugin.svg)](https://github.com/AuraDevelopmentTeam/slf4j-plugin/blob/master/LICENSE)

A SLF4J logging implementation for the Bungeecord and Bukkit/Spigot platforms.

The motivation is quite simple:  
When using SLF4J on either Bungeecord or Spigot/Bukkit even adding the jdk14 adapter doesn't work properly. Instead we need a specialized adapter for each
platform. And that is exactly what this is.

## Table of Contents

- [Downloads](#downloads)
- [Using this library](#using-this-library)
	- [Adding it to your project](#adding-it-to-your-project)
		- [Maven](#maven)
		- [Gradle](#gradle)
	- [Usage](#usage)
- [Issue Reporting](#issue-reporting)
- [Feature Requests](#feature-requests)
- [Setting up a Workspace/Compiling from Source](#setting-up-a-workspacecompiling-from-source)
- [Development builds](#development-builds)
- [PGP Signing](#pgp-signing)
- [License](#license)
- [Support](#support)
	- [Getting Support](#getting-support)
	- [Supporting us!](#supporting-us)

## Downloads

You can download all builds from:

- Maven:
  - Releases: https://maven.aura-dev.team/repository/auradev-releases/
  - Snapshots: https://maven.aura-dev.team/repository/auradev-snapshots/

## Using this library

### Adding it to your project

You can easily use this library by including it as a maven dependency, as all releases get uploaded to our maven repository. (Replace `{bungeecord|spigot}` with
the appropriate edition for your platform and `{version}` with the appropriate version!)

#### Maven

```xml
<repositories>
    <repository>
        <id>AuraDevelopmentTeam</id>
        <url>https://maven.aura-dev.team/repository/auradev-releases/</url>
        <!--<url>https://maven.aura-dev.team/repository/auradev-snapshots/</url>-->
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>dev.aura.lib.slf4j-plugin.{bungeecord|spigot}</groupId>
        <artifactId>slf4j-plugin-{bungeecord|spigot}-1.7.25</artifactId>
        <version>{version}</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

#### Gradle

```gradle
repositories {
    maven {
        name "AuraDevelopmentTeam"
        url "https://maven.aura-dev.team/repository/auradev-releases/"
        // url "https://maven.aura-dev.team/repository/auradev-snaptshots/"
    }
}

dependencies {
    compile "dev.aura.lib.slf4j-plugin.{bungeecord|spigot}:slf4j-plugin-{bungeecord|spigot}-1.7.25:{version}"
}
```

### Usage

*To be added*

## [Issue Reporting](https://github.com/AuraDevelopmentTeam/slf4j-plugin/issues)

If you found a bug or even are experiencing a crash please report it so we can fix it. Please check at first if a bug report for the issue already
[exits](https://github.com/AuraDevelopmentTeam/slf4j-plugin/issues). If not just create a
[new issue](https://github.com/AuraDevelopmentTeam/slf4j-plugin/issues/new) and fill out the form.

Please include the following:

* Library version
* Java version
* For crashes:
  * Steps to reproduce
  * Log files that contain stack traces

*(When creating a new issue please follow the template)*

## [Feature Requests](https://github.com/AuraDevelopmentTeam/slf4j-plugin/issues)

If you want a new feature added, go ahead an open a [new issue](https://github.com/AuraDevelopmentTeam/slf4j-plugin/issues/new), remove the existing form and
describe your feature the best you can. The more details you provide the easier it will be implementing it.  
You can also talk to us on [Discord](https://discord.me/bungeechat).

## Setting up a Workspace/Compiling from Source

* Clone:  
  Clone the repository like this: `git clone --recursive https://github.com/AuraDevelopmentTeam/slf4j-plugin.git`
* IDE-Setup:  
  Run [gradle] in the repository root: `./gradlew installLombok <eclipse|idea>`
* Build:  
  Run [gradle] in the repository root: `./gradlew build`. The build will be in `build/libs`
* If obscure Gradle issues are found try running `./gradlew cleanCache clean`

## Development builds

Between each official release there are several bleeding edge development builds, which you can also use. But be aware that they might contain unfinished
features and therefore won't work properly.

You can find the builds here: https://gitlab.aura-dev.team/AuraDev/slf4j-plugin/pipelines

On the right is a download symbol, click that a dropdown will open. Select "build". Then you'll download a zip file containing all artifacts including the
library jar.

## PGP Signing

All files will be signed with PGP.  
The public key to verify it can be found in `misc/publicKey.asc`. The signatures of the files will also be found in the maven.

## License

slf4j-plugin is licensed under the [MIT License](https://opensource.org/licenses/MIT)

## Support

### Getting Support

If you need help with anything, want to discuss issues or suggestions, or just want to say hi, you can visit our
[Discord Server (https://discord.me/bungeechat)](https://discord.me/bungeechat).

### Supporting us!

Thanks for scrolling down so far!  
We are developing this plugin (and others!) as well as providing constant support for all our plugins free of charge so that as many people as possible can use
it! Since it is still a lot of work we would really appreciate it if you could support us on [Patreon](https://www.patreon.com/AuraDev)!

<p align="center"><a href="https://www.patreon.com/bePatron?u=6416598"><img alt="Become a Patreon" src="https://c5.patreon.com/external/logo/become_a_patron_button.png"></a></p>

## Random Quote

> Every good work of software starts by scratching a developer’s personal itch.
>
> — <cite>Eric S. Raymond</cite>
