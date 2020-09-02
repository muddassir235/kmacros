package com.muddassir.kmacros

import android.os.Handler

/**
 * safe - Run a block of code safely. Avoiding any exceptions.
 *
 * @param action The action to perform safely.
 */
inline fun safe(action: ((Unit) -> Unit)) {
    try { action.invoke(Unit) } catch (e: Exception) { /* don't care */ }
}

/**
 * delay - delay action lambda by the specified time
 *
 * @param millis: Delay in millis
 * @param task: The lambda to run
 */
inline fun delay(millis: Long, crossinline task: ((Unit) -> Unit)) {
    Handler().postDelayed({ task.invoke(Unit) }, millis)
}