# kmacros
[![Release](https://jitpack.io/v/muddassir235/kmacros.svg?style=flat-square)](https://jitpack.io/#muddassir235/kmacros/)

Useful Kotlin functions/methods and extensions for Android.

## Add Dependencies
Add the following in your project level build.gradle
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
and the following in your app level build.gradle
```groovy
dependencies {
    implementation 'com.github.muddassir235:kmacros:1.3'
}
```

## Functions
#### Delay
Delay a block of code my a specified time in milliseconds
```kotlin
delay(1000) {
    // Your block of code
}
```
#### Safe
Run a fault tolerant block of code safely, avoiding any exceptions
```kotlin
safe {
    // Your block of code
}
```
## Primitives
#### Display Pixels (dp) to Pixels (px)
Convert android display pixels to actual physical screen pixels
```kotlin
layoutParams.height = 20.0f.px
```

#### Pixels (px) to Display Pixels (dp)
Convert physical screen pixels to android display pixels
```kotlin
layoutParams.height = 100.dp
```

#### Long to Time String
Long number timestamp  to string (Support upto Hours of granularity) HH:MM:SS
```kotlin
textview.text = 60000L.time // 01:00
```

#### Integer to Arabic Number String
Convert kotlin Integer to arabic number String
```kotlin
val arabic123 = 123.arabicNumber // ١٢٣
```

#### Serializable Object To Base64 Encoded String ()
Convert a Kotlin Serializable Object to a Base64 encode string and vice-versa. This can be useful in certain situations (e.g. Saving objects to SharedPreferences if required, Sending data over the network e.t.c)
```kotlin
val base64Str = objectToString(serializableObject)
val originalObject = stringToObject(base64Str)
```
