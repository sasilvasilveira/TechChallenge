# TechChallenge
This is a project to create a Reddit Feed where a subreddit is given by the user and on the next screens, it´s subreddit posts are displayed.

## Requirements

- Android Studio Giraffe (or more recent version);

### System dependencies
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.9")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

### New Installed dependencies
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
    implementation("com.github.kittinunf.fuel:fuel-android:2.3.1")
    implementation("com.google.code.gson:gson:2.8.9")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

## Installation and Setup

- Download this project;
- Open it on Android Studio;
- Click on Build (located on top bar) -> Clean Project;
- Click on Build (located on top bar) -> Rebuild Project;
- Go to "Device Manager" (located at the right side bar) and "Create Device";
- Select "Pixel 4" and click "Next";
- Select "API 34" (if an underlined arrow appears beside it, click on it and wait for its download to finish) and click "Next";
- Click on "Finish";
- Go to App -> src -> main -> java -> com.example.feedreddit -> RedditConn and fill the following values with your credentials:\
      &nbsp;- AUTHORIZATION_USER\
      &nbsp;- AUTHORIZATION_PASSWORD\
      &nbsp;- AUTHORIZATION_REDDIT_USER\
      &nbsp;- AUTHORIZATION_REDDIT_PASSWORD\
  ![image](https://github.com/sasilvasilveira/TechChallenge/assets/50676787/f92494d7-6f6d-47df-8beb-804d3f96a87f)
  ![image](https://github.com/sasilvasilveira/TechChallenge/assets/50676787/c1d0cd13-cc86-4660-9b14-b1be07907095)
- On the right top of the screen must be the following options:\
  ![image](https://github.com/sasilvasilveira/TechChallenge/assets/50676787/3ea0b436-13ee-4dd5-9212-8c9bfb696311)
- On the first selectable "rectangle", select the option "APP";
- On the second selectable "rectangle", select the option with the previously created device name (probably it is "Pixel 4 API 34");
- Click on Run App (the green arrow);

## Future updates and features

&ensp;Currently, this project only contains the first and second screen.\
&ensp;However, the second screen does not dipslays anything.\
&ensp;In order to see the returned json from the given subreddit,\
run the project and go to the "Logcat" tab (located at the bottom of the android studio screen)\
and type "System.out" on it´s filter. It will look like this:\
![image](https://github.com/sasilvasilveira/TechChallenge/assets/50676787/f1a7d4ac-fa8b-4c2a-af63-808f55b57578)

