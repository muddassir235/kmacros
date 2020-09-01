package com.muddassir.kmacros

import android.os.Handler

/**
 * safe - The action to perform.
 *
 * @param action The action to perform safely.
 */
fun safe(action: ((Unit) -> Unit)) {
    try { action.invoke(Unit) } catch (e: Exception) { /* don't care */ }
}

/**
 * delay - delay action lambda by the specified time
 *
 * @param millis: Delay in millis
 * @param task: The lambda to run
 */
internal fun delay(millis: Long, task: ((Unit) -> Unit)) {
    Handler().postDelayed({ task.invoke(Unit) }, millis)
}