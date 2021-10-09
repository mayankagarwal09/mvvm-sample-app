# mvvm-sample-app

## About
The App Loads list of items from a mock API and shows in a recyclerView using both LinearLayout and GridLayout.
It also has a bottom navigation bar and a toolbar with searchView. Supports Offline caching of data using Room and NetworkBoundResource.

## ScreenShots

<div>
<img src="assets/screenshots/Screenshot1.png" width="325" height="575" />
<img src="assets/screenshots/Screenshot2.png" width="325" height="575" />
<img src="assets/screenshots/Screenshot3.png" width="325" height="575" />
</div>

<div>
<img src="assets/screenshots/Screenshot4.gif" width="325" height="675" />
<img src="assets/screenshots/Screenshot5.gif" width="325" height="675" />
</div>


## APK

***You can Install and test app from below 👇***

[![APK](https://img.shields.io/badge/Apk-orange.svg?style=for-the-badge&logo=android)](assets/apks/debug.apk)

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- [Hilt-Dagger](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [DataBinding](https://developer.android.com/topic/libraries/data-binding) - Bind UI components in the layouts to data sources in the app using a declarative format rather than programmatically.
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Moshi](https://github.com/square/moshi) - A modern JSON library for Kotlin and Java.
- [Moshi Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/moshi) - A Converter which uses Moshi for serialization to and from JSON.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.

## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)
