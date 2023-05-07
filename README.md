# README Template

Below is a template provided for use when building your README file for students.

# Project Title

Project description goes here.

## Getting Started

Instructions for how to get a copy of the project running on your local machine.
I forked the project from the github page.

### Dependencies

```
Examples here
```

### Installation

Step by step explanation of how to get a dev environment running.

Because I'm using the newest Java compiler so I changed build gradle tool to 7.0.1 and upgrade gradle property to distributionUrl=https\://services.gradle.org/distributions/gradle-7.2-bin.zip

List out the steps

Change the classpath 'com.android.tools.build:gradle:4.1.0' to classpath 'com.android.tools.build:gradle:7.1.0' in dependencies block of project build gradle

Change distributionUrl=https\://services.gradle.org/distributions/gradle-7.2-bin.zip in gradle-wrapper.properties file

Add
    dataBinding {
        enabled = true
    }

to android block in app build gradle

Add
    //navigation
    implementation "androidx.navigation:navigation-fragment-ktx:2.3.5"
    implementation "androidx.navigation:navigation-ui-ktx:2.3.5"
to dependencies block in app build gradle
```
Give an example here
```

## Testing

Explain the steps needed to run any automated tests

### Break Down Tests

Explain what each test does and why

```
Examples here
```
## Project Instructions

This section should contain all the student deliverables for this project.

## Built With

* [Item1](www.item1.com) - Description of item
* [Item2](www.item2.com) - Description of item
* [Item3](www.item3.com) - Description of item
* [Logo](https://www.hippopng.com/png-fb8p27) - Logo for login

Include all items used to build project.

## License
