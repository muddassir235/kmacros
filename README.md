# kmacros
[![Release](https://jitpack.io/v/muddassir235/kmacros.svg?style=flat-square)](https://jitpack.io/#muddassir235/kmacros/)

Useful Kotlin functions/methods and extensions for Android which help you develop quicker. Add this library to your project to avoid writing boilerplate code and focus on what you want to develop. More methods and extensions coming soon.

Used in https://play.google.com/store/apps/details?id=com.muddassirkhan.quran_android

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
    implementation 'com.github.muddassir235:kmacros:1.12'
}
```

## Functions
#### Delay
Delay a block of code my a specified time in milliseconds.
```kotlin
delay(1000) {
    // Your block of code
}
```
#### Safe
Run a fault tolerant block of code safely, avoiding any exceptions.
```kotlin
safe {
    // Your block of code
}
```

## Resources
#### Screen Width and Screen Height
The device's width and Height in physical pixels.

```kotlin
layoutParams.width = screenWidth
layoutParams.height = screenHeight
```

## Context
#### Start Activity
Convenient way of starting an activity from within a context.
```kotlin
startActivity<YourActivity>() // starts YourActivity
startActivityNoAnimation<YourActivity>() // starts YourActivity without any animations.
```
#### Show a Toast
Show a toast from within a context for a short or a long duration.
```kotlin
toast("Hello World!")
toastLong("Hello World!!!!!!")
```
#### Save to SharedPreferences
Save any boolean, int, long, float, string, or any array of (boolean, int, long, float, string) or any data object in SharedPreferences from within a Context.
```kotlin
save("mykey", true)                             // Boolean
save("mykey", 1)                                // Int
save("mykey", 1L)                               // Long
save("mykey", 1.0f)                             // Float
save("mykey", "My String")                      // String
save("mykey", anyDataObject)                    // Data Object
save("mykey", arrayOf(true, false))         // Arrays of all primitive types are supported
.
.
.
save("mykey", Array<AnyDataObject>)            // Any data object array can be saved.
```
#### Load from SharedPreferences
Load any saved boolean, int, long, float, string, or array of (boolean, int, long, float, string) or any data object from SharedPreferences within a Context.
```kotlin
val value = load<Boolean>("mykey")
val value = load<Int>("mykey")
val value = load<Long>("mykey")
val value = load<Float>("mykey")
val value = load<String>("mykey")
val value = load<MyDataObject>("mykey")
val value = load<Array<String>>("mykey")                   
.
.
.
val value = load<Array<MyDataObject>>("mykey")
```
#### Delete from SharedPreferences
Load any saved boolean, int, long, float, string, or array of (boolean, int, long, float, string), any data object from SharedPreferences within a Context.
```kotlin
delete<Boolean>("mykey")
delete<Int>("mykey")
delete<Long>("mykey")
delete<Float>("mykey")
delete<String>("mykey")
delete<MyDataObject>("mykey")
delete<Array<String>>("mykey")                  
.
.
.
delete<Array<MyDataObject>>("mykey")
```
#### Safe Save, Load and Delete
Safe versions of the above save and load functions which avoid/ignore any exceptions.
```kotlin
safeSave("mykey", myObject) // Does nothing if it fails
safeLoad<MyObject>("mykey") // Returns null in case any exception occurs
safeDelete<MyObject>("mykey") // Does nothing if it fails
```
#### Data Object To Json Encoded String
Convert a Kotlin Data Object to a Json encoded string and vice-versa. This can be useful in certain situations (e.g. Saving objects to SharedPreferences if required, Sending data over the network e.t.c)
```kotlin
val jsonString = objectToString(dataObject)
val originalObject = stringToObject(jsonString)
```

#### Create Intent
Create an intent of an Activity from within a context.
```kotlin
val intent = createIntent<YourActivity>() // Intent of YourActivity.
```
#### Broadcast Action
Broadcast an action from within a context which can be received by a BroadcastReceiver (Optional bundle of extras can be provided which will be received in the form of an intent by the BroadcastReceiver.)
```kotlin
broadcastAction("stop_download")
broadcastAction("stop_download", bundleOfExtras) // Optinal bundle of extras 
```
#### Pending Intent With Action
Create a pending intent with the specified action from within a context.
```kotlin
pendingIntentWithAction("stop_audio")
```
#### Is Service Running
Check whether a service is running or not from within a context.
```kotlin
isServiceRunning(MyService::class.java) // returns true or false
```
#### Prefs
Get an instant handle to the default SharedPreferences from within a context.
```kotlin
this.prefs
```
## View
#### Mutable Width and Height
You don't have to get a reference to the layoutParams, adjust the width and height and reassign layout params, mutableWidth and mutableHeight will handle that for you.
```kotlin
myView.mutableWidth = 160.0f.px
myView.mutableHeight = 90.0f.px
```
#### Minimum Width and Minimum Height
 You don't have to set both `minimumWidth` and `minWidth` for acheiving your desired behaviour (Textview and its decendants (Button e.t.c) require both of these to be set in order to apply a minimum width to the view which leads to ugly code), simply use `minW`
```kotlin
myTextView.minW = 16.0.px
myTextView.minH = 9.0.px
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
Long number timestamp to time string (Supports upto Hours of granularity) HH:MM:SS
```kotlin
textview.text = 60000L.time // 01:00
```

#### Integer to Arabic Number String
Convert a Kotlin Integer to an arabic number String.
```kotlin
val arabic123 = 123.arabicNumber // ١٢٣
```

## Dialog
#### Set Nav Bar Color
Set the navigation bar color for when a dialog get displayed (Useful for top to bottom dialogs, BottomSheet Dialogs)
```kotlin
mydialog.setNavigationBarColor(Color.WHITE)
```

## Uses:
* https://github.com/muddassir235/eprefs

## [Apps by Muddassir Ahmed](https://play.google.com/store/apps/developer?id=Muddassir+Khan):

* https://play.google.com/store/apps/details?id=com.muddassirkhan.quran_android
* https://play.google.com/store/apps/details?id=com.app.kitaabattawheed

## Muddassir Ahmed Links:

* https://www.linkedin.com/in/muddassir35/
* https://muddassirahmed.medium.com/
* https://stackoverflow.com/users/5841416/muddassir-ahmed
