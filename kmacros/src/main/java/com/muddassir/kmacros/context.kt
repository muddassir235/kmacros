package com.muddassir.kmacros

import android.app.Activity
import android.app.ActivityManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import kotlin.reflect.KClass

/**
 * createIntent - Creates an intent for the specified activity <T>.
 *
 * @return Intent for the specified activity
 */
inline fun <reified T: Activity> Context.createIntent() =
    Intent(this, T::class.java)

/**
 * startActivity - Starts the specified activity <T>.
 */
inline fun <reified T: Activity> Activity.startActivity() {
    startActivity(createIntent<T>())
}

/**
 * startActivity - Starts the specified activity <T>. without any animations.
 */
inline fun <reified T: Activity> Activity.startActivityNoAnimation() {
    val intent = createIntent<T>()
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
}

/**
 * Context.broadcastAction: Broadcast action intent
 *
 * @param action action key
 */
fun Context.broadcastAction(action: String) {
    Intent().also { intent ->
        intent.action = action
        this.sendBroadcast(intent)
    }
}

/**
 * Context.broadcastAction: Broadcast action intent with extra data
 *
 * @param action action key
 * @param bundle Extra data
 */
fun Context.broadcastAction(action: String, bundle: Bundle) {
    Intent().also { intent ->
        intent.action = action
        intent.putExtras(bundle)
        this.sendBroadcast(intent)
    }
}

/**
 * pendingIntentWithAction - get a pending intent with the specified action.
 *
 * @param action  The action the intent will have.
 *
 * @return A Pending Intent with the specified action
 */
fun Context.pendingIntentWithAction(action: String): PendingIntent {
    val intent = Intent()
    intent.action = action
    return PendingIntent.getBroadcast(this, 100, intent, 0)
}


/**
 * isServiceRunning - Checks whether a service is running or not
 *
 * @param serviceClass: the Service to check
 *
 * @return Whether the service is running or not.
 */
fun Context.isServiceRunning(serviceClass: Class<*>): Boolean {
    val manager =
        this.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    for (service in manager.getRunningServices(Int.MAX_VALUE)) {
        if (serviceClass.name == service.service.className) {
            return true
        }
    }
    return false
}

/**
 * Get a reference to the default SharedPreferences
 */
val Context.prefs: SharedPreferences get() = this.getSharedPreferences(
    "preferences", Context.MODE_PRIVATE)

/**
 * Context.save - Save any serializable object in SharedPreferences
 *
 * @param key The key of the object to save
 * @param value the value of the object to save
 */
fun Context.save(key: String, value: Any) {
    prefs.save(key, value)
}

/**
 * Context.safeSave - Save any serializable object in SharedPreferences safely (avoids exceptions)
 *
 * @param key The key of the object to save
 * @param value the value of the object to save
 */
fun Context.safeSave(key: String, value: Any) {
    prefs.safeSave(key, value)
}

/**
 * Context.load - Load any serializable object in SharedPreferences
 *
 * @param key The key of the object to load
 * @param type The type of the object that is being loaded.
 */
fun <T: Any> Context.load(key: String, type: KClass<T>): T? {
    return prefs.load(key, type)
}

/**
 * Context.safeLoad - Load any serializable object in SharedPreferences safely (avoids exceptions)
 *
 * @param key The key of the object to load
 * @param type The type of the object that is being loaded.
 */
fun <T: Any> Context.safeLoad(key: String, type: KClass<T>): T? {
    return prefs.safeLoad(key, type)
}