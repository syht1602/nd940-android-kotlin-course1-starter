# Project Title

This is the first assignment for android kotlin from udacity platform.
It is about listing the shoe and create a new shoe to update to the list.

## Getting Started

I forked the project from the github page.

####This project was built using the following technologies:
- Kotlin programming language
- Android Studio IDE
- Android Jetpack libraries, including ViewModel and LiveData
- Data Binding library

### Dependencies

```

    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.core:core-ktx:1.3.1'
    implementation 'com.google.android.material:material:1.0.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.0-rc1'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    implementation 'com.jakewharton.timber:timber:4.7.1'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.6.1'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'

    def nav_version = "2.3.5"

    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
	
	
    ext.nav_version = '2.5.0'
    classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
```

### Installation
List out the steps

1. Because I'm using the newest Java compiler so I changed build gradle tool to 7.0.1 and upgrade gradle property to

2. `distributionUrl=https\://services.gradle.org/distributions/gradle-7.2-bin.zip`

3. Change the `classpath 'com.android.tools.build:gradle:4.1.0'` to classpath `'com.android.tools.build:gradle:7.1.0'` in dependencies block of project build gradle

4. In **gradle-wrapper.properties** file change `distributionUrl=https\://services.gradle.org/distributions/gradle-7.2-bin.zip `

5. Add ` dataBinding { enabled = true }` to **android block** in app build gradle

6. Add to dependencies block in app build gradle
    `implementation "androidx.navigation:navigation-fragment-ktx:2.3.5"`
`    implementation "androidx.navigation:navigation-ui-ktx:2.3.5"`

7. Upgrade version `classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21" `

## Testing


### Break Down Tests

Explain what each test does and why

```
App show login screen when first start
The login screen must let user input and do login function
Click login button with any falsy data will notify the toast with "Login failed! " message
Click login button with any given data will notify the toast with "Login successfully! " message (email : "email", password: "password")
User click Login and after login successfully move to Welcome screen
User click back or do back press will go back to Login screen and do logout
User click next button and move to Instruction screen
In the Instruction screen, user click back or do back press will go back to Welcome screen
In the Instruction screen, user click next will go to Shoe List screen
After login if user force close app, next time will go directly to Shoe list screen
In the Shoe list screen, it will show all of the shoe in a scroll view, user can roll if the shoe item is too long
The Shoe item will show information about the Name, Company, Size and Description of the shoe.
User click 3 dots menu will show up the logout
User click logout menu, app will navigate to logout screen and do logout
After logout, next time when user launch the app will go to Login screen
In the Shoe list screen, there is an add shoe button
When user click add button will move to Shoe detail screen
In the Shoe detail screen, let user input Name, Company, Size and Description, all of field must be input to save new shoe item
User click Cancel button, comeback to Shoe list screen without any action
User click Save button, add Shoe item to current Shoe list and comeback to Shoe list screen, update Shoe list with new item
```
## Project Instructions

## Built With

* [Logo](https://www.hippopng.com/png-fb8p27) - Logo for login and the image place holder for shoe detail

Include all items used to build project.

## License
